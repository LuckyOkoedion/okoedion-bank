package com.lucky.OkoedionBank.Controllers.impl;

import com.lucky.OkoedionBank.Controllers.IRobotCpuController;
import com.lucky.OkoedionBank.Pojo.RobotCpu;
import com.lucky.OkoedionBank.Services.IRobotCpuService;
import com.lucky.OkoedionBank.Services.impl.RobotCpuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value =  "/robot-cpu")
public class RobotCpuController implements IRobotCpuController {

    //   Note that the type of `robotCpuService` below is an interface, not a class. This is for
//   loose coupling / Strategy design pattern.

    private IRobotCpuService robotCpuService;

    //        Here you can now swap implementation at ease without need for refactoring.
//        Just use constructor dependency injection to provide any class, so long as the class
//        implements the `IRobotCpuService` interface.

    public RobotCpuController(RobotCpuService theRobotCpuService) {
        super();
        robotCpuService = theRobotCpuService;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<RobotCpu>> getAll() {
        try {
            return new ResponseEntity<>(robotCpuService.getAll(), HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<RobotCpu> getOneById(@PathVariable(value="id") String id) {
        try {
            return new ResponseEntity<>(robotCpuService.getOneById(id), HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
