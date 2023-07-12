import org.example.Account;
import org.example.ICalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.*;

//this annotation needs to be present
@ExtendWith(MockitoExtension.class)
public class CalculatorMockTest {

	//mock of an interface
	ICalculator calc = mock(ICalculator.class);

	@BeforeEach
	public void setUp() throws Exception {
		//telling my mock that if someone calls the method add with these two params
		//it should return 750.00 - random value
		when(calc.add(100.00, 500.00)).thenReturn(750.00);

		//when I call add method with ANY 2 params of type double
		when(calc.add(anyDouble(), anyDouble())).thenReturn(750.00);

	}

	@Test
	public void testMock() {
		//mocking
		//when I create an account I call calc.add in the constructor
		//I don't create a real instance, just a mock
		Account acc = new Account(200, calc);
		//I can verify that the mock has been called with these parameters
		verify(calc).add(200.0, 500.0);
		verify(calc, Mockito.times(1)).add(200.0, 500.0);
	}
	
	@Test
	public void testStub(){
		//stubbing
		//set up done in the @Before method
		//when I call add on the mock I return a fixed value
		//that value is then set in the balance of the account
		Account acc= new Account(100, calc);
		//I'm testing state, after receiving the value from calc mock I set it in my obj
		assertEquals(acc.getBalance(), 750.00);
	}


}
