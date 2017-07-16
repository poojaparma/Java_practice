package com.java.eight.feature;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * A new java.util.stream has been added in Java 8 to perform filter/map/reduce
 * like operations with the collection. Stream API will allow sequential as well
 * as parallel execution Streams are not meant to replace ArrayLists or other
 * collections. They are only meant to make manipulating the data easier and
 * faster. A stream is a one-time-use Object. Once it has been traversed, it
 * cannot be traversed again.
 * 
 * Streams have the ability to filter, map, and reduce while being traversed.
 * There are two "modes" for a stream: sequential and parallel. This is where
 * the ability of the stream to use the multicore processors of today comes into
 * play. It uses fork/join parallelism to split up the work and speed the
 * processing along. No storage. Streams don't have storage for values; they
 * carry values from a source (which could be a data structure, a generating
 * function, an I/O channel, etc) through a pipeline of computational steps.
 * Functional in nature. Operations on a stream produce a result, but do not
 * modify its underlying data source. Laziness-seeking. Many stream operations,
 * such as filtering, mapping, sorting, or duplicate removal) can be implemented
 * lazily. This facilitates efficient single-pass execution of entire pipelines,
 * as well as facilitating efficient implementation of short-circuiting
 * operations. Bounds optional. There are many problems that are sensible to
 * express as infinite streams, letting clients consume values until they are
 * satisfied. (If we were enumerating perfect numbers, it is easy to express
 * this as a filtering operation on the stream of all integers.) While a
 * Collection is constrained to be finite, a stream is not. (To terminate in
 * finite time, a stream pipeline with an infinite source can use
 * short-circuiting operations; alternately, you can request an Iterator from a
 * Stream and traverse it manually.) As an API, Streams is completely
 * independent from Collections. While it is easy to use a collection as the
 * source for a stream (Collection has stream() and parallelStream() methods) or
 * to dump the elements of a stream into a collection (using the collect()
 * operation as shown earlier), aggregates other than Collection can be used as
 * sources for streams as well. Many JDK classes, such as BufferedReader,
 * Random, and BitSet, have been retrofitted to act as sources for streams, and
 * Arrays.stream() provides stream view of arrays. In fact, anything that can be
 * described with an Iterator can be used as a stream source, though if more
 * information is available (such as size or metadata about stream contents like
 * "sortedness"), the library can provide an optimized execution. The Java 8
 * Streams can be seen as lazily constructed Collections, where the values are
 * computed when user demands for it. Actual Collections behave absolutely
 * opposite to it and they are set of eagerly computed values (no matter if the
 * user demands for a particular value or not).
 *
 */
public class StreamClass {

	public static void main(String[] args) {
		List<Integer> myList = new ArrayList<>();
		for (int i = 0; i < 100; i++)
			myList.add(i);

		// sequential stream
		Stream<Integer> sequentialStream = myList.stream();

		// parallel stream
		Stream<Integer> parallelStream = myList.parallelStream();

		// using lambda with Stream API, filter example
		Stream<Integer> highNums = parallelStream.filter((s) -> s > 80);
		// using lambda in forEach
		highNums.forEach(p -> System.out.println("High Nums parallel=" + p));

		Stream<Integer> highNumsSeq = sequentialStream.filter(p -> p > 80);
		highNumsSeq.forEach(p -> System.out.println("High Nums sequential=" + p));
	}
}
