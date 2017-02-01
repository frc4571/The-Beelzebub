package org.usfirst.frc.team4571.robot.commands.mill;

import org.usfirst.frc.team4571.robot.Robot;
import org.usfirst.frc.team4571.robot.RobotConstants;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MillCommand extends Command {

	private boolean isCurrentDirectionIsForward;

	public MillCommand() {
		requires(Robot.MILL_SUBSYSTEM);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if( isCurrentDirectionIsForward ){
			reverse();
		} else{
			forward();
		}
		isCurrentDirectionIsForward = !isCurrentDirectionIsForward;
	}

	public void forward(){
		Robot.MILL_SUBSYSTEM.forward(RobotConstants.MILL_CONSTANT_SPEED);
		SmartDashboard.putNumber("MillForwardSpeed", RobotConstants.MILL_CONSTANT_SPEED);
	}

	public void reverse(){
		Robot.MILL_SUBSYSTEM.reverse(-RobotConstants.MILL_CONSTANT_SPEED);
		SmartDashboard.putNumber("MillReverseSpeed", -RobotConstants.MILL_CONSTANT_SPEED);
	}

	// Make this return true when this Command no longer needs to run execute()
	// TODO : Fix the boolean
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.MILL_SUBSYSTEM.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}