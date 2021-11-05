package com.example.planet.repository;

import com.example.planet.entity.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanetRepository extends JpaRepository<Planet, Integer> {

    List<Planet> findAllByLordId(int id);
}
