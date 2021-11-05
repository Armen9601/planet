package com.example.planet.service.serviceImpl;

import com.example.planet.dto.LordDto;
import com.example.planet.entity.Lord;
import com.example.planet.repository.LordRepository;
import com.example.planet.service.LordService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LordServiceImpl implements LordService {

    private final LordRepository lordRepository;
    private final ModelMapper mapper;

    @Override
    public LordDto add(LordDto lord) {
        Lord saved = lordRepository.save(mapper.map(lord, Lord.class));
        return mapper.map(saved, LordDto.class);
    }

    @Override
    public List<LordDto> findAllIdlers() {
        return lordRepository.findAllIdlers().stream().map(l -> mapper.map(l, LordDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<LordDto> top10Young() {
        return lordRepository.findTop10ByOrderByAgeAsc().stream().map(l -> mapper.map(l, LordDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<LordDto> getAll() {
        return lordRepository.findAll().stream().map(l -> mapper.map(l, LordDto.class)).collect(Collectors.toList());
    }

}
