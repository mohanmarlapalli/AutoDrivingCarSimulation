package com.test.AutoDrivingCarSimulation;

import java.util.HashMap;
import java.util.Map;

public class CarApplicationTest 
{
	public static void main(String[] args) {
		Map<Character, AutoDrivingCar> cars = new HashMap<>();
		CarMovingDirectionsUtil carDirections = new CarMovingDirectionsUtil();
		// Example Test 1 scenario
		char[] movingDirectionsA = "FFRFFFRRLF".toCharArray();
		AutoDrivingCar autoDrivingCarA = new AutoDrivingCar(1, 2, 'N', movingDirectionsA);
		cars.put('A', autoDrivingCarA);
		// Test 1 scenario
		System.out.println(carDirections.movingCarDirections(10, 10, cars));
		
		
		
		// Example Test 2 scenario
		// car 1 object
		movingDirectionsA = "FFRFFFFRRL".toCharArray();
		autoDrivingCarA = new AutoDrivingCar(1, 2, 'N', movingDirectionsA);
		cars.put('A', autoDrivingCarA);
		
		// car 2 object
		char[] movingDirectionsB = "FFLFFFFFFF".toCharArray();
		AutoDrivingCar autoDrivingCarB = new AutoDrivingCar(7, 8, 'W', movingDirectionsB);
		cars.put('B', autoDrivingCarB);
		
		System.out.println(carDirections.movingCarDirections(10, 10, cars));
	}
}
