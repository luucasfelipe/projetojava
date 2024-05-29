package com.hotel.controller;

import com.hotel.model.Hospede;

import com.hotel.repository.HospedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospedes")
public class HospedeController {

    @Autowired
    private HospedeRepository hospedeRepository;

    @GetMapping
    public List<Hospede> listar() {
        return hospedeRepository.findAll();
    }

    @PostMapping
    public Hospede adicionar(@RequestBody Hospede hospede) {
        return hospedeRepository.save(hospede);
    }

    @PutMapping("/{id}")
    public Hospede atualizar(@PathVariable Long id, @RequestBody Hospede hospedeAtualizado) {
        return hospedeRepository.findById(id).map(hospede -> {
            hospede.setNome(hospedeAtualizado.getNome());
            hospede.setDocumento(hospedeAtualizado.getDocumento());
            hospede.setTelefone(hospedeAtualizado.getTelefone());
            return hospedeRepository.save(hospede);
        }).orElseGet(() -> {
            hospedeAtualizado.setId(id);
            return hospedeRepository.save(hospedeAtualizado);
        });
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        hospedeRepository.deleteById(id);
    }
}
