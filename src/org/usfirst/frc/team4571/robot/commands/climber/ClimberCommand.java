package org.usfirst.frc.team4571.robot.commands.climber;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClimberCommand extends Command {
	private Button togglePowerButton;
	private boolean isClimberOn = false;

    public ClimberCommand(Button togglePowerButton) {
        requires(Robot.CLIMBER_SUBSYSTEM);
        this.togglePowerButton = togglePowerButton;
    }

    protected void initialize() {
    	Robot.CLIMBER_SUBSYSTEM.stop();
    	
    }

    protected void execute() {
    	if ((this.isClimberOn == false) && (this.togglePowerButton.get())) {
    		Robot.CLIMBER_SUBSYSTEM.start();
    		this.isClimberOn = true;
    	} else if ((this.isClimberOn == true) && (this.togglePowerButton.get())) {
    		Robot.CLIMBER_SUBSYSTEM.stop();
    		this.isClimberOn = false;
    	}
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
}
