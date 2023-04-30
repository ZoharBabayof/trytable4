package com.example.trytable2;

import java.util.ArrayList;

public class Surgery {
    private static int IDcouter = 0;

    private int surgID;

    private Specialization spec;
    private Doctor doctor;
    private Patient patient;
    private OperatingRoom room;
    private String time_left;

    public Surgery(Specialization spec, Doctor doctor, Patient patient, OperatingRoom room,double time_left) {
        IDcouter++;
        this.surgID= IDcouter;
        this.spec = spec;
        this.doctor = doctor;
        this.patient = patient;
        this.room = room;
       // this.time_left = time_left;
        this.time_left = String.valueOf(room.getTime_left_evalution());

    }

    public String getTime_left() {
        return time_left;
    }

    public void setTime_left(String time_left) {
        this.time_left = time_left;
    }

    public  int getSurgID() {
        return surgID;
    }


    public Specialization getSpec() {
        return spec;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public OperatingRoom getRoom() {
        return room;
    }

    public void setSpec(Specialization spec) {
        this.spec = spec;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setRoom(OperatingRoom room) {
        this.room = room;
    }
}
