package org.firstinspires.ftc.teamcode.nextFTC.Subystems;

import com.pedropathing.ivy.Command;



import dev.nextftc.hardware.RobotController;
import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.robot.Mechanism;

public class Motor implements Mechanism {
    NextMotor Motor = new NextMotor(RobotController.expansionHub(), 0);

    public Command go() {return instant(() -> Motor.setThrottle(0.9));}
    public Command stop() { return instant(() -> Motor.setThrottle(0));}

}
