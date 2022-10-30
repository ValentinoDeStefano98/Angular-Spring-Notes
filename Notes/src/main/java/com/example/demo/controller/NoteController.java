package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Note;
import com.example.demo.repository.NoteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class NoteController {
	
	private NoteRepository noteRepository;

	public NoteController(NoteRepository noteRepository) {
		this.noteRepository = noteRepository;
	}
	
	@GetMapping("/notes")
	public List<Note> getNotes(){
		return (List<Note>) noteRepository.findAll();
	}
	
	@PostMapping("/notes")
	void addNote(@RequestBody Note note) {
		noteRepository.save(note);
	}
	
	@DeleteMapping("/notes/{id}")
	public ResponseEntity<HttpStatus> deleteNote(@PathVariable("id") long id){
		try {
			noteRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/notes")
	public ResponseEntity<HttpStatus> deleteAllNotes(){
		try {
			noteRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	/*
	@GetMapping("/notes")
	public ResponseEntity<List<Note>> getAllNotes(@RequestParam(required = false) String note){
		try {
			List<Note> notes = new ArrayList<Note>();
			
			if (note == null) {
				noteRepository.findAll().forEach(notes::add);
			} else {
				noteRepository.findByNote(note).forEach(notes::add);
			}
			
			if (notes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(notes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/notes/{id}")
	public ResponseEntity<Note> getNoteById(@PathVariable("id") long id){
		Optional<Note> noteData = noteRepository.findById(id);
		
		if(noteData.isPresent()) {
			return new ResponseEntity<>(noteData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/notes")
	public ResponseEntity<Note> createNote(@RequestBody Note note){
		try {
			Note _note = noteRepository.save( new Note(note.getNote(), null));
			return new ResponseEntity<>(_note, HttpStatus.CREATED);
		} catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/notes/{id}")
	public ResponseEntity<Note> updateNote(@PathVariable("id") long id, @RequestBody Note note){
		Optional<Note> noteData = noteRepository.findById(id);
		
		if (noteData.isPresent()) {
			Note _note = noteData.get();
			_note.setNote(note.getNote());
			return new ResponseEntity<>(noteRepository.save(note), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/notes/{id}")
	public ResponseEntity<HttpStatus> deleteNote(@PathVariable("id") long id){
		try {
			noteRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/notes")
	public ResponseEntity<HttpStatus> deleteAllNotes(){
		try {
			noteRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/
}

