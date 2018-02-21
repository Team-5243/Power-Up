package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.RobotMap;
import org.usfirst.frc.team5243.robot.commands.TankDrive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveSubsystem extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	// SpeedController frontLeft;
	// SpeedController frontRight;
	// SpeedController backLeft;
	// SpeedController backRight;
	Encoder encoder;

	WPI_TalonSRX frontLeft;
	WPI_TalonSRX frontRight;
	// WPI_TalonSRX backLeft;
	// WPI_TalonSRX backRight;

	SpeedControllerGroup left;
	SpeedControllerGroup right;

	DifferentialDrive drive;

	AHRS gyro;
	
	private double previousLeftVelocity, previousRightVelocity;

	/**
	 * The drive subsystem that relates to the drive train
	 */
	public DriveSubsystem() {
		/*
		 * frontLeft = new TalonSRX(RobotMap.frontLeft); frontRight = new
		 * TalonSRX(RobotMap.frontRight); backLeft = new TalonSRX(RobotMap.backLeft);
		 * backRight = (SpeedController)new TalonSRX(RobotMap.backRight);
		 */
		frontLeft = new WPI_TalonSRX(RobotMap.frontLeft);
		frontRight = new WPI_TalonSRX(RobotMap.frontRight);
		// backLeft = new WPI_TalonSRX(RobotMap.backLeft);
		// backRight = new WPI_TalonSRX(RobotMap.backRight);
		frontLeft.setSafetyEnabled(false);
		frontRight.setSafetyEnabled(false);
		// backLeft.setSafetyEnabled(false);
		// backRight.setSafetyEnabled(false);

		left = new SpeedControllerGroup(frontLeft/* backLeft */);
		right = new SpeedControllerGroup(frontRight/* , backRight */);
		encoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
		encoder.setDistancePerPulse(5);

		drive = new DifferentialDrive(left, right);

		gyro = new AHRS(SPI.Port.kMXP);
		gyro.reset();
		gyro.zeroYaw();
		drive.setSafetyEnabled(false);
		
		previousLeftVelocity = 0;
		previousRightVelocity = 0;
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new TankDrive());
	}

	/**
	 * Tank drive
	 */
	public void tankDrive() {
		//double currentLeftVelocity = -Robot.oi.getLeftStick().getY();
		//double currentRightVelocity = -Robot.oi.getRightStick().getY();
		
		//double acceleration = Math.sqrt(Math.pow(gyro.getRawAccelX(), 2) + Math.pow(gyro.getRawAccelY(), 2));
		
		drive.tankDrive(-Robot.oi.getLeftStick().getY(), -Robot.oi.getRightStick().getY());
		//drive.tankDrive(currentLeftVelocity - (acceleration > 0.1 ? 0.1 : acceleration), 
		//currentRightVelocity - (acceleration > 0.1 ? 0.1 : acceleration));
		
		//previousLeftVelocity = currentLeftVelocity - (acceleration > 0.1 ? 0.1 : acceleration);
		//previousRightVelocity = currentRightVelocity - (acceleration > 0.1 ? 0.1 : acceleration);
	}

	/**
	 * Gee I wonder
	 */
	public void stopMotors() {
		left.set(0.0);
		right.set(0.0);
	}
	
	/**
	 * Every 1 and a half inches decrements the speed by .1
	 */
	public void softStop() {
		double motorSpeed = .8;
		double mult = -100;
		while(motorSpeed > 0) {
			while (encoder.getDistance() / mult <= 1.5) {
				left.set(motorSpeed);
				right.set(motorSpeed);
				Timer.delay(.005);
				motorSpeed-=.1;
			}
		}
	}

	/**
	 * Sets the yaw of the gyro to 0
	 */
	public void zeroYaw() {
		gyro.zeroYaw();
	}

	/**
	 * 
	 * @return some count of the encoder - no idea
	 */
	public double encoderCount() {
		return encoder.get();

	}

	/**
	 * 
	 * @return the supposed distance the encoder has gone - no idea
	 */
	public double getDistance() {
		return encoder.getDistance();
	}

	/**
	 * Resets the encoder to its default state
	 */
	public void resetEncoder() {
		encoder.reset();
	}

	/**
	 * 
	 * @return the acceleration of the gyro
	 */
	public double getAcceleration() {
		return gyro.getRawAccelX();
	}

	/**
	 * Drives the robot in a self-correcting manner
	 */
	public void driveStraight(double distance) {
		double lastYaw = gyro.getYaw();
		double mult = -80;
		//double startEncoderPos = encoder.getDistance();
		encoder.reset();
		while (encoder.getDistance() / mult <= distance) {
			System.out.println(encoder.getDistance()+" "+encoder.getDistance()/mult+" "+distance);
			drive.tankDrive(.6, .6);
			Timer.delay(.01);
			double curYaw = gyro.getYaw();
			autoCorrect(curYaw - lastYaw);
			lastYaw = curYaw;
		}
		//softStop();
		stopMotors();
	}

	/**
	 * Drives forward until the distance is reached
	 * 
	 * @param distance
	 *            the distance the robot is supposed to drive forward in meters
	 */

	/**
	 * Turns the robot a number of degrees
	 * 
	 * @param degrees
	 *            the degrees the robot should turn
	 */
	public void rotateLeft(double degrees) {
		if (gyro.getYaw() < degrees) {
			stopMotors();
		} else {
			right.set(-0.5);
			left.set(-0.5);
		}
	}

	/**
	 * Turns the robot a number of degrees
	 * 
	 * @param degrees
	 * the degrees the robot should turn
	 */
	public void rotateRight(double degrees) {
		if (gyro.getYaw() > degrees) {
			stopMotors();
		} else {
			right.set(0.5);
			left.set(0.5);
		}
	}

	/**
	 * 
	 * @return whether the robot's drive train is completely still
	 */
	public boolean isStopped() {
		return left.get() == 0.0 && right.get() == 0.0;
	}

	public void autoCorrect(double degrees) {
		/*double degOfFreedom = 4;
		int sign = 1;
		if (degrees < 0) {
			sign = -1;
			degrees += 10;
		} else {
			degrees -= 5;
		}
		gyro.zeroYaw();
		System.out.println(gyrso.getYaw());
		double lowerBound = degrees - degOfFreedom;
		double upperBound = degrees + degOfFreedom;
		while (true) {
			System.out.println(gyro.getYaw());
			drive.tankDrive(sign * .5, sign * -.5);
			Timer.delay(.01);
			if (gyro.getYaw() >= lowerBound && gyro.getYaw() <= upperBound) {
				break;
			}
		}
		stopMotors();*/
		if (degrees < 0) rotateRight(degrees); 
		else rotateLeft(-degrees);
		
	}

}
