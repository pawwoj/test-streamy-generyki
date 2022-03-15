package kalkulator;

public class Main {
    /*    2:
        Dany jest kod:
    Map<String, ??> operationMap = new HashMap()<>();
    operationMap.put("+", ??);
    operationMap.put("-", ??);
    operationMap.put("*", ??);
    operationMap.put("/", ??);

    System.out.println(operationMap.get("+").calculate(10,20));
        zrob aby kod dzialal.*/

    public static void main(String[] args) {
        Kalkulator kalkulator = new Kalkulator();
        System.out.println(kalkulator.licz("+", 10, 20));
    }
}
