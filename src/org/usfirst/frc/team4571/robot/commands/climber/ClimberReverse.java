package org.usfirst.frc.team4571.robot.commands.climber;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClimberReverse extends Command {

    private Button toggleReverseButton;
    private boolean isClimberReversed = false;

	public ClimberReverse(Button toggleReverseButton) {
    	requires(Robot.CLIMBER_SUBSYSTEM);
    	this.toggleReverseButton = toggleReverseButton;
    }
	
    protected void initialize(Button toggleReverseButton) {
    	Robot.CLIMBER_SUBSYSTEM.stop();
    }

    protected void execute() {
    	if ((this.isClimberReversed == false) && (this.toggleReverseButton.get())) {
    		Robot.CLIMBER_SUBSYSTEM.setReverse();
    		this.isClimberReversed = true;
    	} else if ((this.isClimberReversed == true) && (this.toggleReverseButton.get())) {
    		Robot.CLIMBER_SUBSYSTEM.stop();
    		this.isClimberReversed = false;
    	}
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}
    
    protected void interrupted() {}
}
