package com.example.planet.service;

import com.example.planet.dto.PlanetDto;

import java.util.List;

public interface PlanetService {

    PlanetDto add(PlanetDto planetDto);

    void delete(int id);

    List<PlanetDto> findAll();

    List<PlanetDto> getAllByLord(int id);
}
