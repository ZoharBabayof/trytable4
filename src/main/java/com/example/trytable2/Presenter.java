package com.example.trytable2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Presenter
{
    private Model model;
    private View view;
    /**
     * constructor
     */
    public Presenter(Model model) {
        this.model = model;
        this.view = new View();
    }

    /**
     * constructor
     */
    public Presenter() {
        // Initialize the view
        this.view = new View();
        this.model = new Model();
        // ...
    }

    /**
     *
     * @param not used. egnore.
     */
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


        // so I should have a main timer that calls every 5 seconds to the UpdateHospital function



        // model
            // UpdateHospital: call to the SortAllPatientsQueues function and call to the Schedule function (that do the schedule while there is option)
            //                  make sure the last function updates the data structures. then call to the gui to show changes.
            // in "schedule" function we use doctor, rooms heaps. we need to make functions to sort these heaps by the specialization.
            // in "schedule" function we use patients heaps. we need to make function to sort this heap by the total urgency.
            // and in the algorithm we need to add preference to take patient with lower time of surgery if the difference between the total urgency of them is in the range of 2 and none of them in 10.


    }

    /**
     * returns the specializations array from model
     * @return ArrayList<Specialization> spec array
     * @throws IOException
     */
    public ArrayList<Specialization> giveSpec() throws IOException {
        return (this.model.StartModel());
    }

    // ret all OperatingRooms of hospital in  array list

    /**
     * returns the opRooms arraylist from model
     * @return ArrayList<OperatingRoom >oprooms
     */
    public ArrayList<OperatingRoom > retOprooms()
    {
        return (this.model.retOprooms());
    }

    // ret retRecoveryRoom of hospital in  array list

    /**
     * not used. ignore.
     * @return
     */
    public RecoveryRoom retRecoveryRoom()
    {
        return this.model.retRecoveryRoom();
    }

    // ret Doctors of hospital in  array list

    /**
     * returns the doctors ArrayList from model
     * @return ArrayList<Doctor > doctors
     */
    public ArrayList<Doctor > retDoctors()
    {
        return this.model.retDoctors();
    }


    /**
     * call the InitHospital function from model
     */
    public void startHospital() {
        model.InitHospital();
    }




        // start main algorithm of project.


    /**
     * call the schedule function from model
     * @throws IOException
     */
    public void Algorithem() throws IOException {

        //for(Specialization s : this.giveSpec() )



            model.schedule();
    }

    /**
     * return the ArrayList surgeries from model
     * @return ArrayList<Surgery> surgeries
     */

    public ArrayList<Surgery> retSurges()
    {
        return model.getSurgeries();
    }

    /**
     * ignore. not relevant
     */
    public void showSurgTable(Doctor d, Patient p, OperatingRoom op)
    {
     this.view.showSurgerytable( this.retSurges());
    }

    /**
     *
     * @param d - Doctor d
     * @param p - Patient p
     * @param op- OperatingRoom op
     * call to the showSurgery function in view
     */
     public void showSurgInView(Doctor d, Patient p, OperatingRoom op)
    {
        this.view.showSurgery( d, p,op);
    }

}
