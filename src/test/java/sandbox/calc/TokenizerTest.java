package sandbox.calc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TokenizerTest {

	@Test
	public void shouldTokenizeComplexOps() {
		Tokenizer t = new Tokenizer();
		Expression tokens = t.tokenize("(1+2)*3");
		assertTrue(tokens.size() == 5);

		tokens = t.tokenize("((1+2)*3)-(5+7)");
		assertTrue(tokens.size() == 9);
	}

	@Test
	public void shouldTokenizeSimpleOps() {
		Tokenizer t = new Tokenizer();
		Expression tokens = t.tokenize("");
		assertTrue(tokens.size() == 0);

		tokens = t.tokenize("5");
		assertTrue(tokens.size() == 1);
		assertEquals(new NumberTerm(5), tokens.get(0));

		tokens = t.tokenize("-5");
		assertTrue(tokens.size() == 1);
		assertEquals(new NumberTerm(-5), tokens.get(0));

		tokens = t.tokenize("5+5");
		assertTrue(tokens.size() == 3);
		assertEquals(new NumberTerm(5), tokens.get(0));
		assertEquals(new Operator("+"), tokens.get(1));
		assertEquals(new NumberTerm(5), tokens.get(2));

		tokens = t.tokenize("5-5");
		assertTrue(tokens.size() == 3);
		assertEquals(new NumberTerm(5), tokens.get(0));
		assertEquals(new Operator("-"), tokens.get(1));
		assertEquals(new NumberTerm(5), tokens.get(2));

		tokens = t.tokenize("-5*-5");
		assertTrue(tokens.size() == 3);
		assertEquals(new NumberTerm(-5), tokens.get(0));
		assertEquals(new Operator("*"), tokens.get(1));
		assertEquals(new NumberTerm(-5), tokens.get(2));

		tokens = t.tokenize("75+15");
		assertTrue(tokens.size() == 3);
		assertEquals(new NumberTerm(75), tokens.get(0));
		assertEquals(new Operator("+"), tokens.get(1));
		assertEquals(new NumberTerm(15), tokens.get(2));

		tokens = t.tokenize("75+15*789");
		assertTrue(tokens.size() == 5);
		assertEquals(new NumberTerm(75), tokens.get(0));
		assertEquals(new Operator("+"), tokens.get(1));
		assertEquals(new NumberTerm(15), tokens.get(2));
		assertEquals(new Operator("*"), tokens.get(3));
		assertEquals(new NumberTerm(789), tokens.get(4));
	}

}
