package com.briup.service;

import java.util.List;

import com.briup.bean.Test;

public interface ITestService {
    List<Test> findAll();

    void saveOrUpdate(Test test);
}
