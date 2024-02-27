package com.test.AutoDrivingCarSimulation;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class CarTest {

	@Test
	public void ifYouDonotPassMoveCommand() {
		char[] commandsA = "".toCharArray();
		AutoDrivingCar autoDrivingCar = new AutoDrivingCar(-1, -2, 'N', commandsA);
		CarMovingDirectionsUtil carDirections = new CarMovingDirectionsUtil();
		Map<Character, AutoDrivingCar> cars = new HashMap<>();
		cars.put('A', autoDrivingCar);
		carDirections.movingCarDirections(10, 10, cars);
		assertEquals(-1, autoDrivingCar.getX());
		assertEquals(-2, autoDrivingCar.getY());
		assertEquals('N', autoDrivingCar.getDirection());
	}

	@Test
	public void ifYouGiveWrongDirection() {
		char[] commandsA = "FFRFFFRRLF".toCharArray();
		AutoDrivingCar autoDrivingCar = new AutoDrivingCar(1, 2, 'G', commandsA);
		CarMovingDirectionsUtil carDirections = new CarMovingDirectionsUtil();
		Map<Character, AutoDrivingCar> cars = new HashMap<>();
		cars.put('A', autoDrivingCar);
		carDirections.movingCarDirections(10, 10, cars);
		assertEquals(1, autoDrivingCar.getX());
		assertEquals(2, autoDrivingCar.getY());
		assertEquals('G', autoDrivingCar.getDirection());
	}

	@Test
	public void testCase1() {
		char[] commandsA = "FFRFFFRRLF".toCharArray();
		AutoDrivingCar autoDrivingCar = new AutoDrivingCar(1, 2, 'N', commandsA);
		CarMovingDirectionsUtil carDirections = new CarMovingDirectionsUtil();
		Map<Character, AutoDrivingCar> cars = new HashMap<>();
		cars.put('A', autoDrivingCar);
		carDirections.movingCarDirections(10, 10, cars);
		assertEquals(4, autoDrivingCar.getX());
		assertEquals(3, autoDrivingCar.getY());
		assertEquals('S', autoDrivingCar.getDirection());
	}

	@Test
	public void testCaseWithCollision() {
		char[] commandsA = "FFRFFFRRLF".toCharArray();
		AutoDrivingCar autoDrivingCar1 = new AutoDrivingCar(1, 2, 'N', commandsA);
		CarMovingDirectionsUtil carDirections = new CarMovingDirectionsUtil();
		Map<Character, AutoDrivingCar> cars = new HashMap<>();
		cars.put('A', autoDrivingCar1);

		char[] commandsB = "FFLFFFFFFF".toCharArray();
		AutoDrivingCar autoDrivingCar2 = new AutoDrivingCar(7, 8, 'W', commandsB);
		cars.put('B', autoDrivingCar2);

		String output = carDirections.movingCarDirections(10, 10, cars);
		Assert.assertNotSame("no collision", output);
	}

}