package com.ance.pfe.service;

import com.ance.pfe.domain.Test;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;

import java.util.List;

public interface ITestService {
    List<Test> GetAllTest();

    Test getTestById(Long id);

    Test createTest(Test test) throws MailjetSocketTimeoutException, MailjetException;

    Test updateTest(Test test);

    void deleteTest(Long id);

    void sendEmail(String testname) throws MailjetSocketTimeoutException, MailjetException;
}


