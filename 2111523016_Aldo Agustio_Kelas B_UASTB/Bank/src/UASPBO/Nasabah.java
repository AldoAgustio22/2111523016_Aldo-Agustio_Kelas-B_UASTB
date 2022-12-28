package UASPBO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Nasabah implements Tunai {

    private String nama;
    private String alamat;
    private int noRekening;
    private String saldo;

    public Nasabah(String nama, String alamat, int noRekening, String saldo) {
        this.nama = nama;
        this.alamat = alamat;
        this.noRekening = noRekening;
        this.saldo = saldo;
    }

   

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public int getNoRekening() {
        return noRekening;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setNoRekening(int noRekening) {
        this.noRekening = noRekening;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public void tarikTunai(int jumlah, int jumlahSaldo) {
        try {
            
            if (jumlah > jumlahSaldo) {
                System.out.println("Saldo tidak cukup untuk menarik tunai sebesar " + jumlah);
            } else {
                jumlahSaldo -= jumlah;
                System.out.println("Tarik tunai sebesar " + jumlah + " berhasil");
            }

        } catch (NumberFormatException e) {
            System.err.println("format angka salah");
        }

    }

    public void setorTunai(int jumlah, int jumlahSaldo) {
        saldo += jumlah;
        System.out.println("Setor tunai sebesar " + jumlah + " berhasil");
    }

    public void create(Nasabah nasabah) {
        String file = "D:\\nasabah.txt";

        try (BufferedWriter dt = new BufferedWriter(new FileWriter(file, true))) {

         

           
                dt.write( nasabah.getNama() + "," + nasabah.getAlamat() + "," +nasabah.getNoRekening() + "," + nasabah.getSaldo());
                dt.flush();
                dt.newLine();
            

            dt.close();

        } catch (Exception ex) {
            System.out.println("Eror: file tidak ada/tidak dapat dibaca");
        }

    }

    

   

   

}
