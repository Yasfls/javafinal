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
                        String descricao = scanner.next();
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
                        String email = scanner.next();
                                           
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
                        String telefone = scanner.next();
                                           
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
            //opção 4 - imprimindo a lista de professores
                case 6:
                try {
                    Connection con = DriverManager.getConnection(url, user, password);
                    Statement stm = con.createStatement();
                    ResultSet sql = stm.executeQuery("SELECT * FROM lugar;");
                    while(sql.next()) {
                        System.out.println(new lugar(
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
                //opção 5 imprimindo as inserções do objeto curso com o nome do professor que o leciona, sendo puxado pelo id inserido no objeto
                case 7:
                try {
                    Connection con = DriverManager.getConnection(url, user, password);
                    Statement stm = con.createStatement();
                    ResultSet sql = stm.executeQuery("SELECT * FROM aluno;");
                    while(sql.next()) {
                        ResultSet sqlCurso = stm.executeQuery("SELECT * FROM curso WHERE id = " + sql.getInt("idCurso") + ";");

                        if (sqlCurso.next()) {
                            ResultSet sqlProfessor = stm.executeQuery("SELECT * FROM professor WHERE id = " + sqlCurso.getInt("idProfessor") + ";");

                            if (sqlProfessor.next()) {
                                Professor professor = new Professor(
                                    sqlProfessor.getInt("idProfessor"),
                                    sqlProfessor.getString("nomeProfessor"),
                                    sqlProfessor.getString("departamentoProf")
                                );
    
                                Curso curso = new Curso(
                                    sqlCurso.getInt("idCurso"),
                                    sqlCurso.getString("nomeCurso"),
                                    sqlCurso.getInt("cargaHoras"),
                                    professor
                                );
    
                                System.out.println(new Curso(
                                    sqlCurso.getInt("idCurso"),
                                    sqlCurso.getString("nomeCurso"),
                                    sqlCurso.getInt("cargaHoras"),
                                    professor
                                ));
                            }
                        }
                    }
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                break;
                //opção 6 imprimindo as inerções do objeto aluno com o nome do curso em que ele está matriculado, o nome é puxado pelo id inserido no objeto
                case 8:
                try {
                    Connection con = DriverManager.getConnection(url, user, password);
                    Statement stm = con.createStatement();
                    ResultSet sql = stm.executeQuery("SELECT * FROM curso;");
                    while(sql.next()) {
                        ResultSet sqlCurso = stm.executeQuery("SELECT * FROM curso WHERE id = " + sql.getInt("idCurso") + ";");

                        if (sqlCurso.next()) {
                            ResultSet sqlProfessor = stm.executeQuery("SELECT * FROM professor WHERE id = " + sqlCurso.getInt("idProfessor") + ";");

                            if (sqlProfessor.next()) {
                                Professor professor = new Professor(
                                    sqlProfessor.getInt("idProfessor"),
                                    sqlProfessor.getString("nomeProfessor"),
                                    sqlProfessor.getString("departamentoProf")
                                );
    
                                System.out.println(new Curso(
                                    sql.getInt("idCurso"),
                                    sql.getString("nomeCurso"),
                                    sql.getString("cargaHoras"),
                                    
                                ));
                            }
                        }
                    }
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                break;
                //opção 7 fecha o programa e saí do loop do while
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