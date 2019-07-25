package com.concordia.mergesort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PhaseTwo {

	public static void main(String[] args) {

	}

	public void mergeSublist(String filePath) {

		long startTime = System.nanoTime();

		try {

			System.out.println("First Line");

			int phaseCount = 2;

			//String folderNameOld = "E:\\OutputFile\\";
			String folderNameOld = filePath;
			String folderNameNext = "";

			File newPhaseFolder = new File(folderNameOld + String.valueOf(phaseCount));

			boolean flag = newPhaseFolder.mkdir();

			if (flag) {
				// System.out.println("created");
			} else {
				// System.out.println("not created");
			}

			int iterationCount = 0;

			while (true) {
				File path = null;

				if (iterationCount == 0) {
					path = new File(folderNameOld);
				} else {
					if (phaseCount == 2) {
						path = new File(folderNameOld);
					} else {
						path = new File(folderNameOld);
					}
					if (iterationCount > 0) {

						folderNameNext = folderNameOld + "\\" + String.valueOf(phaseCount);
						// System.out.println("folderName: " + folderNameNext);

						File newPhaseFolder1 = new File(folderNameNext);

						boolean flag1 = newPhaseFolder1.mkdir();

						if (flag1) {
							// System.out.println("created");
						} else {
							// System.out.println("not created");
						}
					}

				}

				int numberOfFile = path.listFiles().length;

				System.out.println("Number Of File, for Pass: " + phaseCount + ": " + numberOfFile);

				if (numberOfFile <= 2 && iterationCount > 0) {
					break;
				}

				if (numberOfFile % 2 == 0) {
					numberOfFile = numberOfFile + 1;
				}

				int fileNumber = 0;
				int fileNumberrOutput = 0;

				for (int i = 0; i < numberOfFile - 2; i += 2) {
					// System.out.println("folder Name Value: " + folderNameOld);

					// System.out.println("File Path1: " + folderNameOld + "\\" +String.valueOf(fileNumber) + ".txt");

					BufferedReader bufferedReader1 = null;
					BufferedReader bufferedReader2 = null;

					try {
						bufferedReader1 = new BufferedReader(
								new FileReader(folderNameOld + "\\" + String.valueOf(fileNumber) + ".txt"));

						fileNumber = fileNumber + 1;
						// System.out.println("File Path2: " + folderNameOld + "\\"+ String.valueOf(fileNumber) + ".txt");

						bufferedReader2 = new BufferedReader(
								new FileReader(folderNameOld + "\\" + (fileNumber) + ".txt"));
						fileNumber = fileNumber + 1;
					} catch (Exception e) {
						// System.out.println("Error Caught Null Buffer: "+ e.getMessage());
					}
					PhaseTwo mergeJoin = new PhaseTwo();

					mergeJoin.mergeArray(bufferedReader1, bufferedReader2,
							folderNameOld + "\\" + String.valueOf(phaseCount), i, fileNumber, fileNumberrOutput,
							folderNameOld, phaseCount);

					fileNumberrOutput = fileNumberrOutput + 1;
					// System.out.println("Last LIne");

				}
				folderNameOld = folderNameOld + String.valueOf(phaseCount) + "\\";
				phaseCount++;
				iterationCount++;
			}
		} catch (Exception e) {
			// System.out.println("Error Occured: " + e.getMessage());
			e.printStackTrace();
		}
		long endTime = System.nanoTime();
		System.out.println("Phase Completed, Merged Code, Time Taken: " + (endTime - startTime) / 1000000 + " ms");

	}

	public Integer mergeArray(BufferedReader bufferedReader1, BufferedReader bufferedReader2, String filePath, int i,
			int fileNumber, int fileNumberrOutput, String folderNameOld, int phaseCount) {

		Boolean recordExsistFlag = true;

		BufferedWriter bw = null;
		try {

			// System.out.println(folderNameOld);
			String filePathh = folderNameOld + phaseCount + "\\" + fileNumberrOutput + ".txt";
			bw = new BufferedWriter(new FileWriter(filePathh));

			// System.out.println("bw: " + filePathh);

			String firstString = null;
			String secondString = null;

			while (recordExsistFlag) {
				try {
					if (firstString == null) {
						firstString = bufferedReader1.readLine();
					}

					if (secondString == null) {
						secondString = bufferedReader2.readLine();
					}
				} catch (Exception e) {
					// System.out.println("Error. Buffered Reader is null: " + e.getMessage());
				}

				// System.out.println("1. " + firstString);
				// System.out.println("2. " + secondString);

				int firstInt = 0;
				int secondInt = 0;

				if (firstString == null && secondString == null) {
					recordExsistFlag = false;
					break;
				}

				if (firstString != null)
					firstInt = Integer.parseInt(firstString);

				if (secondString != null)
					secondInt = Integer.parseInt(secondString);

				if (firstString != null && secondString != null) {
					if (firstInt < secondInt) {
						bw.write(String.valueOf(firstInt));
						firstString = null;
						// System.out.println("Writing integer to output file: " + firstInt);
					} else {
						bw.write(String.valueOf(secondInt));
						secondString = null;
						// System.out.println("Writing integer to output file: " + secondInt);

					}
				} else {

					if (firstString != null) {
						bw.write(String.valueOf(firstInt));
						firstString = null;
						// System.out.println("Writing integer to output file: " + firstString);

					}

					if (secondString != null) {
						bw.write(String.valueOf(secondInt));
						secondString = null;
						// System.out.println("Writing integer to output file: " + secondString);

					}
				}
				bw.newLine();
			}

			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
