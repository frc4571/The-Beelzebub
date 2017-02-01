package org.usfirst.frc.team4571.robot.commands.vision;

import java.util.ArrayList;

import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team4571.robot.components.vision.FindGearPegPipeline;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.vision.VisionThread;

public class TestVisionCommand extends Command {

	protected void initialize() {
		UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
		camera.setResolution(320, 240);

		VisionThread visionThread = new VisionThread(camera, new FindGearPegPipeline(), pipeline -> {
			ArrayList<MatOfPoint> keyPoints = pipeline.filterContoursOutput();
			if (keyPoints != null) {
				for (MatOfPoint keyPoint : keyPoints) {
					Rect rect = Imgproc.boundingRect(keyPoint);
					System.err.println("Found rect at (" + rect.x + ", " + rect.y + ") H: " + rect.height + ", W: " + rect.width);
				}
			}
		});
		visionThread.start();		
	}

	protected void execute() {
		UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
		camera.setResolution(320, 240);

		VisionThread visionThread = new VisionThread(camera, new FindGearPegPipeline(), pipeline -> {
			ArrayList<MatOfPoint> keyPoints = pipeline.filterContoursOutput();
			if (keyPoints != null) {
				for (MatOfPoint keyPoint : keyPoints) {
					Rect rect = Imgproc.boundingRect(keyPoint);
					System.err.println("Found rect at (" + rect.x + ", " + rect.y + ") H: " + rect.height + ", W: " + rect.width);
				}
			} else {
				System.err.println("No key points");
			}
			System.err.println("Processed thread loop");
		});
		visionThread.start();		
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {}

}