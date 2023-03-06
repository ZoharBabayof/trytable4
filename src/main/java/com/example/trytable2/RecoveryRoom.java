package com.example.trytable2;

import java.util.ArrayList;

public class RecoveryRoom
{
    // also remember to check in the code when arriving to recoveryroom level before put in
    // recovery room if patient
    // need treatment in another Specialization.

    private final int MAX_PATIENTS = 28;
    private static int patients_counter=0;
    private final int WAITING_TIME=30;// 30 rounds of clock
    private ArrayList<Patient> resting_patients;

    // constructor


    public RecoveryRoom()
    {
        this.resting_patients = new ArrayList<Patient>();

    }

    public RecoveryRoom(ArrayList<Patient> resting_patients) {
        this.resting_patients = resting_patients;
    }

    public int getMAX_PATIENTS() {
        return MAX_PATIENTS;
    }

    public static int getPatients_counter() {
        return patients_counter;
    }

    public int getWAITING_TIME() {
        return WAITING_TIME;
    }

    public ArrayList<Patient> getResting_patients() {
        return resting_patients;
    }

    /*
    -final MAX_PATIENTS: int
-patients_counter: int
-WAITING_TIME:int
-patients_rest: dinamic <patient> array
    */
    /*
    -void free_patients()// free all patients who ok
-add_patient_to_room()
*/
}
