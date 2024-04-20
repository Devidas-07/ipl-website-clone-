package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.PointTable;
import com.project.repository.PointTableRepository;

@Service
public class PointTableService {
	public PointTableService() {
		System.out.println("obj created");
	}
@Autowired
PointTableRepository repo;
	public List<PointTable> getPointTable(){
		List<PointTable> list= repo.getPointTable_SQL();
			
		return list;
	}
	public void updatePointTable(PointTable point) {
		repo.save(point);
	}
	public PointTable getPointTableById(int id) {
		return repo.findById(id).get();
	}
	
	
}
