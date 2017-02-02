package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.RobotConstants;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearSubsystem extends Subsystem {

	private final DoubleSolenoid gearSolenoid;
	private final Compressor compressor;
	private final Servo gearServo;
	
	public GearSubsystem (){
		this.gearSolenoid = new DoubleSolenoid( RobotConstants.GEAR_FORWARD_CHANNEL, RobotConstants.GEAR_REVERSE_CHANNEL );
		this.gearServo = new Servo( RobotConstants.GEAR_SERVO_CHANNEL );
		this.compressor = new Compressor( RobotConstants.GEAR_COMPRESSOR_MODULE );
		this.compressor.setClosedLoopControl(true);
	}
	
	protected void initDefaultCommand() {}
	
	public void initializeSubsystem (){
		pushOut();
	}
	
	public void setServoRotation(double angle){
		this.gearServo.setAngle(angle);
	}
	
	public  void pushOut() {
		gearSolenoid.set(DoubleSolenoid.Value.kForward);
	}

	public void pushIn() {
		gearSolenoid.set(DoubleSolenoid.Value.kReverse);
	}
	
	public Value getSolenoidvalue(){
		return gearSolenoid.get();
	}
	
	public void stop(){
		this.gearServo.set(0.0);
	}
}