package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.mechanisms.Base;
import org.firstinspires.ftc.teamcode.mechanisms.Turret;

public class Robot {
    private Base base;
    private Turret turret;
    private boolean manual;

    public Robot(HardwareMap hardwareMap, int goalTag, Telemetry telemetry) {
        base = new Base(hardwareMap);
        turret = new Turret(hardwareMap,goalTag,telemetry);
        manual = false;
    }

    public void drive(double fRight, double fLeft, double bRight, double bLeft) {
        base.drive(fRight,fLeft,bRight,bLeft);
    }

    public void updateBase(boolean intake, boolean transfer, boolean reverse) {
//        base.intake(intake);
//        base.transfer(transfer,intake);
        base.intakeAndTransfer(intake,transfer);
        base.emergencyReverseIntake(reverse);
    }

    public void updateTurret(double rotateSpeed, boolean manualOn, boolean manualOff) {
        if(manualOn) {
            manual = true;
        }
        else if(manualOff) {
            manual = false;
        }

        if(manual) {
            turret.manualRotate(rotateSpeed);
        }
        else {
            turret.turnToGoalv2(.5);
        }
        turret.setVelocity();
    }
}
