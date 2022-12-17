package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.entity.Project;
import com.cydeo.mapper.ProjectMapper;
import com.cydeo.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {

    @Mock
    ProjectRepository projectRepository;

    @Mock
    ProjectMapper projectMapper;

    @InjectMocks
    ProjectServiceImpl projectService;

    @Test
    void getByProjectCode_Test() {

//Given part
        //stubbing. Behavior and return
        when(projectRepository.findByProjectCode(anyString())).thenReturn(new Project());

        when(projectMapper.convertToDto(any(Project.class))).thenReturn(new ProjectDTO());

        // When part
        ProjectDTO projectDTO = projectService.getByProjectCode(anyString());

//Then step

        //check the order of these two mocks
        InOrder inOrder = inOrder(projectRepository, projectMapper);
//we are providing in which order these two mock should be
        inOrder.verify(projectRepository).findByProjectCode(anyString());
        inOrder.verify(projectMapper).convertToDto(any(Project.class));

        assertNotNull(projectDTO);


    }

    @Test
    void getByProjectCode_ExceptionTest(){

        when(projectRepository.findByProjectCode("")).thenThrow(
                new NoSuchElementException("Project not found"));

        Throwable throwable=assertThrows(NoSuchElementException.class,
                ()-> projectService.getByProjectCode(""));

        //this method with parameter "" will throw an exception, verifying that it called
        verify(projectRepository).findByProjectCode("");
        //this method must never be run
       verify(projectMapper,never()).convertToDto(any(Project.class));

       assertEquals("Project not found", throwable.getMessage());

    }

}












