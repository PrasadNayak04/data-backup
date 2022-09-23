package com.robosoft.Insurance.Controller;

import com.robosoft.Insurance.Modal.Accident;
import com.robosoft.Insurance.Modal.Car;
import com.robosoft.Insurance.Modal.Participated;
import com.robosoft.Insurance.Modal.Person;
import com.robosoft.Insurance.Service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class InsuranceController {

    @Autowired
    private InsuranceService insuranceService;

    //Get the number of drivers involved in accident in a given year
    @GetMapping("/driversinvolved/{year}")
    public int NumberOfDriversInYear(@PathVariable String year){
        return insuranceService.getNumberofPerson(year);
    }

    //Get the number of cars involved in accidents for a given driver
    @GetMapping("/accidentcars/{driverName}")
    public int involvedCarsByName(@PathVariable String driverName){
        return insuranceService.numberOfCarsInvolvedByName(driverName);
    }

    @PutMapping("/updateparticipated/{regNumber}/{reportNumber}/{damageAmount}")
    public int updateParticipate(@PathVariable String regNumber,@PathVariable int reportNumber,@PathVariable int damageAmount){
        return insuranceService.updateDamageAmount(regNumber,reportNumber,damageAmount);
    }

    @GetMapping("personbyid/{driver_id}")
    public Person getPersonDataById(@PathVariable String driver_id){
        return insuranceService.personDataById(driver_id);
    }

    @PostMapping("/saveperson")
    public String addPerson(@RequestBody Person person){
        return insuranceService.addPerson(person);
    }

    @PostMapping("/savecar")
    public String addCar(@RequestBody Car car){
        return insuranceService.addCar(car);
    }

    @PostMapping("/saveaccident")
    public String addAccident(@RequestBody Accident accident) {
        return insuranceService.addAccident(accident);
    }

    @PostMapping("/saveparticipated")
    public String addParticipated(@RequestBody Participated participated) {
        return insuranceService.addParticipated(participated);
    }
}
