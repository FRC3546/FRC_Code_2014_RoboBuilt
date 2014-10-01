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
import com.team3546.season2014.RoboBuilt.subsystems.Shooter;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import com.team3546.season2014.RoboBuilt.Robot;
/**
 * Rewinds an away catapult until it is rewound
 */
public class  AutoRewind extends Command {
    //Stores the systems this command uses
    RobotSystemsGroup requiredSystems;
    //Stores the result given by the status manager so we don't undo what we haven't done
    boolean executeCommand;
    //Stores whether this command has retracted the arm yet
    private boolean retractedArmYet = false;
    //Stores the time the command was initiated
    double initialTime;
    public AutoRewind() {
        //Build a profile to describe the usage of this command
        requiredSystems = new RobotSystemsGroup();
        //This command uses almost every system
        requiredSystems.armMovementSolenoid.value = StatusManager.uses;
        requiredSystems.backboardSolenoid.value = StatusManager.dependentOn;
        requiredSystems.shooterWinchMotor.value = StatusManager.uses;
        requiredSystems.secondaryShooterReleaseSolenoid.value = StatusManager.uses;
        requiredSystems.shooterReleaseSolenoid.value = StatusManager.uses;
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }
    // Called just before this Command runs the first time
    protected void initialize() {
        executeCommand = Robot.statusManager.checkForConflictsAndSetNewStatus(requiredSystems);
        if (executeCommand) {
            Robot.shooter.setShooterRelease(Shooter.shooterReleaseEngaged);
            Robot.shooter.setSecondaryShooterRelease(Shooter.secondaryShooterReleaseEngaged);
            Robot.shooter.setShooterWinchMotor(Shooter.shooterWinchMotorWind);
            initialTime = Timer.getFPGATimestamp();
        }
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (executeCommand) {
            Robot.shooter.setShooterWinchMotor(Shooter.shooterWinchMotorWind);
            if (!retractedArmYet) {
                //This is so that the pickup arm, which was extended in shoot can be retracted
                //The delay is so it doesn't hit the catapult
                //^^ Thanks self, love ya
                if (Timer.getFPGATimestamp() - initialTime > 1.5){
                    Robot.pickupArm.setArmMovementSolenoid(PickupArm.pickupArmIn);
                    retractedArmYet = true;
                }
            }
        }
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.shooter.eitherFinalSwitchPressed();
    }
    // Called once after isFinished returns true
    protected void end() {
        if (executeCommand) {
            if (!retractedArmYet) {
                //If the arm wasn't retracted yet, do so
                Robot.pickupArm.setArmMovementSolenoid(PickupArm.pickupArmIn);
                retractedArmYet = true;
            }
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
