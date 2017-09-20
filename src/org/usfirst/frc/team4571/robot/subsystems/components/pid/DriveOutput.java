package org.usfirst.frc.team4571.robot.subsystems.components.pid;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.RobotDrive;

public class DriveOutput implements PIDOutput {
	
	private RobotDrive myRobot;
	
	public DriveOutput(RobotDrive myRobot) {
		this.myRobot = myRobot;
	}

	@Override
	public void pidWrite(double output) {
		this.myRobot.tankDrive(-output, output);
	}
}