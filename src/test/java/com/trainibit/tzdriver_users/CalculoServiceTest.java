package com.trainibit.tzdriver_users;

import com.trainibit.tzdriver_users.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

public class CalculoServiceTest {

    @Mock
    private UserRepository  userRepository;

    @InjectMocks
    private CalculoServiceTest calculoServiceTest;

    @Test
    public void shortByCalculoSuccess(){
        //1.-arregnge
        //1.1 definir entradas
        CalculoRequest calculoRequest = new CalculoRequest(5,5, UUID.randomUUID(), UUID.randomUUID());
        //1.2 definir salidas
        Tabulador tabulador = new tabaulador();
        Tabulador.setCostoDTO(new BigDecimal(450.0));
        //1.3 MOkear comportamientos de mis dependencias

        when(userRepository.getAllUsersActiveTrue(anyInt()).thenReturn);

    //ACt

    //Asser
    }
}
