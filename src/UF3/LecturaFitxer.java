package src.UF3;

import java.io.File;
import java.util.Scanner;

public class LecturaFitxer {
         Taulell taulell = new Taulell();
         int files;
    int columnes;
    int i;
    src.UF3.Taulell t = new Taulell();

    public void main(String[] args) {
        try {
            File f = new File("res/taulells.txt");
            Scanner in = new Scanner(f);
            String espai = in.nextLine();
            String[] separador = espai.split(" ");
            files = Integer.parseInt(separador[0]);
            taulell.setFiles(files);
            columnes = Integer.parseInt(separador[1]);
            taulell.setColumnes(columnes);
            float[][] llegirtaulell = new float[files][columnes];
            i = 0;
            while (in.hasNextLine()) {
                espai = in.nextLine();
                separador = espai.split(" ");
                for (int j = 0; j < columnes; j++) {
                    llegirtaulell[i][j] = Float.parseFloat(String.valueOf(separador[j]));
                }
                i++;
            }
            taulell.setTaulell(llegirtaulell);
            t.toString();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    }

