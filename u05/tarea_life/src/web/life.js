const COL_CELL = "blue";
const COL_GRID = "#AAAAFF";

// ----------------------------------------------------------
// Definición de la "clase" LifeGame

function LifeGame() {
    
    // Inicializa las estructuras de datos
    this.init = function(rows, cols, ncells) {
        this.rows = rows;
        this.cols = cols;
        this.ncells = ncells;
        this.gen = 1;        
        
        this.data = this.create_matrix(rows, cols, 0);
        
        if(ncells<rows*cols)
            while(ncells-->0) {
                let r = Math.floor(Math.random()*rows);
                let c = Math.floor(Math.random()*cols);
                if (this.data[r][c] == 0) this.data[r][c] = 1;
                else ncells++;
            }
    }
    
    // Dibuja las celdas sobre el canvas
    this.redraw = function(canvas, grid, cell_color, grid_color) {
        let ctx = canvas.getContext("2d");

        ctx.clearRect(0, 0, canvas.width, canvas.height);

        ctx.fillStyle = cell_color;

        let cellw = canvas.width/this.cols;
        let cellh = canvas.height/this.rows;

        for(let i=0; i<this.rows; i++) 
            for(let j=0; j<this.cols; j++) 
                if(this.data[i][j] == 1) 
                    ctx.fillRect(j*cellw, i*cellh, cellw, cellh);

        if(grid) this.redraw_grid(canvas, cellw, cellh, grid_color);        
    }
    
    // Dibuja el grid
    this.redraw_grid = function(canvas, cellw, cellh, color) {
        let ctx = canvas.getContext("2d");

        ctx.strokeStyle = color;

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
    
    // Evoluciona la población
    this.evolve = function() {
        let next = this.create_matrix(this.rows, this.cols, 0);

        let ncells = 0;
        for(let r=0; r<this.rows; r++) 
            for(let c=0; c<this.cols; c++) {
                let alive = this.check_alive(r, c);
                next[r][c] = alive;
                if(alive) ncells++;
            }
        
        for(let r=0; r<this.rows; r++) 
            for(let c=0; c<this.cols; c++)
                this.data[r][c] = next[r][c];

        this.ncells = ncells;
        
        return ncells;        
    }
    
    // Chequea si una célula vive o muere
    this.check_alive = function(row, col) {
        let alive = this.data[row][col];

        // Obtiene el número de células vecinas vivas
        let aliveNeighbours = 0;
        let rowIni = (row>0)?(row-1):row;
        let rowEnd = (row<(this.rows-1))?(row+1):row;
        let colIni = (col>0)?(col-1):col;
        let colEnd = (col<(this.cols-1))?(col+1):col;
        for(let i=rowIni; i<=rowEnd; i++)
            for(let j=colIni; j<=colEnd; j++)
                if(i!=row || j!=col)
                    if(this.data[i][j] == 1) aliveNeighbours++;

        // Si hay una célula viva, 
        // y tiene dos o tres vecinas vivas sigue viva; si no, muere
        if(alive) { 
            alive = (aliveNeighbours==2 || aliveNeighbours==3)? 1: 0; 
        }
        // Si hay una célula muerta,
        // y tiene tres vecinas vivas, renace; si no, sigue muerta                
        else { 
            alive = (aliveNeighbours==3)? 1: 0; 
        }

        return alive;            
    }
    
    // Crea una matriz 2D
    this.create_matrix = function(rows, cols, value) {
        matrix = [];
        for(let r=0; r<rows; r++) {
            let ar = [];
            for(let c=0; c<cols; c++) ar[c] = 0;
            matrix[r] = ar;
        }
        
        return matrix;
    }
}

// ----------------------------------------------------------
// UI event handlers

function btnReset_onclick() {
    let rows = parseInt(txtRows.value);
    let cols = parseInt(txtCols.value);
    let ncells = parseInt(txtNCells.value);
    
    txtAlive.value = ncells;
    txtGen.value = 1;
    
    life.init(rows, cols, ncells);
    life.redraw(canvas, chkGrid.checked, COL_CELL, COL_GRID);
}

function btnGen_onclick() {
    let ncells = life.evolve();
    
    txtAlive.value = ncells;
    txtGen.value = parseInt(txtGen.value) + 1;
    
    life.redraw(canvas, chkGrid.checked, COL_CELL, COL_GRID);
}

function chkGrid_onclick() {
    life.redraw(canvas, chkGrid.checked, COL_CELL, COL_GRID);
}

// ----------------------------------------------------------
// UI Objects

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

// ----------------------------------------------------------

// Objeto principal
var life = new LifeGame();

btnReset_onclick();






