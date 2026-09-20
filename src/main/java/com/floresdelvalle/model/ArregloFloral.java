package com.floresdelvalle.model;

public class ArregloFloral {
    private Long id;
    private String nombre;
    private String descripcion;
    private String ocasionRecomendada;
    private double precioSugerido;
    private String floresPrincipales;
    private String popularidad;

    public ArregloFloral() {}

    public ArregloFloral(Long id, String nombre, String descripcion, String ocasionRecomendada,
                         double precioSugerido, String floresPrincipales, String popularidad) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ocasionRecomendada = ocasionRecomendada;
        this.precioSugerido = precioSugerido;
        this.floresPrincipales = floresPrincipales;
        this.popularidad = popularidad;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getOcasionRecomendada() { return ocasionRecomendada; }
    public void setOcasionRecomendada(String ocasionRecomendada) { this.ocasionRecomendada = ocasionRecomendada; }

    public double getPrecioSugerido() { return precioSugerido; }
    public void setPrecioSugerido(double precioSugerido) { this.precioSugerido = precioSugerido; }

    public String getFloresPrincipales() { return floresPrincipales; }
    public void setFloresPrincipales(String floresPrincipales) { this.floresPrincipales = floresPrincipales; }

    public String getPopularidad() { return popularidad; }
    public void setPopularidad(String popularidad) { this.popularidad = popularidad; }
}
