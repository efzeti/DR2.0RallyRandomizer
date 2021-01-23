
import java.util.*;

public class Main {

    public static String[] rallies = new String[]{"Catamarca Province, Argentina", "Monaro, Australia", "Hawkes Bay, New Zealand",
            "Ribadelles, Spain", "New England, USA", "Łęczna County, Poland", "Monte Carlo, Monaco", "Värmland, Sweden",
            "Baumholder, Germany", "Jämsä, Finland", "Argolis, Greece", "Powys, Wales", "Perth and Kinross, Scotland"};

    public static String[] classes = new String[]{"H1 (FWD)", "H2 (FWD)", "H2 (RWD)", "H3 (RWD)", "Group B (RWD)",
            "Group B (4WD)", "R2", "F2 Kit Car", "Group A", "NR4/R4", "Up to 2000cc", "R5", "Rally GT"};

    public static void main(String[] args) {



        Scanner s = new Scanner(System.in);
        String rallyCount;
        String uniqueClasses; // 1 for different car class @ each rally


        do {

            System.out.println("How many rallies do you want?");

            rallyCount = s.nextLine();

        }while (!rallyCount.chars().allMatch( Character::isDigit ) || Integer.parseInt(rallyCount) < 1);

        System.out.println("Do you want unique car classes for each rally? (1 for unique car class at each rally, other number for random)");
        uniqueClasses = s.nextLine();

        RallySeason rallySeason = new RallySeason(Arrays.asList(rallies), Arrays.asList(classes));


        rallySeason.generateSeason(Integer.parseInt(rallyCount), uniqueClasses.equals("1"));
        rallySeason.rallyPrinter();




    }


}
