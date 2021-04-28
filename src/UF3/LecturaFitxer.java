package src.UF3;


import java.io.File;
import java.util.Scanner;

public class LecturaFitxer {
    int files;
    int columnes;
    int i;
    Taulell t = new Taulell();

    public String getLecturaFitxer() {
        System.out.println("a");
        float[][] llegirtaulell;
        try {
            File f = new File("res/taulells.txt");
            Scanner in = new Scanner(f);
            String[] espai = in.nextLine().split(" ");
            int filestext = Integer.parseInt(espai[0]);
            int columnestext = Integer.parseInt(espai[1]);
            t.setColumnes(columnestext);
            t.setFiles(filestext);
            llegirtaulell = new float[files][columnes];
            int i = 0;
            while (in.hasNextLine()) {
                for (int j = 0; j < files; i++) {
                    llegirtaulell[i][j] = Float.parseFloat(String.valueOf(espai[i]));
                    System.out.print(llegirtaulell[i][j]);
                }
                i++;
            }
            t.setTaulell(llegirtaulell);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    return null;
    }
}
