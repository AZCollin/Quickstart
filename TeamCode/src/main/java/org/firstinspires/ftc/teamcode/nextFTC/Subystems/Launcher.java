package org.firstinspires.ftc.teamcode.nextFTC.Subystems;

import static dev.nextftc.units.Units.DegreesPerSecond;
import static dev.nextftc.units.Units.Radians;

import com.acmerobotics.dashboard.config.Config;
import com.pedropathing.ivy.Command;

import dev.nextftc.control.feedback.PIDCoefficients;
import dev.nextftc.control.feedback.PIDController;
import dev.nextftc.hardware.RobotController;
import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.robot.Mechanism;

@Config
public class Launcher implements Mechanism {
    public static double P = 0.01;
    public static double I = 0.0;
    public static double D = 0.001;

    public static double targetVelocity = 1000;
    public NextMotor launcher = new NextMotor(RobotController.expansionHub(), 1, Radians.of(2 * Math.PI / 537.7));
    PIDController pid = new PIDController(new PIDCoefficients(P, I, D));

    public Command go() {
        return instant(() -> {
            launcher.getVelocityConstants()
                    .withP(P)
                    .withI(I)
                    .withD(D);

            launcher.setVelocitySetpoint(
                    DegreesPerSecond.of(targetVelocity)
            );
        });
    }

    public Command stop() {return instant(() -> launcher.setThrottle(0));}


    public PIDCoefficients getPID() {
        return new PIDCoefficients(P, I, D);
    }

    @Override
    public void periodic() {
        launcher.update();
    }
}
