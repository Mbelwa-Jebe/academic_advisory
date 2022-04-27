-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 26, 2022 at 08:54 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `academic_advisory`
--

-- --------------------------------------------------------

--
-- Table structure for table `advisors`
--

CREATE TABLE `advisors` (
  `advisor_id` varchar(20) NOT NULL,
  `advisor_fname` varchar(20) NOT NULL,
  `advisor_lname` varchar(20) NOT NULL,
  `advisor_rank` varchar(20) NOT NULL,
  `advisor_office` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `advisors`
--

INSERT INTO `advisors` (`advisor_id`, `advisor_fname`, `advisor_lname`, `advisor_rank`, `advisor_office`, `password`) VALUES
('100', 'john', 'doe', 'lecturer', 'b205', 'passwrd'),
('101', 'john', 'dillinger', 'lecturer', 'b209', '1234'),
('200', 'Dre', 'Dre', 'Dr', '6789', 'Dre');

-- --------------------------------------------------------

--
-- Table structure for table `appointments`
--

CREATE TABLE `appointments` (
  `appointment_id` int(20) NOT NULL,
  `student_id` varchar(20) NOT NULL,
  `advisor_id` varchar(20) NOT NULL,
  `response` varchar(20) NOT NULL DEFAULT 'waiting',
  `request_info` varchar(20) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `appointments`
--

INSERT INTO `appointments` (`appointment_id`, `student_id`, `advisor_id`, `response`, `request_info`, `timestamp`) VALUES
(1, '1234', '100', 'waiting', 'personal', '2022-04-09 11:54:16'),
(2, '1234', '100', 'waiting', 'academic', '2022-04-09 11:54:16'),
(3, '6789', '200', 'waiting', 'academic', '2022-04-09 11:54:16'),
(4, '1234', '100', 'waiting', 'insert_test', '2022-04-24 07:29:24'),
(5, '1234', '100', 'waiting', 'insert_test', '2022-04-24 07:29:24'),
(6, '1234', '100', 'waiting', 'insert_test', '2022-04-24 07:29:25'),
(11, '1234', '100', 'waiting', 'matatizo', '2022-04-24 08:59:06'),
(12, '1234', '100', 'waiting', 'sonkosonko', '2022-04-24 09:00:00'),
(18, '1234', '100', 'waiting', 'consultations', '2022-04-24 10:57:28');

-- --------------------------------------------------------

--
-- Table structure for table `consultations`
--

CREATE TABLE `consultations` (
  `consultation_id` int(20) NOT NULL,
  `advisor_id` varchar(20) NOT NULL,
  `student_id` varchar(20) NOT NULL,
  `report` varchar(9000) NOT NULL,
  `report_date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `consultations`
--

INSERT INTO `consultations` (`consultation_id`, `advisor_id`, `student_id`, `report`, `report_date`) VALUES
(2, '100', '1234', 'First Report', '2022-04-19 16:45:24'),
(3, '100', '1234', 'Second Report', '2022-04-19 16:46:34'),
(4, '200', '6789', 'Third Report', '2022-04-19 16:47:47'),
(5, '100', '1234', 'Report 4', '2022-04-19 18:19:08');

-- --------------------------------------------------------

--
-- Table structure for table `messages`
--

CREATE TABLE `messages` (
  `message_id` varchar(20) NOT NULL,
  `student_id` varchar(20) NOT NULL,
  `advisor_id` varchar(20) NOT NULL,
  `timestamp` datetime(6) NOT NULL DEFAULT current_timestamp(6),
  `content` varchar(9000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `registration_no` varchar(20) NOT NULL,
  `student_fname` varchar(20) NOT NULL,
  `student_lname` varchar(20) NOT NULL,
  `programme` varchar(20) NOT NULL,
  `year_of_study` year(4) NOT NULL,
  `advisor_id` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`registration_no`, `student_fname`, `student_lname`, `programme`, `year_of_study`, `advisor_id`, `password`) VALUES
('1234', 'Mbelwa', 'Jebe', 'BIT', 2003, '100', '1234'),
('2019-04-02822', 'Mbelwa', 'Jebe', 'BIT', 2003, '100', 'passwrd'),
('6789', 'Bill', 'Ali', 'BIT', 2003, '200', '6789');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `advisors`
--
ALTER TABLE `advisors`
  ADD PRIMARY KEY (`advisor_id`);

--
-- Indexes for table `appointments`
--
ALTER TABLE `appointments`
  ADD PRIMARY KEY (`appointment_id`),
  ADD KEY `student_id` (`student_id`),
  ADD KEY `advisor_id` (`advisor_id`);

--
-- Indexes for table `consultations`
--
ALTER TABLE `consultations`
  ADD PRIMARY KEY (`consultation_id`),
  ADD KEY `advisor_id` (`advisor_id`),
  ADD KEY `student_id` (`student_id`);

--
-- Indexes for table `messages`
--
ALTER TABLE `messages`
  ADD PRIMARY KEY (`message_id`),
  ADD KEY `advisor_id` (`advisor_id`),
  ADD KEY `student_id` (`student_id`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`registration_no`),
  ADD KEY `advisor_id` (`advisor_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appointments`
--
ALTER TABLE `appointments`
  MODIFY `appointment_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `consultations`
--
ALTER TABLE `consultations`
  MODIFY `consultation_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `appointments`
--
ALTER TABLE `appointments`
  ADD CONSTRAINT `appointments_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `students` (`registration_no`),
  ADD CONSTRAINT `appointments_ibfk_2` FOREIGN KEY (`advisor_id`) REFERENCES `advisors` (`advisor_id`);

--
-- Constraints for table `consultations`
--
ALTER TABLE `consultations`
  ADD CONSTRAINT `consultations_ibfk_1` FOREIGN KEY (`advisor_id`) REFERENCES `advisors` (`advisor_id`),
  ADD CONSTRAINT `consultations_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `students` (`registration_no`);

--
-- Constraints for table `messages`
--
ALTER TABLE `messages`
  ADD CONSTRAINT `messages_ibfk_1` FOREIGN KEY (`advisor_id`) REFERENCES `advisors` (`advisor_id`),
  ADD CONSTRAINT `messages_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `students` (`registration_no`);

--
-- Constraints for table `students`
--
ALTER TABLE `students`
  ADD CONSTRAINT `students_ibfk_1` FOREIGN KEY (`advisor_id`) REFERENCES `advisors` (`advisor_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
