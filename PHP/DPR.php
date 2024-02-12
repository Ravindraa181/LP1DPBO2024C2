<?php

class DPR // Membuat class DPR
{
    /* Membuat atribut berjenis private */
    private $id; // Untuk menyimpan id
    private $nama; // Untuk menyimpan nama
    private $bidang; // Untuk menyimpan bidang
    private $partai; // Untuk menyimpan partai
    private $foto; // untuk menyimpan foto

    /* Konstruktor */
    public function __construct($id = '', $nama = 0, $bidang = '', $partai = '', $foto = '') // Membuat konstruktor dengan isian dari parameter
    {
        $this->id = $id;         // Meng-assign atribut id dengan nilai dari parameter id
        $this->nama = $nama; // Meng-assign atribut nama dengan nilai dari parameter nama
        $this->bidang = $bidang;       // Meng-assign atribut bidang dengan nilai dari parameter bidang
        $this->partai = $partai;   // Meng-assign atribut partai dengan nilai dari parameter partai
        $this->foto = $foto; // meng-asign atribut foto dengan nilai dari parameter foto
    }

    /* Setter dan Getter */
    public function setId($id) // Setter untuk atribut id
    {
        $this->id = $id; // Meng-assign atribut id dengan nilai dari parameter id
    }

    public function setNama($nama) // Setter untuk atribut nama
    {
        $this->nama = $nama; // Meng-assign atribut nama dengan nilai dari parameter nama
    }

    public function setBidang($bidang) // Setter untuk atribut bidang
    {
        $this->bidang = $bidang; // Meng-assign atribut bidang dengan nilai dari parameter bidang
    }

    public function setPartai($partai) // Setter untuk atribut partai
    {
        $this->partai = $partai; // Meng-assign atribut partai dengan nilai dari parameter partai
    }

    public function setFoto($foto) // Setter untuk atribut foto
    {
        $this->foto = $foto; // Meng-assign atribut foto dengan nilai dari parameter foto
    }

    public function getId() // Getter untuk atribut id
    {
        return $this->id; // Me-return nilai dari atribut id
    }

    public function getNama() // Getter untuk atribut nama
    {
        return $this->nama; // Me-return nilai dari atribut nama
    }

    public function getBidang() // Getter untuk atribut bidang
    {
        return $this->bidang; // Me-return nilai dari atribut bidang
    }

    public function getPartai() // Getter untuk atribut partai
    {
        return $this->partai; // Me-return nilai dari atribut partai
    }

    public function getFoto() // Getter untuk atribut foto
    {
        return $this->foto; // Me-return nilai dari atribut foto
    }

    /* Method untuk CRUD */
    public function addDPRData(&$DPRlist, $temp) // method untuk menambah data anggota dpr
    {
        if (empty($DPRlist)) { //Jika array kosong
            array_push($DPRlist, $temp); // Menambahkan data anggota dpr ke array
            echo "Data Anda Berhasil Ditambahkan" . "<br>"; // Menampilkan pesan bahwa  
        } else { // Jika array tidak kosong
            $find = false; // Untuk mengecek apakah data sudah ada atau belum, nilai defaultnya false yang menandakan data belum ada
            $i = 0; // Membuat iterator untuk mengecek data dalam list

            do { // do while untuk mengecek apakah data sudah ada atau belum, pengecekkan menggunakan nama sebagai primary key
                if ($temp->getNama() == $DPRlist[$i]->getNama()) { //Jika nama sudah ada, maka data tidak akan ditambahkan ke dalam array
                    $find = true; // Mengubah nilai find menjadi true
                    echo "Data Nama Telah Digunakan, Silahkan Menambahkan Data Baru dengan Nama Yang Berbeda." . "<br>"; // Menampilkan pesan error
                }
                $i++; // Iterasi untuk mengecek data selanjutnya
            } while ($find == false && $i < count($DPRlist)); // Jika data belum ditemukan dan iterator belum sampai ke akhir array, maka akan melakukan proses pengecekan berikutnya

            if ($find == false) { // Jika data tidak ditemukan, maka     data akan dimasukan ke dalam array
                array_push($DPRlist, $temp); // Memasukan data ke dalam array
                echo "Data Anda Berhasil Ditambahkan" . "<br>"; // Menampilkan pesan bahwa data berhasil dimasukan ke dalam array
            }
        }
    }

    public function updateDPRData(&$DPRlist, $temp, $id, $nama, $bidang, $partai) // Method untuk mengubah data anggota dpr
    {
        // Proses setter data inputan ke setiap atribut dari objek temp  
        $temp->setId($id);
        $temp->setNama($nama);
        $temp->setBidang($bidang);
        $temp->setPartai($partai);

        $find = false; // Untuk mengecek apakah data ada di dalam array atau tidak, nilai defaultnya false yang menandakan data tidak ada
        $i = 0; // Membuat iterator untuk mengecek data dalam list

        do { // do while untuk mengecek apakah data yang akan diubah ada di dalam array, pengecekan menggunakan nama sebagai primary key
            if ($temp->getNama() == $DPRlist[$i]->getNama()) { // Jika data anggota dpr ditemukan, maka akan langsung diubah datanya 
                $find = true; // Mengubah nilai find menjdai true
                $DPRlist[$i] = $temp; // Ubah data anggota dpr di array
                echo "Data Anda Berhasil Diubah" . "<br>"; // Menampilkan pesan berhasil mengubah data
            }
            $i++; // Iterasi untuk mengecek data selanjutnya
        } while ($find == false && $i < count($DPRlist)); // Jika data belum ditemukan dan iterator belum sampai ke akhir array, maka akan melakukan proses pengecekan berikutnya

        if ($find == false) { // Jika data tidak ditemukan, maka akan menampilkan pesan error
            echo "Gagal Mengubah Data Tidak Ada Didalam List" . "<br>";
        }
    }

    public function deleteDPRData(&$DPRlist, $nama) // Method untuk menghapus data anggota dpr
    {
        $find = false; // Untuk mengecek apakah data ada di dalam array atau tidak, nilai defaultnya false yang menandakan data tidak ada
        $i = 0; // Membuat iterator untuk mengecek data dalam list

        do { // do while untuk mengecek apakah data yang akan dihapus ada di dalam array, pengecekan menggunakan nama sebagai primary key
            if ($nama == $DPRlist[$i]->getNama()) { // Jika data anggota dpr ditemukan, maka akan langsung dihapus datanya
                $find = true; // Mengubah nilai find menjdai true
                array_splice($DPRlist, $i, 1); // Menghapus data anggota dpr di dalam array
                echo "Data Anda Berhasil Dihapus" . "<br>"; // Menampilkan pesan berhasil menghapus data
            }
            $i++; // Iterasi untuk mengecek data selanjutnya
        } while ($find == false && $i < count($DPRlist)); // Jika data belum ditemukan dan iterator belum sampai ke akhir array, maka akan melakukan proses pengecekan berikutnya

        if ($find == false) { // Jika data tidak ditemukan, maka akan menampilkan pesan error
            echo "Gagal Menghapus Data Nama Tidak Ada didalam List!" . "<br>";
        }
    }

    public function showListOfDPR($DPRlist) // Method untuk menampilkan semua data anggota dpr di dalam array
    {
        if (empty($DPRlist)) { // Jika array kosong
            echo "[WARNING] The DPR list is still empty." . "<br>"; // Menampilkan pesan error
        } else { // Jika array ada isinya
            echo "<h3>Data Dari List DPR</h3>"; // Judul Tabel
            echo "<table border='1' cellpadding='5' cellspacing = '0'>";
            echo "<tr>";
            echo "<th>id</th>" . "<th>Nama</th>" . "<th>bidang</th>" . "<th>partai</th>". "<th>foto</th>"; // Header Tabel
            echo "</tr>";
            $no = 1;
            /* Menampilkan semua data anggota dpr */
            for ($i = 0; $i < count($DPRlist); $i++) {
                echo "<tr>";
                // echo "<td>" . $no . '. ' . "</td>";
                echo "<td>" . $DPRlist[$i]->getId() . "</td>";
                echo "<td>" . $DPRlist[$i]->getNama() . "</td>";
                echo "<td>" . $DPRlist[$i]->getBidang() . "</td>";
                echo "<td>" . $DPRlist[$i]->getPartai() . "</td>";
                echo "<td><img src=\"".  $DPRlist[$i]->getFoto() . "\" width='50px' /></td>";
                echo "</tr>";
            }
            echo "</table>";
            echo "<br>";
        }
    }
}