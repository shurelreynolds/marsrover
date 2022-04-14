# MarsRover
MarsRover is a simulation game about navigating space vehicles, avoiding obstacles and controlling equipments on Mars.

Assumption
- That  upper-right coordinates 5,5 implies a grid size of 6 units     
- That N = 90 degrees, E = 180 degrees, W = 0/360 degrees S = 270 degrees
- That there is a Rover at point 0,0 at the start, facing North.
- On Move R2(x=R(-1).x,R(-1).y)
- That the given range is -gridSize to gridSize
- Facing West at point 0,0 and M1 will set Rover at the last position 5,0
- When facing North at position 0,5 and M1 will set Rover at 0,0
- Two numbers separated by a space denotes setting the coords to these numbers
- 1 2 N Two numbers and either N E W S denotes changing the position and defining the facing position of the vehicle
- A string of character determines where the vehicle should move to. M for 1 move, R-for Right L-for Left eg. MMRMMRMRRM 

Test Plan

Aspects to be tested
- Plateau valid & invalid size limits
- Valid & invalid commands
- Navigation Map
- Rover coords
- 
Command Line Interface

![Step 1](https://https://github.com/shurelreynolds/marsrover/blob/main/mars1.png)
