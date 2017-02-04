package org.usfirst.frc.team4571.robot.components.pid;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.RobotDrive;

public class DriveOutput implements PIDOutput {
	
	private RobotDrive robotDrive;
	private PIDController distanceController;
	
	public DriveOutput(RobotDrive robotDrive, PIDController distanceController) {
		this.robotDrive = robotDrive;
		this.distanceController = distanceController;
	}
	
	@Override
	public void pidWrite(double output) {
		this.robotDrive.tankDrive(distanceController.get(), distanceController.get());
	}
}