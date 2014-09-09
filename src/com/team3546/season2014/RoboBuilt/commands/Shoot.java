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
import edu.wpi.first.wpilibj.command.Command;
import com.team3546.season2014.RoboBuilt.Robot;
/**
 * Fires the catapult and calls rewind when done
 */
public class  Shoot extends Command {
    //Stores the systems this command uses
    RobotSystemsGroup requiredSystems;
    //Stores the result given by the status manager so we don't undo what we haven't done
    boolean executeCommand;
    public Shoot() {
        //Build a profile to describe the usage of this command
        requiredSystems = new RobotSystemsGroup();
        //This command uses every system
        requiredSystems.armMovementSolenoid.value = StatusManager.uses;
        requiredSystems.pickupArmMotor.value = StatusManager.dependentOn;
        requiredSystems.backboardSolenoid.value = StatusManager.uses;
        requiredSystems.shooterWinchMotor.value = StatusManager.uses;
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }
    // Called just before this Command runs the first time
    protected void initialize() {
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }
    // Called once after isFinished returns true
    protected void end() {
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
