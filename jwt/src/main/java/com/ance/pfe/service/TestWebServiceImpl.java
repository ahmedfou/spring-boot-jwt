package com.ance.pfe.service;

import com.ance.pfe.domain.Test;
import com.ance.pfe.domain.TestWebService;
import com.ance.pfe.repository.TestWebServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestWebServiceImpl implements ITestWebServiceService {
    private final TestWebServiceRepository testWebServiceRepository;

    public TestWebServiceImpl(TestWebServiceRepository testWebServiceRepository) {
        this.testWebServiceRepository = testWebServiceRepository;
    }


    @Override
    public List<TestWebService> getAllTestWebService() {
        return testWebServiceRepository.findAll();
    }

    @Override
    public TestWebService getTestWebServiceById(Long id) {
        return testWebServiceRepository.findById(id).get();
    }

    @Override
    public TestWebService createTestWebService(TestWebService testWebService) {
        return testWebServiceRepository.save(testWebService);
    }

    @Override
    public TestWebService updateTestWebService(TestWebService testWebService) {
        TestWebService testWebService1 = testWebServiceRepository.findById(testWebService.getId()).get();

        testWebService1.setName(testWebService.getName());
        testWebService1.setReponse(testWebService.getReponse());
        testWebService1.setRequest(testWebService.getRequest());

        return testWebServiceRepository.save(testWebService1);
    }

    @Override
    public void deleteTestWebService(Long id) {
        testWebServiceRepository.deleteById(id);
    }
}
