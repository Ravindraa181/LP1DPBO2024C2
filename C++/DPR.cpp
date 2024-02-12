// Import library yang dibutuhkan
#include <bits/stdc++.h>
#include <iostream>
#include <string>
#include <iomanip>

using namespace std; // Menggunakan standard namespace

class DPR // Membuat class DPR
{
private:           // Membuat atribut berjenis private
    string name;   // Untuk menyimpan nama
    int idNumber;  // Untuk menyimpan ID
    string bidang; // Untuk menyimpan bidang
    string partai; // Untuk menyimpan partai

public:
    /* Konstruktor */
    DPR() // Membuat konstruktor default
    {
        this->name = "";    // Meng-assign atribut name dengan string kosong
        this->idNumber = 0; // Meng-assign atribut idNumber dengan 0
        this->bidang = "";  // Meng-assign atribut bidang dengan string kosong
        this->partai = "";  // Meng-assign atribut partai dengan string kosong
    }

    DPR(string name, int idNumber, string bidang, string partai) // Membuat konstruktor dengan isian dari parameter
    {
        this->name = name;         // Meng-assign atribut name dengan nilai dari parameter name
        this->idNumber = idNumber; // Meng-assign atribut idNumber dengan nilai dari parameter idNumber
        this->bidang = bidang;     // Meng-assign atribut bidang dengan nilai dari parameter bidang
        this->partai = partai;     // Meng-assign atribut partai dengan nilai dari parameter partai
    }

    /* Setter dan Getter */
    void setName(string name) // Setter untuk atribut name
    {
        this->name = name; // Meng-assign atribut name dengan nilai dari parameter name
    }

    void setIdNumber(int idNumber) // Setter untuk atribut idNumber
    {
        this->idNumber = idNumber; // Meng-assign atribut idNumber dengan nilai dari parameter idNumber
    }

    void setBidang(string bidang) // Setter untuk atribut bidang
    {
        this->bidang = bidang; // Meng-assign atribut bidang dengan nilai dari parameter bidang
    }

    void setPartai(string partai) // Setter untuk atribut partai
    {
        this->partai = partai; // Meng-assign atribut partai dengan nilai dari parameter partai
    }

    string getName() // Getter untuk atribut name
    {
        return this->name; // Me-return nilai dari atribut name
    }

    int getIdNumber() // Getter untuk atribut idNumber
    {
        return this->idNumber; // Me-return nilai dari atribut idNumber
    }

    string getBidang() // Getter untuk atribut bidang
    {
        return this->bidang; // Me-return nilai dari atribut bidang
    }

    string getPartai() // Getter untuk atribut partai
    {
        return this->partai; // Me-return nilai dari atribut partai
    }

    /* Method untuk perintah pilihan */
    void commandOptions() // Method untuk menampilkan menu program CRUD
    {
        cout << "==============================\n";
        cout << "|        CRUD Program        |\n"; // CRUD = Create, Read, Update, Delete
        cout << "==============================\n";
        cout << "|  0. Exit the program       |\n"; // 0 untuk keluar dari program
        cout << "|  1. Add DPR data           |\n"; // 1 untuk menambahkan data anggota dpr
        cout << "|  2. Update DPR data        |\n"; // 2 untuk mengubah data anggota dpr
        cout << "|  3. Delete DPR data        |\n"; // 3 untuk menghapus data anggota dpr
        cout << "|  4. Show list of DPR       |\n"; // 4 untuk menampilkan semua data dalam daftar anggota dpr
        cout << "==============================\n";
        cout << "Enter your choice : ";
    }

    /* Method untuk CRUD */
    void addDPRData(list<DPR> &dprList, DPR temp, string name, int idNumber, string bidang, string partai) // Method untuk menambahkan data anggota dpr
    {
        // Proses setter data inputan ke setiap atribut dari objek temp
        temp.setName(name);
        temp.setIdNumber(idNumber);
        temp.setBidang(bidang);
        temp.setPartai(partai);

        if (dprList.empty()) // Jika list kosong, langsung masukan data ke dalam list
        {
            dprList.push_back(temp);                      // Memasukan data ke dalam list
            cout << "\n[SUCCESS] Data has been added.\n"; // Menampilkan pesan bahwa data berhasil dimasukan ke dalam list
        }
        else // Jika list tidak kosong, lakukan pengecekan terlebih dahulu
        {
            bool find = false;                        // Untuk mengecek apakah data sudah ada atau belum, nilai defaultnya adalah false yang menandakan data belum ada
            list<DPR>::iterator it = dprList.begin(); // Membuat iterator untuk mengecek data dalam list

            do // do while untuk mengecek apakah data sudah ada atau belum, pengecekkan menggunakan sebagai primary key
            {
                if (temp.getIdNumber() == it->getIdNumber()) // Jika sudah ada, maka data tidak akan dimasukan ke dalam list dan akan menampilkan pesan error
                {
                    find = true;                                                                                 // Jika sudah ada, maka nilai find akan berubah menjadi true
                    cout << "\n[ERROR] ID number already exists, please add data with a different ID number.\n"; // Pesan error
                }
                it++;                                       // Iterasi untuk mengecek data selanjutnya
            } while (find == false && it != dprList.end()); // Jika data belum ditemukan dan iterator belum sampai ke akhir list, maka akan melakukan proses pengecekan data berikutnya

            if (find == false) // Jika data tidak ditemukan, maka data akan dimasukan ke dalam list
            {
                dprList.push_back(temp);                      // Memasukan data ke dalam list
                cout << "\n[SUCCESS] Data has been added.\n"; // Menampilkan pesan bahwa data berhasil dimasukan ke dalam list
            }
        }
    }

    void updateDPRData(list<DPR> &dprList, int idNumber) // Method untuk mengubah data anggota dpr
    {
        bool find = false;                        // Untuk mengecek apakah data sudah ada atau belum, nilai defaultnya adalah false yang menandakan data tidak ditemukan
        list<DPR>::iterator it = dprList.begin(); // Membuat iterator untuk mengecek data dalam list

        do // do while untuk mengecek apakah data yang akan diubah ada di dalam dprList atau tidak
        {
            if (it->getIdNumber() == idNumber) // Jika data yang akan diubah ditemukan di dalam dprList, maka akan meminta beberapa masukan
            {
                find = true; // Jika data ditemukan, maka nilai find akan berubah menjadi true
                cout << "\nEnter Name    : ";
                cin >> name; // Meminta masukan untuk mengubah nama
                cout << "Enter bidang   : ";
                cin >> bidang; // Meminta masukan untuk mengubah bidang
                cout << "Enter partai   : ";
                cin >> partai; // Meminta masukan untuk mengubah partai

                *it = DPR(name, idNumber, bidang, partai);      // Mengubah data yang sudah ada di dalam dprList dengan data baru
                cout << "\n[SUCCESS] Data has been changed.\n"; // Menampilkan pesan bahwa data berhasil diubah
            }
            it++;                                       // Iterasi untuk mengecek data selanjutnya
        } while (find == false && it != dprList.end()); // Jika data belum ditemukan dan iterator belum sampai ke akhir list, maka akan melakukan proses pengecekan data berikutnya

        if (find == false)                                         // Jika data tidak ditemukan, maka akan menampilkan pesan error
            cout << "\n[ERROR] DPR data not found in the list.\n"; // Pesan error
    }

    void deleteDPRData(list<DPR> &dprList, int idNumber) // Method untuk menghapus data anggota dpr
    {
        bool find = false;                        // Untuk mengecek apakah data sudah ada atau belum, nilai defaultnya adalah false yang menandakan data belum ada
        list<DPR>::iterator it = dprList.begin(); // Membuat iterator untuk mengecek data dalam list

        do // do while untuk mengecek apakah data yang akan dihapus ada di dalam dprList atau tidak
        {
            if (it->getIdNumber() == idNumber) // Jika data yang akan dihapus ditemukan di dalam dprList, maka data akan dihapus
            {
                find = true;       // Jika data ditemukan, maka nilai find akan berubah menjadi true
                dprList.erase(it); // Menghapus data yang ditemukan

                cout << "\n[SUCCESS] Data has been deleted.\n"; // Menampilkan pesan bahwa data berhasil dihapus
            }
            it++;                                       // Iterasi untuk mengecek data selanjutnya
        } while (find == false && it != dprList.end()); // Jika data belum ditemukan dan iterator belum sampai ke akhir list, maka akan melakukan proses pengecekan data berikutnya

        if (find == false)                              // Jika data tidak ditemukan, maka akan menampilkan pesan error
            cout << "\n[ERROR] ID number not exist!\n"; // Pesan error
    }

    void showListOfDPR(list<DPR> &dprList) // Method untuk menampilkan data anggota dpr
    {
        if (dprList.empty()) // Jika list kosong, maka akan menampilkan pesan error
        {
            cout << "\n[WARNING] The DPR list is still empty.\n"; // Pesan error
        }
        else // Jika list tidak kosong, maka akan menampilkan data anggota dpr
        {
            int no = 0;
            cout << endl;

            // set lebar kolom
            int colWidth = 15;

            // header tabel
            cout << setw(5) << "ID" << setw(colWidth) << "Nama" << setw(colWidth) << "bidang" << setw(colWidth) << "partai" << endl;

            // garis pemisah antara header dan data
            cout << setfill('-') << setw(5) << "" << setw(colWidth) << "" << setw(colWidth) << "" << setw(colWidth) << "" << setfill(' ') << endl;

            // isi tabel
            for (auto &DPR : dprList)
            {
                cout << setw(5) << DPR.getIdNumber() << setw(colWidth) << DPR.getName() << setw(colWidth) << DPR.getBidang() << setw(colWidth) << DPR.getPartai() << endl;
            }

            cout << endl;
        }
    }

    /* Destruktor */
    ~DPR() // Membuat destruktor untuk menghapus semua objek yang telah dibuat
    {
    }
};