package saves;

import java.io.FileWriter;
import java.io.IOException;

public class Write {
	private static void writeToFile(String textToAdd) throws IOException {
		FileWriter fw = new FileWriter("./data/yilonmah.txt");
		fw.write(textToAdd);
		fw.close();
	}

	private static void appendToFile(String textToAppend) throws IOException {
		FileWriter fw = new FileWriter("./data/yilonmah.txt", true);
		fw.write(textToAppend);
		fw.close();
	}

}
