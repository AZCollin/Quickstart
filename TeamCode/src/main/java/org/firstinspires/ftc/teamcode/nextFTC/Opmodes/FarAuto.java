package org.firstinspires.ftc.teamcode.nextFTC.Opmodes;

import static com.pedropathing.ivy.Scheduler.schedule;
import static com.pedropathing.ivy.commands.Commands.waitMs;
import static com.pedropathing.ivy.groups.Groups.parallel;
import static com.pedropathing.ivy.groups.Groups.sequential;
import static com.pedropathing.ivy.pedro.PedroCommands.follow;

import com.pedropathing.api.Paths;
import com.pedropathing.api.PoseFactory;
import com.pedropathing.follower.Follower;
import com.pedropathing.ivy.Command;
import com.pedropathing.math.Pose;
import com.pedropathing.paths.Path;

import org.firstinspires.ftc.teamcode.nextFTC.MyRobot;
import org.firstinspires.ftc.teamcode.pedro.Constants;

import dev.nextftc.robot.opmode.NextAutonomous;
import dev.nextftc.robot.opmode.NextOpMode;


@NextAutonomous(name = "farAuto")
public class FarAuto extends NextOpMode {

    public Follower follower;
    public FarAuto(MyRobot robot) {
        super(robot);
        this.robot = robot;

        follower = Constants.create(hardwareMap);
        follower.setPose(start);
    }
    private MyRobot robot;
    private final PoseFactory poseFactory = PoseFactory.degrees();
    // Poses
    private final Pose start = poseFactory.of(80.075, 8.0858, 270);
    private final Pose startPoint = poseFactory.of(98, 54, 270);
    private final Pose endPoint = poseFactory.of(129, 19, 270);


    public Path path1() {
        return Paths.curve(start, startPoint, endPoint).linear(start, endPoint);

    }

    private Command autoRoutine(){
        return sequential(
                robot.launcher.stop(),
                waitMs(20000),
                sequential(
                        parallel(
                robot.launcher.go1()

                                ),
                        waitMs(3000),
                        robot.flapper.open(),
                        robot.intake.go(),
                        robot.motor.go(),
                        waitMs(200),
                        robot.intake.stop(),
                        waitMs(2000),
                        robot.motor.stop(),
                        robot.flapper.close()
                        ),
                follow(follower, path1())

        );
    }



    @Override
    public void start() {
        schedule(autoRoutine());

    }

    @Override
    public void periodic() {
        follower.update();

        telemetry.addData("X", follower.pose().x());
        telemetry.addData("Y", follower.pose().y());
        telemetry.addData("Heading",
                Math.toDegrees(follower.pose().heading()));
        telemetry.addData("Follower Mode", follower.mode());
    }
}
