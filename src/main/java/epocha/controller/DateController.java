package epocha.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.http.HttpStatus.*;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;

import epocha.service.DateService;
import epocha.response.DateResponse;

@RestController
public class DateController
{
    @Autowired
    private DateService dateService;

    @RequestMapping(value="/dates", method=GET)
    public ResponseEntity<?> dates() throws IOException {
        List<DateResponse> listOfDateResponse =  dateService.calculateDifferencesBetweenTwoDates();
      
        return new ResponseEntity<>(listOfDateResponse, OK);
    }
}
