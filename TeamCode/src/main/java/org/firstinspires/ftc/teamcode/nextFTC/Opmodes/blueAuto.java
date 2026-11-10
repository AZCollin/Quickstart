package org.firstinspires.ftc.teamcode.nextFTC.Opmodes;
import com.pedropathing.api.Paths;
import com.pedropathing.follower.Follower;
import com.pedropathing.ivy.Command;

import static com.pedropathing.api.Paths.line;
import static com.pedropathing.ivy.Scheduler.schedule;
import static com.pedropathing.ivy.commands.Commands.waitMs;
import static com.pedropathing.ivy.groups.Groups.sequential;
import static com.pedropathing.ivy.pedro.PedroCommands.follow;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.opMode;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.pedropathing.api.PoseFactory;

import com.pedropathing.ivy.Scheduler;
import com.pedropathing.math.Pose;
import com.pedropathing.paths.Path;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;


import org.firstinspires.ftc.teamcode.nextFTC.MyRobot;
import org.firstinspires.ftc.teamcode.nextFTC.Subystems.Launcher;
import org.firstinspires.ftc.teamcode.pedro.Constants;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.pedropathing.ivy.Scheduler;

import dev.nextftc.robot.opmode.NextOpMode;


@Autonomous
public class blueAuto extends OpMode {

    public Follower follower;
    private MyRobot robot;
    private final PoseFactory poseFactory = PoseFactory.degrees();
    // Poses
    private final Pose start = poseFactory.of(85.075, 133.0858, 90);
    private final Pose startPoint = poseFactory.of(98, 121, 90);
    private final Pose preparePickup = poseFactory.of(118.4575, 133.1734, 0);
    private final Pose pickup = poseFactory.of(128.2454, 130.7577, 0);
    private final Pose startCurveToShoot = poseFactory.of(133.2454, 132.7577, 0);
    private final Pose startCurveToShootEnd = poseFactory.of(81.8899, 8.4142, 270);
    private final Pose startCurveToShootPoint = poseFactory.of(121.6691, 47.5602, 0);
    private final Pose pickup2Start = poseFactory.of(81.8899, 8.4142, 270);
    private final Pose pickup2End = poseFactory.of(127.1604, 94.2148, 0);
    private final Pose pickup2Point = poseFactory.of(114.5984, 49.3261, 0);
    private final Pose backToShoot = poseFactory.of(127.1604, 94.2148, 0);
    private final Pose backToShootEnd = poseFactory.of(81.89, 8.41, 270);
    private final Pose backToShootPoint = poseFactory.of(121.5545, 44.3122, 0);

    public Path path1() {
        return Paths.curve(start, startPoint, preparePickup).linear(start, preparePickup);

    }

    public Path path2() {
        return Paths.line(preparePickup, pickup).constant(pickup);
    }

    public Path path3() {
        return Paths.curve(startCurveToShoot, startCurveToShootPoint, startCurveToShootEnd).linear(startCurveToShoot, startCurveToShootEnd);
    }

    public Path path4() {
        return Paths.through(pickup2Start, pickup2Point, pickup2End).linear(pickup2Start, pickup2End);
    }

    public Path path5() {
        return Paths.curve(backToShoot, backToShootPoint, backToShootEnd).linear(backToShoot, backToShootEnd);
    }
    private Command autoRoutine(){
        return sequential(
                robot.launcher.go(),
                waitMs(2000),
                robot.flapper.open(),
                robot.intake.go(),
                robot.motor.go(),
                waitMs(200),
                robot.intake.stop(),
                waitMs(200),
                robot.launcher.stop(),
                robot.motor.stop(),
                robot.flapper.close(),
                follow(follower, path1()),

                follow(follower, path2()),

                follow(follower, path3()),
                follow(follower, path4()),
                follow(follower, path5())

        );
    }



    @Override
    public void init() {
        Scheduler.reset();
        follower = Constants.create(hardwareMap);
        follower.setPose(start);
        follower.update();
    }
    @Override
    public void start() {
        schedule(autoRoutine());
    }
    @Override
    public void loop() {
        follower.update();
        Scheduler.execute();
        // add your other methods needed in the loop here
        telemetry.addData("X", follower.pose().x());
        telemetry.addData("Y", follower.pose().y());
        telemetry.addData("Heading", Math.toDegrees(follower.pose().heading()));
        telemetry.addData("Follower Mode", follower.mode());
        telemetry.update();
    }
}
