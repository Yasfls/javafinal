public class Evento {
    int id_evento;
    int id_organizador;
    int id_local;
    String data;
    String descricao;
    int vagas;

    public Evento(
        int id_evento,
        int id_organizador,
        int id_local,
        String data,
        String descricao,
        int vagas
        ){
            this.id_evento = id_evento;
            this.id_organizador = id_organizador;
            this.id_local = id_local;
            this.data = data;
            this.descricao = descricao;
            this.vagas = vagas;
        }
}
