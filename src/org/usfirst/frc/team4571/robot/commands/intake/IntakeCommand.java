package org.usfirst.frc.team4571.robot.commands.intake;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeCommand extends Command {
	
	private boolean isRollerOut;
	
	public IntakeCommand() {
		requires(Robot.INTAKE_SUBSYSTEM);
	}

	protected void initialize() {
		Robot.INTAKE_SUBSYSTEM.initialize();
		isRollerOut = true;
	}
	
	protected void execute() {
		if( isRollerOut ) {
			Robot.INTAKE_SUBSYSTEM.in();
			isRollerOut = false;
		}
		else{
			Robot.INTAKE_SUBSYSTEM.out();
			Robot.INTAKE_SUBSYSTEM.setSpeed(.5);
			isRollerOut = true;
		}
	}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {
		Robot.INTAKE_SUBSYSTEM.stopRoller(0);
	}

	protected void interrupted() {}
	
}