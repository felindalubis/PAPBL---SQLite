package com.example.felindalubis.tugassql1;

public class MinumanModel {
    private String nama, harga, toko;
    int id;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getToko() {
        return toko;
    }

    public void setToko(String toko) {
        this.toko = toko;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MinumanModel() {

    }

    public MinumanModel(int id, String nama, String harga, String toko) {

        this.nama = nama;
        this.harga = harga;
        this.toko = toko;
        this.id = id;
    }

    public MinumanModel(String nama, String harga, String toko) {

        this.nama = nama;
        this.harga = harga;
        this.toko = toko;
    }
}
