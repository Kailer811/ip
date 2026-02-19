package saves;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import print.Printer;
import task.Deadline;
import task.Event;
import task.Task;
import task.Todo;

public class Read {
	public static Task[] initList() throws FileNotFoundException {
		File f = new File("./data/yilonmah.txt");
		Scanner s = new Scanner(f);
		int taskCount = 0;
		Task[] list = new Task[100];
		System.out.println("thinkingg hardd");
		while (s.hasNext()) {
			String line = s.nextLine();
			System.out.println("neuronss connecctt");
			char c = line.charAt(1);
			switch (c) {
				case 'T':
					String desc = line.substring(5);
					list[taskCount] = new Todo(desc);
					Printer.taskAdded();
					System.out.println(list[taskCount].printTask());
					taskCount++;
					Printer.listCount(taskCount);
					Printer.dash();
					break;
				case 'D':
					desc = line.substring(9);
					int separator = desc.indexOf("/");
					String name = desc.substring(0, separator - 1);
					String date = desc.substring(separator + 4);
					list[taskCount] = new Deadline(name, date);
					Printer.taskAdded();
					System.out.println(list[taskCount].printTask());
					taskCount++;
					Printer.listCount(taskCount);
					Printer.dash();
					break;
				case 'E':
					desc = line.substring(6);
					int separator1 = desc.indexOf("/");
					int separator2 = desc.indexOf("/", separator1 + 1);
					name = desc.substring(0, separator1 - 1);
					String from = desc.substring(separator1 + 6, separator2 - 1);
					String by = desc.substring(separator2 + 4);
					list[taskCount] = new Event(name, from, by);
					Printer.taskAdded();
					System.out.println(list[taskCount].printTask());
					taskCount++;
					Printer.listCount(taskCount);
					Printer.dash();
					break;
			}
		}
		return list;
	}
}
