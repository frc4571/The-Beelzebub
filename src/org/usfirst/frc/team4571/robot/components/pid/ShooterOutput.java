package org.usfirst.frc.team4571.robot.components.pid;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.PIDOutput;

public class ShooterOutput implements PIDOutput {
	
	private CANTalon shooterMotor;
	
	public ShooterOutput (CANTalon shooterMotor){
		this.shooterMotor = shooterMotor;
	}

	@Override
	public void pidWrite(double output) {
		shooterMotor.set(output);
	}
}