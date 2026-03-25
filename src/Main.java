import java.util.ArrayList;
import java.util.List;

// abstraction
abstract class Kendaraan {
    protected String nomorKendaraan;

    public Kendaraan(String nomorKendaraan) {
        this.nomorKendaraan = nomorKendaraan;
    }

    public String getNomorKendaraan() {
        return nomorKendaraan;
    }

    // setiap kendaraan harus punya jenis (mobil/motor)
    public abstract String getTipeKendaraan();
}

// inheritance
class Mobil extends Kendaraan {
    public Mobil(String nomorKendaraan) {
        super(nomorKendaraan);
    }

    public String getTipeKendaraan() {
        return "Mobil";
    }
}

class Motor extends Kendaraan {
    public Motor(String nomorKendaraan) {
        super(nomorKendaraan);
    }

    public String getTipeKendaraan() {
        return "Motor";
    }
}

class Tiket {
    private int idTiket;
    private int durasi;
    private int jamMasuk;

    public Tiket(int idTiket, int durasi, int jamMasuk) {
        this.idTiket = idTiket;
        this.durasi = durasi;
        this.jamMasuk = jamMasuk;
    }

    public int getIdTiket() {
        return idTiket;
    }

    // biaya parkir berdasarkan jenis kendaraan
    public double hitungBiaya(String tipeKendaraan) {
        if ("Mobil".equals(tipeKendaraan)) {
            return durasi * 5000;
        } else {
            return durasi * 2000;
        }
    }

    public int getJamMasuk() {
        return jamMasuk;
    }
}

// sistem parkir
class TempatParkir {
    // menyimpan kendaraan yang sedang parkir
    private List<Kendaraan> daftarKendaraan = new ArrayList<>();

    public void tambahKendaraan(Kendaraan k) {
        daftarKendaraan.add(k);
        System.out.println(k.getTipeKendaraan() + " masuk: " + k.getNomorKendaraan());
    }

    public int getTotalKendaraan() {
        return daftarKendaraan.size();
    }

    // menampilkan semua kendaraan
    public void tampilkanSemuaKendaraan() {
        System.out.println("\nDaftar kendaraan di parkiran:");
        for (Kendaraan k : daftarKendaraan) {
            System.out.println("- " + k.getTipeKendaraan() + " | " + k.getNomorKendaraan());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        TempatParkir parkir = new TempatParkir();

        Kendaraan mobil1 = new Mobil("B 1234 ABC");
        Kendaraan motor1 = new Motor("AE 5678 XYZ");

        parkir.tambahKendaraan(mobil1);
        parkir.tambahKendaraan(motor1);

        Tiket tiket1 = new Tiket(1, 2, 10);
        Tiket tiket2 = new Tiket(2, 3, 11);

        System.out.println("\n=== STRUK PARKIR ===");
        System.out.println("Ticket ID: " + tiket1.getIdTiket());
        System.out.println("Jenis: " + mobil1.getTipeKendaraan());
        System.out.println("Plat: " + mobil1.getNomorKendaraan());
        System.out.println("Jam masuk: " + tiket1.getJamMasuk());
        System.out.println("Biaya: " + tiket1.hitungBiaya(mobil1.getTipeKendaraan()));

        System.out.println("\n=== STRUK PARKIR ===");
        System.out.println("Ticket ID: " + tiket2.getIdTiket());
        System.out.println("Jenis: " + motor1.getTipeKendaraan());
        System.out.println("Plat: " + motor1.getNomorKendaraan());
        System.out.println("Jam masuk: " + tiket2.getJamMasuk());
        System.out.println("Biaya: " + tiket2.hitungBiaya(motor1.getTipeKendaraan()));

        parkir.tampilkanSemuaKendaraan();

        System.out.println("\nTotal kendaraan: " + parkir.getTotalKendaraan());
    }
}
