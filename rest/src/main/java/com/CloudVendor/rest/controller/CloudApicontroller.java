package com.CloudVendor.rest.controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CloudVendor.rest.model.CloudVendor;
import com.CloudVendor.rest.service.CloudVendorService;

@RestController
@RequestMapping("/cloudvendor")
public class CloudApicontroller {
	
	CloudVendorService cloudVendorService;
	
	public CloudApicontroller(CloudVendorService cloudVendorService) {
		super();
		this.cloudVendorService = cloudVendorService;
	}

	@GetMapping("{vendorId}")
	public CloudVendor getCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
		return cloudVendorService.getCloudVendor(vendorId);
	}
	
	@GetMapping()
	public List<CloudVendor> getAllCloudVendorDetails() {
		return cloudVendorService.getAllCloudVendor();
	}
	
	@PostMapping
	public String createCloudVendorDetails(@RequestBody CloudVendor cloudvendor) {
		cloudVendorService.createCloudVendor(cloudvendor);
		return "Vendor created Succesfully";
	}
	
	@PutMapping
	public String updateCloudVendorDetails(@RequestBody CloudVendor cloudvendor) {
		cloudVendorService.updateCloudVendor(cloudvendor);
		return "Cloud Vendor updated successfully";
	}
	
	@DeleteMapping("{vendorId}")
	public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
		cloudVendorService.deleteCloudVendor(vendorId);	
		return "Cloud Vendor deleted successfully";
	}
}
