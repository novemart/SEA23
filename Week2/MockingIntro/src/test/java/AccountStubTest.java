import org.example.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountStubTest {

    @Test
    public void depositSmallAmount(){
        //arrange
        double amount = 500.0;
        Account a = new Account(100, new CalculatorStub() );

        //act
        a.depositMoney(amount);

        //assert
        assertEquals(600.0, a.getBalance());

    }

    @Test
    public void depositLargeAmount(){
        //arrange
        double amount = 1500;
        Account a = new Account(100, new CalculatorStub());

        //act
        a.depositMoney(amount);

        //assert
        assertEquals(0.0, a.getBalance());
    }
}
