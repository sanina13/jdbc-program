package pt.ipbeja.ip;

import pt.ipbeja.ip.database.row;

public class utentes {
    private int codUtente;
    private String nome;
    private String morada;
    private String profissao;

    /**
     * This is the builder method
     * @param nome name of the utente
     * @param morada utente adress
     * @param profissao utente job
     */
    utentes(String nome, String morada, String profissao) {
        this.nome = nome;
        this.morada = morada;
        this.profissao = profissao;
    }

    /**
     * this is the method to insert the values in the rows
     * @param row that's the rows
     */
    utentes(row row) {
        this.codUtente = Integer.parseInt(row.getColumns().get(0));
        this.nome = row.getColumns().get(1);
        this.profissao = row.getColumns().get(2);
        this.morada = row.getColumns().get(3);
    }

    /**
     * this method is for return the values to the database
     * @return return the values
     */
    String toDatabase(){
        return "('" + nome + "' , '" + profissao + "' , '" + morada + "')";
    }

    @Override
    public String toString() {
        return
                " cod_utente - " + codUtente +
                        " | nome utente - " + nome  +
                        " |  morada - " + morada +
                        " |  profissao - " + profissao;
    }

}
