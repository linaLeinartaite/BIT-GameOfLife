package gameoflifes;

/**
 *
 * @author Lina
 */
public class GameOfLifes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("..........");
        System.out.println("GAME OF LIFE");
        int size = 50;
        int cycles = 100;
        char[][] field = new char[size][size];
        char[][][] fieldsAll = new char[cycles + 1][size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                /*
            sugeneruosime atsitiktine lenta (kuri is ties nera atsitiktine)
            tuscias langelis bus zymimas tarkim nuliu 
            - uzimtas >> X'u;
                 */
                if (Math.random() < 0.25) {
                    field[i][j] = 'X';
                } else {
                    field[i][j] = '-';
                }
            }
        }
        //ispausdinam field arreju:
        System.out.println("RANDOM FIELD");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("................");
        //istatom pirmaji lauka i pozicia [0];
        fieldsAll[0] = field;

        //generuojam antraji areju pagal 'gyvenimo taisykles'; 
        for (int it = 0; it < cycles; it++) {
            System.out.println("FIELD NO:" + (it + 1));
            int count = 0;
            char[][] fieldNew = new char[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    int nbr = 0;

// skaiciuojam kaimynus (kiekvienm kaimynui po if'a :))
//esama eilute i; kaimynai: [i][j-1]; [i][j+1];
                    if (j - 1 >= 0 && field[i][j - 1] == 'X') {
                        nbr += 1;
                    }
                    if (j + 1 < size && field[i][j + 1] == 'X') {
                        nbr += 1;
                    }
                    // virsutine eilute: i-1; kaimynai: [i-1][j-1]; [i-1][j]; [i-1][j+1];
                    if (i - 1 >= 0 && j - 1 >= 0 && field[i - 1][j - 1] == 'X') {
                        nbr += 1;
                    }
                    if (i - 1 >= 0 && field[i - 1][j] == 'X') {
                        nbr += 1;
                    }
                    if (i - 1 >= 0 && j + 1 < size && field[i - 1][j + 1] == 'X') {
                        nbr += 1;
                    }
//apatine eilute: i+1; kaimynai: [i+1][j-1]; [i+1][j1]; [i+1][j+1];
                    if (j - 1 >= 0 && i + 1 < size && field[i + 1][j - 1] == 'X') {
                        nbr += 1;
                    }
                    if (i + 1 < size && field[i + 1][j] == 'X') {
                        nbr += 1;
                    }
                    if (i + 1 < size && j + 1 < size && field[i + 1][j + 1] == 'X') {
                        nbr += 1;
                    }

//uzpildom nauja areju gyventojais :
                    if (nbr == 3) {
                        fieldNew[i][j] = 'X';
                    } else if (nbr > 3 || nbr < 2) {
                        fieldNew[i][j] = '-';
                    } else {
                        fieldNew[i][j] = field[i][j];
                    }
//ir spausdinam nauja cikla:
                    System.out.print(fieldNew[i][j]);
                }
                //palyginam visus senus su nauju arejum:
                System.out.println("");

                for (int a = 0; a <= it; a++) {
                    for (int b = 0; b < size; b++) {
                        for (int c = 0; c < size; c++) {
                            if (fieldNew[b][c] != fieldsAll[a][b][c]) {
                                count = 0;
                                break;
                            } else if (count == size * size) {
                                break;
                            } else {
                                count++;
                            }
                        }
                        if (count == size * size) {
                            break;
                        }
                    }
                    if (count == size * size) {
                        System.out.println("THE " + (it + 1) + " ITERATION MATCHED ITERATION " + a + ".");
                        break;
                    }
                }
            }
            if (count != size * size) {
                count = 0;
                field = fieldNew;
                //i  surenkam visus arrejus:
                fieldsAll[it + 1] = fieldNew;

                System.out.println("");
                System.out.println("................");
                System.out.println("");
            } else {
                count = 0;
//                System.out.println("IS ITERACIJA KARTOJASI" + it + "ZINGSNYJE");               
                break;
            }
        }
        System.out.println("");
        System.out.println("******");

    }

}
