package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
//import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;


public class CubeSubsystem extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	DoubleSolenoid clampCube; //clamp cube solenoid
	DoubleSolenoid flipCube; //flip cube mech perpendicular
	
	WPI_TalonSRX leftBelt;
	WPI_TalonSRX rightBelt;
	
	public Compressor compressor;

	/**
	 * The cube subsystem that relates to the cube mechanism.
	 */
	public CubeSubsystem() {
		clampCube = new DoubleSolenoid(RobotMap.clampCubeSolF, RobotMap.clampCubeSolR);
		flipCube = new DoubleSolenoid(RobotMap.flipCubeSolF, RobotMap.flipCubeSolR);
		
		leftBelt = new WPI_TalonSRX(RobotMap.leftBelt);
		rightBelt = new WPI_TalonSRX(RobotMap.rightBelt);
		leftBelt.setSafetyEnabled(false);
		rightBelt.setSafetyEnabled(false);
		
		try {
			compressor = new Compressor();
			compressor.start();
			//compressor.setClosedLoopControl(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
		//setDefaultCommand(new CubePSICommand());
	}
	
	/**
	 * Sets the state of the solenoid
	 * @param on Solenoid is on or off depending on whether "on" is true or false
	 */
	public void intakeCube() {
		leftBelt.set(-1);
		rightBelt.set(-1);
	}
	
	public void releaseCube() {
		leftBelt.set(1);
		rightBelt.set(1);
	}
	
	public void stopBelts() {
		leftBelt.set(0);
		rightBelt.set(0);
	}
	
	public void toggleCubeBelts(double speed) {
		leftBelt.set(speed);
		rightBelt.set(speed);
	}
	
	public void setClampCubeSol(Value direction) {
		clampCube.set(direction);
	}
	
	public void setFlipCubeSol(Value direction) {
		flipCube.set(direction);
	}

	/**
	 * Toggles the cube solenoid between the on and off state
	 */
	public void toggleClampCubeSol() {
		if (clampCube.get().equals(Value.kReverse) || clampCube.get().equals(Value.kOff)) {
			clampCube.set(Value.kForward);
			System.out.println("Clamp Cube: Forward"); //**Release**
		} else {
			clampCube.set(Value.kReverse);
			System.out.println("Clamp Cube: Reverse"); //**Close**
		}
	}
	
	public void toggleFlipCubeSol() {
		if (flipCube.get().equals(Value.kReverse) || flipCube.get().equals(Value.kOff)) {
			flipCube.set(Value.kForward);
			System.out.println("Flip Cube: Forward"); //**Up** 
		} else {
			flipCube.set(Value.kReverse);
			System.out.println("Flip Cube: Reverse"); //**Down**
		}
	}
	
	public DoubleSolenoid getClampCubeSol() {
		return clampCube;
	}
	
	public DoubleSolenoid getFlipCubeSol() {
		return flipCube;
	}
	
	public void setClosedLoopControl(boolean on) {
		if (compressor != null)
			compressor.setClosedLoopControl(on);
	}
	
	public void disableCompressor() {
		compressor.stop();
	}
	
	public boolean compressorEnabled() {
		return compressor.enabled();
	}
	
}