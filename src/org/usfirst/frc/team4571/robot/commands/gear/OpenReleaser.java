package org.usfirst.frc.team4571.robot.commands.gear;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OpenReleaser extends Command {

    public OpenReleaser() {
    	requires(Robot.GEAR_SUBSYSTEM);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.GEAR_SUBSYSTEM.pushOut(Robot.GEAR_SUBSYSTEM.getReleaser());
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
