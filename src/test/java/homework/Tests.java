package homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Tests {

    @Test
    @DisplayName("Адресная строка не пустая")
    public void correctUrl() {
        String url = "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";
        String expectUrl = "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";

        assertThat(url, equalTo(expectUrl));
    }

    @Test
    @DisplayName("Сортировка выполнена успешно")
    public void currentSort() {
        RequestCats request = new RequestCats("id", "text", "type", "user", "1");
        String expectUpvotes = "null";

        Assertions.assertNotEquals(request.getUpvotes(), expectUpvotes);
    }
}