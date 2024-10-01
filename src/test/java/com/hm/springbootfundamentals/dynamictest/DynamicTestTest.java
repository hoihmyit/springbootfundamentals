package com.hm.springbootfundamentals.dynamictest;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DynamicTestTest {

    //Unlike @Test methods, a test factory is not itself a test method but a factory for test cases.
    //Test factory methods:
    // - cannot be private or static
    // - must return a Stream, Collection, Iterable, or Iterator of DynamicTest instances
    @TestFactory
    Stream<DynamicTest> test() {
        return Stream.of("Apple", "Banana", "Orange")
                .map(fruit -> DynamicTest.dynamicTest("Test " + fruit, () -> System.out.println("Test " + fruit)));
        //Test Apple
        //Test Banana
        //Test Orange
    }

    @TestFactory
    Stream<DynamicTest> test2() {
        return IntStream.iterate(0, n -> n + 2).limit(3)
                .mapToObj(n -> DynamicTest.dynamicTest("Test " + n, () -> System.out.println("Test " + n)));
        //Test 0
        //Test 2
        //Test 4
    }
}
