package pt.ipbeja.ip;

import pt.ipbeja.ip.database.DBConnection;
import pt.ipbeja.ip.database.row;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * caritas software
 * @author Tiago Sanina
 * @version 13/01/2019
 */
public class Main {

    private final static Scanner scanner = new Scanner(System.in);
    private static DBConnection db;
    private static List<colaboradores> colaboradores;
    private static List<servicos> servicos;
    private static List<utentes> utentes;
    private static List<servicosUtentes> servicosUtentes;
    private static int men;

    /**
     * The main method is to launch the program,  and the connection with the database
     * @param args Arrays of arguments
     */
    public static void main(String[] args) {
        db = new DBConnection("caritas");
        start();
    }

    /**
     * This is the start method have a login in the begin and redirect to a menu
     */
    private static void start() {
        clearScreen();
        login();
        if(men == 1){
            menu1();
        }
        else if (men == 2){
            menu2();
        }
        else if (men == 3){
            menu3();
        }
    }


    /**
     * This is the method that presents all admin menu options
     */
    private static void showMenu1Options() {
        clearScreen();
        System.out.println("+-----------------------------------+");
        System.out.println("|         Menu Administrador        |");
        System.out.println("+-----------------------------------+");
        System.out.println("| 1-> Inserir Funcionários          |");
        System.out.println("| 2-> Alterar Dados dos Funcionários|");
        System.out.println("| 3-> Remover Funcionários          |");
        System.out.println("| 4-> Inserir Serviços              |");
        System.out.println("| 5-> Alterar Serviços              |");
        System.out.println("| 6-> Remover Serviços              |");
        System.out.println("| 7-> Ver serviços por area         |");
        System.out.println("| 8-> Ver serviços por utentes      |");
        System.out.println("| 0-> Log out                       |");
        System.out.println("| 999-> Close app                   |");
        System.out.println("+-----------------------------------+");
        System.out.print("Opcao => ");
    }

    /**
     * This is the method that presents all funcionario menu options
     */
    private static void showMenu2Options() {
        clearScreen();
        System.out.println("+--------------------------------------------------+");
        System.out.println("|                 Menu Funcionário                 |");
        System.out.println("+--------------------------------------------------+");
        System.out.println("| 1-> Inserir utentes                              |");
        System.out.println("| 2-> Alterar Dados dos utentes                    |");
        System.out.println("| 3-> Remover utentes                              |");
        System.out.println("| 4-> Inserir apoio a um utente                    |");
        System.out.println("| 5-> Alterar apoio a um utente                    |");
        System.out.println("| 6-> Remover apoio a um utente                    |");
        System.out.println("| 7-> pesquisa dos serviços associados aos utentes |");
        System.out.println("| 0-> Log out                                      |");
        System.out.println("| 999-> Close app                                  |");
        System.out.println("+--------------------------------------------------+");
        System.out.print("Opcao => ");
    }

    /**
     * This is the method that presents all ajudante menu options
     */
    private static void showMenu3Options() {
        clearScreen();
        System.out.println("+----------------------------------+");
        System.out.println("|           Menu Ajudante          |");
        System.out.println("+----------------------------------+");
        System.out.println("| 1-> Marcar Serviço como prestado |");
        System.out.println("| 2-> Estado dos serviços          |");
        System.out.println("| 0-> Log out                      |");
        System.out.println("| 999-> Close app                  |");
        System.out.println("+----------------------------------+");
        System.out.print("Opcao => ");
    }

    /**
     * This is the admin menu method, which will basically redirect to all program features
     */
    private  static void menu1(){
        String ans;

        do {
            showMenu1Options();

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    insertFuncionarios();
                    break;
                case 2:
                    alterFuncionarios();
                    break;
                case 3:
                    deleteFuncionarios();
                    break;
                case 4:
                    insertServico();
                    break;
                case 5:
                    alterServico();
                    break;
                case 6:
                    removeServico();
                    break;
                case 7:
                    servicosArea();
                    break;
                case 8:
                    servicosUtente();
                    break;
                case 0:
                    start();
                case 999:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please choose a number between 1 and 8.");
            }
            System.out.print("Go back to the menu? (y/n)");
            ans = scanner.next();
            if (ans.equals("n")) {
                login();
            }
        } while (ans.equals("y"));
    }

    /**
     * This is the funcionario menu method, which will basically redirect to all program features
     */
    private  static void menu2(){
        String ans;

        do {
            showMenu2Options();

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    insertUtentes();
                    break;
                case 2:
                    alterUtentes();
                    break;
                case 3:
                    deleteUtentes();
                    break;
                case 4:
                    insertApoio();
                    break;
                case 5:
                    alterApoio();
                    break;
                case 6:
                    deleteApoio();
                    break;
                case 7:
                    servicosUtentes();
                    break;
                case 0:
                    start();
                    break;
                case 999:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please choose a number between 1 and 7.");
            }
            System.out.print("Go back to the menu? (y/n)");
            ans = scanner.next();
            if (ans.equals("n")) {
                login();
            }
        } while (ans.equals("y"));
    }

    /**
     * This is the ajudante menu method, which will basically redirect to all program features
     */
    private  static void menu3(){
        String ans;

        do {
            showMenu3Options();

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    servicoPrestado();
                    break;
                case 2:
                    servicoAgendado();
                    break;
                case 0:
                    System.out.println("Exit");
                    start();
                    break;
                case 999:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please choose a number between 1 and 2.");
            }
            System.out.print("Go back to the menu? (y/n)");
            ans = scanner.next();
            if (ans.equals("n")) {
                login();
            }
        } while (ans.equals("y"));
    }

    /**
     * this method is for clear the screen
     */
    private static void clearScreen() {
        for (int i = 0; i < 12; i++)
            System.out.println();
    }
    /**
     * this method is for login
     */
    private static void login() {
        String nome;
        String password;
        System.out.println("+--------------------------------------------------+");
        System.out.println("|                       Login                      |");
        System.out.println("+--------------------------------------------------+");
        System.out.println("Digite o seu nome de utilizador: ");
        nome = scanner.nextLine();
        nome =  "'%" + nome + "%'";
        System.out.println("Digite a sua password: ");
        password = scanner.nextLine();
        password =  "'%" + password + "%'";

        try {
            db.connect();
            List<row> result = db.select("SELECT * FROM `colaboradores` WHERE `nome` LIKE " +  nome + "AND `senha` LIKE " + password);
            List<row> result2 = db.select("SELECT tipo_colaborador FROM `colaboradores` WHERE `nome` LIKE " + nome);
            db.close();

            if (result.size() > 0) {
                System.out.println("Login realizado com sucesso!");
                switch (result2.get(0).toString()) {
                    case "[Admin]":
                        men = 1;
                        break;
                    case "[Funcionario]":
                        men = 2;
                        break;
                    case "[Ajudante]":
                        men = 3;
                        break;
                }
            }
            else {
                System.out.println("Name or Password are wrong");
            }
        } catch (Exception e) {
            System.out.println("Name or Password are wrong.");
        }
    }

    /**
     * insert funcionarios or ajudantes
     */
    private  static void insertFuncionarios(){
        clearScreen();

        scanner.nextLine();
        System.out.print("Nome de usuario? ->");
        String nome = scanner.nextLine();

        System.out.println("Palavra-passe? ->");
        String senha = scanner.nextLine();

        System.out.println("Opcoes: \b -Funcionario \b -Ajudante");
        System.out.println("Tipo do novo usuario? ->");
        String type = scanner.nextLine();

        colaboradores newS = new colaboradores(nome,  type, senha);

        db.connect();
        boolean b = db.insert("INSERT INTO colaboradores ( nome, senha, tipo_colaborador ) VALUES " + newS.toDatabase());
        db.close();


        if (!b) {
            System.out.println("There is an error connecting to the database.");
        }
    }

    /**
     * alter funcionarios
     */
    private  static void alterFuncionarios(){
        clearScreen();

        colaboradores = new ArrayList<>();

        db.connect();
        List<row> result = db.select("SELECT * FROM colaboradores");
        db.close();

        for (int i = 0; i < result.size(); i++) {
            colaboradores.add(new colaboradores(result.get(i)));
        }

        for (int i = 0; i < colaboradores.size(); i++) {
            System.out.println(colaboradores.get(i).toString());
        }

        scanner.nextLine();
        System.out.print("ID do Funcionario que quer alterar? ->");
        String id = scanner.nextLine();

        System.out.print("Novo de usuario para o Funcionario? ->");
        String nomeN = scanner.nextLine();

        System.out.println("Nova Palavra-passe do novo usuario? ->");
        String senhaN = scanner.nextLine();

        System.out.println("Opcoes: \b -Funcionario \b -Ajudante");
        System.out.println("Tipo do novo usuario? ->");
        String type = scanner.nextLine();

        id = "'" + id + "'";
        nomeN = "'" + nomeN + "'";
        senhaN = "'" + senhaN + "'";
        type = "'" + type + "'";

        db.connect();
        boolean b = db.insert("UPDATE `colaboradores` SET `cod_colaborador`= " + id + ",`nome`=" + nomeN + ",`senha`= " + senhaN + ",`tipo_colaborador`=" + type + " WHERE cod_colaborador = " + id);
        db.close();

        if (!b) {
            System.out.println("There is an error connecting to the database.");
        }
    }

    /**
     * delete funcionarios or ajudantes
     */
    private  static void deleteFuncionarios(){
        clearScreen();

        colaboradores = new ArrayList<>();

        db.connect();
        List<row> result = db.select("SELECT * FROM colaboradores");
        db.close();

        for (int i = 0; i < result.size(); i++) {
            colaboradores.add(new colaboradores(result.get(i)));
        }

        for (int i = 0; i < colaboradores.size(); i++) {
            System.out.println(colaboradores.get(i).toString());
        }

        System.out.println("Insere o id do funcionario:");
        int id = scanner.nextInt();

        db.connect();
        boolean result2 = db.delete("DELETE FROM colaboradores WHERE cod_colaborador= " + id);
        db.close();


        if (!result2) {
            System.out.println("There is an error connecting to the database.");
        }
    }

    /**
     * insert servico
     */
    private  static void insertServico(){
        clearScreen();

        scanner.nextLine();
        System.out.print("Area do servico: ->");
        String area = scanner.nextLine();

        System.out.println("nome do servico: ->");
        String nome = scanner.nextLine();

        servicos newS = new servicos(area, nome);

        db.connect();
        boolean b = db.insert("INSERT INTO servicos ( area, nome_servico ) VALUES " + newS.toDatabase());
        db.close();


        if (!b) {
            System.out.println("There is an error connecting to the database.");
        }
    }

    /**
     * alter servico
     */
    private  static void alterServico(){
        clearScreen();

        servicos = new ArrayList<>();

        db.connect();
        List<row> result = db.select("SELECT * FROM servicos");
        db.close();

        for (int i = 0; i < result.size(); i++) {
            servicos.add(new servicos(result.get(i)));
        }

        for (int i = 0; i < servicos.size(); i++) {
            System.out.println(servicos.get(i).toString());
            System.out.println(" ");
        }

        scanner.nextLine();
        System.out.print("ID do serviço que quer alterar? ->");
        String id = scanner.nextLine();

        System.out.print("Area do servico: ->");
        String newArea = scanner.nextLine();

        System.out.println("nome do servico: ->");
        String newNome = scanner.nextLine();

        id = "'" + id + "'";
        newArea = "'" + newArea + "'";
        newNome = "'" + newNome + "'";

        db.connect();
        boolean b = db.insert("UPDATE `servicos` SET `cod_servico`= " + id + ",`area`=" + newArea + ",`nome_servico`= " + newNome + " WHERE cod_servico = " + id);
        db.close();

        if (!b) {
            System.out.println("There is an error connecting to the database.");
        }
    }

    /**
     * delete servico
     */
    private  static void removeServico(){
        clearScreen();

        servicos = new ArrayList<>();

        db.connect();
        List<row> result = db.select("SELECT * FROM servicos");
        db.close();

        for (int i = 0; i < result.size(); i++) {
            servicos.add(new servicos(result.get(i)));
        }

        for (int i = 0; i < servicos.size(); i++) {
            System.out.println(servicos.get(i).toString());
            System.out.println(" ");
        }

        System.out.println("Insere o id do servico:");
        int id = scanner.nextInt();

        db.connect();
        boolean result2 = db.delete("DELETE FROM servicos WHERE cod_servico= " + id);
        db.close();


        if (!result2) {
            System.out.println("There is an error connecting to the database.");
        }
    }

    /**
     * servicos for area
     */
    private  static void servicosArea(){
        clearScreen();

        String area;

        System.out.println("Areas: \n alojamento \n alimentacao \n higiene \n roupa \n financeira \n convivio");

        System.out.print("Area do servico: ->");
        scanner.nextLine();
        area = scanner.nextLine();
        area =  "'%" + area + "%'";

        db.connect();
        List<row> result = db.select("SELECT * FROM `servicos` WHERE `area` LIKE " +  area);
        db.close();

        System.out.println(result);
    }

    /**
     * services for utente
     */
    private  static void servicosUtente(){
        clearScreen();

        servicosUtentes = new ArrayList<>();

        db.connect();
        List<row> result = db.select("SELECT * FROM servicos_utentes");
        db.close();

        for (int i = 0; i < result.size(); i++) {
            servicosUtentes.add(new servicosUtentes(result.get(i)));
        }

        for (int i = 0; i < servicosUtentes.size(); i++) {
            System.out.println(servicosUtentes.get(i).toString());
        }
    }

    /**
     * insert utentes
     */
    private  static void insertUtentes(){
        clearScreen();

        scanner.nextLine();
        System.out.print("Nome do utente? ->");
        String nome = scanner.nextLine();

        System.out.println();
        System.out.print("Morada do utente? ->");
        String morada = scanner.nextLine();

        System.out.println();
        System.out.println("Profissao do utente? ->");
        String profissao = scanner.nextLine();

        utentes newS = new utentes(nome,  morada, profissao);

        db.connect();
        boolean b = db.insert("INSERT INTO utentes ( nome, profissao, morada ) VALUES " + newS.toDatabase());
        db.close();


        if (!b) {
            System.out.println("There is an error connecting to the database.");
        }
    }

    /**
     * alter utentes
     */
    private  static void alterUtentes(){
        clearScreen();

        utenteView();

        scanner.nextLine();
        System.out.print("ID do utente que quer alterar? ->");
        String id = scanner.nextLine();

        System.out.print("nome do utente? ->");
        String newNome = scanner.nextLine();
        System.out.println();

        System.out.println("Morada do utente? ->");
        String newMorada = scanner.nextLine();
        System.out.println();

        System.out.println("profissao do utente? ->");
        String newProfissao = scanner.nextLine();
        System.out.println();

        id = "'" + id + "'";
        newNome = "'" + newNome + "'";
        newMorada = "'" + newMorada + "'";
        newProfissao = "'" + newProfissao + "'";

        db.connect();
        boolean b = db.insert("UPDATE `utentes` SET `cod_utente`= " + id +
                                                            ",`nome`=" + newNome +
                                                            ",`profissao`= " + newProfissao +
                                                            ",`morada`= " + newMorada +
                                                            " WHERE cod_utente = " + id);
        db.close();


        if (!b) {
            System.out.println("There is an error connecting to the database.");
        }
    }

    /**
     * alter utentes
     */
    private  static void deleteUtentes(){
        clearScreen();

        utentes = new ArrayList<>();

        db.connect();
        List<row> result = db.select("SELECT * FROM utentes");
        db.close();

        for (int i = 0; i < result.size(); i++) {
            utentes.add(new utentes(result.get(i)));
        }

        for (int i = 0; i < utentes.size(); i++) {
            System.out.println(utentes.get(i).toString());
            System.out.println(" ");
        }

        System.out.println("Insere o id do utente:");
        int id = scanner.nextInt();

        db.connect();
        boolean result2 = db.delete("DELETE FROM utentes WHERE cod_utente= " + id);
        db.close();

        if (!result2) {
            System.out.println("Verifica se não ha nehuma ligacao com outra tabela");
        }
    }

    /**
     * insert apoio
     */
    private  static void insertApoio(){
        clearScreen();

        utenteView();

        System.out.println(" ");

        servicos = new ArrayList<>();

        db.connect();
        List<row> result2 = db.select("SELECT * FROM servicos");
        db.close();

        for (int i = 0; i < result2.size(); i++) {
            servicos.add(new servicos(result2.get(i)));
        }

        for (int i = 0; i < servicos.size(); i++) {
            System.out.println(servicos.get(i).toString());
        }

        scanner.nextLine();
        System.out.print("Id do utente? ->");
        String codUtente = scanner.nextLine();

        System.out.println();
        System.out.print("Id do servico? ->");
        String codServico = scanner.nextLine();

        System.out.println();
        System.out.println("Estado do servico? ->");
        String estado = scanner.nextLine();

        System.out.println();
        System.out.println("Data da requesição? ->");
        String data = scanner.nextLine();

        servicosUtentes newS = new servicosUtentes(codUtente, codServico, estado, data);

        db.connect();
        boolean b = db.insert("INSERT INTO `servicos_utentes`(`cod_utente`, `cod_servico`, `estado`, `data_requesicao`) VALUES " + newS.toDatabase());
        db.close();

        if (!b) {
            System.out.println("There is an error connecting to the database.");
        }
    }

    /**
     * view the table utentes
     */
    private static void utenteView(){
        clearScreen();

        utentes = new ArrayList<>();

        db.connect();
        List<row> result = db.select("SELECT * FROM utentes");
        db.close();

        for (int i = 0; i < result.size(); i++) {
            utentes.add(new utentes(result.get(i)));
        }

        for (int i = 0; i < utentes.size(); i++) {
            System.out.println(utentes.get(i).toString());
        }
    }

    /**
     * alter apoio
     */
    private  static void alterApoio(){
        clearScreen();

        servicoUtente();

        scanner.nextLine();
        System.out.print("Id do apoio? ->");
        String idRequesicao = scanner.nextLine();

        System.out.print("Id do utente? ->");
        String idUtente = scanner.nextLine();

        System.out.print("Id do servico? ->");
        String idServico = scanner.nextLine();
        System.out.println();

        System.out.println("Estado do servico? ->");
        String newEstado = scanner.nextLine();
        System.out.println();

        System.out.println("Data da requesição? ->");
        String newData = scanner.nextLine();
        System.out.println();

        idRequesicao = "'" + idRequesicao + "'";
        idUtente = "'" + idUtente + "'";
        idServico = "'" + idServico + "'";
        newEstado = "'" + newEstado + "'";
        newData = "'" + newData + "'";

        db.connect();
        boolean b = db.insert("UPDATE `servicos_utentes` SET " + "`cod_requesicao`= " + idRequesicao +
                ",`cod_utente`= " + idUtente +
                ",`cod_servico`=" + idServico +
                ",`estado`= " + newEstado +
                ",`data_requesicao`= " + newData +
                " WHERE cod_requesicao = " + idRequesicao);
        db.close();


        if (!b) {
            System.out.println("There is an error connecting to the database.");
        }
    }

    /**
     * view table servico servico utentes
     */
    private static void servicoUtente(){
        clearScreen();

        servicosUtentes = new ArrayList<>();

        db.connect();
        List<row> result = db.select("SELECT * FROM servicos_utentes");
        db.close();

        for (int i = 0; i < result.size(); i++) {
            servicosUtentes.add(new servicosUtentes(result.get(i)));
        }

        for (int i = 0; i < servicosUtentes.size(); i++) {
            System.out.println(servicosUtentes.get(i).toString());
            System.out.println(" ");
        }
    }

    /**
     * delete apoio
     */
    private  static void deleteApoio(){
        clearScreen();

        servicosUtentes = new ArrayList<>();

        db.connect();
        List<row> result = db.select("SELECT * FROM servicos_utentes");
        db.close();

        for (int i = 0; i < result.size(); i++) {
            servicosUtentes.add(new servicosUtentes(result.get(i)));
        }

        for (int i = 0; i < servicosUtentes.size(); i++) {
            System.out.println(servicosUtentes.get(i).toString());
            System.out.println(" ");
        }

        System.out.println("Insere o id do apoio:");
        int id = scanner.nextInt();

        db.connect();
        boolean result2 = db.delete("DELETE FROM servicos_utentes WHERE cod_requesicao = " + id);
        db.close();


        if (!result2) {
            System.out.println("There is an error connecting to the database.");
        }
    }

    /**
     * view table utentes
     */
    private  static void servicosUtentes(){
        clearScreen();

        servicosUtentes = new ArrayList<>();

        db.connect();
        List<row> result = db.select("SELECT * FROM servicos_utentes");
        db.close();

        for (int i = 0; i < result.size(); i++) {
            servicosUtentes.add(new servicosUtentes(result.get(i)));
        }

        for (int i = 0; i < servicosUtentes.size(); i++) {
            System.out.println(servicosUtentes.get(i).toString());
            System.out.println(" ");
        }
    }

    /**
     * servico alter state
     */
    private  static void servicoPrestado(){
        clearScreen();

        utenteView();

        servicoAgendado();

        scanner.nextLine();
        System.out.print("Id do apoio? ->");
        String idRequesicao = scanner.nextLine();

        System.out.print("Mudar estado do servico? ->");
        String newEstado = scanner.nextLine();

        idRequesicao = "'" + idRequesicao + "'";
        newEstado = "'" + newEstado + "'";

        db.connect();
        boolean b = db.insert("UPDATE `servicos_utentes` SET " +
                "`estado`= " + newEstado +
                " WHERE cod_requesicao = " + idRequesicao);
        db.close();


        if (!b) {
            System.out.println("There is an error connecting to the database.");
        }
    }

    /**
     * scheduled servicos
     */
    private  static void servicoAgendado(){
        System.out.println(" ");

        servicosUtentes = new ArrayList<>();

        System.out.println("Insere o id do utente:");
        int id = scanner.nextInt();

        db.connect();
        List<row> result = db.select("SELECT * FROM servicos_utentes WHERE cod_utente = " + id);
        db.close();

        for (int i = 0; i < result.size(); i++) {
            servicosUtentes.add(new servicosUtentes(result.get(i)));
        }

        for (int i = 0; i < servicosUtentes.size(); i++) {
            System.out.println(servicosUtentes.get(i).toString());
            System.out.println(" ");
        }
    }
}
