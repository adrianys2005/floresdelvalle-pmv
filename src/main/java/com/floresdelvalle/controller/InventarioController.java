package com.floresdelvalle.controller;

import com.floresdelvalle.model.Flor;
import com.floresdelvalle.service.FlorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class InventarioController {

    private final FlorService florService;

    public InventarioController(FlorService florService) {
        this.florService = florService;
    }

    @GetMapping("/inventario")
    public String listarInventario(Model model) {
        model.addAttribute("flores", florService.obtenerTodas());
        model.addAttribute("stockCritico", florService.contarStockCritico());
        model.addAttribute("totalUnidades", florService.totalFloresEnInventario());
        model.addAttribute("nuevaFlor", new Flor());
        return "inventario";
    }

    @PostMapping("/inventario/nuevo")
    public String registrarLote(@ModelAttribute("nuevaFlor") Flor flor, RedirectAttributes redirectAttributes) {
        florService.agregarFlor(flor);
        redirectAttributes.addFlashAttribute("mensajeExito", "Nuevo lote de " + flor.getTipoFlor() + " registrado exitosamente en el inventario.");
        return "redirect:/inventario";
    }
}
