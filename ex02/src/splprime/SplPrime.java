package splprime;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import splprime.scan.Scanner;
import splprime.scan.Token;

public class SplPrime {

	static boolean hadError = false;

	// Expects a single file that comprises SPL' program as argument
	public static void main(String[] args) throws IOException {
		runFile(args[0]);
	}

	private static void runFile(String path) throws IOException {
		byte[] bytes = Files.readAllBytes(Paths.get(path));
		run(new String(bytes, Charset.defaultCharset()));

		// Indicate an error in the exit code.
		if (hadError) {
			System.exit(65);
		}
	}

	private static void run(String source) {
		Scanner scanner = new Scanner(source);
		List<Token> tokens = scanner.scanTokens();

		// For now, just print the tokens
		for (Token token : tokens) {
			System.out.println(token);
		}
	}

	public static void error(int line, String message) {
		report(line, "", message);
	}

	private static void report(int line, String where, String message) {
		System.err.println("[line " + line + "] Error" + where + ": " + message);
		hadError = true;
	}

}
