package com.floresdelvalle.model;

public class Pedido {
    private Long id;
    private String clienteNombre;
    private String clienteDireccion;
    private String clienteContacto;
    private String clienteEmail;
    private String tipoArreglo;
    private String ocasion;
    private String fechaEntrega;
    private double presupuesto;
    private String estado; // En curso, Completado, Entregado
    private String metodoPago;
    private String notasEspeciales;

    public Pedido() {}

    public Pedido(Long id, String clienteNombre, String clienteDireccion, String clienteContacto,
                  String clienteEmail, String tipoArreglo, String ocasion, String fechaEntrega,
                  double presupuesto, String estado, String metodoPago, String notasEspeciales) {
        this.id = id;
        this.clienteNombre = clienteNombre;
        this.clienteDireccion = clienteDireccion;
        this.clienteContacto = clienteContacto;
        this.clienteEmail = clienteEmail;
        this.tipoArreglo = tipoArreglo;
        this.ocasion = ocasion;
        this.fechaEntrega = fechaEntrega;
        this.presupuesto = presupuesto;
        this.estado = estado;
        this.metodoPago = metodoPago;
        this.notasEspeciales = notasEspeciales;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getClienteNombre() { return clienteNombre; }
    public void setClienteNombre(String clienteNombre) { this.clienteNombre = clienteNombre; }

    public String getClienteDireccion() { return clienteDireccion; }
    public void setClienteDireccion(String clienteDireccion) { this.clienteDireccion = clienteDireccion; }

    public String getClienteContacto() { return clienteContacto; }
    public void setClienteContacto(String clienteContacto) { this.clienteContacto = clienteContacto; }

    public String getClienteEmail() { return clienteEmail; }
    public void setClienteEmail(String clienteEmail) { this.clienteEmail = clienteEmail; }

    public String getTipoArreglo() { return tipoArreglo; }
    public void setTipoArreglo(String tipoArreglo) { this.tipoArreglo = tipoArreglo; }

    public String getOcasion() { return ocasion; }
    public void setOcasion(String ocasion) { this.ocasion = ocasion; }

    public String getFechaEntrega() { return fechaEntrega; }
    public void setFechaEntrega(String fechaEntrega) { this.fechaEntrega = fechaEntrega; }

    public double getPresupuesto() { return presupuesto; }
    public void setPresupuesto(double presupuesto) { this.presupuesto = presupuesto; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }

    public String getNotasEspeciales() { return notasEspeciales; }
    public void setNotasEspeciales(String notasEspeciales) { this.notasEspeciales = notasEspeciales; }
}
