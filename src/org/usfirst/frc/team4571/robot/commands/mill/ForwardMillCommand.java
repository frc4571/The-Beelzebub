package org.usfirst.frc.team4571.robot.commands.mill;

import org.usfirst.frc.team4571.robot.Robot;
import org.usfirst.frc.team4571.robot.RobotConstants;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ForwardMillCommand extends Command {

	public ForwardMillCommand() {
		requires(Robot.MILL_SUBSYSTEM);
	}

	protected void initialize() {}

	protected void execute() {
		forward();
	}

	private void forward(){
		Robot.MILL_SUBSYSTEM.forward(RobotConstants.MILL_CONSTANT_SPEED);
		SmartDashboard.putNumber("Mill Forward Speed", RobotConstants.MILL_CONSTANT_SPEED);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.MILL_SUBSYSTEM.stop();
	}

	protected void interrupted() {}
}