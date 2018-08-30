package com.example.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;



@RestController
@RequestMapping("/test/")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;



    @RequestMapping(value = "/hospitals/{id}", method = RequestMethod.GET)

    public @ResponseBody ResponseEntity<Hospital> getHospital(@PathVariable("id") int id) throws Exception {

        Hospital hospital = this.hospitalService.getHospital(id);

        return ResponseEntity.ok().body(hospital);

    }

    @RequestMapping(value = "/hospitals", method = RequestMethod.GET)

    public @ResponseBody List<Hospital> getAllHospitals() throws Exception {

        return this.hospitalService.getAllHospitals();

    }

    @RequestMapping(value = "/hospitals", method = RequestMethod.POST)
    public ResponseEntity<String> addHospital(@RequestBody Hospital hospital  ) {
        this.hospitalService.addHospital(hospital);
        //return this.hospitalService.getAllHospitals();
        return ResponseEntity.ok().body("DONE");
    }

    @RequestMapping(value = "/hospitals", method = RequestMethod.PUT)
    public ResponseEntity<List<Hospital>> updateHospital(@RequestBody Hospital hospital) {

        this.hospitalService.updateHospital(hospital);
        System.out.println(this.hospitalService.getAllHospitals());
        return ResponseEntity.ok().body(this.hospitalService.getAllHospitals());
    }

    @RequestMapping(value = "/hospitals", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteHospital(@RequestBody Hospital hospital) {
        this.hospitalService.deleteHospital(hospital);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }



}
