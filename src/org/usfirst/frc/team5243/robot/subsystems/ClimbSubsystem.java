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
	 * Lifts the climb mechanism through the joysticks. A limit was added so that the cube dart will automatically retract
	 * itself when the arms are near the horizontal position in order to stay within the size limit.
	 */
	public void liftTeleop() {
		//if(!(((getLeftPotVoltage() < 4.15 && getLeftPotVoltage() > 3.15) && (getRightPotVoltage() < 4.15 && getRightPotVoltage() > 3.15)) || ((getLeftPotVoltage() < 1.15 && getLeftPotVoltage() > .2) && (getRightPotVoltage() < 1.15 && getRightPotVoltage() > .2)))) {
		/*if((getLeftPotVoltage() < 3.15 && getLeftPotVoltage() > 1.2) && (getRightPotVoltage() < 3.15 && getRightPotVoltage() > 1.2)) {
			Robot.cubeSubsystem.retractCubeDart();
			System.out.println("Retracting Cube Dart to stay within the size limit");
		}*/
		/*leftClimb.set(.7);
		rightClimb.set(.7);*/
		if(leftPot.getVoltage() < 3.85) {
			leftClimb.set(.7);
		}
		else {
			leftClimb.set(0);
		}
		if(rightPot.getVoltage() < 4.15) {
			rightClimb.set(.8);
		}
		else {
			rightClimb.set(0);
		}
		//System.out.println("Left Voltage: " + leftPot.getVoltage());
		//System.out.println("Right Voltage: " + rightPot.getVoltage());
	}

	/**
	 * Lowers the climb mechanism through the joysticks
	 */
	public void lowerTeleop() {
		//if(!(((getLeftPotVoltage() < 4.15 && getLeftPotVoltage() > 3.15) && (getRightPotVoltage() < 4.15 && getRightPotVoltage() > 3.15)) || ((getLeftPotVoltage() < 1.15 && getLeftPotVoltage() > .15) && (getRightPotVoltage() < 1.15 && getRightPotVoltage() > .15)))) {
		/*if((getLeftPotVoltage() < 3.15 && getLeftPotVoltage() > 1.2) && (getRightPotVoltage() < 3.15 && getRightPotVoltage() > 1.2)) {
			Robot.cubeSubsystem.retractCubeDart();
			System.out.println("Retracting Cube Dart to stay within the size limit");
		}*/
		if(leftPot.getVoltage() > 0.27) {
			leftClimb.set(-.5);
		}
		else {
			leftClimb.set(0);
		}
		if(rightPot.getVoltage() > 0.36) {
			rightClimb.set(-.47);
		}
		else {
			rightClimb.set(0);
		}
		//System.out.println("Left Voltage: " + leftPot.getVoltage());
		//System.out.println("Right Voltage: " + rightPot.getVoltage());
	}

	/**
	 * Lifts the climb mechanism all the way. Used in auton.
	 */
	public void liftAuton(double per) {
		//if(leftPot.getVoltage() > 4.15 && rightPot.getVoltage() > 4.15) 
		per = (4.15*per);
		if (leftPot.getVoltage() < per && rightPot.getVoltage() < per) {
			leftClimb.set(.7);
			rightClimb.set(.8);
		} else {
			stopActuators();
		}
	}

	/**
	 * Lowers the climb mechanism all the way. Used in auton.
	 */
	public void lowerAuton(double percent) {
		percent = 4.15*percent; //pass a percent to lower it to
		if(leftPot.getVoltage() > percent && rightPot.getVoltage() > percent) {
			leftClimb.set(-.5);
			rightClimb.set(-.47);
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