import java.util.Comparator;

public class TaskImportanceComparator implements Comparator<Task> {

  // сортировка по важности
  @Override
  public int compare(Task o1, Task o2) {
    return o2.getImportance().compareTo(o1.getImportance());
  }


}
