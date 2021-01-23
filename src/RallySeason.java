import java.util.*;

public class RallySeason {

    List<String> ralliesList;
    List<String> classesList;
    Map<String, String> rallyMap;


    public RallySeason(List<String> ralliesList, List<String> classesList) {
        this.ralliesList = ralliesList;
        this.classesList = classesList;
        rallyMap = new HashMap<>();

        generateSeason(Math.min(ralliesList.size(), classesList.size()), false); // generates default season
    }

    public void generateSeason(int rallyCounter, boolean uniqueClasses){

        LinkedList<String> internalClassesList = new LinkedList<>(classesList);
        LinkedList<String> internalRalliesList = new LinkedList<>(ralliesList);


        Random r = new Random();

        int rallyIndex;
        int classIndex;


        for (int i = 0; i < rallyCounter; i++) {

            if (internalClassesList.size() == 0){
                rallyMap.put("There are less car classes than rallies, assigning a unique class to a rally is not possible.", "Class randomization is reset");
                internalClassesList = new LinkedList<>(classesList);
            }

            rallyIndex = r.nextInt(internalRalliesList.size());
            classIndex = r.nextInt(internalClassesList.size());

            rallyMap.put(internalRalliesList.get(rallyIndex), internalClassesList.get(classIndex)); // default rally season

            internalRalliesList.remove(rallyIndex);

            if (uniqueClasses){
                internalClassesList.remove(classIndex);
            }

        }
    }

    public void rallyPrinter (){
        for (Map.Entry<String, String> entry : rallyMap.entrySet()){
            System.out.format("%-13s" + " @ " + entry.getKey() + "\n", entry.getValue());
//            System.out.format("%0$-10s" + " @ " + entry.getKey() ,entry.getValue()); // 0$ indicates argument index
        }
    }

}
