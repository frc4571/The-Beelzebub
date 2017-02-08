package org.usfirst.frc.team4571.robot.commands.drive;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TurnThenDrive extends CommandGroup {

    public TurnThenDrive(double angle, double distanceInInches) {
        requires(Robot.TANK_DRIVE_SUBSYSTEM);
        addSequential(new TurnDegreesCommand(angle));
        addSequential(new AutoDriveCommand(distanceInInches, 0.0));
    }
}