package org.usfirst.frc.team2785.robot.subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lift extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	TalonSRX talonFirst = new TalonSRX(1);
	TalonSRX talonSecond = new TalonSRX(2);
	public static final double KLOW= 11013;
	public static final double KGROUND = 0;
	public static final double KHIGHONE= 25172;
	public static final double KHIGHTWO= 31465;
	public static final double KHIGHTHREE= 37758;
	public static final double KCLIMB= 44050;
			

	public Lift() {
		talonFirst.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
    	talonFirst.config_kF(0,0,10);
    	talonFirst.setSensorPhase(true);
    	talonFirst.setInverted(false);
    	talonFirst.setNeutralMode(NeutralMode.Brake);
    	talonSecond.setNeutralMode(NeutralMode.Brake);
    	talonFirst.configNominalOutputForward(0, 10);
    	talonFirst.configNominalOutputReverse(0, 10);
    	talonFirst.configPeakOutputForward(1,10);
    	talonFirst.configPeakOutputReverse(-1, 10);
    	talonFirst.config_kF(0,0.0,10);
    	talonFirst.config_kP(0, 0.3, 10);
    	talonFirst.config_kI(0, 0.0, 10);
    	talonFirst.config_kD(0,0.0,10);
    	talonFirst.configAllowableClosedloopError(0, 4, 10);

    	
    	int absolutePosition = talonFirst.getSensorCollection().getPulseWidthPosition();
    	absolutePosition &= 0xFFF;
    	absolutePosition *= -1;
    	talonFirst.setSelectedSensorPosition(absolutePosition, 0, 10);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public boolean OnTarget() {
    	return talonFirst.getClosedLoopError(0)<4;

    }
    
    public void extendLift(double height) {
    	double targetPositionRotations = height*80;
    	talonFirst.set(ControlMode.Position, targetPositionRotations);
    	talonSecond.set(ControlMode.Follower,talonFirst.getDeviceID());
    }

}

