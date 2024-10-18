package portfolio_comickeeper;

/*
 Create the ComicBook object
 --- this uses encapsulation and data protection by utilizing 'Getters and Setters'
     ** also by creating separate classes for different code it helps to keep code clean and modular
     (Portfolio Check-in 1 Ch04 - Display an understanding of the benefits of Encapsulation)
*/

class ComicBook {
    private String title;                          // each book needs a title
    private int vol;                               // each book has a volume
    private int num;                               // each book has a number
    private String grade;                          // each book has a grade

    // Constructor
    public ComicBook(String title, int vol, int num, String grade) {
        this.title = title;
        this.vol = vol;
        this.num = num;
        this.grade = grade;
    }

    // Getters and Setters

    // title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // vol
    public int getVol() {
        return vol;
    }

    public void setVol(int vol) {
        this.vol = vol;
    }

    // num
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    // grade
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    // Display comic book details
    public void displayDetails() {
        System.out.println("Comic Book Details:");
        System.out.println("Title: " + title);
        System.out.println("Volume: " + vol);
        System.out.println("Issue Number: " + num);

        // Switch statement based on user input grade
        switch (ComicGrade.valueOf(grade)) {
            case FAIR:
                System.out.println("This is a 'Reader' copy; there are plenty of higher grade editions around.");
                break;
            case VG:
                System.out.println("This is a great place holder book; keep a look out for Very Fine or Mint copies.");
                break;
            case VF:
                System.out.println("Pretty nice book, keep your eyes open for a Mint copy.");
                break;
            case MINT:
                System.out.println("Nice Mint copy; keep up the search for additional high grade copies at a good price.");
                break;
            default:
                System.out.println("Invalid grade entered.");
        }
    }
}