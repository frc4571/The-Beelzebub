package org.usfirst.frc.team4571.robot.commands.drive;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TeleopDriveCommand extends Command {

    public TeleopDriveCommand() {
    	requires(Robot.TANK_DRIVE_SUBSYSTEM);
    }

    protected void initialize() {}

    protected void execute() {
    	 Robot.TANK_DRIVE_SUBSYSTEM.drive(-Robot.LEFT_JOYSTICK.getYAxisSpeed(), -Robot.RIGHT_JOYSTICK.getYAxisSpeed());
    }                                       

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.TANK_DRIVE_SUBSYSTEM.stop();
    }

    protected void interrupted() {}

}