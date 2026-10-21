package org.firstinspires.ftc.teamcode.nextFTC.Subystems;

import com.pedropathing.ivy.Command;



import dev.nextftc.hardware.RobotController;
import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.robot.Mechanism;

public class Intake implements Mechanism {
    NextMotor intake = new NextMotor(RobotController.expansionHub(), 2);

    public Command go() {return instant(() -> intake.setThrottle(0.9));}
    public Command stop() { return instant(() -> intake.setThrottle(0));}

}
