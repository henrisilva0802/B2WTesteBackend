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

import com.b2w.testebackend.dto.CargoDto;
import com.b2w.testebackend.response.Response;
import com.b2w.testebackend.service.CargoService;

@Controller
@RequestMapping(value = "/api/cargo")
public class CargoController {

	@Autowired
	private CargoService cargoService;

	@GetMapping(value = "/findAll")
	public ResponseEntity<List<CargoDto>> findAll() {
		List<CargoDto> listCargosDto = cargoService.findAll();
		return ResponseEntity.status(200).body(listCargosDto);
	}

	@GetMapping(value = "/findAllByDateDesc")
	public ResponseEntity<List<CargoDto>> findAllByDate() {
		List<CargoDto> listCargosDto = cargoService.findAllByDateOrderned();
		return ResponseEntity.status(200).body(listCargosDto);
	}

	@GetMapping(value = "/findById/{id}")
	public ResponseEntity<CargoDto> findById(@PathVariable(name = "id") Integer id) {
		CargoDto cargoDto = cargoService.findById(id);
		return ResponseEntity.status(200).body(cargoDto);
	}

	@PostMapping(value = "/save")
	public ResponseEntity<Response> save(@RequestBody CargoDto cargoDto) {
		return ResponseEntity.status(200).body(cargoService.save(cargoDto));
	}

	@PutMapping(value = "/edit")
	public ResponseEntity<Response> edit(@RequestBody CargoDto cargoDto) {
		return ResponseEntity.status(200).body(cargoService.edit(cargoDto));
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Response> delete(@PathVariable Integer id) {
		return ResponseEntity.status(200).body(cargoService.delete(id));
	}

}
