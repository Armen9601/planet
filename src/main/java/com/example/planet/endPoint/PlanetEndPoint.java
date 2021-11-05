package com.example.planet.endPoint;


import com.example.planet.dto.PlanetDto;
import com.example.planet.service.PlanetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/planet")
public class PlanetEndPoint {
    private final PlanetService planetService;

    @GetMapping
    public List<PlanetDto> getAll() {
        return planetService.findAll();
    }

    @GetMapping("/lord/{id}")
    public List<PlanetDto> getAllByLord(int id) {
        return planetService.getAllByLord(id);
    }

    @PostMapping
    public ResponseEntity<PlanetDto> add(@RequestBody PlanetDto planetDto) {
        return ResponseEntity.ok().body(planetService.add(planetDto));
    }

    @DeleteMapping("{id}")
    public void deleteUSer(@PathVariable("id") int id) {
        planetService.delete(id);
    }


}
