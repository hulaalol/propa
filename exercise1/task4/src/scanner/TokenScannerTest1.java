package scanner;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*; 

import java.util.List;

import org.junit.jupiter.api.Test;

class TokenScannerTest1 {

	@Test
	void test1() {
		List<String> list1 = Arrays.asList("if", "(","x", ">", "0", ")","{", "y", 
        		"<=", "7",";", "}");
        
		//TokenScanner test1 = new TokenScanner();
		List<String> results1 = TokenScanner.functionScanner("if (x >0){\ny<=  7;\n}");
		assertEquals(list1, results1);
		
		
	}
	

}
