-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 14, 2020 at 04:14 PM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `products`
--

-- --------------------------------------------------------

--
-- Table structure for table `brands`
--

CREATE TABLE `brands` (
  `brandId` int(11) NOT NULL,
  `name` varchar(250) NOT NULL,
  `active` tinyint(1) NOT NULL DEFAULT 1,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `brands`
--

INSERT INTO `brands` (`brandId`, `name`, `active`, `created_at`) VALUES
(1, 'Hugo Boss', 1, '2020-01-12 19:29:08'),
(2, 'Tommy Hilfiger', 1, '2020-01-12 19:29:08'),
(8, 'CalvinKlein', 1, '2020-01-14 09:33:51');

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE `categories` (
  `categoryId` int(11) NOT NULL,
  `name` varchar(250) NOT NULL,
  `active` tinyint(1) NOT NULL DEFAULT 1,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`categoryId`, `name`, `active`, `created_at`) VALUES
(1, 'apparel', 1, '2020-01-12 19:30:50'),
(2, 'Men Shirt', 1, '2020-01-12 19:30:50'),
(3, 'Men T-Shirt', 1, '2020-01-12 19:30:50'),
(4, 'shirts', 1, '2020-01-14 09:33:52');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` bigint(20) NOT NULL,
  `name` varchar(500) NOT NULL,
  `description` text NOT NULL,
  `brand` int(11) NOT NULL,
  `category` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `name`, `description`, `brand`, `category`, `created_at`) VALUES
(100, 'Red Shirt', 'red Hugo boss shirt', 1, 1, '2020-01-12 19:32:26'),
(101, 'Green Shirt', 'green Hugo boss shirt', 1, 1, '2020-01-12 19:32:26'),
(102, 'White Shirt', 'White Hugo boss shirt', 1, 1, '2020-01-12 19:32:26'),
(103, 'Black Shirt', 'Black Hugo boss shirt', 1, 1, '2020-01-12 19:32:26'),
(104, 'Purple Shirt', 'Purple Hugo boss shirt', 1, 1, '2020-01-12 19:32:26'),
(105, 'Gray Shirt', 'Gray Hugo boss shirt', 1, 1, '2020-01-12 19:32:26'),
(106, 'Brown Shirt', 'Brown Hugo boss shirt', 1, 1, '2020-01-12 19:32:26'),
(107, 'Short Sleeve Shirt', 'Multi color CalvinKlein Short Sleeve Shirt', 8, 4, '2020-01-14 09:33:52'),
(108, 'Short Sleeve Shirt X', 'Multi color CalvinKlein Short Sleeve Shirt', 8, 4, '2020-01-14 09:40:54'),
(109, 'Short Sleeve Shirt M', 'Multi color CalvinKlein Short Sleeve Shirt', 8, 4, '2020-01-14 10:21:16'),
(110, 'Short Sleeve Shirt S', 'Multi color CalvinKlein Short Sleeve Shirt', 8, 4, '2020-01-14 10:37:14'),
(111, 'Short Sleeve Shirt L', 'Multi color CalvinKlein Short Sleeve Shirt', 8, 4, '2020-01-14 10:37:44');

-- --------------------------------------------------------

--
-- Table structure for table `taggedproducts`
--

CREATE TABLE `taggedproducts` (
  `taggedProdId` bigint(20) NOT NULL,
  `product` bigint(20) NOT NULL,
  `tag` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `taggedproducts`
--

INSERT INTO `taggedproducts` (`taggedProdId`, `product`, `tag`) VALUES
(1, 100, 1),
(2, 100, 2),
(3, 100, 3),
(5, 102, 1),
(6, 105, 2),
(7, 107, 3),
(8, 109, 4),
(9, 109, 5),
(10, 109, 6),
(11, 110, 4),
(12, 110, 5),
(13, 110, 6),
(14, 111, 7),
(15, 111, 8),
(16, 111, 9);

-- --------------------------------------------------------

--
-- Table structure for table `tags`
--

CREATE TABLE `tags` (
  `tagId` int(11) NOT NULL,
  `name` varchar(250) NOT NULL,
  `active` tinyint(1) NOT NULL DEFAULT 1,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tags`
--

INSERT INTO `tags` (`tagId`, `name`, `active`, `created_at`) VALUES
(1, 'red', 1, '2020-01-12 19:34:58'),
(2, 'shirt', 1, '2020-01-12 19:34:58'),
(3, 'slim fit', 1, '2020-01-12 19:35:10'),
(4, 'multi color', 1, '2020-01-14 10:21:16'),
(5, 'shirt2', 1, '2020-01-14 10:21:17'),
(6, 'slim fit2', 1, '2020-01-14 10:21:17'),
(7, 'multi color3', 1, '2020-01-14 10:37:44'),
(8, 'shirt3', 1, '2020-01-14 10:37:44'),
(9, 'slim fit3', 1, '2020-01-14 10:37:44');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `brands`
--
ALTER TABLE `brands`
  ADD PRIMARY KEY (`brandId`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`categoryId`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`),
  ADD KEY `brand` (`brand`),
  ADD KEY `category` (`category`);

--
-- Indexes for table `taggedproducts`
--
ALTER TABLE `taggedproducts`
  ADD PRIMARY KEY (`taggedProdId`),
  ADD UNIQUE KEY `product` (`product`,`tag`),
  ADD KEY `product_2` (`product`),
  ADD KEY `tag` (`tag`);

--
-- Indexes for table `tags`
--
ALTER TABLE `tags`
  ADD PRIMARY KEY (`tagId`),
  ADD UNIQUE KEY `name` (`name`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `brands`
--
ALTER TABLE `brands`
  MODIFY `brandId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `categories`
--
ALTER TABLE `categories`
  MODIFY `categoryId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=112;

--
-- AUTO_INCREMENT for table `taggedproducts`
--
ALTER TABLE `taggedproducts`
  MODIFY `taggedProdId` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `tags`
--
ALTER TABLE `tags`
  MODIFY `tagId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `products_ibfk_1` FOREIGN KEY (`brand`) REFERENCES `brands` (`brandId`),
  ADD CONSTRAINT `products_ibfk_2` FOREIGN KEY (`category`) REFERENCES `categories` (`categoryId`);

--
-- Constraints for table `taggedproducts`
--
ALTER TABLE `taggedproducts`
  ADD CONSTRAINT `taggedproducts_ibfk_1` FOREIGN KEY (`product`) REFERENCES `products` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `taggedproducts_ibfk_2` FOREIGN KEY (`tag`) REFERENCES `tags` (`tagId`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
