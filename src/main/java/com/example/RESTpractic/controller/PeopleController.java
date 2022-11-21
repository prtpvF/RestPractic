package com.example.RESTpractic.controller;

import com.example.RESTpractic.model.Person;
import com.example.RESTpractic.services.PeopleServices;
import com.example.RESTpractic.util.PersonException;
import com.example.RESTpractic.util.PersonNotCreatedException;
import com.example.RESTpractic.util.PersoneErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {
    private final PeopleServices peopleServices;

    @Autowired
    public PeopleController(PeopleServices peopleServices) {
        this.peopleServices = peopleServices;
    }
    @GetMapping()
    public List<Person> getPeople(){
        return peopleServices.findAll();
    }
    @GetMapping("/{id}")
    public Person getPerson(@PathVariable("id") int id){
        return peopleServices.findOne(id);
    }
    @PostMapping()
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid Person person, BindingResult bindingResult){
      if (bindingResult.hasErrors()){
          StringBuilder errorMsg = new StringBuilder();
          List<FieldError> errors = bindingResult.getFieldErrors();
          for (FieldError error: errors) {
              errorMsg.append(error.getField()).append(" -").append(error.getDefaultMessage())
                      .append(";");
          }
          throw new PersonNotCreatedException(errorMsg.toString());
      }
         peopleServices.save(person);
      //когда не хотим создавать объект положительного ответа
      return ResponseEntity.ok(HttpStatus.OK);
    }
    @ExceptionHandler
    private ResponseEntity<PersoneErrorResponse> handleException(PersonException e) {
        PersoneErrorResponse response = new PersoneErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }





}
