package org.firstinspires.ftc.teamcode;

public class PID {

    private double Kp;
    private double ki;
    private double kd;
    private double setPoint;
    private double I;
    private RunTime runTime = new RunTime();
    private double lastError;
    private double source;
    public double F;


    public PID (double kp, double ki, double kd, double f) {
        this.Kp = kp;
        this.ki = ki;
        this.kd = kd;
        this.I = 0;
        this.lastError = 0;
        this.F = f;

    }


    public void set_set_point (double set_point) {

        this.setPoint = set_point;
    }

    public double get_set_point(){
        return this.setPoint;
    }

    public double cal (double source){
        this.source = source;
        double deltaTime = runTime.time();
        double error = this.setPoint - this.source;
        double P = error * Kp;
        this.I += (error * deltaTime) * ki;
        double D = ((error - this.lastError) / deltaTime) * kd;

        double pid = P + this.I + D + F;
        if (pid >= 1){
            return 1;
        }
        else if (pid <= -1){
            return -1;
        }
        else {
            return pid;
        }
    }


    public boolean tolorance_boolen (double tolorance){
        if (source <= Math.abs(this.setPoint + tolorance) && source >= Math.abs(this.setPoint - tolorance)){
            return true;
        }
        else {
            return false;
        }

    }

}

