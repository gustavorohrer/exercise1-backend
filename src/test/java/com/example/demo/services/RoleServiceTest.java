package com.example.demo.services;

import com.example.demo.TestUtils;
import com.example.demo.model.Role;
import com.example.demo.repository.RoleRepository;
import com.example.demo.services.response.Response;
import com.example.demo.services.response.RoleService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class RoleServiceTest {

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private RoleService roleService;

    @After
    public void tearDown() {
        Mockito.verifyNoMoreInteractions(roleRepository);
    }

    @Test
    public void shouldReturnOneOperator() {
        // GIVEN
        Role role = TestUtils.createRole();
        List<Role> roleList = Collections.singletonList(role);
        Mockito.when(roleRepository.findAll()).thenReturn(roleList);

        // WHEN
        Response response = roleService.getAll();

        // THEN
        Mockito.verify(roleRepository).findAll();
        Assert.assertTrue(response.isOk());
        Assert.assertEquals(1, ((List) response.getExtra().get("roleList")).size());
    }
}
