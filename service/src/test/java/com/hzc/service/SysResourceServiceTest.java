package com.hzc.service;

import com.hzc.model.SysResource;
import com.hzc.util.alias.S;
import org.junit.Test;

import java.util.List;

public class SysResourceServiceTest extends SupperJunit{

    @Test
    public void testGetResources() throws Exception {
        List<SysResource> resources = S.sysResourceService().getResources();
        System.out.println(resources.size());
    }
}