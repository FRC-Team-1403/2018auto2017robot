package org.usfirst.frc.team1403.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {

    public DigitalInput opticHigh;
    public DigitalInput opticMax;
    public DigitalInput opticMid;
    public DigitalInput opticLow;
    public TalonSRX elMotor;

    
    public Elevator() {
    	opticHigh = new DigitalInput(0);
    	opticMid = new DigitalInput(1);
    	opticLow = new DigitalInput(2);
    	opticMax = new DigitalInput(3);
    	elMotor = new TalonSRX(8);
    }

    public void Move(boolean direction) {
    	if (direction) {elMotor.set(ControlMode.PercentOutput, 0.5);}
    	else {elMotor.set(ControlMode.PercentOutput, -0.5); }
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

