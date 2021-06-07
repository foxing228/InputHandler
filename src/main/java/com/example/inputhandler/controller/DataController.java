package com.example.inputhandler.controller;

import com.example.inputhandler.dto.RequestDto;
import com.example.inputhandler.service.TextHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequestMapping("/text")
public class DataController {

    private TextHandlerService textHandlerService;

    @Autowired
    public DataController(TextHandlerService textHandlerService) {
        this.textHandlerService = textHandlerService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Long> getData(@RequestBody RequestDto requestDto) {
        if(requestDto.getText() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        String input = requestDto.getText();
        Map<String, Long> resp = textHandlerService.prepareResp(input);

        return resp;
    }
}
