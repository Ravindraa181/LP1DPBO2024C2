# Saya Ravindra Maulana Sahman NIM 2108724 mengerjakan soal Latihan Praktikum 1 dalam mata kuliah DPBO untuk 
# keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin

import os # Import library os untuk mengakses fungsi-fungsi yang berhubungan dengan sistem operasi
from DPR import DPR # Import class DPR dari file DPR.py

flag = True # Flag untuk menentukan apakah program akan berhenti atau tidak
dprList = [] # List untuk menyimpan objek anggota dpr

while flag: # while akan terus berjalan selama flag bernilai True
    dprObject = DPR() # Membuat objek dari class DPR
    os.system('cls' if os.name == 'nt' else 'clear') # Menghapus layar
    dprObject.commandOptions() # Menampilkan menu

    choice = int(input()) # Meminta input dari user untuk memilih menu

    if choice == 0: # Jika user memilih menu 0, maka program akan berhenti
        flag = False # Mengubah nilai flag menjadi False
    elif choice == 1: # Jika user memilih menu 1, maka program akan meminta input dari user untuk data anggota dpr
        idNumber = int(input("\nEnter ID        : ")) # Meminta input dari user untuk ID anggota dpr
        name = input("Enter Nama      : ") # Meminta input dari user untuk nama anggota dpr
        bidang = input("Enter Bidang    : ") # Meminta input dari user untuk bidang anggota dpr
        partai = input("Enter Partai    : ") # Meminta input dari user untuk partai anggota dpr

        dprObject.addDPRData(dprList, dprObject, name, idNumber, bidang, partai) # Memanggil method addDPRData untuk menambahkan data anggota dpr ke dalam list
    elif choice == 2: # Jika user memilih menu 2, maka program akan meminta input dari user untuk ID anggota dpr yang akan diubah
        if len(dprList) == 0: # Jika list kosong, maka akan menampilkan pesan peringatan
            print('\n' + "[WARNING] The DPR list is still empty." + '\n\n') # Pesan peringatan
        else: # Jika list tidak kosong, maka akan meminta input dari user untuk ID anggota dpr yang akan diubah
            idNumber = int(input("\nEnter the ID number of the DPR you want to change : "))
            
            dprObject.updateDPRData(dprList, idNumber); # Memanggil method updateDPRData untuk mengubah data anggota dpr di dalam list
    elif choice == 3: # Jika user memilih menu 3, maka program akan meminta input dari user untuk ID anggota dpr yang akan dihapus
        if len(dprList) == 0: # Jika list kosong, maka akan menampilkan pesan peringatan
           print('\n' + "[WARNING] The DPR list is still empty." + '\n\n') # Pesan peringatan
        else: # Jika list tidak kosong, maka akan meminta input dari user untuk ID anggota dpr yang akan dihapus
            idNumber = int(input("\nEnter the ID number of the DPR you want to delete : "))
            
            dprObject.deleteDPRData(dprList, idNumber); # Memanggil method deleteDPRData untuk menghapus data anggota dpr di dalam list
    elif choice == 4: # Jika user memilih menu 4, maka program akan menampilkan data anggota dpr yang ada di dalam list
        dprObject.showListOfDPR(dprList) # Memanggil method showListOfDPR untuk menampilkan data anggota dpr yang ada di dalam list
    else: # Jika user memilih menu selain 0, 1, 2, 3, dan 4, maka akan menampilkan pesan peringatan
        print('\n' + "[WARNING] Invalid input, please try again." + '\n\n') # Pesan peringatan

    if(choice != 0): # Jika user memilih menu selain 0, maka akan menampilkan pesan untuk menekan tombol apapun untuk melanjutkan
        os.system("pause") # Menampilkan pesan untuk menekan tombol apapun untuk melanjutkan
