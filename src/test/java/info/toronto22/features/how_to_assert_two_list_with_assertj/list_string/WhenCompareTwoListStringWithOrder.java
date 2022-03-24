package info.toronto22.features.how_to_assert_two_list_with_assertj.list_string;

import net.serenitybdd.junit5.SerenityTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SerenityTest
public class WhenCompareTwoListStringWithOrder {
    static List<String> firstList = new ArrayList<>();
    static List<String> secondList = new ArrayList<>();
    static List<String> thirdList = new ArrayList<>();
    static List<String> fourthList = new ArrayList<>();

    @BeforeAll
    public static void initLists(){
        //Original list
        firstList.add("A");
        firstList.add("B");
        firstList.add("C");

        //Same original list but different order
        secondList.add("A");
        secondList.add("C");
        secondList.add("B");

        //Same original list
        thirdList.add("A");
        thirdList.add("B");
        thirdList.add("C");

        //different with original list
        fourthList.add("D");
        fourthList.add("D");
        fourthList.add("D");
    }

    @Test
    public void compare_ignore_order_with_2_equal_lists_have_same_order(){
        assertThat(firstList).isEqualTo(thirdList);
    }

    @Test
    public void compare_ignore_order_with_2_equal_lists_have_different_order(){
        assertThrows(AssertionError.class,
                ()-> assertThat(firstList).isEqualTo(secondList));
    }
    @Test
    public void compare_ignore_order_with_2_different_lists(){
        assertThrows(AssertionError.class,
                ()-> assertThat(firstList).isEqualTo(fourthList));
    }
}
