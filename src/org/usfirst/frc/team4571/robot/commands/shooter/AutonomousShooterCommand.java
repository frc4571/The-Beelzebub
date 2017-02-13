package org.usfirst.frc.team4571.robot.commands.shooter;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousShooterCommand extends Command  {

	public AutonomousShooterCommand(){
		requires(Robot.SHOOTER_SUBSYSTEM);
	}

	protected void execute (){
		long start_time = System.currentTimeMillis();
		long finish_time= 120000;
		while(System.currentTimeMillis() - start_time <=finish_time){
			Robot.SHOOTER_SUBSYSTEM.speed(0.90);
		}
	}

	protected boolean isFinished() {
		return true;
	}
	
	protected void end (){
		Robot.SHOOTER_SUBSYSTEM.stop();
	}
}