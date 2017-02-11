package org.usfirst.frc.team4571.robot.commands.intake;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeRoller extends Command {

   
	public IntakeRoller() {
    	requires(Robot.INTAKE_SUBSYSTEM);
    }
    protected void initialize() {
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//TODO : We shouldnt have to set a constant speed here. This should be passed in from somewhere
		Robot.INTAKE_SUBSYSTEM.setIntakeRollerSpeed(.5);
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }
    // Called once after isFinished returns true
    protected void end() {
    	Robot.INTAKE_SUBSYSTEM.stopRoller();
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
