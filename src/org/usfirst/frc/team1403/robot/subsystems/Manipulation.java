package org.usfirst.frc.team1403.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Manipulation extends Subsystem {

    public TalonSRX inMotor1;
    public TalonSRX inMotor2;

	public Manipulation() {
		inMotor1 = new TalonSRX(0);
		inMotor2 = new TalonSRX(1);
	}
	
	public void Intake(double x) {
		inMotor1.set(ControlMode.PercentOutput, x);
		inMotor2.set(ControlMode.PercentOutput, -x);
	}
	public void Eject(double y) {
		inMotor1.set(ControlMode.PercentOutput, -y);
		inMotor2.set(ControlMode.PercentOutput, y);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

