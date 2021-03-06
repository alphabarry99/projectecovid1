package src.UF3;


public class Interficie {

    /**
     * Mostra la informació d'un array per pantalla de forma simple
     * @param dades Array d'string amb informació
     */
    public static void mostrarDades(String[] dades){

    }

    /**
     * Mostra per pantalla les diferents opcions que formen el menú
     * que es rep com a paràmetre. La primera posició de l'array menú és el
     * títol del mateix mentre que la resta són les opcions. Aquesta variable
     * ja ve inicialitzada des del codi que en fa la crida.
     * @param menu Conté les diferents opcions que es mostraran per pantalla a
     * l'usuari.
     */
    public static void mostrarMenu(String[] menu){
        System.out.println("1. Carregar taulell");
        System.out.println("2. Introduir malalts");
        System.out.println("3. Transmitir virus");
        System.out.println("4. Curar malalts");
        System.out.println("5. Consultar Dades API");
        System.out.println("6. Guardar les dades");
        System.out.println("0. Sortir");
    }

    /**
     * Mostra la informació per pantalla de forma simple
     * @param missatge Missatge a mostrar per pantalla
     */
    public static void mostrarMissatge(String missatge){

        System.out.println(missatge);
    }


    /**
     * Mostra la informació per pantalla en format capçalera
     * @param missatge Missatge a mostrar per pantalla en format capçalera
     */
    public static void mostrarCapçalera(String missatge){

        System.out.println("______________________________");
        System.out.println(missatge);
        System.out.println("______________________________");
    }

}
