# LP1DPBO2024C2

### Saya Ravindra Maulana Sahman NIM 2108724 mengerjakan Latihan 1 dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

## Deskripsi Tugas
Buatlah program berbasis OOP menggunakan bahasa pemrograman C++, Java, Python, dan PHP yang menampilkan informasi daftar anggota DPR (sekumpulan objek anggota DPR) dan memiliki fitur menambah, mengubah, dan menghapus data. Setiap anggota DPR memiliki data id, nama, nama bidang, nama partai, dan foto profil (khusus bahasa PHP). 

## Desain Program
Program didesain dalam satu class:

* DPR
Pada class DPR terdapat 4 atribut :

* name -> berisikan Nama anggotaDpr dengan tipe data string
* idNumber -> berisikan NIM anggotaDpr dengan tipe data integer
* bidang -> berisikan Bidang anggotaDpr dengan tipe data string
* partai -> berisikan Partai anggotaDpr dengan tipe data string
* Tiap atribut memiliki setter dan getternya masing-masing yang berada pada class DPR.

Selain itu, dalam class DPR ini juga terdapat 4-6 method yang digunakan untuk memproses operasi CRUD diantaranya Create, Read, Update, dan Delete.

commandOptions -> untuk menampilkan menu CRUD yang dapat dipilih oleh pengguna
addDPRData -> untuk menambahkan data anggotaDpr
updateDPRData -> untuk mengubah data anggotaDpr
deleteDPRData -> untuk menghapus data anggotaDpr
showListOfDPR -> untuk menampilkan data anggotaDpr
clearScreen -> untuk membersihkan layar pertama kali program dijalankan (Java)
## Alur Program
Pada umumnya, semua program yang dibuat memiliki alur yang sama, hanya saja pada source code Php tidak tersedia menu input dari pengguna (data diinput secara hardcode).

Pertama program akan menampilkan menu CRUD yang dapat dipilih oleh pengguna. Pengguna akan diminta menginput perintah sampai program berakhir. Kelima perintahnya yaitu:

* 0 -> untuk keluar dari program atau dari menu CRUD
* 1 -> untuk menjalankan perintah 'addDPRData' yaitu menginput data kedalam list
* 2 -> untuk menjalankan perintah 'updateDPRData' yaitu mengubah data yang ada didalam list dengan data inputan yang baru dari user
* 3 -> untuk menjalankan perintah 'deleteDPRData' yaitu untuk menghapus data yang ada didalam list sesuai dengan perintah user
* 4 -> untuk menjalankan perintah 'showListOfDPR' yaitu untuk menampilkan output dari semua data yang telah di input oleh user dalam bentuk tabel sederhana

## Dokumentasi
* Pada Program Python
#### addlist
![addlistdpr](https://github.com/Ravindraa181/LP1DPBO2024C2/assets/100990733/79364da8-efd8-4e7a-bc8c-4317b5be1827)

#### showlist
![showlistdpr](https://github.com/Ravindraa181/LP1DPBO2024C2/assets/100990733/4fdd782e-9630-4848-a249-39deb86d64e4)

#### updatelist
![updatelistdpr](https://github.com/Ravindraa181/LP1DPBO2024C2/assets/100990733/c05db27d-0ccd-4e99-b299-0a987a7f1d38)

#### deletelist
![deletelistdpr](https://github.com/Ravindraa181/LP1DPBO2024C2/assets/100990733/b95e8662-6484-4d35-bfc3-2c0c5156a7ed)

#### showlist
![showakhirlistdpr](https://github.com/Ravindraa181/LP1DPBO2024C2/assets/100990733/7853f3a4-d1a2-4798-a654-fd8df8ee3123)

* Pada Program PHP

#### Create Data
![createdataphp](https://github.com/Ravindraa181/LP1DPBO2024C2/assets/100990733/5617f702-3cb6-4cbe-bf6b-cd7ed4af3ca8)

#### Update Data
![updatedataphp](https://github.com/Ravindraa181/LP1DPBO2024C2/assets/100990733/ce28206f-3966-42ca-8bd4-7ab60bb0d1f8)

#### Delete Data
![deletedataphp](https://github.com/Ravindraa181/LP1DPBO2024C2/assets/100990733/42877abb-e452-403e-94ca-468d8b0da692)
