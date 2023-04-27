package com.example.trytable2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Doctor {
    private String name;
    private String id;
    private boolean  Is_available;
    private Specialization [] specialities_array;// dinamic array of specialities_array
    private String current_room_id;// has id of operation room which is an integer number//



    public Doctor(String name, String id, boolean is_available,  String current_room_id, Specialization [] specialities_array )
    {
        this.name = name;
        this.id = id;
        Is_available = true;
        this.specialities_array = specialities_array;
        this.current_room_id = current_room_id;
    }

    public boolean canOperateOn(Patient patient) // search if have the spec
    {
        for(Specialization s:this.specialities_array)
        {
            if((s.getSpec_name()).equals(patient.getSpec_needed().getSpec_name()))
                return true;
        }
        return false;
    }

    public int getPriority()// by the number of specs you treat. the more the less its less urgent to put you with patient because you can treat more kinds
    {
//        if(this.specialities_array==null)
//            return -1;
        int c = 0;
        for(Specialization s:this.specialities_array)
        {
            c++;

        }
        return c;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Is_available == doctor.Is_available && name.equals(doctor.name) && id.equals(doctor.id) && Objects.equals(specialities_array, doctor.specialities_array) && current_room_id.equals(doctor.current_room_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, Is_available, specialities_array, current_room_id);
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

    public Specialization [] getSpecialities_array() {
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

    public void setSpecialities_array(Specialization [] specialities_array) {
        this.specialities_array = specialities_array;
    }

    public void setCurrent_room_id(String current_room_id) {
        this.current_room_id = current_room_id;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", Is_available=" + Is_available +
                ", specialities_array=" + Arrays.toString(specialities_array) +
                ", current_room_id='" + current_room_id + '\'' +
                '}';
    }

/*
    -name: String
-id:String
-Is_available:boolean
-specialities[]: dinamic <specialization> array
-current_room: OperatingRoom
    */
}
