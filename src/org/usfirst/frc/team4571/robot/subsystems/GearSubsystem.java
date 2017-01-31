package org.usfirst.frc.team4571.robot.subsystems;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearSubsystem extends Subsystem {

	private static final DoubleSolenoid GearSolenoid = new DoubleSolenoid (0,1);
	private static final Compressor compressor = new Compressor (0);
	Servo gearServo = new Servo(0);

	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	
	}
	
	public GearSubsystem (){
		compressor.setClosedLoopControl(true);
		
		
	}
	public void initializeSubsystem (){
		pushOut();
		
	}
	public void setSpeed(double Speed){
		this.gearServo.set(0.5);
	}
	public  void pushOut() {
		// TODO Auto-generated method stub
		GearSolenoid.set(DoubleSolenoid.Value.kForward);
	}

	public void pushIn() {
		GearSolenoid.set(DoubleSolenoid.Value.kReverse);
	}
	public Value getSolenoidvalue(){
		return GearSolenoid.get();
		
	}
	public void stop(){
		this.gearServo.set(0.0);
	}
}
	
	
	
      
	
	
