package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class Base {
    private Motor fRight;
    private Motor fLeft;
    private Motor bRight;
    private Motor bLeft;
    private Motor intakeMotor;
    private Motor transferMotor;
    private boolean reverse;

    public Base(HardwareMap hardwareMap) {
        fRight = new Motor("front_right_drive",hardwareMap);
        fLeft = new Motor("front_left_drive",hardwareMap);
        bRight = new Motor("back_right_drive",hardwareMap);
        bLeft = new Motor("back_left_drive",hardwareMap);

        fRight.setDirectionReverse();
        bRight.setDirectionReverse();

        intakeMotor = new Motor("IntakeMotor",hardwareMap);
        transferMotor = new Motor("TransferMotor",hardwareMap);
        transferMotor.setDirectionReverse();
    }

    public void drive(double fRightPower, double fLeftPower, double bRightPower, double bLeftPower) {
        fRight.setPower(fRightPower);
        fLeft.setPower(fLeftPower);
        bRight.setPower(bRightPower);
        bLeft.setPower(bLeftPower);
    }

//    public void intake(boolean intaking) {
//        if(intaking) {
//            intakeMotor.setPower(.5);
//        }
//        else {
//            intakeMotor.setPower(0);
//        }
//    }
//
//    public void transfer(boolean launching, boolean intaking) {
//        if(launching&&!intaking) {
//            transferMotor.setPower(.5);
//        }
//        else if(!intaking) {
//            transferMotor.setPower(0);
//        }
//        else {
//            transferMotor.setPower(-.5);
//        }
//    }

    public void intakeAndTransfer(boolean intaking, boolean launching) {
        if(reverse)
            return;

        if(intaking) {
            intakeMotor.setPower(.65);
            transferMotor.setPower(-.65);
        }
        else if(launching) {
            intakeMotor.setPower(.75);
            transferMotor.setPower(1);
        }
        else {
            intakeMotor.setPower(0);
            transferMotor.setPower(0);
        }
    }

    public void emergencyReverseIntake(boolean reverse) {
        this.reverse = reverse;
        if(reverse) {
            intakeMotor.setPower(-.65);
            transferMotor.setPower(-.65);
        }
    }
}
