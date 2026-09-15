package org.firstinspires.ftc.teamcode.pedro;

import static dev.nextftc.robot.RobotState.robot;

import com.pedropathing.ivy.Command;
import com.pedropathing.ivy.commands.Commands;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.robot.Robot;

import org.firstinspires.ftc.teamcode.Claw;

import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.Telemetry;
import dev.nextftc.robot.drive.DriveCommands;
import dev.nextftc.robot.opmode.BulkReadHook;
import dev.nextftc.robot.opmode.NextOpMode;
import dev.nextftc.robot.opmode.NextTeleop;
import dev.nextftc.robot.triggers.CommandGamepad;

@NextTeleop(name = "My Teleop")
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

