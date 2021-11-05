package com.example.planet.endPoint;


import com.example.planet.dto.LordDto;
import com.example.planet.service.LordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/lord")
public class LordEndPoint {

    private final LordService lordService;

    @PostMapping
    public ResponseEntity<LordDto> add(@RequestBody LordDto lordDto) {
        return ResponseEntity.ok().body(lordService.add(lordDto));
    }

    @GetMapping("/empty-lords")
    public List<LordDto> allIdlers() {
        return lordService.findAllIdlers();
    }

    @GetMapping
    public List<LordDto> getTopTen() {
        return lordService.top10Young();
    }

    @GetMapping("/all")
    public List<LordDto> getAll() {
        return lordService.getAll();
    }

}
