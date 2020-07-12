package com.b2w.testebackend.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b2w.testebackend.dto.CargoDto;
import com.b2w.testebackend.entity.Cargo;
import com.b2w.testebackend.entity.Trilha;
import com.b2w.testebackend.repository.CargoRepository;
import com.b2w.testebackend.response.Response;
import com.b2w.testebackend.response.TypeResponseEnum;
import com.b2w.testebackend.service.CargoService;
import com.b2w.testebackend.service.TrilhaService;

@Service
public class CargoServiceImpl implements CargoService {

	@Autowired
	private CargoRepository cargoRepository;

	@Autowired
	private TrilhaService trilhaService;

	@Override
	public List<CargoDto> findAll() {
		List<CargoDto> listCargosDto = buildDtoFromEntity(cargoRepository.findAll());
		return listCargosDto;
	}

	@Override
	public CargoDto findById(Integer id) {
		Optional<Cargo> cargo = cargoRepository.findById(id);
		return (cargo.isPresent()) ? buildDtoFromEntity(cargo.get()) : null;
	}

	@Override
	public Response save(CargoDto cargoDto) {
		try {
			if (cargoDto.getId() == null) {
				Cargo cargo = buildEntityFromDto(cargoDto);
				cargoRepository.save(cargo);
				return new Response(TypeResponseEnum.SUCESS.getValue(), "Cargo salvo com sucessos!");
			} else {
				return new Response(TypeResponseEnum.ERROR.getValue(),
						"ERRO: Você está tentando editar um cargo e não criá-lo!");
			}
		} catch (Exception e) {
			return new Response(TypeResponseEnum.ERROR.getValue(),
					"Não foi possível salvar o cargo! " + e.getMessage());
		}
	}

	@Override
	public Response edit(CargoDto cargoDto) {
		try {
			if (!(this.findById(cargoDto.getId()) == null)) {
				Cargo cargo = buildEntityFromDto(cargoDto);
				cargoRepository.save(cargo);
				return new Response(TypeResponseEnum.SUCESS.getValue(), "Cargo editado com sucessos!");
			} else {
				return new Response(TypeResponseEnum.ERROR.getValue(),
						"ERRO: Você está tentando editar um Cargo que não existe");
			}
		} catch (Exception e) {
			return new Response(TypeResponseEnum.ERROR.getValue(),
					"Não foi possível editar o cargo! " + e.getMessage());
		}
	}

	@Override
	public Response delete(Integer id) {
		try {
			Cargo cargo = cargoRepository.findById(id).get();
			cargoRepository.delete(cargo);
			return new Response(TypeResponseEnum.SUCESS.getValue(), "Cargo deletado com sucessos!");
		} catch (Exception e) {
			return new Response(TypeResponseEnum.ERROR.getValue(),
					"Não foi possível deletar o cargo! " + e.getMessage());
		}
	}

	@Override
	public List<CargoDto> findAllByDateOrderned() {
		List<CargoDto> listCargosDto = buildDtoFromEntity(cargoRepository.findAllByOrderByDataAtualizacaoDesc());
		return listCargosDto;
	}

	@Override
	public CargoDto buildDtoFromEntity(Cargo cargo) {
		CargoDto cargoDto = new CargoDto(cargo.getId(), cargo.getNome(), cargo.getTrilha().getId(), cargo.getMissao(),
				cargo.getDataAtualizacao());
		return cargoDto;
	}

	@Override
	public Cargo buildEntityFromDto(CargoDto cargoDto) {
		Trilha trilha = trilhaService.buildEntityFromDto(trilhaService.findById(cargoDto.getTrilhaId()));
		Date dataAtualizacao = new Date();
		Cargo cargo = new Cargo(cargoDto.getId(), cargoDto.getNome(), trilha, cargoDto.getMissao(), dataAtualizacao);
		return cargo;
	}

	@Override
	public List<CargoDto> buildDtoFromEntity(List<Cargo> listCargos) {
		List<CargoDto> listCargosDto = new ArrayList<>();
		listCargos.forEach(cargo -> {
			CargoDto cargoDto = new CargoDto(cargo.getId(), cargo.getNome(), cargo.getTrilha().getId(),
					cargo.getMissao(), cargo.getDataAtualizacao());
			listCargosDto.add(cargoDto);
		});
		return listCargosDto;
	}
}
