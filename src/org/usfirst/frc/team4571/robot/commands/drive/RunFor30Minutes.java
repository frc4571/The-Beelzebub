//package org.usfirst.frc.team4571.robot.commands.drive;
//
//import org.usfirst.frc.team4571.robot.Robot;
//import edu.wpi.first.wpilibj.command.Command;
//
//public class RunFor30Minutes extends Command {
//	
//	public boolean driveStop;
//	
//	public RunFor30Minutes() {
//		requires(Robot.TANK_DRIVE_SUBSYSTEM);
//	}
//	
//	protected void initialize() {}
//
//	protected void execute() {
//		long startFowardTime = System.currentTimeMillis();
//		long finishFowardTime = 1800000;
//		while( System.currentTimeMillis() - startFowardTime <= finishFowardTime ) {
//			Robot.TANK_DRIVE_SUBSYSTEM.drive(.3,.3);
//			driveStop = true;
//		}
//	}
//
//	protected boolean isFinished() {
//		return driveStop;
//
//	}
//
//	protected void end() {
//		Robot.TANK_DRIVE_SUBSYSTEM.stop();
//	}
//
//	protected void interrupted() {}
//	
//}