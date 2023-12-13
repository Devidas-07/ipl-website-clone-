package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.dto.PointTable;
@Repository
public interface PointTableRepository extends JpaRepository<PointTable, Integer>{

}
