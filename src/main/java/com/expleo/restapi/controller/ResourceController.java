package com.expleo.restapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expleo.restapi.payload.ResourceDto;
import com.expleo.restapi.service.ResourceService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/resources")
@Tag(
		name="CRUD Rest APIs for Resource"
				)

public class ResourceController {
	
	private ResourceService resourceService;
	
	public ResourceController(ResourceService resourceService)
	{
		this.resourceService=resourceService;
	}
	
	
	@Operation(
			
		summary="Create Resource Rest API",
		description="Create Resource Rest API is used to save resource into database "
			
			)
	
	 
	@ApiResponse(
			
			responseCode = "201",
			description = "Http Status 201 Created"		
						)
	
	
	@PostMapping
	public ResponseEntity<ResourceDto> createResource(@Valid @RequestBody ResourceDto resourceDto)
	{
		return new ResponseEntity<>(resourceService.createResource(resourceDto),HttpStatus.CREATED);
	}
	
	
	@Operation(
			
			summary="Get Resource Rest API",
			description="Get Resource Rest API is used to get resources from database "
				
				)
		
		 
		@ApiResponse(
				
				responseCode = "200",
				description = "Http Status 200 SUCCESS"		
							)
		
	
	@GetMapping
	public List<ResourceDto> getAllResources()
	{
		return resourceService.getAllResources();
	}
	
	
     @Operation(
			
			summary="Get Resource By Id Rest API",
			description="Get Resource By Id Rest API is used to get single resource from database"
				
				)
		
		 
	@ApiResponse(
				
				responseCode = "200",
				description = "Http Status 200 SUCCESS"		
							)
	
	@GetMapping("/{id}")
	public ResponseEntity<ResourceDto> getResource(@PathVariable(name="id") long id)
	{
		return ResponseEntity.ok(resourceService.getResourceById(id));
	}
     
     
     @Operation(
 			
 			summary="Update Resource Rest API",
 			description="Update Resource Rest API is used to update resource in the database"
 				
 				)
 		
 		 
 	@ApiResponse(
 				
 				responseCode = "200",
 				description = "Http Status 200 SUCCESS"		
 							)
     

	@PutMapping("/{id}")
	public ResponseEntity<ResourceDto> updatePost(@Valid @RequestBody ResourceDto resourceDto, @PathVariable(name="id") long id)
	{
		ResourceDto response= resourceService.updateResource(resourceDto, id);
		return new ResponseEntity<>(response, HttpStatus.OK);
				
	}
     
     @Operation(
  			
  			summary="Delete Resource Rest API",
  			description="Delete Resource Rest API is used to  delete resource from database"
  				
  				)
  		
  		 
  	@ApiResponse(
  				
  				responseCode = "200",
  				description = "Http Status 200 SUCCESS"		
  							)
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteResource(@PathVariable(name="id") long id)
	{
		resourceService.deleteResource(id);
		return new ResponseEntity<>("Resource deleted successfully", HttpStatus.OK);
	}
}
	
