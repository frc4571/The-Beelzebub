package org.usfirst.frc.team4571.robot.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeSubsystem extends Subsystem {

	private CANTalon intakeMotor;
	private DoubleSolenoid solenoidInAndOut;
	private DoubleSolenoid solenoidUpAndDown;
	private Compressor compressor;
	@SuppressWarnings("unused")
	private Encoder encoder;

	public IntakeSubsystem(){

		this.intakeMotor = new CANTalon(RobotConstants.INTAKE_MOTOR_CHANNEL);
		this.solenoidInAndOut = new DoubleSolenoid(RobotConstants.ROLLER_FOWARD_SOLENOID_CHANNEL, RobotConstants.ROLLER_REVERSE_SOLENOID_CHANNEL);
		this.solenoidUpAndDown = new DoubleSolenoid(RobotConstants.ROLLER_FOWARD_SOLENOID_CHANNEL, RobotConstants.ROLLER_REVERSE_SOLENOID_CHANNEL);
		this.compressor = new Compressor(0);
		this.compressor.setClosedLoopControl(true);
		this.encoder = new Encoder(RobotConstants.INTAKE_ENCODER_CHANNEL_A, RobotConstants.INTAKE_ENCODER_CHANNEL_B, false,EncodingType.k4X);
	}
    public void initDefaultCommand() {}
	
	public void initialize() {
		pushIn();
		pushDown();
	}
	public void pushOut(){
		this.solenoidInAndOut.set(DoubleSolenoid.Value.kForward);
	}
	public void pushIn(){
		this.solenoidInAndOut.set(DoubleSolenoid.Value.kReverse);
	}
	public void pushUp(){
		this.solenoidUpAndDown.set(DoubleSolenoid.Value.kForward);
	}
	public void pushDown(){
		this.solenoidUpAndDown.set(DoubleSolenoid.Value.kReverse);
	}
	public Value getRollerSolenoidValueHorizontal(){
		return solenoidInAndOut.get();
	}
	public Value getRollerSolenoidValueVertical(){
		return solenoidUpAndDown.get();
	}
	public void setSpeed(double speed){
		this.intakeMotor.set(speed);
	}
	public void stopRoller() {
		this.intakeMotor.set(0);
	}
}