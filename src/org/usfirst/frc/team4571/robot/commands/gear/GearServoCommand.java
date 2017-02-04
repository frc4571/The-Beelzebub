//package org.usfirst.frc.team4571.robot.commands.gear;
//
//import org.usfirst.frc.team4571.robot.Robot;
//
//import edu.wpi.first.wpilibj.command.Command;
//
//public class GearServoCommand extends Command{
//
//	private boolean rotateVal;
//	private boolean alreadyPressed;
//
//	public GearServoCommand (){
//		requires(Robot.GEAR_SUBSYSTEM);
//	}
//
//	protected void execute (){
//		if (this.rotateVal) {
//			Robot.GEAR_SUBSYSTEM.setServoRotation(180.0);
//		} else {
//			Robot.GEAR_SUBSYSTEM.setServoRotation(0.0);
//		}
//		// TODO : We shouldn't have to use joystick interaction here
//		if(Robot.LEFT_JOYSTICK.getButton1().get() && alreadyPressed == false) {
//			this.rotateVal = !this.rotateVal;
//			this.alreadyPressed = true;
//		} else if(Robot.LEFT_JOYSTICK.getButton1().get() == false) {
//			this.alreadyPressed = false;
//		}
//	}
//
//	//TODO : Is this correct?
//	protected boolean isFinished() {
//		return false;
//	}
//}