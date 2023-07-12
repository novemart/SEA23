import org.example.Account;
import org.example.ICalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AccountMockTest {

    ICalculator mockCalculator = mock(ICalculator.class);

    @Test
    public void smallAmountDepositTest(){
        //arrange
        double amount = 500;
        Account a = new Account(100, mockCalculator);

        //act
        a.depositMoney(amount);

        //assert
        assertEquals(600.0, a.getBalance());
        verify(mockCalculator, Mockito.times(0)).add(any(Double.class), any(Double.class) );

    }

    @Test
    public void largeAmountDepositTest(){
        //arrange
        double amount = 5000;
        Account a = new Account(100, mockCalculator);
        when(mockCalculator.add(100, 5000)).thenReturn(1000.0);

        //act
        a.depositMoney(amount);

        //assert
        assertEquals(1000, a.getBalance());
        verify(mockCalculator, Mockito.times(1)).add(100, 5000);

    }

}
