package com.hotel.controller;

import com.hotel.model.Reserva;
import com.hotel.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    @GetMapping
    public List<Reserva> listar() {
        return reservaRepository.findAll();
    }

    @PostMapping
    public Reserva adicionar(@RequestBody Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    @PutMapping("/{id}")
    public Reserva atualizar(@PathVariable Long id, @RequestBody Reserva reservaAtualizada) {
        return reservaRepository.findById(id).map(reserva -> {
            reserva.setHospede(reservaAtualizada.getHospede());
            reserva.setFuncionario(reservaAtualizada.getFuncionario());
            reserva.setDataReserva(reservaAtualizada.getDataReserva());
            reserva.setStatus(reservaAtualizada.getStatus());
            return reservaRepository.save(reserva);
        }).orElseGet(() -> {
            reservaAtualizada.setId(id);
            return reservaRepository.save(reservaAtualizada);
        });
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        reservaRepository.deleteById(id);
    }
}
