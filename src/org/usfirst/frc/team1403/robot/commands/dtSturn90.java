package org.usfirst.frc.team1403.robot.commands;

import org.usfirst.frc.team1403.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class dtSturn90 extends Command {

	boolean direction;
	
    public dtSturn90(boolean direction) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrain);
        this.direction = direction;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.gyro.reset();
    	Robot.drivetrain.resetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (direction) {Robot.drivetrain.setLeftRightPower(0, 0.4); }
    	else {Robot.drivetrain.setLeftRightPower(0.4, 0); }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(Robot.drivetrain.gyro.getAngle()) >= 90;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
