//package org.usfirst.frc.team4571.robot.commands.shooter;
//
//import org.usfirst.frc.team4571.robot.Robot;
//
//import edu.wpi.first.wpilibj.buttons.Button;
//import edu.wpi.first.wpilibj.command.Command;
//public class mill {
//	public boolean Mill = false;
//	//public boolean isAlreadyPressed;
//	//private Button button;
//	
//	//public Mill(Button button) {
//		//requires(Robot.SHOOTER_SUBSYSTEM);
//		this.button = button;
//	//}
//	
//	protected void execute() {
//		if (Mill){
//			Robot.SHOOTER_SUBSYSTEM.start();
//			} else {
//				Robot.SHOOTER_SUBSYSTEM.stop();
//				}
//			if (Robot.LEFT_JOYSTICK.getButton2().get() && isAlreadyPressed == false){
//				Mill =! Mill;
//				isAlreadyPressed =! isAlreadyPressed; 
//			}
//			else if  (Robot.LEFT_JOYSTICK.getButton2().get()== false ){
//				isAlreadyPressed =! isAlreadyPressed;
//			}
//	}
//
//	protected boolean isFinished() {
//		return false;
//	}
//	
//	protected void end() {}
//}
//
//
