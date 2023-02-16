package com.example.trytable2;

import java.util.Iterator;
import java.util.LinkedList;

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
        n.getPatient_queue().add(a);
        p.getPatient_queue().add(b);
        c.getPatient_queue().add(f);
        v.getPatient_queue().add(d);
        v.getPatient_queue().add(e);
        Iterator<Patient> iterator = v.getPatient_queue().iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


        // the actual code:
        // create

    }
}
