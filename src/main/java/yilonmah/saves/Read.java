package saves;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import err.ExceptionManager;
import err.YilonmahExceptions;
import task.Deadline;
import task.Event;
import task.Task;
import task.Todo;

public class Read {
	public static ArrayList<Task> initList() throws FileNotFoundException {
		File f = new File("./data/yilonmah.txt");
		Scanner s = new Scanner(f);
		ArrayList<Task> list = new ArrayList<>();
		while (s.hasNext()) {
			String line = s.nextLine();
			char c = line.charAt(1);
			try {
				switch (c) {
				case 'T':
					String desc = line.substring(5);
					list.add(new Todo(desc));
					break;
				case 'D':
					desc = line.substring(9);
					int separator = desc.indexOf("/");
					String name = desc.substring(0, separator - 1);
					String date = desc.substring(separator + 4);
					list.add(new Deadline(name, date));
					break;
				case 'E':
					desc = line.substring(6);
					int separator1 = desc.indexOf("/");
					int separator2 = desc.indexOf("/", separator1 + 1);
					name = desc.substring(0, separator1 - 1);
					String from = desc.substring(separator1 + 6, separator2 - 1);
					String by = desc.substring(separator2 + 4);
					list.add(new Event(name, from, by));
					break;
				default:
					throw new YilonmahExceptions.FileCorrupted();
				}
			} catch (YilonmahExceptions e) {
				ExceptionManager.handleException(e);
			}
		}
		return list;
	}
}
