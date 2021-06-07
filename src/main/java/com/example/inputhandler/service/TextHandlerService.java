package com.example.inputhandler.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@CacheConfig(cacheNames = "Data")
@Service
public class TextHandlerService {
    public Map<String, Long> countDuplicates(String input) {
        List<String> strings = Arrays.asList(input.split(" "));
        return strings.stream().collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum));
    }

    public Long countUnique(String input) {
        return Long.valueOf(Arrays.asList(input.split(" ")).stream().distinct().count());
    }

    @Cacheable(key = "#input")
    public Map<String, Long> prepareResp(String input) {
        System.out.println("non from cache");
        Map<String, Long> map = countDuplicates(input);
        map.put("UNIQUE", countUnique(input));
        return map;
    }
}
