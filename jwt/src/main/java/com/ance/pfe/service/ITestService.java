package com.ance.pfe.service;

import com.ance.pfe.domain.Test;

import java.util.List;

public interface ITestService {
    List< Test> GetAllTest();
    Test getTestById(Long id);
    Test createTest(Test test);
    Test updateTest(Test test);
    void deleteTest(Long id);
}


