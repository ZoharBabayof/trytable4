package com.example.trytable2;
import  java.lang.Math.*;

import static java.lang.Math.pow;

public class Patient
{
         /*
    -name: String
-id:String
-waiting_time:int
-severity_before:int
-urgency_level:int
-spec_needed:<specialization>
    */

    private String name;
    private String id;
    private double waiting_time; // *5 minutes
    private double severity_before; // 1-resuscitation 5 - non urgency
    private double urgency_level;
    private String spec_needed;//every

    public Patient(String name, String id, double waiting_time, double severity_before, String spec_needed) {
        this.name = name;
        this.id = id;
        this.waiting_time = waiting_time;
        this.severity_before = severity_before;
        this.urgency_level = pow(2,(5-this.severity_before))*waiting_time;// 2^(5-severity_before)*waiting_time is the time from 120 he can wait
        this.spec_needed = spec_needed;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public double getWaiting_time() {
        return waiting_time;
    }

    public double getSeverity_before() {
        return severity_before;
    }

    public double getUrgency_level() {
        return urgency_level;
    }

    public String getSpec_needed() {
        return spec_needed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setWaiting_time(double waiting_time) {
        this.waiting_time = waiting_time;
    }

    public void setSeverity_before(double severity_before) {
        this.severity_before = severity_before;
    }

    public void setUrgency_level(double urgency_level) {
        this.urgency_level = urgency_level;
    }

    public void setSpec_needed(String spec_needed) {
        this.spec_needed = spec_needed;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", waiting_time=" + waiting_time +
                ", severity_before=" + severity_before +
                ", urgency_level=" + urgency_level +
                ", spec_needed='" + spec_needed + '\'' +
                '}';
    }
}
