package com.example;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import com.google.common.io.Files;

public class Main {

	/**
	 * Entry point of the project
	 * 
	 * @param args
	 *            First argument is supposed to be a filename
	 * @throws IOException
	 * @throws InvalidSimulationException
	 */
	public static void main(String[] args) throws IOException, InvalidSimulationException {
		if (args.length != 1) {
			printUsage();
			return;
		}
		String fileName = args[0];
		File file = new File(fileName);
		if (!file.exists()) {
			System.err.println("Could not find file" + fileName);
		}
		List<String> lines = Files.readLines(file, Charset.forName("utf-8"));
		Simulation simulation = Simulation.parseSimulation(lines);
		List<String> result = simulation.run();
		for (String string : result) {
			System.out.println(string);
		}
	}

	private static void printUsage() {
		System.out.println("Provide a file as argument");
	}

}
