package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.RobotConstants;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ClimberSubsystem extends Subsystem {
	public CANTalon climberMotor1;
	public CANTalon climberMotor2;

	public ClimberSubsystem() {
		this.climberMotor1 = new CANTalon (RobotConstants.CLIMBER_MOTOR_1);
		this.climberMotor2 = new CANTalon (RobotConstants.CLIMBER_MOTOR_2);
	}
	@Override
	protected void initDefaultCommand() {}
	
	public void start() {
		
		this.climberMotor1.set(-0.99);
		this.climberMotor2.set(0.99);
	}
	
	public void setReverse() {
		this.climberMotor1.set(0.99);
		this.climberMotor2.set(-0.99);
	}
	
	public void stop() {
		this.climberMotor1.set(0.0);
		this.climberMotor2.set(0.0);
	}
}