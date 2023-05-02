package com.example.trytable2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class OperatingRoom
{
    //HashMap<String, Patient> capitalCities;
    private static int roomcounter=0;
    private String room_id ;
    private boolean Is_available;
    private double time_left_evalution;// in clock rounds. if availiable: time_left_evalution = 0.
    private Specialization [] specialities_array;// dinamic array of specialities the room can treat
    private Doctor doc1;
    // in the future more doctors
    private Patient pat1;


    public OperatingRoom(Specialization [] arryspec)
    {
        this.specialities_array = specialities_array;
        roomcounter++;
        this.room_id = Integer.toString(roomcounter);
        this.time_left_evalution = 0;//

        this.room_id = room_id;// mispur of operation rooms from 1 to number of rooms
        this.Is_available = true;
        this.time_left_evalution = time_left_evalution;
        this.specialities_array = arryspec;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperatingRoom that = (OperatingRoom) o;
        return Is_available == that.Is_available && time_left_evalution == that.time_left_evalution && room_id.equals(that.room_id) && Objects.equals(specialities_array, that.specialities_array) && doc1.equals(that.doc1) && pat1.equals(that.pat1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(room_id, Is_available, time_left_evalution, specialities_array, doc1, pat1);
    }


    public void surgery(Doctor d, Patient p)
    {
        this.doc1 = d;
        this.pat1 = p;
        this.time_left_evalution = (p.getUrgency_level())/5;
        System.out.println("surgery: spec:"+p.getSpec_needed()+" room_id:"+this.room_id+" doctor:"+this.doc1+" patient:"+this.pat1 + "time left: " + time_left_evalution);
    }
    public void start_operation(double time_left_evalution, Doctor doc1, Patient pat1)
            // in the fututure create people class that doctor and patient are inherit in to add
            // unlimited/ undefined shape of people to operation (mabey two doctors and not just one for example)
    {
        // get the doctor and patient for this operation
        this.doc1 = doc1;
        this.pat1 = pat1;

        this.time_left_evalution = time_left_evalution;
        this.Is_available = false;
    }

    public Specialization canOperateOn(Doctor d)
    {
        for(Specialization s:this.specialities_array)
        {
            for(Specialization s2:d.getSpecialities_array()) {
                if (s.getSpec_name().equals(s2.getSpec_name())&&s.getPatient_array_list().size()>0)
                    return s2;
            }
        }
        return null;
    }
    public boolean specinSpecialities(Specialization s1)
    {
        for(Specialization s:this.specialities_array)
        {
                if (s.getSpec_name().equals(s1.getSpec_name()))
                    return true;

        }
        return false;
    }


    public int getPriority()// by the number of specs you treat. the more the less its less urgent to put you with patient because you can treat more kinds
    {

        int c = 0;
        for(Specialization s:this.specialities_array)
        {
            c++;

        }
        return c;

    }

    public String getRoom_id() {
        return this.room_id;
    }

    public boolean isIs_available() {
        return Is_available;
    }

    public double getTime_left_evalution() {
        return time_left_evalution;
    }

    public Specialization [] getSpecialities_array() {
        return specialities_array;
    }

    public Doctor getDoc1() {
        return doc1;
    }

    public Patient getPat1() {
        return pat1;
    }


    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public void setIs_available(boolean is_available) {
        Is_available = is_available;
    }

    public void setTime_left_evalution(int time_left_evalution) {
        this.time_left_evalution = time_left_evalution;
    }

    public void setSpecialities_array(Specialization [] specialities_array) {
        this.specialities_array = specialities_array;
    }

    public void setDoc1(Doctor doc1) {
        this.doc1 = doc1;
    }

    public void setPat1(Patient pat1) {
        this.pat1 = pat1;
    }

    @Override
    public String toString() {
        return "room id: "+ room_id;
//        return "OperatingRoom{" +
//                "room_id='" + room_id + '\'' +
//                ", Is_available=" + Is_available +
//                ", time_left_evalution=" + time_left_evalution +
//                ", specialities_array=" + Arrays.toString(specialities_array) +
//                ", doc1=" + doc1 +
//                ", pat1=" + pat1 +
//                '}';
    }
}
