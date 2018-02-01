package org.usfirst.frc.team1403.robot.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class cgLeftSwitchAuto extends CommandGroup {

    public cgLeftSwitchAuto() {
    	
        addSequential(new dtDriveTimeGyro(3, 0.5));
        addSequential(new dtSturn90(true));
        addSequential(new dtDriveTimeGyro(3, 0.5));
        addSequential(new dtSturn90(false));
        addSequential(new dtDriveTimeGyro(3, 0.5));
        addSequential(new mpManipulate(false, 0.75), 1);
        
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
