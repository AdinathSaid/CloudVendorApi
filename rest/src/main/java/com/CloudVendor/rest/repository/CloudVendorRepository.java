package com.CloudVendor.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CloudVendor.rest.model.CloudVendor;



public interface CloudVendorRepository extends JpaRepository<CloudVendor, String>{
		
}
