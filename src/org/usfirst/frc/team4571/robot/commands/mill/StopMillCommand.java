package org.usfirst.frc.team4571.robot.commands.mill;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class StopMillCommand extends Command {

	public StopMillCommand() {
		requires(Robot.MILL_SUBSYSTEM);
	}

	protected void initialize() {}

	protected void execute() {
		Robot.MILL_SUBSYSTEM.stop();
	}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {
		Robot.MILL_SUBSYSTEM.stop();
	}

	protected void interrupted() {}
}