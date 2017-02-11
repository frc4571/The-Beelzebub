package org.usfirst.frc.team4571.robot.vision;

/**
 * Separate thread for processing vision results
 * @author Team 4571 Rambots #1
 *
 */
public class VisionProcessor implements Runnable, VisionConstants {

	@Override
	public void run() {
		while (true) {
			try {
				VisionSnapshot snapshot = VisionSnapshotRecorder.get().getSnapshot();
				if (snapshot != null) {
					processSnapshot(snapshot);
				}
				Thread.sleep(VISION_PROCESSOR_FREQUENCY_MILLIS);
			} catch (InterruptedException e) {
				e.printStackTrace(System.err);
			}
		}
	}
	
	private void processSnapshot(VisionSnapshot snapshot) {
		if (snapshot.isBoilerInView()) {
			double d = snapshot.getBoilerDistance();
			System.err.println("Boiler distance: " + d);
		}
	}
}
