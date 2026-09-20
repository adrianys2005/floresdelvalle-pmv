package com.floresdelvalle.controller;

import com.floresdelvalle.service.EntregaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EntregaController {

    private final EntregaService entregaService;

    public EntregaController(EntregaService entregaService) {
        this.entregaService = entregaService;
    }

    @GetMapping("/entregas")
    public String listarEntregas(Model model) {
        model.addAttribute("entregas", entregaService.obtenerTodas());
        model.addAttribute("enRuta", entregaService.contarEnRuta());
        return "entregas";
    }
}
