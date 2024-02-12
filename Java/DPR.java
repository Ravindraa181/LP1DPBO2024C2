// Import library
import java.util.Scanner;
import java.util.ArrayList;

public class DPR { // Membuat class DPR
    /* Membuat atribut berjenis private */
    private String name; // Untuk menyimpan nama
    private int idNumber; // Untuk menyimpan Id (ID number)
    private String bidang; // Untuk menyimpan jurusan
    private String partai; // Untuk menyimpan fakultas

    /* Konstruktor */
    public DPR() // Membuat konstruktor default
    {
        this.name = ""; // Meng-assign atribut name dengan string kosong
        this.idNumber = 0; // Meng-assign atribut idNumber dengan 0
        this.bidang = ""; // Meng-assign atribut bidang dengan string kosong
        this.partai = ""; // Meng-assign atribut partai dengan string kosong
    }

    public DPR(String name, int idNumber, String bidang, String partai) // Membuat konstruktor dengan isian dari
                                                                            // parameter
    {
        this.name = name; // Meng-assign atribut name dengan nilai dari parameter name
        this.idNumber = idNumber; // Meng-assign atribut idNumber dengan nilai dari parameter idNumber
        this.bidang = bidang; // Meng-assign atribut bidang dengan nilai dari parameter bidang
        this.partai = partai; // Meng-assign atribut partai dengan nilai dari parameter partai
    }

    /* Setter dan Getter */
    public void setName(String name) // Setter untuk atribut name
    {
        this.name = name; // Meng-assign atribut name dengan nilai dari parameter name
    }

    public void setIdNumber(int idNumber) // Setter untuk atribut idNumber
    {
        this.idNumber = idNumber; // Meng-assign atribut idNumber dengan nilai dari parameter idNumber
    }

    public void setBidang(String bidang) // Setter untuk atribut bidang
    {
        this.bidang = bidang; // Meng-assign atribut bidang dengan nilai dari parameter bidang
    }

    public void setPartai(String partai) // Setter untuk atribut partai
    {
        this.partai = partai; // Meng-assign atribut partai dengan nilai dari parameter partai
    }

    public String getName() // Getter untuk atribut name
    {
        return this.name; // Me-return nilai dari atribut name
    }

    public int getIdNumber() // Getter untuk atribut idNumber
    {
        return this.idNumber; // Me-return nilai dari atribut idNumber
    }

    public String getBidang() // Getter untuk atribut bidang
    {
        return this.bidang; // Me-return nilai dari atribut bidang
    }

    public String getPartai() // Getter untuk atribut partai
    {
        return this.partai; // Me-return nilai dari atribut partai
    }

    /* Method untuk perintah pilihan */
    public void commandOptions() // Method untuk menampilkan menu program CRUD
    {
        System.out.println("==============================");
        System.out.println("|        CRUD Program        |"); // CRUD = Create, Read, Update, Delete
        System.out.println("==============================");
        System.out.println("|  0. Exit the program       |"); // 0 untuk keluar dari program
        System.out.println("|  1. Add DPR data           |"); // 1 untuk menambahkan data anggota dpr
        System.out.println("|  2. Update DPR data        |"); // 2 untuk mengubah data anggota dpr
        System.out.println("|  3. Delete DPR data        |"); // 3 untuk menghapus data anggota dpr
        System.out.println("|  4. Show list of DPR       |"); // 4 untuk menampilkan semua data dalam daftar anggota dpr
        System.out.println("==============================");
        System.out.print("Enter your choice : ");
    }

    /* Method untuk CRUD */
    public void addDPRData(ArrayList<DPR> dprList, DPR temp, String name, int idNumber, String bidang,
            String partai) // Method untuk menambahkan data anggota dpr
    {
        // Proses setter dari inputan ke setiap atribut dari objek temp
        temp.setName(name);
        temp.setIdNumber(idNumber);
        temp.setBidang(bidang);
        temp.setPartai(partai);

        if (dprList.isEmpty()) // Jika list kosong, langsung masukan data ke dalam list
        {
            dprList.add(temp); // Memasukan data ke dalam list
            System.out.println("\n[SUCCESS] Data has been added."); // Menampilkan pesan bahwa data berhasil
                                                                    // dimasukan ke dalam list
        } else // Jika list tidak kosong, lakukan pengecekan terlebih dahulu
        {
            boolean find = false; // Untuk mengecek apakah data sudah ada atau belum, nilai defaultnya
                                  // adalah false yang menandakan data belum ada
            int i = 0; // Membuat iterator untuk mengecek data dalam list

            /*
             * do while untuk mengecek apakah data sudah ada atau belum, pengecekkan
             * menggunakan Id sebagai primary key
             */
            do {
                if (temp.getIdNumber() == dprList.get(i).getIdNumber()) // Jika Id sudah ada, maka data tidak akan
                                                                            // dimasukan ke dalam list dan akan
                                                                            // menampilkan pesan error
                {
                    find = true; // Jika Id sudah ada, maka nilai find akan berubah menjadi true
                    System.out.println(
                            "\n[ERROR] ID number already exists, please add data with a different ID number."); // Pesan
                                                                                                                // error
                }
                i++; // Iterasi untuk mengecek data selanjutnya
            } while (find == false && i < dprList.size()); // Jika data belum ditemukan dan iterator
                                                               // belum sampai ke akhir list, maka akan
                                                               // melakukan proses pengecekan data
                                                               // berikutnya

            if (find == false) // Jika data tidak ditemukan, maka data akan dimasukan ke dalam list
            {
                dprList.add(temp); // Memasukan data ke dalam list
                System.out.println("\n[SUCCESS] Data has been added."); // Menampilkan pesan bahwa data
                                                                        // berhasil dimasukan ke dalam list
            }
        }
    }

    public void updateDPRData(ArrayList<DPR> dprList, int idNumber, Scanner scan) // Method untuk mengubah
                                                                                              // data anggota dpr
    {
        boolean find = false; // Untuk mengecek apakah data sudah ada atau belum, nilai defaultnya adalah
                              // false yang menandakan data tidak ditemukan
        int i = 0; // Membuat iterator untuk mengecek data dalam list

        /*
         * do while untuk mengecek apakah data yang akan diubah ada di dalam dprList
         * atau tidak
         */
        do {
            if (dprList.get(i).getIdNumber() == idNumber) // Jika data yang akan diubah ditemukan di dalam
                                                              // dprList, maka akan meminta beberapa masukan
            {
                find = true; // Jika data ditemukan, maka nilai find akan berubah menjadi true
                System.out.print("\nEnter Name     : ");
                name = scan.next(); // Meminta masukan untuk mengubah nama
                System.out.print("Enter bidang   : ");
                bidang = scan.next(); // Meminta masukan untuk mengubah jurusan
                System.out.print("Enter partai   : ");
                partai = scan.next(); // Meminta masukan untuk mengubah fakultas

                dprList.set(i, new DPR(name, idNumber, bidang, partai)); // Mengubah data yang sudah ada di
                // dalam dprList dengan data baru
                System.out.println("\n[SUCCESS] Data has been changed."); // Menampilkan pesan bahwa data berhasil
                                                                          // diubah
            }
            i++; // Iterasi untuk mengecek data selanjutnya
        } while (find == false && i < dprList.size()); // Jika data belum ditemukan dan iterator belum sampai ke
                                                           // akhir list, maka akan melakukan proses pengecekan data
                                                           // berikutnya

        if (find == false) // Jika data tidak ditemukan, maka akan menampilkan pesan error
            System.out.println("\n[ERROR] DPR data not found in the list."); // Pesan error
    }

    public void deleteDPRData(ArrayList<DPR> dprList, int idNumber) // Method untuk menghapus data anggota dpr
    {
        boolean find = false; // Untuk mengecek apakah data sudah ada atau belum, nilai defaultnya adalah
                              // false yang menandakan data belum ada
        int i = 0; // Membuat iterator untuk mengecek data dalam list

        /*
         * do while untuk mengecek apakah data yang akan dihapus ada di dalam
         * dprList atau tidak
         */
        do {
            if (dprList.get(i).getIdNumber() == idNumber) // Jika data yang akan dihapus ditemukan di dalam
                                                              // dprList, maka data akan dihapus
            {
                find = true; // Jika data ditemukan, maka nilai find akan berubah menjadi true
                dprList.remove(i); // Menghapus data yang ditemukan

                System.out.println("\n[SUCCESS] Data has been deleted."); // Menampilkan pesan bahwa data berhasil
                                                                          // dihapus
            }
            i++; // Iterasi untuk mengecek data selanjutnya
        } while (find == false && i < dprList.size()); // Jika data belum ditemukan dan iterator belum sampai ke
                                                           // akhir list, maka akan melakukan proses pengecekan data
                                                           // berikutnya

        if (find == false) // Jika data tidak ditemukan, maka akan menampilkan pesan error
            System.out.println("\n[ERROR] ID number not exist!"); // Pesan error
    }

    public void showListOfDPR(ArrayList<DPR> dprList) // Method untuk menampilkan data anggota dpr
    {
        if (dprList.isEmpty()) // Jika list kosong, maka akan menampilkan pesan error
        {
            System.out.println("\n[WARNING] The DPR list is still empty."); // Pesan error
        } else // Jika list tidak kosong, maka akan menampilkan data anggota dpr
        {
            int i = 0; // Untuk menampilkan nomor urut data anggota dpr

            System.out.println(); // Memberikan jarak antara menu dan data anggota dpr

            for (dprList.get(i); i < dprList.size(); i++) // Looping untuk menampilkan data anggota dpr
            {
                /* Menampilkan nomor urut, nama, Id, jurusan, dan fakultas. */
                System.out.println("   ID       : " + dprList.get(i).getIdNumber());
                System.out.println("   Nama     : " + dprList.get(i).getName());
                System.out.println("   Bidang   : " + dprList.get(i).getBidang());
                System.out.println("   Partai   : " + dprList.get(i).getPartai());
                if (i != dprList.size() - 1) // Jika bukan data terakhir, maka akan memberikan jarak antara data
                                                 // anggota dpr
                {
                    System.out.println();
                }
            }
        }
    }
}