package com.example.trytable2;

import java.util.ArrayList;

public class OperatingRoom
{
    //HashMap<String, Patient> capitalCities;
    private static int room_id = 1;
    private boolean Is_available;
    private int time_left_evalution;// in clock rounds. if availiable: time_left_evalution = 0.
    private ArrayList<Specialization> specialities_array;// dinamic array of specialities the room can treat
    private Doctor doc1;
    // in the future more doctors
    private Patient pat1;

    private String current_doctor_id;// if none then "-1"(in String)
    public OperatingRoom()
    {
        this.time_left_evalution = 0;//
        room_id++;
        this.room_id = room_id;// mispur of operation rooms from 1 to number of rooms
        this.Is_available = true;
        this.time_left_evalution = time_left_evalution;

    }

    public start_opeation(int time_left_evalution, Doctor doc1,Patient pat1)
            // in the fututure create people class that doctor and patient are inherit in to add
            // unlimited/ undefined shape of people to operation (mabey two doctors and not just one for example)
    {
        // get the doctor and patient for this operation
        this.doc1 = doc1;
        this.pat1 = pat1;

        this.time_left_evalution = time_left_evalution;
        boolean Is_available = false;
    }

}
