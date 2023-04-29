package com.example.trytable2;

public class Surgery {
    private static int surgID = 0;
    private Specialization spec;
    private Doctor doctor;
    private Patient patient;
    private OperatingRoom room;
    public Surgery(Specialization spec, Doctor doctor, Patient patient, OperatingRoom room) {
        this.surgID++;
        this.spec = spec;
        this.doctor = doctor;
        this.patient = patient;
        this.room = room;
    }

    public static int getSurgID() {
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
