package ch15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class FileInOutStreamTest {

	public static void main(String[] args) throws Exception {

		String baseDir = "d:\\workspace\\java\\ch15\\in\\";
		String fileName = "test.txt";
		File target = new File(baseDir, fileName);

		String targetDir = "d:\\workspace\\java\\ch15\\out\\";
		String targetFile = "output.txt";
		File targetOut = new File(targetDir, targetFile);

		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(target);
			fos = new FileOutputStream(targetOut);
			byte[] readBuffer = new byte[1024];
			while (fis.read(readBuffer, 0, readBuffer.length) > -1) {
				fos.write(readBuffer); // µ¤¾î¾²±â
			}
		} finally {
			fis.close();
			fos.close();
		}

		// FileUtils.copyFile(target, fos); //file copy

		BufferedReader bufferR = null;
		BufferedWriter bufferW = null;
		try {
			bufferR = new BufferedReader(new FileReader(target));
			bufferW = new BufferedWriter(new FileWriter(targetOut, true));

			String str = "";
			while ((str = bufferR.readLine()) != null) {
				bufferW.write(str);
				bufferW.newLine();
			}
		} finally {
			bufferR.close();
			bufferW.flush();
			bufferW.close();
		}

	}

}
