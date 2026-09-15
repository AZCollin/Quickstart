package org.firstinspires.ftc.teamcode;

import com.pedropathing.ivy.Command;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.hardware.actuators.NextServo;
import dev.nextftc.robot.Mechanism;

public class Claw implements Mechanism {

    NextServo claw = new NextServo(RobotController.controlHub(), 0);

    public Command open() { return instant(() -> claw.setPosition(0.2)); }
    public Command close() { return instant(() -> claw.setPosition(0.8)); }
}
