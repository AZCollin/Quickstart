package org.firstinspires.ftc.teamcode.nextFTC.Subystems;

import com.pedropathing.ivy.Command;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.hardware.actuators.NextServo;
import dev.nextftc.robot.Mechanism;

public class Lift implements Mechanism {

    NextServo Lift = new NextServo(RobotController.controlHub(), 5);

    public Command up() { return instant(() -> Lift.setPosition(0.8)); }
    public Command down() { return instant(() -> Lift.setPosition(0.3)); }
    public Command stop() { return instant(() -> Lift.setPosition(0.5)); }
}
