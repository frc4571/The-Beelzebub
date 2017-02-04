//package org.usfirst.frc.team4571.robot.commands.intake;
//
//import org.usfirst.frc.team4571.robot.Robot;
//
//import edu.wpi.first.wpilibj.command.Command;
//
//public class IntakeCommand extends Command {
//	
//	private boolean isRollerOut;
//	
//	public IntakeCommand() {
//		requires(Robot.INTAKE_SUBSYSTEM);
//	}
//
//	protected void initialize() {
//		Robot.INTAKE_SUBSYSTEM.initialize();
//		isRollerOut = true;
//	}
//	
//	protected void execute() {
//		if( isRollerOut ) {
//			Robot.INTAKE_SUBSYSTEM.stopRoller();
//			Robot.INTAKE_SUBSYSTEM.in();
//		} else{
//			Robot.INTAKE_SUBSYSTEM.out();
//			//TODO : We shouldnt have to set a constant speed here. This should be passed in from somewhere
//			Robot.INTAKE_SUBSYSTEM.setSpeed(.5);
//		}
//		isRollerOut = !isRollerOut;
//	}
//	
//	protected boolean isFinished() {
//		return false;
//	}
//	
//	protected void end() {
//		Robot.INTAKE_SUBSYSTEM.stopRoller();
//	}
//
//	protected void interrupted() {}
//	
//}