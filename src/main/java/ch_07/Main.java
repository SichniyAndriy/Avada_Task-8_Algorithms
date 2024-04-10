package ch_07;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Graph graph = GraphUtil.init();
        graph.showAllVertex();

        int from;
        int to;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                from = checkInput(scanner, graph.size(), "початкової");
                if (from == 0) break;

                to = checkInput(scanner, graph.size(), "кінцевої");
                if (to == 0) break;

                System.out.println(graph.findBestWay(from, to));
            } catch (InputMismatchException e) {
                throw new RuntimeException("Помилка вводу. Введіть від 0 до " + graph.size());
            }
        }
        scanner.close();
    }

    private static int checkInput(Scanner scanner, int size, String line) throws InputMismatchException {
        System.out.print("Введіть номер " + line + " вершини або 0 для виходу: ");
        int input = scanner.nextInt();
        if (input < 0 || input > size) {
            throw new InputMismatchException();
        }
        return input;
    }
}
