package com.example.demo.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Note;
import com.example.demo.model.User;

import java.util.List;

public interface NoteRepository extends CrudRepository<Note, Long>, JpaRepository<Note, Long>{
	
	List<Note> findByUser(User user, Sort sort);


}
