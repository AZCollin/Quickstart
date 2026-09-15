package org.firstinspires.ftc.teamcode.pedro;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Claw;

import java.util.Set;

import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.NextRobot;
import dev.nextftc.robot.drive.DriveCommands;

public class MyRobot implements NextRobot {
    Drivetrain drivetrain = new Drivetrain();
    Claw claw = new Claw();
    Motor motor = new Motor();


    @Override
    public Set<Mechanism> getMechanisms() {
        return Set.of(claw, motor, drivetrain);
    }
}
