
package src.UF3;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * Aquí s'organitzan les funcions del nostre programa
 * @author Albert Buch i Alpha Omar Barry
 * @version 25/03/2021
 */
 //Prova Commit Albert
public class ProjecteCovid {


    public static void main(String[] args) throws IOException, ParseException {
        ProjecteCovid solucio = new ProjecteCovid();
        solucio.inici();
    }

    /**
     * Programa principal cridat des del main de la classe. Mostra el menú
     * per pantalla i segons la opció triada executa una o altre instrucció fins
     * que aquesta opció sigui la de sortir.
     */
    public void inici() throws IOException, ParseException {
        String[] menu = {
                "MENÚ",
                "1. XXX", "2. XXX", "3. XXX", "4. XXX","5. XXX", "0. Sortir"
        };
        int opcio = 0;
        int files = 0;
        int columnes = 0;
        src.UF3.GestorTaulell g = new src.UF3.GestorTaulell();
        src.UF3.Taulell t = new Taulell();
        src.UF3.DadesAPI d = new DadesAPI();

        //  float[][] taulell = new float[0][0];
        Scanner sc = new Scanner(System.in);
        do {
            Interficie.mostrarMenu(menu);
            opcio = Utils.validarEnter("Tria una opció", "Error");
            switch (opcio) {
                case 1:
                    try {
                        File f = new File("res/taulells.txt");
                        Scanner in = new Scanner(f);

                        while (in.hasNextLine()){
                            System.out.println(in.nextLine());
                        }
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    g.introduirMalalts(t);
                    System.out.println(t.getFiles());
                    System.out.println(t.getColumnes());
                    System.out.println(t.toString());
                    break;
                case 3:
                    g.transmitirVirus(t);
                    System.out.println(t.getFiles());
                    System.out.println(t.getColumnes());
                    System.out.println(t.toString());
                    break;
                case 4:
                    g.curarMalalts(t);
                    System.out.println(t.getFiles());
                    System.out.println(t.getColumnes());
                    System.out.println(t.toString());
                    break;
                case 5:
                    d.dadesCatalunya();
                    System.out.println("¿Que vols fer amb les dades del Covid?");
                    System.out.println("1-Consultar dades de Catalunya");
                    System.out.println("2-Consultar dades de Girona");
                    System.out.println("3-Consultar dades de qualsevol país");
                    System.out.println("4-Consultar dades de qualsevol país en un interval concret ");
                    int opciodades = sc.nextInt();
                    switch (opciodades){
                        case 1: d.dadesCatalunya();
                            break;
                        case 2: d.dadesGirona();
                            break;
                        case 3: d.dadesMundials();
                            break;
                        case 4: d.dadesMundialsInterval();
                    }
                    break;
                case 0:

                    break;
            }
        } while (opcio != 0);
    }
}