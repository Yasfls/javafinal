import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Menu {
        public static void main(String[] args) throws Exception {

        final String url = "jdbc:mysql://localhost:3306/evento";
        final String user = "root";
        final String password = "";
        Scanner scanner = new Scanner(System.in);
        int opt=0;
        Connection con = null;

        do {
            
            System.out.println("Opções: ");
            System.out.println("1 - Cadastrar Local");
            System.out.println("2 - Cadastrar Organizador");
            System.out.println("3 - Cadastrar Participante");
            System.out.println("4 - Cadastrar Evento");
            System.out.println("5 - Listar Locais");
            System.out.println("6 - Listar Organizadores");
            System.out.println("7 - Listar Participantes");
            System.out.println("8 - Listar Eventos");
            System.out.println("9 - Sair");
            try {
                opt = scanner.nextInt();
            
            switch (opt) {
                case 1: 
                    try {
                        System.out.println("Informe o id do local");
                        Integer id_local = scanner.nextInt();
                        System.out.println("Informe a descricao do local");
                        String descricao = scanner.next();
                        System.out.println("Informe o número de vagas no local");
                        Integer vagas = scanner.nextInt();
                                           
                        con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();                        
                        stm.executeUpdate("INSERT INTO local "
                            + "(id_local, desc_local, vagas_local) VALUES "
                            + "('"+id_local+"', '"+descricao+"', '"+vagas+"')");                       
                        
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    } finally {                        
                        con.close();
                    }
                    break;

                case 2:
                    try {
                        System.out.println("Informe o id do organizador");
                        Integer id_org = scanner.nextInt();
                        System.out.println("Informe o nome do organizador");
                        String nome_org = scanner.next();
                        System.out.println("Informe o email do organizador");
                        String email = scanner.next();
                        

                        con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        stm.executeUpdate("INSERT INTO organizador "
                            + "(id_org, nome_org, email_org) VALUES "
                            + "('"+id_org+"', '"+nome_org+"','"+email+"')");

                        } catch (SQLException e) {
                            System.out.println(e.getMessage());
                        } finally {                        
                            con.close();
                        }
                        break;

                case 3:
                    try {
                        System.out.println("Informe o id do participante");
                        Integer id_part = scanner.nextInt();
                        System.out.println("Informe o nome do participante");
                        String nome_part = scanner.next();
                        System.out.println("Informe o telefone do participante");
                        String telefone = scanner.next();
                                        
                        con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        stm.executeUpdate("INSERT INTO participante "
                            + "(id_part, nome_part, tel_part) VALUES "
                            + "('"+id_part+"','"+nome_part+"','"+telefone+"')");

                        } catch (SQLException e) {
                            System.out.println(e.getMessage());
                        } finally {                        
                            con.close();
                        }
                        break;

                case 4: 
                    try {
                        System.out.println("Informe o id do evento");
                        Integer id_evento = scanner.nextInt();
                        System.out.println("Informe o id do organizador");
                        Integer id_org = scanner.nextInt();
                        System.out.println("Informe o id do local");
                        Integer id_local = scanner.nextInt();
                        System.out.println("Informe o número de vagas do evento");
                        Integer vagas_evento = scanner.nextInt();
                        System.out.println("Informe a data do evento");
                        String data = scanner.next();
                        System.out.println("Informe a descricao do evento");
                        String descricao = scanner.next();
                                        
                        con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();                        
                        stm.executeUpdate("INSERT INTO evento "
                            + "(id_evento, id_org, id_local, vagas_evento, data_evento, desc_evento) VALUES "
                            + "('"+id_evento+"', '"+id_org+"', '"+id_local+"', '"+vagas_evento+"', '"+data+"', '"+descricao+"')");                       
                        
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    } finally {                        
                        con.close();
                    }
                    break;

                case 5:
                    try {
                        con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        ResultSet sql = stm.executeQuery("SELECT * FROM local;");
                        while(sql.next()) {
                            System.out.println(
                                "Id: " +  sql.getInt("id_local") 
                                + " Descrição: " + sql.getString("desc_local")
                                + " Vagas: " + sql.getInt("vagas_local")
                            );
                        }
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6:
                    try {
                        con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        ResultSet sql = stm.executeQuery("SELECT * FROM organizador;");
                        while(sql.next()) {
                            System.out.println(
                                "Id: " +  sql.getInt("id_org") 
                                + " Nome: " + sql.getString("nome_org")
                                + " Email: " + sql.getString("email_org")
                            );
                        }
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 7:
                    try {
                        con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        ResultSet sql = stm.executeQuery("SELECT * FROM participante;");
                        while(sql.next()) {
                            System.out.println(
                                "Id: " +  sql.getInt("id_part") 
                                + " Nome: " + sql.getString("nome_part")
                                + " Telefone: " + sql.getString("tel_part")
                            );
                        }
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 8:
                    try {
                        con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        ResultSet sql = stm.executeQuery("SELECT * FROM evento;");
                        while(sql.next()) {
                            System.out.println(
                                "Id: " +  sql.getInt("id_evento") 
                                + " Id organizador: " + sql.getInt("id_org")
                                + " Id Local: " + sql.getInt("id_local")
                                + " Vagas: " + sql.getInt("vagas_evento")
                                + " Data: " + sql.getString("data_evento")
                                + " Descricao: " + sql.getString("desc_evento")
                            );
                        }
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                    case 9:
                        System.out.println("Saindo...");
                        break;
                    default:
                        break;
            }
        //mensagem de erro do try catch
        } catch (Exception e) {
            System.out.println("Opção inválida");
            scanner.nextLine();
            continue;
        }
        } while (opt != 9);
    
    

        scanner.close();
        }
    
}