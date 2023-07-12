import org.example.PricingService;
import org.example.rooms.DoubleRoom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DoubleRoomTest {

    PricingService serviceMock = mock(PricingService.class);

    @Test
    public void testMock() {

        when(serviceMock.getPrice(150, 1, 3)).thenReturn(750.00);
        //mocking
        //when I create an account I call calc.add in the constructor
        //I don't create a real instance, just a mock
        DoubleRoom cut = new DoubleRoom(serviceMock, 150, true);


        assertEquals(cut.bookRoom(1, 3), 1.2*750.00, 0.001);

        //I can verify that the mock has been called with these parameters
        verify(serviceMock).getPrice(150, 1, 3);
        verify(serviceMock, Mockito.times(1)).getPrice(150, 1, 3);
    }

}
