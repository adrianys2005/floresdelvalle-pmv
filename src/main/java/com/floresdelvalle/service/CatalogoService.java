package com.floresdelvalle.service;

import com.floresdelvalle.model.ArregloFloral;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CatalogoService {
    private final List<ArregloFloral> arreglos = new ArrayList<>();

    public CatalogoService() {
        arreglos.add(new ArregloFloral(1L, "Caja de Rosas Amor Eterno", "Elegante caja redonda con 24 rosas rojas seleccionadas y toques de gipsófila.", "San Valentín / Aniversario", 135000, "Rosas Rojas", "Top Ventas"));
        arreglos.add(new ArregloFloral(2L, "Sol Radiante de Girasoles", "Bouquet alegre con 7 girasoles gigantes, follaje verde montecasino y eucalipto aromático.", "Cumpleaños / Agradecimiento", 98000, "Girasoles", "Alta Demanda"));
        arreglos.add(new ArregloFloral(3L, "Orquídea Majestuosa en Maceta", "Orquídea Phalaenopsis de doble vara en maceta artesanal decorativa de cerámica.", "Día de la Madre / Hogar", 145000, "Orquídeas", "Exclusivo"));
        arreglos.add(new ArregloFloral(4L, "Paz y Serenidad", "Arreglo sobrio y distinguido con lirios blancos, hortensias y claveles finos.", "Condolencias", 125000, "Lirios y Hortensias", "Tradicional"));
    }

    public List<ArregloFloral> obtenerTodos() {
        return Collections.unmodifiableList(arreglos);
    }
}
