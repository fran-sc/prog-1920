package rimage;

class RadioImage {
    RadioImage(int[] data, int w, int h, boolean color) { }

    public void procesaImagen() {
        System.out.println("Procesando imagen...");
    }
}

public class RadioImageCheck extends RadioImage {
    private static final int ERR_T1 = 0;
    private static final int ERR_T2 = 1;
    private static final int ERR_T3 = 2;

    private static int[] err_cont = new int[3];
    private boolean error;

    RadioImageCheck(int[] data, int w, int h, boolean color) {
        super(data, w, h, color);
        
        boolean error;
        
        error = RadioImageCheck.checkErrorTipo1(data, w, h, color);

        if(!error)
            error = RadioImageCheck.checkErrorTipo2(data, w, h, color);
        
        if(!error)
            error = RadioImageCheck.checkErrorTipo3(data, w, h, color);

        this.error = error;
    }

    private static boolean checkErrorTipo1(int[] data, int w, int h, boolean color) {
        boolean error = false;

        int num_c = (color ? 3 : 1);
        if (data.length != w * h * num_c) {
            error = true;
            ++err_cont[ERR_T1];
        }
     
        return error;
    }

    private static boolean checkErrorTipo2(int[] data, int w, int h, boolean color) {
        boolean error = false;

        for (int p : data) {
            if (p < 0 || p > 255) {
                error = true;
                ++err_cont[ERR_T2];
                break;
            }
        }

        return error;
    }

    private static boolean checkErrorTipo3(int[] data, int w, int h, boolean color) {
        boolean error = false, diff;
        int ncol = color?3:1;
        int[] col = new int[ncol];

        // Check rows
        for(int i=0; i<h; i++) {
            // First color in current row
            for(int k=0; k<ncol; ++k) {
                col[k] = data[i*w*ncol + k];
            }

            // Compare with rest
            diff = false;
        chk_row:            
            for(int j=1; j<w; ++j) {
                for(int k=0; k<ncol; ++k) {
                    if(col[k] != data[i*w*ncol + j*ncol + k]) {
                        diff = true;
                        break chk_row;
                    }
                }
            }
            if(!diff) {
                error = true;
                break;
            }
        }

        if(!error) {
            // Check cols
            for (int j = 0; j < w; ++j) {
                // First color in current col
                for (int k = 0; k < ncol; ++k) {
                    col[k] = data[j*ncol + k];
                }

                // Compare with rest
                diff = false;
            chk_cols:            
                for (int i = 1; i < h; ++i) {
                    for (int k = 0; k < ncol; ++k) {
                        if (col[k] != data[i*w*ncol + j*ncol + k]) {
                            diff = true;
                            break chk_cols;
                        }
                    }
                }
                if (!diff) {
                    error = true;
                    break;
                }            
            }        
        }

        if(error) 
            ++err_cont[ERR_T3];

        return error;
    }

    public void procesaImagen() {
        if(!this.error)
            super.procesaImagen();
    }

    public static int getNumIncorrectas(int n) {
        return err_cont[n-1];
    }

    public static void main(String[] args) {
        int[] dat_bn = { 0, 255, 0, 255, 0, 255 };
        int[] dat_col = {   0, 0, 0, 255, 255, 255, 
                            0, 0, 0, 255, 0, 255, 
                            0, 1, 0, 255, 255, 255 };
        int[] dat_bn_err = { 0, -1, 0, 255, 255, 256 };
        int[] dat_col_err = { 0, 0, 0, 255, 256, 255, 0, 0, 0, 255, 255, 255, 0, 0, 0, 255, 255, 255 };
        

        RadioImageCheck img_col_ok = new RadioImageCheck(dat_col, 2, 3, true);
        RadioImageCheck img_bn_ok = new RadioImageCheck(dat_bn, 3, 2, false);

        img_col_ok.procesaImagen();
        img_bn_ok.procesaImagen();
        System.out.print(RadioImageCheck.getNumIncorrectas(1));
        System.out.print(RadioImageCheck.getNumIncorrectas(2));
        System.out.println(RadioImageCheck.getNumIncorrectas(3));
    }
}