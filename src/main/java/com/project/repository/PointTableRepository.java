package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.dto.PointTable;
@Repository
public interface PointTableRepository extends JpaRepository<PointTable, Integer>{
	
	@Query(value = "SELECT * FROM point_table ORDER BY points DESC;", nativeQuery = true)
	public List<PointTable> getPointTable_SQL();
}
