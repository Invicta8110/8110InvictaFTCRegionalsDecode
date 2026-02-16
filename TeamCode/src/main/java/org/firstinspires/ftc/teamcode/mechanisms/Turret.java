package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.Gamepad;
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
        else {
            turretMotor.setPower(0);
        }
    }

    public double calculateVelocityRpm() {
        double g = -9.81;
        double h = 2; //measure and update
        camera.poll();
        double x = Math.sqrt(camera.getArea()); //will need to multiply by a constant

        double r = .04; //radius
        double conversionFactor = 30 / (Math.PI * r);

        double square = (g*h*h) / (2*Math.cos(2*Math.PI/3)*(h*Math.tan(Math.PI/3)-x));
        double rpm = Math.sqrt(square) * conversionFactor;
        return 6000/rpm;
    }

    public double calculateVelocityTicks() {
        double g = -9.81;
        double h = 2; //measure and update
        camera.poll();
        double x = Math.sqrt(camera.getArea()); //will need to multiply by a constant

        double r = .04; //radius
        double conversionFactor = 537 / (Math.PI * r * 2);

        double square = (g*h*h) / (2*Math.cos(2*Math.PI/3)*(h*Math.tan(Math.PI/3)-x));
        return Math.sqrt(square) * conversionFactor;
    }

    public void setVelocity() {
        outtakeMotor.setVelocity(calculateVelocityTicks());
    }
}
