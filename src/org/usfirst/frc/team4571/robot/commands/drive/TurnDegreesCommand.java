package org.usfirst.frc.team4571.robot.commands.drive;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TurnDegreesCommand extends Command {

    private double angle;

	public TurnDegreesCommand(double angle) {
    	requires(Robot.TANK_DRIVE_SUBSYSTEM);
    	this.angle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.TANK_DRIVE_SUBSYSTEM.initialize();
    	Robot.TANK_DRIVE_SUBSYSTEM.setAnglePIDParameter(angle);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("NavX Angle", Robot.TANK_DRIVE_SUBSYSTEM.getNavXAngle());
    	SmartDashboard.putNumber("Angle SetPoint", Robot.TANK_DRIVE_SUBSYSTEM.getTurnController().getSetpoint());
    	SmartDashboard.putNumber("Angle Average Error", Robot.TANK_DRIVE_SUBSYSTEM.getTurnController().getAvgError());
    	SmartDashboard.putNumber("Angle Error", Robot.TANK_DRIVE_SUBSYSTEM.getTurnController().getError());

    	SmartDashboard.putNumber("Turn Controller Get", Robot.TANK_DRIVE_SUBSYSTEM.getTurnController().get());
    	SmartDashboard.putNumber("Distance Controller Get", (Robot.TANK_DRIVE_SUBSYSTEM.getDistanceController().get()));
    	SmartDashboard.putNumber("Left Speed ( Distance - Turn )", (Robot.TANK_DRIVE_SUBSYSTEM.getDistanceController().get() - Robot.TANK_DRIVE_SUBSYSTEM.getTurnController().get()));
    	SmartDashboard.putNumber("Right Speed ( Distance + Turn )", (Robot.TANK_DRIVE_SUBSYSTEM.getDistanceController().get() + Robot.TANK_DRIVE_SUBSYSTEM.getTurnController().get()));
    	
    	SmartDashboard.putNumber("Distance P", Robot.TANK_DRIVE_SUBSYSTEM.getDistanceController().getP() );
    	SmartDashboard.putNumber("Distance I", Robot.TANK_DRIVE_SUBSYSTEM.getDistanceController().getI() );
    	SmartDashboard.putNumber("Distance D", Robot.TANK_DRIVE_SUBSYSTEM.getDistanceController().getD() );
    	
    	SmartDashboard.putNumber("Turn P", Robot.TANK_DRIVE_SUBSYSTEM.getTurnController().getP() );
    	SmartDashboard.putNumber("Turn I", Robot.TANK_DRIVE_SUBSYSTEM.getTurnController().getI() );
    	SmartDashboard.putNumber("Turn D", Robot.TANK_DRIVE_SUBSYSTEM.getTurnController().getD() );
    	
    	SmartDashboard.putBoolean( "Is Turn Finished", isFinished() );
    	
    	System.out.println("NavX Angle= " +  Robot.TANK_DRIVE_SUBSYSTEM.getNavXAngle());
    	System.out.println("Angle SetPoint= " +  Robot.TANK_DRIVE_SUBSYSTEM.getTurnController().getSetpoint());
    	System.out.println("Angle Average Error= " +  Robot.TANK_DRIVE_SUBSYSTEM.getTurnController().getAvgError());
    	System.out.println("Angle Error= " +  Robot.TANK_DRIVE_SUBSYSTEM.getTurnController().getError());

    	System.out.println("Turn Controller Get= " +  Robot.TANK_DRIVE_SUBSYSTEM.getTurnController().get());
//    	System.out.println("Distance Controller Get= " +  (Robot.TANK_DRIVE_SUBSYSTEM.getDistanceController().get()));
    	System.out.println("Left Speed ( Distance - Turn )= " +  (Robot.TANK_DRIVE_SUBSYSTEM.getDistanceController().get() - Robot.TANK_DRIVE_SUBSYSTEM.getTurnController().get()));
    	System.out.println("Right Speed ( Distance + Turn )= " +  (Robot.TANK_DRIVE_SUBSYSTEM.getDistanceController().get() + Robot.TANK_DRIVE_SUBSYSTEM.getTurnController().get()));
    	
    	System.out.println( "Turn controller ontarget= " +  Robot.TANK_DRIVE_SUBSYSTEM.getTurnController().onTarget());
    	
//    	System.out.println("Distance P= " +  Robot.TANK_DRIVE_SUBSYSTEM.getDistanceController().getP() );
//    	System.out.println("Distance I= " +  Robot.TANK_DRIVE_SUBSYSTEM.getDistanceController().getI() );
//    	System.out.println("Distance D= " +  Robot.TANK_DRIVE_SUBSYSTEM.getDistanceController().getD() );
    	
//    	System.out.println("Turn P= " +  Robot.TANK_DRIVE_SUBSYSTEM.getTurnController().getP() );
//    	System.out.println("Turn I= " +  Robot.TANK_DRIVE_SUBSYSTEM.getTurnController().getI() );
//    	System.out.println("Turn D= " +  Robot.TANK_DRIVE_SUBSYSTEM.getTurnController().getD() );
    	
    	System.out.println( "Is Turn Finished= " +  isFinished() );
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.TANK_DRIVE_SUBSYSTEM.isTurnFinished();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.TANK_DRIVE_SUBSYSTEM.getTurnController().disable();
    	Robot.TANK_DRIVE_SUBSYSTEM.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.TANK_DRIVE_SUBSYSTEM.getTurnController().disable();
    }
}