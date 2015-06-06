package com.djavafactory.service.impl;

import com.djavafactory.dao.OrganizationDao;
import com.djavafactory.model.Organization;
import com.djavafactory.service.OrganizationManager;
import com.djavafactory.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("organizationManager")
@WebService(serviceName = "OrganizationService", endpointInterface = "com.djavafactory.service.OrganizationManager")
public class OrganizationManagerImpl extends GenericManagerImpl<Organization, Long> implements OrganizationManager {
    OrganizationDao organizationDao;

    @Autowired
    public OrganizationManagerImpl(OrganizationDao organizationDao) {
        super(organizationDao);
        this.organizationDao = organizationDao;
    }
}