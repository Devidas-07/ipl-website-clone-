package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.CskPlayers;
import com.project.repository.CskPlayersRepository;

@Service
public class CskPlayersService {
	@Autowired
	CskPlayersRepository repository;
	
	/*public void saveCskPlayers(CskPlayers players) {
		repository.save(players);
	}
	public void saveImage(String imageUrl) {
		CskPlayers imageEntity = new CskPlayers();
		imageEntity.setImg(imageUrl);
		repository.save(imageEntity);
	}
	*/
	public List<CskPlayers> getCskPlayers(){
		List<CskPlayers> list= repository.findAll();
		
		return list;
	}
	public CskPlayers getCskPlayerById(int id) {
		return repository.findById(id).get();
	}
	public void deletePlayerById(int id) {
		repository.deleteById(id);
	}
	/*
	private String saveImageToFileStorage(MultipartFile imageFile) {
	    String uploadDirectory = "C:\\FSD24APR\\JAVA\\Java Program\\SPRING BOOT\\ipl-website-clone\\src\\main\\resources\\static\\Images";

	    try {
	        // Generate a unique filename for the uploaded image
	        String filename = UUID.randomUUID().toString() + "_" + imageFile.getOriginalFilename();

	        // Save the image to the specified directory
	        Path filePath = Paths.get(uploadDirectory, filename);
	        Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

	        // Return the URL to access the saved image
	        return "/images/" + filename;
	    } catch (IOException e) {
	        e.printStackTrace();
	        // Handle the exception appropriately (e.g., logging, returning an error message)
	        return null;
	    }
	}
	*/
	/*
	public void saveCskPlayers(CskPlayers player, MultipartFile imageFile) {
		String imageUrl = saveImageToFileStorage(imageFile);
		player.setImg(imageUrl);
		repository.save(player);
	}
	*/
	public void saveCskPlayers(CskPlayers player) {
		repository.save(player);
	}
	
	
	
}
