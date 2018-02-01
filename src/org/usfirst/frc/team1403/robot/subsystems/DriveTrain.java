package org.usfirst.frc.team1403.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team1403.robot.Robot;
import org.usfirst.frc.team1403.robot.RobotMap;
import org.usfirst.frc.team1403.robot.commands.dtJoyDrive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class DriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	//public TalonSRX motor4;
    //public TalonSRX motor5;
    public TalonSRX motor6;
    //public TalonSRX motor0, motor1;
    public TalonSRX motor2;
    public AnalogGyro gyro;
    
    public DriveTrain() {
    	
    	//motor4 = new TalonSRX(4); //nothing
    	//motor5 = new TalonSRX(5); //hang motor changed to right2 (not working)
    	motor6 = new TalonSRX(6); //left1
    	//motor1 = new TalonSRX(1); //nothing
    	//motor0 = new TalonSRX(0); //left2 (not in use)
    	motor2 = new TalonSRX(2); //right1
    	gyro = new AnalogGyro(0);
	}
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new dtJoyDrive());
    }
    
    public void setLeftRightPower(double leftPower, double rightPower)
    {
    	motor6.set(ControlMode.PercentOutput, leftPower);
    	motor2.set(ControlMode.PercentOutput, -rightPower); 
    }

    public void resetEncoders() {
    	motor6.getSensorCollection().setQuadraturePosition(0, 0);
    	motor2.getSensorCollection().setQuadraturePosition(0, 0);
    }
    
    public void drive() {
    	if(Robot.m_oi.djoy.getRawButton(6)) {
    		motor6.set(ControlMode.PercentOutput, Robot.m_oi.djoy.getRawAxis(1)*0.5);
    		motor2.set(ControlMode.PercentOutput, Robot.m_oi.djoy.getRawAxis(5)*-0.5);
    	}
    	//motor4.set(ControlMode.PercentOutput, Robot.m_oi.stick.getRawAxis(1));
    	else {
    	motor6.set(ControlMode.PercentOutput, Robot.m_oi.djoy.getRawAxis(1));
    	//motor0.set(ControlMode.PercentOutput, Robot.m_oi.stick.getRawAxis(1));
    	//motor1.set(ControlMode.PercentOutput, -Robot.m_oi.stick.getRawAxis(5));
    	motor2.set(ControlMode.PercentOutput, -Robot.m_oi.djoy.getRawAxis(5));
    	//motor5.set(ControlMode.PercentOutput, -Robot.m_oi.stick.getRawAxis(5));
    	}
    }
   
    public double getPosition() {return motor6.getSensorCollection().getQuadraturePosition() * RobotMap.feetPerTick; }

}

