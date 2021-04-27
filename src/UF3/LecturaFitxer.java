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
            try {
                File f = new File("res/taulells.txt");
                Scanner in = new Scanner(f);

                while (in.hasNextLine()){
                    System.out.println(in.nextLine());
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

        return null;
    }
}
