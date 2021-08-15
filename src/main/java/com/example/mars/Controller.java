package com.example.mars;


import com.example.mars.input.model.MarsInput;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @PostMapping(value="/sendMissionToMars",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> sendMissionToMars(@RequestBody MarsInput input){
        MissionHelper mission = new MissionHelper(input);
        return mission.sendMission();
    }




}
