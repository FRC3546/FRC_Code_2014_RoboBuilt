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
import com.team3546.season2014.RoboBuilt.subsystems.Backboard;
import com.team3546.season2014.RoboBuilt.subsystems.PickupArm;
import com.team3546.season2014.RoboBuilt.subsystems.Shooter;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import com.team3546.season2014.RoboBuilt.Robot;
/**
 * Fires the catapult
 */
public class  JustShoot extends Command {
    //Stores the systems this command uses
    RobotSystemsGroup requiredSystems;
    //Stores the result given by the status manager so we don't undo what we haven't done
    boolean executeCommand;
    public JustShoot() {
        //Build a profile to describe the usage of this command
        requiredSystems = new RobotSystemsGroup();
        //This command uses every system
        requiredSystems.armMovementSolenoid.value = StatusManager.uses;
        requiredSystems.pickupArmMotor.value = StatusManager.dependentOn;
        requiredSystems.backboardSolenoid.value = StatusManager.uses;
        requiredSystems.shooterWinchMotor.value = StatusManager.uses;
        requiredSystems.secondaryShooterReleaseSolenoid.value = StatusManager.uses;
        requiredSystems.shooterReleaseSolenoid.value = StatusManager.uses;
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }
    // Called just before this Command runs the first time
    protected void initialize() {
        executeCommand = Robot.statusManager.checkForConflictsAndSetNewStatus(requiredSystems);
        //Only run this command if one of the limit switches is pressed
        if (executeCommand && Robot.shooter.eitherFinalSwitchPressed()) {
            //Loosen the cable
            Robot.shooter.setShooterRelease(Shooter.shooterReleaseEngaged);
            Robot.shooter.setShooterWinchMotor(Shooter.shooterWinchMotorUnwind);
            Timer.delay(1);
            Robot.shooter.setShooterWinchMotor(Shooter.shooterWinchMotorOff);
            Robot.shooter.setShooterRelease(Shooter.shooterReleaseDisengaged);
            //Setup backboard and put arms down
            Robot.backboard.setBackboardSolenoid(Backboard.backBoardOut);
            Robot.pickupArm.setArmMovementSolenoid(PickupArm.pickupArmOut);
            Timer.delay(0.5);
            //FIRE!
            Robot.shooter.setSecondaryShooterRelease(Shooter.secondaryShooterReleaseDisengaged);
            Timer.delay(2);
        }
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }
    // Called once after isFinished returns true
    protected void end() {
        if (executeCommand) {
            //Reset latch and re-engage dog gear
            Robot.shooter.setSecondaryShooterRelease(Shooter.secondaryShooterReleaseEngaged);
            Robot.shooter.setShooterRelease(Shooter.shooterReleaseEngaged);
            Timer.delay(0.5);
            //At this point, the arms have to stay extended so that they don't hit the currently released catapult
            //They will be retracted by the auto-rewind
            Robot.statusManager.doneWithSystems(requiredSystems);
        }
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
