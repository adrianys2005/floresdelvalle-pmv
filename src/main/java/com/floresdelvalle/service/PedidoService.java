package com.floresdelvalle.service;

import com.floresdelvalle.model.Pedido;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PedidoService {
    private final List<Pedido> pedidos = new ArrayList<>();
    private final AtomicLong seq = new AtomicLong(101);

    private final FlorService florService;
    private final EntregaService entregaService;
    private final FacturaService facturaService;

    public PedidoService(FlorService florService, EntregaService entregaService, FacturaService facturaService) {
        this.florService = florService;
        this.entregaService = entregaService;
        this.facturaService = facturaService;
        inicializarPedidos();
    }

    private void inicializarPedidos() {
        pedidos.add(new Pedido(seq.getAndIncrement(), "Laura Camila Restrepo", "Carrera 45 # 72-15, Barrio El Prado", "3114589211", "laura.restrepo@gmail.com", "Caja de 24 Rosas Rojas", "Aniversario", "2026-09-18", 120000, "Completado", "PSE", "Tarjeta con mensaje de amor"));
        pedidos.add(new Pedido(seq.getAndIncrement(), "Santiago Mejia Morales", "Calle 10 # 32-40, Poblado", "3209876543", "santiago.mejia@hotmail.com", "Ramo Silvestre de Girasoles", "Cumpleaños", "2026-09-19", 95000, "En curso", "Transferencia Nequi", "Entregar antes de las 3pm"));
        pedidos.add(new Pedido(seq.getAndIncrement(), "Empresa Construsur SAS", "Avenida Las Vegas # 18-90", "3154442211", "compras@construsur.com", "Centro de Mesa Orquídeas", "Evento Corporativo", "2026-09-20", 180000, "En curso", "Tarjeta de Crédito", "Factura electrónica requerida"));
    }

    public synchronized List<Pedido> obtenerTodos() {
        return Collections.unmodifiableList(new ArrayList<>(pedidos));
    }

    public synchronized Pedido registrarPedido(Pedido pedido) {
        pedido.setId(seq.getAndIncrement());
        pedido.setEstado("En curso");
        if (pedido.getFechaEntrega() == null || pedido.getFechaEntrega().isBlank()) {
            pedido.setFechaEntrega(LocalDate.now().format(DateTimeFormatter.ISO_DATE));
        }
        pedidos.add(0, pedido);

        // Descontar inventario en tiempo real segun el tipo de arreglo
        if (pedido.getTipoArreglo() != null) {
            florService.descontarStock(pedido.getTipoArreglo(), 12);
        }

        // Programar entrega con conductor automaticamente
        entregaService.programarEntrega(pedido.getId(), pedido.getClienteNombre(), pedido.getClienteDireccion(), pedido.getClienteContacto());

        // Emitir factura con calculo de flete
        facturaService.emitirFactura(pedido);

        return pedido;
    }

    public synchronized long contarEnCurso() {
        return pedidos.stream().filter(p -> "En curso".equalsIgnoreCase(p.getEstado())).count();
    }

    public synchronized long contarCompletados() {
        return pedidos.stream().filter(p -> "Completado".equalsIgnoreCase(p.getEstado()) || "Entregado".equalsIgnoreCase(p.getEstado())).count();
    }
}
