package com.example.planet.service;

import com.example.planet.dto.LordDto;

import java.util.List;

public interface LordService {

    LordDto add(LordDto lordDto);

    List<LordDto> findAllIdlers();

    List<LordDto> top10Young();

    List<LordDto> getAll();
}
