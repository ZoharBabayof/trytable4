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
    static ArrayList<OperatingRoom> operatingRooms;//ArrayList for every OperatingRoom
    static RecoveryRoom recoveryRoom; //one RecoveryRoom in project

    static ArrayList<Doctor> doctors;//ArrayList for every OperatingRoom
    static ArrayList<Doctor> availDoctors = new ArrayList() ;//ArrayList for every OperatingRoom

    static ArrayList<OperatingRoom> availOpRooms= new ArrayList() ;//ArrayList for every OperatingRoom



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


    public boolean SpecinRoomSpecArr(OperatingRoom room, Specialization s)
    {
        int counter = 0;
        while(counter!=room.getSpecialities_array().length&&s!=room.getSpecialities_array()[counter])
        {
            counter++;
        }
        if(counter==room.getSpecialities_array().length)
            return false;
        else
            return true;
    }

    public boolean SpecinDocSpecArr(Doctor doc, Specialization s)
    {
        int counter = 0;
        while(counter!=doc.getSpecialities_array().length&&s!=doc.getSpecialities_array()[counter])
        {
            counter++;
        }
        if(counter==doc.getSpecialities_array().length)
            return false;
        else
            return true;
    }

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
            if(SpecinDocSpecArr(doc,n))
                n.getDoctors_with_spec().add(doc);
            if(SpecinDocSpecArr(doc,p))
                p.getDoctors_with_spec().add(doc);
            if(SpecinDocSpecArr(doc,c))
                c.getDoctors_with_spec().add(doc);
            if(SpecinDocSpecArr(doc,v))
                v.getDoctors_with_spec().add(doc);
        }

        System.out.println("Operating Rooms:");
        for (OperatingRoom room : operatingRooms) {
            System.out.println("- " + room);
            if(SpecinRoomSpecArr(room,n))
                n.getOperatingRooms_with_spec().add(room);
            if(SpecinRoomSpecArr(room,p))
                p.getOperatingRooms_with_spec().add(room);
            if(SpecinRoomSpecArr(room,c))
                c.getOperatingRooms_with_spec().add(room);
            if(SpecinRoomSpecArr(room,v))
                v.getOperatingRooms_with_spec().add(room);
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

    // find the spec in rooms
    public boolean SearchSpecInRooms()
    {
        return true;//!!!!!!!1!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }


    public void searchAvail()
    {
        for(Doctor d:doctors)
        {
            if(d.isIs_available())
            {
                availDoctors.add(d);
            }
        }
        for(OperatingRoom op:operatingRooms)
        {
            if(op.isIs_available())
            {
                availOpRooms.add(op);
            }
        }
    }
    public void schedule()
    {

        searchAvail();


        int flag = 0;
        // if something empty stop
        int doctorCounter = 0;

        while (!(v.getPatient_queue().isEmpty() &&c.getPatient_queue().isEmpty() &&p.getPatient_queue().isEmpty() &&n.getPatient_queue().isEmpty()||availDoctors.isEmpty()||availOpRooms.isEmpty())&& flag==0&&doctorCounter<availDoctors.size())
        {
            sortDoctorHeapBySpecialityLength();
            for(int i=0;i<availDoctors.size();i++)
            {
                System.out.println(availDoctors.get(i));

            }
            for(int i=0;i<availOpRooms.size();i++)
            {
                System.out.println(availOpRooms.get(i));

            }
            System.out.println("-------------");
            sortRoomHeapBySpecialityLength();
            Doctor d1 = availDoctors.get(doctorCounter);
            Patient chosenP=null;
            int i = 0;
            boolean flagf = false;
            while(i < availOpRooms.size()&&flagf == false)
            {
                OperatingRoom op = availOpRooms.get(i);
                i++;
                Specialization specConnect = null;
                 specConnect = op.canOperateOn(d1);
                if(specConnect!=null)
                {
                    double maxcalc = d1.getSpecialities_array()[0].getPatient_queue().get(0).getUrgency_level()/d1.getSpecialities_array()[0].getPatient_queue().get(0).getWaiting_time();
                    for(Patient p : specConnect.getPatient_queue())
                    {
                        if ( specConnect.getPatient_queue().get(0).getUrgency_level()/specConnect.getPatient_queue().get(0).getWaiting_time()>=maxcalc)
                        {
                            maxcalc = specConnect.getPatient_queue().get(0).getUrgency_level()/specConnect.getPatient_queue().get(0).getWaiting_time();
                            chosenP = specConnect.getPatient_queue().get(0);
                        }
                    }

                }


                if(chosenP!=null)// if appropriate and most urgent patient found
                {
                    d1.setIs_available(false);
                    availDoctors.remove(d1);
                    op.surgery(d1, chosenP);
                    op.setIs_available(false);
                    availOpRooms.remove(op);
                    flagf = true;

                }
            }


            doctorCounter++;
        }
    }



    public void sortDoctorHeapBySpecialityLength() {
        int n = availDoctors.size();
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyDoctorsBySpecialityLength(availDoctors, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            Doctor temp = availDoctors.get(0);
            availDoctors.set(0, availDoctors.get(i));
            availDoctors.set(i, temp);
            heapifyDoctorsBySpecialityLength(availDoctors, i, 0);
        }
    }

    private void heapifyDoctorsBySpecialityLength(List<Doctor> heap, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && heap.get(left).getSpecialities_array().length > heap.get(largest).getSpecialities_array().length) {
            largest = left;
        }

        if (right < n && heap.get(right).getSpecialities_array().length > heap.get(largest).getSpecialities_array().length) {
            largest = right;
        }

        if (largest != i) {
            Doctor temp = heap.get(i);
            heap.set(i, heap.get(largest));
            heap.set(largest, temp);
            heapifyDoctorsBySpecialityLength(heap, n, largest);
        }
    }

    public void sortRoomHeapBySpecialityLength() {
        int n = availOpRooms.size();
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyRoomsBySpecialityLength(availOpRooms, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            OperatingRoom temp = availOpRooms.get(0);
            availOpRooms.set(0, availOpRooms.get(i));
            availOpRooms.set(i, temp);
            heapifyRoomsBySpecialityLength(availOpRooms, i, 0);
        }
    }

    private void heapifyRoomsBySpecialityLength(List<OperatingRoom> heap, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && heap.get(left).getSpecialities_array().length > heap.get(largest).getSpecialities_array().length) {
            largest = left;
        }

        if (right < n && heap.get(right).getSpecialities_array().length > heap.get(largest).getSpecialities_array().length) {
            largest = right;
        }

        if (largest != i) {
            OperatingRoom temp = heap.get(i);
            heap.set(i, heap.get(largest));
            heap.set(largest, temp);
            heapifyRoomsBySpecialityLength(heap, n, largest);
        }
    }

//
//    public void sortDoctorHeap() {
//        int n = availDoctors.size();
//        for (int i = n / 2 - 1; i >= 0; i--) {
//            heapifyDoctors(availDoctors, n, i);
//        }
//    }
//
//    public void sortRoomHeap() {
//        int n = availOpRooms.size();
//        for (int i = n / 2 - 1; i >= 0; i--) {
//            heapifyRooms(availOpRooms, n, i);
//        }
//    }
//
//    private void heapifyDoctors(List<Doctor> heap, int n, int i) {
//        int largest = i;
//        int left = 2 * i + 1;
//        int right = 2 * i + 2;
//
//
//        if (left < n && calculatePriority(heap.get(left), null) > calculatePriority(heap.get(largest), null)) {
//            largest = left;
//        }
//
//        if (right < n && calculatePriority(heap.get(right), null) > calculatePriority(heap.get(largest), null)) {
//            largest = right;
//        }
//
//        if (largest != i) {
//            Doctor temp = heap.get(i);
//            heap.set(i, heap.get(largest));
//            heap.set(largest, temp);
//            heapifyDoctors(heap, n, largest);
//        }
//    }
//
//    private void heapifyRooms(List<OperatingRoom> heap, int n, int i) {
//        int largest = i;
//        int left = 2 * i + 1;
//        int right = 2 * i + 2;
//
//        if (left < n && calculatePriority(null, heap.get(left)) > calculatePriority(null, heap.get(largest))) {
//            largest = left;
//        }
//
//        if (right < n && calculatePriority(null, heap.get(right)) > calculatePriority(null, heap.get(largest))) {
//            largest = right;
//        }
//
//        if (largest != i) {
//            OperatingRoom temp = heap.get(i);
//            heap.set(i, heap.get(largest));
//            heap.set(largest, temp);
//            heapifyRooms(heap, n, largest);
//        }
//    }
//
//
//    public void sortPatientHeap(Specialization specialization) {
//        int n = specialization.getPatient_queue().size();
//        for (int i = n / 2 - 1; i >= 0; i--) {
//            heapifyPatients(specialization.getPatient_queue(), i);
//        }
//    }
//
//    private void heapifyPatients(List<Patient> patientQueue, int i) {
//        int n = patientQueue.size();
//        int largest = i;
//        int l = 2 * i + 1;
//        int r = 2 * i + 2;
//
//        if (l < n && patientQueue.get(l).getUrgency_level() > patientQueue.get(largest).getUrgency_level()) {
//            largest = l;
//        }
//
//        if (r < n && patientQueue.get(r).getUrgency_level() > patientQueue.get(largest).getUrgency_level()) {
//            largest = r;
//        }
//
//        if (largest != i) {
//            Patient temp = patientQueue.get(i);
//            patientQueue.set(i, patientQueue.get(largest));
//            patientQueue.set(largest, temp);
//
//            heapifyPatients(patientQueue, largest);
//        }
//    }
//
////
////    /**
////     * Calculates the priority of assigning a patient to a given doctor and room. The higher the priority value, the better
////     * the match between the patient, doctor, and room.
////     *
////     * @param doctor the doctor to consider
////     * @param room the room to consider
////     * @return the priority value
////     */
////    private int calculatePriority(Doctor doctor, OperatingRoom room) {
////        int priority = 0;
////        if(room!=null&&doctor!=null) {
////            if (doctor.getSpecialities_array()[0] == room.getSpecialities_array()[0]) {//!!!!!!!!!!!!!!!!!!!!!!!!!!!
////                priority += 2;
////            }
////            if (doctor.isIs_available() && room.isIs_available()) {
////                priority += 1;
////            }
////        }
////            return priority;
////
////    }
//private int calculatePriority(Doctor doctor, OperatingRoom room) {
//    int priority = 0;
//    if(room!=null||doctor!=null) {
//        if (doctor.isIs_available() && room.isIs_available()) {
//            int doctorSpecialitySize = doctor.getSpecialities_array().length;
//            int roomSpecialitySize = room.getSpecialities_array().length;
//            priority = doctor.getPriority() + room.getPriority();
//
//            // Increase priority for doctors and rooms with smaller size of Specialities_array
//            if (doctorSpecialitySize < roomSpecialitySize) {
//                priority += (roomSpecialitySize - doctorSpecialitySize) * 5;
//            } else if (roomSpecialitySize < doctorSpecialitySize) {
//                priority += (doctorSpecialitySize - roomSpecialitySize) * 5;
//            }
//        }
//    }
//    return priority;
//}


    /**
     * An enumeration representing the different specializations of doctors.
     */



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
