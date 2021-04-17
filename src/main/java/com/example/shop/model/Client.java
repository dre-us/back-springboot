package com.example.shop.model;

public class Client {

    private int dni;
    private String address;

    public Client(int dni, String address) {
        this.dni = dni;
        this.address = address;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client{" +
                "dni=" + dni +
                ", address='" + address + '\'' +
                '}';
    }
}
