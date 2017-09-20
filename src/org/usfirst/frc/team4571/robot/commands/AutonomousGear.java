package org.usfirst.frc.team4571.robot.commands;

import org.usfirst.frc.team4571.robot.commands.drive.AutonomousDrive;
import org.usfirst.frc.team4571.robot.commands.gear.CloseReleaser;
import org.usfirst.frc.team4571.robot.commands.gear.OpenReleaser;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousGear extends CommandGroup {

    public AutonomousGear() {
    	//requires(Robot.TANK_DRIVE_SUBSYSTEM);
    	//requires(Robot.GEAR_SUBSYSTEM);
    	
    	addSequential(new AutonomousDrive(4, false));
    	//Timer.delay(1.0);
    	addSequential(new OpenReleaser());
    	//Timer.delay(1.0);
    	addSequential(new AutonomousDrive(1, true));
    	//Timer.delay(2.0);
    	addSequential(new CloseReleaser());
    }

}