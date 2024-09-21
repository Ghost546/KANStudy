package Java.Tasks;

//

public class Task8Queens {
    String[][] table = new String[8][8];
    final int requiredQueens = 8;
    int resultingQueensWithoutThreat = 8;
    boolean bumpedIntoFigure = false;
    int figuresPositionsCounter = 0;
    final int maxFiguresPositionsCounter = 77777777;
    int parsedCounter;
    int position;

    int optionCounter = 0;

    String[] arrayNumbersOfAnswers = new String[92];

    public void prepareTable() {
        for(int i = 0; i < table.length; i++) {
            for(int j=0; j < table[i].length; j++){
                table[i][j] = "0";
            }
        }
        figurePlacement();
    }

    public void searchSolution() {
        do{
            figureMove();
            checkTable();
            if (resultingQueensWithoutThreat==8) {
                optionCounter++;
                System.out.println("Вариант расположения фигур: " + optionCounter);
                System.out.println();
                showTable();
                figuresPositionsCounterShow();
                figuresCountWithoutThreat();
                figuresPositionsCounterAddToArray(optionCounter);
            }
            resultingQueensWithoutThreat=8;
        }while (figuresPositionsCounter!=maxFiguresPositionsCounter);

        System.out.println();

        for(int i = 0; i<optionCounter; i++) {
            System.out.println(arrayNumbersOfAnswers[i]);
        }

    }

    private void figureMove() {
        int j = 0;
        if (figuresPositionsCounter<=maxFiguresPositionsCounter) {
            figuresPositionsCounter++;
            parsedCounter = figuresPositionsCounter;
            do{
                position = parsedCounter%10;
                parsedCounter = parsedCounter/10;
                if(position>7) {
                    continue;
                }
                figureReplace(position, j);
                j++;
            } while (parsedCounter>0);
        }
    }

    private void figureReplace(int i, int j) {
        table[i][j] = "F";
        for(int k = 0; k < table.length; k++) {
            if (k!=i) {
                table[k][j] = "0";
            }
        }

    }

    //написать два метода сдвига и генерацией всех возможных перестановок
    //row - номер строки на доске
    //

    private void checkTable() {
        for(int i = 0; i < table.length; i++) {
            for(int j=0; j < table[i].length; j++){
                if(table[i][j].equals("F")) {
                    checkFiguresOnThreat(i,j);
                }
            }
        }
    }

    private void figuresCountWithoutThreat() {
        System.out.println("Кол-во фигур без угроз: " + resultingQueensWithoutThreat);
        System.out.println("_________________________________________________________________");
        System.out.println();
    }

    private void figuresPositionsCounterShow() {
        String figuresPositionsCounterString = String.valueOf(figuresPositionsCounter);
        figuresPositionsCounterString = new StringBuilder(figuresPositionsCounterString).reverse().toString();
        if (figuresPositionsCounterString.length()<8){
            figuresPositionsCounterString = figuresPositionsCounterString+"0";
        }
        System.out.println("Расположение фигур по одномерному массиву: " + figuresPositionsCounterString);
        System.out.println();
    }

    private void figuresPositionsCounterAddToArray(int optionCounter) {
        String figuresPositionsCounterString = String.valueOf(figuresPositionsCounter);
        figuresPositionsCounterString = new StringBuilder(figuresPositionsCounterString).reverse().toString();
        if (figuresPositionsCounterString.length()<8){
            figuresPositionsCounterString = figuresPositionsCounterString+"0";
        }
        arrayNumbersOfAnswers[optionCounter-1] = figuresPositionsCounterString;
    }

    private void figurePlacement() {
        for(int i = 0; i < table.length; i++) {
            addFigure(0, i);
        }
    }

    private void addFigure(int line, int column) {
        table[line][column] = "F";
    }

    private void checkFiguresOnThreat(int initialLine, int initialColumn) {
        checkRightHorizontalCells(initialLine, initialColumn);
        checkLeftHorizontalCells(initialLine, initialColumn);
        checkTopVerticalCells(initialLine, initialColumn);
        checkDownVerticalCells(initialLine, initialColumn);

        checkLeftTopDiagonalCells(initialLine, initialColumn);
        checkRightTopDiagonalCells(initialLine, initialColumn);
        checkLeftDownDiagonalCells(initialLine, initialColumn);
        checkRightDownDiagonalCells(initialLine, initialColumn);
        if (bumpedIntoFigure) {
            resultingQueensWithoutThreat--;
        }
        bumpedIntoFigure = false;
    }

    private void checkRightHorizontalCells(int initialLine, int initialColumn) {
        while (initialColumn < table.length-1) {
            initialColumn++;
            checkCell(initialLine, initialColumn);
        }
    }

    private void checkLeftHorizontalCells(int initialLine, int initialColumn) {
        while (initialColumn > 0) {
            initialColumn--;
            checkCell(initialLine, initialColumn);
        }
    }

    private void checkTopVerticalCells(int initialLine, int initialColumn) {
        while (initialLine > 0) {
            initialLine--;
            checkCell(initialLine, initialColumn);
        }
    }

    private void checkDownVerticalCells(int initialLine, int initialColumn) {
        while (initialLine < table.length-1) {
            initialLine++;
            checkCell(initialLine, initialColumn);
        }
    }

    private void checkLeftTopDiagonalCells(int initialLine, int initialColumn) {
        while (initialLine > 0 & initialColumn > 0) {
            initialLine--;
            initialColumn--;
            checkCell(initialLine, initialColumn);
        }
    }

    private void checkRightTopDiagonalCells(int initialLine, int initialColumn) {
        while (initialLine > 0 & initialColumn < table.length-1) {
            initialLine--;
            initialColumn++;
            checkCell(initialLine, initialColumn);
        }
    }

    private void checkLeftDownDiagonalCells(int initialLine, int initialColumn) {
        while (initialLine < table.length-1 & initialColumn > 0) {
            initialLine++;
            initialColumn--;
            checkCell(initialLine, initialColumn);
        }
    }

    private void checkRightDownDiagonalCells(int initialLine, int initialColumn) {
        while (initialLine < table.length-1 & initialColumn < table.length-1) {
            initialLine++;
            initialColumn++;
            checkCell(initialLine, initialColumn);
        }
    }

    public void checkCell(int line, int column) {
        if(table[line][column].equals("F")) {
            bumpedIntoFigure = true;
        }
    }

    public void showTable() {
        for(int i = 0; i < table.length; i++) {
            for(int j=0; j < table[i].length; j++){
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
