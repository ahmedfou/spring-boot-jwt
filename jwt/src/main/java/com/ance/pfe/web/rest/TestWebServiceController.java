package com.ance.pfe.web.rest;

import com.ance.pfe.domain.TestWebService;
import com.ance.pfe.service.ITestWebServiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/testWebServices")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TestWebServiceController {

    final ITestWebServiceService iTestWebServiceService;

    public TestWebServiceController(ITestWebServiceService iTestWebServiceService) {
        this.iTestWebServiceService = iTestWebServiceService;
    }

    @PostMapping("/createTestWebService")
    public TestWebService createTestWebService(@RequestBody TestWebService testWebService) {
        return iTestWebServiceService.createTestWebService(testWebService);
    }

    @GetMapping("/getAllTestWebService")
    public List<TestWebService> getAllTestWebService() {
        return iTestWebServiceService.getAllTestWebService();
    }

    @GetMapping("/getTestWebServiceById/{id}")
    public TestWebService getTestById(@PathVariable Long id) {
        return iTestWebServiceService.getTestWebServiceById(id);
    }

    @PutMapping("/updateTestWebService")
    public TestWebService updateTest(@RequestBody TestWebService testWebService) {
        return iTestWebServiceService.updateTestWebService(testWebService);
    }

    @DeleteMapping("/deleteTestWebService/{id}")//url
    public void deleteTest(@PathVariable Long id) {
        iTestWebServiceService.deleteTestWebService(id);
    }


}
