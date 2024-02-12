<?php
/*Saya Ravindra Maulana Sahman NIM 2108724 mengerjakan soal Latihan Praktikum 1 dalam mata kuliah DPBO untuk 
keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin
*/

require('DPR.php'); // Require Class DPR

$DPRList = array(); // Inisialisasi array list
$arrDPRData = array(); // Inisialisasi array masukan

echo "<h3>Create Data</h3>"; // Menampilkan sesi Create

/* Input data anggota dpr */
$arrDPRData[0] = new DPR("19970324", "Myoui Mina", "Pengawasan", "PDIP" );
$arrDPRData[0]->setFoto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQWoHrDtvu2dFi6eLA39Gncq5cmgjWhdGdxlQ&usqp=CAU");
$arrDPRData[0]->addDPRData($DPRList, $arrDPRData[0]);

$arrDPRData[1] = new DPR("20000721", 'Choi Ji-su', "Hukum & Keamanan", "Nasdem" ); // Create data dengan konstruktor
$arrDPRData[1]->setFoto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSb2eKIxdQPminvaZzXdSWO8CC0ZiKeEVYyFw&usqp=CAU");
$arrDPRData[1]->addDPRData($DPRList, $arrDPRData[1]);

$arrDPRData[2] = new DPR( '20030901',"An Yu-jin", "Kesehatan", "PPP" ); // Create data dengan konstruktor
$arrDPRData[2]->setFoto("https://i.pinimg.com/236x/04/47/de/0447de30feaded5e3e821ef4cfcfffd2.jpg");
$arrDPRData[2]->addDPRData($DPRList, $arrDPRData[2]);   

// Create data dengan setter tiap atribut
$arrDPRData[3] = new DPR();
$arrDPRData[3]->setId("20030225");
$arrDPRData[3]->setNama("Oh Haewon");
$arrDPRData[3]->setBidang("Agama Sosial");
$arrDPRData[3]->setPartai("Golkar");
$arrDPRData[3]->setFoto("https://i.pinimg.com/236x/3c/5f/d3/3c5fd328fb580692bd6ca86512500fbc.jpg");
$arrDPRData[3]->addDPRData($DPRList, $arrDPRData[3]);


$showDPRData = new DPR(); // Objek untuk menampilkan isi array daftar anggota dpr
$showDPRData->showListOfDPR($DPRList); // Menampilkan isi array setelah input data

echo "<h3>Update Data</h3>"; // Menampilkan sesi Update
$arrDPRData[0]->updateDPRData($DPRList, $arrDPRData[0], "19970324", "Myoui Mina", "Pendidikan Olahraga", "PDIP" ); // Update data
$arrDPRData[0]->setFoto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTVFYPVaFfHWl1cEGE2iF3YUcR_ox21CGXkcg&usqp=CAU");

$showDPRData->showListOfDPR($DPRList); // Menampilkan isi array setelah update data

echo "<h3>Delete Data</h3>"; // Menampilkan sesi Delete
$arrDPRData[0]->deleteDPRData($DPRList, 'An Yu-jin'); // Delete data
$showDPRData->showListOfDPR($DPRList); // Menampilkan isi array setelah delete data