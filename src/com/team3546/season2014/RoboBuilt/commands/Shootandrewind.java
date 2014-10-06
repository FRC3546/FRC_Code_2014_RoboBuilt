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
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Calls the shoot command followed by the auto rewind command
 */
public class Shootandrewind extends CommandGroup {
    
    public  Shootandrewind() {
        System.out.println("Shooting and rewinding");
        addSequential(new JustShoot());
        System.out.println("rewinding");
//        addSequential(new AutoRewind());
        System.out.println("done");
    }
}
