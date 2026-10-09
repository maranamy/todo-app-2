import org.example.TodoList;
import  org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TodoListTest {
    @Test
    void addAndList(){
        TodoList td = new TodoList();
        td.add(" первая задача ");
        assertEquals(1, td.size());
        assertEquals("первая задача", td.getAll().getFirst());
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

}
