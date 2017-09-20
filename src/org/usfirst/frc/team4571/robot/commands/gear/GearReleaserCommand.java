package org.usfirst.frc.team4571.robot.commands.gear;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GearReleaserCommand extends Command {
	
	private boolean isReleaserPushedIn;
	private boolean isReleaserPushedOut;
	private Button button;

    public GearReleaserCommand(Button button) {
    	requires(Robot.GEAR_SUBSYSTEM);

    	this.button = button;
    }

    protected void initialize() {
    	Robot.GEAR_SUBSYSTEM.pushIn(Robot.GEAR_SUBSYSTEM.getReleaser());
    }

    protected void execute() {
    	if (isReleaserPushedOut) {
        	Robot.GEAR_SUBSYSTEM.pushOut(Robot.GEAR_SUBSYSTEM.getReleaser());
        	//Robot.
    	} else {
        	Robot.GEAR_SUBSYSTEM.pushIn(Robot.GEAR_SUBSYSTEM.getReleaser());
    	}
    		if (this.button.get() && isReleaserPushedIn == false) {
    			this.isReleaserPushedOut = !isReleaserPushedOut;
    	} else if(this.button.get() == false) {
    		this.isReleaserPushedIn = !isReleaserPushedIn;
    	}
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
}
