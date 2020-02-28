import java.util.Random;
import java.util.Scanner;

public class Letters {
    Scanner sc = new Scanner(System.in);
    Random r = new Random();

    char [][] board;
    int size;

    public int menu(){
        int option = 0;

        System.out.println("Select what do you want to do?");
        System.out.println("1. Random Start");
        System.out.println("2. Create cells");
        System.out.println("3. Exit");
        option = sc.nextInt();
        return option;
    }

    public void create_board(){
        System.out.println("Which is going to be the size of your board?");
        size = sc.nextInt();
        board = new char[size][size];
    }

    public void create_random_cells(){
        int number_cells;
        System.out.println("How many cells do you want to generate?");
        number_cells = sc.nextInt();
        for(int i=0;i<number_cells;i++){
            board[r.nextInt(size)][r.nextInt(size)] = 'O';
        }
    }

    public void create_cells(){
        int number_cells;
        System.out.println("How many cells do you want to create?");
        number_cells = sc.nextInt();
        for(int i=0;i<number_cells;i++){
            int raw = 0;
            int col = 0;
            print(board,size);
            System.out.println("Select the raw and col where you want to create the cell:");
            System.out.print("Raw: "); raw = sc.nextInt();
            System.out.print("Col: "); col = sc.nextInt();
            board[raw][col] = 1;
        }

    }

    public void print(char board[][], int size ){
        for(int i=0;i<size;i++){
            for(int w=0;w<size;w++){
                System.out.print(" " + board[i][w]);
            }
            System.out.println();
        }
    }

    public int number_times(){
        int number_gen;
        System.out.println("How many generations do you want to see?");
        number_gen = sc.nextInt();
        return number_gen;
    }

    public void check(){
        int count = 0;
        for(int i = 0;i<board.length;i++) {
            for(int w=0;w<board.length;w++) {
                count = 0;
                //Cas 1
                if (i+1<board.length) {
                    if (board[i+1][w]=='O') {
                        count += 1;
                    }
                    else {

                    }
                }
                //Cas 2
                if((i+1<board.length) & (w-1>=0)) {
                    if (board[i+1][w-1]=='O') {
                        count += 1;
                    }
                    else {

                    }
                }
                //Cas 3 i+1 w+1
                if((i+1<board.length) & (w+1<board.length)) {
                    if (board[i+1][w+1]=='O') {
                        count += 1;
                    }
                    else {

                    }
                }

                //Cas 4 i w+1
                if((w+1<board.length)) {
                    if (board[i][w+1]=='O') {
                        count += 1;
                    }
                    else {

                    }
                }

                //Cas 5 i w-1
                if((w-1>=0)) {
                    if (board[i][w-1]=='O') {
                        count += 1;
                    }
                    else {

                    }
                }
                //Cas 6 i-1 w
                if((i-1>=0)) {
                    if (board[i-1][w]=='O') {
                        count += 1;
                    }
                    else {

                    }
                }

                //Cas 7 i-1 w+1
                if((i-1>=0)&(w+1<board.length)) {
                    if (board[i-1][w+1]=='O') {
                        count += 1;
                    }
                    else {

                    }
                }

                //Cas 8 i-1 w-1
                if((i-1>=0)&(w-1>=0)) {
                    if (board[i-1][w-1]=='O') {
                        count += 1;
                    }
                    else {

                    }
                }

                //SUPERVIVÈNCIA

                //Sobreviu
                if(count==2 || count == 3) {
                    board[i][w] = 'O';
                }

                //Superpoblacio
                if (count>=4) {
                    board[i][w] = ' ';
                }
                //Soledat
                if (count<=1) {
                    board[i][w] = ' ';
                }
            }
        }
    }



    public void main() throws InterruptedException {
        int option;
        do{
            option = menu();
            switch(option){

                case 1:
                    int number_times;
                    create_board();
                    create_random_cells();
                    number_times = number_times();
                    for(int i=0;i<number_times + 1;i++){
                        Thread.sleep(1000);
                        System.out.println("______________________");
                        System.out.println("GENERATION " + i);
                        System.out.println("______________________");
                        print(board, size);
                        check();
                    }

                case 2:
                    create_board();
                    create_cells();
                    number_times = number_times();
                    for(int i=0;i<number_times + 1;i++){
                        System.out.println("______________________");
                        System.out.println("GENERATION " + i);
                        System.out.println("______________________");
                        print(board, size);
                        check();
                    }
            }
        }while(option!=3);
        System.out.println("See you soon!!");


    }

}
