package com.husky.controllers;
import com.husky.entities.FloatingHoliday;
import com.husky.repositories.FloatingHolidayRepository;
import com.husky.entities.Request;
import com.husky.repositories.RequestRepository;
import com.husky.entities.Employee;
import com.husky.repositories.EmployeeRepository;
import com.husky.utils.CsvHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.util.HashMap;
import java.util.Vector;
import javax.inject.Inject;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;



@RestController
public class FloatingHolidayController {

    @Autowired
    private FloatingHolidayRepository floatingHolidayRepository;
    @Inject
    private EmployeeRepository employeeRepository;
    @Inject
    private RequestRepository requestRepository;

    @PostMapping("/registerHolidaysFromCsv")
    public HashMap<String, String > handleFileUpload(@RequestParam("file") MultipartFile file){
       HashMap<String, String> httpStatus;
       httpStatus = new HashMap<String, String>();
       try{
           CsvHandler csvHandler = new CsvHandler(file);
           Vector<FloatingHoliday> resultVector = csvHandler.getCsvDataAsFloatingHolidays();
           for (FloatingHoliday floatingHoliday :resultVector) {
               floatingHolidayRepository.save(floatingHoliday);
           }
           httpStatus.put("200: ","OK");
       } catch (Exception exception) {
           httpStatus.put("Reason:",exception.getMessage());
           httpStatus.put("400: ", "FAIL");
       }
       return httpStatus;
    }
    @RequestMapping(value = "/floatingHoliday" ,method = RequestMethod.POST)
    public FloatingHoliday create(@RequestBody FloatingHoliday floatingHoliday) {
        floatingHolidayRepository.save(floatingHoliday);
        return floatingHoliday;
    }
	//Retorna los Flotiholiday por usuario 
    @RequestMapping(value ="floatingHoliday/{employeeId}", method = RequestMethod.GET)
    public List<FloatingHoliday> getFloatingHolidayByEmployeeId(@PathVariable(value = "employeeId") Long employeeId){
        List<Request> requests = requestRepository.findByEmployeeId(employeeId);
        Employee employee = employeeRepository.findById(employeeId).get();
        if(requests.size() != 0){
          List <Long> ids = new ArrayList <Long> ();
          for(Request request: requests){
                ids.add(request.floatingHoliday.getId());
          }
          List <FloatingHoliday> floatingHolidayN = floatingHolidayRepository.findByIdNotIn(ids);
            return validate(floatingHolidayN,employee);
            
        }else{
          List <FloatingHoliday> floatingHolidayNN = floatingHolidayRepository.findAll();
          return validate(floatingHolidayNN,employee);
          
        }
    }
    public List <FloatingHoliday>validate(List<FloatingHoliday> floatingHolidays, Employee employee){
      List <FloatingHoliday> listFloating = new ArrayList <> ();
      for(FloatingHoliday floatingHoliday : floatingHolidays ){
          if(floatingHoliday.getEmployeeGender() == null){
            if(floatingHoliday.getHasChildren()== null){
              listFloating.add(floatingHoliday);
            }else{
              boolean g = floatingHoliday.getHasChildren() == "true";
              if(g == employee.getIsParent()){
                listFloating.add(floatingHoliday);
              }
            }
          }else{
            if(floatingHoliday.getEmployeeGender() == employee.getGender()){
                listFloating.add(floatingHoliday);
              }
          }     
      }
      return listFloating;            
          
    }

}
