package org.usfirst.frc.team4571.robot.commands.shooter;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShooterCommand extends Command {
	
	public ShooterCommand (){
		requires(Robot.SHOOTER_SUBSYSTEM);
	}

	protected void execute(){
		Robot.SHOOTER_SUBSYSTEM.speed(0.95);
	}

	protected boolean isFinished() {
		return false;
	}
	
	protected void end(){
		Robot.SHOOTER_SUBSYSTEM.stop();
	}
}