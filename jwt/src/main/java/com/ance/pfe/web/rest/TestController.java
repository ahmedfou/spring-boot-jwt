package com.ance.pfe.web.rest;

import com.ance.pfe.domain.Test;
import com.ance.pfe.service.ITestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tests")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TestController {
    final ITestService itestService;

    public TestController(ITestService itestService) {
        this.itestService = itestService;
    }

    @PostMapping("/createTest")
    public Test createTest(@RequestBody Test test) {
        return itestService.createTest(test);
    }

    @GetMapping("/getAllTest")
    public List<Test> getAllTest() {
        return itestService.GetAllTest();
    }

    @GetMapping("/getTestById/{id}")
    public Test getTestById(@PathVariable Long id) {
        return itestService.getTestById(id);
    }

    @PutMapping("/updateTest")
    public Test updateTest(@RequestBody Test test) {
        return itestService.updateTest(test);
    }

    @DeleteMapping("/deleteTest/{id}")//url
    public void deleteTest(@PathVariable Long id) {
        itestService.deleteTest(id);
    }


}

