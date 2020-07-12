package com.b2w.testebackend.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b2w.testebackend.dto.TrilhaDto;
import com.b2w.testebackend.entity.Trilha;
import com.b2w.testebackend.repository.TrilhaRepository;
import com.b2w.testebackend.response.Response;
import com.b2w.testebackend.response.TypeResponseEnum;
import com.b2w.testebackend.service.TrilhaService;

@Service
public class TrilhaServiceImpl implements TrilhaService {

	@Autowired
	private TrilhaRepository trilhaRepository;

	@Override
	public List<TrilhaDto> findAll() {
		List<TrilhaDto> listTrilhasDto = buildDtoFromEntity(trilhaRepository.findAll());
		return listTrilhasDto;
	}

	@Override
	public TrilhaDto findById(Integer id) {
		Optional<Trilha> trilha = trilhaRepository.findById(id);
		return (trilha.isPresent()) ? buildDtoFromEntity(trilha.get()) : null;
	}

	@Override
	public Response save(TrilhaDto trilhaDto) {
		try {
			if (trilhaDto.getId() == null) {
				Trilha trilha = buildEntityFromDto(trilhaDto);
				trilhaRepository.save(trilha);
				return new Response(TypeResponseEnum.SUCESS.getValue(), "Trilha salva com sucessos!");
			} else {
				return new Response(TypeResponseEnum.ERROR.getValue(),
						"ERRO: Você está tentando editar uma trilha e não criá-lo!");
			}
		} catch (Exception e) {
			return new Response(TypeResponseEnum.ERROR.getValue(),
					"Não foi possível salvar o trilha! " + e.getMessage());
		}
	}

	@Override
	public Response edit(TrilhaDto trilhaDto) {
		try {
			if (!(this.findById(trilhaDto.getId()) == null)) {
				Trilha trilha = buildEntityFromDto(trilhaDto);
				trilhaRepository.save(trilha);
				return new Response(TypeResponseEnum.SUCESS.getValue(), "Trilha editada com sucessos!");
			} else {
				return new Response(TypeResponseEnum.ERROR.getValue(),
						"ERRO: Você está tentando editar uma Trilha que não existe");
			}
		} catch (Exception e) {
			return new Response(TypeResponseEnum.ERROR.getValue(),
					"Não foi possível editar a Trilha! " + e.getMessage());
		}
	}

	@Override
	public Response delete(Integer id) {
		try {
			Trilha trilha = trilhaRepository.findById(id).get();
			trilhaRepository.delete(trilha);
			return new Response(TypeResponseEnum.SUCESS.getValue(), "Trilha deletada com sucessos!");
		} catch (Exception e) {
			return new Response(TypeResponseEnum.ERROR.getValue(),
					"Não foi possível deletar a Trilha! " + e.getMessage());
		}
	}

	@Override
	public List<TrilhaDto> findAllByDateOrderned() {
		List<TrilhaDto> listTrilhasDto = buildDtoFromEntity(trilhaRepository.findAllByOrderByDataAtualizacaoDesc());
		return listTrilhasDto;
	}

	@Override
	public TrilhaDto buildDtoFromEntity(Trilha trilha) {
		TrilhaDto trilhaDto = new TrilhaDto(trilha.getId(), trilha.getNome(), trilha.getDiretoria(),
				trilha.getMissaoFormal(), trilha.getMissaoAlternativa(), trilha.getDataAtualizacao());
		return trilhaDto;
	}

	@Override
	public Trilha buildEntityFromDto(TrilhaDto trilhaDto) {
		Date dataAtualizacao = new Date();
		Trilha trilha = new Trilha(trilhaDto.getId(), trilhaDto.getNome(), trilhaDto.getDiretoria(),
				trilhaDto.getMissaoFormal(), trilhaDto.getMissaoAlternativa(), dataAtualizacao);
		return trilha;
	}

	@Override
	public List<TrilhaDto> buildDtoFromEntity(List<Trilha> listTrilhas) {
		List<TrilhaDto> listTrilhasDto = new ArrayList<>();
		listTrilhas.forEach(trilha -> {
			TrilhaDto trilhaDto = new TrilhaDto(trilha.getId(), trilha.getNome(), trilha.getDiretoria(),
					trilha.getMissaoFormal(), trilha.getMissaoAlternativa(), trilha.getDataAtualizacao());
			listTrilhasDto.add(trilhaDto);
		});
		return listTrilhasDto;
	}

}
