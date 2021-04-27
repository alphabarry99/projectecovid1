package src.UF2;

import java.util.Scanner;

/**
 * Aquí es gestionarán les funcions del nostre taulell
 * @version 25/03/2021
 * @author Albert Buch i Alpha Omar Barry
 */
public class GestorTaulell {

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
        t.setCasella(x, y, malalts);

    }

    /**
     *amb aquesta funció podrem elevar el numero de malalts
     * @param taulell
     */
    public void transmitirVirus(Taulell taulell){
        System.out.println("Introdueix la taxa de transmisió");
        Scanner in=new Scanner(System.in);
        float taxa=in.nextFloat();
        taulell.transmitirVirus(taxa);
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
                t.setCasella(fila, columna, (int) (num - numRestar));
            } else if (opcio2 == 2) {

                System.out.println("Quants malalts vols curar(1-100)");
                int malaltsCurar = in.nextInt();
                if (t.getCasella(fila, columna) > malaltsCurar) {
                    int numeromalalts = (int) t.getCasella(fila, columna);
                    t.setCasella(fila, columna, (numeromalalts - malaltsCurar));

                } else {
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
                        }
                    }
            } else if (opcio3 == 2) {
                System.out.println("Quants malalts vols curar(1-100)");
                int malaltsCurar = in.nextInt();
                for (int i = 0; i < t.getFiles(); i++) {
                    for (int j = 0; j < t.getColumnes(); j++) {
                        if (t.getTaulell()[i][j] > malaltsCurar) {
                            t.getTaulell()[i][j] -= malaltsCurar;

                        } else {
                            t.getTaulell()[i][j] = 0;
                        }
                    }
                }
            }
        }
    }
}
