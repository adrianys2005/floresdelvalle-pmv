package com.floresdelvalle.model;

public class Flor {
    private Long id;
    private String tipoFlor;
    private String color;
    private String variedad;
    private int cantidadDisponible;
    private double precioCompra;
    private double precioVenta;
    private String temporadaClave;

    public Flor() {}

    public Flor(Long id, String tipoFlor, String color, String variedad, int cantidadDisponible,
                double precioCompra, double precioVenta, String temporadaClave) {
        this.id = id;
        this.tipoFlor = tipoFlor;
        this.color = color;
        this.variedad = variedad;
        this.cantidadDisponible = cantidadDisponible;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.temporadaClave = temporadaClave;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTipoFlor() { return tipoFlor; }
    public void setTipoFlor(String tipoFlor) { this.tipoFlor = tipoFlor; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getVariedad() { return variedad; }
    public void setVariedad(String variedad) { this.variedad = variedad; }

    public int getCantidadDisponible() { return cantidadDisponible; }
    public void setCantidadDisponible(int cantidadDisponible) { this.cantidadDisponible = cantidadDisponible; }

    public double getPrecioCompra() { return precioCompra; }
    public void setPrecioCompra(double precioCompra) { this.precioCompra = precioCompra; }

    public double getPrecioVenta() { return precioVenta; }
    public void setPrecioVenta(double precioVenta) { this.precioVenta = precioVenta; }

    public String getTemporadaClave() { return temporadaClave; }
    public void setTemporadaClave(String temporadaClave) { this.temporadaClave = temporadaClave; }

    public String getEstadoStock() {
        if (cantidadDisponible <= 0) return "Agotado";
        if (cantidadDisponible <= 30) return "Stock Crítico";
        return "Disponible";
    }
}
