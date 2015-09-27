package problem.h000.d010;

import problem.Problem;

import java.util.Arrays;

/**
 * By starting at the top of the triangle below and moving to adjacent numbers on the row below,
 * the maximum total from top to bottom is 23.
 *
 * 3
 * 7 4
 * 2 4 6
 * 8 5 9 3
 *
 * That is, 3 + 7 + 4 + 9 = 23.
 *
 * Find the maximum total from top to bottom of the triangle below:
 */
public class Problem018 implements Problem {
    public static final int[][] DATA = new int[][]{
        {75},
        {95, 64},
        {17, 47, 82},
        {18, 35, 87, 10},
        {20,  4, 82, 47, 65},
        {19,  1, 23, 75,  3, 34},
        {88,  2, 77, 73,  7, 63, 67},
        {99, 65,  4, 28,  6, 16, 70, 92},
        {41, 41, 26, 56, 83, 40, 80, 70, 33},
        {41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
        {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
        {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
        {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
        {63, 66,  4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
        { 4, 62, 98, 27, 23,  9, 70, 98, 73, 93, 38, 53, 60,  4, 23}
    };

    private final int[][] data;

    public Problem018() {
        this(DATA);
    }

    public Problem018(int[][] data) {
        this.data = data;
    }

    @Override
    public long solve() {
        Path[] paths = new Path[]{new Path(new int[]{0}, data[0][0])};

        for (int depth = 1; depth < data.length; depth++) {
            Path[] nextPaths = new Path[depth+1];

            for (int i = 0; i <= depth; i++) {
                if (i == 0) {
                    nextPaths[0] = Path.next(paths[0], 0, data[depth][0]);
                } else if (i == depth) {
                    nextPaths[depth] = Path.next(paths[depth-1], depth, data[depth][depth]);
                } else {
                    Path left = paths[i-1];
                    Path right = paths[i];
                    Path optimal = left.value > right.value ? left : right;

                    nextPaths[i] = Path.next(optimal, i, data[depth][i]);
                }
            }

            paths = nextPaths;
        }
        
        Path maximum = null;
        for (Path path : paths) {
            if (maximum == null || maximum.value < path.value) {
                maximum = path;
            }
        }

        return maximum.value;
    }

    private static class Path {
        public int[] indices;
        public long value;

        public Path(int[] indices, long sum) {
            this.indices = indices;
            this.value = sum;
        }

        public static Path next(Path prev, int index, int value) {
            int[] nextIndices = Arrays.copyOf(prev.indices, prev.indices.length+1);
            nextIndices[nextIndices.length-1] = index;

            return new Path(nextIndices, prev.value +value);
        }
    }
}
