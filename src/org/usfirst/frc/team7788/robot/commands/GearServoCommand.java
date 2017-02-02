package org.usfirst.frc.team7788.robot.commands;

import org.usfirst.frc.team7788.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class GearServoCommand extends Command{
	
	private boolean rotateVal = false;
	private boolean alreadyPressed = false;
	
	public GearServoCommand (){
		requires(Robot.GEAR_SUBSYSTEM);
	}
	
	protected void execute (){
		if (this.rotateVal) {
			Robot.GEAR_SUBSYSTEM.setServoRotation(180.0);
		} else {
			Robot.GEAR_SUBSYSTEM.setServoRotation(0.0);
		}
		
		if(Robot.LEFT_JOYSTICK.getButton1().get() && alreadyPressed == false) {
			this.rotateVal = !this.rotateVal;
			this.alreadyPressed = true;
		} else if(Robot.LEFT_JOYSTICK.getButton1().get() == false) {
			this.alreadyPressed = false;
		}
	}
	
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
		
		}
	
	}






