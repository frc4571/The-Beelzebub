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
		// If we are running with only "Turn controller" enabled mode. aka only turning
		if (distanceController.getSetpoint() == 0.0) {
			robotDrive.tankDrive(output, -output);
		} 
		// If we are running with turn and distance controllers enabled.
		else {
			robotDrive.tankDrive(distanceController.get() + output, distanceController.get() - output);
		}
	}
}