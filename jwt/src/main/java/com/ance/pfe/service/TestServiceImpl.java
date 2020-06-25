package com.ance.pfe.service;

import com.ance.pfe.domain.Test;
import com.ance.pfe.repository.TestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl  implements ITestService {
    private final TestRepository testRepository;

    public TestServiceImpl(TestRepository testRepository) {
        this.testRepository = testRepository;
    }


    @Override
    public List<Test> GetAllTest() {
        return testRepository.findAll() ;
    }
    @Override
    public Test getTestById(Long id) {
        return testRepository.findById(id).get();
    }
    @Override
    public Test createTest(Test test) {
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
}
