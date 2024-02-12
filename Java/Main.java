/*
 * Saya Ravindra Maulana Sahman NIM 2108724 mengerjakan soal Latihan Praktikum 1 dalam mata kuliah DPBO untuk 
 * keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin
 */

// Import library
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) { // Method main yang akan dijalankan pertama kali
        ArrayList<DPR> dprList = new ArrayList<>(); // Membuat objek ArrayList untuk menyimpan data anggota dpr
        Scanner scan = new Scanner(System.in); // Membuat objek Scanner untuk meminta masukan dari user

        boolean flag = true; // Deklarasi variabel flag untuk menentukan apakah program akan berulang atau
                             // tidak
        int input; // Deklarasi variabel input untuk menyimpan masukan dari user

        do {
            DPR dprObject = new DPR(); // Deklarasi objek dprObject dari kelas DPR
            dprObject.commandOptions(); // Menampilkan menu

            input = scan.nextInt(); // Meminta input dari user
            int idNumber; // Deklarasi variabel idNumber untuk menyimpan ID (ID Number) anggota dpr
            String name, bidang, partai; // Deklarasi variabel name, bidang, dan partai untuk menyimpan nama,
                                         // jurusan, dan fakultas anggota dpr

            switch (input) // Switch case untuk menentukan apa yang akan dilakukan berdasarkan input dari
                           // user
            {
                case 0: // Jika input = 0, maka program akan berhenti
                    flag = false; // Mengubah nilai flag menjadi false
                    break;
                case 1: // Jika input = 1, maka program akan meminta input dari user terkait data
                        // anggota dpr yang akan ditambahkan
                    System.out.print("\nEnter ID        : ");
                    idNumber = scan.nextInt(); // Meminta input dari user untuk nama anggota dpr
                    System.out.print("Enter Name      : ");
                    name = scan.next(); // Meminta input dari user untuk nama anggota dpr
                    System.out.print("Enter Bidang    : ");
                    bidang = scan.next(); // Meminta input dari user untuk nama anggota dpr
                    System.out.print("Enter Partai    : ");
                    partai = scan.next(); // Meminta input dari user untuk nama anggota dpr

                    // Memanggil method addDPRData untuk menambahkan data anggota dpr ke dalam
                    // list
                    dprObject.addDPRData(dprList, dprObject, name, idNumber, bidang, partai);
                    break;
                case 2: // Jika input = 2, maka program akan meminta input dari user untuk mengubah data
                        // anggota dpr
                    if (dprList.isEmpty()) { // Jika list kosong, maka akan menampilkan pesan peringatan
                        System.out.println("\n[WARNING] The DPR list is still empty."); // Pesan peringatan
                    } else // Jika list tidak kosong, maka akan meminta input dari user untuk ID (ID
                           // Number) anggota dpr yang akan diubah
                    {
                        System.out.print("\nEnter the ID number of the DPR you want to change : ");
                        idNumber = scan.nextInt();

                        // Memanggil method updateDPRData untuk mengubah data anggota dpr di dalam
                        // list
                        dprObject.updateDPRData(dprList, idNumber, scan);
                    }
                    break;
                case 3: // Jika input = 3, maka program akan meminta input dari user untuk menghapus
                        // data anggota dpr (berdasarkan ID)
                    if (dprList.isEmpty()) { // Jika list kosong, maka akan menampilkan pesan peringatan
                        System.out.println("\n[WARNING] The DPR list is still empty."); // Pesan peringatan
                    } else // Jika list tidak kosong, maka akan meminta input dari user untuk ID (ID
                           // Number) anggota dpr yang akan dihapus
                    {
                        System.out.print("\nEnter the ID number of the DPR you want to delete : ");
                        idNumber = scan.nextInt();

                        // Memanggil method deleteDPRData untuk menghapus data anggota dpr di dalam
                        // list
                        dprObject.deleteDPRData(dprList, idNumber);
                    }
                    break;
                case 4: // Jika input = 4, maka program akan menampilkan seluruh data anggota dpr yang
                        // ada
                        // di dalam list
                    // Memanggil method showListOfDPR untuk menampilkan seluruh data anggota dpr
                    // yang ada di dalam list
                    dprObject.showListOfDPR(dprList);
                    break;
                default: // Jika input selain 0, 1, 2, 3, dan 4, maka akan menampilkan pesan peringatan
                    System.out.println("\n[WARNING] Invalid input, please try again."); // Pesan peringatan
                    break;
            }

            if (input != 0) // Jika input tidak sama dengan 0, maka akan menampilkan 2 enter dan mempause
                            // program
            {
                System.out.println('\n');
                /* Mempause program */
                System.out.println("Press any key to continue . . .");
                new java.util.Scanner(System.in).nextLine();
            }
        } while (flag == true); // loop akan berhenti jika flag bernilai false, yakni jika user memasukkan 0

        scan.close(); // Menterminasi Scanner
    }
}
