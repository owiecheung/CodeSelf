package com.vtxlab.demo.crypto.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.core.convert.converter.Converter;

// @Component
public class StringToListConverter implements Converter<String, List<String>> {

    // Spring's default WebDataBinder is configured to split parameters lists on commas.
    @Override
    public List<String> convert(String source) {
        return Arrays.asList(source.split(","));
    }

}
