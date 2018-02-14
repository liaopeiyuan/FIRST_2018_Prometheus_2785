package org.usfirst.frc.team2785.robot.commands;

import org.usfirst.frc.team2785.robot.subsystems.Lift;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Low extends CommandGroup {

    public Low() {
            addSequential( new Extend(Lift.KLOW));
            addSequential(new Shoot());
            addSequential(new Extend(Lift.KGROUND));
      }

    }

