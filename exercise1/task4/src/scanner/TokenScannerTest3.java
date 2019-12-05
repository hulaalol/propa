package scanner;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class TokenScannerTest3 {

	@Test
	void test3() {
		List<String> list3 = Arrays.asList("while", "(","k", "!=", "0", ")","{", "variable", 
        		"<=", "5897543889",";", "}");
        
		//TokenScanner test3 = new TokenScanner();
		List<String> results3 = TokenScanner.functionScanner("//Simple loop \n while (k!=0 ){\n variable <= 5897543889;} ");

		assertEquals(list3, results3);
	}

}
