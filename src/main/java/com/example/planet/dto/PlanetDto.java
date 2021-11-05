package com.example.planet.dto;

import com.example.planet.entity.Lord;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanetDto {

    private int id;
    private String title;
    private Lord lord;
}
