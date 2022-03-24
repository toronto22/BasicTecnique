package info.toronto22.features.how_to_assert_two_list_with_assertj.list_object;

import info.toronto22.model.User;
import net.serenitybdd.junit5.SerenityTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SerenityTest
public class WhenCompareTwoListObjectWithOrder {
    static List<User> firstList = new ArrayList<>();
    static List<User> secondList = new ArrayList<>();
    static List<User> thirdList = new ArrayList<>();
    static List<User> fourthList = new ArrayList<>();

    @BeforeAll
    public static void initLists(){
        //Original list
        firstList.add(new User("A",12,true,123.12));
        firstList.add(new User("B",14,true,888));
        firstList.add(new User("C",13,false,999));

        //Same original list but different order
        secondList.add(new User("A",12,true,123.12));
        secondList.add(new User("C",13,false,999));
        secondList.add(new User("B",14,true,888));

        //Same original list
        thirdList.add(new User("A",12,true,123.12));
        thirdList.add(new User("B",14,true,888));
        thirdList.add(new User("C",13,false,999));

        //different with original list
        fourthList.add(new User("A",12,true,123.12));
        fourthList.add(new User("B",14,true,888));
        fourthList.add(new User("D",13,false,999));
    }

    @Test
    public void compare_with_order_with_2_equal_lists_have_same_order(){
        assertThat(firstList).usingRecursiveComparison()
                .isEqualTo(thirdList);
    }

    @Test
    public void compare_with_order_with_2_equal_lists_have_different_order(){
        assertThrows(AssertionError.class,
                ()-> assertThat(firstList).usingRecursiveComparison()
                        .isEqualTo(secondList));
    }
    @Test
    public void compare_with_order_with_2_different_lists(){
        assertThrows(AssertionError.class,
                ()-> assertThat(firstList).usingRecursiveComparison()
                        .isEqualTo(fourthList));
    }
}
