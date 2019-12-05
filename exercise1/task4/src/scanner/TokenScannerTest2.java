package scanner;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class TokenScannerTest2 {

	@Test
	void test2() {
		
		List<String> list2 = Arrays.asList("for", "(","i", "<=", "0", ";","i", "<", 
        		"10", ";","i", "=","i","+", "1", ")","{", "z", "<=","z", "/","2",";", "}", "return", "0",";");
        
		//TokenScanner test3 = new TokenScanner();
		List<String> results2 = TokenScanner.functionScanner("for   (i<=0;i<10; i=i+1){\n z<=z/2;}\n return 0;");

		assertEquals(list2, results2);
		
		
	}
}
