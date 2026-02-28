package org.firstinspires.ftc.teamcode.opModes.teleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.mechanisms.Motor;
import org.firstinspires.ftc.teamcode.robot.Robot;

@TeleOp
public class TestTeleOp extends OpMode {
    private Motor fRight;
    private Motor fLeft;
    private Motor bRight;
    private Motor bLeft;
    private Motor turretMotor;

    public void init() {
        fRight = new Motor("front_right_drive",hardwareMap);
        fLeft = new Motor("front_left_drive",hardwareMap);
        bRight = new Motor("back_right_drive",hardwareMap);
        bLeft = new Motor("back_left_drive",hardwareMap);

        fRight.setDirectionReverse();
        bRight.setDirectionReverse();

        turretMotor = new Motor("TurretMotor",hardwareMap);
        turretMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void loop() {
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

        telemetry.addData("fRight",fRightPower);
        telemetry.addData("fLeft",fLeftPower);
        telemetry.addData("bRight",bRightPower);
        telemetry.addData("bLeft",bLeftPower);


        fRight.setPower(fRightPower);
        fLeft.setPower(fLeftPower);
        bRight.setPower(bRightPower);
        bLeft.setPower(bLeftPower);

        turretMotor.setPower(gamepad1.right_trigger-gamepad1.left_trigger);

        telemetry.addData("Turret",turretMotor.getPosition());
    }
}
