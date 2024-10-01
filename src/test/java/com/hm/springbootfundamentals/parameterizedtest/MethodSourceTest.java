package com.hm.springbootfundamentals.parameterizedtest;

import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.Assert.assertEquals;

public class MethodSourceTest {

    @Before

    private static String[] getFruits() {
        return new String[]{"Apple", "Banana", "Orange"};
    }

    private static Object[] getObject() {
        return new Object[][]{
                {1, "John", "Math"},
                {2, "Jane", "Science"},
                {3, "Doe", "History"}
        };
    }

    @ParameterizedTest(name = "Test {index}: test getFruits fruit{0}")
    @MethodSource("getFruits")
    void methodSourceTest1(String fruit) {
        System.out.println("methodSourceTest1: fruit=" + fruit);
        //methodSourceTest1: fruit=Apple
        //methodSourceTest1: fruit=Banana
        //methodSourceTest1: fruit=Orange
    }

    @ParameterizedTest(name = "Test {index}: test getObject id{0}, name{1}, course{2}")
    @MethodSource("getObject")
    void methodSourceTest2(int id, String name, String course) {
        System.out.println("methodSourceTest2: id=" + id + ", name=" + name + ", course=" + course);
        //methodSourceTest2: id=1, name=John, course=Math
        //methodSourceTest2: id=2, name=Jane, course=Science
        //methodSourceTest2: id=3, name=Doe, course=History
    }

    // More argument sources:
    //@TestInstance(TestInstance.Lifecycle.PER_METHOD) // the default - creates a new instance of the test class for every test
    //@TestInstance(TestInstance.Lifecycle.PER_CLASS) // re-uses the same instance for every tests

    @RepeatedTest(value = 2)
    void test(RepetitionInfo repetitionInfo) {
        System.out.println("Current repetition: " + repetitionInfo.getCurrentRepetition());
        System.out.println("Total repetitions: " + repetitionInfo.getTotalRepetitions());
        //Current repetition: 1
        //Total repetitions: 2
        //Current repetition: 2
        //Total repetitions: 2
        assertEquals(2, repetitionInfo.getTotalRepetitions());
    }
}
