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
     static RecoveryRoom recoveryRoom; //ignore. not relevant

    static ArrayList<Doctor> doctors;//ArrayList for every OperatingRoom
    static ArrayList<Doctor> availDoctors = new ArrayList() ;//ArrayList for every OperatingRoom

    static ArrayList<OperatingRoom> availOpRooms= new ArrayList() ;//ArrayList for every OperatingRoom

    Presenter presenter;
    private static ArrayList<Surgery> surgeries = new ArrayList<>();


    /**
     * constructor
     */
    public Model()
    {
        // init the ArrayLists:
       this.specs = new ArrayList<Specialization>();
       this.operatingRooms = new ArrayList<OperatingRoom>();
       this.doctors = new ArrayList<Doctor>();
        this.presenter = new Presenter(this);
    }

    public static ArrayList<Surgery> getSurgeries() {
        return surgeries;
    }

    public static void setSurgeries(ArrayList<Surgery> surgeries) {
        Model.surgeries = surgeries;
    }


    /**
     *
     * @param specializationStr - String.
     * @return the specialization the apripriate to string
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

    /**
     *
     * @param room - OperatingRoom room
     * @param s - Specialization s
     * @return if spec in specialization array
     */
    public boolean SpecinRoomSpecArr(OperatingRoom room, Specialization s)
    {
        int counter = 0;
        //run until speciality found or until counter = room.getSpecialities_array()
        while(counter!=room.getSpecialities_array().length&&s!=room.getSpecialities_array()[counter])
        {
            counter++;
        }
        if(counter==room.getSpecialities_array().length)
            return false;
        else
            return true;
    }

    /**
     *
     * @param doc - Doctor doc
     * @param s - Specialization s
     * @return - if spec in specialization array
     */
    public boolean SpecinDocSpecArr(Doctor doc, Specialization s)
    {
        int counter = 0;
        //run until speciality found or until counter = doc.getSpecialities_array()
        while(counter!=doc.getSpecialities_array().length&&s!=doc.getSpecialities_array()[counter])
        {
            counter++;
        }
        if(counter==doc.getSpecialities_array().length)
            return false;
        else
            return true;
    }

    /**
     * read the info from HospitalInfo.txt file and put the objects that in it in the project structures.
     */
    public void InitHospital()
    {

//        ArrayList<OperatingRoom> operatingRooms = new ArrayList<OperatingRoom>();
//        ArrayList<Doctor> doctors = new ArrayList<Doctor>();

        // lets set max specs can be treated just for comfort of reading the file: 2
        try {
            File file = new File("C:\\Users\\User\\IdeaProjects\\trytable2\\src\\main\\java\\com\\example\\trytable2\\HospitalInfo.txt");
            Scanner scanner = new Scanner(file);
            // while there is next line in file read the line information
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
                        s.getPatient_array_list().add(patient);
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
        for (Patient patient : v.getPatient_array_list()) {
            System.out.println("- " + patient.toString());
        }
        System.out.println("\n N Patients:");
        for (Patient patient : n.getPatient_array_list()) {
            System.out.println("- " + patient.toString());
        }
        System.out.println("\n C Patients:");
        for (Patient patient : c.getPatient_array_list()) {
            System.out.println("- " + patient.toString());
        }
        System.out.println("\n P Patients:");
        for (Patient patient : p.getPatient_array_list()) {
            System.out.println("- " + patient.toString());
        }

        this.specs.add(n);
        this.specs.add(p);
        this.specs.add(c);
        this.specs.add(v);

        searchAvail();

    }

    /**
     *
     * @return ArrayList<Specialization> specs that contains the four specialities.
     * @throws IOException
     */
    public  ArrayList<Specialization>  StartModel() throws IOException // put values in all patients, doctors rooms and structures
    {

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




    /**
     * ignore. not relevant.
     * @return
     */
    public boolean SearchSpecInRooms()
    {
        return true;//!!!!!!!1!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }

    /**
     * search availiable doctors and operating rooms and put them in the structures of the availiable.
     */
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

    /**
     * schedule the Operating rooms, Doctors an patients to the surgeries while considering the specialization, urgency  and waiting time in patient and
     * number of specialization in rooms and doctors.
     * also calling to the sorting the heaps of them.
     */
    public void schedule()
    {

        sortDoctorHeapBySpecialityLength();

        int doctorCounter = 0;
        // while the terms of availiability of rooms,doctors,patients allow to do surgery
        while (doctorCounter < availDoctors.size() && (v.getPatient_array_list().size() > 0 || c.getPatient_array_list().size() > 0 ||
                p.getPatient_array_list().size() > 0 || n.getPatient_array_list().size() > 0) && !availDoctors.isEmpty() && !availOpRooms.isEmpty()) {//


            sortRoomHeapBySpecialityLength();


            if (availDoctors.get(doctorCounter).isIs_available() == true) {
                Doctor d1 = availDoctors.get(doctorCounter);
                int i = 0;
                boolean flagf = false;
                //search and connect availiable oproom to doctor while not finish seraching in
                // avail oproooms and an aproppriate patient and room not found
                while (flagf == false&&i < availOpRooms.size() ) {
                    for(Specialization s:specs )
                        sortPatientCollection(s);

                    if ( availOpRooms.get(i).isIs_available() == true) {//
                        OperatingRoom op = availOpRooms.get(i);


                        Specialization specConnect = null;
                        specConnect = op.canOperateOn(d1);
                        Patient chosenP = null;
                        if (specConnect != null && specConnect.getPatient_array_list().size() > 0) {
                            chosenP = specConnect.getPatient_array_list().get(0);
                        }
                        if (specConnect != null&&d1.getSpecialities_array().length>0&&d1.getSpecialities_array()[0].getPatient_array_list().size() > 0) {

                            // search the most urgent patient from each spec the doctors and rooms can treat
                            for (Specialization s : specs)
                            {
                                if (s.getPatient_array_list().size() > 0&&s.getPatient_array_list().get(0).getUrgency_level() > specConnect.getPatient_array_list().get(0).getUrgency_level()&&op.specinSpecialities(s)&& d1.specinSpecialities(s)) {
                                    specConnect = s;
                                    chosenP = specConnect.getPatient_array_list().get(0);
                                }
                            }


                        }

                        if (chosenP != null)// if appropriate and most urgent patient found
                        {
                            Specialization spec2 = chosenP.getSpec_needed();
                            d1.setIs_available(false);
                            d1.setCurrent_room_id(op.getRoom_id());
                           // availDoctors.remove(d1);
                            op.surgery(d1, chosenP);
                            presenter.showSurgInView(d1,chosenP,op);

                            op.setIs_available(false);

                            spec2.getPatient_array_list().remove(chosenP);

                            flagf = true;

                        }
                    }
                    i++;

                }

            }
            doctorCounter++;

        }
        // for every surgery reduce in 1 the time_left and set doctors Oproom to availiable if time_left<=0
        for(Surgery s :surgeries)
        {
            s.setTime_left(Double.toString(Double.parseDouble(s.getTime_left())-1));
            if(Double.parseDouble(s.getTime_left())<=0) {
                s.setTime_left(Double.toString(0.0));
                s.getDoctor().setIs_available(true);
                s.getRoom().setIs_available(true);


            }
        }

    }


    /**
     *
     * @param - Speicalization  spec
     * sorting by considering severity in patient and waiting time and.
     */
    public void sortPatientCollection(Specialization spec) {
        //ArrayList<Patient> patientList = spec.getPatient_array_list();
        Collections.sort(spec.getPatient_array_list(), new Comparator<Patient>() {
            @Override
            public int compare(Patient p1, Patient p2) {
                double p1Urgency = p1.getUrgency_level();
                double p2Urgency = p2.getUrgency_level();
                double p1Time = p1.getEstimated_surgery_time();
                double p2Time = p2.getEstimated_surgery_time();


                int result = 0;

                if (p1Urgency > p2Urgency) {
                    result = -1;
                } else if (p1Urgency < p2Urgency) {
                    result = 1;
                } else if (Math.abs(p1.getSeverity_before() - p2.getSeverity_before()) < 2 && p1Time > p2Time && (p1Time - p2Time) >= 10) {
                    result = 1;
                } else if (Math.abs(p1.getSeverity_before() - p2.getSeverity_before()) < 2 && p1Time < p2Time && (p2Time - p1Time) >= 10) {
                    result = -1;
                } else {// if equal
                    result = Double.compare(p1Time, p2Time);
                }

                return result;

            }
        });
    }


    /**
     * sort doctor heap by specialities number
     */
    public void sortDoctorHeapBySpecialityLength() {
        int n = availDoctors.size();
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyDoctorsBySpecialityLength(availDoctors, n, i);
        }
        for (int i = n - 1; i > 0; i--) {// this part try to "lehavtih et hamiyun" but it doesnt seems necesery
            Doctor temp = availDoctors.get(0);
            availDoctors.set(0, availDoctors.get(i));
            availDoctors.set(i, temp);
            heapifyDoctorsBySpecialityLength(availDoctors, i, 0);
        }
    }


    /**
     * heapify on  doctor heap by specialities number
     * @param heap -
     * @param n -
     * @param i -
     */
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


    /**
     * sort Operating rooms heap by specialities number
     */
    public void sortRoomHeapBySpecialityLength() {
        int n = availOpRooms.size();
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyRoomsBySpecialityLength(availOpRooms, n, i);
        }
        for (int i = n - 1; i > 0; i--) {// this part try to "lehavtih et hamiyun" but it doesnt seems necesery
            OperatingRoom temp = availOpRooms.get(0);
            availOpRooms.set(0, availOpRooms.get(i));
            availOpRooms.set(i, temp);
            heapifyRoomsBySpecialityLength(availOpRooms, i, 0);
        }


    }
    /**
     * heapify on  Operating rooms heap by specialities number
     */

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




}
