// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package com.team3546.season2014.RoboBuilt;
import com.team3546.season2014.RoboBuilt.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.*;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton pickUpButton;
    public JoystickButton catchButton;
    public JoystickButton downShiftButton;
    public JoystickButton toggleLightsButton;
    public JoystickButton upShiftButton;
    public JoystickButton manualToggleShooterReleaseButton;
    public Joystick joystick1;
    public JoystickButton herdButton;
    public JoystickButton passBallButton;
    public JoystickButton manualPickupArmMotorButton;
    public JoystickButton manualUnRewindButton;
    public JoystickButton manualRewindButton;
    public JoystickButton manualToggleSecondaryShooterReleaseButton;
    public JoystickButton toggleBackboardButton;
    public JoystickButton shootButton;
    public JoystickButton autoRewindButton;
    public Joystick joystick2;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        joystick2 = new Joystick(2);
        
        autoRewindButton = new JoystickButton(joystick2, 11);
        autoRewindButton.whenPressed(new AutoRewind());
        shootButton = new JoystickButton(joystick2, 10);
        shootButton.whenPressed(new JustShoot());
        toggleBackboardButton = new JoystickButton(joystick2, 9);
        toggleBackboardButton.whenPressed(new ToggleBackboard());
        manualToggleSecondaryShooterReleaseButton = new JoystickButton(joystick2, 8);
        manualToggleSecondaryShooterReleaseButton.whenPressed(new ManualToggleSecondaryShooterRelease());
        manualRewindButton = new JoystickButton(joystick2, 7);
        manualRewindButton.whenPressed(new ManualRewind());
        manualUnRewindButton = new JoystickButton(joystick2, 6);
        manualUnRewindButton.whenPressed(new ManualUnRewind());
        manualPickupArmMotorButton = new JoystickButton(joystick2, 5);
        manualPickupArmMotorButton.whenPressed(new ManualPickupArmMotor());
        passBallButton = new JoystickButton(joystick2, 2);
        passBallButton.whenPressed(new Passandrewind());
        herdButton = new JoystickButton(joystick2, 1);
        herdButton.whenPressed(new Herd());
        joystick1 = new Joystick(1);
        
        manualToggleShooterReleaseButton = new JoystickButton(joystick1, 7);
        manualToggleShooterReleaseButton.whenPressed(new ManualToggleShooterRelease());
        upShiftButton = new JoystickButton(joystick1, 5);
        upShiftButton.whenPressed(new ShiftUp());
        toggleLightsButton = new JoystickButton(joystick1, 6);
        toggleLightsButton.whenPressed(new ToggleLights());
        downShiftButton = new JoystickButton(joystick1, 4);
        downShiftButton.whenPressed(new ShiftDown());
        catchButton = new JoystickButton(joystick1, 3);
        catchButton.whenPressed(new Catch());
        pickUpButton = new JoystickButton(joystick1, 1);
        pickUpButton.whenPressed(new Pickup());
	    
        // SmartDashboard Buttons
        SmartDashboard.putData("Joystick Tank Drive", new JoystickTankDrive());
        SmartDashboard.putData("Pickup", new Pickup());
        SmartDashboard.putData("Toggle Backboard", new ToggleBackboard());
        SmartDashboard.putData("Toggle Lights", new ToggleLights());
        SmartDashboard.putData("Just Shoot", new JustShoot());
        SmartDashboard.putData("Catch", new Catch());
        SmartDashboard.putData("Shift Down", new ShiftDown());
        SmartDashboard.putData("Shift Up", new ShiftUp());
        SmartDashboard.putData("Herd", new Herd());
        SmartDashboard.putData("Pass Ball", new PassBall());
        SmartDashboard.putData("Manual UnRewind", new ManualUnRewind());
        SmartDashboard.putData("Manual Rewind", new ManualRewind());
        SmartDashboard.putData("Manual Toggle Secondary Shooter Release", new ManualToggleSecondaryShooterRelease());
        SmartDashboard.putData("Manual Toggle Shooter Release", new ManualToggleShooterRelease());
        SmartDashboard.putData("Manual Pickup Arm Motor", new ManualPickupArmMotor());
        SmartDashboard.putData("Auto Rewind", new AutoRewind());
        SmartDashboard.putData("AutonomousCommand", new AutonomousCommand());
        SmartDashboard.putData("Shoot and rewind", new Shootandrewind());
        SmartDashboard.putData("Pass and rewind", new Passandrewind());
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getJoystick1() {
        return joystick1;
    }
    public Joystick getJoystick2() {
        return joystick2;
    }
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}
