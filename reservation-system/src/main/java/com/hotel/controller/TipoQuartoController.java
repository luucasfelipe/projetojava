package com.hotel.controller;

import com.hotel.model.TipoQuarto;
import com.hotel.repository.TipoQuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipos-quarto")
public class TipoQuartoController {

    @Autowired
    private TipoQuartoRepository tipoQuartoRepository;

    @GetMapping
    public List<TipoQuarto> listar() {
        return tipoQuartoRepository.findAll();
    }

    @PostMapping
    public TipoQuarto adicionar(@RequestBody TipoQuarto tipoQuarto) {
        return tipoQuartoRepository.save(tipoQuarto);
    }

    @PutMapping("/{id}")
    public TipoQuarto atualizar(@PathVariable Long id, @RequestBody TipoQuarto tipoQuartoAtualizado) {
        return tipoQuartoRepository.findById(id).map(tipoQuarto -> {
            tipoQuarto.setDescricao(tipoQuartoAtualizado.getDescricao());
            tipoQuarto.setPreco(tipoQuartoAtualizado.getPreco());
            return tipoQuartoRepository.save(tipoQuarto);
        }).orElseGet(() -> {
            tipoQuartoAtualizado.setId(id);
            return tipoQuartoRepository.save(tipoQuartoAtualizado);
        });
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        tipoQuartoRepository.deleteById(id);
    }
}
