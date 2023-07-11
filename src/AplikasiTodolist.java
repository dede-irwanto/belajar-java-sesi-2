public class AplikasiTodolist {
    public static String[] model = new String[10];
    public static void main(String[] args) {
        testShowTodolist();
    }
    /**
     * Menampilkan todo list
     */
    public static void showTodolist() {
        for (int i = 0; i < model.length; i++) {
            var todo = model[i];
            var no = i + 1;

            if (todo != null) {
                System.out.println(no + ". " + todo);
            }
        }
    }
    public static void testShowTodolist() {
        model[0] = "Belajar Java Dasar";
        model[1] = "Belajar Java OOP";
        showTodolist();
    }
    /**
     * Menambah todo ke list
     */
    public static void addTodolist() {

    }
    /**
     * Menghapus todo dari list
     */
    public static void removeTodolist() {

    }

    /**
     * Menampilkan view todo list
     */
    public static void viewShowTodolist() {

    }

    /**
     * Menampilkan view menambah todo list
     */
    public static void viewAddTodolist() {

    }

    /**
     * Menampilkan view menghapus todo list
     */
    public static void viewRemoveTodolist() {

    }
}
