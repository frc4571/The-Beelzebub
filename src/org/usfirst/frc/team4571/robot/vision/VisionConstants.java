package org.usfirst.frc.team4571.robot.vision;

public interface VisionConstants {
	
	public static final double CAMERA_FOV_X = 320;
	public static final double CAMERA_FOV_Y = 240;
	
	/* Height of camera with respect to the floor */
	public static final double CAMERA_HEIGHT = 29;

	/* Height from the floor to the BOTTOM edge of the TOP tape */
	public static final double BOILER_TOP_TAPE_FLOOR_HEIGHT = 83;
	public static final double BOILER_TOP_TAPE_HEIGHT = 4;
	public static final double BOILER_BOTTOM_TAPE_HEIGHT = 2;
	public static final double BOILER_TAPE_WIDTH = 17.5;
	public static final double TAN_30 = Math.tan(Math.toRadians(30));
	
	public static final double CAMERA_FOCAL_LENGTH = CAMERA_FOV_X / (2 * TAN_30);
	
	public static final long VISION_PROCESSOR_FREQUENCY_MILLIS = 1000;
}
