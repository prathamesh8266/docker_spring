package com.example.docker.repository;

import com.example.docker.entity.DemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemoRepo extends JpaRepository<DemoEntity,Integer> {

}
