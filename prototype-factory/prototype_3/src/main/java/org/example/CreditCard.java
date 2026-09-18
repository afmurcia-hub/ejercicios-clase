package org.example;

import java.util.Objects;

//  Clase CreditCard que implementa Cloneable y usa super.clone()
class CreditCard implements Cloneable {
    private String titularName;
    private String cardId;
    private String expirationDate;
    private int securityCode;


    // Constructor con parámetros
    public CreditCard(String titularName, String cardId, String expirationDate, int securityCode) {
        this.titularName = titularName;
        this.cardId = cardId;
        this.expirationDate = expirationDate;
        this.securityCode = securityCode;
    }


    // Getters y Setters
    public String getTitularName() { return titularName; }
    public void setTitularName(String titularName) { this.titularName = titularName; }

    public String getCardId() { return cardId; }
    public void setCardId(String cardId) { this.cardId = cardId; }

    public String getExpirationDate() { return expirationDate; }
    public void setExpirationDate(String expirationDate) { this.expirationDate = expirationDate; }

    public int getSecurityCode() { return securityCode; }
    public void setSecurityCode(int securityCode) { this.securityCode = securityCode; }



    // Implementación del metodo clone usando el mecanismo nativo de Java
    @Override
    public CreditCard clone() {
        try {
            // super.clone() realiza la copia superficial (shallow copy) automática a nivel de bytes en memoria
            return (CreditCard) super.clone();
        } catch (CloneNotSupportedException e) {
            // Manejo obligatorio de la excepción que exige Java al usar Cloneable
            throw new AssertionError("La clonación no está soportada", e);
        }
    }

    // Metodo toString para imprimir el estado de la tarjeta claramente
    @Override
    public String toString() {
        return "CreditCard{" +
                "titularName='" + titularName + '\'' +
                ", cardId='" + cardId + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", securityCode=" + securityCode +
                '}';
    }
}

