package com.example.student_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student_api.model.Aluno;
import com.example.student_api.model.ApiResponse;
import com.example.student_api.service.AlunoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Aluno>> salvarAluno(@Valid @RequestBody Aluno aluno) {
        Aluno savedAluno = alunoService.save(aluno);
        return ResponseEntity.ok(new ApiResponse<>("Aluno salvo com sucesso!", savedAluno));
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<ApiResponse<Aluno>> buscarAlunoPorCpf(@PathVariable String cpf) {
        Aluno aluno = alunoService.findByCpf(cpf);
        return ResponseEntity.ok(new ApiResponse<>("Aluno encontrado!", aluno));
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<ApiResponse<Void>> deletarAluno(@PathVariable String cpf) {
        alunoService.deleteByCpf(cpf);
        return ResponseEntity.ok(new ApiResponse<>("Aluno deletado com sucesso!", null));
    }
}
