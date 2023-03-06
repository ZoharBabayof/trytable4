package com.example.trytable2;

import java.util.ArrayList;

public class Model
{
    private static ArrayList<Specialization> specs;//array for every kind of specialization
    //private static ArrayList<Doctor> doctors;//array for every kind of specialization // i have this in spec already
    private static ArrayList<OperatingRoom > OperatingRooms;//array for every kind of specialization



    public Model()
    {
       this.specs = new ArrayList<Specialization>();


    }

    /*
        definitions for the main objects in project: all the Specializations, Doctors, Patients, Rooms
        - define the structs and data structures
         */

    /**
     *
     * @return
     */
    public  ArrayList<Specialization>  StartModel()
    {

        //create object for every kind of specilization:
        Specialization n = new Specialization("Neurosurgery");
        Specialization p = new Specialization("Pediatric_surgery");
        Specialization c = new Specialization("Card_surgery");
        Specialization v = new Specialization("Vascular_surgery");
        // Patient(String name, String id, int waiting_time, int severity_before, int urgency_level, Specialization spec_needed) {
        Patient a = new Patient("a","1",0,1,"Neurosurgery");
        Patient b = new Patient("b","2",1,2,"Pediatric_surgery");
        Patient f = new Patient("c","3",2,3,"Card_surgery");
        Patient d = new Patient("d","4",3,4,"Vascular_surgery");

        Patient e = new Patient("e","0",4,5,"Vascular_surgery");
        Patient e1 = new Patient("e1","1",4,5,"Vascular_surgery");
        Patient e2 = new Patient("e2","2",1,5,"Vascular_surgery");
        Patient e3 = new Patient("e3","3",4,5,"Vascular_surgery");
        Patient e4 = new Patient("e4","1",4,5,"Vascular_surgery");
        Patient e5 = new Patient("e1","2",1,5,"Vascular_surgery");
        Patient e6 = new Patient("e2","19",4,5,"Vascular_surgery");
        Patient e7 = new Patient("e3","1",4,5,"Vascular_surgery");
        Patient e8 = new Patient("e4","2",4,5,"Vascular_surgery");
        n.getPatient_queue().add(a);


        p.getPatient_queue().add(b);
        c.getPatient_queue().add(f);
        v.getPatient_queue().add(d);
        v.getPatient_queue().add(e);
        v.getPatient_queue().add(e1);
        v.getPatient_queue().add(e2);
        v.getPatient_queue().add(e3);
        v.getPatient_queue().add(e4);
        this.specs.add(n);
        this.specs.add(p);
        this.specs.add(c);
        this.specs.add(v);

        //create all Operating Rooms :
        OperatingRoom1 = new OperatingRoom();




        //create the RecoveryRoom
        RecoveryRoom recoveryRoom = new RecoveryRoom();
        Patient p7 = new Patient("e3","1",4,-1,"Vascular_surgery");
        Patient p8 = new Patient("e4","222",4,-1,"Neurosurgery");
        Patient p77 = new Patient("e33","12",22,-1,"Pediatric_surgery");
        Patient p87 = new Patient("e43","22",4,-1,"Neurosurgery");

        recoveryRoom.getResting_patients().add(p7);
        recoveryRoom.getResting_patients().add(p8);
        recoveryRoom.getResting_patients().add(p77);
        recoveryRoom.getResting_patients().add(p87);

        return(this.specs);//,this.O,recoveryRoom);
    }
}
