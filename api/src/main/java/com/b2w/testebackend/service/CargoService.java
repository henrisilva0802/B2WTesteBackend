package com.b2w.testebackend.service;

import java.util.List;

import com.b2w.testebackend.dto.CargoDto;
import com.b2w.testebackend.entity.Cargo;
import com.b2w.testebackend.response.Response;

public interface CargoService {
	public List<CargoDto> findAll();

	public CargoDto findById(Integer id);

	public Response save(CargoDto cargoDto);

	public Response edit(CargoDto cargoDto);

	public Response delete(Integer id);

	public List<CargoDto> findAllByDateOrderned();

	public CargoDto buildDtoFromEntity(Cargo cargo);

	public Cargo buildEntityFromDto(CargoDto cargoDto);

	public List<CargoDto> buildDtoFromEntity(List<Cargo> listCargos);

}
