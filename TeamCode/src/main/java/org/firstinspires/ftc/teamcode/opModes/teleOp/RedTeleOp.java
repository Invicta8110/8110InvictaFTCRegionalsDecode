package org.firstinspires.ftc.teamcode.opModes.teleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.robot.Robot;

@TeleOp
public class RedTeleOp extends OpMode {
    private Robot robot;

    public void init() {
        robot = new Robot(hardwareMap,24,telemetry);
    }

    public void loop() {
        robot.updateTurret(gamepad1.left_trigger-gamepad1.right_trigger,gamepad1.y,gamepad1.b);
        robot.updateBase(gamepad1.a,gamepad1.x,gamepad1.left_bumper);

        drive();
    }

    private void drive() {
        double y = -gamepad1.left_stick_y; // Remember, Y stick is reversed!
        double x = gamepad1.left_stick_x;
        double rx = gamepad1.right_stick_x;

        double fRightPower = y - x - rx;
        double fLeftPower = y + x + rx;
        double bRightPower = y + x - rx;
        double bLeftPower = y - x + rx;

        robot.drive(fRightPower, fLeftPower, bRightPower, bLeftPower);
    }
}
