package com.karis.userproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karis.userproject.repositories.ProjectRepository;
import com.karis.userproject.models.Project;
import com.karis.userproject.models.User;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepo;
	
	//List All projects
	public List<Project> allProjects(){
		return projectRepo.findAllByOrderByProjectNameAsc();
//		return projectRepo.findAll();
	}
	
	//Create new project
	public Project createProject(Project project) {
		return projectRepo.save(project);
	}
	
	//Delete a project
	public void deleteProject(Long id) {
		projectRepo.deleteById(id);
	}
	
	//Get One Project 
	public Project getOneProject(Long id) {
		return projectRepo.findById(id).orElse(null);
	}
	
	//Update Project
	public Project updateProject(Long id, String name, String description) {
		Project project = getOneProject(id);
		project.setProjectName(name);
		project.setDescription(description);
		return projectRepo.save(project);
	}
	
	//Like a project
	public void likeProject(Project project, User user) {
		List<User> likers = project.getLikers();
		likers.add(user);
		projectRepo.save(project);
	}
	
	//Unlike a project
	public void unLikeProject(Project project, User user) {
		List<User> likers = project.getLikers();
		likers.remove(user);
		projectRepo.save(project);
	}
}
