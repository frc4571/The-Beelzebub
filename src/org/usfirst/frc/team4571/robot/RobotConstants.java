package org.usfirst.frc.team4571.robot;

public class RobotConstants {

	// Joystick
	public static final int LEFT_JOYSTICK_PORT = 0;
	public static final int RIGHT_JOYSTICK_PORT = 1;
	public static final double JOYSTICK_TUNING_PARAMETER = 0.5;
	
	// Drive subsystem
	public static final int DRIVE_FRONT_LEFT_MOTOR_CHANNEL = 1;
	public static final int DRIVE_FRONT_RIGHT_MOTOR_CHANNEL = 2;
	public static final int DRIVE_REAR_LEFT_MOTOR_CHANNEL = 3;
	public static final int DRIVE_REAR_RIGHT_MOTOR_CHANNEL = 4;
	public static final int LEFT_DRIVE_ENCODER_CHANNEL_A = 0;
	public static final int LEFT_DRIVE_ENCODER_CHANNEL_B = 1;
	public static final int RIGHT_DRIVE_ENCODER_CHANNEL_A = 2;
	public static final int RIGHT_DRIVE_ENCODER_CHANNEL_B = 3; 

	public static final double DRIVE_TRAIN_WHEEL_DIAMETER_IN_FEET = 6;
	public static final double DRIVE_TRAIN_PULSES_PER_REVOLUTION = 360.0;
	public static final double GEAR_RATIO = 10.71;
	public static final double REAL_DRIVE_TRAIN_PULSES_PER_REVOLUTION = DRIVE_TRAIN_PULSES_PER_REVOLUTION;// * GEAR_RATIO;
	public static final double DISTANCE_TRAVELED_PER_PULSE = (Math.PI * DRIVE_TRAIN_WHEEL_DIAMETER_IN_FEET) / REAL_DRIVE_TRAIN_PULSES_PER_REVOLUTION;
	
	// Intake subsystem
	public static final int INTAKE_ENCODER_CHANNEL_A = 9;
	public static final int INTAKE_ENCODER_CHANNEL_B = 10;
	public static final int ROLLER_FOWARD_SOLENOID_CHANNEL = 0;
	public static final int ROLLER_REVERSE_SOLENOID_CHANNEL = 1;
	public static final int INTAKE_MOTOR_CHANNEL = 5;

	// Mill subsystem
	public static final int MILL_LEFT_MOTOR_CHANNEL = 1;
	public static final int MILL_RIGHT_MOTOR_CHANNEL = 2;
	public static final double MILL_CONSTANT_SPEED = 1.0;
	
	// Shooter subsystem
	public static final int SHOOTER_MOTOR_CHANNEL = 6;
	
	// Gear subsystem
	public static final int GEAR_FORWARD_CHANNEL = 0;
	public static final int GEAR_REVERSE_CHANNEL = 1;
	public static final int GEAR_SERVO_CHANNEL = 0;
	public static final int GEAR_COMPRESSOR_MODULE = 0;
	public static final double DISTANCE_FROM_FRONT_TO_WHEEL = 4.15;
}