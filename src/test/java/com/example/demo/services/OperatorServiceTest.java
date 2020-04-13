package com.example.demo.services;

import com.example.demo.TestUtils;
import com.example.demo.controllers.request.OperatorRequest;
import com.example.demo.model.Operator;
import com.example.demo.model.Role;
import com.example.demo.repository.OperatorRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.services.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class OperatorServiceTest {

    @Mock
    private OperatorRepository operatorRepository;

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private OperatorService operatorService;

    @After
    public void tearDown() {
        Mockito.verifyNoMoreInteractions(operatorRepository, roleRepository);
    }

    @Test
    public void shouldReturnOneOperator() {
        // GIVEN
        Operator operator = TestUtils.createOperator();
        List<Operator> operators = Collections.singletonList(operator);
        Mockito.when(operatorRepository.findAll()).thenReturn(operators);

        // WHEN
        Response response = operatorService.getAll();

        // THEN
        Mockito.verify(operatorRepository).findAll();
        Assert.assertTrue(response.isOk());
        Assert.assertEquals(1, ((List) response.getExtra().get("operators")).size());
    }

    @Test
    public void shouldCreateAnOperator() {
        // GIVEN
        Role role = TestUtils.createRole();
        OperatorRequest operatorRequest = new OperatorRequest(null, "FirstName", "LastName", "phone", "email", "password", role.getId());
        Mockito.when(operatorRepository.findOneByEmail(Mockito.anyString())).thenReturn(Optional.empty());
        Mockito.when(roleRepository.findOne(Mockito.anyLong())).thenReturn(role);

        // WHEN
        Response response = operatorService.createOrUpdate(operatorRequest);

        // THEN
        Assert.assertEquals(OperatorService.ResponseCode.CREATED, response.getResponseCode());
        Mockito.verify(operatorRepository).findOneByEmail(Mockito.anyString());
        Mockito.verify(roleRepository).findOne(Mockito.anyLong());
        ArgumentCaptor<Operator> operatorArgumentCaptor = ArgumentCaptor.forClass(Operator.class);
        Mockito.verify(operatorRepository).save(operatorArgumentCaptor.capture());
        Operator operator = operatorArgumentCaptor.getValue();
        Assertions.assertThat(operator.getRole()).isSameAs(role);
    }

    @Test
    public void shouldUpdateAnOperator() {
        // GIVEN
        Operator operator = TestUtils.createOperator();
        Mockito.when(operatorRepository.findOneByEmail(Mockito.anyString())).thenReturn(Optional.of(operator));
        Mockito.when(roleRepository.findOne(Mockito.anyLong())).thenReturn(operator.getRole());
        OperatorRequest operatorRequest = new OperatorRequest(operator.getId(), "FirstName", "LastName", "phone", "email", "password", operator.getRole().getId());

        // WHEN
        Response response = operatorService.createOrUpdate(operatorRequest);

        // THEN
        Assert.assertEquals(OperatorService.ResponseCode.OK, response.getResponseCode());
        Mockito.verify(operatorRepository).findOneByEmail(Mockito.eq(operatorRequest.getEmail()));
        Mockito.verify(roleRepository).findOne(Mockito.eq(operatorRequest.getRoleId()));
        ArgumentCaptor<Operator> operatorArgumentCaptor = ArgumentCaptor.forClass(Operator.class);
        Mockito.verify(operatorRepository).save(operator);
    }

    @Test
    public void shouldRespondOperatorAlreadyExists() {
        // GIVEN
        Operator operator = TestUtils.createOperator();
        Mockito.when(operatorRepository.findOneByEmail(Mockito.anyString())).thenReturn(Optional.of(operator));
        OperatorRequest operatorRequest = new OperatorRequest(null, "FirstName", "LastName", "phone", operator.getEmail(), "password", operator.getRole().getId());

        // WHEN
        Response response = operatorService.createOrUpdate(operatorRequest);

        // THEN
        Assert.assertEquals(OperatorService.ResponseCode.OPERATOR_ALREADY_EXIST, response.getResponseCode());
        Mockito.verify(operatorRepository).findOneByEmail(Mockito.eq(operator.getEmail()));
    }

    @Test
    public void shouldFailRoleNotFound() {
        // GIVEN
        Operator operator = TestUtils.createOperator();
        Mockito.when(operatorRepository.findOneByEmail(Mockito.anyString())).thenReturn(Optional.empty());
        Mockito.when(roleRepository.findOne(Mockito.anyLong())).thenReturn(null);
        long nonExistentRoleId = 4L;
        OperatorRequest operatorRequest = new OperatorRequest(null, "FirstName", "LastName", "phone", "email", "password", nonExistentRoleId);

        // WHEN
        Response response = operatorService.createOrUpdate(operatorRequest);

        // THEN
        Assert.assertEquals(OperatorService.ResponseCode.ROLE_NOT_EXIST, response.getResponseCode());
        Mockito.verify(operatorRepository).findOneByEmail(Mockito.eq(operatorRequest.getEmail()));
        Mockito.verify(roleRepository).findOne(Mockito.eq(operatorRequest.getRoleId()));
    }
}
