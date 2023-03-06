package com.example.trytable2;

import java.util.ArrayList;

public class OperatingRoom
{
    //HashMap<String, Patient> capitalCities;
    private static int room_id = 1;
    private boolean Is_available;
    private int time_left_evalution;// in clock rounds. if availiable: time_left_evalution = 0.
    private ArrayList<Specialization> specialities_array;// dinamic array of specialities the room can treat

    private String current_doctor_id;// if none then "-1"(in String)
    public OperatingRoom(int time_left_evalution, boolean Is_available)
    {
        this.time_left_evalution = time_left_evalution;//
        room_id++;
        this.room_id = room_id;// mispur of operation rooms from 1 to number of rooms
        this.Is_available = Is_available;
        this.time_left_evalution = time_left_evalution;

    }

}
