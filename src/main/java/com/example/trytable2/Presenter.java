package com.example.trytable2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Presenter
{
    private Model model;
    public Presenter() {
        this.model = new Model();
    }


    public static void main(String[] args)
    {

//    // defenitions:
//        //create object for every kind of specilization:
//        Specialization n = new Specialization("Neurosurgery");
//        Specialization p = new Specialization("Pediatric_surgery");
//        Specialization c = new Specialization("Cardiothoracic_surgery");
//        Specialization v = new Specialization("Vascular_surgery");
//
//        // patients:
//
//        //Patient(String name, String id, int waiting_time, int severity_before, int urgency_level, Specialization spec_needed) {
//        Patient a = new Patient("a","1",0,1,"Neurosurgery");
//        Patient b = new Patient("b","2",1,2,"Pediatric_surgery");
//        Patient f = new Patient("c","3",2,3,"Cardiothoracic_surgery");
//        Patient d = new Patient("d","4",3,4,"Vascular_surgery");
//        Patient e = new Patient("e","5",4,5,"Vascular_surgery");
//        n.getPatient_queue().add(a);
//        p.getPatient_queue().add(b);
//        c.getPatient_queue().add(f);
//        v.getPatient_queue().add(d);
//        v.getPatient_queue().add(e);
//        Iterator<Patient> iterator = v.getPatient_queue().iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }


        // the actual code:
        // create




    }
    // ret all possible specs of hospital in  array list
    public ArrayList<Specialization> giveSpec()
    {
        return (this.model.StartModel());
    }

    // ret all OperatingRooms of hospital in  array list
    public ArrayList<OperatingRoom > retOprooms()
    {
        return (this.model.retOprooms());
    }

    // ret retRecoveryRoom of hospital in  array list
    public RecoveryRoom retRecoveryRoom()
    {
        return this.model.retRecoveryRoom();
    }

    // ret Doctors of hospital in  array list
    public ArrayList<Doctor > retDoctors()
    {
        return this.model.retDoctors();
    }

    // start main algorithm of project.
    public void Algorithem()

    {
        //for(Specialization s : this.giveSpec() )
        Specialization s = this.giveSpec().get(3);
            model.schedule(s);
    }

}
