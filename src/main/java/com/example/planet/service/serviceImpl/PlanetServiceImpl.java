package com.example.planet.service.serviceImpl;

import com.example.planet.dto.PlanetDto;
import com.example.planet.entity.Planet;
import com.example.planet.repository.PlanetRepository;
import com.example.planet.service.PlanetService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlanetServiceImpl implements PlanetService {

    private final PlanetRepository planetRepository;
    private final ModelMapper mapper;


    @Override
    public PlanetDto add(PlanetDto planetDto) {
        Planet planet = planetRepository.save(mapper.map(planetDto, Planet.class));
        return mapper.map(planet,PlanetDto.class);
    }

    @Override
    public void delete(int id) {
        planetRepository.deleteById(id);
    }

    @Override
    public List<PlanetDto> findAll() {
        return planetRepository.findAll().stream().map(p -> mapper.map(p, PlanetDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<PlanetDto> getAllByLord(int id) {
        return planetRepository.findAllByLordId(id).stream().map(p -> mapper.map(p, PlanetDto.class)).collect(Collectors.toList());
    }
}
