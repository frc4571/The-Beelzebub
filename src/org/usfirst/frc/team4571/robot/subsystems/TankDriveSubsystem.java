package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.RobotConstants;
import org.usfirst.frc.team4571.robot.subsystems.components.pid.DriveOutput;

import com.ctre.CANTalon;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TankDriveSubsystem extends Subsystem {

	private RobotDrive robotDrive;
	private CANTalon frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor;
	private DoubleSolenoid gearBoxPistons;
	private final AHRS navX;
	private final DriveOutput angleOutput;
	private final PIDController turnController;
	
	private final double navKp = 1.37;
	private final double navKi = 0.0;
	private final double navKd = 3.1;

	public TankDriveSubsystem() {
		this.frontLeftMotor = new CANTalon(RobotConstants.DRIVE_FRONT_LEFT_MOTOR_CHANNEL);
		this.frontRightMotor = new CANTalon(RobotConstants.DRIVE_FRONT_RIGHT_MOTOR_CHANNEL);
		this.rearLeftMotor = new CANTalon(RobotConstants.DRIVE_REAR_LEFT_MOTOR_CHANNEL);
		this.rearRightMotor = new CANTalon(RobotConstants.DRIVE_REAR_RIGHT_MOTOR_CHANNEL);
		this.robotDrive = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
		this.navX = new AHRS(SPI.Port.kMXP);
		this.angleOutput = new DriveOutput(this.robotDrive);
		
		this.turnController = new PIDController(navKp, navKi, navKd, navX, angleOutput);
		this.robotDrive.setExpiration(0.1);
		this.robotDrive.setSafetyEnabled(true);
	}

	public void initDefaultCommand() {
		
	}

	// TeleOP Drive
	public void drive(double leftValue, double rightValue) {
		this.robotDrive.tankDrive(leftValue, rightValue);
	}

	public void stop() {
		robotDrive.drive(0,0);
	}
	public DoubleSolenoid getGearBoxPistons() {
		return this.gearBoxPistons;
	}
	
//	public void shiftHigh() {
//		gearBoxPistons.set(Value.kForward);
//	}
	
	public void resetNavX() {
		this.navX.reset();
	}
	
	public double getNavXAngle() { 
		return this.navX.getAngle();
	}
	
	public boolean isTurnFinished() {
		return turnController.onTarget();
	}
	
	public void setAnglePIDParameter(double angleSetPoint) {
		turnController.reset();	
		turnController.setInputRange(-180.0f, 180.0f);
		turnController.setOutputRange(-0.6, 0.6);
		turnController.setSetpoint(angleSetPoint);
		turnController.setAbsoluteTolerance(5.0f);
		turnController.enable();
	}
	
	public PIDController getTurnController() {
		return this.turnController;
	}
	
	public void disableTurnController() {
		this.turnController.disable();
	}
}