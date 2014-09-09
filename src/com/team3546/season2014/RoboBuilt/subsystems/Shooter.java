// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package com.team3546.season2014.RoboBuilt.subsystems;
import com.team3546.season2014.RoboBuilt.Robot;
import com.team3546.season2014.RoboBuilt.RobotMap;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 * Contains all of the components of the shooter:
 * Primary and Secondary Shooter Releases
 * Initial and Both final limit switches
 * Winch Motor
 *
 * The motor is initialized to 0
 * The releases are initialized to retracted
 */
public class Shooter extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    DoubleSolenoid shooterReleaseSolenoid = RobotMap.shooterShooterReleaseSolenoid;
    SpeedController shooterWinchMotor = RobotMap.shooterShooterWinchMotor;
    DigitalInput intialShooterLimitSwitch = RobotMap.shooterIntialShooterLimitSwitch;
    DigitalInput finalShooterLimitSwitch1 = RobotMap.shooterFinalShooterLimitSwitch1;
    DigitalInput finalShooterLimitSwitch2 = RobotMap.shooterFinalShooterLimitSwitch2;
    DoubleSolenoid secondaryShooterReleaseSolenoid = RobotMap.shooterSecondaryShooterReleaseSolenoid;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        //Initialize the components to default values
        shooterWinchMotor.set(0);
        secondaryShooterReleaseSolenoid.set(DoubleSolenoid.Value.kReverse);
        shooterReleaseSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
    /**
     * Sets the state of the winch motor, even slows it down on initial switch when winding
     * @param setPoint "Off", "Wind", or "Unwind"
     */
    public void setShooterWinchMotor(String setPoint) {
        if (setPoint.equals("Off")) {
            shooterWinchMotor.set(0);
        } else if (setPoint.equals("Wind")) {
            if (!intialShooterLimitSwitch.get()) {
                shooterWinchMotor.set(-Robot.shooterWinchMotorSpeed);
            } else {
                shooterWinchMotor.set(-Robot.shooterWinchMotorSlowSpeed);
            }
        } else if (setPoint.equals("Unwind")) {
            shooterWinchMotor.set(Robot.shooterWinchMotorSpeed);
        }
    }

    /**
     * Toggles the secondary shooter release
     */
    public void toggleSecondaryShooterRelease() {
        //Gets the current position of the secondary shooter release solenoid and inverts it
        if (secondaryShooterReleaseSolenoid.get() == DoubleSolenoid.Value.kReverse) {
            setSecondaryShooterRelease(DoubleSolenoid.Value.kForward);
        } else {
            setSecondaryShooterRelease(DoubleSolenoid.Value.kReverse);
        }
    }

    /**
     * Toggles the primary shooter release
     */
    public void toggleShooterRelease() {
        //Gets the current position of the secondary shooter release solenoid and inverts it
        if (shooterReleaseSolenoid.get() == DoubleSolenoid.Value.kReverse) {
            setShooterRelease(DoubleSolenoid.Value.kForward);
        } else {
            setShooterRelease(DoubleSolenoid.Value.kReverse);
        }
    }

    /**
     * Sets the primary shooter release
     * @param position Position to set it to
     */
    public void setShooterRelease(DoubleSolenoid.Value position) {
        shooterReleaseSolenoid.set(position);
    }

    /**
     * Sets the secondary shooter release
     * @param position Position to set it to
     */
    public void setSecondaryShooterRelease(DoubleSolenoid.Value position) {
        secondaryShooterReleaseSolenoid.set(position);
    }
}
