package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.RobotConstants;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ShooterSubsystem extends Subsystem {
	public CANTalon shooterMotor; 
    public Encoder encoder; 
	
     	public ShooterSubsystem (){
		this.shooterMotor = new CANTalon (RobotConstants.SHOOTER_MOTOR_CHANNEL);
		this.encoder = new Encoder(RobotConstants.ONE_ENCODER_CHANNEL_A, RobotConstants.ONE_ENCODER_CHANNEL_B, false, EncodingType.k4X);
	}
	
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	public void initialize (){
		this.encoder.reset();
	}
	public void setSpeed(double speed){
	   this.shooterMotor.set(0.5);	
		
	}
	public void stop(){
		setSpeed(0.0);
	}
	
 }
	