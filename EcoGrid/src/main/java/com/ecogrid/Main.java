import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
        String user = "RM551500";
        String password = "101094";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            while (true) {
                System.out.println("\n=== MENU DE OPÇÕES ===");
                System.out.println("1. Gerenciar Comunidades");
                System.out.println("2. Gerenciar Usuários");
                System.out.println("3. Gerenciar Microgrids");
                System.out.println("4. Sair");
                System.out.print("Escolha uma opção: ");

                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        gerenciarComunidades(conn, scanner);
                        break;
                    case 2:
                        gerenciarUsuarios(conn, scanner);
                        break;
                    case 3:
                        gerenciarMicrogrids(conn, scanner);
                        break;
                    case 4:
                        System.out.println("Encerrando o sistema...");
                        return;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    // Métodos para Gerenciamento de Comunidades
    private static void gerenciarComunidades(Connection conn, Scanner scanner) throws SQLException {
        System.out.println("\n=== GERENCIAR COMUNIDADES ===");
        System.out.println("1. Listar comunidades");
        System.out.println("2. Adicionar comunidade");
        System.out.println("3. Atualizar comunidade");
        System.out.println("4. Remover comunidade");
        System.out.print("Escolha uma opção: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                listarComunidades(conn);
                break;
            case 2:
                adicionarComunidade(conn, scanner);
                break;
            case 3:
                atualizarComunidade(conn, scanner);
                break;
            case 4:
                removerComunidade(conn, scanner);
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private static void listarComunidades(Connection conn) throws SQLException {
        String sql = "SELECT * FROM comunidades";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.printf("ID: %d, Nome: %s, Região: %s%n", rs.getInt("id"), rs.getString("nome"), rs.getString("regiao"));
            }
        }
    }

    private static void adicionarComunidade(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Digite o nome da comunidade: ");
        scanner.nextLine(); // Consumir o newline
        String nome = scanner.nextLine();
        System.out.print("Digite a região: ");
        String regiao = scanner.nextLine();

        String sql = "INSERT INTO comunidades (nome, regiao) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.setString(2, regiao);
            int rowsInserted = pstmt.executeUpdate();
            System.out.println(rowsInserted > 0 ? "Comunidade adicionada com sucesso!" : "Falha ao adicionar comunidade.");
        }
    }

    private static void atualizarComunidade(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Digite o ID da comunidade que deseja atualizar: ");
        int id = scanner.nextInt();
        System.out.print("Digite o novo nome: ");
        scanner.nextLine(); // Consumir o newline
        String nome = scanner.nextLine();
        System.out.print("Digite a nova região: ");
        String regiao = scanner.nextLine();

        String sql = "UPDATE comunidades SET nome = ?, regiao = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.setString(2, regiao);
            pstmt.setInt(3, id);
            int rowsUpdated = pstmt.executeUpdate();
            System.out.println(rowsUpdated > 0 ? "Comunidade atualizada com sucesso!" : "Comunidade não encontrada.");
        }
    }

    private static void removerComunidade(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Digite o ID da comunidade que deseja remover: ");
        int id = scanner.nextInt();

        String sql = "DELETE FROM comunidades WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rowsDeleted = pstmt.executeUpdate();
            System.out.println(rowsDeleted > 0 ? "Comunidade removida com sucesso!" : "Comunidade não encontrada.");
        }
    }

    // Métodos para Gerenciamento de Usuários
    private static void gerenciarUsuarios(Connection conn, Scanner scanner) throws SQLException {
        System.out.println("\n=== GERENCIAR USUÁRIOS ===");
        System.out.println("1. Listar usuários");
        System.out.println("2. Adicionar usuário");
        System.out.println("3. Atualizar usuário");
        System.out.println("4. Remover usuário");
        System.out.print("Escolha uma opção: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                listarUsuarios(conn);
                break;
            case 2:
                adicionarUsuario(conn, scanner);
                break;
            case 3:
                atualizarUsuario(conn, scanner);
                break;
            case 4:
                removerUsuario(conn, scanner);
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private static void listarUsuarios(Connection conn) throws SQLException {
        String sql = "SELECT * FROM usuarios";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.printf("ID: %d, Nome: %s, Email: %s%n", rs.getInt("id"), rs.getString("nome"), rs.getString("email"));
            }
        }
    }

    private static void adicionarUsuario(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Digite o nome do usuário: ");
        scanner.nextLine(); // Consumir o newline
        String nome = scanner.nextLine();
        System.out.print("Digite o email do usuário: ");
        String email = scanner.nextLine();

        String sql = "INSERT INTO usuarios (nome, email) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.setString(2, email);
            int rowsInserted = pstmt.executeUpdate();
            System.out.println(rowsInserted > 0 ? "Usuário adicionado com sucesso!" : "Falha ao adicionar usuário.");
        }
    }

    private static void atualizarUsuario(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Digite o ID do usuário que deseja atualizar: ");
        int id = scanner.nextInt();
        System.out.print("Digite o novo nome: ");
        scanner.nextLine(); // Consumir o newline
        String nome = scanner.nextLine();
        System.out.print("Digite o novo email: ");
        String email = scanner.nextLine();

        String sql = "UPDATE usuarios SET nome = ?, email = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.setString(2, email);
            pstmt.setInt(3, id);
            int rowsUpdated = pstmt.executeUpdate();
            System.out.println(rowsUpdated > 0 ? "Usuário atualizado com sucesso!" : "Usuário não encontrado.");
        }
    }

    private static void removerUsuario(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Digite o ID do usuário que deseja remover: ");
        int id = scanner.nextInt();

        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rowsDeleted = pstmt.executeUpdate();
            System.out.println(rowsDeleted > 0 ? "Usuário removido com sucesso!" : "Usuário não encontrado.");
        }
    }

    // Métodos para Gerenciamento de Microgrids
    private static void gerenciarMicrogrids(Connection conn, Scanner scanner) throws SQLException {
        System.out.println("\n=== GERENCIAR MICROGRIDS ===");
        System.out.println("1. Listar microgrids");
        System.out.println("2. Adicionar microgrid");
        System.out.println("3. Atualizar microgrid");
        System.out.println("4. Remover microgrid");
        System.out.print("Escolha uma opção: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                listarMicrogrids(conn);
                break;
            case 2:
                adicionarMicrogrid(conn, scanner);
                break;
            case 3:
                atualizarMicrogrid(conn, scanner);
                break;
            case 4:
                removerMicrogrid(conn, scanner);
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private static void listarMicrogrids(Connection conn) throws SQLException {
        String sql = "SELECT * FROM microgrids";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.printf("ID: %d, Nome: %s, Potência: %.2f%n", rs.getInt("id"), rs.getString("nome"), rs.getDouble("potencia"));
            }
        }
    }

    private static void adicionarMicrogrid(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Digite o nome da microgrid: ");
        scanner.nextLine(); // Consumir o newline
        String nome = scanner.nextLine();
        System.out.print("Digite a potência da microgrid (kW): ");
        double potencia = scanner.nextDouble();

        String sql = "INSERT INTO microgrids (nome, potencia) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.setDouble(2, potencia);
            int rowsInserted = pstmt.executeUpdate();
            System.out.println(rowsInserted > 0 ? "Microgrid adicionada com sucesso!" : "Falha ao adicionar microgrid.");
        }
    }

    private static void atualizarMicrogrid(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Digite o ID da microgrid que deseja atualizar: ");
        int id = scanner.nextInt();
        System.out.print("Digite o novo nome: ");
        scanner.nextLine(); // Consumir o newline
        String nome = scanner.nextLine();
        System.out.print("Digite a nova potência (kW): ");
        double potencia = scanner.nextDouble();

        String sql = "UPDATE microgrids SET nome = ?, potencia = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.setDouble(2, potencia);
            pstmt.setInt(3, id);
            int rowsUpdated = pstmt.executeUpdate();
            System.out.println(rowsUpdated > 0 ? "Microgrid atualizada com sucesso!" : "Microgrid não encontrada.");
        }
    }

    private static void removerMicrogrid(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Digite o ID da microgrid que deseja remover: ");
        int id = scanner.nextInt();

        String sql = "DELETE FROM microgrids WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rowsDeleted = pstmt.executeUpdate();
            System.out.println(rowsDeleted > 0 ? "Microgrid removida com sucesso!" : "Microgrid não encontrada.");
        }
    }
}
