-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 28, 2023 at 06:46 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hms`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `document` varchar(20) DEFAULT NULL,
  `number` varchar(30) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `gender` varchar(15) DEFAULT NULL,
  `country` varchar(20) DEFAULT NULL,
  `room` varchar(10) DEFAULT NULL,
  `checkintime` varchar(80) DEFAULT NULL,
  `deposit` varchar(20) DEFAULT NULL,
  `hotel_id` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `dname` varchar(30) DEFAULT NULL,
  `budget` varchar(30) DEFAULT NULL,
  `hotel_id` int(5) DEFAULT NULL,
  `staff` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`dname`, `budget`, `hotel_id`, `staff`) VALUES
('Restaurant', '50000', 13, 20),
('Cleaning', '50000', 1, 25),
('Purchase', '100000', 3, 30),
('Security', '15000', 5, 8),
('Technical', '70000', 13, 20),
('Front Office', '45000', 1, 25),
('House Keeping', '10000', 3, 10),
('Food and Bevarages', '60000', 5, 30),
('House Keeping', '20000', 1, 23),
('Food and Beverages', '41000', 1, 36),
('Security', '28000', 1, 21),
('Restaurant', '24000', 2, 12),
('Cleaning', '10000', 2, 41),
('Purchase', '11000', 2, 25),
('Security', '12000', 2, 10),
('Front office', '13000', 2, 32),
('Security', '14000', 3, 12),
('Front office', '15000', 3, 15),
('Restaurant', '16000', 3, 25),
('Restaurant', '17000', 4, 36),
('Cleaning', '18000', 4, 14),
('Purchase', '19000', 4, 45),
('Security', '20000', 4, 20),
('Front office', '21000', 4, 26),
('Restaurant', '22000', 5, 24),
('Cleaning', '23000', 5, 30),
('Purchase', '24000', 5, 36),
('Restaurant', '25000', 6, 39),
('Cleaning', '26000', 6, 41),
('Purchase', '27000', 6, 25),
('Security', '28000', 6, 12),
('Front office', '29000', 6, 11),
('Restaurant', '30000', 7, 20),
('Cleaning', '31000', 7, 24),
('Purchase', '33000', 7, 26),
('Secyrity', '34000', 7, 25),
('Front office', '35000', 7, 40),
('Restaurant', '36000', 8, 29),
('Cleaning', '37000', 8, 27),
('Purchase', '38000', 8, 36),
('Security', '39000', 8, 45),
('Front office', '40000', 8, 23);

-- --------------------------------------------------------

--
-- Table structure for table `driver`
--

CREATE TABLE `driver` (
  `name` varchar(20) DEFAULT NULL,
  `age` varchar(10) DEFAULT NULL,
  `gender` varchar(15) DEFAULT NULL,
  `company` varchar(20) DEFAULT NULL,
  `brand` varchar(20) DEFAULT NULL,
  `available` varchar(20) DEFAULT NULL,
  `location` varchar(40) DEFAULT NULL,
  `hotel_id` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `driver`
--

INSERT INTO `driver` (`name`, `age`, `gender`, `company`, `brand`, `available`, `location`, `hotel_id`) VALUES
('sidd', '19', 'Male', 'mercedez', 'benz 300', 'Available', 'Banglore', 1),
('darsh', '26', 'Male', 'mercedez', 'benz 300', 'Busy', 'Bangalore', 3),
('Deep', '22', 'Male', 'Ferrari', 'MK456', 'Available', 'Bangalore', 5),
('Harsh', '30', 'Male', 'mercedez', 'benz 300', 'Busy', 'Bangalore', 13),
('Bhalu', '45', 'Male', 'Ferrari', 'MK456', 'Available', 'Bangalore', 1),
('Annush', '35', 'Male', 'mercedez', 'benz 300', 'Busy', 'Bangalore', 5),
('rfg', '25', 'Female', 'sdfdgfb', 'dfcs', 'Available', 'dfvgb', 1),
('dsfv', '45', 'Female', 'asdcv', 'sdcv', 'Available', 'londin', 1);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `name` varchar(25) DEFAULT NULL,
  `age` varchar(10) DEFAULT NULL,
  `gender` varchar(15) DEFAULT NULL,
  `job` varchar(30) DEFAULT NULL,
  `salary` int(15) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `aadhar` varchar(20) DEFAULT NULL,
  `hotel_id` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`name`, `age`, `gender`, `job`, `salary`, `phone`, `email`, `aadhar`, `hotel_id`) VALUES
('sak', '24', 'Female', 'Housekeeping', 5000, '6541230789', 'sak@gmail.com', '123456789025', 1),
('jjjj', '22', 'Male', 'Porters', 34343, '4678876549', 'dddd', '534545678765', 13),
('Punj', '29', 'Female', 'Cleaning', 5000, '6541230785', 'punj@gmail.com', '123456789032', 1),
('Anil', '42', 'Male', 'Restaurant', 34343, '4678876565', 'anil@gmail.com', '534545678748', 13),
('dvcx', '25', 'Male', 'Kitchen Staff', 25600, '6431978250', 'sdc@gmail.com', '123456789852', 1),
('rgfb', '52', 'Female', 'Accountant', 85000, '1324569847', 'sdfgb@gfbn.com', '456852167953', 1),
('gtr', '45', 'Male', 'Waiter/Waitress', 45000, '4561320788', 'shdf@gmail.com', '789465258763', 1),
('sidff', '27', 'Male', 'Porters', 36000, '1234568790', 'sdf@gh.vom', '123987456852', 1),
('wesdrgf', '35', 'Female', 'Room Service', 25000, '4561230259', 'gfhg@gmail.com', '123456789003', 1);

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `hotel_id` int(11) NOT NULL,
  `rating` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `feedback`
--

INSERT INTO `feedback` (`hotel_id`, `rating`) VALUES
(12, 5),
(12, 2),
(3, 7),
(3, 6),
(5, 5),
(3, 8),
(1, 6),
(1, 5);

-- --------------------------------------------------------

--
-- Table structure for table `hotels`
--

CREATE TABLE `hotels` (
  `hotel_id` int(5) NOT NULL,
  `hotel_name` varchar(35) DEFAULT NULL,
  `pincode` int(6) DEFAULT NULL,
  `Type` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hotels`
--

INSERT INTO `hotels` (`hotel_id`, `hotel_name`, `pincode`, `Type`) VALUES
(1, 'Taj ', 453298, 'Boarding'),
(2, 'Sri Krishna', 590004, 'Boarding'),
(3, 'slv', 560003, 'Lodging'),
(4, 'Udupi Sri', 524632, 'Lodging'),
(5, 'class G', 560090, 'Boarding'),
(6, 'Vishnu International', 546320, 'Boarding'),
(7, 'Green Garden', 798465, 'Boarding'),
(9, 'Params Intl', 132465, 'Lodging'),
(13, 'KSR', 560009, 'Boarding');

-- --------------------------------------------------------

--
-- Table structure for table `issue`
--

CREATE TABLE `issue` (
  `issue_id` varchar(5) NOT NULL,
  `descr` varchar(25) DEFAULT NULL,
  `hotel_id` varchar(255) DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `issue`
--

INSERT INTO `issue` (`issue_id`, `descr`, `hotel_id`, `status`) VALUES
('12', 'bad maintainance', '1', 'To be Resolved'),
('14', 'sfdghh', '1', 'Resolved'),
('5', 'bad service', '13', 'Resolved'),
('8', 'bad restaurant', '3', 'Resolved'),
('89', 'bad view', '5', 'Resolved');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `username` varchar(25) DEFAULT NULL,
  `password` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `password`) VALUES
('admin', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `manager`
--

CREATE TABLE `manager` (
  `mname` varchar(10) DEFAULT NULL,
  `mpwd` varchar(10) DEFAULT NULL,
  `hotel_id` varchar(5) NOT NULL,
  `mail` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `manager`
--

INSERT INTO `manager` (`mname`, `mpwd`, `hotel_id`, `mail`) VALUES
('smith', 'smith', '1', 'smith@gmail.com'),
('Ram', 'ram123', '13', 'Ram2002@gmail.com'),
('yukth', 'yukth123', '2', 'yukth@gmail.com'),
('udupi', 'udupi', '4', 'udupi@gmail.com'),
('xxx', '123', '5', 'xxx@gmail.com'),
('vishnu', 'vishnu', '6', 'vishnu@gmail.com'),
('ramu', 'ramu', '7', 'ramu@gmail.com'),
('paramu', 'paramu', '9', 'paramu@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `roomnumber` varchar(10) NOT NULL,
  `availability` varchar(20) DEFAULT NULL,
  `cleaning_status` varchar(20) DEFAULT NULL,
  `price` varchar(20) DEFAULT NULL,
  `bed_type` varchar(20) DEFAULT NULL,
  `hotel_id` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`roomnumber`, `availability`, `cleaning_status`, `price`, `bed_type`, `hotel_id`) VALUES
('456', 'Available', 'To be Cleaned', '5600', 'Tree house', 1),
('610', 'Available', 'Cleaned', '15000', 'Single Bed', 1),
('611', 'Available', 'Cleaned', '16000', 'Double Bed', 1),
('612', 'Occupied', 'Cleaned', '17000', 'Pent House', 1),
('613', 'Available', 'Cleaned', '18000', 'Tree house', 1),
('614', 'Available', 'Cleaned', '18555', 'Boat House', 1),
('615', 'Available', 'Cleaned', '19555', 'Boat House', 1),
('616', 'Available', 'Cleaned', '20000', 'Tree house', 1),
('784', 'Available', 'Cleaned', '5600', 'Double Bed', 1);

-- --------------------------------------------------------

--
-- Table structure for table `usr_name`
--

CREATE TABLE `usr_name` (
  `name` varchar(20) NOT NULL,
  `pwd` varchar(50) NOT NULL,
  `hotel_id` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `usr_name`
--

INSERT INTO `usr_name` (`name`, `pwd`, `hotel_id`) VALUES
('john', 'john', 13),
('sakya', 'sakya123', 3),
('Shashank', 'Shashank', 1),
('shyam', 'shyam', 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`number`);

--
-- Indexes for table `hotels`
--
ALTER TABLE `hotels`
  ADD PRIMARY KEY (`hotel_id`),
  ADD UNIQUE KEY `hotel_id` (`hotel_id`);

--
-- Indexes for table `issue`
--
ALTER TABLE `issue`
  ADD PRIMARY KEY (`issue_id`);

--
-- Indexes for table `manager`
--
ALTER TABLE `manager`
  ADD PRIMARY KEY (`hotel_id`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`roomnumber`);

--
-- Indexes for table `usr_name`
--
ALTER TABLE `usr_name`
  ADD PRIMARY KEY (`name`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
