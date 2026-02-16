package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.mechanisms.Base;
import org.firstinspires.ftc.teamcode.mechanisms.Turret;

public class Robot {
    private Base base;
    private Turret turret;

    public Robot(HardwareMap hardwareMap, int goalTag) {
        base = new Base(hardwareMap);
        turret = new Turret(hardwareMap,goalTag);
    }

    public void drive(double fRight, double fLeft, double bRight, double bLeft) {
        base.drive(fRight,fLeft,bRight,bLeft);
    }

    public void updateBase(boolean intake, boolean transfer) {
        base.intake(intake);
        base.transfer(transfer,intake);
    }

    public void updateTurret() {
        turret.turnToGoal(.5);
        turret.setVelocity();
    }
}
