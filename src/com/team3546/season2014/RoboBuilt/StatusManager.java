package com.team3546.season2014.RoboBuilt;

/**
 * Created by Andrew on 9/6/2014.
 * Manages the state of the robot so that commands can run without conflict
 */
public class StatusManager {

    //Global constants to describe the requirements of a command
    public final static int independentOf = 0;
    public final static int uses = 1;
    public final static int dependentOn = 2;

    //Global constants to describe the use of RobotSystems
    public final static int notInUse = 0;
    public final static int inUse = 1;

    private RobotSystemsGroup robotStatus;
    public StatusManager() {
        //No argument in the constructor initializes the data to notInUse
        robotStatus = new RobotSystemsGroup();
    }

    /**
     * Checks for conflicts between the specified needs and the current status of the robot.
     * If the robot is not using the required systems, the function automatically allocates them for use
     * @param needs Specifies the required systems
     * @return Whether or not to proceed with the command
     */
    public boolean checkForConflictsAndSetNewStatus(RobotSystemsGroup needs) {
        int[] currentRobotStatus =  robotStatus.getValues();
        for (int i  = 0; i < needs.getValues().length; i++) {
            if (currentRobotStatus[i] != notInUse && needs.getValues()[i] != independentOf)  {
                if (currentRobotStatus[i] == inUse || needs.getValues()[i] == uses) {
                    return false;
                }
            }
        }

        int[] newRobotStatus =  robotStatus.getValues();
        for (int i = 0; i < needs.getValues().length; i++) {
            newRobotStatus[i] += needs.getValues()[i];
        }
        robotStatus.setValues(newRobotStatus);

        return true;
    }

    /**
     * Release the specified RobotSystems to the rest of the robot
     * @param systems Specifies which systems to release
     */
    public void doneWithSystems(RobotSystemsGroup systems) {
        int[] newRobotStatus =  robotStatus.getValues();
        for (int i = 0; i < systems.getValues().length; i++) {
            newRobotStatus[i] -= systems.getValues()[i];
        }
        robotStatus.setValues(newRobotStatus);
    }
}
