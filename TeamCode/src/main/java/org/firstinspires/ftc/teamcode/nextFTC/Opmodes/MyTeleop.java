package org.firstinspires.ftc.teamcode.nextFTC.Opmodes;

import static org.firstinspires.ftc.teamcode.nextFTC.Subystems.Launcher.D;
import static org.firstinspires.ftc.teamcode.nextFTC.Subystems.Launcher.I;
import static org.firstinspires.ftc.teamcode.nextFTC.Subystems.Launcher.P;

import com.acmerobotics.dashboard.FtcDashboard;
import com.pedropathing.ivy.Command;

import org.firstinspires.ftc.teamcode.nextFTC.MyRobot;
import org.firstinspires.ftc.teamcode.nextFTC.Subystems.Launcher;

import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.Telemetry;
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
        driver.a().whileTrue(robot.flapper.open()).onFalse(robot.flapper.close());
        driver.rightBumper().whileTrue(robot.motor.go()).onFalse(robot.motor.stop());
        driver.rightTrigger().isOver(0.3).whileTrue(robot.intake.go()).onFalse(robot.intake.stop());
        driver.leftBumper().whileTrue(robot.launcher.go()).onFalse(robot.launcher.stop());

        FtcDashboard.getInstance().getTelemetry().addData("Target Velocity", Launcher.targetVelocity / 100.0);
        FtcDashboard.getInstance().getTelemetry().addData("Actual Velocity", robot.launcher.launcher.getEncoderVelocity());
        telemetry.addData("Target velo", Launcher.targetVelocity / 100.0);
        telemetry.addData("Actual Velocity", robot.launcher.launcher.getEncoderVelocity());
        telemetry.update();
        FtcDashboard.getInstance().getTelemetry().update();

    }
}

