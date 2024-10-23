package com.example.student_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student_api.model.Aluno;
import com.example.student_api.repository.AlunoRepository;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

	@Autowired
	private AlunoRepository alunoRepository;

	@PostMapping
	public Aluno salvarAluno(@RequestBody Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	@DeleteMapping("/{cpf}")
	public ResponseEntity<Aluno> buscarAlunoPorCpf(@PathVariable String cpf) {
		Aluno aluno = alunoRepository.findByCpf(cpf);
		if (aluno != null) {
			return ResponseEntity.ok(aluno);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@GetMapping
	public ResponseEntity<Void> deletarAluno(@PathVariable String cpf) {
		Aluno aluno = alunoRepository.findByCpf(cpf);
		if (aluno != null) {
			alunoRepository.delete(aluno);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
