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

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public boolean isIs_available() {
        return Is_available;
    }

    public ArrayList<Specialization> getSpecialities_array() {
        return specialities_array;
    }

    public String getCurrent_room_id() {
        return current_room_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIs_available(boolean is_available) {
        Is_available = is_available;
    }

    public void setSpecialities_array(ArrayList<Specialization> specialities_array) {
        this.specialities_array = specialities_array;
    }

    public void setCurrent_room_id(String current_room_id) {
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
