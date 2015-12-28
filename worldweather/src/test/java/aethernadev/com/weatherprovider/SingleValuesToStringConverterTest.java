package aethernadev.com.weatherprovider;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import aethernadev.com.weatherprovider.mapper.SingleValuesToStringConverter;
import aethernadev.com.weatherprovider.model.searchlocation.ResponseLocation;

import static com.google.common.truth.Truth.*;

/**
 * Created by Aetherna on 2015-12-27.
 */
public class SingleValuesToStringConverterTest {

    SingleValuesToStringConverter testObject;

    @Before
    public void setUp() throws Exception {
        testObject = new SingleValuesToStringConverter();
    }

    @Test
    public void shouldReturnEmptyStringOnNullList() {
        //having
        List<ResponseLocation.SingleValue> nullSingleValues = null;
        //when
        String result = testObject.convertToString(nullSingleValues);
        //then
        assertThat(result).isEmpty();
    }

    @Test
    public void shouldReturnEmptyStringOnEmptyList() {
        //having
        List<ResponseLocation.SingleValue> empty = new ArrayList<>();
        //when
        String result = testObject.convertToString(empty);
        //then
        assertThat(result).isEmpty();
    }

    @Test
    public void shouldReturnEmptyStringOnNullFirstElement() {
        //having
        List<ResponseLocation.SingleValue> values = new ArrayList<>();
        values.add(null);
        //when
        String result = testObject.convertToString(values);
        //then
        assertThat(result).isEmpty();
    }

    @Test
    public void shouldReturnEmptyStringOnFirstElementNullValue() {
        //having
        List<ResponseLocation.SingleValue> values = new ArrayList<>();
        ResponseLocation.SingleValue nullValued = new ResponseLocation.SingleValue();
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
        ResponseLocation.SingleValue firstSingleValue = new ResponseLocation.SingleValue();
        firstSingleValue.setValue("London");

        ResponseLocation.SingleValue secondSingleValue = new ResponseLocation.SingleValue();
        secondSingleValue.setValue("Warsaw");

        List<ResponseLocation.SingleValue> values = new ArrayList<>();
        values.add(firstSingleValue);
        values.add(secondSingleValue);

        //when
        String result = testObject.convertToString(values);
        //then
        assertThat(result).isEqualTo("London");
    }
}
