package org.usfirst.frc.team4571.robot;

import org.usfirst.frc.team4571.robot.commands.drive.AutoDriveCommand;
import org.usfirst.frc.team4571.robot.commands.drive.RunFor30Minutes;
import org.usfirst.frc.team4571.robot.commands.drive.TeleopDriveCommand;
import org.usfirst.frc.team4571.robot.commands.drive.TurnDegreesCommand;
import org.usfirst.frc.team4571.robot.commands.drive.TurnThenDrive;
import org.usfirst.frc.team4571.robot.commands.gear.GearPneumaticsCommand;
import org.usfirst.frc.team4571.robot.commands.gear.GearServoCommand;
import org.usfirst.frc.team4571.robot.commands.mill.MillCommand;
import org.usfirst.frc.team4571.robot.commands.vision.TestVisionCommand;
import org.usfirst.frc.team4571.robot.subsystems.GearSubsystem;
import org.usfirst.frc.team4571.robot.subsystems.MillSubsystem;
import org.usfirst.frc.team4571.robot.subsystems.TankDriveSubsystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * 
 * @author arjunrao87
 *
 */
public class Robot extends IterativeRobot {

	// Joystick
	public static final RobotJoystick LEFT_JOYSTICK = new RobotJoystick(RobotConstants.LEFT_JOYSTICK_PORT);
	public static final RobotJoystick RIGHT_JOYSTICK = new RobotJoystick(RobotConstants.RIGHT_JOYSTICK_PORT);

	// Subsystems
	public static final TankDriveSubsystem TANK_DRIVE_SUBSYSTEM = new TankDriveSubsystem();
	//public static final IntakeSubsystem INTAKE_SUBSYSTEM = new IntakeSubsystem();
	public static final MillSubsystem MILL_SUBSYSTEM = new MillSubsystem();
	public static final GearSubsystem GEAR_SUBSYSTEM = new GearSubsystem();

	// Commands
	// -- Drive -- //
	public static final TeleopDriveCommand TANK_DRIVE_COMMAND = new TeleopDriveCommand();	
	public static final RunFor30Minutes RUN_FOR_30_MIN = new RunFor30Minutes();	
	public static final AutoDriveCommand DRIVE_STRAIGHT_COMMAND = new AutoDriveCommand(12, 0.0);	
	public static final TurnDegreesCommand TURN_RIGHT_90_DEGREES = new TurnDegreesCommand(90.0);
	public static final TurnDegreesCommand TURN_LEFT_90_DEGREES = new TurnDegreesCommand(-90.0);
	public static final TurnDegreesCommand TURN_RIGHT_180_DEGREES = new TurnDegreesCommand(179.9f);
	public static final TurnDegreesCommand TURN_LEFT_180_DEGREES = new TurnDegreesCommand(-179.9f);
	public static final TurnDegreesCommand TURN_RIGHT_270_DEGREES = new TurnDegreesCommand(269.9f);
	public static final TurnDegreesCommand TURN_LEFT_270_DEGREES = new TurnDegreesCommand(-269.9f);
	public static final TurnDegreesCommand TURN_LEFT_150_DEGREES = new TurnDegreesCommand(-150.0f);
	public static final TurnThenDrive TURN_RIGHT_45_AND_DRIVE_12_INCHES = new TurnThenDrive(45.0f, 12.0);

	// -- Intake -- //
//	public static final IntakeCommand INTAKE_COMMAND = new IntakeCommand();

	// -- Mill -- //
	public static final MillCommand MILL_COMMAND = new MillCommand();

	// -- Vision -- //
	public static final TestVisionCommand TEST_VISION_COMMAND = new TestVisionCommand();

	// -- Gear -- //
	public static final GearPneumaticsCommand GEAR_PNEMATICS_COMMAND = new GearPneumaticsCommand();
	public static final GearServoCommand GEAR_SERVO_COMMAND = new GearServoCommand();
 
	@Override
	public void robotInit() {
		// TODO : Should this be in teleop init?
	}

	@Override
	public void disabledInit(){
		Robot.TANK_DRIVE_SUBSYSTEM.disableBoth();
		Robot.TANK_DRIVE_SUBSYSTEM.initialize();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().removeAll();
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
//		Scheduler.getInstance().add(TEST_VISION_COMMAND);
		Scheduler.getInstance().add(DRIVE_STRAIGHT_COMMAND);
		Scheduler.getInstance().add(MILL_COMMAND);
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		Scheduler.getInstance().add(TANK_DRIVE_COMMAND);
		//Scheduler.getInstance().add(INTAKE_COMMAND);
		Scheduler.getInstance().add(GEAR_PNEMATICS_COMMAND);
		Scheduler.getInstance().add(GEAR_SERVO_COMMAND);
		//TODO : Do we need to mill command to be added here?
		
		Robot.LEFT_JOYSTICK.button4WhenPressed(TURN_LEFT_180_DEGREES);
		Robot.RIGHT_JOYSTICK.button4WhenPressed(TURN_RIGHT_180_DEGREES);
		Robot.LEFT_JOYSTICK.button3WhenPressed(TURN_LEFT_90_DEGREES);
		Robot.RIGHT_JOYSTICK.button3WhenPressed(TURN_RIGHT_90_DEGREES);
		Robot.RIGHT_JOYSTICK.button3WhenPressed(TURN_RIGHT_90_DEGREES);
		Robot.LEFT_JOYSTICK.button1WhenPressed(TURN_LEFT_270_DEGREES);
		Robot.RIGHT_JOYSTICK.button1WhenPressed(TURN_RIGHT_270_DEGREES);
		Robot.LEFT_JOYSTICK.button2WhenPressed(TURN_RIGHT_45_AND_DRIVE_12_INCHES);
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}