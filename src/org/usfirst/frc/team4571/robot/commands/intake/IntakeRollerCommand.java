package org.usfirst.frc.team4571.robot.commands.intake;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeRollerCommand extends Command {

	private double intakeRollerSpeed;
	
	public IntakeRollerCommand( double intakeRollerSpeed ) {
    	requires(Robot.INTAKE_SUBSYSTEM);
    	this.intakeRollerSpeed = intakeRollerSpeed;
    }
	
    protected void initialize() {
    }

    protected void execute() {
		Robot.INTAKE_SUBSYSTEM.setIntakeRollerSpeed(intakeRollerSpeed);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.INTAKE_SUBSYSTEM.stopRoller();
    }

    protected void interrupted() {
    }
}
