package com.finalproject.hospital.controller;

import com.finalproject.hospital.domain.Doctor;
import com.finalproject.hospital.domain.Patient;
import com.finalproject.hospital.domain.Schedules;
import com.finalproject.hospital.repository.DoctorRepository;
import com.finalproject.hospital.repository.ScheduleRepository;
import com.finalproject.hospital.repository.PatientRepository;
import com.finalproject.hospital.service.DoctorService;
import com.finalproject.hospital.service.ScheduleService;
import com.finalproject.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    PatientService patientService;

    @Autowired
    ScheduleService scheduleService;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    DoctorService doctorService;

    @Autowired
    DoctorRepository doctorRepository;

    @GetMapping("/")
    public String mainPage() {
        return "main-thyme";
    }

//    ================== registrating patient =====================
    @GetMapping("register-patient")
    public String registerPatient(Model model) {
        model.addAttribute("patient", new Patient());
        return "register-patient-form";
    }
//    ================== /registrating patient =====================

//     =================== processing registration ===================
    @PostMapping("/process_register")
    public String processRegister(Patient patient) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(patient.getPassword());
        patient.setPassword(encodedPassword);
        patientRepository.save(patient);
        return "register-success";
    }
//     =================== /processing registration ===================

    @GetMapping({"/doctor"})
        public ModelAndView getSchedule() {
            ModelAndView mav2 = new ModelAndView("doctor-thyme");
            mav2.addObject("schedules", scheduleRepository.findAll());
            mav2.addObject("patients", patientRepository.findAll());
            return mav2;
        }

        @RequestMapping("/new")
        public String showNewSchedulePage(Model model) {
            Schedules schedules = new Schedules();
            model.addAttribute("schedule", schedules);

            return "new-schedule";
        }

        @RequestMapping("/edit/{id}")
        public ModelAndView showEditSchedulePage(@PathVariable(name = "id") long id) {
            ModelAndView mav = new ModelAndView("editSchedule");
            Schedules schedules = scheduleService.get(id);
            mav.addObject("schedule", schedules);
            return mav;
        }

        @RequestMapping(value = "/save", method = RequestMethod.POST)
        public String saveSchedule(@ModelAttribute("schedule") Schedules schedules) {
            scheduleService.save(schedules);

            return "redirect:/doctor";
        }

        @RequestMapping("/delete/{id}")
        public String deleteSchedule(@PathVariable(name = "id") long id) {
            scheduleService.delete(id);

            return "redirect:/doctor";
        }

        @GetMapping("/pharmacy")
        public String welcomePharmacy() {
            return "pharmacy-thyme";
        }


// ==================================== Patient ===============================================

        @RequestMapping("/editPatient1/{id}")
        public ModelAndView showEditDoctorPage(@PathVariable(name = "id") long id) {
            ModelAndView mav = new ModelAndView("editPatient");
            Patient patient = patientService.get(id);
            mav.addObject("patient", patient);
            return mav;
        }

        @RequestMapping(value = "/savePatient", method = RequestMethod.POST)
        public String savePatient(@ModelAttribute("patient") Patient patient) {
            patientService.save(patient);

            return "redirect:/doctor";
        }

        @RequestMapping("/newPatient")
        public String showNewPatient(Model model) {
            Patient patient = new Patient();
            model.addAttribute("patient", patient);

            return "new-patient";
        }

        @RequestMapping("/deletePatient/{id}")
        public String deletePatient(@PathVariable(name = "id") long id) {
            patientService.delete(id);

            return "redirect:/doctor";
        }
    @GetMapping("/patient")
    public ModelAndView showPatientInfo() {
        ModelAndView mav3 = new ModelAndView("patient");
        mav3.addObject("patients", patientRepository.findAll());
        return mav3;
    }

//        ================== registrating patient =====================
    @GetMapping("register-doctor")
    public String registerDoctor(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "registerdoctor";
    }
//    ================== /registrating patient =====================

//         =================== processing registration ===================
    @PostMapping("/process_register_doctor")
    public String processRegister(Doctor doctor) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(doctor.getPassword());
        doctor.setPassword(encodedPassword);
        doctorService.save(doctor);
        return "register-success";
    }
//     =================== /processing registration ===================


    @RequestMapping(value = "/saveDoctor", method = RequestMethod.POST)
    public String saveDoctor(@ModelAttribute("doctor") Doctor doctor) {
        doctorService.save(doctor);

        return "redirect:/doctor";
    }

}
