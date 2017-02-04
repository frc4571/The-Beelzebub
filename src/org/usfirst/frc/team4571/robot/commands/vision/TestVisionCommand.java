package org.usfirst.frc.team4571.robot.commands.vision;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;
import org.usfirst.frc.team4571.robot.components.vision.FindGearPegPipeline;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoCamera.WhiteBalance;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.vision.VisionThread;

public class TestVisionCommand extends Command {

	protected void initialize() {
		try {
			Process p = Runtime.getRuntime().exec("v4l2-ctl -l");
			// Process p = Runtime.getRuntime().exec("v4l2-ctl -c exposure_absolute=5");
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = null;
			while ((line = input.readLine()) != null) {
				System.err.println(line);
			}
			input.close();
		} catch (Exception e) {
			System.err.println(e);
		}
		VideoCapture vc;
		UsbCamera camera = new UsbCamera("cam0", 0);
		// UsbCamera camera = CameraServer.getInstance();
		camera.setResolution(320, 240);
		camera.setBrightness(30);
		camera.setExposureManual(20);
		camera.setWhiteBalanceManual(WhiteBalance.kFixedIndoor);
		CameraServer.getInstance().startAutomaticCapture(camera);

		VisionThread visionThread = new VisionThread(camera, new FindGearPegPipeline(), pipeline -> {
			ArrayList<MatOfPoint> keyPoints = pipeline.filterContoursOutput();
			if (keyPoints != null) {
				for (MatOfPoint keyPoint : keyPoints) {
					Rect rect = Imgproc.boundingRect(keyPoint);
					System.err.println(
							"Found rect at (" + rect.x + ", " + rect.y + ") H: " + rect.height + ", W: " + rect.width);
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
					System.err.println(
							"Found rect at (" + rect.x + ", " + rect.y + ") H: " + rect.height + ", W: " + rect.width);
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

	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}

}