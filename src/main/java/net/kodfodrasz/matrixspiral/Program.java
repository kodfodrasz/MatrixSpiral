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
        List<List<Integer>> matrix = readMatrix(""
                + "1 2 3\n"
                + "8 9 4\n"
                + "7 6 5\n");
        List<Integer> serialized = MatrixSpiral.spiral(matrix);
        printList(serialized);
    }

    public static List<List<Integer>> readMatrixFromStdin() {
        return readMatrix(System.in);
    }

    public static List<List<Integer>> readMatrix(String str) {
        return readMatrix(new ByteArrayInputStream(str.getBytes())); // this is AIDS (StringInputStream is @Deprecated, because buggy. Don't fix it... 'cause of compat...)
    }

    public static List<List<Integer>> readMatrix(InputStream in) {
        List<List<Integer>> matrix;
        try (InputStreamReader reader = new InputStreamReader(in)) {
            try (BufferedReader br = new BufferedReader(reader)) {
                List<List<Integer>> lines = new ArrayList<>();

                String line;
                while ((line = br.readLine()) != null ) {
                    if(line.trim().isEmpty()){
                        break;
                    }
                    
                    String[] tokens = line.split("[ \\t]+");
                    List<Integer> intline = Stream.of(tokens)
                            .map(p -> p.trim())
                            .map(p -> Integer.parseInt(p)) // this is AIDS
                            .collect(Collectors.toList());
                    lines.add(intline);
                }
                matrix = lines;
            }
        } catch (IOException ex) {
            Logger.getLogger(MatrixSpiral.class.getName()).log(Level.SEVERE, null, ex);
            matrix = null;
        }
        return matrix;
    }

    public static <T> void printList(List<T> list) {
        List<String> ns = list.stream() // this is AIDS
                .map(i -> i.toString()) // this is AIDS
                .collect(Collectors.toList());
        System.out.println(String.join(" ", ns));
    }
}
