package org.firstinspires.ftc.teamcode.nextFTC.Opmodes;

import org.firstinspires.ftc.teamcode.nextFTC.MyRobot;

import dev.nextftc.robot.opmode.NextOpMode;
import dev.nextftc.robot.opmode.NextTeleop;
import dev.nextftc.robot.triggers.CommandGamepad;

@NextTeleop(name = "Teleop")
public class MyTeleop extends NextOpMode {
    private final MyRobot robot;
    CommandGamepad driver = new CommandGamepad(gamepad1);


    public MyTeleop(MyRobot robot) {
        super(robot);
        this.robot = robot;
    }



    @Override
    public void start() {
        robot.drivetrain.startDrive(gamepad1);

    }
    @Override
    public void periodic() {
        driver.a().whileTrue(robot.claw.open()).onFalse(robot.claw.close());
        driver.b().whileTrue(robot.motor.go()).onFalse(robot.motor.stop());

    }

}

