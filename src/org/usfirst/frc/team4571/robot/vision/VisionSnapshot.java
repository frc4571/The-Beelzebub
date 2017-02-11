package org.usfirst.frc.team4571.robot.vision;

import java.util.ArrayList;

import org.opencv.core.Rect;

public class VisionSnapshot implements VisionConstants {
	private final long timestamp;
	private final ArrayList<Rect> detectedRectangles;
	
	public VisionSnapshot(ArrayList<Rect> rectangles) {
		this.timestamp = System.currentTimeMillis();
		this.detectedRectangles = rectangles;
	}
	
	public long getTimestamp() {
		return this.timestamp;
	}
	
	/**
	 * Checks to see if there are two rectangles, one thick on top of one thin one
	 * Thick one should be approximately 2x the height of the thin one
	 * We will use 1.5x as threshold
	 * @return
	 */
	public boolean isBoilerInView() {
		System.err.println("Running isBoilerInView");
		System.err.println(detectedRectangles.size());
		if (detectedRectangles.size() == 2) {
			Rect r1 = detectedRectangles.get(0);
			Rect r2 = detectedRectangles.get(1);
			System.err.println(r1);
			System.err.println(r2);
			return (r2.y > r1.y && r1.height >= r2.height * 1.5 && r1.height < r2.height * 2.5) ||
				   (r1.y > r2.y && r2.height >= r1.height * 1.5 && r2.height < r2.height * 2.5);	
		}
		return false;
	}
	
	/**
	 * Do not call this unless isBoilerInView returns true!
	 * Don't want to make additional checks here
	 * @return
	 */
	public double getBoilerDistance() {
		Rect rect1 = detectedRectangles.get(0);
		// Calc distance based on width and height
		double d1 = (BOILER_TAPE_WIDTH * CAMERA_FOV_X) / (2 * rect1.width * TAN_30);
		System.err.println("D1: " + d1);
		// We know the height
		double l1 = Math.sqrt(Math.pow(d1, 2) - Math.pow(BOILER_TOP_TAPE_FLOOR_HEIGHT - CAMERA_HEIGHT, 2));
		System.err.println("L1: " + l1);
		return l1;
	}
	
	public double getAngle() {
		/*
		double d = (17.5 * 320) / (2 * rect.width * 0.557);
		System.err.println("Found rect at (" + rect.x + ", " + rect.y + ") H: " + rect.height + ", W: " + rect.width);
		System.err.println("Distance: " + Math.round(d) + " inches");
		double dy = Math.atan((rect.y - 120) / f);
		System.err.println("DY: " + dy * r);
		*/
		return 0;

	}
}
