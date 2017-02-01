package org.usfirst.frc.team7788.robot.subsystems;

import org.usfirst.frc.team7788.robot.RobotConstants;
import org.usfirst.frc.team7788.robot.subsystems.ShooterOutput;
import org.usfirst.frc.team7788.robot.subsystems.ShooterSource;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ShooterSubsystem extends Subsystem {
	public CANTalon shooterMotor; 
    public Encoder encoder; 
    private  ShooterSource shootersource;
    private ShooterOutput shooteroutput ;
    private PIDController rateController;
    private static final double encoderKP = 0.0; 
    private static final double encoderKI = 0.0;
    private static final double encoderKD = 0.0;
    
    
	public ShooterSubsystem (){
		this.shooterMotor = new CANTalon (RobotConstants.SHOOTER_MOTOR_CHANNEL);
		this.encoder = new Encoder(RobotConstants.ONE_ENCODER_CHANNEL_A, RobotConstants.ONE_ENCODER_CHANNEL_B, false, EncodingType.k4X);
		this.encoder.setDistancePerPulse(RobotConstants.SHOOTER_DISTANCE_PER_PULSE);
		this.shootersource = new ShooterSource();
		this.shootersource.setPIDSourceType(PIDSourceType.kRate);
		this.shooteroutput = new ShooterOutput (shooterMotor);
		this.rateController = new PIDController (encoderKP, encoderKI, encoderKD, shootersource, shooteroutput);
	}
	
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	public void initialize (){
		this.encoder.reset();
	}
	
	public double getRPM(){
		return shootersource.pidGet();
		
	}
	public void speed (double speed){
	   this.shooterMotor.set(0.5);	
		
	}
	public boolean isShooterFinished(){
		return rateController.onTarget();
		
	}
	public void setPIDParameters(double Rategoal){
		rateController.reset();
		rateController.setOutputRange (-1,1);
		rateController.setSetpoint(Rategoal);
		rateController.setAbsoluteTolerance(0.05*Rategoal);
		rateController.enable();
	}
	public PIDController getRateController(){
		return this.rateController;
		
	}
	public void stop(){
		this.shooterMotor.set(0.0);
	}

	}
	
 
	