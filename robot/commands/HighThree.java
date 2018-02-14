package org.usfirst.frc.team2785.robot.commands;

import org.usfirst.frc.team2785.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class HighThree extends CommandGroup {

    public HighThree() {
            addSequential(new Extend(Lift.KHIGHTHREE));
            addSequential(new Shoot());
            addSequential(new Extend(Lift.KGROUND));
          }
      }


