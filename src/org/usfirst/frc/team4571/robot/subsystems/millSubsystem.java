package org.usfirst.frc.team4571.robot.subsystems;
import org.usfirst.frc.team4571.robot.RobotConstants;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
public class millSubsystem {
	public CANTalon millMotor;
	
	public  millSubsystem(){
	this.millMotor = new CANTalon (RobotConstants.MILL_MOTOR);
	}
protected void initDefaultCommand() {}
	
	public void start() {
		// Timer.delay(0.004);
		 //this.shooterMotor.set(0.95);	
		 this.millMotor.set(0.50);	
	}
	
	public void stop() {
		this.millMotor.set(0.0);
	}

	public void speed() {
		// TODO Auto-generated method stub
		
	}
}
