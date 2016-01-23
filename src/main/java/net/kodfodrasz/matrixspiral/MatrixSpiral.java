package net.kodfodrasz.matrixspiral;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class MatrixSpiral {

    public static Integer[] spiral(Integer[][] matrix) {
        return spiral(matrix, Stream.empty()).toArray(Integer[]::new);
    }

    private static Stream<Integer> spiral(Integer[][] matrix, Stream<Integer> head) {
        Integer[][] remainder = submatrix(matrix);
        Stream<Integer> visited = Stream.concat(head, Stream.of(edgeItemsClockwise(matrix)));

        if (remainder == null) {
            return visited;
        } else {
            return spiral(remainder, visited);
        }
    }

    public static Integer[] edgeItemsClockwise(Integer[][] matrix) {
        return concatStreams( // this is AIDS 
                // first row
                Stream.of(Stream.of(matrix).findFirst().orElse(new Integer[0])),
                // internal row -> { row[last] } 
                Stream.of(matrix).skip(1).limit(Math.max(0, matrix.length - 2))
                .flatMap(arr -> reverseStreamOfArray(arr).limit(1)),
                // last row, reversed
                reverseStreamOfArray(Stream.of(matrix).skip(Math.max(1, matrix.length - 1)).findFirst().orElse(new Integer[0])),
                // reverse order of internal rows, then: internal row -> { row[first] if row has nultiple elements } 
                reverseStreamOfArray(Stream.of(matrix).skip(1).limit(Math.max(0, matrix.length - 2)).toArray(Integer[][]::new))
                .flatMap(arr -> reverseStreamOfArray(arr).skip(Math.max(1, arr.length - 1)).limit(1))
        ).toArray(Integer[]::new);
    }

    public static Integer[][] submatrix(Integer[][] matrix) {
        Integer[][] result = Stream.of(matrix)
                .skip(1)
                .limit(Math.max(0, matrix.length - 2))
                .map(arr -> Stream.of(arr).skip(1).limit(Math.max(0, arr.length - 2)).toArray(Integer[]::new))
                .filter(arr -> arr.length != 0)
                .toArray(Integer[][]::new);
        return result.length > 0 ? result : null;
    }

    public static <T> Stream<T> reverseStreamOfArray(T[] arr) {
        Iterator<T> reverseIntArrayIterator = new Iterator<T>() {
            int idx = arr.length;

            @Override
            public boolean hasNext() {
                return 0 < idx;
            }

            @Override
            public T next() {
                return arr[--idx];
            }
        };

        return StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(reverseIntArrayIterator, Spliterator.ORDERED), false);
    }

    public static <T> Stream<T> concatStreams(Stream<T>... streams) {
        return Stream.of(streams).reduce(Stream.empty(), (a, b) -> Stream.concat(a, b));
    }

}
