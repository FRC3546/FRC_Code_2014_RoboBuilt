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
 * Unwinds the catapult while running the intake motors outward
 */
public class  PassBall extends Command {
    //Stores the systems this command uses
    RobotSystemsGroup requiredSystems;
    //Stores the result given by the status manager so we don't undo what we haven't done
    boolean executeCommand;
    //Stores the time the command was initiated
    double initialTime;
    public PassBall() {
        //Build a profile to describe the usage of this command
        requiredSystems = new RobotSystemsGroup();
        //This command uses every system
        requiredSystems.armMovementSolenoid.value = StatusManager.dependentOn;
        requiredSystems.pickupArmMotor.value = StatusManager.uses;
        requiredSystems.backboardSolenoid.value = StatusManager.dependentOn;
        requiredSystems.shooterReleaseSolenoid.value = StatusManager.uses;
        requiredSystems.secondaryShooterReleaseSolenoid.value = StatusManager.uses;
        requiredSystems.shooterWinchMotor.value = StatusManager.uses;
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }
    // Called just before this Command runs the first time
    protected void initialize() {
        executeCommand = Robot.statusManager.checkForConflictsAndSetNewStatus(requiredSystems);
        if (executeCommand && Robot.shooter.eitherFinalSwitchPressed()) {
            Robot.shooter.setShooterRelease(Shooter.shooterReleaseEngaged);
            Robot.shooter.setSecondaryShooterRelease(Shooter.secondaryShooterReleaseDisengaged);
            Robot.pickupArm.setPickupArmMotor(PickupArm.pickupArmMotorOut);
            Robot.shooter.setShooterWinchMotor(Shooter.shooterWinchMotorUnwind);
            initialTime = Timer.getFPGATimestamp();
        }
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //Update the values so the watchdog doesn't attack
        Robot.shooter.setShooterWinchMotor(Shooter.shooterWinchMotorUnwind);
        Robot.pickupArm.setPickupArmMotor(PickupArm.pickupArmMotorOut);
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//        System.out.println("Checking for finish..." + Timer.getFPGATimestamp());
        //Only stop if the motors have been running for 2.5 seconds already
        return Timer.getFPGATimestamp() - initialTime > 2.5 && !(Robot.oi.passBallButton.get());
    }
    // Called once after isFinished returns true
    protected void end() {
        System.out.println("Finished!");
        if (executeCommand) {
            Robot.shooter.setShooterWinchMotor(Shooter.shooterWinchMotorOff);
            Robot.pickupArm.setPickupArmMotor(PickupArm.pickupArmMotorOff);
            Robot.shooter.setSecondaryShooterRelease(Shooter.secondaryShooterReleaseEngaged);
            Robot.statusManager.doneWithSystems(requiredSystems);
        }
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
