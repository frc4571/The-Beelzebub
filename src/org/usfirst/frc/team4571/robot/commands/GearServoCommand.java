package org.usfirst.frc.team4571.robot.commands;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class GearServoCommand extends Command{

	
	public GearServoCommand (){
		requires(Robot.GEAR_SUBSYSTEM);
	}
	
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
		
		}
	
	}



