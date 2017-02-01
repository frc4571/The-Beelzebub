package org.usfirst.frc.team7788.robot.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.PIDOutput;

public class ShooterOutput implements PIDOutput {
	private CANTalon shooterMotor;
	
	public ShooterOutput (CANTalon shooterMotor){
		this.shooterMotor = shooterMotor;
	}

	@Override
	public void pidWrite(double output) {
		// TODO Auto-generated method stub

	}

}
