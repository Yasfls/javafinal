public class Organizador {
    Pessoa id_organizador;
    Pessoa nome_org;
    String email;

    public Organizador(
        Pessoa id_organizador,
        Pessoa nome_org,
        String email
        ){
            this.id_organizador = id_organizador;
            this.nome_org = nome_org;
            this.email = email;
        }
}
