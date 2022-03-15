package minmax;

import java.util.*;

public class MinMaxService {

    public static <T extends Comparable<T>> MinMax<T> getMinAndMax(List<T> elements) {
        return new MinMax<>(
                Optional.ofNullable(elements)
                        .orElse(Collections.emptyList())
                        .stream()
                        .filter(Objects::nonNull)
                        .min(Comparator.naturalOrder())
                        .orElseThrow()
                ,
                Optional.of(elements)
                        .orElse(Collections.emptyList())
                        .stream()
                        .filter(Objects::nonNull)
                        .max(Comparator.naturalOrder())
                        .orElseThrow());
    }
}
