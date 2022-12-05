package advent.of.code.sections;

import java.util.ArrayList;
import java.util.List;

public class SectionCalculator {
    public List<Integer> calculateSections(String input) {
        ArrayList<Integer> list = new ArrayList<>();
        String[] split = input.split("-");
        for (int i = Integer.parseInt(split[0]); firstNumberIsSmallest(i, Integer.parseInt(split[1])); i++) {
            list.add(i);
        }
        return list;
    }

    public boolean isHardOverlap(List<Integer> firstSection, List<Integer> secondSection) {
        if (firstNumberIsSmallest(firstSection.get(0), secondSection.get(0))
                && secondNumberIsBiggest(firstSection, secondSection)) {
            return true;
        } else
            return firstNumberIsSmallest(secondSection.get(0), firstSection.get(0))
                    && secondNumberIsBiggest(secondSection, firstSection);
    }

    public boolean isSoftOverlap(List<Integer> sectionFirstList, List<Integer> sectionSecondList) {
        return sectionFirstList.stream().anyMatch(sectionSecondList::contains);
    }

    private boolean secondNumberIsBiggest(List<Integer> sectionFirstList, List<Integer> sectionSecondList) {
        return sectionFirstList.get(sectionFirstList.size() - 1) >= sectionSecondList.get(sectionSecondList.size() - 1);
    }

    private boolean firstNumberIsSmallest(Integer sectionFirstList, Integer sectionSecondList) {
        return sectionFirstList <= sectionSecondList;
    }
}
