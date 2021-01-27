package robbie;

import java.util.Scanner;

enum COM { MOVF, MOVB, ROTL, ROTR, PERF };

public class RobbieController1 {
    private static final int MAX_PROG_COMM = 10;

    private Robbie robot;
    private IComm[] commList;
    private int nextComm;

    public Robbie getRobot() { return this.robot; }
    public RobbieController1() { this.robot = new Robbie(); }

    public void executeProgram(String program) {
        String[] progLines = program.split("\n");
        String[] cmdParts;
        int i = 0;

        // Crear lista de comandos
        commList = new IComm[progLines.length];
        for(String progLine: progLines) {
            cmdParts = progLine.split(" ");
            switch(COM.valueOf(cmdParts[0])) {
                case MOVF:
                    commList[i++] = new CommMove(this.robot, Double.parseDouble(cmdParts[1]));
                    break;
                case MOVB:
                    commList[i++] = new CommMove(this.robot, (-1)*Double.parseDouble(cmdParts[1]));
                    break;
                case ROTL:
                    commList[i++] = new CommRot(this.robot, (-1)*Double.parseDouble(cmdParts[1]));
                    break;
                case ROTR:
                    commList[i++] = new CommRot(this.robot, Double.parseDouble(cmdParts[1]));
                    break;
                case PERF:
                    commList[i++] = new CommPerf();
                    break;
            }
        }

        // Ejecutar lista de comandos
        for(IComm cmd: commList)
            cmd.execute();
    }
    
}