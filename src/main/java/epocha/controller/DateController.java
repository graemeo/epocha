package epocha.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.http.HttpStatus.*;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;

import epocha.service.DateService;
import epocha.Date;

@RestController
public class DateController
{
    @Autowired
    private DateService dateService;

    @RequestMapping(value="/dates", method=GET)
    public ResponseEntity<?> dates() throws IOException {
        dateService.calculateDifferencesBetweenTwoDates();

        return new ResponseEntity<>(OK);
    }
}
