package org.usfirst.frc.team4571.robot;

import org.usfirst.frc.team4571.robot.commands.AutonomousGear;
import org.usfirst.frc.team4571.robot.commands.AutonomousSideGear;
//import org.usfirst.frc.team4571.robot.commands.AutonomousGear;
import org.usfirst.frc.team4571.robot.commands.climber.ClimberCommand;
import org.usfirst.frc.team4571.robot.commands.climber.ClimberReverse;
import org.usfirst.frc.team4571.robot.commands.drive.AutonomousDrive;
import org.usfirst.frc.team4571.robot.commands.drive.GearBoxPistonsCommand;
//import org.usfirst.frc.team4571.robot.commands.drive.GearBoxPistonsCommand;
import org.usfirst.frc.team4571.robot.commands.drive.TeleOpDriveCommand;
import org.usfirst.frc.team4571.robot.commands.drive.TurnCommand;
import org.usfirst.frc.team4571.robot.commands.gear.GearCatcherCommand;
import org.usfirst.frc.team4571.robot.commands.gear.GearReleaserCommand;
import org.usfirst.frc.team4571.robot.commands.gear.OpenReleaser;
//import org.usfirst.frc.team4571.robot.commands.gear.feederCommand;
import org.usfirst.frc.team4571.robot.commands.shooter.ShooterCommand;
//import org.usfirst.frc.team4571.robot.commands.shooter.mill;
import org.usfirst.frc.team4571.robot.subsystems.ClimberSubsystem;
import org.usfirst.frc.team4571.robot.subsystems.GearSubsystem;
import org.usfirst.frc.team4571.robot.subsystems.ShooterSubsystem;
import org.usfirst.frc.team4571.robot.subsystems.TankDriveSubsystem;
import org.usfirst.frc.team4571.robot.subsystems.millSubsystem;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 * @author Mahim, Arlenis, and Sharom
 *
 */
public class Robot extends IterativeRobot {

	// JoySticks
	public static final RobotJoystick LEFT_JOYSTICK = new RobotJoystick(RobotConstants.LEFT_JOYSTICK_PORT);
	public static final RobotJoystick RIGHT_JOYSTICK = new RobotJoystick(RobotConstants.RIGHT_JOYSTICK_PORT);
	public static final RobotJoystick ARCADE_BUTTONS = new RobotJoystick (RobotConstants.ARCADE_BUTTONS_PORT);

	// Subsystems
	public static final TankDriveSubsystem TANK_DRIVE_SUBSYSTEM = new TankDriveSubsystem();
	public static final GearSubsystem GEAR_SUBSYSTEM = new GearSubsystem();
	public static final ShooterSubsystem SHOOTER_SUBSYSTEM = new ShooterSubsystem();
	public static final ClimberSubsystem CLIMBER_SUBSYSTEM = new ClimberSubsystem();
	//public static final millSubsystem MILL_SUBSYSTEM = new millSubsystem();
	
	
	// Commands
	
	// Climber
	public static final ClimberCommand CLIMBER_COMMAND = new ClimberCommand(Robot.ARCADE_BUTTONS.getButton4());
	public static final ClimberReverse CLIMBER_REVERSE = new ClimberReverse(Robot.ARCADE_BUTTONS.getButton1());
	
	// Drive
	public static final TeleOpDriveCommand TELE_OP_DRIVE_COMMAND = new TeleOpDriveCommand();	
	public static final AutonomousDrive AUTONOMOUS = new AutonomousDrive(5, false);
	public static final AutonomousDrive DRIVE_BACK = new AutonomousDrive(1, true);
	
	public AutonomousGear AUTONOMOUS_GEAR;
	public AutonomousSideGear AUTONOMOUS_SIDE_GEAR;
	public static final TurnCommand TURN_90_DEGREES = new TurnCommand(90.0f);
	
	// Gear
	public static final GearCatcherCommand GEAR_CATCHER_COMMAND = new GearCatcherCommand(ARCADE_BUTTONS.getButton2());
	public static final GearReleaserCommand GEAR_RELEASER_COMMAND = new GearReleaserCommand(ARCADE_BUTTONS.getButton3());
	public static final GearBoxPistonsCommand GEARBOX_PISTON = new GearBoxPistonsCommand (LEFT_JOYSTICK.getButton1());
	public static final OpenReleaser OPEN_RELEASER = new OpenReleaser();
	
	// Shooter
	public static final ShooterCommand SHOOTER_COMMAND = new ShooterCommand(LEFT_JOYSTICK.getButton2());
	//public static final mill MILL_COMMAND = new mill(LEFT_JOYSTICK.getButton2());
	@Override
	public void robotInit() {
		//CameraServer.getInstance().startAutomaticCapture();
		
		AUTONOMOUS_GEAR = new AutonomousGear();
		//AUTONOMOUS_SIDE_GEAR = new AutonomousSideGear();
	}

	@Override
	public void disabledInit(){}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().removeAll();
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		Scheduler.getInstance().add(AUTONOMOUS_GEAR);
//		Scheduler.getInstance().add(AUTONOMOUS);
//		Scheduler.getInstance().add(AUTONOMOUS_SIDE_GEAR);
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {

		Scheduler.getInstance().add(TELE_OP_DRIVE_COMMAND);
		//Robot.ARCADE_BUTTONS.button1WhenPressed(CLIMBER_REVERSE);
		Robot.ARCADE_BUTTONS.button2WhenPressed(GEAR_CATCHER_COMMAND);
		Robot.ARCADE_BUTTONS.button3WhenPressed(GEAR_RELEASER_COMMAND);
		Robot.ARCADE_BUTTONS.button4WhenPressed(CLIMBER_COMMAND);
        Robot.LEFT_JOYSTICK.button1WhenPressed(GEARBOX_PISTON);
//		Robot.LEFT_JOYSTICK.button4WhenPressed(CLIMBER_COMMAND);
//		Robot.LEFT_JOYSTICK.button1WhenPressed(TURN_90_DEGREES);
        Robot.LEFT_JOYSTICK.button2WhenPressed(SHOOTER_COMMAND);
		
		
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