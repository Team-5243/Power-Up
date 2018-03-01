/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5243.robot;

import org.usfirst.frc.team5243.robot.commands.auton.commandgroups.DriveToBaseline;
import org.usfirst.frc.team5243.robot.commands.auton.commandgroups.Pos1_ScaleCloser;
import org.usfirst.frc.team5243.robot.commands.auton.commandgroups.Pos1_SwitchCloser;
import org.usfirst.frc.team5243.robot.commands.auton.commandgroups.Pos2_SwitchLeft;
import org.usfirst.frc.team5243.robot.commands.auton.commandgroups.Pos2_SwitchRight;
import org.usfirst.frc.team5243.robot.commands.auton.commandgroups.Pos3_ScaleCloser;
import org.usfirst.frc.team5243.robot.commands.auton.commandgroups.Pos3_SwitchCloser;
import org.usfirst.frc.team5243.robot.subsystems.ClimbSubsystem;
import org.usfirst.frc.team5243.robot.subsystems.CubeSubsystem;
//import org.usfirst.frc.team5243.robot.subsystems.ClimbSubsystem;
//import org.usfirst.frc.team5243.robot.subsystems.CubeSubsystem;
import org.usfirst.frc.team5243.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static OI oi;
	String gameData;

	public static DriveSubsystem driveSubsystem = new DriveSubsystem();
	public static ClimbSubsystem climbSubsystem = new ClimbSubsystem();
	public static CubeSubsystem cubeSubsystem = new CubeSubsystem();
	CommandGroup driveCommand;

	SendableChooser<Command> m_chooser = new SendableChooser<>();

	//Command driveCommand;

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		oi.init();
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", m_chooser);
		SmartDashboard.putNumber("Position", 1);
		CameraServer.getInstance().startAutomaticCapture(0);
		gameData = "R";/*DriverStation.getInstance().getGameSpecificMessage();*/

	}

	/**
	 * This function is called once each time the robot enters Disabled mode. You
	 * can use it to reset any subsystem information you want to clear when the
	 * robot is disabled.
	 */
	@Override
	public void disabledInit() {
		//climbSubsystem.stopActuators();
		//System.out.println(climbSubsystem.getTime(ClimbCommand.start, Timer.getFPGATimestamp()));
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable chooser
	 * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
	 * remove all of the chooser code and uncomment the getString code to get the
	 * auto name from the text box below the Gyro
	 *
	 * <p>
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons to
	 * the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		driveCommand = new Pos1_ScaleCloser();
		driveCommand.start();
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		 * switch(autoSelected) { case "My Auto": autonomousCommand = new
		 * MyAutoCommand(); break; case "Default Auto": default: autonomousCommand = new
		 * ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		int position = (int) SmartDashboard.getNumber("Position", 4);
		switch (position) {
		case 1:
			if(gameData.length() > 0){
				if(gameData.charAt(0) == 'L') {
					driveCommand = new Pos1_SwitchCloser();
					System.out.println("on our side");
					driveCommand.start();
				}
				else if(gameData.charAt(1) == 'L') {
					driveCommand = new Pos1_ScaleCloser();
					System.out.println("scale on our side");
					driveCommand.start();
				}
				else {
					driveCommand = new DriveToBaseline();
					System.out.println("The force is not on our side");
					driveCommand.start();
				}
			}
			else {
				driveCommand = new DriveToBaseline();
				System.out.println("message is not available");
				driveCommand.start();
			}
			break;
			case 2:
				if(gameData.length() > 0){
					if(gameData.charAt(0) == 'L') {
						driveCommand = new Pos2_SwitchLeft();
						driveCommand.start();
					}
					else {
						driveCommand = new Pos2_SwitchRight();
						driveCommand.start();
					}

		        }
				break;
			case 3:
				if(gameData.length() > 0){
					if(gameData.charAt(0) == 'R'){
						driveCommand = new Pos3_SwitchCloser();
						driveCommand.start();
					} 
					else if(gameData.charAt(1) == 'R'){
						driveCommand = new Pos3_ScaleCloser();
						driveCommand.start();
					}
					else {
						driveCommand = new DriveToBaseline();
						driveCommand.start();
						
					}
				break;
				}
				
		}
			

		}

		/**
		 * This function is called periodically during autonomous.
		 */
		@Override
		public void autonomousPeriodic() {
			Scheduler.getInstance().run();
			System.out.println("Encoder Distance: " + driveSubsystem.getDistance()/-70.514);
		}

		@Override
		public void teleopInit() {
			// This makes sure that the autonomous stops running when
			// teleop starts running. If you want the autonomous to
			// continue until interrupted by another command, remove
			// this line or comment it out.
			SmartDashboard.putNumber("Accel", driveSubsystem.getAcceleration());
			//cubeSubsystem.setClosedLoopControl();
		}

		/**
		 * This function is called periodically during operator control.
		 */
		@Override
		public void teleopPeriodic() {
			Scheduler.getInstance().run();
			//System.out.println("right Voltage: "+climbSubsystem.rightPot.getVoltage());
			//System.out.println("leftVoltage: "+climbSubsystem.leftPot.getVoltage());
			System.out.println("Cube Pot: " + cubeSubsystem.getPot().getVoltage());
			cubeSubsystem.setClosedLoopControl();
		}

		/**
		 * This function is called periodically during test mode.
	 `*/
		@Override
		public void testPeriodic() {
		}

	}
