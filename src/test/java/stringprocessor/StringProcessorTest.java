package stringprocessor;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.roman.stringprocessor.StringProcessor;

public class StringProcessorTest {

	private StringProcessor stringProcessor;

	@Before
	public void init() {
		stringProcessor = new StringProcessor();
	}

	@Test
	public void testFindCombinationsSuccessful() {
		String targetString = "aabc";
		List<String> dictionary = Arrays.asList(new String[] { "a", "ab", "b", "c" });
		List<String> combinations = stringProcessor.findCombinations(targetString, dictionary);

		assertEquals(2, combinations.size());
		assertEquals(targetString, combinations.get(0).trim().replace(" ", ""));
		assertEquals(targetString, combinations.get(1).trim().replace(" ", ""));
	}
	
	@Test
	public void testFindCombinationsSuccessful2() {
		String targetString = "aabc";
		List<String> dictionary = Arrays.asList(new String[] { "a", "ab", "b", "c", "bc" });
		List<String> combinations = stringProcessor.findCombinations(targetString, dictionary);

		assertEquals(3, combinations.size());
		assertEquals(targetString, combinations.get(0).trim().replace(" ", ""));
		assertEquals(targetString, combinations.get(1).trim().replace(" ", ""));
		assertEquals(targetString, combinations.get(2).trim().replace(" ", ""));
	}
	
	@Test
	public void testFindCombinationsSuccessful3() {
		String targetString = "abac";
		List<String> dictionary = Arrays.asList(new String[] { "a", "ab", "b", "c", "bc" });
		List<String> combinations = stringProcessor.findCombinations(targetString, dictionary);

		assertEquals(2, combinations.size());
		assertEquals(targetString, combinations.get(0).trim().replace(" ", ""));
		assertEquals(targetString, combinations.get(1).trim().replace(" ", ""));
	}

	@Test
	public void testFindCombinationsDictionaryWithoutCharacter() {
		List<String> dictionary = Arrays.asList(new String[] { "a", "ab", "b", "c" });
		List<String> combinations = stringProcessor.findCombinations("aabcz", dictionary);
		assertEquals(0, combinations.size());
	}

	@Test
	public void testFindCombinationsEmpty() {
		List<String> dictionary = Arrays.asList(new String[] { "ab", "b", "c" });
		List<String> combinations = stringProcessor.findCombinations("aabc", dictionary);
		assertEquals(0, combinations.size());
	}

	@Test(expected = NullPointerException.class)
	public void testFindCombinationsTargetStringNull() {
		List<String> dictionary = Arrays.asList(new String[] { "ab", "b", "c" });
		stringProcessor.findCombinations(null, dictionary);
	}

	@Test(expected = NullPointerException.class)
	public void testFindCombinationsDictionaryNull() {
		stringProcessor.findCombinations("aabc", null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFindCombinationsDictionaryEmpty() {
		List<String> dictionary = Arrays.asList(new String[] {});
		stringProcessor.findCombinations("aabc", dictionary);
	}
}
