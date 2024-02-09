# Order Manager Test

Testing functionalities of the Order Manager app with Appium and TestNG using the Java programming language.

## Description

The Order Manager app is an Android mobile application built with Jetpack Compose & Kotlin. The primary goal is to enable waiting staff to enter and process orders, while administrators can add users and manage orders.

The project contains 7 test cases (methods) in a `TestMobile` class. The test cases are as follows:

### 1. Successful Login
Verifies successful login functionality.

### 2. Invalid Login
Checks the behavior when providing invalid login credentials.

### 3. Navigate to Confirm Order
Ensures the navigation to the Confirm Order page works correctly.

### 4. Add Order and Click Three Times
Tests the functionality of adding an order and clicking three times.

### 5. Navigate Back to Confirm Order
Checks if navigating back to the Confirm Order page works as expected.

### 6. Create Order
Verifies the process of creating an order, including the success message.

### 7. Logout
Tests the logout functionality.

## Getting Started

1. Ask the Order Manager owner for access to the repository and passwords.
2. Start a Daemon background process, launch the emulator, install the app to the emulator, and start the server from the command prompt.
3. Start the Appium app and launch the server.
4. Start the tests by typing `mvn test` (or use `Ctrl + Enter`) in the terminal of the test SDK.

## Dependencies

The project relies on the following dependencies:

- Appium 7.3.0
- TestNG 7.0.0
- Maven Surefire Report Plugin 2.22.1
- Maven Compiler Plugin 3.8.1

## Project Requirements

To run this project successfully:

1. Install Order Manager on the desired device.
2. Install Node.js for running Appium code.
3. Ensure an emulator is running or a device is connected to the computer.

## Author

**Luka Majstorović**
