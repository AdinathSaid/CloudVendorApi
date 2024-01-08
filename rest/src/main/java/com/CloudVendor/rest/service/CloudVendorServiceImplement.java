package com.CloudVendor.rest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.CloudVendor.rest.exceptions.CloudVendorNotFoundException;
import com.CloudVendor.rest.model.CloudVendor;
import com.CloudVendor.rest.repository.CloudVendorRepository;
@Service
public class CloudVendorServiceImplement implements CloudVendorService{
	CloudVendorRepository cloudVendorRepository;
	
	public CloudVendorServiceImplement(CloudVendorRepository cloudVendorRepository) {
		this.cloudVendorRepository = cloudVendorRepository;
	}
	
	
	@Override
	public String createCloudVendor(CloudVendor cloudvendor) {
		cloudVendorRepository.save(cloudvendor);
		return "Vendor details saved successfully.";
	}
	
	@Override
	public String deleteCloudVendor(String vendorId) {
		cloudVendorRepository.deleteById(vendorId);
		return "deleted succesfully";
	}
	
	@Override
	public List<CloudVendor> getAllCloudVendor() {
		
		return cloudVendorRepository.findAll();
	}
	
	
	@Override
	public CloudVendor getCloudVendor(String cloudVendorId) {
		if(cloudVendorRepository.findById(cloudVendorId).isEmpty()){
			throw new CloudVendorNotFoundException("Vendor doesnot exist");
		}
		return cloudVendorRepository.findById(cloudVendorId).get();
	}
	
	
	@Override
	public String updateCloudVendor(CloudVendor cloudvendor) {
		cloudVendorRepository.save(cloudvendor);
		return "Details updated";
	}

}
