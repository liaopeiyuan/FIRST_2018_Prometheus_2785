package org.usfirst.frc.team2785.robot.commands;



import org.usfirst.frc.team2785.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Climb extends CommandGroup {

	public Climb() {
	        addSequential( new Extend(Lift.KCLIMB));
	        addSequential( new WaitForMe());
	        addSequential(new Extend(Lift.KGROUND));
	  }

		
	}

