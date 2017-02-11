package org.usfirst.frc.team4571.robot.vision;

/**
 * Currently implemented as storing only the current snapshot
 * TODO: Implement a queue of most recent X snapshots
 * @author Team 4571 Rambots #1
 *
 */
public class VisionSnapshotQueue {

	private VisionSnapshot current;
	
	public void push(VisionSnapshot snapshot) {
		this.current = snapshot;
	}
	
	public VisionSnapshot getCurrent() {
		return current;
	}
}
