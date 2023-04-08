package com.example.trytable2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Model
{
    // all specs:
    static Specialization n = new Specialization("Neurosurgery");
    static Specialization p = new Specialization("Pediatric_surgery");
    static Specialization c = new Specialization("Card_surgery");
    static Specialization v = new Specialization("Vascular_surgery");

    static ArrayList<Specialization> specs;//ArrayList for every kind of specialization
    static ArrayList<OperatingRoom > operatingRooms;//ArrayList for every OperatingRoom
    static RecoveryRoom recoveryRoom; //one RecoveryRoom in project

    static ArrayList<Doctor > doctors;//ArrayList for every OperatingRoom


    public Model()
    {
        // init the ArrayLists:
       this.specs = new ArrayList<Specialization>();
       this.operatingRooms = new ArrayList<OperatingRoom>();
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



    public Specialization StrToSpec(String specializationStr) {


        Specialization specialization = new Specialization("");
        if (specializationStr.equals("c")) {
            specialization = c;
        } else if (specializationStr.equals("p")) {
            specialization = p;
        } else if (specializationStr.equals("n")) {
            specialization = n;
        } else if (specializationStr.equals("v")) {
            specialization = v;
        }
        return specialization;
    }


    /**
     * this function init the Hospital by reading all the objects of Doctors, Operating Rooms and Patients from the Information file "HospitalInfo.txt" and adding them to
     * the relevant data structure. It also adds all the specializations to an arraylist.
     * It has no parameters and no returns.
     */
    public void InitHospital()
    {

//        ArrayList<OperatingRoom> operatingRooms = new ArrayList<OperatingRoom>();
//        ArrayList<Doctor> doctors = new ArrayList<Doctor>();

        // lets set max specs can be treated just for comfort of reading the file: 2
        try {
            File file = new File("C:\\Users\\User\\IdeaProjects\\trytable2\\src\\main\\java\\com\\example\\trytable2\\HospitalInfo.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("OperatingRoom")) {
                    String[] data = line.split(",");
                    if (data.length == 3) {
                        OperatingRoom operatingRoom = new OperatingRoom(new Specialization[]{StrToSpec(data[1]), StrToSpec(data[2])});
                        operatingRooms.add(operatingRoom);
                    } else {
                        OperatingRoom operatingRoom = new OperatingRoom(new Specialization[]{StrToSpec(data[1])});
                        operatingRooms.add(operatingRoom);
                    }
                } else if (line.contains("Doctor")) {
                    String[] data = line.split(",");
                    if (data.length == 7) {
                        Doctor doctor = new Doctor(data[1], data[2], Boolean.valueOf(data[3]), data[4], new Specialization[]{StrToSpec(data[5]), StrToSpec(data[6])});
                        doctors.add(doctor);
                    } else {
                        Doctor doctor = new Doctor(data[1], data[2], Boolean.valueOf(data[3]), data[4], new Specialization[]{StrToSpec(data[5])});
                        doctors.add(doctor);
                    }
                } else if (line.contains("Patient")) {
                    String[] data = line.split(",");
                    if (data.length == 6) {
                        Patient patient = new Patient(data[1], data[2], Double.parseDouble(data[3]), Double.parseDouble(data[4]), StrToSpec(data[5]));
                        Specialization s = patient.getSpec_needed();
                        s.getPatient_queue().add(patient);
                    }
                    else
                    {

                        System.out.println("cant");
                    }

                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: HospitalInfo.txt file not found.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format in the HospitalInfo.txt file.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error: An unexpected error occurred while reading the HospitalInfo.txt file.");
            e.printStackTrace();
        }



        System.out.println("Doctors:");
        for (Doctor doc : doctors) {
            System.out.println("- " + doc.toString());
        }

        System.out.println("Operating Rooms:");
        for (OperatingRoom room : operatingRooms) {
            System.out.println("- " + room);
        }
// print patients
        System.out.println("\n V Patients:");
        for (Patient patient : v.getPatient_queue()) {
            System.out.println("- " + patient.toString());
        }
        System.out.println("\n N Patients:");
        for (Patient patient : n.getPatient_queue()) {
            System.out.println("- " + patient.toString());
        }
        System.out.println("\n C Patients:");
        for (Patient patient : c.getPatient_queue()) {
            System.out.println("- " + patient.toString());
        }
        System.out.println("\n P Patients:");
        for (Patient patient : p.getPatient_queue()) {
            System.out.println("- " + patient.toString());
        }

        this.specs.add(n);
        this.specs.add(p);
        this.specs.add(c);
        this.specs.add(v);
    }

    public  ArrayList<Specialization>  StartModel() throws IOException // put values in all patients, doctors rooms and structures
    {








        //---------------------------------------------------------------------------
        // create all patients:

//
//        // add patients to their aproppriate spec needed:
//        n.getPatient_queue().add(a);
//        p.getPatient_queue().add(b);
//        c.getPatient_queue().add(f);
//        v.getPatient_queue().add(d);
//        v.getPatient_queue().add(e);
//        v.getPatient_queue().add(e1);
//        v.getPatient_queue().add(e2);
//        v.getPatient_queue().add(e3);
//        v.getPatient_queue().add(e4);
//
//        // add all specs to the ArrayList
//        this.specs.add(n);
//        this.specs.add(p);
//        this.specs.add(c);
//        this.specs.add(v);
//

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
//
//        // init ArrayList:
//        this.recoveryRoom = new RecoveryRoom();
//
//        // adding patients to the recovery room that will be in the beginning :
//
//        Patient p7 = new Patient("e3","1",4,-1,"Vascular_surgery");
//        Patient p8 = new Patient("e4","222",4,-1,"Neurosurgery");
//        Patient p77 = new Patient("e33","12",22,-1,"Pediatric_surgery");
//        Patient p87 = new Patient("e43","22",4,-1,"Neurosurgery");
//
//        //  add all Resting_patients to recoveryRoom
//        this.recoveryRoom.getResting_patients().add(p7);
//        this.recoveryRoom.getResting_patients().add(p8);
//        this.recoveryRoom.getResting_patients().add(p77);
//        this.recoveryRoom.getResting_patients().add(p87);
//

        //--------------------------------------------------------
        //create the doctors objects




//        //add doctors objects to arraylist of doctors
//        this.doctors.add(d1);
//        this.doctors.add(d2);
//        this.doctors.add(d3);
//        this.doctors.add(d4);
//        this.doctors.add(d5);
//
//
//        d1.getSpecialities_array().add(v);
//        v.getDoctors_with_spec().add(d1);




//
//        // try diffrent way: add doctors to a spec:
//        n.getDoctors_with_spec().add(d1);
//        n.getDoctors_with_spec().add(d2);
//        n.getDoctors_with_spec().add(d3);
//        n.getDoctors_with_spec().add(d4);
//        v.getDoctors_with_spec().add(d5);
//----------------------------------------------------------------------

//        // same with OperatingRooms:
//        ArrayList<Specialization> specsforrooms = new ArrayList<>();
//        specsforrooms.add(n);
//        specsforrooms.add(v);
//        specsforrooms.add(c);
//        specsforrooms.remove(n);
//
//        n.getOperatingRooms_with_spec().add(r1);
//        n.getOperatingRooms_with_spec().add(r2);
//
//        v.getOperatingRooms_with_spec().add(r3);
//        v.getOperatingRooms_with_spec().add(r2);
//
//        c.getOperatingRooms_with_spec().add(r2);
//        c.getOperatingRooms_with_spec().add(r3);
//
//
//
//
//
//        r1.getSpecialities_array().add(v);
//        r1.getSpecialities_array().add(n);
//        r1.getSpecialities_array().add(c);
//        r1.getSpecialities_array().add(p);
//        r2.getSpecialities_array().add(n);
//
//        v.getOperatingRooms_with_spec().add(r1);
//        n.getOperatingRooms_with_spec().add(r1);
//        c.getOperatingRooms_with_spec().add(r1);
//        p.getOperatingRooms_with_spec().add(r1);
//        n.getOperatingRooms_with_spec().add(r2);




        return(this.specs);
       // ;//,this.O,recoveryRoom);
    }

    public ArrayList<OperatingRoom > retOprooms()
    {
        return this.operatingRooms;
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
        Set<Patient> unmatchedPatients = new HashSet<>(s.getPatient_queue());
        Set<Doctor> unmatchedDoctors = new HashSet<>(s.getDoctors_with_spec());
        Set<OperatingRoom> unmatchedRooms = new HashSet<>(s.getOperatingRooms_with_spec());

        // Create heaps to efficiently find the doctors and operating rooms with the highest priority for each patient
        PriorityQueue<Doctor> doctorHeap = new PriorityQueue<>(Comparator.comparingInt(Doctor::getPriority).reversed());
        PriorityQueue<OperatingRoom> roomHeap = new PriorityQueue<>(Comparator.comparingInt(OperatingRoom::getPriority).reversed());
        doctorHeap.addAll(unmatchedDoctors);
        roomHeap.addAll(unmatchedRooms);

        // While there are still unmatched patients, doctors, and rooms
        while (!unmatchedPatients.isEmpty() && !doctorHeap.isEmpty() && !roomHeap.isEmpty()) {
            // For each unmatched patient, find the doctor and room with the highest priority that is available
            Iterator<Patient> patientIterator = unmatchedPatients.iterator();
            while (patientIterator.hasNext()) {
                Patient patient = patientIterator.next();
                Doctor doctor = doctorHeap.peek();
                OperatingRoom room = roomHeap.peek();
                if (doctor.canOperateOn(patient) && room.canOperateOn(patient)) {
                    // If a matching doctor and room are found, assign the patient to them
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
                    patientIterator.remove();
                    doctorHeap.poll();
                    roomHeap.poll();
                }
            }
            // Print the final assignments
//            for (Patient patient : s.getPatient_queue()) {
//                Doctor doctor = patientDoctorMap.get(patient);
//                OperatingRoom room = patientRoomMap.get(patient);
//                if (doctor != null && patient != null && room != null) {
//                    System.out.println("Patient " + patient.getId() + " is assigned to Doctor " + doctor.getId() + " in Room " + room.getRoom_id());
//                }
//            }

        }
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
