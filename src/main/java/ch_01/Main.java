package ch_01;

import java.util.Arrays;
import java.util.Scanner;
import net.datafaker.Faker;

public class Main {
    private final static Faker faker = new Faker();
    private static int LEN;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть розмір масива: ");
        LEN = scanner.nextInt();
        int[] arr = new int[LEN];
        for (int i = 0; i < LEN; ++i) {
            arr[i] = faker.random().nextInt(-99, 99);
        }
        System.out.println(Arrays.toString(arr));

        scanner = new Scanner(System.in);

        System.out.print("Введіть число: ");
        int x = scanner.nextInt();
        searchSerial(x, arr);

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));

        System.out.print("Введіть число: ");
        x = scanner.nextInt();
        searchBinary(x, arr);
    }

    private static void searchSerial(int x, int[] arr) {
        for (int i = 0; i < LEN; ++i) {
            if (arr[i] == x) {
                System.out.println("Ідекс шукаємого числа: " + i);
                return;
            }
        }
        System.out.println("Шукаємого числа немає");
    }

    private static void searchBinary(final int x, final int[] arr) {
        int res = searchBinary(x, arr, 0, arr.length - 1);
        System.out.println(res >= 0 ? "Ідекс шукаємого числа: " + res : "Шукаємого числа немає");
    }

    private static int searchBinary(final int x, final int[] arr, final int from, final int to) {
        if (from >= to) return -1;
        final int mid = from + (to - from) / 2;

        if (arr[mid] == x) return mid;
        else if (arr[mid] < x) return searchBinary(x, arr , mid + 1, to);
        else if (arr[mid] > x) return searchBinary(x, arr, from, mid - 1);
        else return -1;
    }
}
