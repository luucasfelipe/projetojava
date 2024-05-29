package com.hotel.controller;

import com.hotel.model.QuartoReserva;
import com.hotel.repository.QuartoReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quartos-reserva")
public class QuartoReservaController {

    @Autowired
    private QuartoReservaRepository quartoReservaRepository;

    @GetMapping
    public List<QuartoReserva> listar() {
        return quartoReservaRepository.findAll();
    }

    @PostMapping
    public QuartoReserva adicionar(@RequestBody QuartoReserva quartoReserva) {
        return quartoReservaRepository.save(quartoReserva);
    }

    @PutMapping("/{id}")
    public QuartoReserva atualizar(@PathVariable Long id, @RequestBody QuartoReserva quartoReservaAtualizado) {
        return quartoReservaRepository.findById(id).map(quartoReserva -> {
            quartoReserva.setReserva(quartoReservaAtualizado.getReserva());
            quartoReserva.setTipoQuarto(quartoReservaAtualizado.getTipoQuarto());
            quartoReserva.setQuantidade(quartoReservaAtualizado.getQuantidade());
            return quartoReservaRepository.save(quartoReserva);
        }).orElseGet(() -> {
            quartoReservaAtualizado.setId(id);
            return quartoReservaRepository.save(quartoReservaAtualizado);
        });
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        quartoReservaRepository.deleteById(id);
    }
}
