import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    public static void matrixRotation(List<List<Integer>> matrix, int r) {

        int m = matrix.size();
        int n = matrix.get(0).size();

        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {

            List<Integer> elements = new ArrayList<>();

            int top = layer;
            int left = layer;
            int bottom = m - 1 - layer;
            int right = n - 1 - layer;

            for (int j = left; j <= right; j++)
                elements.add(matrix.get(top).get(j));

            for (int i = top + 1; i < bottom; i++)
                elements.add(matrix.get(i).get(right));

            for (int j = right; j >= left; j--)
                elements.add(matrix.get(bottom).get(j));

            for (int i = bottom - 1; i > top; i--)
                elements.add(matrix.get(i).get(left));

            int len = elements.size();
            int rotate = r % len;
            int index = rotate;

            for (int j = left; j <= right; j++)
                matrix.get(top).set(j, elements.get(index++ % len));

            for (int i = top + 1; i < bottom; i++)
                matrix.get(i).set(right, elements.get(index++ % len));

            for (int j = right; j >= left; j--)
                matrix.get(bottom).set(j, elements.get(index++ % len));

            for (int i = bottom - 1; i > top; i--)
                matrix.get(i).set(left, elements.get(index++ % len));
        }

        for (List<Integer> row : matrix) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < row.size(); i++) {
                if (i > 0) sb.append(" ");
                sb.append(row.get(i));
            }
            System.out.println(sb.toString());
        }
    }
}

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] first = bufferedReader.readLine().trim().split(" ");

        int m = Integer.parseInt(first[0]);
        int n = Integer.parseInt(first[1]);
        int r = Integer.parseInt(first[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] row = bufferedReader.readLine().trim().split(" ");
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add(Integer.parseInt(row[j]));
            }
            matrix.add(list);
        }

        Result.matrixRotation(matrix, r);
    }
}
