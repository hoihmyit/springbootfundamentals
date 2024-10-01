package com.hm.springbootfundamentals.parameterizedtest;

import com.hm.springbootfundamentals.model.Student;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;

public class StudentAggregator implements ArgumentsAggregator {
    @Override
    public Object aggregateArguments(ArgumentsAccessor arguments, ParameterContext context) throws ArgumentsAggregationException {
        return new Student(arguments.getInteger(0), arguments.getString(1), arguments.getString(2));
    }
}
