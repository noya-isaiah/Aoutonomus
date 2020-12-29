package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="testPID", group="Iterative Opmode")

public class testPID extends OpMode {
    private DcMotor rightMotor= null;
    private DcMotor leftMotor=null;
    private PID PIDright;
    private PID PIDleft;



    public void init() {
        rightMotor = hardwareMap.get(DcMotor.class, "right_drive");
        leftMotor = hardwareMap.get(DcMotor.class, "left_drive");
        rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


        PIDright= new PID(0.9,1,1, 0);
        PIDright.set_set_point(10000);

        PIDleft= new PID(0.9,1,1, 0);
        PIDleft.set_set_point(10000);


    }

    public void init_loop() {
    }

    public void start() {
    }

    public void loop() {
        if (PIDright.tolorance_boolen(1000) == false) {
            rightMotor.setPower(PIDright.cal(rightMotor.getCurrentPosition()));
        }
        else {
            rightMotor.setPower(0);
        }

        if (PIDleft.tolorance_boolen(1000) == false) {
            leftMotor.setPower(PIDleft.cal(rightMotor.getCurrentPosition()));
        }
        else {
            leftMotor.setPower(0);
        }


        telemetry.addData("right_motor", "encoder: " + rightMotor.getCurrentPosition());
        telemetry.addData("left_motor", "encoder: " + leftMotor.getCurrentPosition());


    }

    public void stop() {

    }

}
