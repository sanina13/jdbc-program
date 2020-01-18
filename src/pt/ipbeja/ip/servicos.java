package pt.ipbeja.ip;

import pt.ipbeja.ip.database.row;

public class servicos {
    private int codServico;
    private String area;
    private String nome_servico;

    /**
     * This is the builder method
     * @param area area of the service
     * @param nome_servico name of the service
     */
    servicos(String area, String nome_servico) {
        this.area = area;
        this.nome_servico = nome_servico;
    }

    /**
     * this is the method to insert the values in the rows
     * @param row that's the rows
     */
    servicos(row row) {
        this.codServico = Integer.parseInt(row.getColumns().get(0));
        this.area = row.getColumns().get(1);
        this.nome_servico = row.getColumns().get(2);
    }

    /**
     *this method is for return the values to the database
     * @return return the values
     */
    String toDatabase(){
        return "('" + area + "' , '" + nome_servico + "')";
    }

    @Override
    public String toString() {
        return
                " cod_servicos - " + codServico + " | nome servico - " + nome_servico  + " |  area - " + area;
    }

}

