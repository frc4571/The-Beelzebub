package org.usfirst.frc.team4571.robot.commands.intake;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeSolenoid extends Command {

	private boolean isRollerOut;
	private boolean isRollerDown;

	public IntakeSolenoid() {
		requires(Robot.INTAKE_SUBSYSTEM);
	}

	protected void initialize() {
		Robot.INTAKE_SUBSYSTEM.initialize();
		isRollerOut = true;
		isRollerDown = true;
	}
    protected void execute() {
		if( isRollerOut ){
			Robot.INTAKE_SUBSYSTEM.stopRoller();
			Robot.INTAKE_SUBSYSTEM.pushIn();
		} else{
			Robot.INTAKE_SUBSYSTEM.pushOut();
		}
		isRollerOut = !isRollerOut;
		if(isRollerDown){
			Robot.INTAKE_SUBSYSTEM.pushUp();
		}else{
			Robot.INTAKE_SUBSYSTEM.pushDown();
		}
		isRollerDown = !isRollerDown;
	}
	protected boolean isFinished() {
		return true;
	}
	protected void end() {
	}
	protected void interrupted() {
	}
}