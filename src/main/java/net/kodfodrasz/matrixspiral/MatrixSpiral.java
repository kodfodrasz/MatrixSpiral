package net.kodfodrasz.matrixspiral;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class MatrixSpiral {

    public static <T> List<T> spiral(List<List<T>> matrix) {
        return spiral(matrix, Stream.empty()).collect(Collectors.toList());
    }

    private static <T> Stream<T> spiral(List<List<T>> matrix, Stream<T> head) {
        List<List<T>> remainder = submatrix(matrix);
        Stream<T> visited = Stream.concat(head, edgeItemsClockwise(matrix).stream());

        if (remainder == null) {
            return visited;
        } else {
            return spiral(remainder, visited);
        }
    }

    public static <T> List<T> edgeItemsClockwise(List<List<T>> matrix) {
        return concatStreams( // this is AIDS 
                // first row
                matrix.stream().findFirst().orElseGet(ArrayList<T>::new).stream(),
                // internal row -> { row[last] } 
                matrix.stream().skip(1).limit(Math.max(0, matrix.size() - 2))
                .flatMap(arr -> reverseStream(arr.stream()).limit(1)),
                // last row, reversed
                reverseStream(matrix.stream().skip(Math.max(1, matrix.size() - 1)).findFirst().orElseGet(ArrayList<T>::new).stream()),
                // reverse order of internal rows, then: internal row -> { row[first] if row has nultiple elements } 
                reverseStream(matrix.stream().skip(1).limit(Math.max(0, matrix.size() - 2)).collect(Collectors.toList()).stream()
                .flatMap(arr -> reverseStream(arr.stream()).skip(Math.max(1, arr.size() - 1)).limit(1)))
        ).collect(Collectors.toList());
    }

    public static <T> List<List<T>> submatrix(List<List<T>> matrix) {
        List<List<T>> result = matrix.stream()
                .skip(1)
                .limit(Math.max(0, matrix.size() - 2))
                .map(arr -> arr.stream().skip(1).limit(Math.max(0, arr.size() - 2)).collect(Collectors.toList()))
                .filter(arr -> !arr.isEmpty())
                .collect(Collectors.toList());
        return result.size() > 0 ? result : null;
    }

    public static <T> Stream<T> reverseStream(Stream<T> arr) {
        ArrayDeque<T> a = arr.collect(Collectors.toCollection(ArrayDeque<T>::new));

        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(a.descendingIterator(), Spliterator.ORDERED), false);
    }

    public static <T> Stream<T> concatStreams(Stream<T>... streams) {
        return Stream.of(streams).reduce(Stream.empty(), (a, b) -> Stream.concat(a, b));
    }
}
