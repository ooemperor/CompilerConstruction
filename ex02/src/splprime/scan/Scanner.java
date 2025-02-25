package splprime.scan;

import java.util.ArrayList;
import java.util.List;

public class Scanner {

	// In and output
	private final String source;
	private final List<Token> tokens = new ArrayList<>();

	public Scanner(String source) {
		this.source = source;
	}

	// Scan tokens
	public List<Token> scanTokens() {
		// TODO
		return tokens;
	}


}
