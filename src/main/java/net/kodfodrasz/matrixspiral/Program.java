package net.kodfodrasz.matrixspiral;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Program {

    public static void main(String[] args) {
        int[][] matrix = readMatrix(""
                + "1 2 3\n"
                + "8 9 4\n"
                + "7 6 5\n");
        int[] serialized = MatrixSpiral.spiral(matrix);
        printArray(serialized);
    }

    public static int[][] readMatrixFromStdin() {
        return readMatrix(System.in);
    }

    public static int[][] readMatrix(String str) {
        return readMatrix(new ByteArrayInputStream(str.getBytes())); // this is AIDS (StringInputStream is @Deprecated, because buggy. Don't fix it... 'cause of compat...)
    }

    public static int[][] readMatrix(InputStream in) {
        int[][] matrix;
        try (InputStreamReader reader = new InputStreamReader(in)) {
            try (BufferedReader br = new BufferedReader(reader)) {
                List<int[]> lines = new ArrayList<>();

                String line;
                while ((line = br.readLine()) != null ) {
                    if(line.trim().isEmpty()){
                        break;
                    }
                    
                    String[] tokens = line.split("[ \\t]+");
                    int[] intline = Stream.of(tokens)
                            .map(p -> p.trim())
                            .mapToInt(p -> Integer.parseInt(p)) // this is AIDS
                            .toArray();
                    lines.add(intline);
                }
                matrix = lines.toArray(new int[0][0]);
            }
        } catch (IOException ex) {
            Logger.getLogger(MatrixSpiral.class.getName()).log(Level.SEVERE, null, ex);
            matrix = null;
        }
        return matrix;
    }

    public static void printArray(int[] array) {
        List<String> ns = IntStream.of(array) // this is AIDS
                .mapToObj(i -> Integer.toString(i)) // this is AIDS
                .collect(Collectors.toList());
        System.out.println(String.join(" ", ns));
    }
}
