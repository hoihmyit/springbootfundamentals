package com.hm.springbootfundamentals.parameterizedtest;

import com.hm.springbootfundamentals.model.Student;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.assertEquals;

public class StudentTest {

    /**
     * The @CsvSource annotation in JUnit 5 provides an ArgumentsSource which reads comma-separated values from a string.
     */

    @ParameterizedTest(name = "Test getId Person[{0}, {1}, {2}]")
    @CsvSource({"1, John, Math"})
    void testGetId(@AggregateWith(StudentAggregator.class) Student student) {
        assertEquals(1, student.getId());
    }

    @ParameterizedTest(name = "Test getId Person[{0}, {1}, {2}]")
    @CsvSource({"1, John, Math"})
    void testGetName(@AggregateWith(StudentAggregator.class) Student student) {
        assertEquals("John", student.getName());
    }

    @ParameterizedTest(name = "Test getId Person[{0}, {1}, {2}]")
    @CsvSource({"1, John, Math"})
    void testGetCourse(@AggregateWith(StudentAggregator.class) Student student) {
        assertEquals("Math", student.getCourse());
    }
}
