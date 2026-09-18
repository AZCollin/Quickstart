package org.firstinspires.ftc.teamcode.nextFTC.Subystems;

import com.pedropathing.ivy.Command;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.robot.Mechanism;

public class Launcher implements Mechanism {

    NextMotor launcher = new NextMotor(RobotController.expansionHub(), 1);

    public Command go() {return instant(() -> launcher.setThrottle(-0.5));
    }
    public Command stop() {
        return instant(() -> launcher.setThrottle(0));
    }
}
