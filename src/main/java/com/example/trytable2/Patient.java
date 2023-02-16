package com.example.trytable2;

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
    private int waiting_time;
    private int severity_before;
    private int urgency_level;
    private String spec_needed;//every

    public Patient(String name, String id, int waiting_time, int severity_before, String spec_needed) {
        this.name = name;
        this.id = id;
        this.waiting_time = waiting_time;
        this.severity_before = severity_before;
        this.urgency_level = 3;// here we need to do a automatic calculation by the rules of health world
        this.spec_needed = spec_needed;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getWaiting_time() {
        return waiting_time;
    }

    public int getSeverity_before() {
        return severity_before;
    }

    public int getUrgency_level() {
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

    public void setWaiting_time(int waiting_time) {
        this.waiting_time = waiting_time;
    }

    public void setSeverity_before(int severity_before) {
        this.severity_before = severity_before;
    }

    public void setUrgency_level(int urgency_level) {
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
