package org.usfirst.frc.team2785.robot.commands;

import org.usfirst.frc.team2785.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Extend extends Command {
	private double height;
    public Extend(double height) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.lift);
    	this.height=height;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	Robot.lift.extendLift(height);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }


}
