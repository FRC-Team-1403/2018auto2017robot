package org.usfirst.frc.team1403.robot.commands;

import org.usfirst.frc.team1403.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class dtDriveStraightGyro extends Command {
	
	public double distance;
	public double speed;
    
	public dtDriveStraightGyro(double distance, double speed) {
    	 // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrain);
        this.distance = distance;
        this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.resetEncoders();
    	Robot.drivetrain.gyro.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double gyroPower = Robot.drivetrain.gyro.getAngle()*0.01;
    	
    	if(distance>0.0) {Robot.drivetrain.setLeftRightPower(-(speed-gyroPower), -(speed+gyroPower)); }
    	else {Robot.drivetrain.setLeftRightPower((speed+gyroPower), (speed-gyroPower)); }
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    
    	return Math.abs(Robot.drivetrain.getPosition()) >= Math.abs(distance);
    
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.setLeftRightPower(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drivetrain.setLeftRightPower(0, 0);
    }
}

