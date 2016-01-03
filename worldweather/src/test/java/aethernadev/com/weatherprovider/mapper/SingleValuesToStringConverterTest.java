package aethernadev.com.weatherprovider.mapper;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import aethernadev.com.weatherprovider.model.SingleValue;
import aethernadev.com.weatherprovider.model.searchlocation.ResponseLocation;

import static com.google.common.truth.Truth.*;

/**
 * Created by Aetherna on 2015-12-27.
 */
public class SingleValuesToStringConverterTest {

    SingleValueToString testObject;

    @Before
    public void setUp() throws Exception {
        testObject = new SingleValueToString();
    }

    @Test
    public void shouldReturnEmptyStringOnNullList() {
        //having
        List<SingleValue> nullSingleValues = null;
        //when
        String result = testObject.convertToString(nullSingleValues);
        //then
        assertThat(result).isEmpty();
    }

    @Test
    public void shouldReturnEmptyStringOnEmptyList() {
        //having
        List< SingleValue> empty = new ArrayList<>();
        //when
        String result = testObject.convertToString(empty);
        //then
        assertThat(result).isEmpty();
    }

    @Test
    public void shouldReturnEmptyStringOnNullFirstElement() {
        //having
        List< SingleValue> values = new ArrayList<>();
        values.add(null);
        //when
        String result = testObject.convertToString(values);
        //then
        assertThat(result).isEmpty();
    }

    @Test
    public void shouldReturnEmptyStringOnFirstElementNullValue() {
        //having
        List< SingleValue> values = new ArrayList<>();
         SingleValue nullValued = new SingleValue();
        nullValued.setValue(null);
        values.add(nullValued);
        //when
        String result = testObject.convertToString(values);
        //then
        assertThat(result).isEmpty();
    }

    @Test
    public void shouldReturnValueFromFirstElement(){
        //having
        SingleValue firstSingleValue = new SingleValue();
        firstSingleValue.setValue("London");

        SingleValue secondSingleValue = new SingleValue();
        secondSingleValue.setValue("Warsaw");

        List<SingleValue> values = new ArrayList<>();
        values.add(firstSingleValue);
        values.add(secondSingleValue);

        //when
        String result = testObject.convertToString(values);
        //then
        assertThat(result).isEqualTo("London");
    }
}
