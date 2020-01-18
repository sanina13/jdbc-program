package pt.ipbeja.ip;

import pt.ipbeja.ip.database.row;

public class servicosUtentes {
    private int codRequesicao;
    private String codUtente;
    private String codServico;
    private String estado;
    private String dataRequesicao;

    /**
     * This is the builder method
     * @param estado state of the service
     * @param dataRequesicao data of the service
     */
    servicosUtentes(String estado, String dataRequesicao) {
        this.estado = estado;
        this.dataRequesicao = dataRequesicao;
    }

    /**
     * this is the method to insert the values in the rows
     * @param row that's the rows
     */
    servicosUtentes(row row) {
        this.codRequesicao = Integer.parseInt(row.getColumns().get(0));
        this.codUtente = row.getColumns().get(1);
        this.codServico = row.getColumns().get(2);
        this.estado = row.getColumns().get(3);
        this.dataRequesicao = row.getColumns().get(4);
    }

    /**
     * This is the builder method
     * @param codUtente id utente
     * @param codServico id servico
     * @param estado state of the service
     * @param dataRequesicao date of the service
     */
    servicosUtentes(String codUtente, String codServico, String estado, String dataRequesicao) {
        this.codUtente = codUtente;
        this.codServico = codServico;
        this.estado = estado;
        this.dataRequesicao = dataRequesicao;
    }

    /**
     *this method is for return the values to the database
     * @return return the values
     */
    String toDatabase(){
        return "('" + codUtente + "' , '" + codServico + "', '" + estado + "' , '" + dataRequesicao + "')";
    }

    @Override
    public String toString() {
        return
                " cod_Requesicao - " + codRequesicao +
                        " |cod_utente - " + codUtente +
                        " |cod_servicos - " + codServico +
                        " | estado servico - " + estado  +
                        " |  data_requesicao - " + dataRequesicao;
    }

}

