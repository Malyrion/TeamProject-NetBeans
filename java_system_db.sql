-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 19, 2020 at 07:17 PM
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

-- --------------------------------------------------------

--
-- Table structure for table `blanks`
--

CREATE TABLE `blanks` (
  `blankID` int(8) NOT NULL,
  `staffID` int(10) NOT NULL,
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
  `blankID` int(8) NOT NULL,
  `type` varchar(50) NOT NULL,
  `departureTime` date NOT NULL,
  `arrivalTime` date NOT NULL,
  `departuredFrom` varchar(200) NOT NULL,
  `arrivedTo` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `coupon`
--

INSERT INTO `coupon` (`blankID`, `type`, `departureTime`, `arrivalTime`, `departuredFrom`, `arrivedTo`) VALUES
(-1, 'fasd', '2000-12-23', '2000-12-23', 'dafsd', 'sdaf'),
(1, 'afds', '2000-12-23', '2000-12-23', 'fads', 'adfs');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customerID` int(10) NOT NULL,
  `discountRateID` int(10) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `DOB` date NOT NULL,
  `telephone` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `isValued` tinyint(1) NOT NULL,
  `address` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customerID`, `discountRateID`, `firstName`, `lastName`, `DOB`, `telephone`, `email`, `isValued`, `address`) VALUES
(-1, -1, 'fasd', 'fdas', '2000-12-23', '2434', 'sadfasd', 0, 'dfas'),
(24, 423, 'fa', 'asdf', '2020-03-04', '2342', 'fad', -1, 'adfasdfasdfasdfasfa'),
(111, 803, '', '', '2020-03-13', '', '', 0, ''),
(445, 651, '', 'adsf', '2020-03-20', 'afds', 'adf', 0, 'adsf'),
(812, 879, 'Jhon', 'Drake', '2011-05-04', '+4234', 'JhonDrake@gmail.com', 0, 'Baker Street 212'),
(828, 320, 'test', 'test ', '2020-03-20', '456789', 'fadshjf', 0, 'address');

-- --------------------------------------------------------

--
-- Table structure for table `discountrates`
--

CREATE TABLE `discountrates` (
  `discountRateID` int(10) NOT NULL,
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
  `tickedID` int(10) NOT NULL,
  `title` varchar(10) NOT NULL,
  `ExpiryDate` date NOT NULL,
  `CVV` int(4) NOT NULL,
  `firstName` varchar(200) NOT NULL,
  `lastName` varchar(200) NOT NULL,
  `paymentType` varchar(200) NOT NULL,
  `cardNumber` int(20) NOT NULL,
  `amount` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `paymentdetails`
--

INSERT INTO `paymentdetails` (`customerID`, `tickedID`, `title`, `ExpiryDate`, `CVV`, `firstName`, `lastName`, `paymentType`, `cardNumber`, `amount`) VALUES
(-984, 686, 'Mr', '2000-12-23', -1, 'adfs', 'afds', 'cash', -1, 423),
(-939, -687, 'Mr', '2000-12-23', 434, 'gffdfs', 'fdsgsd', 'card', 3453, 3222),
(-734, -533, 'Mr', '2000-12-23', 323, 'sesdsd', 'dsdsdseses', 'card', 44346536, 444),
(-471, -616, 'Mr', '2000-12-23', 323, 'sesdsd', 'dsdsdseses', 'card', 44346536, 444),
(-304, -296, 'Mr', '2000-12-23', 233, 'fasdf', 'dasf', 'card', 42423, 234),
(-151, -18, 'Mr', '2000-12-23', -1, 'rwerw', 'rewr', 'cash', -1, 555),
(-125, -126, 'Mr', '2000-12-23', -1, 'rwerw', 'rewr', 'cash', -1, 555),
(-122, -192, 'Mr', '2000-12-23', 324, 'radnoam', 'ramdond', 'card', 572357892, 334),
(-40, 25, 'Mr', '2000-12-23', -1, 'adfs', 'afds', 'cash', -1, 423);

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `staffID` int(10) NOT NULL,
  `commisionRateID` int(10) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `DOB` date NOT NULL,
  `email` varchar(50) NOT NULL,
  `telephone` varchar(14) NOT NULL,
  `role` varchar(50) NOT NULL,
  `address` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`staffID`, `commisionRateID`, `firstName`, `lastName`, `username`, `password`, `DOB`, `email`, `telephone`, `role`, `address`) VALUES
(111111, 1111111, 'advisor_1_name', 'advisor_1_surname', 'advisor', 'advisor', '2020-03-10', 'advisor@gmail.com', '+440666011566', 'Traverl_Advisor', '');

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
  `dateSold` date NOT NULL,
  `time` time NOT NULL,
  `amount` float NOT NULL,
  `amountPaid` float NOT NULL,
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
-- Indexes for table `commisionrate`
--
ALTER TABLE `commisionrate`
  ADD PRIMARY KEY (`commisionRateID`);

--
-- Indexes for table `coupon`
--
ALTER TABLE `coupon`
  ADD PRIMARY KEY (`blankID`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customerID`);

--
-- Indexes for table `discountrates`
--
ALTER TABLE `discountrates`
  ADD PRIMARY KEY (`discountRateID`);

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
