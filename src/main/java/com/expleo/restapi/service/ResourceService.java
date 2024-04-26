package com.expleo.restapi.service;

import java.util.List;

import com.expleo.restapi.payload.ResourceDto;

public interface ResourceService {
	
	ResourceDto createResource(ResourceDto resourceDto);
	
	List<ResourceDto> getAllResources();
	
	ResourceDto getResourceById(long Id);
	
	ResourceDto updateResource(ResourceDto resourceDto, long id);
	
	void deleteResource(long id);

}
