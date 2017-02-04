//package org.usfirst.frc.team4571.robot.subsystems;
//
//import org.usfirst.frc.team4571.robot.RobotConstants;
//import org.usfirst.frc.team4571.robot.components.pid.DriveOutput;
//import org.usfirst.frc.team4571.robot.components.sensors.EncoderAverage;
//
//import com.ctre.CANTalon;
//import com.kauailabs.navx.frc.AHRS;
//
//import edu.wpi.first.wpilibj.CounterBase.EncodingType;
//import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.wpilibj.PIDController;
//import edu.wpi.first.wpilibj.PIDOutput;
//import edu.wpi.first.wpilibj.PIDSourceType;
//import edu.wpi.first.wpilibj.RobotDrive;
//import edu.wpi.first.wpilibj.SPI;
//import edu.wpi.first.wpilibj.command.Subsystem;
//
///**
// *
// */ 
//public class TankDriveSubsystem extends Subsystem {
//
//	private RobotDrive robotDrive;
//	private CANTalon frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor;
//
//	private Encoder leftEncoder, rightEncoder;
//	
//	private double encoderKp = 0.05;
//	private double encoderKi = 10.0;
//	private double encoderKd = 8.0;
//
//	private final EncoderAverage encoderAverage;
//	private final PIDController distanceController;
//	
//	private double navKp = 0.05;
//	private double navKi = 0.0;
//	private double navKd = 0.0;
//	
//	private final AHRS navX;
//	private final DriveOutput angleOutput;
//	private final PIDController turnController;
//
//	public TankDriveSubsystem() {
//		this.frontLeftMotor = new CANTalon(RobotConstants.DRIVE_FRONT_LEFT_MOTOR_CHANNEL);
//		this.frontRightMotor = new CANTalon(RobotConstants.DRIVE_FRONT_RIGHT_MOTOR_CHANNEL);
//		this.rearLeftMotor = new CANTalon(RobotConstants.DRIVE_REAR_LEFT_MOTOR_CHANNEL);
//		this.rearRightMotor = new CANTalon(RobotConstants.DRIVE_REAR_RIGHT_MOTOR_CHANNEL);
//
//		this.robotDrive = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
//
//		this.leftEncoder = new Encoder(RobotConstants.LEFT_DRIVE_ENCODER_CHANNEL_A, RobotConstants.LEFT_DRIVE_ENCODER_CHANNEL_B, true, EncodingType.k4X);
//		this.rightEncoder = new Encoder(RobotConstants.RIGHT_DRIVE_ENCODER_CHANNEL_A, RobotConstants.RIGHT_DRIVE_ENCODER_CHANNEL_B, false, EncodingType.k4X);
//		this.leftEncoder.setDistancePerPulse(RobotConstants.DISTANCE_PER_PULSE);
//		this.rightEncoder.setDistancePerPulse(RobotConstants.DISTANCE_PER_PULSE);
//
//		this.encoderAverage = new EncoderAverage(leftEncoder, rightEncoder);
//		this.encoderAverage.setPIDSourceType(PIDSourceType.kDisplacement);
//		this.distanceController = new PIDController(encoderKp, encoderKi, encoderKd, encoderAverage, new PIDOutput() {
//			
//			@Override
//			public void pidWrite(double paramDouble) {
//				// Do nothing. this.angleOutput will take care of controlling the robot.
//			}
//		});
//		
//		this.navX = new AHRS(SPI.Port.kMXP);
//		this.navX.setPIDSourceType(PIDSourceType.kDisplacement);
//		this.angleOutput = new DriveOutput(robotDrive, distanceController);
//		this.turnController = new PIDController(navKp, navKi, navKd, navX, angleOutput); 
//	}
//	
//	public void initDefaultCommand() {}
//
//	public void initialize() {
//		this.encoderAverage.reset();
//		this.navX.reset();
//	}
//	
//	public double getLeftEncoderDistance() {
//		return this.leftEncoder.getDistance();
//	}
//
//	public double getRightEncoderDistance() {
//		return this.rightEncoder.getDistance();
//	}
//
//	public double getDistance() {
//		return encoderAverage.pidGet();
//	}
//	
//	public double getNavXAngle(){
//		return this.navX.getAngle();
//	}
//
//	public boolean isBothFinished() {
//		return distanceController.onTarget() && turnController.onTarget();
//	}
//	
//	public boolean isTurnFinished() {
//		return turnController.onTarget();
//	}
//
//	public void setBothPIDParameters(double distanceSetPoint, double angleSetPoint) {
//		distanceController.reset();
//		turnController.reset();
//		
//		distanceController.setOutputRange(-0.6, 0.6);
//		distanceController.setSetpoint(distanceSetPoint);
//		distanceController.setAbsoluteTolerance(0.1 * distanceSetPoint);
//		
//		turnController.setOutputRange(-0.6, 0.6);
//		turnController.setSetpoint(angleSetPoint);
//		turnController.setAbsoluteTolerance(2.0f);
//		
//		distanceController.enable();
//		turnController.enable();
//	}
//	
//	public void setAnglePIDParameter(double angleSetPoint) {
//		turnController.reset();		
//		turnController.setOutputRange(-0.6, 0.6);
//		turnController.setSetpoint(angleSetPoint);
//		turnController.setAbsoluteTolerance(2.0f);
//		turnController.enable();
//	}
//	
//	// Teleop drive
//	public void drive(double leftValue, double rightValue) {
//		this.robotDrive.tankDrive(leftValue, rightValue);
//	}
//
//	public void stop() {
//		robotDrive.drive(0,0);
//	}
//	
//	public PIDController getDistanceController() {
//		return this.distanceController;
//	}
//	
//	public PIDController getTurnController() {
//		return this.turnController;
//	}
//	
//	public void disableBoth() {
//		this.distanceController.disable();
//		this.turnController.disable();
//	}
//}