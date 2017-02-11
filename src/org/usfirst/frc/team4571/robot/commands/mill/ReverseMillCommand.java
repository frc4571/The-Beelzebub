package org.usfirst.frc.team4571.robot.commands.mill;

import org.usfirst.frc.team4571.robot.Robot;
import org.usfirst.frc.team4571.robot.RobotConstants;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ReverseMillCommand extends Command {

	public ReverseMillCommand() {
		requires(Robot.MILL_SUBSYSTEM);
	}

	protected void initialize() {}

	protected void execute() {
		reverse();
	}
	
	private void reverse(){
		Robot.MILL_SUBSYSTEM.reverse(-RobotConstants.MILL_CONSTANT_SPEED);
		SmartDashboard.putNumber("MillReverseSpeed", -RobotConstants.MILL_CONSTANT_SPEED);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.MILL_SUBSYSTEM.stop();
	}

	protected void interrupted() {}
}