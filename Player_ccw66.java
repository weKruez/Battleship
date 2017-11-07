public class Player_ccw66 implements Player{

	public String name;
    private char [] [] boardA1; //Player's place ship board
    private char [] [] boardA2; // Other Player's bomb board
    
    public Player_ccw66(){
        boardA1= new char [10][10]; // Player's ship board
        boardA2 = new char [10][10]; // Player's bomb board
            for(int i = 0; i < boardA1.length; i++){
            for(int j = 0; j < boardA1[i].length; j++){
                boardA1[i][j] = '~';
                boardA2[i][j] = '~';
    }
        }
    }
	
	
            public void placeShips(){
                System.out.println("Choose a row, followed by a column to place the top of the ship");
                System.out.println("Place ships: Aircraft Carrier 'A', 5 spaces, Battleship 'B', 4 spaces, Submarine 'S', 3 spaces, Destroyer 'D', 3 spaces, Patrol Boat, 'P', 2 spaces");
                int [] shipSize = {5,4,3,3,2};
                shipsize:for(int k = 0; k < shipSize.length; ++k){
                    printBoardShips();
                int rowTop = IO.readInt();
                while(rowTop < 0 || rowTop > 9){
                    IO.reportBadInput();
                    System.out.println("Enter a number between 0 and 9 corresponding to the row number on the board");
                    rowTop = IO.readInt();
                    
                }
                int columnTop = IO.readInt();
                while(columnTop < 0 || columnTop > 9){
                    IO.reportBadInput();
                    System.out.println("Enter a number between 0 and 9 corresponding to the column number on the board");
                    columnTop = IO.readInt();
                }
                System.out.println("Type 'h' for horizontal placement, or 'v' for vertical placement");
                String placement = IO.readString();
                while((!placement.equalsIgnoreCase("h")) && 
                      (!placement.equalsIgnoreCase("v"))){
                    IO.reportBadInput();
                    placement = IO.readString();
                }
                
                
                
                if(placement.equalsIgnoreCase("v")){  
                vertical:
                    for(int i = rowTop; i <= shipSize[k] + rowTop - 1; i++){
                        if(rowTop + shipSize[k] - 1 > 9){
                            System.out.println("The ship will not fit on the board! Please choose another position!");
                            i--;
                            k--;
                            continue shipsize;
                        }
                        if(boardA1[i][columnTop] == '~'){
                            if (shipSize[k] == 5){
                                boardA1[i][columnTop] = 'A';
                            }else if(shipSize[k] == 4){
                                boardA1[i][columnTop] = 'B';  
                            }else if(shipSize[k] == 3 && shipSize[k-1] == 3){
                                boardA1[i][columnTop] = 'D';
                            }else if(shipSize[k] == 3){
                                boardA1[i][columnTop] = 'S';
                            }else if(shipSize[k] == 2){
                                boardA1[i][columnTop] = 'P';
                            }
                        }else{
                            System.out.println("Can't place ship on another ship! Choose another position");
                            k--;
                            continue shipsize;
                        }
                        
                    }
                }else if(placement.equalsIgnoreCase("h")){
                    
                horizontal:
                    for(int j = columnTop; j <= shipSize[k] + columnTop - 1; ++j){
                        if(columnTop + shipSize[k] - 1 > 9){
                            System.out.println("The ship will not fit on the board! Please choose another position!");
                            j--;
                            k--;
                            continue shipsize;
                        }  
                        
                        
                        if(boardA1[rowTop][j] == '~' && boardA1[rowTop][columnTop + shipSize[k] - 1] == '~'){
                            if (shipSize[k]== 5){
                                boardA1[rowTop][j] = 'A';
                            }else if(shipSize[k] == 4){
                                boardA1[rowTop][j] = 'B';  
                            }else if((shipSize[k] == 3) && (shipSize[k-1] == 3)){
                                boardA1[rowTop][j] = 'D';
                            }else if(shipSize[k] == 3){
                                boardA1[rowTop][j] = 'S';
                            }else if(shipSize[k] == 2){
                                boardA1[rowTop][j] = 'P';
                            }
                        }else{
                            System.out.println("Can't place ship on another ship! Choose another position!");
                            k--;
                            
                            
                            
                            continue shipsize;
                        }
            
                    }
                    }
                    
    
            }
            }
                
            
           
            public void printBoard(){ //Print other player's bomb board
                System.out.print(" ");
                for(int j = 0; j < boardA2.length; j++){
                    
                    System.out.print(j);
                
            }
                System.out.println();
                for(int i = 0; i < boardA2.length; i++){
                    System.out.print(i);
                    System.out.println(boardA2[i]);
                    
                }
            }
                public void printBoardShips(){ 
                
                    System.out.print(" ");
                    for(int j = 0; j < boardA1.length; j++){
                        
                        System.out.print(j);
                    }
                        System.out.println();
                        for(int i = 0; i < boardA1.length; i++){
                            System.out.print(i);
                            System.out.println(boardA1[i]);
                            
                        }
                }
	
    public void setName(String n){
        this.name = n;
    }
    public String getName(){
        return this.name;
    }
    public void fireResult(char result){
        
        if(result == 'M')
            System.out.println("Missed!");
        else
            System.out.println("Hit!");
        
    }
    public boolean lost(){
        int count = 100;
        for(int i = 0; i < boardA2.length; i++){
            for(int j = 0; j < boardA2[i].length; j++){
                if(boardA2 [i][j] != '~' && boardA2[i][j] != 'M'){
                    count--;
                    
                    if(count == 83){
                        return true;
    }
                }
            }
        }
        return false;
    }
    public Coordinate fire(){

        Coordinate x = new Coordinate(IO.readInt(), IO.readInt());
        
        while(x.y < 0 || x.y > 9 || x.x < 0 || x.x > 9){
            System.out.println("Invalid coordinates! Guess again!");
        x = new Coordinate(IO.readInt(), IO.readInt());
            continue;
        }
        return x;
        
        
                

    
    }
    public char fireUpon(Coordinate x){
        while(boardA2[x.y][x.x] == boardA1[x.y][x.x] && boardA1[x.y][x.x] != '~' && boardA2[x.y][x.x] != '~'){
            System.out.println("Already hit there!");
            break;
        }
        if(boardA1[x.y][x.x] == '~'){
          boardA2[x.y][x.x] = 'M';
            return 'M';
        }else{
            boardA2[x.y][x.x] = boardA1[x.y][x.x];
            return boardA1[x.y][x.x];

    }
    }
    
}

