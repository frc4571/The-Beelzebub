package org.usfirst.frc.team4571.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team4571.robot.commands.drive.AutonomousDrive;
import org.usfirst.frc.team4571.robot.commands.drive.TurnCommand;
import org.usfirst.frc.team4571.robot.commands.gear.CloseReleaser;
import org.usfirst.frc.team4571.robot.commands.gear.OpenReleaser;

public class AutonomousSideGear extends CommandGroup{
	 public AutonomousSideGear() {
	    	
	    	addSequential(new AutonomousDrive(2.8,  false));
	    	//Timer.delay(4.0);
	    	addSequential(new TurnCommand(-60.0f));
	    	addSequential(new AutonomousDrive(3.6,false));
	    	Timer.delay(1.0);
	    	addSequential(new OpenReleaser());
	    	addSequential(new AutonomousDrive(1, true));
	    	Timer.delay(2.0);
	    	addSequential(new CloseReleaser());
	    }

}
