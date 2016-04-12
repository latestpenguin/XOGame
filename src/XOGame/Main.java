package XOGame;

import java.util.Scanner;
/**
 * Created by LPenguin on 04.04.2016.
 */
public class Main {
    public static void main(String[] args) {
        Field nPole = new Field();
        nPole.VivodPole();
        nPole.ObnovitPole();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Введите координаты:");
            int x,y;
            boolean znach;
            do{
                System.out.println("Строка:");
            x = sc.nextInt() - 1;
                System.out.println("Колонка:");
            y = sc.nextInt() - 1;
            znach = nPole.ProverkaHod(x, y);
            if(!znach){
                System.out.println("Введены не правильные координаты! Попробуйте еще раз:");
            }
            }while (!znach);
            nPole.HodUser(x, y);
            if (nPole.ProverkaVigrish()){
                break;
            }
            System.out.println("Ход ПК");
            nPole.HodPC();
            if (nPole.ProverkaVigrish()){
                break;
            }
        }
        if (nPole.player == 1) {
            System.out.println("Поздравляем! Вы победили!");
        }
            else if (nPole.player == 2) {
            System.out.println("Вы проиграли...");
        }

    }
}
