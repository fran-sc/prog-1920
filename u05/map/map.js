// "Clase" Map
function Mapa() {
    this.init = function(size) {
        // Tipos de celdas
        this.CEL_TYPE = {
            FREE:       0,
            WATER:      1,
            PATH:       23,
            EXPLORED:   69,
            START:      99,
            END:        100
        };
    
        this.CEL_ATTR = {
            0:      {color: "ForestGreen"},
            1:      {color: "Blue"},
            23:     {color: "Gainsboro"},
            69:     {color: "PaleGreen"},
            99:     {color: "Yellow"},
            100:    {color: "Red"}
        };               
        
        this.COL_GRID = "GhostWhite";
        
        this.size = size;
        this.data = this.create_matrix(size, size, this.CEL_TYPE.FREE);
        
        this.init_cell = [0, 0];
        this.data[0][0] = this.CEL_TYPE.START;
        this.end_cell = [this.size-1, this.size-1];
        this.data[this.size-1][this.size-1] = this.CEL_TYPE.END;
    }
    
    // Dibuja las celdas sobre el canvas
    this.redraw = function(canvas) {
        let ctx = canvas.getContext("2d");

        ctx.clearRect(0, 0, canvas.width, canvas.height);

        let cell_size = canvas.width/this.size;

        for(let i=0; i<this.size; i++) 
            for(let j=0; j<this.size; j++) {
                ctx.fillStyle = this.CEL_ATTR[this.data[i][j]].color;
                ctx.fillRect(j*cell_size, i*cell_size, cell_size, cell_size);
            }

        this.redraw_grid(canvas, cell_size, cell_size, this.COL_GRID);        
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
    
    // Cambia el tipo de una celda
    this.set_cellType = function(canvas, x, y, celltype) {
        let cell_size = canvas.width/this.size;
        let c = Math.floor(x/cell_size);
        let r = Math.floor(y/cell_size);
        
        let value = this.CEL_TYPE[celltype];
        this.data[r][c] = value;
        
        if(value == this.CEL_TYPE.START) {
            this.data[this.init_cell[0]][this.init_cell[1]] = this.CEL_TYPE.FREE;
            this.init_cell = [r, c];
        }
        else if(value == this.CEL_TYPE.END) {
            this.data[this.end_cell[0]][this.end_cell[1]] = this.CEL_TYPE.FREE;
            this.end_cell = [r, c];            
        }
    }
}


// ----------------------------------------------------------
// UI event handlers

function btnReset_onclick() {
    let size = parseInt(txtSize.value);
    
    map.init(size);
    map.redraw(canvas);
}

function canvas_onclick(event) {
    let x = event.offsetX;
    let y = event.offsetY;
    
    map.set_cellType(canvas, x, y, selType.value);
    map.redraw(canvas);
}

function canvas_onmousedown(event) {
    mousedown = true;
}

function canvas_onmouseup(event) {
    mousedown = false;
}

function canvas_onmousemove(event) {
    if(mousedown) {
        let value = selType.value;
        if(value!="START" && value!="END") { 
            let x = event.offsetX;
            let y = event.offsetY;

            map.set_cellType(canvas, x, y, value);
            map.redraw(canvas);        
        }
    }
}

// ----------------------------------------------------------
// UI Objects

var canvas = document.getElementById("canvas")
canvas.onclick = canvas_onclick;
canvas.onmousedown = canvas_onmousedown;
canvas.onmouseup = canvas_onmouseup;
canvas.onmousemove = canvas_onmousemove;

var txtSize = document.getElementById("txtSize");
var selType = document.getElementById("selType");

var btnReset = document.getElementById("btnReset");
btnReset.onclick = btnReset_onclick;

// ----------------------------------------------------------

// Objeto principal
var map = new Mapa();

var mousedown = false;

btnReset_onclick();






