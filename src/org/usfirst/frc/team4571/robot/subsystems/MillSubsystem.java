package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.RobotConstants;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class MillSubsystem extends Subsystem {

	private Servo leftMillMotor, rightMillMotor;

	public MillSubsystem(){
		this.leftMillMotor = new Servo(RobotConstants.MILL_LEFT_MOTOR_CHANNEL);
		this.rightMillMotor = new Servo(RobotConstants.MILL_RIGHT_MOTOR_CHANNEL);
	}

	public void forward(double speed){
		this.leftMillMotor.set(speed);
		this.rightMillMotor.set(speed);
	}

	public void reverse(double speed){
		this.leftMillMotor.set(speed);
		this.rightMillMotor.set(speed);
	}

	public void stop(){
		this.leftMillMotor.set(0.0);
		this.rightMillMotor.set(0.0);
	}

	public void initDefaultCommand() {}

}