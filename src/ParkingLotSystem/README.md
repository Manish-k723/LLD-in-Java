# Parking Lot Management System

A comprehensive parking lot management system implemented in Java following the components shown in the system diagram.

## System Overview

This parking lot management system implements a complete flow from vehicle entry to exit with payment processing, following the architectural diagram provided.

## System Components

### Core Components (Based on Diagram)

1. **Entrance Gate** - Handles vehicle detection and entry processing
2. **Parking Manager** - Manages parking spot allocation and availability
3. **Exit Gate** - Processes vehicle exit and payment
4. **Pricing Strategy** - Calculates parking costs based on duration and vehicle type
5. **Payment System** - Handles card and cash payments

### Key Classes

- `ParkingLotSystem` - Main system coordinator
- `EntranceGate` - Vehicle entry processing
- `ExitGate` - Vehicle exit and payment processing
- `ParkingManager` - Spot allocation and management
- `PricingStrategy` - Cost calculation logic
- `Vehicle` - Vehicle representation
- `ParkingSpot` - Individual parking spot
- `ParkingTicket` - Ticket generation and tracking

## Features

### Vehicle Entry Process
- Vehicle type detection (Two-wheeler, Four-wheeler, Truck)
- Automatic spot allocation based on vehicle type
- Parking ticket generation with unique ID
- Entry time tracking

### Parking Management
- 20 Two-wheeler spots
- 15 Four-wheeler spots  
- 5 Truck spots
- Real-time availability tracking
- Spot reservation and release

### Exit and Payment Process
- Duration calculation (entry to exit time)
- Cost calculation based on pricing strategy
- Multiple payment options (Card/Cash)
- Payment processing simulation
- Spot release and cleanup

### Pricing Strategy
- Configurable hourly rates per vehicle type
- Default rates:
  - Two-wheeler: ₹10/hour
  - Four-wheeler: ₹20/hour
  - Truck: ₹50/hour
- Minimum billing of 1 hour (rounded up)

## System Flow (Following Diagram)

1. **Vehicle Arrival** → Entrance Gate detects vehicle
2. **Spot Check** → Parking Manager finds available spot
3. **Entry Processing** → Vehicle parked, ticket generated
4. **Parking Duration** → Time tracking begins
5. **Exit Request** → Exit Gate processes vehicle
6. **Cost Calculation** → Pricing Strategy calculates cost
7. **Payment Processing** → Card/Cash payment handled
8. **Spot Release** → Parking Manager frees the spot

## Usage

### Running the Demo

```bash
javac ParkingLotSystem/*.java
java ParkingLotSystem.ParkingLotDemo
```

### Basic Usage

```java
// Initialize system
ParkingLotSystem parkingSystem = ParkingLotSystem.getInstance();

// Vehicle entry
Vehicle car = new Vehicle("MH12CD1234", VehicleType.FOUR_WHEELER);
ParkingTicket ticket = parkingSystem.vehicleEntry(car);

// Vehicle exit with payment
double cost = parkingSystem.vehicleExit("MH12CD1234", PaymentType.CARD_PAYMENT);

// Check current parking status
parkingSystem.displayParkingStatus();
```

## System Architecture

The system follows the Singleton pattern for core components to ensure single instances of:
- ParkingLotSystem
- EntranceGate  
- ExitGate
- ParkingManager
- PricingStrategy

## Error Handling

- Duplicate vehicle entry prevention
- Invalid vehicle exit handling
- No available spots handling
- Payment failure handling

## Future Enhancements

- Database integration for persistence
- Real payment gateway integration
- Web/mobile interface
- Advanced pricing strategies (peak hours, discounts)
- Reservation system
- Multi-level parking support

## Demo Output

The demo showcases:
- System initialization
- Multiple vehicle entries
- Real-time status updates
- Cost calculations
- Payment processing
- Admin functions (rate updates)
- Edge case handling

Run `ParkingLotDemo` to see the complete system in action!