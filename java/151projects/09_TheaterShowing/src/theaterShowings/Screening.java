package theaterShowings;

public class Screening {
    private String title;
    private String time;
    private String[][] seats;

    public Screening(String title, String time, int rows, int columns) {
        this.title = title;
        this.time = time;
        this.seats = new String[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                seats[i][j] = "O"; // "O" indicates an available seat
            }
        }
    }

    public void displaySeatingChart() {
        System.out.println(title + " - " + time);
        for (int i = 0; i < seats.length; i++) {
            System.out.print("row " + i + " - ");
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(seats[i][j]);
            }
            System.out.println();
        }
    }

    public boolean reserveSeat(int row, int column) {
        if (row < 0 || row >= seats.length || column < 0 || column >= seats[0].length) {
            return false; // Seat doesn't exist
        }
        if ("X".equals(seats[row][column])) {
            return false; // Seat is already taken
        }
        seats[row][column] = "X"; // "X" indicates a reserved seat
        return true;
    }}
