package com.floresdelvalle.controller;

import com.floresdelvalle.service.CatalogoService;
import com.floresdelvalle.service.EntregaService;
import com.floresdelvalle.service.FacturaService;
import com.floresdelvalle.service.FlorService;
import com.floresdelvalle.service.PedidoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final FlorService florService;
    private final PedidoService pedidoService;
    private final EntregaService entregaService;
    private final FacturaService facturaService;
    private final CatalogoService catalogoService;

    public HomeController(FlorService florService, PedidoService pedidoService,
                          EntregaService entregaService, FacturaService facturaService,
                          CatalogoService catalogoService) {
        this.florService = florService;
        this.pedidoService = pedidoService;
        this.entregaService = entregaService;
        this.facturaService = facturaService;
        this.catalogoService = catalogoService;
    }

    @GetMapping("/")
    public String inicio(Model model) {
        model.addAttribute("totalFlores", florService.totalFloresEnInventario());
        model.addAttribute("stockCritico", florService.contarStockCritico());
        model.addAttribute("pedidosEnCurso", pedidoService.contarEnCurso());
        model.addAttribute("entregasEnRuta", entregaService.contarEnRuta());
        model.addAttribute("totalVentas", facturaService.calcularTotalRecaudado());
        model.addAttribute("arreglosDestacados", catalogoService.obtenerTodos());
        return "index";
    }

    @GetMapping("/catalogo")
    public String catalogo(Model model) {
        model.addAttribute("arreglos", catalogoService.obtenerTodos());
        return "catalogo";
    }

    @GetMapping("/mision")
    public String mision() {
        return "mision";
    }

    @GetMapping("/vision")
    public String vision() {
        return "vision";
    }

    @GetMapping("/valores")
    public String valores() {
        return "valores";
    }
}
