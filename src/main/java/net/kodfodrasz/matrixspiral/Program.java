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
import java.util.stream.Stream;

public class Program {

    public static void main(String[] args) {
        Integer[][] matrix = readMatrix(""
                + "1 2 3\n"
                + "8 9 4\n"
                + "7 6 5\n");
        Integer[] serialized = MatrixSpiral.spiral(matrix);
        printArray(serialized);
    }

    public static Integer[][] readMatrixFromStdin() {
        return readMatrix(System.in);
    }

    public static Integer[][] readMatrix(String str) {
        return readMatrix(new ByteArrayInputStream(str.getBytes())); // this is AIDS (StringInputStream is @Deprecated, because buggy. Don't fix it... 'cause of compat...)
    }

    public static Integer[][] readMatrix(InputStream in) {
        Integer[][] matrix;
        try (InputStreamReader reader = new InputStreamReader(in)) {
            try (BufferedReader br = new BufferedReader(reader)) {
                List<Integer[]> lines = new ArrayList<>();

                String line;
                while ((line = br.readLine()) != null ) {
                    if(line.trim().isEmpty()){
                        break;
                    }
                    
                    String[] tokens = line.split("[ \\t]+");
                    Integer[] intline = Stream.of(tokens)
                            .map(p -> p.trim())
                            .map(p -> Integer.parseInt(p)) // this is AIDS
                            .toArray(Integer[]::new);
                    lines.add(intline);
                }
                matrix = lines.toArray(new Integer[0][0]);
            }
        } catch (IOException ex) {
            Logger.getLogger(MatrixSpiral.class.getName()).log(Level.SEVERE, null, ex);
            matrix = null;
        }
        return matrix;
    }

    public static <T> void printArray(T[] array) {
        List<String> ns = Stream.of(array) // this is AIDS
                .map(i -> i.toString()) // this is AIDS
                .collect(Collectors.toList());
        System.out.println(String.join(" ", ns));
    }
}
