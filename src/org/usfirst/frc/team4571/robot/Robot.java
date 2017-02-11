package org.usfirst.frc.team4571.robot;

import java.util.ArrayList;

import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team4571.robot.components.vision.FindGearPegPipeline;
import org.usfirst.frc.team4571.robot.vision.VisionProcessor;
import org.usfirst.frc.team4571.robot.vision.VisionSnapshotRecorder;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoCamera.WhiteBalance;
import edu.wpi.first.wpilibj. CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.vision.VisionThread;

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
	//public static final TankDriveSubsystem TANK_DRIVE_SUBSYSTEM = new TankDriveSubsystem();
	//public static final IntakeSubsystem INTAKE_SUBSYSTEM = new IntakeSubsystem();
	//public static final MillSubsystem MILL_SUBSYSTEM = new MillSubsystem();
	//public static final GearSubsystem GEAR_SUBSYSTEM = new GearSubsystem();

	// Commands
	// -- Drive -- //
	/*
	public static final TeleopDriveCommand TANK_DRIVE_COMMAND = new TeleopDriveCommand();	
	public static final RunFor30Minutes RUN_FOR_30_MIN = new RunFor30Minutes();	
	public static final AutoDriveCommand DRIVE_STRAIGHT_COMMAND = new AutoDriveCommand(0.25, 45);	
	public static final TurnDegreesCommand TURN_RIGHT_90_DEGREES = new TurnDegreesCommand(90.0);
	public static final TurnDegreesCommand TURN_LEFT_90_DEGREES = new TurnDegreesCommand(90.0);
	public static final TurnDegreesCommand TURN_180_DEGREES = new TurnDegreesCommand(180.0);

	// -- Intake -- //
	public static final IntakeCommand INTAKE_COMMAND = new IntakeCommand();

	// -- Mill -- //
	public static final MillCommand MILL_COMMAND = new MillCommand();

	// -- Vision -- //
	public static final TestVisionCommand TEST_VISION_COMMAND = new TestVisionCommand();

	// -- Gear -- //
	public static final GearPneumaticsCommand GEAR_PNEMATICS_COMMAND = new GearPneumaticsCommand();
	public static final GearServoCommand GEAR_SERVO_COMMAND = new GearServoCommand();
	*/
 
	@Override
	public void robotInit() {
		// TODO : Should this be in teleop init?
		// Robot.LEFT_JOYSTICK.button4WhenPressed(TURN_RIGHT_90_DEGREES);
		//  UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
		VisionSnapshotRecorder.LOGGING = false;
		VisionSnapshotRecorder.start();
		Thread visionProcessor = new Thread(new VisionProcessor());
		visionProcessor.start();
	}

	@Override
	public void disabledInit(){
		// Robot.TANK_DRIVE_SUBSYSTEM.disableBoth();
		// Robot.TANK_DRIVE_SUBSYSTEM.initialize();
	}

	@Override
	public void disabledPeriodic() {
		/*
		Scheduler.getInstance().removeAll();
		Scheduler.getInstance().run();
		*/
	}

	@Override
	public void autonomousInit() {
		/*
		Scheduler.getInstance().add(TEST_VISION_COMMAND);
		Scheduler.getInstance().add(DRIVE_STRAIGHT_COMMAND);
		Scheduler.getInstance().add(MILL_COMMAND);
		*/
	}

	@Override
	public void autonomousPeriodic() {
		// Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// Scheduler.getInstance().add(TANK_DRIVE_COMMAND);
		// Scheduler.getInstance().add(INTAKE_COMMAND);
		// Scheduler.getInstance().add(GEAR_PNEMATICS_COMMAND);
		// Scheduler.getInstance().add(GEAR_SERVO_COMMAND);
		// Scheduler.getInstance().add(TEST_VISION_COMMAND);
		//TODO : Do we need to mill command to be added here?
	}

	@Override
	public void teleopPeriodic() {
		// Scheduler.getInstance().run();
	}
	
	@Override
	public void robotPeriodic() {
		
	}

	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}