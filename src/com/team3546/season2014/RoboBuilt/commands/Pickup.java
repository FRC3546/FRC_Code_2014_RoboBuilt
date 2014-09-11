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
import com.team3546.season2014.RoboBuilt.subsystems.PickupArm;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import com.team3546.season2014.RoboBuilt.Robot;
/**
 * Extends the pickup arm and turns on the pickup motors
 */
public class  Pickup extends Command {
    //Stores the systems this command uses
    RobotSystemsGroup requiredSystems;
    //Stores the result given by the status manager so we don't undo what we haven't done
    boolean executeCommand;
    public Pickup() {
        //Build a profile to describe the usage of this command
        requiredSystems = new RobotSystemsGroup();
        //This command needs to use the pickup arm
        requiredSystems.armMovementSolenoid.value = StatusManager.uses;
        requiredSystems.pickupArmMotor.value = StatusManager.uses;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }
    // Called just before this Command runs the first time
    protected void initialize() {
        executeCommand = Robot.statusManager.checkForConflictsAndSetNewStatus(requiredSystems);
        if (executeCommand) {
            //Set the position of the arm movement solenoid to extended
            Robot.pickupArm.setArmMovementSolenoid(PickupArm.pickupArmOut);
            //Set the pickup arm motor to in
            Robot.pickupArm.setPickupArmMotor(PickupArm.pickupArmMotorIn);
        }
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
        //Only undo what we've done if we've actually done it
        if (executeCommand) {
            Robot.pickupArm.setArmMovementSolenoid(PickupArm.pickupArmIn);
            Timer.delay(0.5);
            Robot.pickupArm.setPickupArmMotor(PickupArm.pickupArmMotorOff);
            Robot.statusManager.doneWithSystems(requiredSystems);
        }
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
