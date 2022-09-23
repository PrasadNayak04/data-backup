package com.robosoft.Insurance.Service;

import com.robosoft.Insurance.Modal.Accident;
import com.robosoft.Insurance.Modal.Car;
import com.robosoft.Insurance.Modal.Participated;
import com.robosoft.Insurance.Modal.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class InsuranceService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    int count=0;
    String query;
    public int getNumberofPerson(String year) {
        query = "select count(distinct driver_id) as Number_Of_Persons from participated p inner join accident a on p.report_number = a.report_number and year(a.accd_date) =  " + year;
        try{
            return jdbcTemplate.queryForObject(query, Integer.class);
        }catch(Exception e){
            System.out.println("Invalid query\n" + e.getSuppressed());
        }
        return -1;
    }

    public int numberOfCarsInvolvedByName(String driverName){
        query = "select count(a.report_number) from accident a inner join participated p on a.report_number = p.report_number inner join person ps on p.driver_id = ps.driver_id and ps.name = \"" + driverName + "\"";
        try{
            return jdbcTemplate.queryForObject(query, Integer.class);
        }catch(Exception e){
            System.out.println("Invalid query\n" + e.getMessage());
        }
        return -1;
    }

    public int updateDamageAmount(String regNumber, int reportNumber, int damageAmount){
        query = "update participated set damage_amount = ? where regno = ? and report_number = ? ";
        try{
            return jdbcTemplate.update(query, damageAmount, regNumber, reportNumber);
        }catch(Exception e){
            System.out.println("Invalid query\n" + e.getMessage());
        }
        return -1;
    }

    public Person personDataById(String driver_id){
        Person person;
        query = "Select * from person where driver_id = \"" + driver_id + "\" ";
        try{
            person = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<Person>(Person.class));
            if(person != null){
                return person;
            }
        }catch(Exception e){
            System.out.println("Invalid query\n" + e.getMessage());
        }
        return null;
    }

    public String addPerson(Person person){
        query = "insert into person values (?,?,?)";
        try{
            jdbcTemplate.update(query, person.getDriver_id(),person.getName(), person.getAddress());
            return "Added successfully";
        }catch(Exception e){
            System.out.println("Invalid query\n" + e.getMessage());
        }
        return "Failed to add";
    }

    public String addCar(Car car){
        query = "insert into car values (?,?,?)";
        try{
            jdbcTemplate.update(query, car.getRegNo(), car.getModel(), car.getYear());
            return "Added successfully";
        }catch(Exception e){
            System.out.println("Invalid query\n" + e.getMessage());
        }
        return "Failed to add";
    }

    public String addAccident(Accident accident){
        query = "insert into accident values(?,?,?)";
        try{
            jdbcTemplate.update(query, accident.getReport_number(), accident.getAcc_date(), accident.getLocation());
            return "Added successfully";
        }catch(Exception e){
            System.out.println("Invalid query\n" + e.getMessage());
        }
        return "Failed to add";
    }

    public String addParticipated(Participated participated){
        query = "insert into accident values(?,?,?,?)";
        try{
            jdbcTemplate.update(query, participated.getDriver_id(), participated.getRegNo(), participated.getReport_number(), participated.getDamage_amount());
            return "Added successfully";
        }catch(Exception e){
            System.out.println("Invalid query\n" + e.getMessage());
        }
        return "Failed to add";
    }




}


