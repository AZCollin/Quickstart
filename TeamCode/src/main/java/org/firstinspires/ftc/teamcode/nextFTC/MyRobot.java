package org.firstinspires.ftc.teamcode.nextFTC;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.nextFTC.Opmodes.Drivetrain;
import org.firstinspires.ftc.teamcode.nextFTC.Subystems.Flapper;
import org.firstinspires.ftc.teamcode.nextFTC.Subystems.Intake;
import org.firstinspires.ftc.teamcode.nextFTC.Subystems.Launcher;
import org.firstinspires.ftc.teamcode.nextFTC.Subystems.Lift;
import org.firstinspires.ftc.teamcode.nextFTC.Subystems.Motor;
import org.firstinspires.ftc.teamcode.nextFTC.Subystems.Pollen;

import java.util.Set;

import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.NextRobot;

public class MyRobot implements NextRobot {
    public Drivetrain drivetrain = new Drivetrain();
    public Flapper flapper = new Flapper();
    public Motor motor = new Motor();
    public Launcher launcher = new Launcher();
    public Intake intake = new Intake();
    public Pollen pollen = new Pollen();
    public Lift lift = new Lift();



    @Override
    public Set<Mechanism> getMechanisms() {
        return Set.of(flapper, motor,launcher,intake, drivetrain,pollen,lift);
    }
}
