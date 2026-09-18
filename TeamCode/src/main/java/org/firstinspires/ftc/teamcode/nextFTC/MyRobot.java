package org.firstinspires.ftc.teamcode.nextFTC;

import org.firstinspires.ftc.teamcode.nextFTC.Opmodes.Drivetrain;
import org.firstinspires.ftc.teamcode.nextFTC.Subystems.Claw;
import org.firstinspires.ftc.teamcode.nextFTC.Subystems.Launcher;
import org.firstinspires.ftc.teamcode.nextFTC.Subystems.Motor;

import java.util.Set;

import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.NextRobot;

public class MyRobot implements NextRobot {
    public Drivetrain drivetrain = new Drivetrain();
    public Claw claw = new Claw();
    public Motor motor = new Motor();
    public Launcher launcher = new Launcher();

    @Override
    public Set<Mechanism> getMechanisms() {
        return Set.of(claw, motor,launcher, drivetrain);
    }
}
