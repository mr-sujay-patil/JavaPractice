package Practice;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class CheckNotNullOrIterate {
    public static void main(String[] args) {
        List<Integer> list=null;
        Optional.ofNullable(list)
                .filter(ele->!ele.isEmpty())
                .ifPresent(System.out::println);
    }
}
