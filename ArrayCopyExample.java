public class ArrayCopyExample {
    public static void main(String[] args) {
        // 示例二维数组
        int[][] twoDimensionalArray = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        // 创建一维数组，长度为二维数组所有行的元素总和
        int[] oneDimensionalArray = new int[twoDimensionalArray.length * twoDimensionalArray[0].length];

        // 复制每一行到一维数组中
        int index = 0;
        for (int[] row : twoDimensionalArray) {
            System.arraycopy(row, 0, oneDimensionalArray, index, row.length);
            index += row.length;
        }

        // 输出一维数组
        for (int element : oneDimensionalArray) {
            System.out.print(element + " ");
        }
    }
}