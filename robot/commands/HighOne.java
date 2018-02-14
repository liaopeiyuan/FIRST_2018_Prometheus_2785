package org.usfirst.frc.team2785.robot.commands;

import org.usfirst.frc.team2785.robot.subsystems.Lift;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class HighOne extends CommandGroup {

    public HighOne() {
      addSequential( new Extend(Lift.KHIGHONE));
      addSequential(new Shoot());
      addSequential(new Extend(Lift.KGROUND));
    }
}
