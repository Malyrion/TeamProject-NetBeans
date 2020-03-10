-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 10, 2020 at 09:17 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java_system_db`
--
CREATE DATABASE IF NOT EXISTS `java_system_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `java_system_db`;

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `addressID` int(10) NOT NULL,
  `houseNumber` int(11) NOT NULL,
  `roadName` varchar(100) NOT NULL,
  `postCode` varchar(10) NOT NULL,
  `town` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `blanks`
--

CREATE TABLE `blanks` (
  `blankID` int(8) NOT NULL,
  `staffID` int(10) NOT NULL,
  `couponID` int(10) NOT NULL,
  `type` int(3) NOT NULL,
  `status` varchar(50) NOT NULL,
  `blankNumber` int(11) NOT NULL,
  `commisionRate` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `commisionrate`
--

CREATE TABLE `commisionrate` (
  `commisionRateID` int(10) NOT NULL,
  `commisionRate` float NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `coupon`
--

CREATE TABLE `coupon` (
  `couponID` int(10) NOT NULL,
  `blankID` int(8) NOT NULL,
  `type` varchar(50) NOT NULL,
  `departureTime` date NOT NULL,
  `arrivalTime` date NOT NULL,
  `departuredFrom` varchar(200) NOT NULL,
  `arrivedTo` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customerID` int(10) NOT NULL,
  `addressID` int(10) NOT NULL,
  `discountRateID` int(10) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `DOB` date NOT NULL,
  `telephone` int(14) NOT NULL,
  `email` varchar(50) NOT NULL,
  `isValued` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `discountrates`
--

CREATE TABLE `discountrates` (
  `customerID` int(10) NOT NULL,
  `fixedDiscoutnt` float NOT NULL,
  `flexibleDiscount` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `exchangerate`
--

CREATE TABLE `exchangerate` (
  `exchangeRateID` int(10) NOT NULL,
  `exchangeRate` float NOT NULL,
  `localCurrencyName` varchar(50) NOT NULL,
  `localCurrencyAmout` float NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `paymentdetails`
--

CREATE TABLE `paymentdetails` (
  `customerID` int(10) NOT NULL,
  `title` varchar(10) NOT NULL,
  `cardHolderName` varchar(50) NOT NULL,
  `ExpiryDate` date NOT NULL,
  `CVV` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `staffID` int(10) NOT NULL,
  `addressID` int(10) NOT NULL,
  `commisionRateID` int(10) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `DOB` date NOT NULL,
  `email` varchar(50) NOT NULL,
  `telephone` varchar(14) NOT NULL,
  `role` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `ticketsales`
--

CREATE TABLE `ticketsales` (
  `ticketID` int(10) NOT NULL,
  `staffID` int(10) NOT NULL,
  `blanksID` int(8) NOT NULL,
  `customerID` int(11) NOT NULL,
  `exchangeRateID` int(10) NOT NULL,
  `paymentType` varchar(50) NOT NULL,
  `dateSold` date NOT NULL,
  `time` time NOT NULL,
  `amount` float NOT NULL,
  `isRefunded` tinyint(1) NOT NULL,
  `isPayed` tinyint(1) NOT NULL,
  `currency` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `userType` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `userType`) VALUES
(1, 'admin', 'admin', 'System_Administrator'),
(2, 'travelad', 'travelad', 'Travel_Advisor'),
(7, 'manager', 'manager', 'Office_Manager');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`addressID`);

--
-- Indexes for table `commisionrate`
--
ALTER TABLE `commisionrate`
  ADD PRIMARY KEY (`commisionRateID`);

--
-- Indexes for table `coupon`
--
ALTER TABLE `coupon`
  ADD PRIMARY KEY (`couponID`),
  ADD UNIQUE KEY `couponID` (`couponID`,`blankID`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customerID`),
  ADD UNIQUE KEY `customerID` (`customerID`,`addressID`,`discountRateID`);

--
-- Indexes for table `discountrates`
--
ALTER TABLE `discountrates`
  ADD PRIMARY KEY (`customerID`);

--
-- Indexes for table `exchangerate`
--
ALTER TABLE `exchangerate`
  ADD PRIMARY KEY (`exchangeRateID`);

--
-- Indexes for table `paymentdetails`
--
ALTER TABLE `paymentdetails`
  ADD PRIMARY KEY (`customerID`),
  ADD UNIQUE KEY `customerID` (`customerID`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`staffID`),
  ADD UNIQUE KEY `staffID` (`staffID`,`addressID`,`commisionRateID`),
  ADD UNIQUE KEY `username` (`username`,`password`),
  ADD UNIQUE KEY `password` (`password`);

--
-- Indexes for table `ticketsales`
--
ALTER TABLE `ticketsales`
  ADD PRIMARY KEY (`ticketID`),
  ADD UNIQUE KEY `ticketID` (`ticketID`,`staffID`,`blanksID`,`customerID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
