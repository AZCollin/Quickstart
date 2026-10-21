package org.firstinspires.ftc.teamcode.nextFTC;

import org.firstinspires.ftc.teamcode.nextFTC.Opmodes.Drivetrain;
import org.firstinspires.ftc.teamcode.nextFTC.Subystems.Flapper;
import org.firstinspires.ftc.teamcode.nextFTC.Subystems.Intake;
import org.firstinspires.ftc.teamcode.nextFTC.Subystems.Launcher;
import org.firstinspires.ftc.teamcode.nextFTC.Subystems.Motor;

import java.util.Set;

import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.NextRobot;

public class MyRobot implements NextRobot {
    public Drivetrain drivetrain = new Drivetrain();
    public Flapper flapper = new Flapper();
    public Motor motor = new Motor();
    public Launcher launcher = new Launcher();
    public Intake intake = new Intake();

    @Override
    public Set<Mechanism> getMechanisms() {
        return Set.of(flapper, motor,launcher,intake, drivetrain);
    }
}
