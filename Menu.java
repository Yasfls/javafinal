import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Scanner;

public class Menu {
        public static void main(String[] args) throws Exception {
        final String url = "jdbc:mysql://localhost:3306/javafinal";
        final String user = "root";
        final String password = "";
        Scanner scanner = new Scanner(System.in);
        int opt=0;
        do {
            
            System.out.println("Opções: ");
            System.out.println("1 - Cadastrar Local");
            System.out.println("2 - Cadastrar Organizador");
            System.out.println("3 - Cadastrar Participante");
            System.out.println("4 - Cadastrar Evento");
            System.out.println("5 - Cadastrar Pessoa");
            System.out.println("6 - Listar Locais");
            System.out.println("7 - Listar Organizadores");
            System.out.println("8 - Listar Participantes");
            System.out.println("9 - Listar Eventos");
            System.out.println("10 - Listar Pessoas");
            System.out.println("11 - Sair");
            try {
                opt = scanner.nextInt();
            
            //opção 1 - inserindo os dados no objeto Pofessor
            switch (opt) {
                case 1: 
                    try {
                        System.out.println("Informe o id do local");
                        Integer id_local = scanner.nextInt();
                        System.out.println("Informe a descricao do local");
                        String descricao = scanner.nextLine();
                        System.out.println("Informe o número de vagas no local");
                        Integer vagas = scanner.nextInt();
                                           
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        boolean sql = stm.execute("INSERT INTO lugar "
                            + "(id_local, descricao, vagas) VALUES "
                            + "('"+id_local+"', '"+descricao+"', '"+vagas+"')");
                        if(!sql) {
                            System.out.println("Falha na execução");
                        }
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            //opção 2 - inserindo os dados no objeto curso
                case 2: 
                    try {
                        System.out.println("Informe o id do organizador");
                        Integer id_organizador = scanner.nextInt();
                        System.out.println("Informe o email do organizador");
                        String email = scanner.nextLine();
                                           
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        boolean sql = stm.execute("INSERT INTO organizador "
                            + "(id_organizador, email) VALUES "
                            + "('"+id_organizador+"', '"+email+"')");
                        if(!sql) {
                            System.out.println("Falha na execução");
                        }
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            //opção 3 - inserindo os dados no objeto aluno
                case 3: 
                    try {
                        System.out.println("Informe o id do participante");
                        Integer id_participante = scanner.nextInt();
                        System.out.println("Informe o telefone do participante");
                        String telefone = scanner.nextLine();
                                           
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        boolean sql = stm.execute("INSERT INTO participante "
                            + "(id_participante, telefone) VALUES "
                            + "('"+id_participante+"', '"+telefone+"')");
                        if(!sql) {
                            System.out.println("Falha na execução");
                        }
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4: 
                    try {
                        System.out.println("Informe o id do evento");
                        Integer id_evento = scanner.nextInt();
                        System.out.println("Informe o id do organizador do evento");
                        Integer id_organizador = scanner.nextInt();
                        System.out.println("Informe o id do local do evento");
                        Integer id_local = scanner.nextInt();
                        System.out.println("Informe a data do evento");
                        String data = scanner.next();
                        System.out.println("Informe o numero de vagas");
                        Integer vagas = scanner.nextInt();
                                           
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        boolean sql = stm.execute("INSERT INTO evento "
                            + "(id_evento, id_organizador, id_local, data, vagas) VALUES "
                            + "('"+id_evento+"', '"+id_organizador+"', '"+id_local+"', '"+data+"', '"+vagas+"')");
                        if(!sql) {
                            System.out.println("Falha na execução");
                        }
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5: 
                    try {
                        System.out.println("Informe o id da pessoa");
                        Integer id_pessoa = scanner.nextInt();
                        System.out.println("Informe o nome da pessoa");
                        String nome = scanner.nextLine();
                                           
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        boolean sql = stm.execute("INSERT INTO pessoa "
                            + "(id_pessoa, nome) VALUES "
                            + "('"+id_pessoa+"', '"+nome+"')");
                        if(!sql) {
                            System.out.println("Falha na execução");
                        }
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            //opção 4 - imprimindo a lista de professores
                case 6:
                try {
                    Connection con = DriverManager.getConnection(url, user, password);
                    Statement stm = con.createStatement();
                    ResultSet sql = stm.executeQuery("SELECT * FROM lugar;");
                    while(sql.next()) {
                        System.out.println(new Lugar(
                            sql.getInt("id_local"),
                            sql.getString("descricao"),
                            sql.getString("vagas")
                        ));
                    }
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                break;

                case 11:
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
        } while (opt != 11);
    
    

        scanner.close();
        }
    
}