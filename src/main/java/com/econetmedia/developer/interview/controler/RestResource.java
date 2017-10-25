package com.econetmedia.developer.interview.controler;

import com.econetmedia.developer.interview.model.Address;
import com.econetmedia.developer.interview.model.Response;
import com.econetmedia.developer.interview.rest.RestConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class RestResource {

    @Autowired
    RestConsumer restConsumer;

    private static final Logger LOGGER = LoggerFactory.getLogger(RestResource.class);

    @PostMapping(value = "address", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Response> cauptureAddress(@RequestBody Address address) {
        LOGGER.info("\n \n"+address.toString()+"\n");
        LOGGER.info("\n \n"+restConsumer.makeRestCall(1).toString()+"\n");

        return new ResponseEntity(new Response("Success","200",address),HttpStatus.OK);
    }

}
