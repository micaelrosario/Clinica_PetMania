package ConnectionFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/bdpetmania";
    private static final String USER = "root";
    private static final String PASS = "micaelm5s";

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);

            // Restaura o banco de dados a partir do backup
            restoreDatabaseFromBackup();

            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger("Erro ao criar Banco de Dados" + ex);
            return null;
        }
    }

    private static void restoreDatabaseFromBackup() {
        try {
            // Caminho para o arquivo de backup dentro do seu projeto
            String backupFilePath = "src/resources/backupPetMania.sql";

            // Comando para restaurar o banco de dados a partir do backup
            String command = String.format(
                    "mysql -u %s -p%s %s < %s",
                    USER, PASS, URL, backupFilePath
            );

            // Executa o comando no terminal
            ProcessBuilder processBuilder = new ProcessBuilder(command.split("\\s+"));
            processBuilder.inheritIO();
            Process process = processBuilder.start();
            process.waitFor();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    
    

    public static void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt) {

        closeConnection(con);
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {

        closeConnection(con, stmt);
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
