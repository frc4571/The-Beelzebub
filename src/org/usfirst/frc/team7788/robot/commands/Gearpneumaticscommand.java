package org.usfirst.frc.team7788.robot.commands;

import org.usfirst.frc.team7788.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Gearpneumaticscommand extends Command {

	
	private boolean IsGearPushedOut;
	
	public  Gearpneumaticscommand (){
		requires(Robot.GEAR_SUBSYSTEM);
	}


	protected void initialize() {
		Robot.GEAR_SUBSYSTEM.initializeSubsystem();

	}
	protected void execute (){
		if (IsGearPushedOut){
			Robot.GEAR_SUBSYSTEM.pushIn();
			
			IsGearPushedOut = false; 
		}

		else  { 

         Robot.GEAR_SUBSYSTEM.pushOut();
         
         IsGearPushedOut = true;
		}
		
	}


	protected boolean isFinished (){
		return  true;
	}
}
