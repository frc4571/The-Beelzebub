package org.usfirst.frc.team4571.robot.commands.drive;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TurnCommand extends Command {

	
	
	private double angle;

    public TurnCommand(double angle) {
    	requires(Robot.TANK_DRIVE_SUBSYSTEM);
    	this.angle = angle;
    }

    protected void initialize() {
    	Robot.TANK_DRIVE_SUBSYSTEM.resetNavX();
    	Robot.TANK_DRIVE_SUBSYSTEM.setAnglePIDParameter(angle);
    	SmartDashboard.putData("PID", Robot.TANK_DRIVE_SUBSYSTEM.getTurnController());
    }

   
	

    protected boolean isFinished() {
       return Robot.TANK_DRIVE_SUBSYSTEM.isTurnFinished();
    	
    }
    

    protected void end() {
    	Robot.TANK_DRIVE_SUBSYSTEM.getTurnController().disable();
    	Robot.TANK_DRIVE_SUBSYSTEM.resetNavX();
    }

    protected void interrupted() {
    }
}
