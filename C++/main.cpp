/*
Saya Ravindra Maulana Sahman NIM 2108724 mengerjakan soal Latihan Praktikum 1 dalam mata kuliah DPBO untuk 
keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin
*/
#include "DPR.cpp" // Import file DPR.cpp

using namespace std; // Menggunakan standard namespace

int main()
{
    bool flag = true;  // Deklarasi variabel flag untuk menentukan apakah program akan berulang atau tidak
    DPR dprObject;     // Deklarasi objek dprObject dari kelas DPR
    list<DPR> dprList; // Deklarasi list dprList dari kelas DPR

    do // do while untuk menampilkan menu dan meminta input dari user
    {
        system("cls");              // Membersihkan layar
        dprObject.commandOptions(); // Menampilkan menu pilihan

        int input;    // Deklarasi variabel input untuk menyimpan masukan dari user
        cin >> input; // Meminta input dari user

        int idNumber;                // Deklarasi variabel idNumber untuk menyimpan ID anggota dpr
        string name, bidang, partai; // Deklarasi variabel name, bidang, dan partai untuk menyimpan nama, bidang, dan partai anggota dpr

        switch (input) // Switch case untuk menentukan apa yang akan dilakukan berdasarkan input dari user
        {
        case 0:           // Jika input = 0, maka program akan berhenti
            flag = false; // Mengubah nilai flag menjadi false
            break;
        case 1: // Jika input = 1, maka program akan meminta input dari user terkait data anggota dpr yang akan ditambahkan
            cout << "Enter ID      : ";
            cin >> idNumber; // Meminta input dari user untuk ID anggota dpr
            cout << "Enter Nama    : ";
            cin >> name; // Meminta input dari user untuk nama anggota dpr
            cout << "Enter bidang  : ";
            cin >> bidang; // Meminta input dari user untuk bidang anggota dpr
            cout << "Enter partai  : ";
            cin >> partai; // Meminta input dari user untuk partai anggota dpr

            dprObject.addDPRData(dprList, dprObject, name, idNumber, bidang, partai); // Memanggil method addDPRData untuk menambahkan data anggota dpr ke dalam list
            break;
        case 2:                  // Jika input = 2, maka program akan meminta input dari user untuk mengubah data anggota dpr
            if (dprList.empty()) // Jika list kosong, maka akan menampilkan pesan peringatan
            {
                cout << "\n[WARNING] The DPR list is still empty.\n"; // Pesan peringatan
            }
            else // Jika list tidak kosong, maka akan meminta input dari user untuk ID anggota dpr yang akan diubah
            {
                cout << "\nEnter the ID number of the DPR you want to change : ";
                cin >> idNumber;

                dprObject.updateDPRData(dprList, idNumber); // Memanggil method updateDPRData untuk mengubah data anggota dpr di dalam list
            }
            break;
        case 3:                  // Jika input = 3, maka program akan meminta input dari user untuk menghapus data anggota dpr (berdasarkan )
            if (dprList.empty()) // Jika list kosong, maka akan menampilkan pesan peringatan
            {
                cout << "\n[WARNING] The DPR list is still empty.\n"; // Pesan peringatan
            }
            else // Jika list tidak kosong, maka akan meminta input dari user untuk ID anggota dpr yang akan dihapus
            {
                cout << "\nEnter the ID number of the DPR you want to delete : ";
                cin >> idNumber;

                dprObject.deleteDPRData(dprList, idNumber); // Memanggil method deleteDPRData untuk menghapus data anggota dpr di dalam list
            }
            break;
        case 4:                               // Jika input = 4, maka program akan menampilkan seluruh data anggota dpr yang ada di dalam list
            dprObject.showListOfDPR(dprList); // Memanggil method showListOfDPR untuk menampilkan seluruh data anggota dpr yang ada di dalam list
            break;
        default:                                                      // Jika input selain 0, 1, 2, 3, dan 4, maka akan menampilkan pesan peringatan
            cout << "\n[WARNING] Invalid input, please try again.\n"; // Pesan peringatan
            break;
        }

        if (input != 0) // Jika input tidak sama dengan 0, maka akan menampilkan 2 enter dan mempause program
        {
            cout << "\n\n";
            system("pause"); // Mempause program
        }
    } while (flag == true); // Loop akan berhenti jika flag bernilai false, yakni jika user memasukkan 0

    return 0;
}