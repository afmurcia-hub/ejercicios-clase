package org.example.modelo;

public class ContextoTransaccion {
    private final String idTransaccion;
    private final String cliente;
    private final double monto;
    private boolean aprobadoPorFraude = false;
    private boolean stockReservado = false;
    private boolean pagoProcesado = false;
    private String codigoEnvio = null;

    public ContextoTransaccion(String idTransaccion, String cliente, double monto) {
        this.idTransaccion = idTransaccion;
        this.cliente = cliente;
        this.monto = monto;
    }

    public String getIdTransaccion() { return idTransaccion; }
    public String getCliente() { return cliente; }
    public double getMonto() { return monto; }

    public boolean isAprobadoPorFraude() { return aprobadoPorFraude; }
    public void setAprobadoPorFraude(boolean aprobadoPorFraude) { this.aprobadoPorFraude = aprobadoPorFraude; }

    public boolean isStockReservado() { return stockReservado; }
    public void setStockReservado(boolean stockReservado) { this.stockReservado = stockReservado; }

    public boolean isPagoProcesado() { return pagoProcesado; }
    public void setPagoProcesado(boolean pagoProcesado) { this.pagoProcesado = pagoProcesado; }

    public String getCodigoEnvio() { return codigoEnvio; }
    public void setCodigoEnvio(String codigoEnvio) { this.codigoEnvio = codigoEnvio; }
}