import java.util.*;

public class HomeworkConsultation {
    public static void main(String[] args) {

        Camry black = new Camry("black",10000, 600000,"UPP345");
        Camry blue = new Camry("blue", 0,900000,"ATT789");
        Camry red = new Camry("red", 20000,800000,"BUU234");
        Camry green = new Camry("green", 15000,700000,"SNN890");
        Camry yellow = new Camry("yellow", 300000, 500000,"MEE678");

        List<Camry> cars = Arrays.asList(black, blue, red, green, yellow);

        cars.stream()
                .filter(car -> (car.getColor().equalsIgnoreCase("black") || car.getKm() == 0))
                .map(Camry::getNumber)
                .forEach(System.out::println);

        long colorCar = cars.stream()
                .filter(car -> (car.getPrice() >= 700) && (car.getPrice() <= 800))
                .map(Camry::getNumber)
                .distinct()
                .count();
        System.out.println(colorCar);


        Optional<String> min = cars.stream()
                .min(Comparator.comparingDouble(Camry::getPrice))
                .map(Camry::getColor);
        System.out.println(min);

        OptionalDouble average = cars.stream()
                .mapToDouble(Camry::getPrice)
                .average();
        System.out.println(average);

    }
}
//1) Номера всех автомобилей, имеющих черный цвет или нулевой пробег.
//2) Количество уникальных моделей в ценовом диапазоне от 700 до 800 тыс.
//3) Вывести цвет автомобиля с минимальной стоимостью.
//4) Среднюю стоимость Camry

//Predicate<T> - позволяет описать функцию, которая возвращает true или false для какого-либо объекта
//Function<T, R> - позволяет описать функцию, которая возвращает объект типа R, созданный на основе типа T
//Consumer<T> - позволяет выполнять операцию над объектом без возврата значения