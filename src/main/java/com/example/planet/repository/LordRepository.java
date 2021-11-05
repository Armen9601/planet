package com.example.planet.repository;

import com.example.planet.entity.Lord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LordRepository extends JpaRepository<Lord, Integer> {

    @Query(value = "select distinct l.* from lord l left join planet p on l.id=p.lord_id where p.id is null", nativeQuery = true)
    List<Lord> findAllIdlers();

    List<Lord> findTop10ByOrderByAgeAsc();

}
