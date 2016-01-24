package net.kodfodrasz.matrixspiral;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class MatrixSpiral {

    public static <T> T[] spiral(T[][] matrix) {
        IntFunction arrayAllocator =  i -> allocateGenericArray((Class<T[]>)matrix.getClass().getComponentType(), i);

        
        return (T[])spiral(matrix, Stream.empty()).toArray(arrayAllocator);
    }

    private static <T> Stream<T> spiral(T[][] matrix, Stream<T> head) {
        T[][] remainder = submatrix(matrix);
        Stream<T> visited = Stream.concat(head, Stream.of(edgeItemsClockwise(matrix)));

        if (remainder == null) {
            return visited;
        } else {
            return spiral(remainder, visited);
        }
    }

    public static <T> T[] edgeItemsClockwise(T[][] matrix) {
        IntFunction outerArrayAllocator = i -> allocateGenericArray((Class<T[][]>)matrix.getClass(), i);
        IntFunction innerArrayAllocator = i -> allocateGenericArray((Class<T[]>)matrix.getClass().getComponentType(), i);
        
        Supplier emptyArray = () -> (T[])innerArrayAllocator.apply(0);
        
        return (T[]) concatStreams( // this is AIDS 
                // first row
                Stream.of(Stream.of(matrix).findFirst().orElseGet(emptyArray)),
                // internal row -> { row[last] } 
                Stream.of(matrix).skip(1).limit(Math.max(0, matrix.length - 2))
                .flatMap(arr -> reverseStreamOfArray(arr).limit(1)),
                // last row, reversed
                reverseStreamOfArray(Stream.of(matrix).skip(Math.max(1, matrix.length - 1)).findFirst().orElseGet(emptyArray)),
                // reverse order of internal rows, then: internal row -> { row[first] if row has nultiple elements } 
                reverseStreamOfArray(Stream.of(matrix).skip(1).limit(Math.max(0, matrix.length - 2)).toArray(outerArrayAllocator))
                .flatMap(arr -> reverseStreamOfArray((T[])arr).skip(Math.max(1, ((T[])arr).length - 1)).limit(1))
        ).toArray(innerArrayAllocator);
    }

    public static <T> T[][] submatrix(T[][] matrix) {
        IntFunction outerArrayAllocator = i -> allocateGenericArray((Class<T[][]>)matrix.getClass(), i);
        IntFunction innerArrayAllocator = i -> allocateGenericArray((Class<T[]>)matrix.getClass().getComponentType(), i);
        
        T[][] result = (T[][])Stream.of(matrix)
                .skip(1)
                .limit(Math.max(0, matrix.length - 2))
                .map(arr -> (T[])Stream.of(arr).skip(1).limit(Math.max(0, arr.length - 2)).toArray(innerArrayAllocator))
                .filter(arr -> ((T[])arr).length != 0)
                .toArray(outerArrayAllocator);
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

    public static <E> E[] allocateGenericArray(Class<E[]> clazz, int length) {
        // AIDS intensifies!
        E[] a = (E[])clazz.cast(Array.newInstance(clazz.getComponentType(), length));  
        return a;
    } 
}
