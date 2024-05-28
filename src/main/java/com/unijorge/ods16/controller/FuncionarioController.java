package com.unijorge.ods16.controller;

import com.unijorge.ods16.model.Cargo;
import com.unijorge.ods16.model.Funcionario;
import com.unijorge.ods16.model.records.NewEmployee;
import com.unijorge.ods16.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/api/funcionario")
@RestController
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("/cargos")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Cargo> getCar() {
        return Arrays.asList(Cargo.values());
    }

    @PostMapping("/cadastrar")
    @PreAuthorize("hasRole('ADMIN')")
    public String cadastrarFuncionario(@Valid @RequestBody NewEmployee newEmployee) {
        funcionarioService.cadastraFuncionario(newEmployee);
        return "Funcionário cadastrado com sucesso!";
    }

    @GetMapping("/listar")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Funcionario> listarFuncionarios() {
        return funcionarioService.listaTodos();
    }

    @PutMapping("/alterar")
    @PreAuthorize("hasRole('ADMIN')")
    public Funcionario update(@RequestBody Funcionario funcionario){return funcionarioService.createOrUpdate(funcionario);}

    @DeleteMapping("/deletar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deletarFuncionario(@PathVariable Long id){
        funcionarioService.deletarFuncionario(id);
    }
}
