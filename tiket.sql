-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 14 Jun 2021 pada 17.49
-- Versi server: 10.4.17-MariaDB
-- Versi PHP: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tiket`
--

CREATE TABLE `tiket` (
  `no` int(10) NOT NULL,
  `nama` varchar(40) NOT NULL,
  `no_id` int(12) NOT NULL,
  `kode_pesawat` varchar(20) NOT NULL,
  `jenis_pesawat` varchar(20) NOT NULL,
  `harga` int(15) NOT NULL,
  `jumlah_tiket` int(10) NOT NULL,
  `total` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tiket`
--

INSERT INTO `tiket` (`no`, `nama`, `no_id`, `kode_pesawat`, `jenis_pesawat`, `harga`, `jumlah_tiket`, `total`) VALUES
(1123, 'Aditya', 8888, 'Garuda Indonesia', 'First Class', 7000000, 1, 7000000),
(1234, 'Seno', 2222, 'Batik Air', 'Bisnis', 3500000, 2, 7000000),
(1223, 'Nugraha', 3333, 'Air Asia', 'Ekonomi', 2000000, 2, 4000000),
(1233, 'Bagaska', 4444, 'Batik Air', 'Bisnis', 3500000, 1, 3500000),
(1134, 'Rian', 6666, 'Batik Air', 'Bisnis', 3500000, 1, 3500000),
(4321, 'Edo', 7777, 'Garuda Indonesia', 'First Class', 7000000, 1, 7000000);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
