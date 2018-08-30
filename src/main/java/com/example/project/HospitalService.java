package com.example.project;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;



    public List<Hospital> getAllHospitals(){
        List<Hospital> hospitalList=new ArrayList<>(Arrays.asList(

                new Hospital(1000, "Apollo Hospital", "Chennai", 3.8),

                new Hospital(1001, "Global Hospitals", "Goa", 3.5),

                new Hospital(1002,"Global Hospital","Chennai", 3.5),

                new Hospital(1003,"VCare Hospital","Bangalore", 3)));

        hospitalRepository.findAll().forEach(hospitalList::add);

        return hospitalList;

    }

    public Hospital getHospital(int id){
        List<Hospital> hospitalList = getAllHospitals();
        return hospitalList.stream().filter(c->c.getId()==(id)).findFirst().get();

    }

    public void addHospital(Hospital hospital){
        getAllHospitals().add(hospital);
    }

    public void updateHospital(Hospital hospital){
        Hospital hs = getHospital(hospital.getId());
        hs.setName(hospital.getName());
        hs.setCity(hospital.getCity());
        hs.setRating(hospital.getRating());
    }

    public void deleteHospital(Hospital hospital) {
        List<Hospital> hospitalList = getAllHospitals();
        hospitalList.removeIf((Hospital x)->x.getId()==(hospital.getId()));
    }
}
