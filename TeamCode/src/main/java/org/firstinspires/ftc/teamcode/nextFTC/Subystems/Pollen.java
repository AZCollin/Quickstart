package org.firstinspires.ftc.teamcode.nextFTC.Subystems;

import com.pedropathing.ivy.Command;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.hardware.actuators.NextServo;
import dev.nextftc.robot.Mechanism;

public class Pollen implements Mechanism {

    NextServo Pollen = new NextServo(RobotController.controlHub(), 1);

    public Command open() { return instant(() -> Pollen.setPosition(0.15)); }
    public Command close() { return instant(() -> Pollen.setPosition(0.7)); }
}
