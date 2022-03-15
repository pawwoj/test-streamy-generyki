package kalkulator;

import java.util.HashMap;
import java.util.Map;

public class Kalkulator {

    public double licz(String znak, double l1, double l2) {
        Map<String, Calculate> operationMap = new HashMap<>();
        operationMap.put("+", (a, b) -> a + b);
        operationMap.put("-", (a, b) -> a - b);
        operationMap.put("*", (a, b) -> a * b);
        operationMap.put("/", (a, b) -> a / b);

        return operationMap.get(znak).calculate(l1, l2);
    }
}
