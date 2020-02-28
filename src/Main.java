import java.util.Scanner;
import java.util.Random;

public class Main {

    /*
    This game is going to be executed in the main class which will contain a main menu which is going to give the user
    the following options:
        1. Random start(this option will just ask the user the size of the board and the number of cells he wants
        to create).

            This option is going to contain the following methods:
                - public void create_board(); This method is going to set the border size
                - public void random_cells(int number_of_cells); This method is going to generate random cells
                - public int number_times(); This method will give us the number of times we want to execute
                - public void print(int board[][], int size); This method is going to print the board
                - public void check(); This method is going to check the status of each cell

        2. Create cells (like last method this option is going to ask the user the size of the board and after that it
        will ask the user the number of cells and the position where he wants to create them).

            This option is going to contain the following methods:
                - public void create_board(); This method is going to set the border size
                - public  void create_cells (); This method is going to generate cells
                - public  int number_times(); This method will give us the number of times we want to execute
                - public  void print(int board[][], int size); This method is going to print the board
                - public  void check(); This method is going to check the status of each cell

        3. Exit the program (this option is going to exit the program).

     */

    Scanner sc = new Scanner(System.in);
    Random r = new Random();

    int [][] board;
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
        board = new int[size][size];
    }

    public void create_random_cells(){
        int number_cells;
        System.out.println("How many cells do you want to generate?");
        number_cells = sc.nextInt();
        for(int i=0;i<number_cells;i++){
            board[r.nextInt(size)][r.nextInt(size)] = 1;
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

    public void print(int board[][], int size ){
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
                    if (board[i+1][w]==1) {
                        count += 1;
                    }
                    else {

                    }
                }
                //Cas 2
                if((i+1<board.length) & (w-1>=0)) {
                    if (board[i+1][w-1]==1) {
                        count += 1;
                    }
                    else {

                    }
                }
                //Cas 3 i+1 w+1
                if((i+1<board.length) & (w+1<board.length)) {
                    if (board[i+1][w+1]==1) {
                        count += 1;
                    }
                    else {

                    }
                }

                //Cas 4 i w+1
                if((w+1<board.length)) {
                    if (board[i][w+1]==1) {
                        count += 1;
                    }
                    else {

                    }
                }

                //Cas 5 i w-1
                if((w-1>=0)) {
                    if (board[i][w-1]==1) {
                        count += 1;
                    }
                    else {

                    }
                }
                //Cas 6 i-1 w
                if((i-1>=0)) {
                    if (board[i-1][w]==1) {
                        count += 1;
                    }
                    else {

                    }
                }

                //Cas 7 i-1 w+1
                if((i-1>=0)&(w+1<board.length)) {
                    if (board[i-1][w+1]==1) {
                        count += 1;
                    }
                    else {

                    }
                }

                //Cas 8 i-1 w-1
                if((i-1>=0)&(w-1>=0)) {
                    if (board[i-1][w-1]==1) {
                        count += 1;
                    }
                    else {

                    }
                }

                //SUPERVIVÈNCIA

                //Sobreviu
                if(count==2 || count == 3) {
                    board[i][w] = 1;
                }

                //Superpoblacio
                if (count>=4) {
                    board[i][w] = 0;
                }
                //Soledat
                if (count<=1) {
                    board[i][w] = 0;
                }
            }
        }
    }



    public void main(){
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
