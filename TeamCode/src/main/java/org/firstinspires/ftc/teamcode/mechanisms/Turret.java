package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Turret {
    private Camera camera;
    private Motor outtakeMotor;
    private Motor turretMotor;
    private Telemetry telemetry;
    private boolean manual;

    public Turret(HardwareMap hardwareMap, int goalTag, Telemetry telemetry) {
        camera = new Camera(hardwareMap, goalTag,telemetry);
        outtakeMotor = new Motor("OuttakeMotor",hardwareMap);
        turretMotor = new Motor("TurretMotor",hardwareMap);

        outtakeMotor.setDirectionReverse();
        this.telemetry = telemetry;
        manual = false;
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
        double g = 9.81;
        double h = .9845; //measure and update
        camera.poll();
        //double x = Math.sqrt(camera.getArea()); //will need to multiply by a constant
        double x = (1/Math.sqrt(camera.getArea()))*.167-.0655; //check spreadsheet to see calculations behind this

        double r = .045; //radius
        double conversionFactor = 30 / (Math.PI * r);

        //double square = (g*h*h) / (2*Math.cos(2*Math.PI/3)*(h*Math.tan(Math.PI/3)-x));
        double square = (g*x*x) / ((2*.25) * (x*Math.tan(Math.PI/3)-h));
        double rpm = Math.sqrt(square) * conversionFactor;

        telemetry.addData("Area",camera.getArea());
        telemetry.addData("Sqrt",Math.sqrt(camera.getArea()));
        telemetry.addData("Distance",x);
        telemetry.addData("Velocity m/s",Math.sqrt(square));
        telemetry.addData("Velocity tick/s",Math.sqrt(square) * conversionFactor);

        return rpm/6000;
    }

    public double calculateVelocityTicks() {
        double g = 9.81;
        double h = .85; //measure and update
        camera.poll();
        //.double x = Math.sqrt(camera.getArea()); //will need to multiply by a constant
        double x = (1/Math.sqrt(camera.getArea()))*.167-.0655; //check spreadsheet to see calculations behind this

        double r = .045; //radius
        double conversionFactor = 537 / (Math.PI * r * 2);

        //double square = (g*h*h) / (2*Math.cos(Math.PI/3)*(h*Math.tan(Math.PI/3)-x));
        double square = (g*x*x) / ((2*.25) * (x*Math.tan(Math.PI/3)-h));

        telemetry.addData("Area",camera.getArea());
        telemetry.addData("Sqrt",Math.sqrt(camera.getArea()));
        telemetry.addData("Distance",x);
        telemetry.addData("Velocity m/s",Math.sqrt(square));
        telemetry.addData("Velocity tick/s",Math.sqrt(square) * conversionFactor);


        return Math.sqrt(square) * conversionFactor;
    }

    public void setVelocity() {
        //outtakeMotor.setVelocity(calculateVelocityTicks()/500);
        outtakeMotor.setPower(calculateVelocityRpm());
        //outtakeMotor.setPower(-.8);
    }

    public void changeManual() {
        manual = !manual;
    }

    public void manualRotate(double speed) {
        if(manual) {
            turretMotor.setPower(speed);
        }
    }
}
