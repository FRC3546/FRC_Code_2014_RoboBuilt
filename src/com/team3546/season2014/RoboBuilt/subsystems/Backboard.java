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
import com.team3546.season2014.RoboBuilt.RobotMap;
import com.team3546.season2014.RoboBuilt.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 * Contains only one doublesolenoid for control of the backboard.
 * Initializes the backboard to retracted
 */
public class Backboard extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    DoubleSolenoid backboardSolenoid = RobotMap.backboardBackboardSolenoid;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        //Sets the default position of the solenoid to retracted
        backboardSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
    /**
     * Toggles the position of the backboard
     */
    public void toggleBackBoard() {
        //Gets the current position of the backboard solenoid and inverts it
        if (backboardSolenoid.get() == DoubleSolenoid.Value.kReverse) {
            backboardSolenoid.set(DoubleSolenoid.Value.kForward);
        } else {
            backboardSolenoid.set(DoubleSolenoid.Value.kReverse);
        }
    }
    /**
     * Set the position of the backboard
     * @param position
     */
    public void setBackboardSolenoid(DoubleSolenoid.Value position) {
        backboardSolenoid.set(position);
    }
}
