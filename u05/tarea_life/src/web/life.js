function init_data(rows, cols, ncells) {
    data = []
    for(let r=0; r<rows; r++) {
        let ar = [];
        for(let c=0; c<cols; c++) ar[c] = 0;
        data[r] = ar;
    }
    
    if(ncells<rows*cols)
        while(ncells-->0) {
            let r = Math.floor(Math.random()*rows);
            let c = Math.floor(Math.random()*cols);
            if (data[r][c] == 0) data[r][c] = 1;
            else ncells++;
        }
}

function draw_data() {
    let ctx = canvas.getContext("2d");

    ctx.clearRect(0, 0, canvas.width, canvas.height);
    
    ctx.fillStyle = "blue";
    
    let cellw = canvas.width/data[0].length;
    let cellh = canvas.height/data.length;
    
    for(let i=0; i<data.length; i++) 
        for(let j=0; j<data[i].length; j++) 
            if(data[i][j] == 1) 
                ctx.fillRect(j*cellw, i*cellh, cellw, cellh);
 
    if(chkGrid.checked) draw_grid(cellw, cellh);
}

function draw_grid(cellw, cellh) {
    let ctx = canvas.getContext("2d");
    
    ctx.strokeStyle = "#aaaaff"
    
    for(let x=0; x<canvas.width; x+=cellw) {
        ctx.beginPath();
        ctx.moveTo(x,0);
        ctx.lineTo(x,canvas.height);
        ctx.stroke();
    }
    
    for(let y=0; y<canvas.height; y+=cellh) {
        ctx.beginPath();    
        ctx.moveTo(0,y);
        ctx.lineTo(canvas.width,y);
        ctx.stroke();
    }    
}

function evolve() {
    let rows = parseInt(txtRows.value);
    let cols = parseInt(txtCols.value);
    
    next = []
    for(let r=0; r<rows; r++) {
        let ar = [];
        for(let c=0; c<cols; c++) ar[c] = 0;
        next[r] = ar;
    }
    
    let ncells = 0;
    for(let r=0; r<rows; r++) 
        for(let c=0; c<cols; c++) {
            let alive = checkAlive(r, c, rows, cols);
            next[r][c] = alive;
            if(alive) ncells++;
        }
    for(let r=0; r<rows; r++) 
        for(let c=0; c<cols; c++)
            data[r][c] = next[r][c];
    
    return ncells;
}

function checkAlive(row, col, rows, cols) {
    let alive = data[row][col];
    
    // Obtiene el número de células vecinas vivas
    let aliveNeighbours = 0;
    let rowIni = (row>0)?(row-1):row;
    let rowEnd = (row<(rows-1))?(row+1):row;
    let colIni = (col>0)?(col-1):col;
    let colEnd = (col<(cols-1))?(col+1):col;
    for(let i=rowIni; i<=rowEnd; i++)
        for(let j=colIni; j<=colEnd; j++)
            if(i!=row || j!=col)
                if(data[i][j] == 1) aliveNeighbours++;

    if(alive) {
    // Si hay una célula viva y tiene dos o tres vecinas vivas sigue viva; si no, muere
        alive = (aliveNeighbours==2 || aliveNeighbours==3)?1:0;
    }
    else {
    // Si no hay una célula viva en la celda y tiene tres vecinas vivas, renace; si no, sigue muerta
        alive = (aliveNeighbours==3)?1:0;
    }
    
    return alive;    
}

function btnReset_onclick() {
    let rows = parseInt(txtRows.value);
    let cols = parseInt(txtCols.value);
    let ncells = parseInt(txtNCells.value);
    
    txtAlive.value = ncells;
    txtGen.value = 1;
    
    init_data(rows, cols, ncells);

    draw_data();
}

function btnGen_onclick() {
    let ncells = evolve();
    
    txtAlive.value = ncells;
    txtGen.value = parseInt(txtGen.value) + 1;
    
    draw_data();    
}

function chkGrid_onclick() {
    draw_data();
}

var data = [];

var canvas = document.getElementById("canvas")

var txtRows = document.getElementById("txtRows");
var txtCols = document.getElementById("txtCols");
var txtNCells = document.getElementById("txtNCells");
var txtGen = document.getElementById("txtGen");

var chkGrid = document.getElementById("chkGrid");
chkGrid.onclick = chkGrid_onclick;

var btnReset = document.getElementById("btnReset");
btnReset.onclick = btnReset_onclick;

var btnGen = document.getElementById("btnGen");
btnGen.onclick = btnGen_onclick;

btnReset_onclick();

