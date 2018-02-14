/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2785.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2785.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class OpenGripper extends Command {
	public OpenGripper() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.gripper);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.gripper.openGripper();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return Robot.gripper.onTarget();
	}

}
