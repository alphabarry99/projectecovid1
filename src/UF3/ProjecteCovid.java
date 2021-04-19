
package src.UF3;

import java.util.Scanner;

/**
 * Aquí s'organitzan les funcions del nostre programa
 * @author Albert Buch i Alpha Omar Barry
 * @version 25/03/2021
 */
 //Prova Commit Albert
public class ProjecteCovid {


    public static void main(String[] args) {
        ProjecteCovid solucio = new ProjecteCovid();
        solucio.inici();
    }

    /**
     * Programa principal cridat des del main de la classe. Mostra el menú
     * per pantalla i segons la opció triada executa una o altre instrucció fins
     * que aquesta opció sigui la de sortir.
     */
    public void inici() {
        String[] menu = {
                "MENÚ",
                "1. XXX", "2. XXX", "3. XXX", "4. XXX", "0. Sortir"
        };
        int opcio = 0;
        int files = 0;
        int columnes = 0;
        src.UF3.GestorTaulell g = new src.UF3.GestorTaulell();
        src.UF3.Taulell t = new Taulell();

        //  float[][] taulell = new float[0][0];
        Scanner sc = new Scanner(System.in);
        do {
            Interficie.mostrarMenu(menu);
            opcio = Utils.validarEnter("Tria una opció", "Error");
            switch (opcio) {
                case 1:
                    System.out.println("¿Que el vols ple o buit?(ple=1/buit=2)");
                    int opcio2 = sc.nextInt();
                    switch (opcio2) {
                        case 1:
                            System.out.println("Dona'm les files i les columnes");
                            g.carregarDades(t);
                            System.out.println(t.getFiles());
                            System.out.println(t.getColumnes());
                            System.out.println(t.toString());
                            break;
                        case 2:
                            System.out.println("Dona'm les files i les columnes");
                            g.carregarDadesBuit(t);
                            System.out.println(t.getFiles());
                            System.out.println(t.getColumnes());
                            System.out.println(t.toString());
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
                case 0:

                    break;
            }
        } while (opcio != 0);
    }
}