package com.example.student_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.student_api.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	Aluno findByCpf(String cpf);
}
