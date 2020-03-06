# GameOfLife
# GameOfLife
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
