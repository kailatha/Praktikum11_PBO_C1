/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package jdbc.program;

/**
 *
 * @author Kaiii
 */

// Nama 	: Kaila Talitha Putri
// Nim 	: 24060123140179
// Lab 	: C1

import java.util.List;
import jdbc.model.Mahasiswa;
import jdbc.service.MysqlMahasiswaService;

public class Program {

    static MysqlMahasiswaService service = new MysqlMahasiswaService();

    public static void main(String[] args) {
        System.out.println("Koneksi berhasil\n");

        // === insert ===
        System.out.println("===insert");
        service.add(new Mahasiswa(1, "Nina"));
        service.add(new Mahasiswa(2, "Rudi"));
        service.add(new Mahasiswa(3, "Beni"));
        Mahasiswa mhsAdd = new Mahasiswa(5, "Haryo");
        service.add(mhsAdd);
        System.out.println("Berhasil insert: " + formatMhs(mhsAdd));
        displayAll();

        // === update ===
        System.out.println("===update");
        Mahasiswa mhsUpdate = service.getById(5);
        if (mhsUpdate != null) {
            System.out.println("Akan diupdate data lama: " + formatMhs(mhsUpdate));
            mhsUpdate.setNama("Dinaya");
            System.out.println("dengan data baru: " + formatMhs(mhsUpdate));
            service.update(mhsUpdate);
            System.out.println("Berhasil update");
        } else {
            System.out.println("Data tidak ditemukan untuk update");
        }
        displayAll();

        // === delete ===
        System.out.println("===delete");
        Mahasiswa mhsToDelete = service.getById(5);
        if (mhsToDelete != null) {
            System.out.println("akan di delete: " + formatMhs(mhsToDelete));
            service.delete(5);
            System.out.println("Berhasil delete");
        } else {
            System.out.println("Data tidak ditemukan untuk delete");
        }
        displayAll();
    }

    public static void displayAll() {
        System.out.println("===displayAll");
        List<Mahasiswa> semuaMhs = service.getAll();
        for (Mahasiswa m : semuaMhs) {
            System.out.println(formatMhs(m));
        }
        System.out.println(); // jeda baris
    }

    public static String formatMhs(Mahasiswa m) {
        return "Mahasiswa(id=" + m.getId() + ", nama=\"" + m.getNama() + "\")";
    }
}
