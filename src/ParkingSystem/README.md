# Parking Management System

A comprehensive parking management system implemented in Java that handles vehicle parking, payment processing, and administrative functions.

## System Overview

The parking management system consists of the following main components:

### Core Classes

1. **Vehicle** - Abstract base class for different vehicle types

   - `Car` - Car vehicle type
   - `Motorcycle` - Motorcycle vehicle type
   - `Truck` - Truck vehicle type
   - `Van` - Van vehicle type

2. **ParkingSpot** - Represents individual parking spots with vehicle type compatibility

3. **ParkingFloor** - Manages multiple parking spots and contains a display board

4. **ParkingLot** - Main system that manages multiple floors and handles vehicle entry/exit

5. **ParkingTicket** - Represents parking tickets with timing and payment information

6. **Payment** - Handles payment processing for different payment types

7. **ParkingRate** - Singleton class that manages pricing for different vehicle types

### User Management

8. **Account** - Abstract base class for user accounts

   - `Admin` - Administrative account with system management privileges
   - `ParkingAttendant` - Staff account for processing vehicle entry/exit

9. **Person** - Represents people in the system with contact information

10. **DisplayBoard** - Shows real-time parking availability

## Features

### Vehicle Management

- Support for multiple vehicle types (Car, Motorcycle, Truck, Van)
- Automatic spot assignment based on vehicle type compatibility
- Real-time availability tracking

### Payment Processing

- Multiple payment types (Cash, Credit Card, Debit Card, Mobile Payment)
- Automatic rate calculation based on parking duration
- Payment status tracking

### Administrative Functions

- Add/remove parking floors
- Update parking rates
- Monitor system status
- User account management

### Real-time Monitoring

- Display boards showing availability
- Parking status reports
- Ticket tracking

## Usage

### Running the System

```bash
cd src/ParkingSystem
javac *.java
java Main
```

### Example Workflow

1. **Vehicle Entry**

   - Vehicle arrives at parking lot
   - Parking attendant processes entry
   - System assigns appropriate parking spot
   - Parking ticket is issued

2. **Vehicle Exit**

   - Vehicle owner presents ticket
   - System calculates parking fee
   - Payment is processed
   - Vehicle is released from parking spot

3. **Administrative Tasks**
   - Admin can update parking rates
   - Add/remove parking floors
   - Monitor system status

## Design Patterns Used

1. **Singleton Pattern** - ParkingRate class
2. **Factory Pattern** - Vehicle creation
3. **Strategy Pattern** - Payment processing
4. **Observer Pattern** - Display board updates

## System Architecture

The system follows a layered architecture:

- **Presentation Layer** - Display boards and user interfaces
- **Business Logic Layer** - Parking management and payment processing
- **Data Layer** - Vehicle and ticket storage

## Extensibility

The system is designed to be easily extensible:

- New vehicle types can be added by extending the Vehicle class
- New payment methods can be added by extending PaymentType
- Additional administrative functions can be added to the Admin class
- New display board types can be implemented

## Error Handling

The system includes comprehensive error handling:

- Invalid vehicle type assignments
- Payment processing failures
- Parking spot availability checks
- User authentication and authorization
