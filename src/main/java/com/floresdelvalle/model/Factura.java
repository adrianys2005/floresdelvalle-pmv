package com.floresdelvalle.model;

public class Factura {
    private Long id;
    private String numeroFactura;
    private Long pedidoId;
    private String clienteNombre;
    private String detallePedido;
    private double subtotalFlores;
    private double costoEnvio;
    private double total;
    private String metodoPago;
    private String estadoPago; // Pagado, Pendiente
    private String fechaEmision;

    public Factura() {}

    public Factura(Long id, String numeroFactura, Long pedidoId, String clienteNombre,
                   String detallePedido, double subtotalFlores, double costoEnvio,
                   double total, String metodoPago, String estadoPago, String fechaEmision) {
        this.id = id;
        this.numeroFactura = numeroFactura;
        this.pedidoId = pedidoId;
        this.clienteNombre = clienteNombre;
        this.detallePedido = detallePedido;
        this.subtotalFlores = subtotalFlores;
        this.costoEnvio = costoEnvio;
        this.total = total;
        this.metodoPago = metodoPago;
        this.estadoPago = estadoPago;
        this.fechaEmision = fechaEmision;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNumeroFactura() { return numeroFactura; }
    public void setNumeroFactura(String numeroFactura) { this.numeroFactura = numeroFactura; }

    public Long getPedidoId() { return pedidoId; }
    public void setPedidoId(Long pedidoId) { this.pedidoId = pedidoId; }

    public String getClienteNombre() { return clienteNombre; }
    public void setClienteNombre(String clienteNombre) { this.clienteNombre = clienteNombre; }

    public String getDetallePedido() { return detallePedido; }
    public void setDetallePedido(String detallePedido) { this.detallePedido = detallePedido; }

    public double getSubtotalFlores() { return subtotalFlores; }
    public void setSubtotalFlores(double subtotalFlores) { this.subtotalFlores = subtotalFlores; }

    public double getCostoEnvio() { return costoEnvio; }
    public void setCostoEnvio(double costoEnvio) { this.costoEnvio = costoEnvio; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }

    public String getEstadoPago() { return estadoPago; }
    public void setEstadoPago(String estadoPago) { this.estadoPago = estadoPago; }

    public String getFechaEmision() { return fechaEmision; }
    public void setFechaEmision(String fechaEmision) { this.fechaEmision = fechaEmision; }
}
