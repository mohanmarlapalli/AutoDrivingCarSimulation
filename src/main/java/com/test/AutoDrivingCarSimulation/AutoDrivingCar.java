package com.test.AutoDrivingCarSimulation;

import java.util.Arrays;

public class AutoDrivingCar {
	int x;
	int y;
	char direction;
	char[] commands;

	public AutoDrivingCar(int x, int y, char direction, char[] commands) {
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.commands = commands;
	}
	

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public char getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}

	public char[] getCommands() {
		return commands;
	}

	public void setCommands(char[] commands) {
		this.commands = commands;
	}

	@Override
	public String toString() {
		return "AutoDrivingCar [x=" + x + ", y=" + y + ", direction=" + direction + ", commands="
				+ Arrays.toString(commands) + "]";
	}

}