/*
Имеется три стержня — левый, средний и правый. На левом стержне находятся n дисков, диаметры которых различны. Диски упорядочены по размеру диаметра, сверху лежит наименьший, снизу — наибольший. Требуется перенести диски с левого стержня на правый, используя средний стержень как вспомогательный.


        Головоломка имеет следующие два правила:
        1. Вы не можете поместить больший диск на меньший диск.
        2. За один раз можно перемещать только один диск.

        Реализуйте два подхода для решения.

        Итеративно
        Рекурсивно
*/

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        moveRecurs(3, 'A', 'B', 'C');
        moveIter(3, 1, 2, 3);
    }

    public static void moveRecurs(int height, char a, char b, char c) {
        if (height == 1) {
            System.out.println(a + " -> " + c);
        } else {
            moveRecurs(height - 1, a, c, b);
            System.out.println(a + " -> " + c);
            moveRecurs(height - 1, b, a, c);
        }
    }

    public static void moveIter(int height, int a, int b, int c) {
        ArrayList<int[]> stack = new ArrayList<int[]>();
        stack.add(new int[]{height, a, b, c});
        while (stack.size() > 0) {
            int[] tmp = stack.remove(0);
            // tmp[0] = n, tmp[1] = a, tmp[2] = b, tmp[3] = c
            if (tmp[0] == 1) {
                System.out.println(tmp[1] + " -> " + tmp[3]);
            } else {
                stack.add(0, new int[]{tmp[0] - 1, tmp[1], tmp[3], tmp[2]});
                stack.add(1, new int[]{1, tmp[1], tmp[2], tmp[3]});
                stack.add(2, new int[]{tmp[0] - 1, tmp[2], tmp[1], tmp[3]});
            }
        }
    }
}