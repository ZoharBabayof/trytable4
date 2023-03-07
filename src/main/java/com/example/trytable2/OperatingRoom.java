package com.example.trytable2;

import java.util.ArrayList;

public class OperatingRoom
{
    //HashMap<String, Patient> capitalCities;
    private static int roomcounter=1;
    private int room_id ;
    private boolean Is_available;
    private int time_left_evalution;// in clock rounds. if availiable: time_left_evalution = 0.
    private ArrayList<Specialization> specialities_array;// dinamic array of specialities the room can treat
    private Doctor doc1;
    // in the future more doctors
    private Patient pat1;


    public OperatingRoom()
    {
        this.room_id = roomcounter;
        this.time_left_evalution = 0;//
        roomcounter++;
        this.room_id = room_id;// mispur of operation rooms from 1 to number of rooms
        this.Is_available = true;
        this.time_left_evalution = time_left_evalution;
        this.specialities_array = new ArrayList<Specialization>();

    }

    public void start_operation(int time_left_evalution, Doctor doc1,Patient pat1)
            // in the fututure create people class that doctor and patient are inherit in to add
            // unlimited/ undefined shape of people to operation (mabey two doctors and not just one for example)
    {
        // get the doctor and patient for this operation
        this.doc1 = doc1;
        this.pat1 = pat1;

        this.time_left_evalution = time_left_evalution;
        this.Is_available = false;
    }

    public static int getRoom_id() {
        return room_id;
    }

    public boolean isIs_available() {
        return Is_available;
    }

    public int getTime_left_evalution() {
        return time_left_evalution;
    }

    public ArrayList<Specialization> getSpecialities_array() {
        return specialities_array;
    }

    public Doctor getDoc1() {
        return doc1;
    }

    public Patient getPat1() {
        return pat1;
    }

    public static void setRoom_id(int room_id) {
        OperatingRoom.room_id = room_id;
    }

    public void setIs_available(boolean is_available) {
        Is_available = is_available;
    }

    public void setTime_left_evalution(int time_left_evalution) {
        this.time_left_evalution = time_left_evalution;
    }

    public void setSpecialities_array(ArrayList<Specialization> specialities_array) {
        this.specialities_array = specialities_array;
    }

    public void setDoc1(Doctor doc1) {
        this.doc1 = doc1;
    }

    public void setPat1(Patient pat1) {
        this.pat1 = pat1;
    }
}
