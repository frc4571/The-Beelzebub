package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.RobotConstants;
import org.usfirst.frc.team4571.robot.components.pid.ShooterOutput;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ShooterSubsystem extends Subsystem {

	public CANTalon shooterMotor; 
	public Encoder rotationEncoder; 
	private ShooterOutput shooterOutput ;
	private PIDController rateController;
	private static final double encoderKP = 0.0; 
	private static final double encoderKI = 0.0;
	private static final double encoderKD = 0.0;


	public ShooterSubsystem (){
		this.shooterMotor = new CANTalon (RobotConstants.SHOOTER_MOTOR_CHANNEL);
		this.rotationEncoder = new Encoder(RobotConstants.SHOOTER_ENCODER_CHANNEL_A, RobotConstants.SHOOTER_ENCODER_CHANNEL_B, false, EncodingType.k4X);
		this.rotationEncoder.setDistancePerPulse(RobotConstants.SHOOTER_RATE_PER_PULSE);
		this.shooterOutput = new ShooterOutput (shooterMotor);
		this.rateController = new PIDController (encoderKP, encoderKI, encoderKD, rotationEncoder, shooterOutput);
	}

	protected void initDefaultCommand() {}

	public void initialize (){
		this.rotationEncoder.reset();
	}

	public void speed (double speed){
		this.shooterMotor.set(0.95);
	}

	public boolean isShooterFinished(){
		return rateController.onTarget();
	}

	public void setPIDParameters(double rate){
		rateController.reset();
		rateController.setOutputRange (-1,1);
		rateController.setSetpoint(rate);
		rateController.setAbsoluteTolerance(0.05*rate);
		rateController.enable();
	}

	public PIDController getRateController(){
		return this.rateController;
	}

	public void stop(){
		this.shooterMotor.set(0.0);
	}
}