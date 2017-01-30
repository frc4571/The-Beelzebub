package org.usfirst.frc.team4571.robot.commands;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShooterCommand extends Command {

	private boolean IsShooterForward;
	
	public ShooterCommand (){
	requires(Robot.SHOOTER_SUBSYSTEM);

	}
protected void execute(){
	Robot.SHOOTER_SUBSYSTEM.speed(0.5);
	
	if (IsShooterForward){
		Robot.SHOOTER_SUBSYSTEM.speed(-0.5);
	}
	
}

protected boolean isFinished() {
	// TODO Auto-generated method stub
	return true;
}
	protected void end(){
	     
	}
	
}
