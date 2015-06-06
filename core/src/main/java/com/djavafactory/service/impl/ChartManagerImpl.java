package com.djavafactory.service.impl;

import com.djavafactory.dao.ChartDao;
import com.djavafactory.service.ChartManager;
import com.djavafactory.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("ChartManager")
@WebService(serviceName = "ChartService", endpointInterface = "com.djavafactory.service.ChartManager")
public class ChartManagerImpl extends GenericManagerImpl<Chart, Long> implements ChartManager {
    ChartDao chartDao;

    @Autowired
    public ChartManagerImpl(ChartDao chartDao) {
        super(chartDao);
        this.chartDao = chartDao;
    }
}