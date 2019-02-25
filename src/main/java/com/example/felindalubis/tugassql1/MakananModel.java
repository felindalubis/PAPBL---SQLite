package com.example.felindalubis.tugassql1;

public class MakananModel {
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

    public MakananModel() {

    }

    public MakananModel(String nama, String harga, String toko, int id) {

        this.nama = nama;
        this.harga = harga;
        this.toko = toko;
        this.id = id;
    }

    public MakananModel(String nama, String harga, String toko) {

        this.nama = nama;
        this.harga = harga;
        this.toko = toko;
    }
}
