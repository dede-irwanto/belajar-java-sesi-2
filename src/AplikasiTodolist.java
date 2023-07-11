import java.util.Scanner;

public class AplikasiTodolist {
    public static String[] model = new String[10];
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        //testShowTodolist();
        //testAddTodolist();
        //testRemoveTodolist();
        //testInput();
        //testViewShowTodolist();
        //testViewAddTodolist();
        //testViewRemoveTodolist();
        viewShowTodolist();
    }
    /**
     * Menampilkan todo list
     */
    public static void showTodolist() {
        System.out.println("TODOLIST");
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
    public static void addTodolist(String todo) {
        var isFull = true;
        for (var i = 0; i < model.length; i++) {
            // model masih ada yang kosong
            if (model[i] == null) {
                isFull = false;
                break;
            }
        }

        // jika penuh, resize ukuran model 2x lipat
        if (isFull) {
            var temp = model;
            model = new String[model.length * 2];

            for (var i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        // tambah ke posisi yang data array nya null
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }
    public static void testAddTodolist() {
        for (var i = 1; i <= 30; i++) {
            addTodolist("Contoh todo ke-" + i);
        }
        showTodolist();
    }
    /**
     * Menghapus todo dari list
     */
    public static boolean removeTodolist(Integer number) {
        if ((number - 1) >= model.length) {
            return false;
        } else if (model[number - 1] == null) {
            return false;
        } else {
            for (var i = (number - 1); i < model.length; i++) {
                if (i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }
    public static void testRemoveTodolist() {
        addTodolist("Satu");
        addTodolist("Dua");
        addTodolist("Tiga");
        addTodolist("Empat");
        addTodolist("Lima");

        removeTodolist(2);
        showTodolist();
    }
    public static String input(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }
    public static void testInput() {
        var name = input("Nama");
        System.out.println("Hi " + name);

        var site = input("Site");
        System.out.println("Site " + site);
    }
    /**
     * Menampilkan view todo list
     */
    public static void viewShowTodolist() {
        while (true) {
            showTodolist();

            System.out.println("MENU : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = input("Pilih");
            if (input.equals("1")) {
                viewAddTodolist();
            } else if (input.equals("2")) {
                viewRemoveTodolist();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan tidak dimengerti");
            }
        }
    }
    public static void testViewShowTodolist() {
        addTodolist("Satu");
        addTodolist("Dua");
        addTodolist("Tiga");
        addTodolist("Empat");
        addTodolist("Lima");

        viewShowTodolist();
    }
    /**
     * Menampilkan view menambah todo list
     */
    public static void viewAddTodolist() {
        System.out.println("MENAMBAH TODOLIST");

        var todo = input("Todo (x jika batal)");

        if (todo.equals("x")) {
            // batal
        } else {
            addTodolist(todo);
        }
    }
    public static void testViewAddTodolist() {
        viewAddTodolist();
        showTodolist();
    }
    /**
     * Menampilkan view menghapus todo list
     */
    public static void viewRemoveTodolist() {
        System.out.println("MENGHAPUS TODOLIST");

        var number = input("Nomor yang dihapus (x jika batal)");

        if (number.equals("x")) {
            // batal
        } else {
            boolean success = removeTodolist(Integer.valueOf(number));
            if (!success) {
                System.out.println("Gagal menghapus todolist : " + number);
            }
        }
    }
    public static void testViewRemoveTodolist() {
        addTodolist("Satu");
        addTodolist("Dua");
        addTodolist("Tiga");

        showTodolist();

        viewRemoveTodolist();

        showTodolist();
    }
}
