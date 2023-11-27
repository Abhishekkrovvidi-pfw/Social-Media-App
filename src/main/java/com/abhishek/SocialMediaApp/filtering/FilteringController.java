package com.abhishek.SocialMediaApp.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {
    @GetMapping("/filter")
    public MappingJacksonValue filtering(){
        SomeBean someBean = new SomeBean("value1", "value1", "value1");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
       SimpleBeanPropertyFilter  filter =
               SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
        FilterProvider filters =
                new SimpleFilterProvider().addFilter("someBeanFilter",filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }
    @GetMapping("/filter-list")
    public MappingJacksonValue filteringList(){
        List<SomeBean> list = Arrays.asList(new SomeBean("value1","value1","value1"),new SomeBean("value3","value4","value5")) ;
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
        SimpleBeanPropertyFilter  filter =
                SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");
        FilterProvider filters =
                new SimpleFilterProvider().addFilter("someBeanFilter",filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }
}
