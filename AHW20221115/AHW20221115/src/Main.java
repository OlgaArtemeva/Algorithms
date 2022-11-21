public class Main {
    public static void main(String[] args) {
        System.out.println(recurs(2, 0));
        System.out.println(recurs(2, 1));
        System.out.println(recurs(2, 2));
        System.out.println(recurs(2, 8));
        System.out.println("---------------------");

        System.out.println(solutionLog(2, 0));
        System.out.println(solutionLog(2, 1));
        System.out.println(solutionLog(2, 2));
        System.out.println(solutionLog(2, 8));
        System.out.println("=====================");

        int[] arr1 = {100, 112, 256, 349, 770};
        int[] arr2 = {72, 86, 113, 119, 265, 445, 892};
        findK(arr1, arr2, 7);
        System.out.println("=====================");

        int[] arr = {1, 1, 2, 2, 2, 2, 3};
        System.out.println(countIn(arr, 0, 6, 2));
    }


//    1. Даны два целых числа x и n, напишите функцию для вычисления x^n
//    решение 1 - рекурсивно O(n)
//    решение 2 - улучшить решение 1 до O(lon n)

    public static int recurs(int x, int n) {
        int res;
        if (n == 0) {
            return res = 1;
        } else {
            res = x * recurs(x, n - 1);
        }
        return res;
    }

    public static int solutionLog(int x, int n) {
        int res;

        if (n == 0) {
            return 1;
        } else {
            if (n % 2 == 1) {
                return x * solutionLog(x, n - 1);
            } else {
                res = solutionLog(x, n / 2);
            }
        }
        return res * res;
    }

//    Имея два отсортированных массива размера m и n соответственно, вам нужно найти элемент, который будет находиться на k-й позиции в конечном отсортированном массиве.
//    Массив 1 - 100 112 256 349 770
//    Массив 2 - 72 86 113 119 265 445 892
//    к = 7
//    Вывод : 256
//    Окончательный отсортированный массив -
//            72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892
//            7-й элемент этого массива равен 256.

    public static void findK(int[] arr1, int[] arr2, int k) {
        int m = arr1.length;
        int n = arr2.length;
        int[] arr = new int[m + n];
        int i = 0;
        int j = 0;
        int count = 0;

        if (k > m + n || k < 0) {
            System.out.println("k-й позиции нет");
            return;
        } else {
            while (count != k) {

                for (i = 0, j = 0; i <= m && j <= n; ) {
                    if (count == k) {
                        break;
                    }
                    if (arr1[i] >= arr2[j]) {
                        arr[count] = arr2[j];
                        count += 1;
                        j += 1;
                    } else {
                        arr[count] = arr1[i];
                        count += 1;
                        i += 1;
                    }
                }
                if (i == m) {
                    arr[count] = arr2[j];
                    count += 1;
                    j += 1;
                }
                if (j == n) {
                    arr[count] = arr1[i];
                    count += 1;
                    i += 1;
                }
            }
            System.out.println(k + "-я позиция равна " + arr[count - 1]);
        }

    }


//    Имея отсортированный массив arr[] и число x, напишите функцию, которая подсчитывает вхождения x в arr[]. Ожидаемая временная сложность O(Log n)
//    arr[] = {1, 1, 2, 2, 2, 2, 3,}
//    x = 2
//    Вывод: 4 раза

    public static int countIn(int[] arr, int i, int j, int x) {

        if (i > j) {
            return 0;
        }
        if (arr[i] > x || arr[j] < x) {
            return 0;
        }
        if (arr[i] == x && arr[j] == x) {
            return j - i + 1;
        }
        return countIn(arr, i, (i + j) / 2, x) + countIn(arr, (i + j) / 2 + 1, j, x);
    }

}