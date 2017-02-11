package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.RobotConstants;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeSubsystem extends Subsystem {

	private CANTalon intakeMotor;
	private DoubleSolenoid inAndOutSolenoid;
	private DoubleSolenoid upAndDownSolenoid;
	private Compressor compressor;
	@SuppressWarnings("unused")
	private Encoder encoder;

	public IntakeSubsystem(){
		this.intakeMotor = new CANTalon(RobotConstants.INTAKE_MOTOR_CHANNEL);
		// TODO : Commenting out solenoids until we have the hardware apparatus ready
//		this.inAndOutSolenoid = new DoubleSolenoid(RobotConstants.INTAKE_ROLLER_FOWARD_SOLENOID_CHANNEL, RobotConstants.INTAKE_ROLLER_REVERSE_SOLENOID_CHANNEL);
//		this.upAndDownSolenoid = new DoubleSolenoid(RobotConstants.INTAKE_ROLLER_FOWARD_SOLENOID_CHANNEL, RobotConstants.INTAKE_ROLLER_REVERSE_SOLENOID_CHANNEL);
		this.compressor = new Compressor(0);
		this.compressor.setClosedLoopControl(true);
		this.encoder = new Encoder(RobotConstants.INTAKE_ENCODER_CHANNEL_A, RobotConstants.INTAKE_ENCODER_CHANNEL_B, false,EncodingType.k4X);
	}

	public void initDefaultCommand() {}

	public void initialize() {
		// TODO : Do we need pushUp first?
		pushIn();
		pushDown();
		stopRoller();
	}

	public void pushOut(){
		this.inAndOutSolenoid.set(DoubleSolenoid.Value.kForward);
	}

	public void pushIn(){
		this.inAndOutSolenoid.set(DoubleSolenoid.Value.kReverse);
	}

	public void pushUp(){
		this.upAndDownSolenoid.set(DoubleSolenoid.Value.kForward);
	}

	public void pushDown(){
		this.upAndDownSolenoid.set(DoubleSolenoid.Value.kReverse);
	}

	public Value getHorizontalRollerSolenoidValue(){
		return inAndOutSolenoid.get();
	}

	public Value getVerticalRollerSolenoidValue(){
		return upAndDownSolenoid.get();
	}

	public void setIntakeRollerSpeed(double speed){
		this.intakeMotor.set(speed);
	}

	public void stopRoller() {
		this.intakeMotor.set(0);
	}
}