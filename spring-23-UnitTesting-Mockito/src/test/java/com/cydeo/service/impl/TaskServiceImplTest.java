package com.cydeo.service.impl;

import com.cydeo.dto.TaskDTO;
import com.cydeo.entity.Task;
import com.cydeo.mapper.TaskMapper;
import com.cydeo.repository.TaskRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {

    @Mock
    TaskRepository taskRepository;

    @Mock
    TaskMapper taskMapper;

    @InjectMocks
    TaskServiceImpl taskService;

    @ParameterizedTest
    @ValueSource(longs = {1l, 2l, 3l})
    @DisplayName("My Display Name :)")
    void findById_Test(long id) {

        //Given  (Preparation)
        Task task = new Task();
        //Stubbing findById(id) method . Returns Optional<Task>
        when(taskRepository.findById(id)).thenReturn(Optional.of(task));
        //Stubbing convertToDto(task) method. Returns TaskDTO
        when(taskMapper.convertToDto(task)).thenReturn(new TaskDTO());

        //When (Action is happening )
        //running our tests
        taskService.findById(id); //inside taskMapper.convertToDto 1 time
        taskMapper.convertToDto(task);   // just for fun taskMapper.convertToDto another 1 time

        //Then (Assertions and verifications checks)
        //verify keeps track of our Mock_s
        verify(taskRepository).findById(id);  //was  it run 1 time?
        verify(taskMapper, times(2)).convertToDto(task); //was  it run 2 times?

    }

    @Test
    void findById_BDD_Test() {

        //Given
        Task task = new Task();

       /* New way to write
        //When (Action is happening )
        //Stubbing findById(id) method . Returns Optional<Task>
        when(taskRepository.findById(id)).thenReturn(Optional.of(task));
        //Stubbing convertToDto(task) method. Returns TaskDTO
        when(taskMapper.convertToDto(task)).thenReturn(new TaskDTO());   */

        given(taskRepository.findById(anyLong())).willReturn(Optional.of(task));
        given(taskMapper.convertToDto(task)).willReturn(new TaskDTO());

        //When
        taskService.findById(anyLong());

        //Then
        then(taskRepository).should().findById(anyLong());
        then(taskMapper).should(atLeastOnce()).convertToDto(task);

    }


}







