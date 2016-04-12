package XOGame;

import java.util.Random;

/**
 * Created by LPenguin on 04.04.2016.
 */
public class Field {
    Cell[][] cells = new Cell[3][3];
    int player = 0;

    void VivodPole() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    void ObnovitPole() {
        for (Cell[] column : cells) {
            for (Cell cell : column) {
                if (cell.isShoot == 0)
                    System.out.print(cell.n);
                if (cell.isShoot == 1)
                    System.out.print(cell.x);
                if (cell.isShoot == 2)
                    System.out.print(cell.o);

            }
            System.out.println();
        }
    }
    void HodUser(int x, int y){
        cells[x][y].isShoot = 1;
        ObnovitPole();
}
    void HodPC(){
        Random random = new Random();
        while (true) {
            int x = random.nextInt(3);
            int y = random.nextInt(3);
            if (cells[x][y].isShoot == 0){
                cells[x][y].isShoot = 2;
                ObnovitPole();
                break;
            }
        }

    }
    boolean ProverkaVigrish(){

        if ((cells[0][0].isShoot == 1 && cells[0][1].isShoot == 1 && cells[0][2].isShoot == 1)
                || (cells[1][0].isShoot == 1 && cells[1][1].isShoot == 1 && cells[1][2].isShoot == 1)
                || (cells[2][0].isShoot == 1 && cells[2][1].isShoot == 1 && cells[2][2].isShoot == 1)

                || (cells[0][0].isShoot == 1 && cells[1][0].isShoot == 1 && cells[2][0].isShoot == 1)
                || (cells[0][1].isShoot == 1 && cells[1][1].isShoot == 1 && cells[2][1].isShoot == 1)
                || (cells[0][2].isShoot == 1 && cells[1][2].isShoot == 1 && cells[2][2].isShoot == 1)

                || (cells[0][0].isShoot == 1 && cells[1][1].isShoot == 1 && cells[2][2].isShoot == 1)
                || (cells[0][2].isShoot == 1 && cells[1][1].isShoot == 1 && cells[2][0].isShoot == 1)){

            player = 1;
            return true;
        }
        else if ((cells[0][0].isShoot == 2 && cells[0][1].isShoot == 2 && cells[0][2].isShoot == 2)
                || (cells[1][0].isShoot == 2 && cells[1][1].isShoot == 2 && cells[1][2].isShoot == 2)
                || (cells[2][0].isShoot == 2 && cells[2][1].isShoot == 1 && cells[2][2].isShoot == 2)

                || (cells[0][0].isShoot == 2 && cells[1][0].isShoot == 2 && cells[2][0].isShoot == 2)
                || (cells[0][1].isShoot == 2 && cells[1][1].isShoot == 2 && cells[2][1].isShoot == 2)
                || (cells[0][2].isShoot == 2 && cells[1][2].isShoot == 2 && cells[2][2].isShoot == 2)

                || (cells[0][0].isShoot == 2 && cells[1][1].isShoot == 2 && cells[2][2].isShoot == 2)
                || (cells[0][2].isShoot == 2 && cells[1][1].isShoot == 2 && cells[2][0].isShoot == 2)) {

            player = 2;
            return true;
        }

        else {
            return false;
        }

    }

    boolean ProverkaHod(int x, int y){
        if (cells[x][y].isShoot == 2){
            return false;
        }
        if (x >= 3 || x <= -1){
            return false;
        }
        else if (y >= 3 || y <= -1){
            return false;
        }
        else {
            return true;
        }
    }
}
