package org.firstinspires.ftc.teamcode.nextFTC.Subystems;

import com.pedropathing.ivy.Command;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.hardware.actuators.NextServo;
import dev.nextftc.robot.Mechanism;

public class Flapper implements Mechanism {

    NextServo flapper = new NextServo(RobotController.expansionHub(), 0);

    public Command open() { return instant(() -> flapper.setPosition(0.8)); }
    public Command close() { return instant(() -> flapper.setPosition(0.6)); }
}
