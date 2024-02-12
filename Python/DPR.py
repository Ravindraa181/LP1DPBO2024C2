from prettytable import PrettyTable # Import library untuk menampilkan data dalam bentuk tabel

class DPR: # Membuat class DPR
    __name = "" # Membuat atribut __name berjenis private
    __idNumber = 0 # Membuat atribut __idNumber berjenis private
    __bidang = "" # Membuat atribut __bidang berjenis private
    __partai = "" # Membuat atribut __partai berjenis private

    def __init__(self, name = "", idNumber = 0, bidang = "", partai = ""): # Membuat constructor
        self.__name = name # Menginisialisasi atribut __name
        self.__idNumber = idNumber # Menginisialisasi atribut __idNumber
        self.__bidang = bidang # Menginisialisasi atribut __bidang
        self.__partai = partai # Menginisialisasi atribut __partai

    def setName(self, name): # Setter untuk atribut __name
        self.__name = name # Menginisialisasi atribut __name
    
    def setIdNumber(self, idNumber): # Setter untuk atribut __idNumber
        self.__idNumber = idNumber # Menginisialisasi atribut __idNumber

    def setBidang(self, bidang): # Setter untuk atribut __bidang
        self.__bidang = bidang # Menginisialisasi atribut __bidang

    def setPartai(self, partai): # Setter untuk atribut __partai
        self.__partai = partai # Menginisialisasi atribut __partai

    def getName(self): # Getter untuk atribut __name
        return self.__name # Mengembalikan nilai atribut __name

    def getIdNumber(self): # Getter untuk atribut __idNumber
        return self.__idNumber # Mengembalikan nilai atribut __idNumber

    def getBidang(self): # Getter untuk atribut __bidang
        return self.__bidang # Mengembalikan nilai atribut __bidang

    def getPartai(self): # Getter untuk atribut __partai
        return self.__partai # Mengembalikan nilai atribut __partai

    def commandOptions(self): # Membuat method untuk menampilkan menu command
        print("==============================")
        print("|        CRUD Program        |") # CRUD = Create, Read, Update, Delete
        print("==============================")
        print("|  0. Exit the program       |") # 0 untuk keluar dari program
        print("|  1. Add DPR data           |") # 1 untuk menambahkan data mahasiswa
        print("|  2. Update DPR data        |") # 2 untuk mengubah data mahasiswa
        print("|  3. Delete DPR data        |") # 3 untuk menghapus data mahasiswa
        print("|  4. Show list of DPR       |") # 4 untuk menampilkan semua data dalam daftar mahasiswa
        print("==============================")
        print("Enter your choice : ", end = '')

    def addDPRData(self, dprList, temp, name, idNumber, bidang, partai): # Membuat method untuk menambahkan data mahasiswa
    # Proses setter data inputan ke setiap atribut dari objek temp
        temp.setName(name)
        temp.setIdNumber(idNumber)
        temp.setBidang(bidang)
        temp.setPartai(partai)

        if not dprList: # Jika list kosong, langsung masukan data ke dalam list
            dprList.append(temp) # Memasukan data ke dalam list
            print("\n[SUCCESS] Data has been added.\n\n") # Menampilkan pesan bahwa data berhasil dimasukan ke dalam list
        else: # Jika list tidak kosong, lakukan pengecekan terlebih dahulu
            find = False # Untuk mengecek apakah data sudah ada atau belum, nilai defaultnya adalah false yang menandakan data belum ada

            i = 0 # Untuk mengecek data satu persatu
            while not find and i < len(dprList):
                if temp.getIdNumber() == dprList[i].getIdNumber(): # Jika NIM sudah ada, maka data tidak akan dimasukan ke dalam list dan akan menampilkan pesan error
                    find = True # Jika NIM sudah ada, maka nilai find akan berubah menjadi true
                    print("\n[ERROR] ID number already exists, please add data with a different ID number.\n\n") # Pesan error
                i += 1 # Iterasi untuk mengecek data selanjutnya

            if not find : # Jika data tidak ditemukan, maka data akan dimasukan ke dalam list
                dprList.append(temp) # Memasukan data ke dalam list
                print("\n[SUCCESS] Data has been added.\n\n") # Menampilkan pesan bahwa data berhasil dimasukan ke dalam list

    def updateDPRData(self, dprList, idNumber): # Membuat method untuk mengubah data mahasiswa
        find = False # Untuk mengecek apakah data ada atau tidak, nilai defaultnya adalah false yang menandakan data tidak ada
        i = 0 # Membuat iterator untuk mengecek data dalam list

        while not find and i < len(dprList): # do while untuk mengecek apakah data yang akan diubah ada di dalam dprList atau tidak
            if dprList[i].getIdNumber() == idNumber: # Jika data yang akan diubah ditemukan di dalam dprList, maka akan meminta beberapa masukan
                find = True # Jika data ditemukan, maka nilai find akan berubah menjadi true
                self.__name = input("\nEnter Nama         : ") # Meminta masukan untuk mengubah nama
                self.__bidang = input("Enter bidang     : ") # Meminta masukan untuk mengubah jurusan
                self.__partai = input("Enter partai     : ") # Meminta masukan untuk mengubah fakultas

                dprList[i] = DPR(self.__name, idNumber, self.__bidang, self.__partai) # Mengubah data yang sudah ada di dalam dprList dengan data baru
                print("\n[SUCCESS] Data has been changed.\n\n") # Menampilkan pesan bahwa data berhasil diubah
            i += 1 # Iterasi untuk mengecek data selanjutnya

        if not find: # Jika data tidak ditemukan, maka akan menampilkan pesan error
            print("\n[ERROR] DPR data not found in the list.\n\n") # Pesan error

    def deleteDPRData(self, dprList, idNumber): # Membuat method untuk menghapus data mahasiswa
        find = False # Untuk mengecek apakah data ada atau tidak, nilai defaultnya adalah false yang menandakan data tidak ada
        i = 0 # Membuat iterator untuk mengecek data dalam list

        while not find and i < len(dprList): # do while untuk mengecek apakah data yang akan diubah ada di dalam dprList atau tidak
            if dprList[i].getIdNumber() == idNumber: # Jika data yang akan dihapus ditemukan di dalam dprList, maka data akan dihapus
                find = True # Jika data ditemukan, maka nilai find akan berubah menjadi true
                del dprList[i] # Menghapus data yang ditemukan

                print("\n[SUCCESS] Data has been deleted.\n\n") # Menampilkan pesan bahwa data berhasil dihapus  
            i += 1 # Iterasi untuk mengecek data selanjutnya

        if not find: # Jika data tidak ditemukan, maka akan menampilkan pesan error
            print("\n[ERROR] ID number not exist!\n\n") # Pesan error


    def showListOfDPR(self, dprList): # Membuat method untuk menampilkan daftar mahasiswa
        if not dprList: # Jika list kosong, maka akan menampilkan pesan error
            print("\n[WARNING] The DPR list is still empty.\n\n") # Pesan error
        else: # Jika list tidak kosong, maka akan menampilkan data mahasiswa
            print() # Untuk memberikan jarak antara menu command dan daftar mahasiswa
        
            table = PrettyTable() # Membuat objek table dari class PrettyTable
            table.field_names = ["ID", "Nama", "bidang", "partai"] # Membuat header untuk tabel

            for i, DPR in enumerate(dprList): # Looping untuk menampilkan data mahasiswa
                table.add_row([DPR.getIdNumber(), DPR.getName(), DPR.getBidang(), DPR.getPartai()]) # Menambahkan data mahasiswa ke dalam tabel

            print(table) # Menampilkan tabel
            print('\n') # Menambah baris kosong