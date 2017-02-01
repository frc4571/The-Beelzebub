package org.usfirst.frc.team7788.robot.subsystems;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class ShooterSource implements PIDSource  {
	private Encoder encoder;
	private PIDSourceType pidSourcetype;
	
	public void setPIDSourceType(Encoder encoder) {
		// TODO Auto-generated method stub
		this.encoder = encoder; 
	}

	@Override
	public PIDSourceType getPIDSourceType() {
		// TODO Auto-generated method stub
		return pidSourcetype;
	}

	@Override
	public double pidGet() {
		// TODO Auto-generated method stub
		return this.encoder.pidGet();
	}

	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
		// TODO Auto-generated method stub
		this.encoder.setPIDSourceType(pidSource);
	}

	

}
