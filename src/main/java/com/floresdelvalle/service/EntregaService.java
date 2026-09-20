package com.floresdelvalle.service;

import com.floresdelvalle.model.Entrega;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class EntregaService {
    private final List<Entrega> entregas = new ArrayList<>();
    private final AtomicLong seq = new AtomicLong(1);

    public EntregaService() {
        entregas.add(new Entrega(seq.getAndIncrement(), 101L, "Laura Camila Restrepo", "Carrera 45 # 72-15, Barrio El Prado", "Carlos Ruiz", "Ruta Norte", "10:30 AM - 11:30 AM", "Entregado", "3114589211"));
        entregas.add(new Entrega(seq.getAndIncrement(), 102L, "Santiago Mejia Morales", "Calle 10 # 32-40, Poblado", "Andres Montoya", "Ruta Sur", "02:00 PM - 03:00 PM", "En ruta", "3209876543"));
        entregas.add(new Entrega(seq.getAndIncrement(), 103L, "Empresa Construsur SAS", "Avenida Las Vegas # 18-90", "Carlos Ruiz", "Ruta Centro", "04:30 PM - 05:30 PM", "Pendiente", "3154442211"));
    }

    public synchronized List<Entrega> obtenerTodas() {
        return Collections.unmodifiableList(new ArrayList<>(entregas));
    }

    public synchronized Entrega programarEntrega(Long pedidoId, String cliente, String direccion, String telefono) {
        String conductor = (entregas.size() % 2 == 0) ? "Carlos Ruiz" : "Andres Montoya";
        String zona = direccion.toLowerCase().contains("norte") ? "Ruta Norte" : "Ruta Centro/Sur";
        Entrega e = new Entrega(seq.getAndIncrement(), pedidoId, cliente, direccion, conductor, zona, "Horario Programado (1-2 horas)", "En ruta", telefono);
        entregas.add(0, e);
        return e;
    }

    public synchronized long contarEnRuta() {
        return entregas.stream().filter(e -> "En ruta".equalsIgnoreCase(e.getEstadoEntrega())).count();
    }
}
