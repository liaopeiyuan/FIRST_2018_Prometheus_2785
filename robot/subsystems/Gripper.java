package org.usfirst.frc.team2785.robot.subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
/**
 *
 */
public class Gripper extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	TalonSRX talonFirst = new TalonSRX(3);	
	Ultrasonic ultraSensor = new Ultrasonic(1,1);
	public static final double OPENANGLE = 1202;
	public static final double CLOSEANGLE = 662;
	DigitalInput limitSwitch = new DigitalInput(1);
	private DifferentialDrive intakeWheels = new DifferentialDrive(new Spark(5), new Spark(6));
	public static final double INTAKEDIRECTION = 1;
	public static final double STOPDIRECTION = 0;
	public static final double SHOOTDIRECTION = -1;

	
	
	public Gripper() {
		talonFirst.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
    	talonFirst.config_kF(0,0,10);
    	talonFirst.setSensorPhase(true);
    	talonFirst.setInverted(false);
    	talonFirst.configNominalOutputForward(0, 10);
    	talonFirst.configNominalOutputReverse(0, 10);
    	talonFirst.configPeakOutputForward(1,10);
    	talonFirst.configPeakOutputReverse(-1, 10);
    	talonFirst.configAllowableClosedloopError(0, 4, 10);
    	talonFirst.config_kF(0,0.0,10);
    	talonFirst.config_kP(0, 0.3, 10);
    	talonFirst.config_kI(0, 0.0, 10);
    	talonFirst.config_kD(0,0.0,10);
    	talonFirst.setNeutralMode(NeutralMode.Brake);
    	ultraSensor.setAutomaticMode(true);
    	
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public boolean hasCube() { //get data from sensor
    	return ultraSensor.getRangeMM()<20; 
    }
    
    public void initializeGripperPosition() {
    	while(limitSwitch.get()) {
    	talonFirst.set(ControlMode.PercentOutput,1);
    	}
    	talonFirst.set(ControlMode.PercentOutput,0);
    	int absolutePosition = talonFirst.getSensorCollection().getPulseWidthPosition();
    	absolutePosition &= 0xFFF;
    	absolutePosition *= -1;
    	talonFirst.setSelectedSensorPosition(absolutePosition, 0, 10);
    }
    
    public void openGripper() {
    	talonFirst.set(ControlMode.Position, 0);
    }
    
    public void closeGripper() {
    	talonFirst.set(ControlMode.Position, CLOSEANGLE-OPENANGLE);
    	
    }

    public boolean onTarget() {
    	return talonFirst.getClosedLoopError(0)<4; 

    }
    public void setIntakeWheel(double direction) {
    	intakeWheels.arcadeDrive(direction,0);
    }
}

