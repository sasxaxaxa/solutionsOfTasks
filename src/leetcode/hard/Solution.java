package leetcode.hard;

class Solution {
    public static void main(String[] args) {
        int[] arr1 = new int[]{10};
        int[] arr2 = new int[]{20, 30, 40, 50, 60, 70};

        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(arr1, arr2));
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // инициализация переменных m и n с длинами массивов nums1 и nums2 соответственно
        int m = nums1.length;
        int n = nums2.length;
        // проверка, что длина массива nums1 не больше длины массива nums2, если это так,
        // то меняем массивы местами и пересчитываем длины
        if (m > n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            m = nums1.length;
            n = nums2.length;
        }
        // инициализация переменных для бинарного поиска медианы
        int imin = 0;
        int imax = m;



        int half_len = (m + n + 1) / 2;
        // бинарный поиск медианы
        while (imin <= imax) {
            // разбиваем nums1 на две части в точке i
            int i = (imin + imax) / 2;
            // разбиваем nums2 на две части в точке j
            int j = half_len - i;
            // если j > 0 и nums2[j-1] > nums1[i], значит нужно уменьшить i, чтобы увеличить j
            if (i < m && nums2[j - 1] > nums1[i]) {
                imin = i + 1;
            }
            // если i > 0 и nums1[i-1] > nums2[j], значит нужно увеличить i, чтобы уменьшить j
            else if (i > 0 && nums1[i - 1] > nums2[j]) {
                imax = i - 1;
            }
            // иначе найдена правильная разбивка, находим медиану
            else {
                int lmax = 0;
                if (i == 0) {
                    lmax = nums2[j - 1];
                } else if (j == 0) {
                    lmax = nums1[i - 1];
                } else {
                    lmax = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                // если суммарная длина массивов нечётная, медиана - максимальный элемент левой части
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
                // если суммарная длина массивов чётная, медиана - среднее максимального элемента левой
                // части и минимального элемента правой части
                return (lmax + rmin) / 2.0;
            }
        }
        return 0.0;
    }
}