/**
 * @Author: Bryan Bellato
 */

package br.com.bellato.domain;

import java.util.Objects;

public class Client {

    private String name;
    private Long cpf;
    private Long phone_number;
    private String address;
    private String city;
    private String state;

    public Client (String name, String cpf, String phone_number, String address, String city, String state) {
        this.name = name;
        this.cpf = Long.valueOf(cpf.trim());
        this.phone_number = Long.valueOf(phone_number.trim());
        this.cpf = Long.valueOf(cpf.trim());
        this.address = address;
        this.city = city;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Long getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(Long phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(cpf, client.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", cpf=" + cpf +
                ", phone_number=" + phone_number +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

}
