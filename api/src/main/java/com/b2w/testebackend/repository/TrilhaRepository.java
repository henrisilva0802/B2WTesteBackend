package com.b2w.testebackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.b2w.testebackend.entity.Trilha;

@Repository
public interface TrilhaRepository extends JpaRepository<Trilha, Integer>{
	List<Trilha> findAllByOrderByDataAtualizacaoDesc();
}
