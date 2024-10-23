package com.example.student_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.student_api.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	Optional<Aluno> findByCpf(String cpf);
	
	void deleteByCpf(String cpf);
}
