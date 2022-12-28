package UASPBO;

import java.time.*;
import java.util.Date;
import java.io.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Bank {
    String file = "C:\\nasabah.txt";
    static void read() {
        try {
//            System.out.println("");
            System.out.println("========================================================================================");
            System.out.println("                             Data Nasabah Bank                                          ");
            System.out.println("========================================================================================");
            System.out.println(" No           Nama            Alamat              No Rekening             Saldo         ");
            System.out.println("========================================================================================");

            BufferedReader file = new BufferedReader(new FileReader("D:\\nasabah.txt"));
            String isiData;
            String nama, alamat, noRekening, saldo;

            int nomer = 0;

            while ((isiData = file.readLine()) != null) {
                nomer = nomer + 1;
                StringTokenizer dt = new StringTokenizer(isiData, ",");

                nama = dt.nextToken();
                alamat = dt.nextToken();
                noRekening = dt.nextToken();
                saldo = dt.nextToken();

                System.out.println(nomer + "\t\t" + nama + "\t\t" + alamat + "\t\t\t" + noRekening + "\t\t" + saldo);
            }

            System.out.println("================================================================================");
            System.out.println("                                           END                                  ");
            System.out.println("================================================================================");

            file.close();

        } catch (Exception ex) {
            System.err.println("Eror in reading from file");
        }
    }

    static void cariData() {

        try {

            String cari_dt;
            Scanner baca = new Scanner(System.in);

            System.out.print("Masukan No Rekening : ");

            cari_dt = baca.nextLine();

            System.out.println("=================================================================");
            System.out.println("                         Data Nasabah Bank1                      ");
            System.out.println("=================================================================");
            System.out.println(" No        No Rekening          Nama            Alamat           ");
            System.out.println("=================================================================");

            BufferedReader file = new BufferedReader(new FileReader("D:\\nasabah.txt"));
            String isiData;
            String nama, alamat, noRekening, saldo;

            int nomer = 0;

            while ((isiData = file.readLine()) != null) {

                StringTokenizer dt = new StringTokenizer(isiData, ",");

                nama = dt.nextToken();
                alamat = dt.nextToken();
                noRekening = dt.nextToken();
                saldo = dt.nextToken();

                if (cari_dt.equalsIgnoreCase(noRekening)) {
                    nomer = nomer + 1;
                    System.out.println(nomer + "            " + noRekening + "            " + nama + "            " + alamat);

                }

            }

            if (nomer == 0) {
                System.out.println("Data Tidak Ada");
            }

            System.out.println("====================================================================");
            System.out.println("                              END                                   ");
            System.out.println("====================================================================");

            file.close();

        } catch (Exception ex) {
            System.err.println("Error reading from file");
        }
    }

    static void edit() {

        try {

            String RubahNama, RubahAlamat, RubahNoRekening, Rubahsaldo;
            Scanner baca = new Scanner(System.in);

            System.out.print("Masukan No Rekening : ");
            RubahNoRekening = baca.next();

            baca.nextLine();

            System.out.print("Enter name: ");
            RubahNama = baca.nextLine();

            System.out.print("Enter Alamat: ");
            RubahAlamat = baca.nextLine();
            
            System.out.print("Enter Saldo: ");
            Rubahsaldo = baca.nextLine();

            File file_old = new File("D:\\nasabah.txt");
            File file_new = new File("D:\\nasabah.txt");

            BufferedReader lama = new BufferedReader(new FileReader(file_old));
            BufferedWriter baru = new BufferedWriter(new FileWriter(file_new));

            String isiData;
            String  nama, alamat, noRekening, saldo;

            int nomer = 0;

            while ((isiData = lama.readLine()) != null) {

                
                nama = "";
                alamat = "";
                noRekening = "";
                saldo = "";

                StringTokenizer dt = new StringTokenizer(isiData, ",");

                noRekening = dt.nextToken();
                nama = dt.nextToken();
                alamat = dt.nextToken();
                noRekening = dt.nextToken();
                saldo = dt.nextToken();

                if (noRekening.equalsIgnoreCase(RubahNoRekening)) {

                    baru.write( RubahNama + "," + RubahAlamat + RubahNoRekening + "," + Rubahsaldo);
                    baru.flush();
                    baru.newLine();
                } else {
                    baru.write( nama + "," + alamat + noRekening + "," +saldo);
                    baru.flush();
                    baru.newLine();
                }
            }

            lama.close();
            baru.close();

            file_old.delete();
            file_new.renameTo(file_old);

        } catch (Exception ex) {
            System.err.println("Error reading from file");
        }
    }

    static void delete() {

        try {

            String hapus_dt;
            Scanner baca = new Scanner(System.in);

            System.out.print("Masukan No Rekening yang mau di hapus : ");

            hapus_dt = baca.nextLine();

            File file_old = new File("D:\\nasabah.txt");
            File file_new = new File("D:\\nasabah.txt");

            BufferedReader lama = new BufferedReader(new FileReader(file_old));
            BufferedWriter baru = new BufferedWriter(new FileWriter(file_new));

            String isiData;
            String  nama, alamat, noRekening, saldo;

            int nomer = 0;

            while ((isiData = lama.readLine()) != null) {
                
                nama = "";
                alamat = "";
                noRekening = "";
                saldo = "";

                StringTokenizer dt = new StringTokenizer(isiData, ",");

                
                nama = dt.nextToken();
                alamat = dt.nextToken();
                noRekening = dt.nextToken();
                saldo = dt.nextToken();

                if (!(noRekening.equalsIgnoreCase(hapus_dt))) {

                    baru.write(nama + "," + alamat + noRekening + "," +  saldo);
                    baru.flush();
                    baru.newLine();
                }

            }

            lama.close();
            baru.close();

            file_old.delete();
            file_new.renameTo(file_old);

        } catch (Exception ex) {
            System.err.println("Error reading from file");
        }
    }

    static void prosesTarik() {

        try {

            String cari_dt;
            int jumlah_tarik;

            Scanner baca = new Scanner(System.in);

            System.out.print("Masukan No Rekening : ");
            cari_dt = baca.nextLine();

            BufferedReader file = new BufferedReader(new FileReader("D:\\nasabah.txt"));
            String isiData;
            String nama, alamat, noRekening, saldo;

            int nomer = 0;

            while ((isiData = file.readLine()) != null) {

                StringTokenizer dt = new StringTokenizer(isiData, ",");

                nama = dt.nextToken();
                alamat = dt.nextToken();
                noRekening = dt.nextToken();
                saldo = dt.nextToken();

                if (cari_dt.equalsIgnoreCase(noRekening)) {

                    System.out.print("Masukan Uang yang akan ditarik : ");
                    jumlah_tarik = baca.nextInt();

                    int no_rekening = Integer.parseInt(noRekening);

                    Nasabah nasabah = new Nasabah(nama, alamat, no_rekening, saldo);

                    nasabah.setNama(nama);
                    nasabah.setAlamat(alamat);
                    nasabah.setNoRekening(no_rekening);
                    nasabah.setSaldo(saldo);

                    int jumlah_saldo = Integer.parseInt(nasabah.getSaldo());

                    nasabah.tarikTunai(jumlah_tarik, jumlah_saldo);
                } else {
                    System.out.println("no rekening benar");
                }

            }

            file.close();

        } catch (Exception ex) {
            System.err.println("Error reading from file");
        }
    }

    public static void main(String[] args) {

        Scanner baca = new Scanner(System.in);
        String pilih = "";

        String lagi = "y";

        while (lagi.equalsIgnoreCase("y")) {
            System.out.println("\n");
            System.out.println("============================");
            System.out.println("        CRUD DATA NASABAH   ");
            Date sekarang = new Date();
            System.out.println("Date    :  " + sekarang);
            System.out.println("============================");
            System.out.println("1.  Tambah Data");
            System.out.println("2.  Lihat Data");
            System.out.println("3.  Cari Data");
            System.out.println("4.  Edit Data");
            System.out.println("5.  Hapus Data");
            System.out.println("6.  Tarik Tunai");
            System.out.println("7.  Exit");
            System.out.println("\n");
            System.out.println("============================");

            System.out.print("Pilih Menu    : ");
            pilih = baca.next();

            if (pilih.equals("1")) {
                String nama, alamat, saldoAwal;
                
                int noRekening;
                System.out.print("Masukan No Rekening : ");
                noRekening = baca.nextInt();

                baca.nextLine();

                System.out.print("Enter name: ");
                nama = baca.nextLine();

                System.out.print("Enter Alamat: ");
                alamat = baca.nextLine();

                System.out.print("Enter Saldo Awal: ");
                saldoAwal = baca.nextLine();

                Nasabah nasabah = new Nasabah(nama, alamat, noRekening, saldoAwal);

                nasabah.create(nasabah);
            } else if (pilih.equals("2")) {

                read();

            } else if (pilih.equals("3")) {
                cariData();

            } else if (pilih.equals("4")) {
                edit();

            } else if (pilih.equals("5")) {
                delete();

            } else if (pilih.equals("6")) {
                prosesTarik();

            } else if (pilih.equals("7")) {
                System.out.println("==== TERIMAKASIH =====");
                break;
            } else {
                System.out.println("Pilihan Salah");
            }
        }

//        Nasabah nasabah1 = new Nasabah("Aldo Agustio", "123 Main St", 123456, 1000);
//        String nama = nasabah1.getNama();
//        nasabah1.tarikTunai(500);
//
//        NasabahVIP nasabahVIP1 = new NasabahVIP("gustio", "456 Main St", 654321, 2000, 10);
//
//        nasabahVIP1.tarikTunai(200);
//
//        Nasabah nasabah2 = new Nasabah("aldo", "123 Main St", 123456, 1000);
//        nasabah2.tarikTunai(500);
//        nasabah2.setorTunai(200);
//
//        Nasabah[] daftarNasabah;
//        daftarNasabah = new Nasabah[];
//
//        daftarNasabah[0] = new Nasabah("Aldo Agustio", "123 Main St", 123456, 1000);
//        daftarNasabah[1] = new Nasabah("gustio", "123 Main St", 123456, 1000);
//        daftarNasabah[2] = new Nasabah("aldo", "123 Main St", 123456, 1000);
////
//        for (int i = 0; i < daftarNasabah.length; i++) {
//            Nasabah nasabah = daftarNasabah[i];
//            System.out.println("Nama nasabah: " + nasabah.getNama());
//            System.out.println("Alamat nasabah: " + nasabah.getAlamat());
//        }
//
//       
    }

}