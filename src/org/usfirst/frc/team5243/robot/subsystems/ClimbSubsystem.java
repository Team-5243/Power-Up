package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;


public class ClimbSubsystem extends Subsystem {


	WPI_TalonSRX leftClimb;
	WPI_TalonSRX rightClimb;
	public AnalogInput leftPot;
	public AnalogInput rightPot;

	/**
	 * The climb subsystem that relates to the climb mechanism.
	 */
	public ClimbSubsystem() {
		leftClimb = new WPI_TalonSRX(RobotMap.leftClimb);
		rightClimb = new WPI_TalonSRX(RobotMap.rightClimb);
		leftClimb.setSafetyEnabled(false);
		rightClimb.setSafetyEnabled(false);
		leftPot = new AnalogInput(RobotMap.leftPotentiometer);
		rightPot = new AnalogInput(RobotMap.rightPotentiometer);
	}

	/**
	 * Lifts the climb mechanism through the joysticks
	 */
	public void lift() {
		if(leftPot.getVoltage() < 4.15 && rightPot.getVoltage() < 4.15) {
			leftClimb.set(.7);
			rightClimb.set(.8);
		}
		else {
			leftClimb.set(0);
			rightClimb.set(0);
		}
		System.out.println("Left Voltage: " + leftPot.getVoltage());
		System.out.println("Right Voltage: " + rightPot.getVoltage());
	}

	/**
	 * Lowers the climb mechanism through the joysticks
	 */
	public void lower() {
		if(leftPot.getVoltage() > 0.15 && rightPot.getVoltage() > 0.15) {
			leftClimb.set(-.5);
			rightClimb.set(-.47);
		}
		else {
			leftClimb.set(0);
			rightClimb.set(0);
		}
		System.out.println("Left Voltage: " + leftPot.getVoltage());
		System.out.println("Right Voltage: " + rightPot.getVoltage());
	}

	/**
	 * Lifts the climb mechanism all the way. Used in auton.
	 */
	public void fullLift(double per) {
		per = (4.15*per);
		if (leftPot.getVoltage() < per && rightPot.getVoltage() < per) {
			leftClimb.set(.7);
			rightClimb.set(.7);
		} else {
			stopActuators();
		}
	}

	/**
	 * Lowers the climb mechanism all the way. Used in auton.
	 */
	public void fullLower(double per) {
		per = 4.15*per;
		if(leftPot.getVoltage() > per && rightPot.getVoltage() > per) {
			leftClimb.set(-.7);
			rightClimb.set(-.7);
		} else {
			stopActuators();
		}
	}
	
	public double getActuatorSpeeds() {
		return leftClimb.get() + rightClimb.get();
	}
	
	public double getLeftPotVoltage() {
		return leftPot.getVoltage();
	}
	
	public double getRightPotVoltage() {
		return rightPot.getVoltage();
	}

	/**
	 * Stops the climb mechanism.
	 */
	public void stopActuators() {
		leftClimb.set(0.0);
		rightClimb.set(0.0);
	}

	protected void initDefaultCommand() {	

	}
	
}