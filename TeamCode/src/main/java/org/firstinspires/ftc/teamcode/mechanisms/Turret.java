package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class Turret {
    private Camera camera;
    private Motor outtakeMotor;
    private Motor turretMotor;

    public Turret(HardwareMap hardwareMap, int goalTag) {
        camera = new Camera(hardwareMap, goalTag);
        outtakeMotor = new Motor("OttakeMotor",hardwareMap);
        turretMotor = new Motor("TurretMotor",hardwareMap);
    }

    public void turnToGoal(double error) {
        camera.poll();
        if(!camera.tagFound()) {
            turretMotor.setPower(.1);
        }
        else if(Math.abs(camera.getX())>error) {
            turretMotor.setPower(camera.getX()*.03);
        }
    }
}
