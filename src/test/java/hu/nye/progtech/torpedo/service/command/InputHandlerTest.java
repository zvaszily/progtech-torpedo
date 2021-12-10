package hu.nye.progtech.torpedo.service.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class InputHandlerTest {

     private InputHandler underTest;

    private static final String INPUT = "exit";

    private  Command command1;
    private  Command command2;

    @BeforeEach
    public void init(){
        command1 = Mockito.mock(Command.class);
        command2 = Mockito.mock(Command.class);
        underTest = new InputHandler(List.of(command1, command2));
    }

    @Test
    public void testHandleInputShouldRunOnlyTheFirstApplicableCommand(){
        // given
        given(command1.canProcess(INPUT)).willReturn(true);
        //when
        underTest.handleInput(INPUT);
        // then
        verify(command1).canProcess(INPUT);
        verify(command1).process(INPUT);
        verifyNoInteractions(command2);
    }

    @Test
    public void testHandleInputShouldRunNoCommandsWhenNoneOfThemIsApplicable() {
        // given
        given(command1.canProcess(INPUT)).willReturn(false);
        given(command2.canProcess(INPUT)).willReturn(false);

        // when
        underTest.handleInput(INPUT);

        // then
        verify(command1).canProcess(INPUT);
        verifyNoMoreInteractions(command1);
        verify(command2).canProcess(INPUT);
        verifyNoMoreInteractions(command2);
    }
}
