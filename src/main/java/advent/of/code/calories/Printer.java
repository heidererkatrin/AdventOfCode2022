package advent.of.code.calories;


public class Printer {

    public void printElfCalories(ElfStorage elfStorage){
        for (int i = 0; i < elfStorage.getElfList().size(); i++){
            System.out.println("Elf: "+ i +1);
            System.out.println("Calories: " + elfStorage.getElfList().get(i).getTotalCalories());
            System.out.println("---------------------------------------------------------");
        }
    }

    public void printDraws(ElfStorage elfStorage){
        for (int i = 0; i < elfStorage.getElfList().size(); i++){
            System.out.println("Elf: "+ i +1);
            System.out.println("Calories: " + elfStorage.getElfList().get(i).getTotalCalories());
            System.out.println("---------------------------------------------------------");
        }
    }
}
