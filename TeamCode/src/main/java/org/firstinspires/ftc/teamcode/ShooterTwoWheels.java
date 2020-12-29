package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name="linearShooter_proto1", group="run")
public class ShooterTwoWheels extends OpMode {
    private DcMotor motor = null;
    private DcMotor leftMotor = null;
    private DcMotor rightMotor = null;
    private DcMotor thirdMotor = null;
    // Servo servo1;
    // Servo servo2;


    public void init(){
        //motor = hardwareMap.get(DcMotor.class, "third_motor");
        // servo1 = hardwareMap.get(Servo.class, "servo_right");
        // servo2 = hardwareMap.get(Servo.class, "servo_left");
        rightMotor = hardwareMap.get(DcMotor.class,"right_drive");
        thirdMotor = hardwareMap.get(DcMotor.class,"third_motor");





    }

    public void init_loop(){
        //motor.setPower(1);
        thirdMotor.setPower(0.8);


    }

    public void start(){

    }

    public void loop(){
        //motor.setPower(-1);
        thirdMotor.setPower(-0.8);

        // if (gamepad1.a){
        // servo1.setPosition(360);
        // servo2.setPosition(0);
        // }

        // if (gamepad1.b){
        // servo1.setPosition(0);
        // servo2.setPosition(360);
        // }



    }
}