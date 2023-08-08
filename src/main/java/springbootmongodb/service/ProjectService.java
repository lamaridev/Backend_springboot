package springbootmongodb.service;

import java.util.List;

import springbootmongodb.exception.TodoCollectionException;
import springbootmongodb.model.ProjectDTO;









public interface ProjectService 
{
	
	public List<ProjectDTO> getAllProject();
	public ProjectDTO getSingleProject(String id) throws TodoCollectionException;
	public void deleteProjectById(String id) throws TodoCollectionException;
	public void updateProject(String id, ProjectDTO todo) throws TodoCollectionException;
	public void createProject(ProjectDTO todo) throws TodoCollectionException;
	
	
}	

