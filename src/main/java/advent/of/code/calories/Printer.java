package advent.of.code.calories;

import advent.of.code.rockpaperscissor.Draw;

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

    public void printDraws(Draw opponentDraw, Draw myDraw, int individualScore, int score, int lineNumber) {
        System.out.println("Game Number: "+ lineNumber);
        System.out.println("Draw of Opponent: "+ opponentDraw);
        System.out.println("Draw of me: "+ myDraw);
        System.out.println("Match Points: " + individualScore);
        System.out.println("Total Points: " + score);
        System.out.println("---------------------------------------------------------");
    }
}
