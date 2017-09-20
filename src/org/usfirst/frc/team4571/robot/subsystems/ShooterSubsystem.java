package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.RobotConstants;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ShooterSubsystem extends Subsystem {
	
	public CANTalon shooterMotor; 
	public CANTalon feederMotor;
	public CANTalon feederMotor2;
    
	public ShooterSubsystem (){
		this.shooterMotor = new CANTalon (RobotConstants.SHOOTER_MOTOR_CHANNEL);
		this.feederMotor = new CANTalon (RobotConstants.MILL_MOTOR);
		//this.feederMotor2 = new CANTalon (RobotConstants.MILL_MOTOR2);
	}
	
	protected void initDefaultCommand() {}
	
	public void start() {
		 //Timer.delay(0.004);
		 this.shooterMotor.set(0.90);	
		 this.feederMotor.set(0.90);
		 //this.feederMotor2.set(0.99);
	}
	
	public void stop() {
		this.shooterMotor.set(0.0);
		this.feederMotor.set(0.0);
	}
}
	
 
	
