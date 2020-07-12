package com.b2w.testebackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.b2w.testebackend.dto.TrilhaDto;
import com.b2w.testebackend.response.Response;
import com.b2w.testebackend.service.TrilhaService;

@Controller
@RequestMapping("/api/trilha")
public class TrilhaController {

	@Autowired
	private TrilhaService trilhaService;

	@GetMapping(value = "/findAll")
	public ResponseEntity<List<TrilhaDto>> findAll() {
		List<TrilhaDto> listTrilhasDto = trilhaService.findAll();
		return ResponseEntity.status(200).body(listTrilhasDto);
	}

	@GetMapping(value = "/findAllByDateDesc")
	public ResponseEntity<List<TrilhaDto>> findAllByDate() {
		List<TrilhaDto> listTrilhasDto = trilhaService.findAllByDateOrderned();
		return ResponseEntity.status(200).body(listTrilhasDto);
	}

	@GetMapping(value = "/findById/{id}")
	public ResponseEntity<TrilhaDto> findById(@PathVariable(name = "id") Integer id) {
		TrilhaDto trilhaDto = trilhaService.findById(id);
		return ResponseEntity.status(200).body(trilhaDto);
	}

	@PostMapping(value = "/save")
	public ResponseEntity<Response> save(@RequestBody TrilhaDto trilhaDto) {
		return ResponseEntity.status(200).body(trilhaService.save(trilhaDto));
	}

	@PutMapping(value = "/edit")
	public ResponseEntity<Response> edit(@RequestBody TrilhaDto trilhaDto) {
		return ResponseEntity.status(200).body(trilhaService.edit(trilhaDto));
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Response> delete(@PathVariable Integer id) {
		return ResponseEntity.status(200).body(trilhaService.delete(id));
	}
}
