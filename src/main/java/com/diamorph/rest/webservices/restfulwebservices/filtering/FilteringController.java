package com.diamorph.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue filtering() {
        SomeBean someBean = new SomeBean("value1", "value2", "value3");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
        filterEntityProperties(mappingJacksonValue, Stream.of("field1").collect(Collectors.toSet()));
        return mappingJacksonValue;
    }

    @GetMapping("/filtering-list") // only field2
    public MappingJacksonValue filteringList() {
        List<SomeBean> list = Arrays.asList(
                new SomeBean("value1", "value2", "value3"),
                new SomeBean("value4", "value5", "value6")
        );
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
        filterEntityProperties(mappingJacksonValue, Stream.of("field2", "field3").collect(Collectors.toSet()));
        return mappingJacksonValue;
    }

    private static void filterEntityProperties(MappingJacksonValue mappingJacksonValue, Set<String> fieldList) {
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(fieldList);
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mappingJacksonValue.setFilters(filters);
    }
}
