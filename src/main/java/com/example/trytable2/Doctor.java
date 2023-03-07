package com.example.trytable2;

import java.util.ArrayList;

public class Doctor {
    private String name;
    private String id;
    private boolean  Is_available;
    private ArrayList<Specialization> specialities_array;// dinamic array of specialities_array
    private String current_room_id;// has id of operation room which is an integer number//

    public Doctor(String name, String id, boolean is_available,  String current_room_id)
    {
        this.name = name;
        this.id = id;
        Is_available = true;
        this.specialities_array = new ArrayList<Specialization>();
        this.current_room_id = current_room_id;
    }
/*
    -name: String
-id:String
-Is_available:boolean
-specialities[]: dinamic <specialization> array
-current_room: OperatingRoom
    */
}
