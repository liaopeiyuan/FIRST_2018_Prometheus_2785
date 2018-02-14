package org.usfirst.frc.team2785.robot.commands;

import org.usfirst.frc.team2785.robot.Robot;
import org.usfirst.frc.team2785.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

*/
public class TurnLeft extends Command {

	private double degree;
   public TurnLeft(double degree) {
       // Use requires() here to declare subsystem dependencies
       // eg. requires(chassis);
   	requires(Robot.drivetrain);
   	this.degree = degree;
   }

   public TurnLeft() {
       // Use requires() here to declare subsystem dependencies
       // eg. requires(chassis);
   	requires(Robot.drivetrain);
   	this.degree = 1;
   }
   
   // Called just before this Command runs the first time
   protected void initialize() {
   	
   	Robot.drivetrain.turnLeft(degree);
   	
   	
   }
   

   // Called repeatedly when this Command is scheduled to run
   protected void execute() {
   }

   // Make this return true when this Command no longer needs to run execute()
   protected boolean isFinished() {
       return DriveTrain.timer.get()>=degree;

   }

   // Called once after isFinished returns true
   protected void end() {
   }

   // Called when another command which requires one or more of the same
   // subsystems is scheduled to run
   protected void interrupted() {
   }
   
   
   
}
