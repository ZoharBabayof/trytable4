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
}
