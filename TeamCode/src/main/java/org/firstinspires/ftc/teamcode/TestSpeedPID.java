package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="testSpeedPID", group="Iterative Opmode")

public class TestSpeedPID extends OpMode {
    private DcMotor rightMotor=null;
    private DcMotor leftMotor=null;
    private PID powerPIDright;
    private PID powerPIDleft;

    private MotorRPM motorRPMRight = null;
    private MotorRPM motorRPMLeft = null;
    private RunTime runTime = new RunTime();
    private double maxRPM=6000;
    private double RPMRight = 0;
    private double RPMLeft = 0;

    public void init(){
        rightMotor = hardwareMap.get(DcMotor.class, "right_drive");
        leftMotor = hardwareMap.get(DcMotor.class, "left_drive");
        rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


        motorRPMRight = new MotorRPM(rightMotor);
        motorRPMLeft=new MotorRPM(leftMotor);

        powerPIDright=new PID(0,0,0,0);
        powerPIDright.set_set_point(1100);

        powerPIDleft= new PID(0.1,0,0,0);
        powerPIDleft.set_set_point(1100);



    }

    public void init_loop() {

    }


    public void start() {
    }


    public void loop() {

        double RPMRight = (motorRPMRight.Speed());
        double RPMLeft = (motorRPMLeft.Speed());

        rightMotor.setPower(powerPIDright.cal(RPMRight)+ powerPIDright.get_set_point()/maxRPM);
        leftMotor.setPower(powerPIDleft.cal(RPMLeft) + powerPIDleft.get_set_point()/maxRPM);

        if (powerPIDright.tolorance_boolen(100) == false) {
            rightMotor.setPower(powerPIDright.cal(RPMRight)+ powerPIDright.get_set_point()/maxRPM);
        }
        else {
            rightMotor.setPower(0);

        }


        if (powerPIDleft.tolorance_boolen(100) == false) {
            leftMotor.setPower(powerPIDleft.cal(RPMLeft) + powerPIDleft.get_set_point()/maxRPM);
        }
        else {
            leftMotor.setPower(0);
        }




        telemetry.addData("RPMRight: ", RPMRight);
        telemetry.addData("RPMLeft: ", RPMLeft);
        telemetry.addData("Speed: ",rightMotor.getPower());
        telemetry.addData("speed:", leftMotor.getPower());







    }


    public void stop() {

    }

}
