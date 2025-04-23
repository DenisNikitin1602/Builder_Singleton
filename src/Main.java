import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        boolean cycle = true;

        while (cycle) {
            logger.log("Запускаем программу");
            logger.log("Просим пользователя ввести входные данные для списка");
            System.out.print("Введите размер списка: ");
            int size= promptForInt(new Scanner(System.in), logger);

            System.out.print("Введите верхнюю границу для значений: ");
            int limit = promptForInt(new Scanner(System.in), logger);
            logger.log("Создаём и наполняем список");

            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                list.add(i, (int) (Math.random() * limit));
            }
            System.out.println("Вот случайный список: " + list.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));

            logger.log("Просим пользователя ввести входные данные для фильтрации");
            System.out.print("Введите порог для фильтра: ");
            int numF = promptForInt(new Scanner(System.in), logger);


            logger.log("Запускаем фильтрацию");
            Filter filter = new Filter(numF);
            List<Integer> filteredList = filter.filterOut(list);

            logger.log("Выводим результат на экран");
            System.out.println("Отфильтрованный список: " + filteredList.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
            logger.log("Завершаем программу");

            cycle = false;
        }

    }
    public static int promptForInt(Scanner sc, Logger logger) {
        int result = 0;
        while (true) {
            String input = sc.nextLine();

            try {
                result = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                logger.log("Ошибка: введены некорректные данные — \"" + input + "\"");
                System.out.print("Пожалуйста, введите корректное целое число: ");
            }
        }
        return result;
    }
}