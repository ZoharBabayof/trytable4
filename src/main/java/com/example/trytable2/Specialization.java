package com.example.trytable2;

// Specialization in surgery:
  //  Neurosurgery,//תחום ברפואה העוסק בהתערבות ניתוחית במחלות של מערכת העצבים המרכזית ומערכת העצבים ההיקפית כולל המוח וחוט השדרה.
  //  Pediatric_surgery,// טיפול בפעוטות ילדים ובני נוער שסובלים ממחלות כירורגיות שונות.
  //  Cardiothoracic_surgery,//טיפול במחלות כירורגיות של הלב קרום הלב הריאות קרום הריאה וכלי הדם הגדולים שבבית החזה
  //  Vascular_surgery  // תחום ברפואה המתמחה בניתוח של כלי הדם


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Specialization {
    private String spec_name;
        private Queue<Patient> patient_queue;
    private ArrayList <Doctor> doctors_with_spec;// dinamic array that contains all docotor who have this specilization.
    private static int count=0;
    private static ArrayList<Specialization> specilities;// dinamic array of all specilizations static - i must
    private ArrayList <OperatingRoom> OperatingRooms_with_spec;// dinamic array that contains all docotor who have this specilization.


    public Specialization(String spec_name) {
        this.spec_name = spec_name;
        this.patient_queue = new LinkedList<Patient>();
        this.doctors_with_spec = new ArrayList<Doctor>();
        this.OperatingRooms_with_spec = new ArrayList<OperatingRoom>();

       // this.specs = new

    }

    public String getSpec_name() {
        return this.spec_name;
    }

    public Queue<Patient> getPatient_queue() {
        return this.patient_queue;
    }


    public ArrayList<Doctor> getDoctors_with_spec() {
        return this.doctors_with_spec;
    }
    public ArrayList<OperatingRoom> getOperatingRooms_with_spec() {
        return this.OperatingRooms_with_spec;
    }


    public void setSpec_name(String spec_name) {
        this.spec_name = spec_name;
    }

    public void setPatient_queue(Queue<Patient> patient_queue) {
        this.patient_queue = patient_queue;
    }

    public void setDoctors_with_spec(ArrayList<Doctor> doctors_with_spec) {
        this.doctors_with_spec = doctors_with_spec;
    }

    @Override
    public String toString() {
        return spec_name;
    }
//    public String toString() {
//        return "Specialization{" +
//                "spec_name='" + spec_name + '\'' +
//                ", patient_queue=" + patient_queue +
//                ", doctors_with_spec=" + doctors_with_spec +
//                ", OperatingRooms_with_spec=" + OperatingRooms_with_spec +
//                '}';
//    }
    /*
    -spec_name: String
-patient_queue: <patient> queue
-doctors_with_spec: dinamic <doctor> array
    */
}
