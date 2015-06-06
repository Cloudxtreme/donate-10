package com.djavafactory.service;

import com.djavafactory.service.GenericManager;
import com.djavafactory.model.Organization;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface OrganizationManager extends GenericManager<Organization, Long> {
    
}