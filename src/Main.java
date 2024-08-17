//import javax.swing.JOptionPane;
//
//public class MenuComunidades {
//    static String[] comunidades = new String[100];
//    static String[] produtosFaltantes = new String[100];
//    static int[] quantidadesFaltantes = new int[100];
//    static int indiceVazio = 0;
//
//    public static void main(String[] args) {
//        menuComunidade();
//    }
//
//    public static void menuComunidade() {
//        int op;
//        do {
//            op = Integer.parseInt(JOptionPane.showInputDialog(
//                    " Menu Comunidade \n" +
//                            "8  - Cadastrar comunidade \n" +
//                            "9  - Editar comunidade \n" +
//                            "10 - Visualizar comunidade \n" +
//                            "0 - Sair"
//            ));
//
//            switch (op) {
//                case 8:
//                    cadastrarComunidade();
//                    break;
//                case 9:
//                    editarComunidade();
//                    break;
//                case 10:
//                    visualizarComunidade();
//                    break;
//                case 0:
//                    break;
//                default:
//                    JOptionPane.showMessageDialog(null, "Opção inválida");
//                    break;
//            }
//        } while (op != 0);
//    }
//
//    public static void cadastrarComunidade() {
//        String nome = JOptionPane.showInputDialog("Digite o nome da comunidade carente: ").toUpperCase();
//        String produtoFaltante = JOptionPane.showInputDialog("Digite o produto que falta para a comunidade: ").toLowerCase();
//        int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade que falta: "));
//
//        comunidades[indiceVazio] = nome;
//        produtosFaltantes[indiceVazio] = produtoFaltante;
//        quantidadesFaltantes[indiceVazio] = quantidade;
//
//        indiceVazio++;
//    }
//
//    public static void editarComunidade(){
//        String nomeComunidade = JOptionPane.showInputDialog("Digite o nome da comunidade que deseja editar: ").toUpperCase();
//        for (int i = 0; i < indiceVazio; i++) {
//            if (comunidades[i].equals(nomeComunidade)) {
//                String novoProdutoFaltante = JOptionPane.showInputDialog("Digite o produto mais em falta: ").toLowerCase();
//                int novaQuantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantidade que falta: "));
//                produtosFaltantes[i] = novoProdutoFaltante;
//                quantidadesFaltantes[i] = novaQuantidade;
//                JOptionPane.showMessageDialog(null, "Comunidade atualizada com sucesso.");
//                return;
//            }
//        }
//        JOptionPane.showMessageDialog(null, "Comunidade não encontrada.");
//    }
//
//
//    public static void visualizarComunidade() {
//        String mensagem = "";
//        for (int i = 0; i < indiceVazio; i++) {
//            mensagem += "Comunidade: " + comunidades[i] + "\nProduto em falta no momento: " + produtosFaltantes[i] + "\nQuantidade em falta: " + quantidadesFaltantes[i] + "\n\n";
//        }
//        JOptionPane.showMessageDialog(null, mensagem);
//    }
//}




/* Sistema de Controle de Estoque
 * Autor: Joao Lima
 * Disciplina: Algoritmos
 * Curso: ADS - 2º Semestre
 * Data: 22/11/2023
 */

import javax.swing.JOptionPane;

public class Main{
    static String[] comunidades = new String[100];
    static String[] produtosFaltantes = new String[100];
    static int[] quantidadesFaltantes = new int[100];
    static int indiceVazio = 0;

    public static void main(String[] args) {
        menu();
    }

// Dados armazenados na matriz codVal (Linhas)	- As colunas armazenam os produtos
    // 0- Reservado/Não utilizado
    // 1- Código do produto - Executado por: execCad
    // 2- Quantidade de Entradas - Executado por: execCadEntr
    // 3- Quantidade de Saidas - Executado por: execCadVenda
    // 4- Quantidade em Estoque	- Executado por: execCadEntr (Adiciona) e execSaida (retira)



    // Menu do programa
    public static void menu(){

        double codVal [][] = new double [7][200];
        String nomeProd [] = new String [200];
        // Adicione esses arrays para as comunidades carentes e os materiais necessários
        String[] comunidades = new String[200];
        String[] materiais = new String[200];
        int indiceVazio=0, op;


        do{
            op = Integer.parseInt(JOptionPane.showInputDialog(
                    "                ESTOQUE ONG UNASP\n\n\n"+
                            "                        Menu Principal \n\n" +
                            "1  - Cadastrar o produto \n"+ "" +
                            "2  - Entradas de produtos \n"+
                            "3  - Saidas de produtos \n" +
                            "4  - Consulta de produtos (Informando código)\n" +
                            "5  - Consulta de produtos (Informando nome) \n" +
                            "6  - Relatório de estoque \n" +
                            "7  - Alterar quantidade\n"+
                            "8  - Comunidades\n"+

                            /*"999 - Cadastro automático de 7 produtos para teste\n"+*/
                            "0 - Sair do Sistema"));

            switch (op) {

                case 1:
                    indiceVazio = cadastro(nomeProd, codVal, indiceVazio);
                    break;

                case 2:
                    cadEntradas(nomeProd, codVal, indiceVazio);
                    break;

                case 3:
                    cadSaidas (nomeProd, codVal, indiceVazio);
                    break;

                case 4:
                    consProdCod(nomeProd, codVal, indiceVazio);
                    break;

                case 5:
                    consProdNome(nomeProd, codVal, indiceVazio);
                    break;

             /*   case 6:
                    relCompras(nomeProd, codVal, indiceVazio);
                    break;*/

              /*  case 7:
                    relVendas(nomeProd, codVal, indiceVazio);
                    break;*/

                case 6:
                    relEstoque(nomeProd, codVal, indiceVazio);
                    break;

                case 7:
                    alteraQuantidade(nomeProd, codVal, indiceVazio);
                    break;


                case 8:
                    menuComunidade();
                    break;


                case  0:
                    JOptionPane.showMessageDialog(null, "Finalizando o sistema...");
                    break;


                case 999:
                    indiceVazio = autoCadastro(nomeProd, codVal, indiceVazio);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Código inválido");
                    break;
            }


        }while(op!=0);
    }

    public static void menuComunidade() {
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(
                    " Menu Comunidade \n" +
                            "8  - Cadastrar comunidade \n" +
                            "9  - Editar comunidade \n" +
                            "10 - Visualizar comunidade \n" +
                            "0 - Sair"
            ));

            switch (op) {
                case 8:
                    cadastrarComunidade();
                    break;
                case 9:
                    editarComunidade();
                    break;
                case 10:
                    visualizarComunidade();
                    break;
                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
                    break;
            }
        } while (op != 0);
    }

    public static void cadastrarComunidade() {
        String nome = JOptionPane.showInputDialog("Digite o nome da comunidade carente: ").toUpperCase();
        String produtoFaltante = JOptionPane.showInputDialog("Digite o produto que falta para a comunidade: ").toLowerCase();
        int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade que falta: "));

        comunidades[indiceVazio] = nome;
        produtosFaltantes[indiceVazio] = produtoFaltante;
        quantidadesFaltantes[indiceVazio] = quantidade;

        indiceVazio++;
    }

    public static void editarComunidade(){
        String nomeComunidade = JOptionPane.showInputDialog("Digite o nome da comunidade que deseja editar: ").toUpperCase();
        for (int i = 0; i < indiceVazio; i++) {
            if (comunidades[i].equals(nomeComunidade)) {
                String novoProdutoFaltante = JOptionPane.showInputDialog("Digite o produto mais em falta: ").toLowerCase();
                int novaQuantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantidade que falta: "));
                produtosFaltantes[i] = novoProdutoFaltante;
                quantidadesFaltantes[i] = novaQuantidade;
                JOptionPane.showMessageDialog(null, "Comunidade atualizada com sucesso.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Comunidade não encontrada.");
    }


    public static void visualizarComunidade() {
        String mensagem = "";
        for (int i = 0; i < indiceVazio; i++) {
            mensagem += "Comunidade: " + comunidades[i] + "\nProduto em falta no momento: " + produtosFaltantes[i] + "\nQuantidade em falta: " + quantidadesFaltantes[i] + "\n\n";
        }
        JOptionPane.showMessageDialog(null, mensagem);
    }


    public static void cadastroComunidadeCarente(String[] comunidades, String[] materiais, int indiceVazio) {
        String nomeComunidade = JOptionPane.showInputDialog("Digite o nome da comunidade carente: ");
        String materialNecessario = JOptionPane.showInputDialog("Digite o material necessário para a comunidade: ");
        comunidades[indiceVazio] = nomeComunidade;
        materiais[indiceVazio] = materialNecessario;
        indiceVazio++;  // Incrementar o índice vazio para a próxima entrada
    }

    public static void visualizarComunidadesCarentes(String[] comunidades, String[] materiais, int indiceVazio) {
        for (int i = 0; i < indiceVazio; i++) {
            System.out.println("Comunidade: " + comunidades[i] + ", Material necessário: " + materiais[i]);
        }
    }





    //Cadastro de produtos (Verificações)
    public static int cadastro (String nomeProd[], double codVal[][], int indiceVazio) {
        char resp='s', confirmaCad;
        int indiceCad, indiceNomeCad;
        double codCad;
        String nomeCad;

        do {
            if (indiceVazio<nomeProd.length) {
                nomeCad = JOptionPane.showInputDialog("Digite o nome do produto: ");
                //Verifica se o nome do produto já foi cadastrado
                indiceCad=procNome(nomeProd, codVal, indiceVazio, nomeCad);
                if (indiceCad != -1) {
                    //Mostra mensagem caso esteja cadastrado e informa onde
                    JOptionPane.showMessageDialog(null, "Produto já cadastrado com o código: "+codVal[1][indiceCad]);
                }
                else {
                    codCad = Double.parseDouble(JOptionPane.showInputDialog("Digite o código do produto"));
                    //Verifica se o código do produto já foi cadastrado
                    indiceNomeCad = procCod(nomeProd, codVal, indiceVazio, codCad);
                    if (indiceNomeCad != -1) {
                        //Caso sim, mostra o nome do produto que está usando o código
                        JOptionPane.showMessageDialog(null, "Código já cadastrado para o produto: "+nomeProd[indiceNomeCad]);
                    }
                    else {


                        confirmaCad = (JOptionPane.showInputDialog(
                                "           Confirmação de cadastro"+"\n\n"+
                                        "Código: "+codCad+"\n"+
                                        "Nome do produto: "+nomeCad+"\n"+
                                        "Quantidade: 0\n\n"+
//                                        "Preço de custo: R$"+prCusto+"\n"+
//                                        "Valor de venda: R$"+valVenda+"\n\n"+
                                        "Confirma entrada dos dados (S/N)?")).charAt(0);

                        if ((confirmaCad=='s')||(confirmaCad=='S')){

                            execCad(nomeProd, codVal, indiceVazio, codCad, nomeCad);
                            indiceVazio=(indiceVazio+1);
                        }
                    }
                }

                resp = (JOptionPane.showInputDialog("Deseja cadastrar outro produto (S/N)?")).charAt(0);
            }
            else {
                JOptionPane.showMessageDialog(null, "Limite de cadastros alcançado");
                resp = 'n';
            }
        } while ((resp=='s') || (resp=='S'));
        return indiceVazio;
    }

    //Verifica se o código do produto já está cadastrado - Se estiver, retorna a posição
    public static int procCod (String nomeProd[], double codVal[][], int indiceVazio, double buscaCod ) {
        int i=0;

        while ((i<indiceVazio)&&(buscaCod!=codVal[1][i])) {
            i++;
        }
        if (buscaCod!=codVal[1][i]) {
            return -1;
        }
        else {
            return i;
        }
    }


    //Verifica se o nome do produto já está cadastrado - Se estiver, retorna a posição
    public static int procNome(String nomeProd[], double codVal[][], int indiceVazio, String buscaNome) {
        int i=0;

        while ((i<indiceVazio)&&(!(buscaNome.equalsIgnoreCase(nomeProd[i])))) {
            i++;
        }
        if (!(buscaNome.equalsIgnoreCase(nomeProd[i]))) {
            return -1;
        }
        else {
            return i;
        }
    }


    //Cadastro de produtos (Execução de cadastro)
    public static void execCad (String nomeProd[], double codVal[][], int indice, double cod, String nome) {

        nomeProd[indice] = nome;
        codVal[1][indice] = cod;
        codVal[4][indice] = 0;
//        codVal[5][indice] = prCusto;
//        codVal[6][indice] = valVenda;
//        codVal[7][indice] = lucrUn;
    }


    //Cadastro de entradas de produtos (Verifica existência de cadastro do produto e encaminha execução)
    public static void cadEntradas(String nomeProd[], double codVal[][], int indiceVazio){
        double codEntr;
        char resp = 's', confirmaEntr;
        int achouProd;
        double qtdadeEntr;

        do {
            codEntr = Double.parseDouble(JOptionPane.showInputDialog("Informe o código do produto: "));
            //Consulta se o código já está cadastrado no sistema
            achouProd = procCod(nomeProd, codVal, indiceVazio, codEntr);
            if (achouProd != -1) {
                qtdadeEntr = Double.parseDouble(JOptionPane.showInputDialog("Informe a quantidade da entrada do produto: "+nomeProd[achouProd]+"\n" ));

                confirmaEntr = (JOptionPane.showInputDialog(
                        "           Confirmação de entrada"+"\n\n"+
                                "Código: "+codVal[1][achouProd]+"\n"+
                                "Nome do produto: "+nomeProd[achouProd]+"\n"+
                                "Quantidade da entrada: "+qtdadeEntr+"\n\n"+
                                "Confirma entrada dos dados (S/N)?")).charAt(0);
                if ((confirmaEntr=='s')||(confirmaEntr=='S')){
                    execCadEntr(nomeProd, codVal, achouProd, codEntr, qtdadeEntr);
                }
            }
            //Avisa se o produto não está cadastrado
            else {
                JOptionPane.showMessageDialog(null,
                        "                        O código informado: "+codEntr+ " não foi localizado. \n" +
                                "          Certifique-se de que você digitou o código corretamente \n " +
                                "                             e que o produto esteja cadastrado.");
            }
            resp = (JOptionPane.showInputDialog("Deseja cadastrar outra entrada (S/N)?")).charAt(0);

        }while ((resp=='s') || (resp=='S'));
    }


    //Cadastro de entradas (Execução do cadastro de entradas)
    public static void execCadEntr(String nomeProd[], double codVal[][], int indProd, double codEntr, double qtdade){

        //Adiciona ao registro de entradas do produto
        codVal[2][indProd] = (codVal[2][indProd]+qtdade);
        //Adiciona ao estoque do produto
        codVal[4][indProd] = (codVal[4][indProd]+qtdade);
    }


    //Cadastro de vendas (Verifica e encaminha execução)
    public static void cadSaidas (String nomeProd[], double codVal[][], int indiceVazio){
        double codVend;
        char resp = 's', confirmaDoacao = 'n';
        int achouProd;
        double qtdadeVend, qtEstoque;

        do {
            codVend = Double.parseDouble(JOptionPane.showInputDialog("Informe o código do produto: "));
            //Consulta se o código já está cadastrado no sistema
            achouProd = procCod(nomeProd, codVal, indiceVazio, codVend);
            if (achouProd != -1) {
                //Verifica se há estoque do produto informado
                qtEstoque = verEstoque(codVal, achouProd);
                //Não havendo estoque, mostra mensagem
                if (qtEstoque <=0.0){
                    JOptionPane.showMessageDialog(null, "O produto informado: "+nomeProd[achouProd]+" não está em estoque!");
                }
                //Havendo estoque, prossegue com a venda
                else {
                    qtdadeVend = Double.parseDouble(JOptionPane.showInputDialog("" +
                            "Informe a quantidade doada do produto: "+nomeProd[achouProd]));

                    //Verifica se a quantidade informada na venda não excede a quantidade em estoque e mostra mensagem caso exceda
                    if (qtdadeVend > qtEstoque) {
                        JOptionPane.showMessageDialog(null, "A quantidade em estoque do produto: "+nomeProd[achouProd]+ " é somente: " +qtEstoque);
                    }
                    //Havendo estoque suficiente, continua
                    if (qtdadeVend <= qtEstoque){
                        //Mostra mensagem com os dados da venda e pede confirmação
                        confirmaDoacao = (JOptionPane.showInputDialog(
                                "Código: "+codVal[1][achouProd]+"\n"+
                                        "Produto: "+nomeProd[achouProd]+"\n" +
                                        "Quantidade doada: "+qtdadeVend+"\n"+
                                        "Confirma dados da doação (S/N)?")).charAt(0);
                    }
                    if ((confirmaDoacao == 's') || (confirmaDoacao == 'S')) {
                        execCadVenda(codVal, achouProd, qtdadeVend);
                    }
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "O código informado: "+codVend+ " é inválido");
            }
            resp = (JOptionPane.showInputDialog("Deseja cadastrar outra venda (S/N)?")).charAt(0);

        }while ((resp =='s') || (resp =='S'));

    }


    //Verifica Quantidade do produto no estoque
    public static double verEstoque (double codVal[][], int achouProd) {
        double estoque;

        estoque = codVal[4][achouProd];

        return estoque ;
    }


    //Cadastro de Vendas (Execução do cadastro de Vendas)
    public static void execCadVenda(double codVal[][], int indProd, double qtdade){

        //Adiciona ao registro de vendas do produto
        codVal[3][indProd] = (codVal[3][indProd]+qtdade);
        //Retira do estoque do produto
        codVal[4][indProd] = (codVal[4][indProd]-qtdade);
    }


    //Consulta do cadastro de produto informando código
    public static void consProdCod (String nomeProd[], double codVal[][], int indiceVazio){
        double codProcura;
        int achou;
        char resp = 's';

        do{
            codProcura = Double.parseDouble(JOptionPane.showInputDialog("Digite o código do produto: "));
            achou = procCod (nomeProd, codVal, indiceVazio, codProcura );
            if (achou == -1){
                JOptionPane.showMessageDialog(null, "Não foi encontrado produto com o código informado: "+codProcura);
            }
            else{
                JOptionPane.showMessageDialog(null,
                        "Código: "+codVal[1][achou]+"\n"+
                                "Nome do produto: "+nomeProd[achou]+"\n"+
                                "Quantidade em estoque: "+codVal[4][achou]+"\n"
                );
            }
            resp = (JOptionPane.showInputDialog("Deseja pesquisar outro produto (S/N)?")).charAt(0);

        }while ((resp =='s') || (resp =='S'));
    }


    //Consulta do cadastro de produto informando nome
    public static void consProdNome (String nomeProd[], double codVal[][], int indiceVazio){
        String nomeProcura;
        int achou;
        char resp = 's';

        do{
            nomeProcura = JOptionPane.showInputDialog("Digite o nome do produto: ");
            achou = procNome (nomeProd, codVal, indiceVazio, nomeProcura );
            if (achou == -1){
                JOptionPane.showMessageDialog(null, "Não foi encontrado produto com o nome informado: "+nomeProcura);
            }
            else{
                JOptionPane.showMessageDialog(null,
                        "Código: "+codVal[1][achou]+"\n"+
                                "Nome do produto: "+nomeProd[achou]+"\n"+
                                "Quantidade em estoque: "+codVal[4][achou]+"\n");
            }
            resp = (JOptionPane.showInputDialog("Deseja pesquisar outro produto (S/N)?")).charAt(0);

        }while ((resp =='s') || (resp =='S'));
    }


    //Verifica se houveram movimentações (Compra ou venda) do produto
    public static int verMov(String nomeProd[], double codVal[][], int indiceVazio, int tipoMov, int indPesq){ //tipoMov é 2 compras, 3 vendas, 4 estoque


        if (codVal[tipoMov][indPesq]>0){
            return indPesq;
        }
        else{
            return -1;
        }
    }


    //Relatório de compras
    /*public static void relCompras(String nomeProd[], double codVal[][], int indiceVazio){
        int tipoMov=2, indice=0, indPesq=0, i=0;
        double valorCompras=0;

        do{

            indice = verMov(nomeProd, codVal, indiceVazio, tipoMov, indPesq);
            if (indice!=-1){

                JOptionPane.showMessageDialog(null,
                        "                Relatório de compras"+"\n\n"+
                                "Código: "+codVal[1][indice]+"\n"+
                                "Nome do produto: "+nomeProd[indice]+"\n"+
                                "Preço de custo: R$"+codVal[5][indice]+"\n"+
                                "Quantidade comprada: "+codVal[2][indice]+"\n"+
                                "Valor das compras do produto: R$"+(codVal[2][indice]*codVal[5][indice]));
            }
            valorCompras = (calcValores(nomeProd, codVal, indiceVazio, tipoMov, 5, indPesq)+valorCompras);
            //5 identifica preço de custo e tipoMov (2) identifica Qtdade compras
            indPesq = (indPesq+1);

            i++;
        }while (i<indiceVazio);

        JOptionPane.showMessageDialog(null,
                "             Relatório de compras"+"\n\n"+
                        "Valor total das compras: R$"+valorCompras);
    }
*/


    //Cálculo de valores de movimentação
    public static double calcValores (String nomeProd[], double codVal[][], int indiceVazio, int tipoMov, int preco, int indPesq){
        double valor=0;
        int indice;

        indice = verMov(nomeProd, codVal, indiceVazio, tipoMov, indPesq);
        if (indice!=-1){
            valor = (valor+(codVal[preco][indice]*codVal[tipoMov][indice]));
        }
        return valor;
    }


    //Relatório de vendas
   /* public static void relVendas (String nomeProd[], double codVal[][], int indiceVazio){
        int tipoMov=3, indice=0, indPesq=0, i=0;
        double valorVendas=0, custoVendas=0, faturamento=0;

        do{

            indice = verMov(nomeProd, codVal, indiceVazio, tipoMov, indPesq);
            if (indice!=-1){

                JOptionPane.showMessageDialog(null,
                        "    Relatório de vendas/faturamento"+"\n\n"+
                                "Código: "+codVal[1][indice]+"\n"+
                                "Nome do produto: "+nomeProd[indice]+"\n"+
                                "Valor de venda: R$"+codVal[6][indice]+"\n"+
                                "Quantidade vendida: "+codVal[3][indice]+"\n"+
                                "Valor das vendas do produto: R$"+(codVal[3][indice]*codVal[6][indice]));
            }
            //6 identifica valor de venda e tipoMov (3) identifica Qtdade vendas
            valorVendas = (calcValores(nomeProd, codVal, indiceVazio, tipoMov, 6, indPesq)+valorVendas);
            //5 identifica preço de custo e tipoMov (3) identifica Qtdade vendas
            custoVendas = (calcValores(nomeProd, codVal, indiceVazio, tipoMov, 5, indPesq)+custoVendas);
            indPesq = (indPesq+1);

            i++;
        }while (i<indiceVazio);

        faturamento = (valorVendas-custoVendas);

        JOptionPane.showMessageDialog(null,
                "  Relatório de vendas/faturamento"+"\n\n"+
                        "Valor total das vendas: R$"+valorVendas+"\n"+
                        "Lucro líquido: R$"+faturamento);
    }
*/

    //Relatório de estoque
    public static void relEstoque(String nomeProd[], double codVal[][], int indiceVazio){
        int tipoMov=4, indice=0, indPesq=0, i=0; //tipoMov (4) representa quantidade em estoque

        do{
            indice = verMov(nomeProd, codVal, indiceVazio, tipoMov, indPesq);
            if (indice!=-1){

                JOptionPane.showMessageDialog(null,
                        "         Relatório de estoque"+"\n\n"+
                                "Código: "+codVal[1][indice]+"\n"+
                                "Nome do produto: "+nomeProd[indice]+"\n"+
                                "Quantidade em estoque: "+codVal[4][indice]+"\n"
                );
            }

            indPesq = (indPesq+1);

            i++;
        }while (i<indiceVazio);

  /*
    JOptionPane.showMessageDialog(null,
            "                                 Totais do estoque \n\n"+
                    "Valor dos produtos em estoque (preço de custo): R$"+valorCustoEstoque+"\n"+
                    "Valor dos produtos em estoque (valor de venda): R$"+valorVendaEstoque+"\n"+
                    "Possível lucro com a venda total do estoque: R$"+(valorVendaEstoque-valorCustoEstoque))
    ;
  */

    }


    //Alterações de precos de custo e venda do produto
    public static void alteraValores(String nomeProd[], double codVal[][], int indiceVazio){
        double prCusto=0,valVenda=0, codProd;
        int indice;
        char confirma='n';

        codProd = Double.parseDouble(JOptionPane.showInputDialog("Digite o código do produto que deseja alterar: "));
        indice = procCod(nomeProd, codVal, indiceVazio, codProd);
        if (indice == -1){
            JOptionPane.showMessageDialog(null, "O código informado: "+codProd+" não foi localizado");
        }
        else{
            confirma = (JOptionPane.showInputDialog(
                    "          Dados atuais do produto: \n\n"+
                            "Código: "+codProd+"\n"+
                            "Nome do produto: "+nomeProd[indice]+"\n"+
                            "Preço de custo: R$"+codVal[5][indice]+"\n"+
                            "Valor de venda: R$"+codVal[6][indice]+"\n\n"+
                            "Deseja alterar este produto (S/N)?")).charAt(0);
            if ((confirma == 's')||(confirma == 'S')){
                prCusto = Double.parseDouble(JOptionPane.showInputDialog("Informe o novo preço de custo: R$"));
                valVenda = Double.parseDouble(JOptionPane.showInputDialog("Informe o novo valor de venda: R$"));

                confirma = (JOptionPane.showInputDialog(
                        "          Novos dados do produto: \n\n"+
                                "Código: "+codProd+"\n"+
                                "Nome do produto: "+nomeProd[indice]+"\n"+
                                "Preço de custo: R$"+prCusto+"\n"+
                                "Valor de venda: R$"+valVenda+"\n\n"+
                                "Confirma alterações (S/N)?")).charAt(0);
                if ((confirma == 's')||(confirma == 'S')){
                    codVal[5][indice] = prCusto;
                    codVal[6][indice] = valVenda;
                    JOptionPane.showMessageDialog(null, "" +
                            "                                                             AVISO!!! \n\n"+
                            "  Ao gerar relatórios, os valores são baseados nos valores atuais do produto.\n"+
                            " Ou seja, os valores de venda, estoque, faturamento, etc. serão baseados nos\n"+
                            "                                      valores que você acabou de confirmar.");
                }
            }

        }
    }

    //Altera a quantidade direto no estoque
    public static void alteraQuantidade(String nomeProd[], double codVal[][], int indiceVazio){
        double codProd;
        int indice;
        char confirma='n';

        codProd = Double.parseDouble(JOptionPane.showInputDialog("Digite o código do produto que deseja alterar: "));
        indice = procCod(nomeProd, codVal, indiceVazio, codProd);
        if (indice == -1){
            JOptionPane.showMessageDialog(null, "O código informado: "+codProd+" não foi localizado");
        }
        else{
            double novaQuantidade = Double.parseDouble(JOptionPane.showInputDialog(nomeProd[indice]+". Quantidade atual ("+ codVal[4][indice]+ ")\nInforme a nova quantidade: "));
            confirma = (JOptionPane.showInputDialog(
                    "          Dados atuais do produto: \n\n"+
                            "Código: "+codProd+"\n"+
                            "Nome do produto: "+nomeProd[indice]+"\n"+
                            "Quantidade antiga: "+codVal[4][indice]+"\n\n"+
                            "Quantidade nova: "+novaQuantidade+"\n\n"+
                            "Deseja alterar a quantidade deste produto (S/N)?")).charAt(0);
            if ((confirma == 's')||(confirma == 'S')){
                codVal[4][indice] = novaQuantidade;
                JOptionPane.showMessageDialog(null, "Quantidade do produto " + nomeProd[indice] + " atualizada para " + novaQuantidade);
            }
        }
    }


    //Mostra todos as informações cadastradas no sistema
    public static void mostraTodos (String nomeProd[], double codVal[][], int indiceVazio){
        int i=0;


        do{

            JOptionPane.showMessageDialog(null,
                    "Código: "+codVal[1][i]+"\n"+
                            "Nome do produto: "+nomeProd[i]+"\n"+
                            "Preço de custo: R$"+codVal[5][i]+"\n"+
                            "Valor de venda: R$"+codVal[6][i]+"\n"+
                            "Quantidade em estoque: "+codVal[4][i]+"\n"+
                            "Quantidade comprada: "+codVal[2][i]+"\n"+
                            "Quantidade vendida: "+codVal[3][i]+"\n"+
                            "Valor das compras do produto: R$"+(codVal[2][i]*codVal[5][i])+"\n"+
                            "Valor das vendas do produto: R$"+(codVal[3][i]*codVal[6][i])+"\n"+
                            "Lucro obtido com vendas deste produto: R$"+((codVal[3][i]*codVal[6][i])-(codVal[5][i]*codVal[3][i]))+"\n"+
                            "Valor de custo em estoque do produto: R$"+(codVal[4][i]*codVal[5][i])+"\n"+
                            "Valor de venda em estoque do produto: R$"+(codVal[4][i]*codVal[6][i]));

            i++;
        }while (i<indiceVazio);
    }



    //Cadastro automático de produtos - Usado para testes no programa (Evita necessidade de inserção manual de entradas)
    //Esta função não estará disponível em uma eventual versão final do programa
    public static int autoCadastro(String nomeProd[], double codVal[][], int indiceVazio){

        nomeProd[0] = "Arroz"; //Nome do produto
        codVal[1][0] = 1; //Código do produto
        codVal[4][0] = 121;//Estoque atual do produto

        indiceVazio = (indiceVazio+1);

        nomeProd[1] = "Feijao";
        codVal[1][1] = 2;
        codVal[4][1] = 45;

        indiceVazio = (indiceVazio+1);

        nomeProd[2] = "Macarrao"; //Nome do produto
        codVal[1][2] = 3; //Código do produto
        codVal[4][2] = 14; //Estoque atual do produto

        indiceVazio = (indiceVazio+1);

        nomeProd[3] = "Papel Higienico"; //Nome do produto
        codVal[1][3] = 4; //Código do produto
        codVal[4][3] = 5;//Estoque atual do produto

        indiceVazio = (indiceVazio+1);

        nomeProd[4] = "Cadernos"; //Nome do produto
        codVal[1][4] = 5; //Código do produto
        codVal[4][4] = 11;//Estoque atual do produto

        indiceVazio = (indiceVazio+1);

        nomeProd[5] = "Estojo"; //Nome do produto
        codVal[1][5] = 6; //Código do produto
        codVal[4][5] = 4;//Estoque atual do produto

        indiceVazio = (indiceVazio+1);

        nomeProd[6] = "Blusas"; //Nome do produto
        codVal[1][6] = 7; //Código do produto
        codVal[4][6] = 30;//Estoque atual do produto

        indiceVazio = (indiceVazio+1);

        JOptionPane.showMessageDialog(null, "Foram cadastrados 7 produtos no sistema!!!");


        return indiceVazio;

    }


}

