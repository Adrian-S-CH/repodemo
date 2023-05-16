import java.util.LinkedList;
import javax.swing.JOptionPane;

public class CatalogoDeLibros {
    private static final LinkedList<String> manga = new LinkedList<>();
    private static final LinkedList<String> cienciaFiccion = new LinkedList<>();
    private static final LinkedList<String> biografia = new LinkedList<>();

    public static void main(String[] args) {

        // Creamos las listas de cada catálogo
        //LinkedList<String> manga = new LinkedList<>();
        //LinkedList<String> cienciaFiccion = new LinkedList<>();
        //LinkedList<String> biografia = new LinkedList<>();

        // Agregamos algunos libros a cada catálogo
        manga.add("Naruto");
        manga.add("One Piece");
        manga.add("Dragon Ball");

        cienciaFiccion.add("La Guerra de los Mundos");
        cienciaFiccion.add("1984");
        cienciaFiccion.add("Fahrenheit 451");

        biografia.add("Steve Jobs");
        biografia.add("Elon Musk");
        biografia.add("Albert Einstein");

        // Mostramos un menú de opciones para el usuario
        String menu = "Seleccione una opción:\n\n" +
                "1. Mostrar catálogo de manga\n" +
                "2. Mostrar catálogo de ciencia ficción\n" +
                "3. Mostrar catálogo de biografía\n" +
                "4. Agregar libro al inicio de un catálogo\n" +
                "5. Agregar libro al final de un catálogo\n" +
                "6. Agregar libro en un índice específico de un catálogo\n" +
                "7. Salir";

        int opcion = 0;

        while (opcion != 7) {

            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcion) {

                case 1:
                    mostrarCatalogo(manga, "Manga");
                    break;

                case 2:
                    mostrarCatalogo(cienciaFiccion, "Ciencia Ficción");
                    break;

                case 3:
                    mostrarCatalogo(biografia, "Biografía");
                    break;

                case 4:
                    agregarLibroAlInicio();
                    break;

                case 5:
                    agregarLibroAlFinal();
                    break;

                case 6:
                    agregarLibroEnIndice();
                    break;

                case 7:
                    JOptionPane.showMessageDialog(null, "Gracias por utilizar el programa.");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intente de nuevo.");
                    break;

            }

        }

    }

    // Método para mostrar un catálogo de libros en una ventana de diálogo
    public static void mostrarCatalogo(LinkedList<String> catalogo, String nombreCatalogo) {

        String mensaje = "Catálogo de " + nombreCatalogo + ":\n\n";

        for (int i = 0; i < catalogo.size(); i++) {
            mensaje += (i+1) + ". " + catalogo.get(i) + "\n";
        }

        JOptionPane.showMessageDialog(null, mensaje);

    }

    public static void agregarLibroAlInicio() {

        String libro = JOptionPane.showInputDialog("Ingrese el nombre del libro a agregar:");
        int catalogo = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el catálogo:\n\n" +
                "1. Manga\n" +
                "2. Ciencia Ficción\n" +
                "3. Biografía"));

        switch (catalogo) {

            case 1:
                manga.addFirst(libro);
                mostrarCatalogo(manga, "Manga");
                break;

            case 2:
                cienciaFiccion.addFirst(libro);
                mostrarCatalogo(cienciaFiccion, "Ciencia Ficción");
                break;

            case 3:
                biografia.addFirst(libro);
                mostrarCatalogo(biografia, "Biografía");
                break;

            default:
                JOptionPane.showMessageDialog(null, "Opción inválida. Intente de nuevo.");
                break;

        }

    }

    // Método para agregar un libro al final de un catálogo
    public static void agregarLibroAlFinal() {

        String libro = JOptionPane.showInputDialog("Ingrese el nombre del libro a agregar:");
        int catalogo = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el catálogo:\n\n" +
                "1. Manga\n" +
                "2. Ciencia Ficción\n" +
                "3. Biografía"));

        switch (catalogo) {

            case 1:
                manga.addLast(libro);
                mostrarCatalogo(manga, "Manga");
                break;

            case 2:
                cienciaFiccion.addLast(libro);
                mostrarCatalogo(cienciaFiccion, "Ciencia Ficción");
                break;

            case 3:
                biografia.addLast(libro);
                mostrarCatalogo(biografia, "Biografía");
                break;

            default:
                JOptionPane.showMessageDialog(null, "Opción inválida. Intente de nuevo.");
                break;

        }

    }

    public static void agregarLibroEnIndice() {

        String libro = JOptionPane.showInputDialog("Ingrese el nombre del libro a agregar:");
        int indice = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el índice donde desea agregar el libro (comenzando desde 1):"));
        int catalogo = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el catálogo:\n\n" +
                "1. Manga\n" +
                "2. Ciencia Ficción\n" +
                "3. Biografía"));

        switch (catalogo) {

            case 1:
                if (indice > manga.size()) {
                    JOptionPane.showMessageDialog(null, "El índice ingresado es mayor al tamaño del catálogo. Intente de nuevo.");
                } else {
                    manga.add(indice-1, libro);
                    mostrarCatalogo(manga, "Manga");
                }
                break;

            case 2:
                if (indice > cienciaFiccion.size()) {
                    JOptionPane.showMessageDialog(null, "El índice ingresado es mayor al tamaño del catálogo. Intente de nuevo.");
                } else {
                    cienciaFiccion.add(indice-1, libro);
                    mostrarCatalogo(cienciaFiccion, "Ciencia Ficción");
                }
                break;

            case 3:
                if (indice > biografia.size()) {
                    JOptionPane.showMessageDialog(null, "El índice ingresado es mayor al tamaño del catálogo. Intente de nuevo.");
                } else {
                    biografia.add(indice-1, libro);
                    mostrarCatalogo(biografia, "Biografía");
                }
                break;

            default:
                JOptionPane.showMessageDialog(null, "Opción inválida. Intente de nuevo.");
                break;

        }

    }
}
