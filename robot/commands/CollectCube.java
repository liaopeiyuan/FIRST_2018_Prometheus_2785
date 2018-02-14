package org.usfirst.frc.team2785.robot.commands;



import org.usfirst.frc.team2785.robot.subsystems.Gripper;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CollectCube extends CommandGroup {

    public CollectCube() {
       addSequential(new OpenGripper());
       addParallel(new IntakeWheel(Gripper.INTAKEDIRECTION));
       addSequential(new WaitForCube());
       addSequential(new CloseGripper());
    }

   
}
