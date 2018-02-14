package org.usfirst.frc.team2785.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class WaitForMe extends Command {

    public WaitForMe() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Timer.delay(5);
    }

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

   
}
