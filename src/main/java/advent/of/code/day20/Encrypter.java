package advent.of.code.day20;

import java.util.ArrayList;
import java.util.List;

public class Encrypter {
    List<NumberObject> numbers;

    public Encrypter(List<NumberObject> numbers){
        this.numbers = numbers;
    }

    public String shuffleNumbers() {
        List<NumberObject> copyOfNumberList = new ArrayList<>(numbers);
        for (int i = 0; i < copyOfNumberList.size(); i++) {

            NumberObject numberObject = copyOfNumberList.get(i);
            int newIndex = getCurrentIndex(numberObject) + numberObject.getValue();

            if (newIndex < 1) {
                newIndex = calculateIndexNegativ(copyOfNumberList.size(), numberObject);

            } else if (newIndex > copyOfNumberList.size() - 1) {
                newIndex = calculateIndexPositive(copyOfNumberList.size(), newIndex);
            }
            numbers.remove(numberObject);
            numbers.add(newIndex, numberObject);
        }
        return buildStringFromList(numbers);
    }

    private int getCurrentIndex(NumberObject numberObject) {
        return numbers.indexOf(numberObject);
    }

    private NumberObject getItemAtIndex(int index) {
        return numbers.get(index);
    }

    public int getThreeHighestNumbers(){
        NumberObject zero = numbers.stream().filter(e -> e.getValue().equals(0)).findFirst().get();
        int sum = getItemAtIndex(getCurrentIndex(zero) + 1000).getValue();
        sum = sum + getItemAtIndex(getCurrentIndex(zero) + 2000).getValue();
        sum = sum + getItemAtIndex(getCurrentIndex(zero) + 3000).getValue();
        return sum;
    }

    private int calculateIndexPositive(int listLength, int index) {
        int newIndex = index - numbers.size() + 1;
        while (newIndex > listLength - 1) {
            newIndex = newIndex - listLength;
        }
        return newIndex;
    }

    private int calculateIndexNegativ(int listLength, NumberObject numberObject) {
        int calculatedIndex = numberObject.getValue() + getCurrentIndex(numberObject);
        int newIndex = listLength + calculatedIndex - 1;
        while (newIndex < 0) {
            newIndex = newIndex + listLength;
        }
        return newIndex;
    }

    public void addNumberToList(String number) {
        numbers.add(new NumberObject(Integer.parseInt(number.trim())));
    }

    private String buildStringFromList(List<NumberObject> numbers) {
        StringBuilder builder = new StringBuilder();
        for (NumberObject number : numbers) {
            builder.append(number.getValue());
            builder.append(", ");
        }
        return builder.toString();
    }
}
