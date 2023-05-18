import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MergeSortComparison {
    public static void main(String[] args) {
        int size = 10000000; // Размер массива

        // Генерация большого массива случайных чисел
        Integer[] arr = new Integer[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt();
        }

        // Копирование массива для сравнения сортировки
        Integer[] arrCopy = Arrays.copyOf(arr, arr.length);

        // Сортировка с помощью сортировки слиянием (mergesort)
        long mergeSortStartTime = System.currentTimeMillis();
        mergeSort(arr);
        long mergeSortEndTime = System.currentTimeMillis();

        // Сортировка с помощью Collections.sort()
        long collectionsSortStartTime = System.currentTimeMillis();
        Collections.sort(Arrays.asList(arrCopy));
        long collectionsSortEndTime = System.currentTimeMillis();

        // Вывод результатов
        System.out.println("Время выполнения сортировки слиянием: " + (mergeSortEndTime - mergeSortStartTime) + " мс");
        System.out.println("Время выполнения Collections.sort(): " + (collectionsSortEndTime - collectionsSortStartTime) + " мс");
    }

    public static void mergeSort(Integer[] arr) {
        if (arr.length < 2) {
            return;
        }

        int mid = arr.length / 2;
        Integer[] left = Arrays.copyOfRange(arr, 0, mid);
        Integer[] right = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    public static void merge(Integer[] arr, Integer[] left, Integer[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}


/*
Метод mergeSort принимает на вход массив arr и выполняет рекурсивную сортировку слиянием. Сначала он проверяет базовый случай: если размер массива arr меньше 2, то это уже отсортированный массив или пустой массив, поэтому мы просто возвращаемся. Если массив содержит больше элементов, происходит следующее:

Находим середину массива arr, деля его размер пополам: int mid = arr.length / 2;.
Создаем два подмассива left и right, которые являются копиями левой и правой половин массива arr соответственно.
Рекурсивно вызываем метод mergeSort для подмассива left: mergeSort(left);.
Рекурсивно вызываем метод mergeSort для подмассива right: mergeSort(right);.
Вызываем метод merge, передавая массив arr, а также отсортированные подмассивы left и right, чтобы объединить их в итоговый отсортированный массив: merge(arr, left, right);.

Метод merge принимает на вход массив arr, а также два отсортированных подмассива left и right, и выполняет объединение (слияние) этих двух подмассивов в итоговый отсортированный массив.
Объявляем переменные i, j и k и инициализируем их нулевыми значениями. Переменная i будет индексом для подмассива left, переменная j — для подмассива right, а переменная k — для итогового массива arr: int i = 0, j = 0, k = 0;.
В цикле сравниваем элементы left[i] и right[j]. Если left[i] меньше или равно right[j], то добавляем left[i] в итоговый массив arr и увеличиваем индекс i и k на 1. Если left[i] больше right[j], то добавляем right[j] в итоговый массив arr и увеличиваем индекс j и k на 1. Процесс повторяется, пока не будут обработаны все элементы одного из подмассивов.
 */