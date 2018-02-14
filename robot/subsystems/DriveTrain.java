/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2785.robot.subsystems;

import org.usfirst.frc.team2785.robot.Robot;
import org.usfirst.frc.team2785.robot.commands.JoystickDrive;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrain extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	SpeedControllerGroup m_left= new SpeedControllerGroup(new Spark(0), new Spark(1));
	SpeedControllerGroup m_right= new SpeedControllerGroup(new Spark(3), new Spark(4));
	public static final double SECONDS = 1;
	public static final double SECONDSTIME = 1;
	public static Timer timer = new Timer();
	
	private DifferentialDrive m_myRobot = new DifferentialDrive(m_left, m_right);
	
	public void initDefaultCommand() {
		setDefaultCommand(new JoystickDrive());
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public void arcadeDrive(double x, double y) {
		m_myRobot.arcadeDrive(y, x);
	}
	
	public void stop() {
		m_myRobot.arcadeDrive(0,0);
	}
	
	public static void driveForward(double seconds)
    {
    	timer.start();
    	while (timer.get()<seconds)
    	{
    		Robot.drivetrain.arcadeDrive(0.8, 0);
    	}
    	timer.stop();
    }
	
	public static void turn(double degree)
	{
		timer.start();
		while (timer.get()<degree)
		{
			Robot.drivetrain.arcadeDrive(0,1);
		}
		timer.stop();
	}
	
}

