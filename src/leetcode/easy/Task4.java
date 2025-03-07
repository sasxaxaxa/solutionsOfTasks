package leetcode.easy;

//Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
//
//The overall run time complexity should be O(log (m+n)).

public class Task4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //требуемая сложность O(log(m+n))
        //Двоичный поиск выполняется по меньшему из массивов,
        //и на каждом шаге мы сужаем диапазон на половину.
        // Следовательно, сложность будет пропорциональна логарифму
        // длины меньшего массива, а в худшем случае к общей длине
        // двух массивов, что и дает сложность O(log(min(m, n))),
        // что примерно эквивалентно O(log(m + n)) в контексте задачи.

        //мы будем применять двоичный поиск к меньшему массиву,
        //чтобы уменьшить количество итераций

        //проверяем меньший массив. если 1 больше, то меняем их местами
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        //переменные для двоичного поиска - длина массивов

        int m = nums1.length;
        int n = nums2.length;

        //индексы для двоичного поиска
        //left & right это границы для двоичного поиска по массиву nums1.
        //мы ищем нужный индекс в nums1 который разделит массив на 2 части

        int left = 0;
        int right = m;
        int half_len = (m + n + 1) / 2;

        //внутри цикла ищем подходящие индексы i и j которые разделяют массивы

        while (left <= right) {
            int i = (left + right) / 2;

            int j = (half_len - i);

            if (i < m && nums2[j - 1] > nums1[i]) {
                left = i + 1;
            } else if (i > 0 && nums1[i - 1] > nums2[j]) {
                right = i - 1;
            } else {
                int lmax = 0;
                if (i == 0) {
                    lmax = nums2[j - 1];
                } else if (j == 0) {
                    lmax = nums1[i - 1];
                } else {
                    lmax = Math.max(nums1[i - 1], nums2[j - 1]);
                }

                if ((m + n) % 2 == 1) {
                    return lmax;
                }
                int rmin = 0;

                if (i == m) {
                    rmin = nums2[j];
                } else if (j == n) {
                    rmin = nums1[i];
                } else {
                    rmin = Math.min(nums1[i], nums2[j]);
                }
                return (lmax + rmin) / 2.0;
            }
        }
        return 0.0;
    }
}

/*
        while (left <= right) {

            //Предположим, у нас есть два массива:
            //
            //nums1 = [1, 3, 8] (длина 3, m = 3)
            //nums2 = [2, 4, 5, 7, 10] (длина 5, n = 5)

            // i = 0 + (3 - 0) / 2 = 1
            //То есть, мы берем второй элемент из nums1, индекс i = 1
            // j = (3 + 5) / 2 - 1 = 4 - 1 = 3
            //То есть, j = 3 означает, что мы "берем" три элемента из nums2 для левой части.
            //Левую часть мы можем составить из nums1[0], nums1[1] и nums2[0], nums2[1], nums2[2] (это элементы на позициях i и j).
            //Правая часть будет состоять из оставшихся элементов.
            int i = left + (right - left) / 2;
            int j = (m + n) / 2 - i + 1;
            //здесь мы ищем правильное разделение
            int nums1Left = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1Right = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int nums2Left = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2Right = (j == n) ? Integer.MAX_VALUE : nums2[j];

            //проверка является ли разделение правильным

            if (nums1Left <= nums2Right && nums2Left <= nums1Right) {
                if ((m + n) % 2 == 0) { //медиана для четной длины
                    return (Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right)) / 2.0;
                } else { //медиана для нечетной длины
                    return Math.max(nums1Left, nums2Left);
                }
            } else if (nums1Left > nums2Right) {
                //ищем меньшую часть в nums1
                right = i - 1;
            } else {
                left = i + 1;
            }
        }
        throw new IllegalArgumentException("Input arrays are not sorted.");
    }
}*/
