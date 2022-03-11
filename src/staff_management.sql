-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 04, 2022 at 09:28 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `staff_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `ID` int(10) NOT NULL,
  `Name` text NOT NULL,
  `DOB` date NOT NULL,
  `Salary` float(10,0) NOT NULL,
  `Gender` text NOT NULL,
  `Address` text NOT NULL,
  `Position` text NOT NULL,
  `StartDate` date NOT NULL,
  `imgPath` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`ID`, `Name`, `DOB`, `Salary`, `Gender`, `Address`, `Position`, `StartDate`, `imgPath`) VALUES
(19127451, 'Lê Nguyễn Anh Khôi', '2001-11-18', 5000000, 'Male', '54/36/1 Lý Thường Kiệt', 'Data Analysis', '2022-05-01', 'D:/AnhKhoi.jpg'),
(19127109, 'Bùi Ngọc Chính', '2001-10-17', 5000000, 'Male', 'Bình Hưng Hòa B, Bình Tân', 'Backend Developer', '2022-05-01', 'D:/Chinh.jpg');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
