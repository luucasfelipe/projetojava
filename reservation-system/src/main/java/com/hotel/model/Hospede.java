package com.hotel.model;

public class Hospede {
    private Long id;
    private String documento;
    private String nome;
    private String telefone;

    // Construtores
    public Hospede() {
    }

    public Hospede(Long id, String documento, String nome, String telefone) {
        this.id = id;
        this.documento = documento;
        this.nome = nome;
        this.telefone = telefone;
    }

    // Métodos getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
