package com.floresdelvalle.model;

public class Entrega {
    private Long id;
    private Long pedidoId;
    private String clienteNombre;
    private String direccionEntrega;
    private String conductorAsignado;
    private String rutaZona;
    private String horarioEstimado;
    private String estadoEntrega; // Pendiente, En ruta, Entregado
    private String telefonoContacto;

    public Entrega() {}

    public Entrega(Long id, Long pedidoId, String clienteNombre, String direccionEntrega,
                   String conductorAsignado, String rutaZona, String horarioEstimado,
                   String estadoEntrega, String telefonoContacto) {
        this.id = id;
        this.pedidoId = pedidoId;
        this.clienteNombre = clienteNombre;
        this.direccionEntrega = direccionEntrega;
        this.conductorAsignado = conductorAsignado;
        this.rutaZona = rutaZona;
        this.horarioEstimado = horarioEstimado;
        this.estadoEntrega = estadoEntrega;
        this.telefonoContacto = telefonoContacto;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPedidoId() { return pedidoId; }
    public void setPedidoId(Long pedidoId) { this.pedidoId = pedidoId; }

    public String getClienteNombre() { return clienteNombre; }
    public void setClienteNombre(String clienteNombre) { this.clienteNombre = clienteNombre; }

    public String getDireccionEntrega() { return direccionEntrega; }
    public void setDireccionEntrega(String direccionEntrega) { this.direccionEntrega = direccionEntrega; }

    public String getConductorAsignado() { return conductorAsignado; }
    public void setConductorAsignado(String conductorAsignado) { this.conductorAsignado = conductorAsignado; }

    public String getRutaZona() { return rutaZona; }
    public void setRutaZona(String rutaZona) { this.rutaZona = rutaZona; }

    public String getHorarioEstimado() { return horarioEstimado; }
    public void setHorarioEstimado(String horarioEstimado) { this.horarioEstimado = horarioEstimado; }

    public String getEstadoEntrega() { return estadoEntrega; }
    public void setEstadoEntrega(String estadoEntrega) { this.estadoEntrega = estadoEntrega; }

    public String getTelefonoContacto() { return telefonoContacto; }
    public void setTelefonoContacto(String telefonoContacto) { this.telefonoContacto = telefonoContacto; }
}
