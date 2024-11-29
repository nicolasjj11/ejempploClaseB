import java.sql.*;
import java.util.Scanner;

public class GestionUsuarios {
    private static final String URL = "jdbc:mysql://localhost:3306/gestion_usuarios";
    private static final String USER = "root"; // Cambia por tu usuario de MySQL
    private static final String PASSWORD = "password"; // Cambia por tu contraseña de MySQL

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Conexión exitosa a la base de datos.");

            boolean salir = false;
            while (!salir) {
                System.out.println("\n--- Menú ---");
                System.out.println("1. Añadir usuario");
                System.out.println("2. Mostrar usuarios");
                System.out.println("3. Actualizar usuario");
                System.out.println("4. Eliminar usuario");
                System.out.println("5. Salir");
                System.out.print("Elige una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir salto de línea

                switch (opcion) {
                    case 1:
                        añadirUsuario(connection, scanner);
                        break;
                    case 2:
                        mostrarUsuarios(connection);
                        break;
                    case 3:
                        actualizarUsuario(connection, scanner);
                        break;
                    case 4:
                        eliminarUsuario(connection, scanner);
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida. Intenta de nuevo.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }

    private static void añadirUsuario(Connection connection, Scanner scanner) {
        System.out.print("Ingresa el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingresa el email: ");
        String email = scanner.nextLine();

        String sql = "INSERT INTO usuarios (nombre, email) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nombre);
            statement.setString(2, email);
            statement.executeUpdate();
            System.out.println("Usuario añadido correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al añadir usuario: " + e.getMessage());
        }
    }

    private static void mostrarUsuarios(Connection connection) {
        String sql = "SELECT * FROM usuarios";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            System.out.println("\nUsuarios registrados:");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String email = resultSet.getString("email");
                System.out.printf("ID: %d, Nombre: %s, Email: %s%n", id, nombre, email);
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar usuarios: " + e.getMessage());
        }
    }

    private static void actualizarUsuario(Connection connection, Scanner scanner) {
        System.out.print("Ingresa el ID del usuario a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir salto de línea

        System.out.print("Ingresa el nuevo nombre: ");
        String nuevoNombre = scanner.nextLine();
        System.out.print("Ingresa el nuevo email: ");
        String nuevoEmail = scanner.nextLine();

        String sql = "UPDATE usuarios SET nombre = ?, email = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nuevoNombre);
            statement.setString(2, nuevoEmail);
            statement.setInt(3, id);

            int filasActualizadas = statement.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Usuario actualizado correctamente.");
            } else {
                System.out.println("No se encontró un usuario con el ID especificado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar usuario: " + e.getMessage());
        }
    }

    private static void eliminarUsuario(Connection connection, Scanner scanner) {
        System.out.print("Ingresa el ID del usuario a eliminar: ");
        int id = scanner.nextInt();

        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            int filasEliminadas = statement.executeUpdate();
            if (filasEliminadas > 0) {
                System.out.println("Usuario eliminado correctamente.");
            } else {
                System.out.println("No se encontró un usuario con el ID especificado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
        }
    }
}
