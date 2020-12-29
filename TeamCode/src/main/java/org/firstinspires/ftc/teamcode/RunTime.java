package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.util.ElapsedTime;

public class RunTime {
    private double lastRunTime;
    private ElapsedTime runTime = new ElapsedTime();

    public RunTime(){
        this.lastRunTime = runTime.seconds();

    }

    public double time(){
        double deltaTime = (this.runTime.seconds() - this.lastRunTime);
        this.lastRunTime = this.runTime.seconds();
        return deltaTime;
    }
}
