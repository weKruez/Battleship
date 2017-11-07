//Final build for my University intro to CS class. Functional Battleship game. Uses 4 classes, player class, Human player class, AI player class, and coordinate class as specified. You may choose between player vs player or plavery vs a simple AI. In future version the AI will be enhanced.

public class Battleship{
    public static void main(String [] args){
        new Player_ccw66();
        new Player_ccw66();
        new AIPlayer_ccw66();
               System.out.println("Welcome to Battleship! Ready to play? Enter 'Yes' to play!");
        boolean confirm = IO.readBoolean();
        if (!confirm){
            return;
        }
        System.out.println("Enter '1' to play against a human...Enter '2' to play against computer");
        int play = IO.readInt();
        while(play != 1 && play != 2){
            System.out.println("Invalid choice...Please choose 1 for PvP, 2 for Player vs. Computer");
            play = IO.readInt();
            continue;
        }
            if(play == 1){
                System.out.println("What is Player 1's name?");
                Player p1 = new Player_ccw66();
                p1.setName(IO.readString());
                System.out.println("What is Player 2's name?");
                Player p2 = new Player_ccw66();
                p2.setName(IO.readString());
                System.out.println("The rules: Sink the opposing players ships! If you sink all the ships by the end of your turn, YOU WIN! You can attack in five turns. Ships: Aircraft Carrier 'A', 5 spaces, Battleship 'B', 4 spaces, Submarine 'S', 3 spaces, Destroyer 'D', 3 spaces, Patrol Boat, 'P', 2 spaces");
                System.out.println("Ready?");
                confirm = IO.readBoolean();
                if (!confirm){
                    System.out.println("Exit?");
                    confirm = IO.readBoolean();
                    if (confirm){
                        return;
                    }else{
                        ;
                        
                    }
                }
                System.out.println(p2.getName() + ", Please look away from the screen.");
                System.out.println("Is " + p2.getName() + " away from the screen?");
                confirm = IO.readBoolean();
                if (!confirm){
                    System.out.println("Exit?");
                    confirm = IO.readBoolean();
                    if (confirm){
                        return;
                    }
                }
            
                System.out.println("OK! Begin!");
                System.out.println( p1.getName() + ": Place Ships");

                p1.placeShips();
                p1.printBoardShips();
                
                for(int q = 0; q < 100; q++){
                    System.out.println(" ");
                }
                System.out.println("OK!, " + p1.getName() + ", Please look away from the screen");
                System.out.println("Is " + p1.getName() + " away from the screen?");
                confirm = IO.readBoolean();
                if (!confirm){
                    System.out.println("Exit?");
                    confirm = IO.readBoolean();
                    if (confirm){
                        return;
                    }
                }
                System.out.println("OK! Begin!");
                System.out.println(p2.getName() + ": Place Ships");
                p2.placeShips();
                p2.printBoardShips();
                for(int q = 0; q < 100; q++){
                    System.out.println(" ");
                }
            
                
            while((p1.lost() == false) && (p2.lost() == false)){
                System.out.println("OK, " + p1.getName() + ", Fire bombs to hit " + p2.getName() + "'s ships! Choose a row, then column to fire on!");
            player1:for(int i = 0; i <= 5 ; i++){
                if(p1.lost() == true || p2.lost() == true)
                    break;
                p2.printBoard();    
                
                
                
                
                Coordinate c = p1.fire();
                
                char result = p2.fireUpon(c);
                p1.fireResult(result);
                
            }
                if(p2.lost() != true){
                    System.out.println("OK, " + p2.getName() + ", Fire bombs to hit " + p1.getName() + "'s ships! Choose a row, then column to fire on!");
                }
            player2:for(int i = 0; i <= 5; i++){
                if(p1.lost() == true|| p2.lost() == true)
                    break;
                p1.printBoard();    
                
                
                
                
                
                Coordinate c = p2.fire();
                
                char result = p1.fireUpon(c);
                p2.fireResult(result);
                
            }
            }
                if(p2.lost() == true){
                    System.out.println(p1.getName() + " WINS!");
                }else if(p1.lost() == true){
                    System.out.println(p2.getName() + " WINS!");
                }
                
                
                
                
                
                
                System.out.println("Good Game!");
                System.out.println("Want to see the final boards?");
                confirm = IO.readBoolean();
                if(confirm){
                    System.out.println("Final Boards:");
                    System.out.println(p1.getName() + "'s Ships!");
                    p1.printBoardShips();
                    System.out.println(p2.getName() + "'s Bombs!");
                    p1.printBoard();
                    System.out.println(p2.getName() + "'s Ships!");
                    p2.printBoardShips();
                    System.out.println(p1.getName() + "'s Bombs!");
                    p2.printBoard();
                    System.out.println("Thanks for playing!");           
                    return;  
                }else{
                    System.out.println("Thanks for playing!");
                    return;
                }

            }
    
                
        
    
        //////////////////////////////Computer
            else if(play == 2){
                System.out.println("What is Player 1's name?");
                Player p1 = new Player_ccw66();
                p1.setName(IO.readString());
                Player p2 = new AIPlayer_ccw66();
                p2.setName("Computer");
        System.out.println("The rules: Sink the opposing players ships! If you sink all the ships by the end of your turn, YOU WIN! You can attack in five turns. Ships: Aircraft Carrier 'A', 5 spaces, Battleship 'B', 4 spaces, Submarine 'S', 3 spaces, Destroyer 'D', 3 spaces, Patrol Boat, 'P', 2 spaces");
        System.out.println("Ready?");
        confirm = IO.readBoolean();
        if (!confirm){
            System.out.println("Exit?");
            confirm = IO.readBoolean();
            if (confirm){
                return;
            }else{
                ;
                
            }
        }
                

                
                System.out.println("OK! Begin!");
                
                System.out.println( p1.getName() + ": Place Ships");
                
                p1.placeShips();
                p1.printBoardShips();
                
                p2.placeShips();
                
                
            while((p1.lost() == false) && (p2.lost() == false)){
                System.out.println("OK, " + p1.getName() + ", Fire bombs to hit " + p2.getName() + "'s ships! Choose a row, then column to fire on!");
            player1:for(int i = 0; i <= 5 ; i++){
                    if(p1.lost() == true || p2.lost() == true)
                    break;
                    p2.printBoard();   
                
                    Coordinate c = p1.fire();
                
                    char result = p2.fireUpon(c);
                    p1.fireResult(result);
                
                }
                
                if(p2.lost() != true){
                    System.out.println("OK, " + p2.getName() + ", Fire bombs to hit " + p1.getName() + "'s ships! Choose a row, then column to fire on!");
                    }
                player2:for(int i = 0; i <= 5; i++){
                if(p1.lost() == true|| p2.lost() == true)
                    break;
                p1.printBoard();
                
                
                    Coordinate c = p2.fire();
                    
                char result = p1.fireUpon(c);
                p2.fireResult(result);
                
                }
                }
                if(p2.lost() == true){
                    System.out.println(p1.getName() + " WINS!");
                }else if(p1.lost() == true){
                    System.out.println(p2.getName() + " WINS!");
                }
        
                System.out.println("Good Game!");
                System.out.println("Want to see the final boards?");
                confirm = IO.readBoolean();
                if(confirm) {
                    System.out.println("Final Boards:");
                    System.out.println(p1.getName() + "'s Ships!");
                    p1.printBoardShips();
                    System.out.println(p2.getName() + "'s Bombs!");
                    p1.printBoard();
                    System.out.println(p2.getName() + "'s Ships!");
                    p2.printBoardShips();
                    System.out.println(p1.getName() + "'s Bombs!");
                    p2.printBoard();
                    System.out.println("Thanks for playing!");           
                    return;  
                }else{
                    System.out.println("Thanks for playing!");
                    return;
                }
        
            }
    }
}

            
            
        





//This is an older version archived as comments within the main class. This code's function is now largely implemented by the additiomnal classes.

        
        /*System.out.println("What is Player1's name?");
        String name1 = IO.readString();
        System.out.println("What is Player2's name?");
        String name2 = IO.readString();
        char [] [] boardA1= new char [10][10]; // Player1's ship board
        char [] [] boardB1 = new char [10][10]; //Player1's bomb board
        char [] [] boardA2 = new char [10][10]; // Player2's ship board
        char [] [] boardB2 = new char [10][10]; // Player2's bomb board
        initBoard(boardA1);
        initBoard(boardB1);
        initBoard(boardA2);
        initBoard(boardB2);
        verify(boardB2);*/
     
       
       
  

        
        /*fire(boardA2, boardB1, IO.readInt(), IO.readInt());
            if(verify(boardB1)){
                
                System.out.println (name1 + " WINS!");
                break fireloop;
            }
        printBoard(boardB2);   
        System.out.println("OK, " + name2 + ", Fire bombs to hit " + name1 + "'s ships! Choose a row, then column to fire on!");
        
        fire(boardA1, boardB2, IO.readInt(), IO.readInt());
            if(verify(boardB2)){
                System.out.println(name2 + " WINS!");
                break fireloop;
        }
    }


        */    
            
        





     /*                   
                   
    public static void initBoard(char [] [] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                board[i][j] = '~';
        }
    }
}
    public static void printBoard(char[] [] board){
        System.out.print(" ");
        for(int j = 0; j < board.length; j++){
            
            System.out.print(j);
            
        }
        System.out.println();
        for(int i = 0; i < board.length; i++){
                    System.out.print(i);
                System.out.println(board[i]);
           
            }
                
        }
    public static void placeShips(char [] [] board){
        System.out.println("Choose a row, followed by a column to place the top of the ship");
        System.out.println("Place ships: Aircraft Carrier 'A', 5 spaces, Battleship 'B', 4 spaces, Submarine 'S', 3 spaces, Destroyer 'D', 3 spaces, Patrol Boat, 'P', 2 spaces");
        printBoard(board);
        int [] shipSize = {5,4,3,3,2};
    shipsize:for(int k = 0; k < shipSize.length; ++k){
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
                        if(board[i][columnTop] == '~'){
                            if (shipSize[k] == 5){
                            board[i][columnTop] = 'A';
                            }else if(shipSize[k] == 4){
                            board[i][columnTop] = 'B';  
                            }else if(shipSize[k] == 3 && shipSize[k-1] == 3){
                                board[i][columnTop] = 'D';
                            }else if(shipSize[k] == 3){
                                board[i][columnTop] = 'S';
                            }else if(shipSize[k] == 2){
                                board[i][columnTop] = 'P';
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
                          

                            if(board[rowTop][j] == '~' && board[rowTop][columnTop + shipSize[k] - 1] == '~'){
                            if (shipSize[k]== 5){
                            board[rowTop][j] = 'A';
                            }else if(shipSize[k] == 4){
                            board[rowTop][j] = 'B';  
                            }else if((shipSize[k] == 3) && (shipSize[k-1] == 3)){
                            board[rowTop][j] = 'D';
                            }else if(shipSize[k] == 3){
                            board[rowTop][j] = 'S';
                            }else if(shipSize[k] == 2){
                            board[rowTop][j] = 'P';
                            }
                        }else{
                            System.out.println("Can't place ship on another ship! Choose another position!");
                            k--;
                            

    
                            continue shipsize;
                        }
                    
                            
                       
                        
                    
                }
            
                  }
        
        printBoard(board);
    }
}
    

        

    
    public static void fire(char [][] boardA, char [] [] boardB, int y, int x){
        int countA = 0;
        int countB = 0;
        int countS = 0;
        int countD = 0;
        int countP = 0;
        boolean Bcount = false;
        boolean confirm = false;
        for(int q = 1; q <= 5; q++){
            
        if(x >= 0 && x <=9 && y >= 0 && y <=9){
             printBoard(boardB);
            if(boardA[y][x] == '~') {
                boardB[y][x] = 'M';
                printBoard(boardB);
                System.out.println("Miss!");
            }else if(boardB[y][x] == boardA[y][x]){
                System.out.println("Already hit there! Go again!");
                y = IO.readInt();
                x = IO.readInt();
                q--;
                continue;
            }else{
                boardB[y][x] = boardA[y][x];
                printBoard(boardB);
                System.out.println("Hit!");
                if(verify(boardB)){
                    break;
                }
                if(!Bcount){
                if(sankBattleship(boardB)){
                    System.out.println("You sank the other player's battleship!");
                    Bcount = true; 
                }
                }
                System.out.println("Gain a turn!");
                q--;
                y = IO.readInt();
                x = IO.readInt();
                continue;
                
            }
        }else{
            System.out.println("Invalid coordinates! Choose again!");
            y = IO.readInt();
            x = IO.readInt();
            q--;
            continue;
}
        
            //To be added in a later version:
            /*for(int i = 0; i < boardB.length; i++){
                for(int j = 0; j < boardB[i].length; j++){
                    if(boardB[i][j] == 'A'){
                        countA++;
                        if(countA == 5){
                            countA +=100;
                            confirm = true;
                        }else if(countA == 1){
                            countA--;
                        }else if(countA == 2){
                            countA-=2;
                        }else if(countA == 3){
                            countA -= 3;
                        }else if(countA == 4){
                            countA -= 4;
                        }
                    }
                    if(boardB[i][j] == 'B'){
                        countB++;
                        if(countB == 4){
                            countB +=100;
                            confirm = true;
                        }else if(countB == 1){
                            countB--;
                        }else if(countB == 2){
                            countB-=2;
                        }else if(countB == 3){
                            countB -= 3;
                        }
                    }
                    if(boardB[i][j] == 'S'){
                        countS++;
                        if(countS == 3){
                            countS+=100;
                            confirm = true;
                        }else if(countD == 1){
                            countS--;
                        }else if(countD == 2){
                            countS-=2;
                        }
                    }
                    if(boardB[i][j] == 'D'){
                        countD++;
                        if(countD == 3){
                            countD+=100;
                           confirm = true;
                        }else if(countD == 1){
                            countD--;
                        }else if(countD == 2){
                            countD-=2;
                        }
                    }
                    if(boardB[i][j] == 'P'){
                        countP++;
                        if(countP == 2){
                            countP+=100;
                            confirm = true;
                        }else if(countP == 1){
                            countP--;
                        }
                    }
                
            if(confirm){
                System.out.println("You sank a ship! Gain a turn!");
                q--;
                confirm = false;
                continue;
            }
                    
                }
            }
            if(q <= 4){
                y = IO.readInt();
                x = IO.readInt();
    }
    }
    }
    public static boolean verify(char [] [] boardB){
        int count = 100;
        for(int i = 0; i < boardB.length; i++){
            for(int j = 0; j < boardB[i].length; j++){
                if(boardB [i][j] != '~' && boardB[i][j] != 'M'){
                    count--;
                    
                    if(count == 83){
                        return true;
                    }
                }
        }
        }
     return false;

}
    //To be added in a later version:
    public static boolean isLoseTurn(char [] [] board){
        int countA = 0;
        int countB = 0;
        int countS = 0;
        int countD = 0;
        int countP = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 'A'){
                    countA++;
                    if(countA == 5){
                        countA ++;
                        return true;
                    }
                }
                    if(board[i][j] == 'B'){
                        countB++;
                        if(countB == 4){
                            countB ++;
                            return true;
                        }
                    }
                    if(board[i][j] == 'S'){
                        countS++;
                            if(countS == 3){
                                countS++;
                                return true;
                            }
                    }
                    if(board[i][j] == 'D'){
                        countD++;
                            if(countD == 3){
                                countD++;
                                return true;
                            }
                    }
                    if(board[i][j] == 'P'){
                        countP++;
                            if(countP == 2){
                                countP++;
                                return true;
                            }
                    }
                        
}
        }
        return false;
    }
        public static boolean sankBattleship(char [] [] board){
                 int countB = 0;
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[i].length; j++){
                    if(board[i][j] == 'B'){
                        countB++;
                        if(countB == 4){
                            return true;
                    
        }
    }
                }
            }
            return false;
        }
    }
*/ 
           
        




                 
                
            
                 
        
    
        
