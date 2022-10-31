public class Main {
    public static void main(String[] args) {
//        1. Linear Search
//        Given an array arr[] of N elements, the challenge is to write a function to find a given element x in arr[] .
//        Линейный поиск используется для поиска ключевого элемента среди нескольких элементов.
//        Линейный поиск сегодня используется меньше, потому что он медленнее, чем бинарный поиск и хеширование.
//        Алгоритм:
//        Шаг 1: Обход массива
//        Шаг 2: Сопоставьте ключевой элемент с элементом массива
//        Шаг 3: Если ключевой элемент найден, верните позицию индекса элемента массива.
//        Шаг 4: Если ключевой элемент не найден, верните -1

        int[] arr={2, 7, 4, 3, 7, 8};

        System.out.println(searchElement(arr, 3));
        System.out.println(searchElement(arr, 6));
        System.out.println("------------------------");

//        Find the element that appears once in a sorted array
//        Given a sorted array in which all elements occur twice (one after the other) and one element appears only once.
//
//        Простое решение состоит в обходе массива слева направо. Поскольку массив отсортирован, мы легко можем найти нужный элемент.
//                Алгоритм:
//        Шаг 1: Обход массива через один элемент
//        Шаг 2: Если элемент отличается от первого то мы нашли не задублированный элемент
//        Шаг 3: Вернем элемент или позицию в массиве
//        Шаг 4: Если ключевой элемент не найден, верните -1 или что то еще :)
//…
//        Шаг 5: Исправить ошибку ArrayIndexOutOfBoundsException

        int[] arrDouble1={2,2,3,3,4,5,5,7,7};
        System.out.println(searchNotDouble(arrDouble1));

        int[] arrDouble2={2,3,3,4,5,5,7,7};
        System.out.println(searchNotDouble(arrDouble2));

        int[] arrDouble3={2,2,3,3,4,4,5,5,7};
        System.out.println(searchNotDouble(arrDouble3));

        int[] arrDouble4={2,2,3,3,4,4,5,5,7,7};
        System.out.println(searchNotDouble(arrDouble4));

    }
    public static int searchElement(int[] arr, int x){
        for (int i=1; i<arr.length; i++){
            if (arr[i]==x){
                return i;
            }
        }
        return -1;
    }
    /* ----------------------------------------------- */
    public static int searchNotDouble(int[] arr){
        for (int i=1; i<arr.length; i+=2){
            if (arr[i-1]!=arr[i]){
                return i-1;
            }
            if (i==arr.length-2){
                return i+1;
            }
        }
        return -1;
    }

}