package pt.ipbeja.ip;

import pt.ipbeja.ip.database.row;

public class colaboradores {
    private int codColaborador;
    private String nome;
    private String tipoColaborador;
    private String senha;

    /**
     * This is the builder method
     * @param nome the name of the collaborator
     * @param tipoColaborador type of the collaborator
     * @param senha collaborator password
     */
    colaboradores(String nome, String tipoColaborador, String senha) {
        this.nome = nome;
        this.senha = senha;
        this.tipoColaborador = tipoColaborador;
    }

    /**
     * this is the method to insert the values in the rows
     * @param row that's the rows
     */
    colaboradores(row row) {
        this.codColaborador = Integer.parseInt(row.getColumns().get(0));
        this.nome = row.getColumns().get(1);
        this.senha = row.getColumns().get(2);
        this.tipoColaborador = row.getColumns().get(3);
    }

    /**
     *this method is for return the values to the database
     * @return return the values
     */
    String toDatabase(){
        return "('" + nome + "' , '" + senha + "' , '" + tipoColaborador + "')";
    }

    @Override
    public String toString() {
        return
                " cod_colaborador - " + codColaborador +
                        " | nome - " + nome  +
                        " | tipo colaborador - " + tipoColaborador +
                        " | senha - " + senha
                ;
    }
}

