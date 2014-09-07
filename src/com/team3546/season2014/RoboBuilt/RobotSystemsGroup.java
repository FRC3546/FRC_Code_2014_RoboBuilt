package com.team3546.season2014.RoboBuilt;


/**
 * Stores information about the systems of the robot
 * Created by Andrew on 9/6/2014.
 */
public class RobotSystemsGroup {
    public RobotSystem armMovementSolenoid = new RobotSystem();
    public RobotSystem pickupArmMotor = new RobotSystem();
    public RobotSystem backboardSolenoid = new RobotSystem();
    public RobotSystem shooterReleaseSolenoid = new RobotSystem();
    public RobotSystem secondaryShooterReleaseSolenoid = new RobotSystem();
    public RobotSystem shooterWinchMotor = new RobotSystem();
    public RobotSystem initialShooterLimitSwitch = new RobotSystem();
    public RobotSystem finalShooterLimitSwitch1 = new RobotSystem();
    public RobotSystem finalShooterLimitSwitch2 = new RobotSystem();

    public RobotSystemsGroup() {
        int[] defaultValues = new int[6];
        for (int i = 0; i < defaultValues.length; i++) {
            defaultValues[i] = StatusManager.notInUse;
        }
        setValues(defaultValues);
    }

    /**
     * Set all of the values based on an array
     * @param values The values to set the stored values to
     */
    protected void setValues(int[] values) {
        armMovementSolenoid.value = values[0];
        pickupArmMotor.value = values [1];
        backboardSolenoid.value = values[2];
        shooterReleaseSolenoid.value = values[3];
        secondaryShooterReleaseSolenoid.value = values[4];
        shooterWinchMotor.value = values[5];
    }

    /**
     * Sets specific value setSystem to setPoint
     * @param setSystem The RobotSystem to set
     * @param setPoint The value to set it to
     */
    public void setSpecificValue(RobotSystem setSystem, int setPoint) {
        setSystem.value = setPoint;
    }

    /**
     * Returns the set of robotSystems values in order as specified in the RobotSystemsGroup class
     * @return set of values in the order specified in RobotSystemsGroup
     */
    public int[] getValues() {
        int[] values = {
                armMovementSolenoid.value,
                pickupArmMotor.value,
                backboardSolenoid.value,
                shooterReleaseSolenoid.value,
                secondaryShooterReleaseSolenoid.value,
                shooterWinchMotor.value,
                initialShooterLimitSwitch.value,
                finalShooterLimitSwitch1.value,
                finalShooterLimitSwitch2.value
        };
        return values;
    }
}
