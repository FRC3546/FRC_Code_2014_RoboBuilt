// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package com.team3546.season2014.RoboBuilt.commands;
import com.team3546.season2014.RoboBuilt.RobotSystemsGroup;
import com.team3546.season2014.RoboBuilt.StatusManager;
import com.team3546.season2014.RoboBuilt.subsystems.Shooter;
import edu.wpi.first.wpilibj.command.Command;
import com.team3546.season2014.RoboBuilt.Robot;
/**
 * Manually Unwinds the winch
 */
public class  ManualUnRewind extends Command {
    //Stores the systems this command uses
    RobotSystemsGroup requiredSystems;
    //Stores the result given by the status manager so we don't undo what we haven't done
    boolean executeCommand;
    public ManualUnRewind() {
        //Build a profile to describe the usage of this command
        requiredSystems = new RobotSystemsGroup();
        //This command just needs to use the winch motor
        requiredSystems.shooterWinchMotor.value = StatusManager.uses;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }
    // Called just before this Command runs the first time
    protected void initialize() {
        //Check for any conflicts between other commands
        executeCommand = Robot.statusManager.checkForConflictsAndSetNewStatus(requiredSystems);
        if (executeCommand) {
            //Set the state of the winch motor to unwind
            Robot.shooter.setShooterWinchMotor(Shooter.shooterWinchMotorUnwind);
        }
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (executeCommand) {
            //Feed watchdog
            Robot.shooter.setShooterWinchMotor(Shooter.shooterWinchMotorUnwind);
        }
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !(Robot.oi.manualUnRewindButton.get());
    }
    // Called once after isFinished returns true
    protected void end() {
        if (executeCommand) {
            Robot.shooter.setShooterWinchMotor(Shooter.shooterWinchMotorOff);
            Robot.statusManager.doneWithSystems(requiredSystems);
        }
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
