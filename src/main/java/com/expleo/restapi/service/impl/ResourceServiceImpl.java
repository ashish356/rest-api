package com.expleo.restapi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.expleo.restapi.entity.Resource;
import com.expleo.restapi.exception.ResourceNotFoundException;
import com.expleo.restapi.payload.ResourceDto;
import com.expleo.restapi.repository.ResourceRepository;
import com.expleo.restapi.service.ResourceService;

@Service
public class ResourceServiceImpl implements ResourceService{

	private ResourceRepository resourceRepository;
	
	
	public ResourceServiceImpl(ResourceRepository resourceRepository) {
		this.resourceRepository = resourceRepository;
	}


	@Override
	public ResourceDto createResource(ResourceDto resourceDto) {
	
		
		//Convert DTO to Entity
		Resource resource=DtoToEntity(resourceDto);
		Resource newResource=resourceRepository.save(resource);
		
		// Convert Entity to DTO
		ResourceDto response=entityToDto(newResource);
		
		return response;
		
	}


	@Override
	public List<ResourceDto> getAllResources() {
		
		List<Resource> resources=resourceRepository.findAll();
		return resources.stream().map(resource->entityToDto(resource)).collect(Collectors.toList());
		
	}
	
	@Override
	public ResourceDto getResourceById(long id) {
		
		Resource resource=resourceRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Resource", "id", id));
		return entityToDto(resource);
	}

	
	@Override
	public ResourceDto updateResource(ResourceDto resourceDto, long id) {
		
		Resource resource=resourceRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Resource", "id", id));
		
		resource.setName(resourceDto.getName());
		resource.setProject(resourceDto.getProject());
		
		Resource updatedResource=resourceRepository.save(resource);
		return entityToDto(updatedResource);
		
		
	}
	
	
	@Override
	public void deleteResource(long id) {
		
		Resource resource=resourceRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Resource", "id", id));
		resourceRepository.delete(resource);
	}
	
	
	private ResourceDto entityToDto(Resource resource)
	{
		ResourceDto resourceDto=new ResourceDto();
	    resourceDto.setId(resource.getId());
	    resourceDto.setName(resource.getName());
		resourceDto.setProject(resource.getProject());
		return resourceDto;
	}
	
	private Resource DtoToEntity(ResourceDto resourceDto)
	{
		Resource resource=new Resource();
		resource.setName(resourceDto.getName());
		resource.setProject(resourceDto.getProject());
		return resource;
	}


	


	

	
}


