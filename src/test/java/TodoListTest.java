import org.example.TodoList;
import  org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TodoListTest {
    @Test
    void addAndList(){
        TodoList td = new TodoList();
        td.add(" первая задача ");
        assertEquals(1, td.size());
        assertEquals(new TodoList.Task("first task", false), td.getAll().getFirst());
    }

    @Test
    void remove() {
        TodoList td = new TodoList();
        td.add("a");
        td.add("r");
        td.add("bla");
        assertTrue(td.remove(0));
        assertEquals(2, td.size());
        assertFalse(td.remove(8));
    }

    @Test
    void addEmptyIgnored() {
        TodoList t = new TodoList();
        t.add(" ");
        assertEquals(0, t.size());
    }


    //test for cleaning all tasks
    @Test
    void clearList(){
        TodoList t = new TodoList();
        t.add("first");
        t.add("second");
        assertEquals(2, t.size());

        t.clear();
        assertEquals(0, t.size());
        assertTrue(t.getAll().isEmpty());
    }

    //test for searching some tasks
    @Test
    void searchTask(){
        TodoList t = new TodoList();
        t.add("first task");
        t.add("second work");
        t.add("third task");

        List<TodoList.Task> list = t.search("task");
        assertEquals(2, list.size());
        assertEquals("first task", list.get(0).taskName());
        assertEquals("third task", list.get(1).taskName());


        assertEquals(0, t.search("").size());
        assertEquals(1, t.search("WORK").size());
    }

    //test for marking task as done
    @Test
    void markDone(){
        TodoList t = new TodoList();
        t.add("Buy milk");
        t.add("Clean the bathroom");

        assertTrue(t.markDone(0));
        assertFalse(t.getAll().get(1).done());
    }
}
