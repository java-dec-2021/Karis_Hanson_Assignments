package com.karis.userproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.karis.userproject.models.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Long>{
	List<Project> findAll();
	List<Project> findAllByOrderByProjectNameAsc();
	List<Project> findDistinctByOrderByLikersDesc();
	
	@Query("SELECT p FROM Project p")
	List<Project> findAllProjects();
	
	@Query(value="SELECT * from projects", nativeQuery=true)
	List<Project> findAllprojectsNative();

}
