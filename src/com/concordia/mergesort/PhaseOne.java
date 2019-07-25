package com.concordia.mergesort;

import java.io.IOException;
import java.util.Comparator;

public class PhaseOne {
	// public static final Metadata meta;
	public int memoryRecords = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		long memorySize = (long) ((1024) * (1024) * (2));
		int totalRecords = 1000000;
		System.out.println(totalRecords);

		// need to get the size of the record
		int memoryRecords = (int) ((memorySize) / 4);
		int numSubList = (int) Math.ceil(totalRecords / (memoryRecords * 1.0));
		System.out.println(numSubList + " " + memoryRecords);
		long startTime = System.nanoTime();
		Readingfile.readingFile("C:\\Users\\DELL\\Desktop\\input.txt",1000000,40960);
		long endTime = System.nanoTime();
		System.out.println("Generated sublists, took " + (endTime - startTime) / 1000000 + " ms");

		// Calling Phase Two.
		System.out.println("Merging Sublist.");
		PhaseTwo phaseTwo = new PhaseTwo();
		phaseTwo.mergeSublist("C:\\Users\\DELL\\Test\\");
		System.out.println("Merging Sublist Done.");
	}

}