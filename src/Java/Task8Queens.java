package Java;


public class Task8Queens {
    String[][] table = new String[8][8];
    final int requiredQueens = 8;
    int resultingQueens = 8;
    boolean bumpedIntoFigure = false;

    public void prepareTable() {
        for(int i = 0; i < table.length; i++) {
            for(int j=0; j < table[i].length; j++){
                table[i][j] = "0";
            }
        }
    }

    public void searchSolution() {
        figurePlacement();
        do{
            checkTable();

            if (resultingQueens<8) {
                figureMove();
            }
        } while (resultingQueens!=requiredQueens);

        showTable();

        figuresCountWithoutThreat();
    }

    private void figureMove() {

    }

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
        System.out.println("Кол-во фигур без угрозы: " + resultingQueens);
        System.out.println();
    }

    private void figurePlacement() {
        for(int i = 0; i < table.length; i++) {
            addFigure(i, 0);
        }
    }



    private void refreshTable() {
        for(int i = 0; i < table.length; i++) {
            for(int j=0; j < table[i].length; j++){
                table[i][j]="0";
            }
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
            resultingQueens--;
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
