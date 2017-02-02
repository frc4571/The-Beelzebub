package org.usfirst.frc.team4571.robot.commands.mill;

import org.usfirst.frc.team4571.robot.Robot;
import org.usfirst.frc.team4571.robot.RobotConstants;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MillCommand extends Command {

	//TODO : This variable is not behaving as expected. We need to have different versions of the command
	private boolean isCurrentDirectionIsForward;

	public MillCommand() {
		requires(Robot.MILL_SUBSYSTEM);
	}

	protected void initialize() {}

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

	// TODO : Fix the boolean
	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.MILL_SUBSYSTEM.stop();
	}

	protected void interrupted() {}
}