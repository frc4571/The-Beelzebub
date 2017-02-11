package org.usfirst.frc.team4571.robot.vision;

import java.util.ArrayList;

import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team4571.robot.components.vision.FindGearPegPipeline;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoCamera.WhiteBalance;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.vision.VisionThread;

public class VisionSnapshotRecorder {
	
	private VisionThread visionThread;
	private VisionSnapshotQueue snapshots;
	
	private static VisionSnapshotRecorder instance;
	
	public static boolean LOGGING = true; 
	
	public static void start() {		
		if (instance != null) {
			throw new RuntimeException("VisionSnapshotRecorder already running");
		}
		instance = new VisionSnapshotRecorder();
		System.err.println("Starting vision processing");
		instance.visionThread.start();
	}
	
	public static VisionSnapshotRecorder get() {
		return instance;
	}
	
	public VisionSnapshot getSnapshot() {
		return this.snapshots.getCurrent();
	}
	
	private VisionSnapshotRecorder() {
		snapshots = new VisionSnapshotQueue();
		UsbCamera camera = new UsbCamera("cam0", 0);
		// UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
		camera.setResolution(320, 240);
		camera.setBrightness(5);
		camera.setExposureManual(5);
		camera.setWhiteBalanceManual(WhiteBalance.kFixedIndoor);
		CameraServer.getInstance().startAutomaticCapture(camera);
				
		visionThread = new VisionThread(camera, new FindGearPegPipeline(), pipeline -> {
			try {
				ArrayList<MatOfPoint> keyPoints = pipeline.findContoursOutput();
				if (LOGGING) {
					if (pipeline.findContoursOutput().size() > 0) {
						System.err.println("Found " + pipeline.findContoursOutput().size() + " contours");
					}
					if (pipeline.filterContoursOutput().size() > 0) {
						System.err.println("Filtered " + pipeline.filterContoursOutput().size() + " contours");
					}
				}
				ArrayList<Rect> rects = new ArrayList<>();
				for (MatOfPoint keyPoint : keyPoints) {
					Rect rect = Imgproc.boundingRect(keyPoint);
					rects.add(rect);
				}
				snapshots.push(new VisionSnapshot(rects));
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		});
	}
}
