package org.usfirst.frc.team4571.robot.commands.gear;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CloseReleaser extends Command {

    public CloseReleaser() {
    	requires(Robot.GEAR_SUBSYSTEM);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.GEAR_SUBSYSTEM.pushIn(Robot.GEAR_SUBSYSTEM.getReleaser());
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
