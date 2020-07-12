package com.b2w.testebackend.service;

import java.util.List;

import com.b2w.testebackend.dto.TrilhaDto;
import com.b2w.testebackend.entity.Trilha;
import com.b2w.testebackend.response.Response;

public interface TrilhaService {

	public List<TrilhaDto> findAll();

	public TrilhaDto findById(Integer id);

	public Response save(TrilhaDto trilhaDto);

	public Response edit(TrilhaDto trilhaDto);

	public Response delete(Integer id);

	public List<TrilhaDto> findAllByDateOrderned();

	public TrilhaDto buildDtoFromEntity(Trilha trilha);

	public Trilha buildEntityFromDto(TrilhaDto trilhaDto);

	public List<TrilhaDto> buildDtoFromEntity(List<Trilha> listTrilhas);

}
