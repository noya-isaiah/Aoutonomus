package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name="Wobble_proto", group="Iterative Opmode")

public class Wobble extends OpMode
{
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
    private DcMotor motor= null;
    Servo servo1;
    Servo servo2;

    @Override
    public void init() {

        leftDrive  = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
        motor= hardwareMap.get(DcMotor.class,"third_motor");
        servo1= hardwareMap.get(Servo.class,"servo_right");
        servo2 = hardwareMap.get(Servo.class,"servo_left");



        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);

    }


    @Override
    public void init_loop() {
    }


    @Override
    public void start() {
    }


    @Override
    public void loop() {

        leftDrive.setPower(0);
        rightDrive.setPower(0);

        if(gamepad1.a){
            servo1.setPosition(0);
            servo2.setPosition(270);

        }

        if(gamepad1.a){
            servo1.setPosition(-270);
            servo2.setPosition(0);

        }
    }


    @Override
    public void stop() {
    }

}
