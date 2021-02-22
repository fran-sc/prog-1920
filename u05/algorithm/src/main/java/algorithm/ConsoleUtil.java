package algorithm;

public class ConsoleUtil {
    private static final int SYS_NIX = 1;
    private static final int SYS_WIN = 2;

    /* Identifica la plataforma. */
    public static int getSystem() {
        int sys = SYS_NIX; // valor por defecto (linux, Mac)

        String os = System.getProperty("os.name").toUpperCase();
        if (os.contains("WIN"))
            sys = SYS_WIN;

        return sys;
    }

    /* Limpia el terminal. */
    public static void cls(int sys) {
        switch (sys) {
            case SYS_NIX:
                System.out.print("\033[H\033[2J");
                break;
            case SYS_WIN:
                try {
                    // chapucilla windows
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
        }
    }
}
