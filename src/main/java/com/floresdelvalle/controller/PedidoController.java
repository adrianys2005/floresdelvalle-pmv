package com.floresdelvalle.controller;

import com.floresdelvalle.model.Pedido;
import com.floresdelvalle.service.PedidoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("/pedidos")
    public String listarPedidos(Model model) {
        model.addAttribute("pedidos", pedidoService.obtenerTodos());
        model.addAttribute("enCurso", pedidoService.contarEnCurso());
        model.addAttribute("completados", pedidoService.contarCompletados());
        return "pedidos";
    }

    @GetMapping("/pedidos/nuevo")
    public String mostrarFormularioPedido(Model model) {
        model.addAttribute("pedido", new Pedido());
        return "nuevo-pedido";
    }

    @PostMapping("/pedidos/nuevo")
    public String procesarPedido(@ModelAttribute("pedido") Pedido pedido, RedirectAttributes redirectAttributes) {
        pedidoService.registrarPedido(pedido);
        redirectAttributes.addFlashAttribute("mensajeExito",
                "Pedido registrado exitosamente para " + pedido.getClienteNombre() +
                ". Se actualizó el inventario, se programó la entrega y se emitió la factura correspondiente.");
        return "redirect:/pedidos";
    }
}
