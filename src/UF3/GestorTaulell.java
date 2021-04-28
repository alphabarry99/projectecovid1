package src.UF3;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * Aquí es gestionarán les funcions del nostre taulell
 * @version 25/03/2021
 * @author Albert Buch i Alpha Omar Barry
 */
public class GestorTaulell {
    src.UF3.Taulell t = new Taulell();
    public static int malaltsTotals;
    public static int curatsTotals;

    Scanner in = new Scanner(System.in);

    /**
     * En aquesta funció utlitzarem dos funcions per poder
     * modificar les files i les columnes del taulell
     * @param t s'utilitza per poder cridar les funcions a la taula de taulell
     */
    public void carregarDades(Taulell t) {
        int files = in.nextInt();
        int columnes = in.nextInt();
        t.setFiles(files);
        t.setColumnes(columnes);
        t.createTaulellRand();
    }
//  Prova commit Alpha
    /**
     *Aquí cridarem la funció de createtaulellbuit
     *juntament amb funcions per mofificar les columnes i les files
     * @param t s'utilitza per poder cridar les funcions a la taula de taulell
     */
    public void carregarDadesBuit(Taulell t) {
        int files = in.nextInt();
        int columnes = in.nextInt();
        t.setFiles(files);
        t.setColumnes(columnes);
        t.createTaulellBuit();
    }

    public void guardarFichero(Taulell t) {
        int malaltsActuals=0;
        for (int i = 0; i < t.getFiles(); i++) {
            for (int j = 0; j < t.getColumnes(); j++) {
                if(t.getCasella(i,j)>0){
                    malaltsActuals+=t.getCasella(i,j);
                }
            }
        }
        try {
            Scanner reader = new Scanner(System.in);
            FileWriter guardar = new FileWriter("res/taulellguardat.txt",true);
            guardar.write("-------------------------------------" + "\n");
            guardar.write((LocalDateTime.now()) + "\n");
            guardar.write("-------------------------------------" + "\n");
            guardar.write("Malalts Actuals : " + malaltsActuals + "\n");
            guardar.write("Malalts Totals : " + malaltsTotals + "\n");
            guardar.write("Curats Totals : " + curatsTotals + "\n");
            for (int i = 0; i < t.getFiles(); i++) {
                for (int j = 0; j <t.getColumnes() ; j++) {
                    guardar.write(String.valueOf(t.getCasella(i,j)) + " ");
                }guardar.write("\n");
            }
            guardar.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     *Funció per introduir malalts escollints la casella i el numero de malalts
     * @param t
     */
    public void introduirMalalts(Taulell t) {
        System.out.println("Cuants malalts vols introduir");
        int malalts = in.nextInt();
        System.out.println("¿A quina fila?");
        int x = in.nextInt() - 1;
        System.out.println("¿A quina columna?");
        int y = in.nextInt() - 1;
        t.setCasella(x, y, (int) (t.getCasella(x, y)+malalts));
        malaltsTotals+=malalts;
    }

    /**
     *amb aquesta funció podrem elevar el numero de malalts
     * @param taulell
     */
    public void transmitirVirus(Taulell taulell){
        System.out.println("Introdueix la taxa de transmisió");
        Scanner in=new Scanner(System.in);
        float taxa=in.nextFloat();
        for (int i = 0; i <taulell.getFiles(); i++) {
            for (int j = 0; j < taulell.getColumnes(); j++) {
                taulell.getTaulell()[i][j] = (int)(taulell.getTaulell()[i][j]*taxa)+taulell.getTaulell()[i][j];
            }
        }
    }

    /**
     *Aquí podrem curar els malalts tant individualment com a globalment
     * agafant les caselles i  modficant-les
     * @param t
     */
    public void curarMalalts(Taulell t) {
        System.out.println("1-Curar malalts individualment");
        System.out.println("2-Curar malalts globalment");
        int opcio = in.nextInt();
        if (opcio == 1) {
            System.out.println("Dona'm la fila i la columna");
            int fila = (in.nextInt() - 1);
            int columna = (in.nextInt() - 1);
            System.out.println("Que vols curar, en percentatge(1) o en enter(2)");
            int opcio2 = in.nextInt();
            if (opcio2 == 1) {
                System.out.println("Quant malalts vols curar(1,0-100,0)");
                float malaltsCurarFloat = in.nextFloat();
                float numRestar = (t.getCasella(fila, columna) * malaltsCurarFloat) / 100;
                float num = t.getCasella(fila, columna);
                if (numRestar > t.getCasella(fila, columna)) {
                    curatsTotals+=t.getCasella(fila,columna);
                    t.setCasella(fila, columna, 0);

                } else {
                    t.setCasella(fila, columna, (int) (num - numRestar));
                    curatsTotals+=numRestar;
                }
            } else if (opcio2 == 2) {

                System.out.println("Quants malalts vols curar(1-100)");
                int malaltsCurar = in.nextInt();
                if (t.getCasella(fila, columna) > malaltsCurar) {
                    int numeromalalts = (int) t.getCasella(fila, columna);
                    t.setCasella(fila, columna, (numeromalalts - malaltsCurar));
                    curatsTotals+=malaltsCurar;
                } else {
                    curatsTotals += t.getCasella(fila, columna);
                    int numeromalalts = (int) t.getCasella(fila, columna);
                    t.setCasella(fila, columna, (numeromalalts = 0));
                }
            }
        } else if (opcio == 2) {
            System.out.println("Que vols curar en percentatge(1) o en enter(2) ");
            int opcio3 = in.nextInt();
            if (opcio3 == 1) {
                System.out.println("Quant malalts vols curar(1,0-100,0)");
                float malaltsCurarFloat = in.nextFloat();
                for (int i = 0; i < t.getFiles(); i++) {
                    for (int j = 0; j < t.getColumnes(); j++) {
                        float numRestar = (t.getCasella(i, j) * malaltsCurarFloat) / 100;
                        float num = t.getCasella(i, j);
                        t.setCasella(i, j, (int) (num - numRestar));
                        curatsTotals+=numRestar;
                        }
                }
            } else if (opcio3 == 2) {
                System.out.println("Quants malalts vols curar(1-100)");
                int malaltsCurar = in.nextInt();
                for (int i = 0; i < t.getFiles(); i++) {
                    for (int j = 0; j < t.getColumnes(); j++) {
                        if (t.getTaulell()[i][j] > malaltsCurar) {
                            t.getTaulell()[i][j] += -malaltsCurar;
                            curatsTotals+=malaltsCurar;
                        } else {
                            curatsTotals+=t.getCasella(i,j);
                            t.getTaulell()[i][j] = 0;

                        }
                    }
                }
            }
        }
    }
}
