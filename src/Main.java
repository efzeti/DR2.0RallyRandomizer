
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
        Map<String, String> rallyMap = new HashMap<>();
        List<String> ralliesList = new LinkedList<>(Arrays.asList(rallies));
        List<String> classesList = new LinkedList<>(Arrays.asList(classes));

        boolean repeatClasses = false; // false for different car class @ each rally

        Random r = new Random();

        int rallyIndex;
        int classIndex;



        do {

            System.out.println("How many rallies do you want?");

            rallyCount = s.nextLine();

        }while (!rallyCount.chars().allMatch( Character::isDigit ) || Integer.parseInt(rallyCount) < 1 || Integer.parseInt(rallyCount) > rallies.length);


        for (int i = 0; i < Integer.parseInt(rallyCount); i++) {
            rallyIndex = r.nextInt(ralliesList.size());
            classIndex = r.nextInt(classesList.size());

            rallyMap.put(ralliesList.get(rallyIndex), classesList.get(classIndex));

            ralliesList.remove(rallyIndex);

            if (!repeatClasses){
                classesList.remove(classIndex);
            }

        }

        rallyPrinter(rallyMap);




    }

    public static void rallyPrinter (Map<String, String> rallyMap){
        for (Map.Entry<String, String> entry : rallyMap.entrySet()){
            System.out.format("%-13s" + " @ " + entry.getKey() + "\n", entry.getValue());
//            System.out.format("%0$-10s" + " @ " + entry.getKey() ,entry.getValue()); // 0$ indicates argument index
        }
    }
}
