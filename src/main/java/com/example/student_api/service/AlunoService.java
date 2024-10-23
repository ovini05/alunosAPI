package com.example.student_api.service;

import org.springframework.stereotype.Service;

import com.example.student_api.model.Aluno;
import com.example.student_api.repository.AlunoRepository;

@Service
public class AlunoService {

	private final AlunoRepository alunoRepository;
	
	public AlunoService(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}

	public Aluno save(Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	public void deleteByCpf(String cpf) {
		alunoRepository.deleteByCpf(cpf);
	}

	public Aluno findByCpf(String cpf) {
		return alunoRepository.findByCpf(cpf)
				.orElseThrow(() -> new RuntimeException("Aluno não encontrado com o CPF: " + cpf));
	}

}