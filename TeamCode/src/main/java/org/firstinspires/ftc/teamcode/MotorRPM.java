package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

public class MotorRPM {
    private double lastPlace;
    private DcMotor motorDistance;
    private double lastRunTime;
    private ElapsedTime runTime = new ElapsedTime();

    public MotorRPM(DcMotor dcMotor) {
        this.motorDistance = dcMotor;
        this.lastPlace = motorDistance.getCurrentPosition();
        this.lastRunTime = runTime.seconds();
    }

    public double Speed() {
        double deltaDistance = (this.motorDistance.getCurrentPosition() - this.lastPlace);
        lastPlace= motorDistance.getCurrentPosition();
        double deltaTime = (this.runTime.seconds() - this.lastRunTime);
        this.lastRunTime = this.runTime.seconds();
        return (deltaDistance/28)/(deltaTime/60);

    }
}



