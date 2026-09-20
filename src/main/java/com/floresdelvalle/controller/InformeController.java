package com.floresdelvalle.controller;

import com.floresdelvalle.service.CatalogoService;
import com.floresdelvalle.service.FacturaService;
import com.floresdelvalle.service.FlorService;
import com.floresdelvalle.service.PedidoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InformeController {

    private final FlorService florService;
    private final PedidoService pedidoService;
    private final FacturaService facturaService;
    private final CatalogoService catalogoService;

    public InformeController(FlorService florService, PedidoService pedidoService,
                             FacturaService facturaService, CatalogoService catalogoService) {
        this.florService = florService;
        this.pedidoService = pedidoService;
        this.facturaService = facturaService;
        this.catalogoService = catalogoService;
    }

    @GetMapping("/informes")
    public String verInformes(Model model) {
        model.addAttribute("totalFlores", florService.totalFloresEnInventario());
        model.addAttribute("stockCritico", florService.contarStockCritico());
        model.addAttribute("totalVentas", facturaService.calcularTotalRecaudado());
        model.addAttribute("pedidosEnCurso", pedidoService.contarEnCurso());
        model.addAttribute("arreglosPopulares", catalogoService.obtenerTodos());
        return "informes";
    }
}
