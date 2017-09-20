package org.usfirst.frc.team4571.robot.commands.drive;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GearBoxPistonsCommand extends Command {
	private Button button;
	private boolean isGearInHighRatio = false;

    public GearBoxPistonsCommand(Button button) {
    	requires(Robot.GEAR_SUBSYSTEM);
    	this.button = button;
    }
    protected void initialize() {
    	Robot.GEAR_SUBSYSTEM.pushIn(Robot.GEAR_SUBSYSTEM.getGearShifter());    	
    }

    protected void execute() {
    	if ((isGearInHighRatio == false) && (button.get() == true)) {
    		Robot.GEAR_SUBSYSTEM.pushOut(Robot.GEAR_SUBSYSTEM.getGearShifter());
    		isGearInHighRatio = true;
    	} else if ((isGearInHighRatio) && (button.get() == true)) {
    		Robot.GEAR_SUBSYSTEM.pushIn(Robot.GEAR_SUBSYSTEM.getGearShifter());
    		isGearInHighRatio = false;
    	}
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
}
