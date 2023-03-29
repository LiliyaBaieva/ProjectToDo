import java.util.Comparator;

public class TaskStatusComparator implements Comparator<Task> {
  // сортировка по статусу
  @Override
  public int compare(Task o1, Task o2) {
    return o1.getStatus().compareTo(o2.getStatus());
  }
}
