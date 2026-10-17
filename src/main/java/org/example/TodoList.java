package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class TodoList {
    public record Task(String taskName, boolean done) {}
    private final List<Task> items = new ArrayList<>();

    public List<Task> getAll() {
        return new ArrayList<>(items);
    }

    public void add(String item){
        if(item != null){
            item = item.trim();
            if(!item.isEmpty()){
                items.add(new Task(item, false));
            }
        }
    }

    public boolean remove(int index){
        if(index >= 0 && index <items.size()){
            items.remove(index);
            return true;
        }
        return false;
    }

    public int size(){
        return items.size();
    }

    //independent work ---------------------------

    //clear all tasks
    public void clear(){
        items.clear();
    }

    //marking the completed task
    public boolean markDone (int index){
        if(index >= 0 && index < items.size()){
            items.set(index, new
                    Task(items.get(index).taskName(), true));
            return true;
        }
        return false;
    }


    //tasks search by substring
    public List<Task> search(String substring){
        if(substring != null && !substring.trim().isEmpty()){
            String query = substring.trim().toLowerCase();
            //stream() - имеет концепции конвеера обработки
            //collect() - позволяет собрать в необходимую структуру (н-р toList())
            return items.stream().
                    filter(t -> t.taskName.toLowerCase().contains(query))
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}
