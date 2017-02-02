package org.usfirst.frc.team4571.robot.commands.gear;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class GearPneumaticsCommand extends Command {

	private boolean isGearPushedOut;

	public  GearPneumaticsCommand (){
		requires(Robot.GEAR_SUBSYSTEM);
	}

	protected void initialize() {
		Robot.GEAR_SUBSYSTEM.initializeSubsystem();
	}

	protected void execute (){
		if (isGearPushedOut){
			Robot.GEAR_SUBSYSTEM.pushIn();
		} else {
			Robot.GEAR_SUBSYSTEM.pushOut();
		}
		isGearPushedOut = !isGearPushedOut; 
	}

	protected boolean isFinished (){
		return  true;
	}
}