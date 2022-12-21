package advent.of.code.calories;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ElfStorage {
    private final List<Elf> elfList = new ArrayList<>();

    public void addNewElf(Elf elf) {
        elfList.add(elf);
        elfList.sort(Comparator.comparing(Elf::getTotalCalories).reversed());
    }

    public List<Elf> getElfList() {
        return elfList;
    }

    public Elf getHighestCalorieElf() {
        return elfList
                .stream()
                .max(Comparator.comparing(Elf::getTotalCalories))
                .orElse(null);
    }

    public List<Elf> getHighestCalorieElfs(int limit) {
        return getElfList()
                .stream()
                .limit(limit)
                .collect(Collectors.toList());
    }
}
