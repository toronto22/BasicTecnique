package info.toronto22.how_to_assert_two_objects_with_assertj.feature;


import info.toronto22.how_to_assert_two_objects_with_assertj.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class WhenCompareTwoObject {
    User actualUser;
    User expectedUser;
    @Test
    public void should_be_able_to_compare_two_equal_project(){
        actualUser = new User("Toronto22",22,true,12.22);
        expectedUser = new User("Toronto22",22,true,12.22);

        Assertions.assertThat(actualUser).usingRecursiveComparison()
                .isEqualTo(expectedUser);
    }

}
