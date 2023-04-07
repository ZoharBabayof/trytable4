package com.example.trytable2;
import  java.lang.Math.*;
import java.util.Objects;

import static java.lang.Math.pow;

public class Patient implements Comparable<Patient>
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
    private Specialization spec_needed;//every

    public Patient(String name, String id, double waiting_time, double severity_before, Specialization spec_needed) {
        this.name = name;
        this.id = id;
        this.waiting_time = waiting_time;
        this.severity_before = severity_before;
        this.urgency_level = pow(2,(5-this.severity_before))*waiting_time;// 2^(5-severity_before)*waiting_time is the time from 120 he can wait
        this.spec_needed = spec_needed;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Double.compare(patient.waiting_time, waiting_time) == 0 && Double.compare(patient.severity_before, severity_before) == 0 && Double.compare(patient.urgency_level, urgency_level) == 0 && name.equals(patient.name) && id.equals(patient.id) && spec_needed.equals(patient.spec_needed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, waiting_time, severity_before, urgency_level, spec_needed);
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

    public Specialization getSpec_needed() {
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

    public void setSpec_needed(Specialization spec_needed) {
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
                ", spec_needed='" + spec_needed.getSpec_name() + '\'' +
                '}';
    }

    // Define the compareTo method to compare patients by priority
    @Override
    public int compareTo(Patient other) {
        return Double.compare(other.urgency_level, this.urgency_level);
    }
}
