package com.example.demo.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Attachment;

import jakarta.transaction.Transactional;

@Repository
public interface AttachmentRepo extends JpaRepository<Attachment, String> {

	@Modifying
	@Transactional
	@Query(value="INSERT INTO file(filepath) VALUES(:filepath)",nativeQuery = true)
	int insertNewTableDetails(String filepath);

	}
