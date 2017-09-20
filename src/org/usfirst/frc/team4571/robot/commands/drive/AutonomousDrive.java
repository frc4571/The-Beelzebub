package org.usfirst.frc.team4571.robot.commands.drive;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousDrive extends Command{

	public boolean drive = true;
	private boolean isInverted;
	public long timeInMilliSeconds;
	
	public AutonomousDrive(double timeInSeconds, boolean isInverted) {
		requires(Robot.TANK_DRIVE_SUBSYSTEM);
		this.timeInMilliSeconds = (long)(timeInSeconds * 1000);
		this.isInverted = isInverted;
	}

	protected void execute (){
	long start_time = System.currentTimeMillis();
		long finish_time = timeInMilliSeconds;
		while(System.currentTimeMillis()- start_time <= finish_time) {
			if (isInverted) {
				Robot.TANK_DRIVE_SUBSYSTEM.drive(0.52, 0.5);
			} else {
				Robot.TANK_DRIVE_SUBSYSTEM.drive(-0.52, -0.5);
			}
			drive = true;
		}
	}
	
	protected boolean isFinished() {
//		// TODO Auto-generated method stub
	return drive;
	}
	protected void end (){
		Robot.TANK_DRIVE_SUBSYSTEM.stop();
	}
//	
	
}


