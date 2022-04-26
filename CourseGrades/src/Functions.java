import java.util.InputMismatchException;
import java.util.Scanner;

public class Functions {

    Box g = new Box();
    GradeBook grbook = new GradeBook();
    Scanner sc = new Scanner(System.in);

    public void putGrades() {

        try {
            for (int x = 0; x < 12; x++) {
                g.clearConsole();
                float average = 0;
                
                g.printBox("Grades of Student [" + (x + 1) + "]");
                System.out.print("Enter a NAME for Student [" + (x+1) + "]: ");
                String studname = sc.next();
                grbook.setStudName(studname, x);

                for (int y = 0; y < 5; y++) {

                    try {
                        System.out.print(grbook.getnames(y) + " \t");
                        int input = sc.nextInt();
                        if (input < 0){
                            System.out.println("Grades cannot be negative!");
                            y--;
                            g.enterToContinue();
                            g.printBox("Grades of Student [" + (x + 1) + "]");
                        }
                        else {
                            grbook.setGrades(input, x, y);
                            average += input;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("YOU Must Enter a Number!");
                        sc.nextLine();
                        y--;
                        g.enterToContinue();
                        g.printBox("Grades of Student [" + (x + 1) + "]");
                    }
                }
                grbook.setAve(average / 5, x);

            }
        } catch (InputMismatchException e) {
            System.out.println("INVALID GRADE INPUT! ");
        }

        System.out.println("\nData Successfully Inserted!");
        g.enterToContinue();
    }

    public void spefgrade() {
        System.out.print("There are 12 Total Students \nChoose [1 - 12]: ");
        int choice = sc.nextInt();

        g.clearConsole();
        for (int x = 0; x < 12; x++) { // ITERATION OF CHOICES
            if ((choice - 1) == x) {
                g.printBox(grbook.getStudName(x) + "'s GRADES");
                for (int a = 0; a < 5; a++) {
                    System.out.println(grbook.getnames(a) + " \t" + grbook.getGrades(x, a));
                }
            }
        }
        g.enterToContinue();
    }

    public void spefave() {
        System.out.print("There are 12 Total Students \nChoose [1 - 12]: ");
        int choice = sc.nextInt();

        g.clearConsole();
        for (int x = 0; x < 12; x++) { // ITERATION OF CHOICES
            if ((choice - 1) == x) {
                g.printBox(grbook.getStudName(x) + "'s AVERAGE");
                System.out.printf("AVERAGE: \t %.2f", grbook.getAve(x));
            }
        }
        g.enterToContinue();
    }

    public void allgrade() {
        g.clearConsole();
        g.printBox("ALL GRADES OF STUDENTS");
        String titleName = String.format("%-25s", "NAMES");
        String allgrade = "";

        for (int y = 0; y < 5; y++) {
            titleName += grbook.getnames(y) + "\t";
        }

        for (int x = 0; x < 12; x++) {
            
            allgrade += String.format("%-25s", grbook.getStudName(x));

            for (int y = 0; y < 5; y++) {
                allgrade += grbook.getGrades(x, y) + "\t\t";
            }
            allgrade += "\n";

        }

        System.out.print(titleName + "\n" + allgrade);
    }

    public void allave() {
        g.clearConsole();
        g.printBox("ALL AVERAGE OF STUDENTS");
        String titleName = String.format("%-25s", "NAMES");
        String studNo = "";

        for (int x = 0; x < 12; x++) {
            studNo += String.format("%-20s", grbook.getStudName(x)) + grbook.getAve(x) + "\t\t\n";
        }

        System.out.println(titleName);
        System.out.println(studNo);
    }

    public void choices() {
        boolean mainLoop = true;

        while (mainLoop) {
            g.printBox("COURSE GRADES");
            System.out.print("[1] - Show SPECIFIC Grades of Student \n[2] - Show SPECIFIC Average of Student"
                    + " \n[3] - Show ALL Grades of Students \n[4] - Show ALL Average of Students \n[5] - Exit \n\nEnter your Choice: ");

            try {
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        spefgrade();
                        break;
                    case 2:
                        spefave();
                        break;
                    case 3:
                        allgrade();
                        break;
                    case 4:
                        allave();
                        break;
                    case 5:
                        System.out.println("Thanks and have a nice day!");
                        mainLoop = false;
                        break;
                    default:
                        System.out.println("Invalid Input! Try again.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Choice! Try again.");
                sc.nextLine();
            }
            g.enterToContinue();
        }
    }

    public void main() {
        putGrades();
        choices();

    }
}
