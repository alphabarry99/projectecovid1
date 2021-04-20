package src.UF3;

import java.util.Random;

/**
 * Es crearán les funcions del nostre taulell
 * @version 25/03/2021
 * @author Albert Buch i Alpha Omar Barry
 */
public class Taulell {

    private int files;
    private int columnes;
    private float[][] taulell;

    /**
     * Es per obtenir el taulell senser
     *
     * @return ens retornará el valor de la taula
     */
    public float[][] getTaulell() {
        return taulell;
    }

    /**
     * Podrem fer una modificacio a nivel de taula
     *
     * @param taulell
     */

    public void setTaulell(float[][] taulell) {
        this.taulell = taulell;
    }

    /**
     * Agafa les files per poder printar-les
     *
     * @return el valor de cada fila
     */
    public int getFiles() {
        return files;
    }

    /**
     * Aquí podrem modificar el valor de les files
     *
     * @param files les files
     */

    public void setFiles(int files) {
        this.files = files;
    }

    /**
     * Ens ajudará a visualitzar les columnes del taulell
     *
     * @return el valor de les columnes
     */
    public int getColumnes() {
        return columnes;
    }

    /**
     * Es per a modificar els valor de les columnes
     *
     * @param columnes les columnes
     */

    public void setColumnes(int columnes) {
        this.columnes = columnes;
    }

    /**
     * Per a obtenir les files i les columnes del taulell en format d'array
     *
     * @param i les files(x)
     * @param j les columnes(y)
     * @return el valor de les caselles
     */
    public float getCasella(int i, int j) {
        return taulell[i][j];
    }

    /**
     * Ens permetrará modificar les caselles
     *
     * @param i     files
     * @param j     columnes
     * @param value es per poder asignar un valor o un altre funció
     */

    public void setCasella(int i, int j, int value) {
        this.taulell[i][j] = value;
    }

    /**
     * Per poder crear el taulell random
     */

    public void createTaulellRand() {
        this.taulell = new float[files][columnes];
        Random r = new Random();
        for (int i = 0; i < files; i++) {
            for (int j = 0; j < columnes; j++) {
                taulell[i][j] = r.nextInt(10);
            }
        }
    }

    /**
     * Creació del taulell buit
     */

    public void createTaulellBuit() {
        this.taulell = new float[files][columnes];
        Random r = new Random();
        for (int i = 0; i < files; i++) {
            for (int j = 0; j < columnes; j++) {
                taulell[i][j] = 0;
            }
        }
    }
    public void createTaulellBuitTxT() {
        this.taulell = new float[files][columnes];

    }

    /**
     * Enns ajudará a poder printar bé el taulell
     *
     * @return value of toString
     */
    @Override
    public String toString() {
        StringBuilder cad = new StringBuilder();
        for (int i = 0; i < files; i++) {
            for (int j = 0; j < columnes; j++) {
                cad.append((int) taulell[i][j] + "\t");
            }
            cad.append("\n");
        }
        return cad.toString();
    }
}