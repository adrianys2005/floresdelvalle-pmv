package com.floresdelvalle.service;

import com.floresdelvalle.model.Flor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class FlorService {
    private final List<Flor> flores = new ArrayList<>();
    private final AtomicLong seq = new AtomicLong(1);

    public FlorService() {
        flores.add(new Flor(seq.getAndIncrement(), "Rosa de Exportación", "Rojo Pasión", "Exportación Premium", 150, 1500, 3500, "San Valentín / Amor"));
        flores.add(new Flor(seq.getAndIncrement(), "Girasol Gigante", "Amarillo Intenso", "Nacional Selecto", 80, 2000, 4500, "Todo el Año"));
        flores.add(new Flor(seq.getAndIncrement(), "Lirio Oriental", "Blanco Puro", "Holandesa", 25, 3000, 6500, "Condolencias / Matrimonios"));
        flores.add(new Flor(seq.getAndIncrement(), "Orquídea Phalaenopsis", "Morado / Rosado", "Invernadero Especial", 18, 15000, 32000, "Día de la Madre"));
        flores.add(new Flor(seq.getAndIncrement(), "Tulipán Real", "Amarillo y Rojo", "Importación Holanda", 20, 4000, 8000, "San Valentín"));
        flores.add(new Flor(seq.getAndIncrement(), "Hortensia Imperial", "Azul Cielo", "Silvestre Sabana", 65, 2500, 5500, "Día de la Madre"));
        flores.add(new Flor(seq.getAndIncrement(), "Clavel Clásico", "Blanco y Rosado", "Nacional Fino", 120, 800, 1800, "Todo el Año"));
    }

    public synchronized List<Flor> obtenerTodas() {
        return Collections.unmodifiableList(new ArrayList<>(flores));
    }

    public synchronized void agregarFlor(Flor flor) {
        flor.setId(seq.getAndIncrement());
        flores.add(flor);
    }

    public synchronized void descontarStock(String tipoFlor, int cantidad) {
        for (Flor f : flores) {
            if (f.getTipoFlor().toLowerCase().contains(tipoFlor.toLowerCase())) {
                int nuevoStock = Math.max(0, f.getCantidadDisponible() - cantidad);
                f.setCantidadDisponible(nuevoStock);
                break;
            }
        }
    }

    public synchronized long contarStockCritico() {
        return flores.stream().filter(f -> f.getCantidadDisponible() <= 30).count();
    }

    public synchronized int totalFloresEnInventario() {
        return flores.stream().mapToInt(Flor::getCantidadDisponible).sum();
    }
}
