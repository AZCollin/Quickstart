package org.firstinspires.ftc.teamcode.pedro;

import com.qualcomm.robotcore.hardware.Gamepad;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.drive.DriveCommands;

public class Drivetrain implements Mechanism {

    NextMotor frontLeft = new NextMotor(RobotController.controlHub(), 0);
    NextMotor frontRight = new NextMotor(RobotController.controlHub(), 1);
    NextMotor backLeft = new NextMotor(RobotController.controlHub(), 2);
    NextMotor backRight = new NextMotor(RobotController.controlHub(), 3);

    public void startDrive(Gamepad gamepad) {
        DriveCommands.mecanumDrive(frontLeft, frontRight, backLeft, backRight, gamepad).schedule();
    }
}
