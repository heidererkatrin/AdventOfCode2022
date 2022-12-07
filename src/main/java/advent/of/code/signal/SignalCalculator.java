package advent.of.code.signal;

public class SignalCalculator {


    public int calculateFirstMarker(String input, int lengthOfMarker) {
        StringBuilder sequence = new StringBuilder();
        for (int index = 0; index < input.length(); index ++){
            if (sequence.isEmpty()){
                setFirstInput(input, sequence, index);
            }
            else{
                String nextLetter = input.substring(index, index + 1);
                sequence = calculateNextInput(sequence, nextLetter);
                Integer split = calculateFirstMarkerPoint(input, sequence, lengthOfMarker);
                if (split != null) return split;
            }
        }
        return 0;
    }

    private Integer calculateFirstMarkerPoint(String input, StringBuilder sequence, int lengthOfMarker) {
        if (sequence.toString().length() == lengthOfMarker){
            String[] split = input.split(sequence.toString());
            return split[0].length() + lengthOfMarker;
        }
        return null;
    }

    private StringBuilder calculateNextInput(StringBuilder sequence, String nextLetter) {
        if (sequence.toString().contains(nextLetter)){
            String[] split = sequence.toString().split(nextLetter);
            sequence = new StringBuilder();
            if (split.length < 2){
                sequence.append(nextLetter);
            }
            else{
                sequence.append(split[1]).append(nextLetter);
            }
        }
        else{
            sequence.append(nextLetter);
        }
        return sequence;
    }

    private void setFirstInput(String input, StringBuilder sequence, int index) {
        if (!input.substring(index, index +1).equals(input.substring(index +1, index +2))){
            sequence.append(input.charAt(index));
        }
    }
}
