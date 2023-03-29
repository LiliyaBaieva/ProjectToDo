import java.util.Comparator;

public class TaskUrgentComparator implements Comparator<Task> {

  // Сортировка по срочности
  @Override
  public int compare(Task o1, Task o2) {
    return o2.getImportance().compareTo(o1.getImportance());
  }
}
