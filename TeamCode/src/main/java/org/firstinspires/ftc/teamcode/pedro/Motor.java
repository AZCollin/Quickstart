package org.firstinspires.ftc.teamcode.pedro;

import static com.pedropathing.ivy.commands.Commands.instant;

import static dev.nextftc.units.Units.Degrees;

import com.pedropathing.ivy.Command;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.hardware.actuators.NextServo;
import dev.nextftc.robot.Mechanism;

public class Motor implements Mechanism {
    NextMotor Motor = new NextMotor("Motor");
    public Command go() {
        return instant(() -> Motor.setThrottle(0.7));
    }
    public Command stop() {
        return instant(() -> Motor.setThrottle(0));
    }





}
