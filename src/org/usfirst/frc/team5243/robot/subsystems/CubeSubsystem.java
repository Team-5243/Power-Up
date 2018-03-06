package org.usfirst.frc.team5243.robot.subsystems;

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
	DoubleSolenoid solenoidCUBE; //clamp piston
	DoubleSolenoid solenoidELEV; //elevator piston
	AnalogInput potentiometer;
	WPI_TalonSRX actuator;
	
	Compressor compressor;

	
	/**
	 * The cube subsystem that relates to the cube mechanism.
	 */
	public CubeSubsystem() {
		solenoidCUBE = new DoubleSolenoid(RobotMap.cubeSolenoidCubeF, RobotMap.cubeSolenoidCubeR);
		solenoidELEV = new DoubleSolenoid(RobotMap.cubeSolenoidElevF, RobotMap.cubeSolenoidElevR);
		actuator = new WPI_TalonSRX(RobotMap.cubeActuator);
		actuator.setSafetyEnabled(false);
		potentiometer = new AnalogInput(RobotMap.cubePotentiometer);
		
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
	
	public AnalogInput getPot() {
		return potentiometer;
		//LIMIT POT VOLTAGE TO .1-4.2 ***VERY IMPORTANT***
	}
	/**
	 * Extends the cube mechanism
	 */
	public void extend() {
		if(potentiometer.getVoltage() < 4.3)  //may need to change .3 to something smaller. Must be bigger than .15
			actuator.set(1);
		else actuator.set(0);
	}

	/**
	 * Retracts the cube mechanism.
	 */
	public void retract() {
		if(potentiometer.getVoltage() > .7) actuator.set(-1);
		else actuator.set(0);
	}
	
	/**
	 * Extends the cube mechanism all the way. Used in auton.
	 */
	public void fullExtend() {
		if (potentiometer.getVoltage() < 4.3) {
			actuator.set(.5);
		}
		else actuator.set(0.0);
	}
	
	/**
	 * Retracts the cube mechanism all the way. Used in auton.
	 */
	public void fullRetract() {
		if (potentiometer.getVoltage() > .7) {
			actuator.set(0.0);
			return;
		}
		actuator.set(-.5);
	}

	/**
	 * Sets the state of the solenoid
	 * @param on Solenoid is on or off depending on whether "on" is true or false
	 */
	public void setSolenoid(Value direction) {
		solenoidCUBE.set(direction);
	}

	/**
	 * Toggles the cube solenoid between the on and off state
	 */
	public void toggleCube() {
		if (solenoidCUBE.get().equals(Value.kReverse) || solenoidCUBE.get().equals(Value.kOff))
			solenoidCUBE.set(Value.kForward);
		else
			solenoidCUBE.set(Value.kReverse);
	}
	
	public void toggleElev() {
		if (solenoidELEV.get().equals(Value.kReverse) || solenoidELEV.get().equals(Value.kOff))
			solenoidELEV.set(Value.kForward);
		else
			solenoidELEV.set(Value.kReverse);
	}
	
	public void setClosedLoopControl() {
		if (compressor != null)
			compressor.setClosedLoopControl(true);
	}
	
	public void disableCompressor() {
		compressor.stop();
	}
	
	public void stop() {
		actuator.set(0);
	}
	public DoubleSolenoid getSolenoidCube() {
		return solenoidCUBE;
	}
	public DoubleSolenoid getSolenoidElev() {
		return solenoidELEV;
	}
}