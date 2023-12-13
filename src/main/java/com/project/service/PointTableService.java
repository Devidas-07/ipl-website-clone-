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
		List<PointTable> list= repo.findAll();
			/*for(PointTable p: list) {
				
				System.out.println(p.getTeam());
			}
			if(list==null) {
				System.out.println("list is null");
			}
			else {
				System.out.println("list is not null");
			}*/
		return list;
	}
	
	
	
}
