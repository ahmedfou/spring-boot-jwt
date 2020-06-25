package com.ance.pfe.service;

import com.ance.pfe.domain.TestWebService;

import java.util.List;

public interface ITestWebServiceService {

    List<TestWebService> getAllTestWebService();
    TestWebService getTestWebServiceById(Long id);
    TestWebService createTestWebService(TestWebService testWebService);
    TestWebService updateTestWebService(TestWebService testWebService);
    void deleteTestWebService(Long id);
}
