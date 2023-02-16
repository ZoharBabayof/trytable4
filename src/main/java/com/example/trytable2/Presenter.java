package com.example.trytable2;

public class Presenter
{
    public static void main(String[] args)
    {

    // defenitions:
        //create object for every kind of specilization:
        Specialization n = new Specialization("Neurosurgery");
        Specialization p = new Specialization("Pediatric_surgery");
        Specialization c = new Specialization("Cardiothoracic_surgery");
        Specialization v = new Specialization("Vascular_surgery");

        // patients:

        //Patient(String name, String id, int waiting_time, int severity_before, int urgency_level, Specialization spec_needed) {
        Patient a = new Patient("a","1",0,7,"Neurosurgery");
        Patient b = new Patient("b","2",1,7,"Pediatric_surgery");
        Patient f = new Patient("c","3",2,7,"Cardiothoracic_surgery");
        Patient d = new Patient("d","4",3,7,"Vascular_surgery");
        Patient e = new Patient("e","5",4,7,"Vascular_surgery");



        // the actual code:
        // create

    }
}
