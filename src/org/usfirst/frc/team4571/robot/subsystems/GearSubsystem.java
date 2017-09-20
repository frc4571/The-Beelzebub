package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.RobotConstants;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import edu.wpi.first.wpilibj.command.Subsystem;

public class GearSubsystem extends Subsystem {

	private final DoubleSolenoid catcherPistons;
	private final DoubleSolenoid releasePistons;
	private final DoubleSolenoid gearBoxPistons; 
	private final Compressor compressor;

	public GearSubsystem() {
		this.catcherPistons = new DoubleSolenoid(RobotConstants.CATCHER_PISTON_FORWARD_CHANNEL, RobotConstants.CATCHER_PISTON_REVERSE_CHANNEL);
		this.releasePistons = new DoubleSolenoid(RobotConstants.RELEASE_PISTON_FORWARD_CHANNEL, RobotConstants.RELEASE_PISTON_REVERSE_CHANNEL);
		this.gearBoxPistons = new DoubleSolenoid( RobotConstants.GEAR_BOX_PISTON_FORWARD_CHANNEL,RobotConstants.GEAR_BOX_PISTON_REVERSE_CHANNEL );
		this.compressor = new Compressor(RobotConstants.GEAR_COMPRESSOR_MODULE);
		this.compressor.setClosedLoopControl(true);
	}

	protected void initDefaultCommand() {}

	public void pushOut(DoubleSolenoid doubleSolenoid) {
		doubleSolenoid.set(DoubleSolenoid.Value.kForward);
	}

	public void pushIn(DoubleSolenoid doubleSolenoid) {
		doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
	}

	
	public DoubleSolenoid getCatcher() {
		return this.catcherPistons;
	}
	
	public DoubleSolenoid getReleaser() {
		return this.releasePistons;
	}
	public DoubleSolenoid getGearShifter(){
		return this.gearBoxPistons;
		
	}
	
}