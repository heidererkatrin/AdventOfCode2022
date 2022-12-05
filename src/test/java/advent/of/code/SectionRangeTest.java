package advent.of.code;

import advent.of.code.sections.SectionCalculator;
import advent.of.code.sections.SectionCsvReader;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SectionRangeTest {

    public static final String SECTIONS_FILE_PATH = "C:\\dev\\AdventOfCode2022\\src\\test\\resources\\Sections.csv";

    @Test
    public void overlappingSection(){
        SectionCalculator sectionCalculator = new SectionCalculator();
        List<Integer> sectionFirstList = sectionCalculator.calculateSections("2-4");
        List<Integer> sectionSecondList = sectionCalculator.calculateSections("6-8");
        assertThat(sectionFirstList).hasSameElementsAs(Arrays.asList(2,3,4));
        assertThat(sectionSecondList).hasSameElementsAs(Arrays.asList(6,7,8));
        assertThat(sectionCalculator.isHardOverlap(sectionFirstList, sectionSecondList)).isFalse();
    }

    @Test
    public void overlappingSectionShouldBeTrue(){
        SectionCalculator sectionCalculator = new SectionCalculator();
        List<Integer> sectionFirstList = sectionCalculator.calculateSections("2-8");
        List<Integer> sectionSecondList = sectionCalculator.calculateSections("3-7");
        assertThat(sectionFirstList).hasSameElementsAs(Arrays.asList(2,3,4,5,6,7,8));
        assertThat(sectionSecondList).hasSameElementsAs(Arrays.asList(3,4,5,6,7));
        assertThat(sectionCalculator.isHardOverlap(sectionFirstList, sectionSecondList)).isTrue();
    }

    @Test
    public void overlappingSectionShouldBeTrueReversed(){
        SectionCalculator sectionCalculator = new SectionCalculator();
        List<Integer> sectionFirstList = sectionCalculator.calculateSections("3-7");
        List<Integer> sectionSecondList = sectionCalculator.calculateSections("2-8");
        assertThat(sectionFirstList).hasSameElementsAs(Arrays.asList(3,4,5,6,7));
        assertThat(sectionSecondList).hasSameElementsAs(Arrays.asList(2,3,4,5,6,7,8));
        assertThat(sectionCalculator.isHardOverlap(sectionFirstList, sectionSecondList)).isTrue();
    }

    @Test
    public void readAllExercise1(){
        SectionCsvReader sectionCsvReader = new SectionCsvReader();
        assertThat(sectionCsvReader.readAllSectionsHardOverlap(SECTIONS_FILE_PATH)).isEqualTo(547);
    }

    @Test
    public void readAllExercise2(){
        SectionCsvReader sectionCsvReader = new SectionCsvReader();
        assertThat(sectionCsvReader.readAllSectionsSoftOverlap(SECTIONS_FILE_PATH)).isEqualTo(843);
    }
}
