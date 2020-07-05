package com.ance.pfe.service;

import com.ance.pfe.domain.Test;
import com.ance.pfe.repository.TestRepository;
import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import com.mailjet.client.resource.Emailv31;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements ITestService {
    private final TestRepository testRepository;

    MailjetClient client;
    MailjetRequest request;
    MailjetResponse response;

    public TestServiceImpl(TestRepository testRepository) {
        this.testRepository = testRepository;
    }


    @Override
    public List<Test> GetAllTest() {
        return testRepository.findAll();
    }

    @Override
    public Test getTestById(Long id) {
        return testRepository.findById(id).get();
    }

    @Override
    public Test createTest(Test test) throws MailjetSocketTimeoutException, MailjetException {
        sendEmail(test.getNomServeur() + test.getBase());
        return testRepository.save(test);
    }

    @Override
    public Test updateTest(Test test) {
        Test testanc = testRepository.findById(test.getId()).get();

        testanc.setType(test.getType());
        testanc.setNumeroPort(test.getNumeroPort());
        testanc.setBase(test.getBase());
        testanc.setNomServeur(test.getNomServeur());

        return testRepository.save(test);
    }

    @Override
    public void deleteTest(Long id) {
        testRepository.deleteById(id);
    }


    @Override
    public void sendEmail(String testname) throws MailjetSocketTimeoutException, MailjetException {

        client = new MailjetClient("8a1e5c72d917f432f46e5469f775e3ee", "58c13a8907585b7dcc7ead036e0e3597", new ClientOptions("v3.1"));
        request = new MailjetRequest(Emailv31.resource)
                .property(Emailv31.MESSAGES, new JSONArray()
                        .put(new JSONObject()
                                .put(Emailv31.Message.FROM, new JSONObject()
                                        .put("Email", "ancepfe2020@gmail.com")
                                     )
                                .put(Emailv31.Message.TO, new JSONArray()
                                        .put(new JSONObject()
                                                .put("Email", "ancepfe2020@gmail.com")
                                                ))
                                .put(Emailv31.Message.SUBJECT, "CREATION/EXCUTION TEST")
                                .put(Emailv31.Message.TEXTPART, testname)
                                .put(Emailv31.Message.HTMLPART, "ANCE MAILING")));
        response = client.post(request);

    }
}
