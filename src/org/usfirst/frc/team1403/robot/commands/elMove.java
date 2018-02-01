package org.usfirst.frc.team1403.robot.commands;

import org.usfirst.frc.team1403.robot.Robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class elMove extends Command {
	
	int spot;
    public elMove(int spot) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.elevator);
        this.spot = spot;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	boolean direction = true;
    	DigitalInput gate = Robot.elevator.opticMid;
    	
    	switch(spot) {
    	case 4: {
    		direction = true;
    		gate = Robot.elevator.opticMax;
    		break; }
    	case 3: {
    		if (Robot.elevator.opticLow.get() || Robot.elevator.opticMid.get()) {direction = true; }
    		else {direction = false; }
    		gate = Robot.elevator.opticHigh;
    		break; }
    	case 2: {
    		if (Robot.elevator.opticMax.get() || Robot.elevator.opticHigh.get()) {direction = false; }
    		else {direction = true; }
    		gate = Robot.elevator.opticMid;
    		break; }
    	case 1: {
    		direction = false;
    		gate = Robot.elevator.opticLow;
    		break; }
    	}
    	
    	while (!gate.get()) {Robot.elevator.Move(direction); }
    	
    		
    	

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() { }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() { }
}
