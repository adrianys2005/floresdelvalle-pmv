package com.floresdelvalle.service;

import com.floresdelvalle.model.Factura;
import com.floresdelvalle.model.Pedido;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class FacturaService {
    private final List<Factura> facturas = new ArrayList<>();
    private final AtomicLong seq = new AtomicLong(1001);

    public FacturaService() {
        facturas.add(new Factura(1L, "FAC-1001", 101L, "Laura Camila Restrepo", "Caja de 24 Rosas Rojas con Follaje", 120000, 15000, 135000, "PSE", "Pagado", "2026-09-18"));
        facturas.add(new Factura(2L, "FAC-1002", 102L, "Santiago Mejia Morales", "Ramo Silvestre con Girasoles y Lirios", 95000, 12000, 107000, "Transferencia Nequi", "Pagado", "2026-09-19"));
        facturas.add(new Factura(3L, "FAC-1003", 103L, "Empresa Construsur SAS", "Centro de Mesa Orquídeas Phalaenopsis", 180000, 18000, 198000, "Tarjeta de Crédito", "Pendiente", "2026-09-20"));
    }

    public synchronized List<Factura> obtenerTodas() {
        return Collections.unmodifiableList(new ArrayList<>(facturas));
    }

    public synchronized Factura emitirFactura(Pedido pedido) {
        double subtotal = pedido.getPresupuesto();
        double costoEnvio = 12000;
        double total = subtotal + costoEnvio;
        String num = "FAC-" + seq.getAndIncrement();
        String fecha = LocalDate.now().format(DateTimeFormatter.ISO_DATE);

        Factura f = new Factura(null, num, pedido.getId(), pedido.getClienteNombre(),
                pedido.getTipoArreglo() + " (" + pedido.getOcasion() + ")",
                subtotal, costoEnvio, total, pedido.getMetodoPago(), "Pagado", fecha);

        f.setId((long) (facturas.size() + 1));
        facturas.add(0, f);
        return f;
    }

    public synchronized double calcularTotalRecaudado() {
        return facturas.stream()
                .filter(f -> "Pagado".equalsIgnoreCase(f.getEstadoPago()))
                .mapToDouble(Factura::getTotal)
                .sum();
    }

    public synchronized long contarPendientes() {
        return facturas.stream()
                .filter(f -> "Pendiente".equalsIgnoreCase(f.getEstadoPago()))
                .count();
    }
}
