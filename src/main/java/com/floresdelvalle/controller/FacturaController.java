package com.floresdelvalle.controller;

import com.floresdelvalle.service.FacturaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FacturaController {

    private final FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    @GetMapping({"/facturacion", "/facturas"})
    public String listarFacturas(Model model) {
        model.addAttribute("facturas", facturaService.obtenerTodas());
        model.addAttribute("totalRecaudado", facturaService.calcularTotalRecaudado());
        model.addAttribute("pagosPendientes", facturaService.contarPendientes());
        return "facturas";
    }
}
