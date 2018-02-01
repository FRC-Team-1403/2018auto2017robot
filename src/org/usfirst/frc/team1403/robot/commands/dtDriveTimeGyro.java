package org.usfirst.frc.team1403.robot.commands;

import org.usfirst.frc.team1403.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class dtDriveTimeGyro extends Command {

	private double seconds;
	private double speed;
	
    public dtDriveTimeGyro(double seconds, double speed) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrain);
        this.seconds = seconds;
        this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.resetEncoders();
    	Robot.drivetrain.gyro.reset();
    	setTimeout(seconds);
    }

    // Called repeatedly when this Command is scheduled to run
   
    protected void execute() {
    	double gyroPower = Robot.drivetrain.gyro.getAngle()*0.001;
    	Robot.drivetrain.setLeftRightPower(-(speed-gyroPower), -(speed+gyroPower));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}