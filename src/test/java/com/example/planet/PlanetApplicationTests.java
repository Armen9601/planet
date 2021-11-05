package com.example.planet;

import com.example.planet.entity.Lord;
import com.example.planet.entity.Planet;
import com.example.planet.repository.LordRepository;
import com.example.planet.repository.PlanetRepository;
import com.example.planet.service.serviceImpl.LordServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
@AutoConfigureTestEntityManager
class PlanetApplicationTests {

    @InjectMocks
    private LordServiceImpl lordService;
    @Mock
    private LordRepository lordrepository;
    @Mock
    private PlanetRepository planetRepository;
    @Spy
    private ModelMapper mapper;

    @Before
    public void init() {
        lordService = new LordServiceImpl(lordrepository, mapper);
    }


    @Test
    void size() {
        List<Lord> poxos = List.of(new Lord(1, "poxos", 99));
        when(lordrepository.findAllIdlers()).thenReturn(poxos);
        Assertions.assertEquals(lordService.findAllIdlers().size(), poxos.size());
    }


    @Test
    public void test_add_Lord() {
        Lord lord = new Lord(1, "some name", 88);
        lordrepository.save(lord);
        verify(lordrepository, times(1)).save(mapper.map(lord, Lord.class));
    }

    @Test
    public void should_delete_planet_by_id() {
        Planet planet = new Planet(1, "title", null);
        Planet planet1 = new Planet(2, "title1", null);
        Planet planet2 = new Planet(3, "title2", null);
        when(planetRepository.findById(planet.getId())).thenReturn(Optional.of(planet));
        planetRepository.deleteById(planet.getId());
        verify(planetRepository).deleteById(planet.getId());
    }

    @Test
    public void listAll_Idlers_Lords(){
        Lord lord2 = new Lord(3, "some name2", 90);
        Lord lord = new Lord(1, "some name", 88);
        Lord lord1 = new Lord(2, "some name1", 89);
        Planet planet = new Planet(1, "title", lord);
        Planet planet1 = new Planet(2, "title1", lord1);
        lordrepository.save(lord);
        lordrepository.save(lord1);
        lordrepository.save(lord2);
        planetRepository.save(planet);
        planetRepository.save(planet1);
        Assertions.assertNotNull(lordrepository.findAllIdlers());
    }

    @Test
    public void findAllPLanets() {
        Planet planet = new Planet(1, "title", null);
        planetRepository.save(planet);
        Assertions.assertNotNull(planetRepository.findAll());
    }

}



