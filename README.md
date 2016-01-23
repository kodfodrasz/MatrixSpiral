# Traverse over a matrix in a spiral


There is a common interview question: Print the elements of a matrix in a spiral direction, clockwise, from out to in.

Example  traversal order:
~~~
1 2 3
8 9 4
7 6 5
~~~

## Why?

A friend of mine has mentioned this, boasting about his elegant solution in Clojure.
I thought: it is a simple problem! I don't understand all the hype. Let's do it Java.

With functional programming approach (thus using the Java 8 Streams API, and recursion) it will simple.

As it turned out: the problem was simple. The Java API was a pain. I have rewritten the code to be simpler, as I had to recognise once again, that Generics and Primitive types make these fun problems a pain in Java.
The other painful part was the random missing points in the API, (Cannot concatenate multiple streams. cannot reverse iterate/stream an array) which made me write a lot of boilerplate code.

Probably next time I'll stick to C# or F#.

## How

My idea was simple: 
 1. takes the first row
 2. then takes the last items of the inner rows, 
 3. then takes the last row (reversed), 
 4. then takes the inner rows (reversed) and their first items.
 5. repeat for remaining inner submatrix, if there is such

## License

The code is public domain. If you can learn from this, use it for your advantage. If you can somehow make profit from this, so be it!


