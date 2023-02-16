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

    //private static ArrayList<Specialization> specilities;// dinamic array of all specilizations static - i must

    public Specialization(String spec_name) {
        this.spec_name = spec_name;
        this.patient_queue = new LinkedList<Patient>();
        this.doctors_with_spec = new ArrayList<>();
    }

/*
    -spec_name: String
-patient_queue: <patient> queue
-doctors_with_spec: dinamic <doctor> array
    */
}
