public class Participante {
    Pessoa id_participante;
    Pessoa nome_part;
    String telefone;

    public Participante(
        Pessoa id_participante,
        Pessoa nome_part,
        String telefone
        ){
            this.id_participante = id_participante;
            this.nome_part = nome_part;
            this.telefone = telefone;
        }
}
