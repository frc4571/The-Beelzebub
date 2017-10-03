package org.usfirst.frc.team4571.robot.commands.gear;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;

public class GearCatcherCommand extends Command {

	private boolean isCatcherPushedIn;
	private boolean isCatcherPushedOut;
	private Button button;

	public GearCatcherCommand(Button button) {
		requires(Robot.GEAR_SUBSYSTEM);
		this.button = button;
	}

	protected void initialize() {
		Robot.GEAR_SUBSYSTEM.pushIn(Robot.GEAR_SUBSYSTEM.getCatcher());
	}

	protected void execute() {
		if (isCatcherPushedOut) {
			Robot.GEAR_SUBSYSTEM.pushOut(Robot.GEAR_SUBSYSTEM.getCatcher());
			Robot.GEAR_SUBSYSTEM.pushOut(Robot.GEAR_SUBSYSTEM.getReleaser());
		} else {
			Robot.GEAR_SUBSYSTEM.pushIn(Robot.GEAR_SUBSYSTEM.getCatcher());
		}		
		if (this.button.get() && this.isCatcherPushedIn == false) {
			this.isCatcherPushedOut = !isCatcherPushedOut;
		} else if (this.button.get() == false) {
			this.isCatcherPushedIn = !isCatcherPushedIn;	
		}
	}

	protected boolean isFinished() {
		return true;
	}
	
	protected void end() {}
	
	protected void interrupted() {}
}