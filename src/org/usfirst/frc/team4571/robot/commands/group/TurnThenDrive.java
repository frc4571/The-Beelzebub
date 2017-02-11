package org.usfirst.frc.team4571.robot.commands.group;

import org.usfirst.frc.team4571.robot.Robot;
import org.usfirst.frc.team4571.robot.commands.drive.AutoDriveCommand;
import org.usfirst.frc.team4571.robot.commands.drive.TurnDegreesCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TurnThenDrive extends CommandGroup {

    public TurnThenDrive(double angle, double distanceInInches) {
        requires(Robot.TANK_DRIVE_SUBSYSTEM);
        addSequential(new TurnDegreesCommand(angle));
        Robot.TANK_DRIVE_SUBSYSTEM.getTurnController().disable();
        Robot.TANK_DRIVE_SUBSYSTEM.reset();
        addSequential(new AutoDriveCommand(distanceInInches, 0.0));
    }
}