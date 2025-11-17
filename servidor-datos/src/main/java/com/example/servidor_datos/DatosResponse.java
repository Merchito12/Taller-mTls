package com.example.servidor_datos;

public class DatosResponse {

    private String numeroTarjeta;
    private boolean clientCertPresent;
    private String clientCertSubject;

    public DatosResponse() {
    }

    public DatosResponse(String numeroTarjeta, boolean clientCertPresent, String clientCertSubject) {
        this.numeroTarjeta = numeroTarjeta;
        this.clientCertPresent = clientCertPresent;
        this.clientCertSubject = clientCertSubject;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public boolean isClientCertPresent() {
        return clientCertPresent;
    }

    public void setClientCertPresent(boolean clientCertPresent) {
        this.clientCertPresent = clientCertPresent;
    }

    public String getClientCertSubject() {
        return clientCertSubject;
    }

    public void setClientCertSubject(String clientCertSubject) {
        this.clientCertSubject = clientCertSubject;
    }
}
