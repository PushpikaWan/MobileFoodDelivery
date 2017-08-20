-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Aug 20, 2017 at 05:10 PM
-- Server version: 10.1.24-MariaDB
-- PHP Version: 7.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id2631581_mobirestdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `Items`
--

CREATE TABLE `Items` (
  `Item_ID` int(11) NOT NULL,
  `Name` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `Category` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `Availability` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `Price` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `Items`
--

INSERT INTO `Items` (`Item_ID`, `Name`, `Category`, `Availability`, `Price`) VALUES
(1, 'Rice', 'Breakfast', 'Yes', '90.00'),
(2, 'String Hoppers parcel', 'Breakfast', 'Yes', '45.00'),
(3, 'Milk Rice 2 pieces', 'Breakfast', 'Yes', '70.00'),
(4, 'Rotti', 'Breakfast', 'Yes', '15.00'),
(5, 'Vegetable Rice', 'Lunch', 'Yes', '110.00'),
(6, 'Chicken Rice', 'Lunch', 'Yes', '190.00'),
(7, 'Fish Rice', 'Lunch', 'Yes', '150.00'),
(8, 'Egg Rice', 'Lunch', 'Yes', '120.00'),
(9, 'Fried Rice', 'Lunch', 'Yes', '230.00'),
(10, 'Fish Bun', 'Shorteats', 'Yes', '40.00'),
(11, 'Seeni Sambol Bun', 'Shorteats', 'Yes', '40.00'),
(12, 'Egg Bun', 'Shorteats', 'Yes', '40.00'),
(13, 'Fish Rolls', 'Shorteats', 'Yes', '30.00'),
(14, 'Pasties', 'Shorteats', 'Yes', '30.00'),
(15, 'Pastry', 'Shorteats', 'Yes', '40.00'),
(16, 'Cupcake', 'Shorteats', 'Yes', '30.00'),
(17, 'Vanilla Milk Packet', 'Drinks', 'Yes', '40.00'),
(18, 'Chocolate Milk Packet', 'Drinks', 'Yes', '40.00'),
(19, 'Ice Coffee', 'Drinks', 'Yes', '60.00'),
(20, 'Falooda', 'Drinks', 'Yes', '100.00'),
(21, 'Vanilla Ice Cream', 'Deserts', 'Yes', '50.00'),
(22, 'Chocolate Ice Cream', 'Deserts', 'Yes', '50.00'),
(23, 'Strawberry Ice Cream', 'Deserts', 'Yes', '50.00'),
(24, 'Yogurt', 'Deserts', 'Yes', '35.00'),
(25, 'Biscuit Pudding', 'Deserts', 'Yes', '60.00'),
(26, 'CreamCaramel Pudding', 'Deserts', 'Yes', '70.00'),
(27, 'Watalappan', 'Deserts', 'Yes', '70.00'),
(28, 'Apple', 'Fruits', 'Yes', '50.00'),
(29, 'Orange', 'Fruits', 'Yes', '50.00'),
(30, 'Papaya', 'Fruits', 'Yes', '50.00'),
(31, 'Mango', 'Fruits', 'Yes', '60.00'),
(32, 'Grapes', 'Fruits', 'Yes', '70.00'),
(33, 'Pears', 'Fruits', 'Yes', '70.00'),
(34, 'Water melon', 'Fruits', 'Yes', '50.00'),
(35, 'Mixed fruits', 'Fruits', 'Yes', '70.00'),
(36, 'Apple Juice', 'Fruit Juice', 'Yes', '70.00'),
(37, 'Orange Juice', 'Fruit Juice', 'Yes', '70.00'),
(38, 'Papaya Juice with Ice Cream', 'Fruit Juice', 'Yes', '100.00'),
(39, 'Papaya Juice without Ice Cream', 'Fruit Juice', 'Yes', '70.00'),
(40, 'Water melon Juice', 'Fruit Juice', 'Yes', '70.00'),
(41, 'Mixed fruit Juice  with Ice Cr', 'Fruit Juice', 'Yes', '100.00'),
(42, 'Mixed fruit Juice  without Ice', 'Fruit Juice', 'Yes', '70.00');

-- --------------------------------------------------------

--
-- Table structure for table `OrderedItems`
--

CREATE TABLE `OrderedItems` (
  `Order_ID` int(11) NOT NULL,
  `Item_ID` int(11) NOT NULL,
  `Price` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `Quantity` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `TotalPrice` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `OrderedItems`
--

INSERT INTO `OrderedItems` (`Order_ID`, `Item_ID`, `Price`, `Quantity`, `TotalPrice`) VALUES
(9, 5, '1', '110.0', '110.0'),
(9, 6, '1', '190.0', '190.0'),
(9, 7, '1', '150.0', '150.0'),
(10, 5, '1', '110.0', '110.0'),
(10, 6, '1', '190.0', '190.0'),
(10, 7, '1', '150.0', '150.0'),
(11, 5, '1', '110.0', '110.0'),
(11, 6, '1', '190.0', '190.0'),
(11, 7, '1', '150.0', '150.0'),
(11, 22, '1', '50.0', '50.0'),
(12, 5, '1', '110.0', '110.0'),
(12, 6, '1', '190.0', '190.0'),
(12, 10, '1', '40.0', '40.0'),
(12, 11, '1', '40.0', '40.0'),
(12, 12, '1', '40.0', '40.0'),
(13, 5, '1', '110.0', '110.0'),
(13, 6, '1', '190.0', '190.0'),
(13, 10, '1', '40.0', '40.0'),
(13, 11, '1', '40.0', '40.0'),
(13, 12, '1', '40.0', '40.0');

-- --------------------------------------------------------

--
-- Table structure for table `Orders`
--

CREATE TABLE `Orders` (
  `Order_ID` int(11) NOT NULL,
  `Name` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `Place` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `Contact` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `Total` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `Status` varchar(30) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'Pending',
  `Date_Time` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `Orders`
--

INSERT INTO `Orders` (`Order_ID`, `Name`, `Place`, `Contact`, `Total`, `Status`, `Date_Time`) VALUES
(1, '', '', '', '', 'Pending', ''),
(2, '', '', '', '', 'Pending', ''),
(3, '', '', '', '', 'Pending', ''),
(4, '', 'sdfdgf', '12345', 'LKR : 450.0', 'Pending', ''),
(5, 'sdfdg', 'sdfdgf', '12345', 'LKR : 450.0', 'Pending', ''),
(6, 'sdfdg', 'sdfdgf', '12345', 'LKR : 450.0', 'Pending', ''),
(7, 'sdfdg8', 'sdfdgf', '1234589', 'LKR : 450.0', 'Pending', ''),
(8, 'asdfg', '234tg', '2345t', 'LKR : 230.0', 'Pending', ''),
(9, 'wedf', 'sdfb', 'wsedrfg', 'LKR : 500.0', 'Pending', ''),
(10, 'fff', 'sdf', '12345', 'LKR : 500.0', 'Pending', ''),
(11, 'fff', 'sdf', '12345', 'LKR : 500.0', 'Pending', ''),
(12, 'zsxdcv', 'sdfvb', 'sdfg', 'LKR : 420.0', 'Pending', 'Date_Time'),
(13, 'zsxdcv', 'sdfvb', 'sdfg', 'LKR : 420.0', 'Pending', 'Aug 20, 2017 1:08:24 PM');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Items`
--
ALTER TABLE `Items`
  ADD PRIMARY KEY (`Item_ID`);

--
-- Indexes for table `OrderedItems`
--
ALTER TABLE `OrderedItems`
  ADD PRIMARY KEY (`Order_ID`,`Item_ID`),
  ADD KEY `Item_ID` (`Item_ID`);

--
-- Indexes for table `Orders`
--
ALTER TABLE `Orders`
  ADD PRIMARY KEY (`Order_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Items`
--
ALTER TABLE `Items`
  MODIFY `Item_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;
--
-- AUTO_INCREMENT for table `Orders`
--
ALTER TABLE `Orders`
  MODIFY `Order_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `OrderedItems`
--
ALTER TABLE `OrderedItems`
  ADD CONSTRAINT `OrderedItems_ibfk_1` FOREIGN KEY (`Order_ID`) REFERENCES `Orders` (`Order_ID`),
  ADD CONSTRAINT `OrderedItems_ibfk_2` FOREIGN KEY (`Item_ID`) REFERENCES `Items` (`Item_ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
