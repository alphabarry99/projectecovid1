package src.UF3;

import com.sun.security.jgss.GSSUtil;

import java.io.File;
import java.util.Scanner;

public class LecturaFitxer {
    Taulell taulell = new Taulell();
    int files;
    int columnes;
    int i;
    src.UF3.Taulell t = new Taulell();

    public String getLecturaFitxer() {
        float[][] llegirtaulell = new float[0][0];
        try {
            File f = new File("res/taulells.txt");
            Scanner in = new Scanner(f);
            String espai = in.nextLine();
            String[] separador = espai.split(" ");
            files = Integer.parseInt(separador[0]);
            taulell.setFiles(files);
            columnes = Integer.parseInt(separador[1]);
            taulell.setColumnes(columnes);
            llegirtaulell = new float[files][columnes];
            espai = in.nextLine();
            separador = espai.split(" ");
            for (int i = 0; i < files; i++) {
                for (int j = 0; j < columnes; j++) {
                    llegirtaulell[i][j] = Float.parseFloat(String.valueOf(separador[j]));
                    System.out.print(llegirtaulell[i][j]);
                }
                espai = in.nextLine();
                separador = espai.split(" ");
            }

            taulell.setTaulell(llegirtaulell);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return toString();
    }
}
