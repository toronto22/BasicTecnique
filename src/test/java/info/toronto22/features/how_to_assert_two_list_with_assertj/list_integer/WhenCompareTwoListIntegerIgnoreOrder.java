package info.toronto22.features.how_to_assert_two_list_with_assertj.list_integer;

import net.serenitybdd.junit5.SerenityTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SerenityTest
@Execution(ExecutionMode.CONCURRENT)
public class WhenCompareTwoListIntegerIgnoreOrder {
    static List<Integer> firstList = new ArrayList<>();
    static List<Integer> secondList = new ArrayList<>();
    static List<Integer> thirdList = new ArrayList<>();
    static List<Integer> fourthList = new ArrayList<>();

    @BeforeAll
    public static void initLists(){
        //Original list
        firstList.add(1);
        firstList.add(2);
        firstList.add(3);

        //Same original list but different order
        secondList.add(1);
        secondList.add(3);
        secondList.add(2);

        //Same original list
        thirdList.add(1);
        thirdList.add(2);
        thirdList.add(3);

        //different with original list
        fourthList.add(4);
        fourthList.add(4);
        fourthList.add(4);
    }

    @Test
    public void compare_ignore_order_with_2_equal_lists_have_same_order(){
        assertThat(firstList).hasSameElementsAs(thirdList);
    }

    @Test
    public void compare_ignore_order_with_2_equal_lists_have_different_order(){
        assertThat(firstList).hasSameElementsAs(secondList);
    }
    @Test
    public void compare_ignore_order_with_2_different_lists(){
        assertThrows(AssertionError.class,
                ()-> assertThat(firstList).hasSameElementsAs(fourthList));
    }
}
