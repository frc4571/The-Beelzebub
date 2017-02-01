package org.usfirst.frc.team7788.robot.commands;

import org.usfirst.frc.team7788.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousShooter extends Command  {

	public boolean shooter = false;
	
	public AutonomousShooter (){
		requires(Robot.SHOOTER_SUBSYSTEM);
	}

	protected void execute (){
		long start_time = System.currentTimeMillis();
		long finish_time= 120000;
		while(System.currentTimeMillis()-start_time <=finish_time){
			Robot.SHOOTER_SUBSYSTEM.speed(0.90);
			shooter= true;
		}
	}
	
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return shooter;
	}
	protected void end (){
		Robot.SHOOTER_SUBSYSTEM.stop();
	}
	
	
}
