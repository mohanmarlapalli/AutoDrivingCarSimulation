package com.test.AutoDrivingCarSimulation;

import java.util.HashMap;
import java.util.Map;

public class CarMovingDirectionsUtil {
	// Left and Right moving directions
	public static final Map<Character, Map<Character, Character>> rotations = new HashMap<>();
	static {
		Map<Character, Character> leftRotation = new HashMap<>();
		leftRotation.put('N', 'W');
		leftRotation.put('W', 'S');
		leftRotation.put('S', 'E');
		leftRotation.put('E', 'N');
		rotations.put('L', leftRotation);

		Map<Character, Character> rightRotation = new HashMap<>();
		rightRotation.put('N', 'E');
		rightRotation.put('E', 'S');
		rightRotation.put('S', 'W');
		rightRotation.put('W', 'N');
		rotations.put('R', rightRotation);
	}

	public String movingCarDirections(int width, int height,
			Map<Character, AutoDrivingCar> carsMap) {
		StringBuilder output = new StringBuilder();
		boolean collision = false;
		try {
			if(carsMap == null || carsMap.size() == 0) {
				return output.toString();
			}
			for (Map.Entry<Character, AutoDrivingCar> autoDrivingCars : carsMap.entrySet()) {
				 AutoDrivingCar autoDrivingCar = autoDrivingCars.getValue();
				 char[] commands = autoDrivingCar.commands;
				for (int i = 0; i < commands.length; i++) {
					char command = commands[i];
					if (command == 'F') {
						if (autoDrivingCar.direction == 'N') {
							autoDrivingCar.y++;
						} else if (autoDrivingCar.direction == 'S') {
							autoDrivingCar.y--;
						} else if (autoDrivingCar.direction == 'E') {
							autoDrivingCar.x++;
						} else if (autoDrivingCar.direction == 'W') {
							autoDrivingCar.x--;
						}
						// If the car tries to go out of the boundary, that command is ignored.
						ignoreOutOfBoudaryPoints(autoDrivingCar, width, height);
						// If you have more that one car, then need to check collision logic
						if (carsMap.size() > 1) {
							// Multiple Cars check collision logic
							for (AutoDrivingCar car : carsMap.values()) {
								if (car != autoDrivingCar && car.x == autoDrivingCar.x && car.y == autoDrivingCar.y) {
									carsMap.keySet().forEach(e -> output.append(e + " "));
									output.append("\n" + autoDrivingCar.x + " " + autoDrivingCar.y);
									collision = true;
									output.append("\n" + (i + 1));
									return output.toString();
								}
							}
						}
					} else {
						autoDrivingCar.direction = rotations.get(command).get(autoDrivingCar.direction);
					}
				}
			}
		} catch (Exception e) {
			// We need to capture error logs
			System.out.println("Error in car moving"+e.getMessage());
		}
		if (carsMap.size() > 1 && !collision) {
			output.append("no collision");
		} else {
			// For Single Car out show logic
			for (Map.Entry<Character,AutoDrivingCar> singleCarMap : carsMap.entrySet()) {
				AutoDrivingCar autoDrivingCar = singleCarMap.getValue();
				output.append(singleCarMap.getKey()+"\n");
				output.append(autoDrivingCar.x + " " + autoDrivingCar.y);
			}
		}
		return output.toString();
	}

	public void ignoreOutOfBoudaryPoints(AutoDrivingCar autoDrivingCar, int width, int height) {
		if (autoDrivingCar.x < 0 || autoDrivingCar.y < 0 || autoDrivingCar.x >= width || autoDrivingCar.y >= height) {
			// If x,y indexes going beyond limits values to rest to previous values
			if (autoDrivingCar.x < 0) {
				autoDrivingCar.x = 0;
			} else if (autoDrivingCar.y < 0) {
				autoDrivingCar.y = 0;
			} else if (autoDrivingCar.x >= width) {
				autoDrivingCar.x = width;
			} else if (autoDrivingCar.y >= height) {
				autoDrivingCar.y = height;
			}
		}
	}

}
