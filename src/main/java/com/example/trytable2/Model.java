package com.example.trytable2;

import java.util.*;

public class Model
{
    // all specs:
    Specialization n = new Specialization("Neurosurgery");
    Specialization p = new Specialization("Pediatric_surgery");
    Specialization c = new Specialization("Card_surgery");
    Specialization v = new Specialization("Vascular_surgery");
    private static ArrayList<Specialization> specs;//ArrayList for every kind of specialization
    private static ArrayList<OperatingRoom > oprooms;//ArrayList for every OperatingRoom
    private static RecoveryRoom recoveryRoom; //one RecoveryRoom in project

    private static ArrayList<Doctor > doctors;//ArrayList for every OperatingRoom
    public Model()
    {
        // init the ArrayLists:
       this.specs = new ArrayList<Specialization>();
       this.oprooms = new ArrayList<OperatingRoom>();
       this.doctors = new ArrayList<Doctor>();

    }

    /*
        definitions for the main objects in project: all the Specializations, Doctors, Patients, Rooms
        - define the structs and data structures
         */

    /**
     *
     * @return
     */
    public  ArrayList<Specialization>  StartModel() // put values in all patients, doctors rooms and structures
    {

        //create object for every kind of specilization:
//        Specialization n = new Specialization("Neurosurgery");
//        Specialization p = new Specialization("Pediatric_surgery");
//        Specialization c = new Specialization("Card_surgery");
//        Specialization v = new Specialization("Vascular_surgery");
        // Patient(String name, String id, int waiting_time, int severity_before, int urgency_level, Specialization spec_needed) {

        //---------------------------------------------------------------------------
        // create all patients:
        Patient a = new Patient("a","1",0,1,"Neurosurgery");
        Patient b = new Patient("b","2",1,2,"Pediatric_surgery");
        Patient f = new Patient("c","3",2,3,"Card_surgery");
        Patient d = new Patient("d","4",3,4,"Vascular_surgery");

        Patient e = new Patient("e","0",4,5,"Vascular_surgery");
        Patient e1 = new Patient("e1","1",4,5,"Vascular_surgery");
        Patient e2 = new Patient("e2","2",1,5,"Vascular_surgery");
        Patient e3 = new Patient("e3","3",4,5,"Vascular_surgery");
        Patient e4 = new Patient("e4","1",4,5,"Vascular_surgery");
        Patient e5 = new Patient("e1","2",1,5,"Vascular_surgery");
        Patient e6 = new Patient("e2","19",4,5,"Vascular_surgery");
        Patient e7 = new Patient("e3","1",4,5,"Vascular_surgery");
        Patient e8 = new Patient("e4","2",4,5,"Vascular_surgery");

        // add patients to their aproppriate spec needed:
        n.getPatient_queue().add(a);
        p.getPatient_queue().add(b);
        c.getPatient_queue().add(f);
        v.getPatient_queue().add(d);
        v.getPatient_queue().add(e);
        v.getPatient_queue().add(e1);
        v.getPatient_queue().add(e2);
        v.getPatient_queue().add(e3);
        v.getPatient_queue().add(e4);

        // add all specs to the ArrayList
        this.specs.add(n);
        this.specs.add(p);
        this.specs.add(c);
        this.specs.add(v);


//        OperatingRoom op1 = new OperatingRoom();
//        OperatingRoom op2 = new OperatingRoom();
//        OperatingRoom op3 = new OperatingRoom();
//        OperatingRoom op4 = new OperatingRoom();
//        // add specialities to specialities_array in OperatingRooms
//        op1.getSpecialities_array().add(n); // add Neurosurgery
//        op1.getSpecialities_array().add(v);// add Vascular_surgery
//
//        op2.getSpecialities_array().add(p); // add Pediatric_surgery
//        op2.getSpecialities_array().add(c);// add Card_surgery
//
//        op3.getSpecialities_array().add(c); // add Card_surgery
//        op4.getSpecialities_array().add(n); // add Neurosurgery

        // add all OperatingRooms to oprooms(array list of all OperatingRooms)
//        this.oprooms.add(op1);
//        this.oprooms.add(op1);
//        this.oprooms.add(op1);
//        this.oprooms.add(op1);

//-------------------------------------------------------------------------------

        //create the RecoveryRooms

        // init ArrayList:
        this.recoveryRoom = new RecoveryRoom();

        // adding patients to the recovery room that will be in the beginning :

        Patient p7 = new Patient("e3","1",4,-1,"Vascular_surgery");
        Patient p8 = new Patient("e4","222",4,-1,"Neurosurgery");
        Patient p77 = new Patient("e33","12",22,-1,"Pediatric_surgery");
        Patient p87 = new Patient("e43","22",4,-1,"Neurosurgery");

        //  add all Resting_patients to recoveryRoom
        this.recoveryRoom.getResting_patients().add(p7);
        this.recoveryRoom.getResting_patients().add(p8);
        this.recoveryRoom.getResting_patients().add(p77);
        this.recoveryRoom.getResting_patients().add(p87);


        //--------------------------------------------------------
        //create the doctors objects

        Doctor d1 = new Doctor("zohar","1",true,"-1");
        Doctor d2 = new Doctor("zohar2","2",true,"-1");
        Doctor d3 = new Doctor("zohar3","3",true,"-1");
        Doctor d4 = new Doctor("zohar4","4",true,"-1");
        Doctor d5 = new Doctor("zohar5","5",true,"-1");

        //add doctors objects to arraylist of doctors
        this.doctors.add(d1);
        this.doctors.add(d2);
        this.doctors.add(d3);
        this.doctors.add(d4);
        this.doctors.add(d5);


        d1.getSpecialities_array().add(v);
        v.getDoctors_with_spec().add(d1);





        // try diffrent way: add doctors to a spec:
        n.getDoctors_with_spec().add(d1);
        n.getDoctors_with_spec().add(d2);
        n.getDoctors_with_spec().add(d3);
        n.getDoctors_with_spec().add(d4);
        v.getDoctors_with_spec().add(d5);
//----------------------------------------------------------------------

        // same with OperatingRooms:
        ArrayList<Specialization> specsforrooms = new ArrayList<>();
        specsforrooms.add(n);
        OperatingRoom r1 = new  OperatingRoom (specsforrooms);
        specsforrooms.add(v);
        specsforrooms.add(c);
        OperatingRoom r2 = new  OperatingRoom (specsforrooms);
        specsforrooms.remove(n);
        OperatingRoom r3 = new  OperatingRoom (specsforrooms);
        n.getOperatingRooms_with_spec().add(r1);
        n.getOperatingRooms_with_spec().add(r2);

        v.getOperatingRooms_with_spec().add(r3);
        v.getOperatingRooms_with_spec().add(r2);

        c.getOperatingRooms_with_spec().add(r2);
        c.getOperatingRooms_with_spec().add(r3);





        r1.getSpecialities_array().add(v);
        r1.getSpecialities_array().add(n);
        r1.getSpecialities_array().add(c);
        r1.getSpecialities_array().add(p);
        r2.getSpecialities_array().add(n);

        v.getOperatingRooms_with_spec().add(r1);
        n.getOperatingRooms_with_spec().add(r1);
        c.getOperatingRooms_with_spec().add(r1);
        p.getOperatingRooms_with_spec().add(r1);
        n.getOperatingRooms_with_spec().add(r2);




        return(this.specs);
       // ;//,this.O,recoveryRoom);
    }

    public ArrayList<OperatingRoom > retOprooms()
    {
        return this.oprooms;
    }
    public RecoveryRoom retRecoveryRoom()
    {
        return this.recoveryRoom;
    }
    public  ArrayList<Doctor> retDoctors()

    {
        return this.doctors;
    }
//    public void galeSheplyAlgoritem()
//    {
//
//    }




// functions I need to add to try gui and model
    // gui
            // show tables for the operatingrooms, for the resting room after surgery. title for each table in specilization
            // updatetable -   for every single table in gui create apropriate function. in the functoin clear table and new insertions
            //
    // model
            // finish the function galeSheplyAlgoritem and maybe make an array of available doctors to make it simple
            // sortpatientqueue -   for every single queue in specilizations


















//    public class OperatingRoomScheduler {
//
//        // Define data structures for patients, doctors, and operating rooms
//        PriorityQueue<Patient> patientQueue;
//        ArrayList<Doctor> doctorList;
//        ArrayList<OperatingRoom> roomList;
//
//        // Constructor to initialize the scheduler with the input data
//        public OperatingRoomScheduler(PriorityQueue<Patient> patients, ArrayList<Doctor> doctors, ArrayList<OperatingRoom> rooms) {
//            patientQueue = patients;
//            doctorList = doctors;
//            roomList = rooms;
//        }

        // Method to run the scheduling algorithm

    // i do in the begining in order from the most urgent spec to less
        public void schedule(Specialization s) {
            // Create maps to keep track of the current assignments of patients, doctors, and rooms
            Map<Patient, Doctor> patientDoctorMap = new HashMap<>();
            Map<Patient, OperatingRoom> patientRoomMap = new HashMap<>();
            Map<Doctor, Set<Patient>> doctorPatientMap = new HashMap<>();
            Map<OperatingRoom, Set<Patient>> roomPatientMap = new HashMap<>();

            // Initialize the sets of unmatched patients, doctors, and rooms

            Set<Patient> unmatchedPatients = new HashSet<>(s.getPatient_queue()); // take for example the  patients queue
            Set<Doctor> unmatchedDoctors = new HashSet<>(s.getDoctors_with_spec()); //
            Set<OperatingRoom> unmatchedRooms = new HashSet<>(s.getOperatingRooms_with_spec());//v


            // Set maximum number of iterations as the total number of patients, doctors, and rooms
            int maxIterations = unmatchedPatients.size() + unmatchedDoctors.size() + unmatchedRooms.size();

            // Keep track of the number of iterations
            int numIterations = 0;

            // While there are still unmatched patients, doctors, and rooms and maximum iterations not exceeded

            while (!unmatchedPatients.isEmpty() && !unmatchedDoctors.isEmpty() && !unmatchedRooms.isEmpty()  && numIterations < maxIterations) {
                // For each unmatched patient, find the doctor and room with the highest priority that is available

                Iterator<Patient> patientIterator = unmatchedPatients.iterator();
                numIterations++;

                while (patientIterator.hasNext()) {
                    Patient patient = patientIterator.next();
                    Doctor doctor = null;
                    OperatingRoom room = null;
                    int maxPriority = Integer.MIN_VALUE;
                    for (Doctor d : unmatchedDoctors) {
                        if (d.canOperateOn(patient) && d.getPriority() > maxPriority) {
                            maxPriority = d.getPriority();
                            doctor = d;
                        }
                    }
                    for (OperatingRoom r : unmatchedRooms) {
                        if (r.canOperateOn(patient) && r.getPriority() > maxPriority) {
                            maxPriority = r.getPriority();
                            room = r;
                        }
                    }
                    // If a matching doctor and room are found, assign the patient to them
                    if (doctor != null && room != null) {
                        patientDoctorMap.put(patient, doctor);
                        patientRoomMap.put(patient, room);
                        if (!doctorPatientMap.containsKey(doctor)) {
                            doctorPatientMap.put(doctor, new HashSet<>());
                        }
                        doctorPatientMap.get(doctor).add(patient);
                        if (!roomPatientMap.containsKey(room)) {
                            roomPatientMap.put(room, new HashSet<>());
                        }
                        roomPatientMap.get(room).add(patient);
                        patientIterator.remove(); // remove using the iterator
                        unmatchedDoctors.remove(doctor);
                        unmatchedRooms.remove(room);
                    }
                }
                for (Patient patient : s.getPatient_queue()) {
                    Doctor doctor = patientDoctorMap.get(patient);
                    OperatingRoom room = patientRoomMap.get(patient);
                    if(doctor!=null &&patient!=null &&room!=null )
                        System.out.println("Patient " + patient.getId() + " is assigned to Doctor " + doctor.getId() + " in Room " + room.getRoom_id());


                }
            }


            // Print the final assignments

        }


//    class Patient implements Comparable<Patient> {
//        private int id;
//        private int priority;
//
//        public Patient(int id, int priority) {
//            this.id = id;
//            this.priority = priority;
//        }
//
//        public int getId() {
//            return id;
//        }
//
//        public int getPriority() {
//            return priority;
//        }
//    class Patient implements Comparable<Patient> {
//        private int id;
//        private int priority;
//        private ArrayList<String> requiredSpecialties;
//        private int duration;
//
//        public Patient(int id, int priority, ArrayList<String> requiredSpecialties, int duration) {
//            this.id = id;
//            this.priority = priority;
//            this.requiredSpecialties = requiredSpecialties;
//            this.duration = duration;
//        }
//
//        public int getId() {
//            return id;
//        }
//
//        public int getPriority() {
//            return priority;
//        }
//
//        public ArrayList<String> getRequiredSpecialties() {
//            return requiredSpecialties;
//        }
//
//        public int getDuration() {
//            return duration;
//        }
//
//        // Define the compareTo method to compare patients by priority
//        @Override
//        public int compareTo(Patient other) {
//            return Integer.compare(other.priority, this.priority);
//        }
//    }


//class Patient implements Comparable<Patient> {
//    private int id;
//    private int priority;
//    private ArrayList<String> requiredSpecial


































    // 5 seconds to sorting
    // i must to
    // i can work with iterator but i dont


}
