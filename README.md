# Port Container Management System

A console-based application for managing containers and ships at a shipping port using Stack (LIFO) and Queue (FIFO) data structures.

## Description

This system simulates the operations of a shipping port where:
- **Containers** arrive from trucks and are temporarily stored in a stack (Last In, First Out)
- **Ships** line up at the dock in a queue (First In, First Out)
- **Loading operations** transfer the top container from the stack to the front ship in the queue

## Features

1. **Store Container (Push)** - Add containers to the port storage stack
2. **View Port Containers** - Display all containers from top to bottom
3. **Register Arriving Ship (Enqueue)** - Add ships to the waiting queue
4. **View Waiting Ships** - Display all ships from front to rear
5. **Load Next Ship** - Load the top container onto the front ship
6. **Exit** - Terminate the program

## Technical Implementation

### ADT Classes

**Container Class**
- Fields: `id`, `description`, `weight`
- Implements proper `toString()` for formatted output

**Ship Class**
- Fields: `name`, `captain`
- Implements proper `toString()` for formatted output

### Data Structures
- `ArrayDeque<Container>` - Used as a stack for LIFO container storage
- `ArrayDeque<Ship>` - Used as a queue for FIFO ship processing

## How to Run

1. Ensure you have Java JDK installed (Java 8 or higher)
2. Clone this repository
3. Compile the program:
   ```bash
   javac PortContainerManagementSystem.java
   ```
4. Run the program:
   ```bash
   java PortContainerManagementSystem
   ```

## Sample Usage

```
=== Port Container Management System ===
[1] Store container (push)
[2] View port containers
[3] Register arriving ship (enqueue)
[4] View waiting ships
[5] Load next ship (pop container + poll ship)
[0] Exit
Enter choice: 1

Enter container ID: CT001
Enter description: Electronics
Enter weight (e.g., 500kg): 500kg

Stored: CT001 | Electronics | 500kg
```

## Testing Checklist

To demonstrate full functionality:
- ✅ Add at least 3 containers
- ✅ Register at least 2 ships
- ✅ View both container and ship lists
- ✅ Successfully load 1 ship
- ✅ Show remaining counts

## Author

Created as part of a Data Structures and Algorithms course project.

## License

This project is created for educational purposes.
