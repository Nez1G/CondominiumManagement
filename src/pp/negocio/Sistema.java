package pp.negocio;

import java.io.File;
import java.util.*;
import java.time.*;

/**
 * Classe que cria objectos do tipo Sistema
 * @author Fantastic4
 */
public class Sistema implements java.io.Serializable {
    public static final String FICHEIRO_UTILIZADORES = "C:/utilizadores.dat";
    public static final String FICHEIRO_CONDOMINIOS = "C:/publicacoes.dat";  
    public static final String FICHEIRO_CONDO = "C:/condo.dat";
    public static final String FICHEIRO_PROPRIETARIOS = "C:/proprietarios.dat";
    public static final String FICHEIRO_FACTURAS = "C:/facturas.dat";
    public static final String FICHEIRO_EVENTOS = "C:/eventos.dat";
    
    
    private ListaUtilizadores utilizadores;
    private Utilizador utilizadorLigado;
    private HashMap<String, Condominio> listacondominios;
    private ArrayList<Condominio> listaCondo;
    private HashMap<String, Proprietario> listaProp;
    private ArrayList<Recibo> listaFacturas;
    private ArrayList<EventoData2> listaEventos;

    public Sistema() throws ListaUtilizadores.UtilizadorDuplicadoException {
        utilizadores = new ListaUtilizadores(); 
        listacondominios = new HashMap<>();
        listaProp = new HashMap<>();
        listaCondo = new ArrayList<>(listaCondos());
        listaFacturas = new ArrayList<>();
        listaEventos = new ArrayList<>();
        
        
        if (new File(FICHEIRO_UTILIZADORES).exists()){            
            inicializar();
            guardarObjectos();   
        }else{            
            lerObjectos();    
        }   
    } 
    
    
    
    public void guardarObjectos(){
        boolean utilizadoresOk = Serializacao.guardarObjecto(utilizadores, FICHEIRO_UTILIZADORES);
        boolean condominiosOk = Serializacao.guardarObjecto(listacondominios, FICHEIRO_CONDOMINIOS);
        boolean listaCondoOk = Serializacao.guardarObjecto(listaCondo, FICHEIRO_CONDO);
        boolean proprietariosOk = Serializacao.guardarObjecto(listaProp, FICHEIRO_PROPRIETARIOS);
        boolean facturasOk = Serializacao.guardarObjecto(listaFacturas, FICHEIRO_FACTURAS);
        boolean eventosOk = Serializacao.guardarObjecto(listaEventos, FICHEIRO_EVENTOS);
        
        if (!utilizadoresOk || !condominiosOk || !listaCondoOk || !proprietariosOk || !facturasOk || !eventosOk){
            System.out.println("Ocorreu um erro ao gravar os objetos");
        } else{
            System.out.println("Objectos guardados");
        }       
    }
    
    public void lerObjectos(){
        Object utilizadores = Serializacao.lerObjecto(FICHEIRO_UTILIZADORES);
        Object condominios = Serializacao.lerObjecto(FICHEIRO_CONDOMINIOS);
        Object listaCondo = Serializacao.lerObjecto(FICHEIRO_CONDO);
        Object proprietarios = Serializacao.lerObjecto(FICHEIRO_PROPRIETARIOS);
        Object facturas = Serializacao.lerObjecto(FICHEIRO_FACTURAS);
        Object eventos = Serializacao.lerObjecto(FICHEIRO_EVENTOS);
        
        if (utilizadores != null){
            utilizadores = (ArrayList<Utilizador>)utilizadores; 
            System.out.println("lista de utilizadores carregada");
        }else{
            //System.out.println("Ocorreu um erro ao ler o ficheiro de utilizadores");
        }  
        
        if(condominios != null){
            condominios = (HashMap<String, Condominio>)condominios; 
            System.out.println("lista de Condominios carregada");
        }else{
            //System.out.println("Ocorreu um erro ao ler o ficheiro de Condominios");
        }
        
        if(listaCondo != null){
            listaCondo= (ArrayList<Condominio>)listaCondo; 
            System.out.println("lista de CondominiosArray carregada");
        }else{
            //System.out.println("Ocorreu um erro ao ler o ficheiro de CondominiosArray");
        }
        
        if(proprietarios != null){
            proprietarios= (HashMap<String, Proprietario>)proprietarios; 
            System.out.println("lista de proprietarios carregada");
        }else{
            //System.out.println("Ocorreu um erro ao ler o ficheiro de proprietarios");
        }
        
        if(facturas != null){
            facturas= (ArrayList<Recibo>)facturas; 
            System.out.println("lista de facturas carregada");
        }else{
           // System.out.println("Ocorreu um erro ao ler o ficheiro de facturas");
        }
        
        if(eventos != null){
            eventos= (ArrayList<EventoData2>)eventos; 
            System.out.println("lista de eventos carregada");
        }else{
            //System.out.println("Ocorreu um erro ao ler o ficheiro de eventos");
        }
        
    }
    
    public Proprietario getCliente(String cliente) throws ClienteNaoExistenteException {
        if (listaProp.containsKey(cliente)){
            return listaProp.get(cliente);
        }else{
            throw new ClienteNaoExistenteException("O utilizador '%s' já existe na lista");
        }
    }

    public ArrayList<EventoData2> getListaEventos() {
        return listaEventos;
    }

    public void setListaEventos(ArrayList<EventoData2> listaEventos) {
        this.listaEventos = listaEventos;
    }
    
    
    
    
    
    public ArrayList<Fracao> listaFracao(Condominio condo){
       ArrayList<Fracao> basedados = listacondominios.get(condo.getnCondominio()).getFracoes();
       return basedados;
    }
    
    public ArrayList<Proprietario> listaClientes(){
        return new ArrayList<>(listaProp.values());  
    }
    
     public HashMap<String, Proprietario> getListaProp() {
        return listaProp;
    }

    public void setListaProp(HashMap<String, Proprietario> listaProp) {
        this.listaProp = listaProp;
    }

    public HashMap<String, Condominio> getListacondominios() {
        return listacondominios;
    }

    public void setListacondominios(HashMap<String, Condominio> listacondominios) {
        this.listacondominios = listacondominios;
    }
    
    public ArrayList<Condominio> listaCondos(){
        ArrayList<Condominio> testar = new ArrayList<>(listacondominios.values());
        return testar;
    }

    public ArrayList<Condominio> getListaCondo() {
        return listaCondo;
    }

    public void setListaCondo(ArrayList<Condominio> listaCondo) {
        this.listaCondo = listaCondo;
    }

    public ArrayList<Recibo> getListaFacturas() {
        return listaFacturas;
    }

    public void setListaFacturas(ArrayList<Recibo> listaFacturas) {
        this.listaFacturas = listaFacturas;
    }
    
    public ArrayList<Fracao> tenta(){
        
        ArrayList<Condominio> allCondos = new ArrayList<>(listacondominios.values());
        ArrayList<Fracao> allFracoes = new ArrayList<>();
        
         for(int i = 0; i < allCondos.size(); i++){
             ArrayList<Fracao> smallPart = allCondos.get(i).getFracoes();
             for(int y = 0; y < smallPart.size(); y++){
                 allFracoes.add(smallPart.get(i));
             }
         }    
        return allFracoes;
    }
    
    /**
     *
     * @return
     */
    
    /*
    public ArrayList<Recibo> listaFacturas(){
         ArrayList<Condominio> allCondos = new ArrayList<>(listacondominios.values());
         ArrayList<Recibo> allRecibos = new ArrayList<>();
         for(int i = 0; i < allCondos.size(); i++){
             ArrayList<Fracao> allFracoes = allCondos.get(i).getFracoes();
             for(int p = 0; p < allFracoes.size(); p++){
                 ArrayList<Recibo> recibos = allFracoes.get(i).listaRecibos();
                 for(int k = 0; k < recibos.size(); k++){
                     Recibo f = recibos.get(k);
                     allRecibos.add(f);
                 }
             }
         }
         return allRecibos;
    }
   */
    
    
    public ArrayList<Fracao> listaFracoes(Condominio condo){
        return new ArrayList<>(condo.getFracoes());
    }
    
    public void adicionar(Proprietario cliente) throws ClienteDuplicadoException {
        if (cliente == null) {
            throw new NullPointerException("O parâmetro 'utilizador' não pode ser um valor nulo");
        }        
        
        if (!listaProp.containsKey(String.valueOf(cliente.getNif()))) {
            listaProp.put(String.valueOf(cliente.getNif()), cliente);
        }else{
            throw new ClienteDuplicadoException(String.format("O cliente '%s' já existe na coleção", cliente.getNif()));
        }
        
    }
    
    public void addCondo(Condominio condo) throws CondoDuplicadoException{
        if(condo == null){
            throw new NullPointerException("O parâmetro 'condo' não pode ser um valor nulo");
        }
        if(!listacondominios.containsKey(condo.getnCondominio())){
           listacondominios.put(String.valueOf(condo.getnCondominio()), condo);
        }else{
                throw new CondoDuplicadoException("O Condominio já existe na lista");
        }
        
    }

    public ListaUtilizadores getListaUtilizadores() {
        return utilizadores;
    }
    
    public boolean autenticarUtilizador(String username, String password) {        
        if (utilizadores.existe(username)) {
            try{
                Utilizador u = utilizadores.getUtilizador(username);                
                if (u.getPassword().equals(password)){
                    utilizadorLigado = u;
                    return true;
                }                
            }catch (Exception e) {}                        
        }        
        return false;        
    }
    
    public Utilizador getUtilizadorLigado() {
        return utilizadorLigado;
    }
  
    
        public void inicializar() throws ListaUtilizadores.UtilizadorDuplicadoException {
        
        utilizadores.adicionar(new Administrador("admin", "admin", "Aministrador"));
        utilizadores.adicionar(new Utilizador("user1", "1234", "Utilizador 1"));
        utilizadores.adicionar(new Utilizador("user2", "1234", "Utilizador 2")); 
        
        Exata e1 = new Exata();
        Equitativa e2 = new Equitativa();
        Permilagem e3 = new Permilagem();
        Manual e4 = new Manual();
        Exata e5 = new Exata();
        
        Condominio c1 = new Condominio(1, e1, 53.5, 3, "Rua 25 de Abril N187", "4710-000", 10);
        Condominio c2 = new Condominio(2, e2, 500, 3, "Rua do Pinheiro N45", "4715-000", 21);
        Condominio c3 = new Condominio(3, e3, 250.5, 3, "Rua da Caranga N21", "4720-000", 10);
        Condominio c4 = new Condominio(4, e4, 6.500, 3, "Lugar da Estrada rua 3 ", "4720-000", 15);
        Condominio c5 = new Condominio(5, e5, 985, 3, "Rua do Souto" , "4750-652", 8);
		
		
		Proprietario p1 = new Proprietario("Bruno Ferreira", 145095036, 253675042, "Rua 25 de Abril N187 8000-00", "bruno@teste.com");
                Proprietario p2 = new Proprietario("Pedro Palha", 251977285, 910944167, "Rua do Pinheiro N45 8000-00", "pedro@gmail.com");
                Proprietario p3 = new Proprietario("Vicente Peixoto", 811997820, 91775599, "Rua dos Chãos N180 4710-193", "vice_peixoto@gmail.com");
                Proprietario p4 = new Proprietario("Ricardo Duarte", 458975120, 910648111, "Rua de Camões N18 4700-845", "ricardo@gmail.com");
		Proprietario p5 = new Proprietario("Andre Sousa", 925741023, 916589741, "Rua das Oliveiras N80 4710-345", "andre@gmail.com");
		Proprietario p6 = new Proprietario("Ines Pereira", 102365478, 914789520, "Lugar do Negreiro N10 4600-193", "ines@gmail.com");
		Proprietario p7 = new Proprietario("Maria Antónia", 654123987, 965124987, "Rua da Escola Primária N245 4500-987", "maria_a@gmail.com");
		Proprietario p8 = new Proprietario("João Duarte", 654120369, 253698741, "Rua Professor José Ribeiro N45 4700-843", "joao@gmail.com");
		Proprietario p9 = new Proprietario("Rita Joana", 741025963, 253645987, "Rua do Raio N46 4500-123", "rt_joana@gmail.com");
		Proprietario p10 = new Proprietario("Juliana Rosa", 123654985, 925674132, "Rua das Andorinhas N65 4560-764", "rosa@gmail.com");
		Proprietario p11 = new Proprietario("Antonio Cunha", 325963321, 936988123, "Rua Zeca Afonso N98 4700-190", "antonio@gmail.com");
		Proprietario p12 = new Proprietario("Joaquim Jorge", 852369200, 91952369, "Rua Monte da Forca N23 4530-300", "joaquim@gmail.com");
		Proprietario p13 = new Proprietario("Celeste Cruz", 452200111, 96333457, "Rua Infante de Sagres  N54 4735-191", "celeste@gmail.com");
		Proprietario p14 = new Proprietario("José Cunha", 111258996, 918376165, "Rua Fernão Magalhães N2 4701-100", "ze_cunha@gmail.com");
		Proprietario p15 = new Proprietario("Manuel João", 256699885, 253658410, "Rua do Municipio  N6 4702-199", "joao_manuel@gmail.com");
		Proprietario p16 = new Proprietario("Amanda Gomes", 333654102, 926544878, "Rua da Liberdade  N30 4706-162", "amanda_g@gmail.com");
		Proprietario p17 = new Proprietario("Margarida Antunes", 745654789, 917156963, "Avenida da Igreja N8 4730-465", "guida@gmail.com");
		Proprietario p18 = new Proprietario("Joana Almeida", 789654456, 913694561, "Rua Engenheiro Duarte Pacheco N4 400-231", "j2_almeida@gmail.com");
		Proprietario p19 = new Proprietario("Claudia Borges", 012553112, 915651232, "Rua da Bela Vista N5 2000-100", "claudia@gmail.com");
		Proprietario p20 = new Proprietario("Renato Dias", 125898745, 912213451, "Rua Gil Eanes N500 5800-600", "renato@gmail.com");
		Proprietario p21 = new Proprietario("Maria José Gomes", 852369459, 968162055, "Rua Gaspar Corte Real N900 4945-900", "zeza@hotmail.com");
		Proprietario p22 = new Proprietario("Rui silva", 055562325, 253927208, "Rua dos Trabalhadores N32 4320-800", "rsilva@sapo.pt");
		Proprietario p23 = new Proprietario("Ana Luisa Ferraz ", 777856335, 919943447, "Avenida Brasil N84 4840-000", "aluisa@gmail.com");
		Proprietario p24 = new Proprietario("Luis Barros", 545896325, 93699654, "Largo Padre Himalaia N69 4969-502", "l_barros@gmail.com");
		Proprietario p25 = new Proprietario("Fernando Fernandes", 152525225, 253985630, "Rua de Sobreiras N19 4199-200", "nandofernandes@hotmai.com");
		Proprietario p26 = new Proprietario("Alexandre Carvalho ", 85236945, 918841551, "Rua Bartolomeu Velho  N87 8910-302", "carvalho@gmail.com");
		Proprietario p27 = new Proprietario("Diego Ribeiro", 125896335, 912961892, "Largo da Costa Nova N59 9710-103", "diego_r4@hotmail.com");
		Proprietario p28 = new Proprietario("Gustavo Sousa", 824154622, 913062888, "Rua da Pasteleira N39 2003-800", "gustavo.sousa@gmail.com");
		Proprietario p29 = new Proprietario("Laura Borges", 853120869, 910003553, "Rua de Serralves N50 9300-100", "laura2014@gmail.com");
		Proprietario p30 = new Proprietario("Sabrina Gonçalves", 125478963, 963214569, "Praceta José Régio N800 4500-500", "sabrina123@hotmail.com");
                Proprietario p31 = new Proprietario("Teste", 12, 963214569, "Praceta José Régio N800 4500-500", "teste@hotmail.com");
                
        c1.setResponsavel(p1);
        c2.setResponsavel(p2);
        c3.setResponsavel(p3);
	c4.setResponsavel(p4);
	c5.setResponsavel(p5);
		
		
		Fracao f1 = new Fracao(200, "1E", p1, 1);
                Fracao f2 = new Fracao(300, "2E", p2, 2);
                Fracao f3 = new Fracao(350, "3D", p3, 3);
                Fracao f4 = new Fracao(200, "1E", p4, 1);
		Fracao f5 = new Fracao(300, "2E", p5, 2);
		Fracao f6 = new Fracao(350, "3D", p6, 3);
		Fracao f7 = new Fracao(200, "1E", p7, 1);
		Fracao f8 = new Fracao(300, "2D", p8, 2);
		Fracao f9 = new Fracao(350, "3E", p9, 3);
		Fracao f10 = new Fracao(200, "1D", p10, 1);
		Fracao f11 = new Fracao(300, "2E", p11, 2);
		Fracao f12 = new Fracao(350, "3D", p12, 3);
		Fracao f13 = new Fracao(200, "1E", p13, 1);
		Fracao f14 = new Fracao(300, "2D", p14, 2);
		Fracao f15 = new Fracao(350, "3E", p15, 3);
		Fracao f16 = new Fracao(200, "1D", p16, 1);
		Fracao f17 = new Fracao(300, "2E", p17, 2);
		Fracao f18 = new Fracao(350, "3D", p18, 3);
		Fracao f19 = new Fracao(200, "1E", p19, 1);
		Fracao f20 = new Fracao(300, "2D", p20, 2);
		Fracao f21 = new Fracao(350, "3E", p21, 3);
		Fracao f22 = new Fracao(300, "2D", p22, 2);
		Fracao f23 = new Fracao(350, "3E", p23, 3);
		Fracao f24 = new Fracao(200, "1D", p24, 1);
		Fracao f25 = new Fracao(300, "2E", p25, 2);
		Fracao f26 = new Fracao(200, "1D", p26, 1);
		Fracao f27 = new Fracao(300, "2E", p27, 2);
		Fracao f28 = new Fracao(350, "3D", p28, 3);
		Fracao f29 = new Fracao(200, "1E", p29, 1);
		Fracao f30 = new Fracao(300, "2D", p30, 2);
       
	    
		c1.addFracao(f1);
                c1.addFracao(f2);
                c1.addFracao(f3);
                c1.addFracao(f4);
                c1.addFracao(f5);
                c1.addFracao(f6);
                c2.addFracao(f7);
                c2.addFracao(f8);
                c2.addFracao(f9);
                c2.addFracao(f10);
                c2.addFracao(f11);
                c2.addFracao(f12);
                c3.addFracao(f13);
                c3.addFracao(f14);
                c3.addFracao(f15);
                c3.addFracao(f16);
                c3.addFracao(f17);
                c3.addFracao(f18);
                
                c4.addFracao(f19);
                c4.addFracao(f20);
                c4.addFracao(f21);
                c4.addFracao(f22);
                c4.addFracao(f23);
                c4.addFracao(f24);
                f19.setValor(50);
                f20.setValor(50);
                f21.setValor(50);
                f22.setValor(50);
                f23.setValor(50);
                f24.setValor(50);
                
                
                c5.addFracao(f25);
                c5.addFracao(f26);
                c5.addFracao(f27);
                c5.addFracao(f28);
                c5.addFracao(f29);
                c5.addFracao(f30);
       
                listaProp.put(String.valueOf(p1.getNif()), p1);
                listaProp.put(String.valueOf(p2.getNif()), p2);
                listaProp.put(String.valueOf(p3.getNif()), p3);
		listaProp.put(String.valueOf(p4.getNif()), p4);
		listaProp.put(String.valueOf(p5.getNif()), p5);
		listaProp.put(String.valueOf(p6.getNif()), p6);
		listaProp.put(String.valueOf(p7.getNif()), p7);
		listaProp.put(String.valueOf(p8.getNif()), p8);
		listaProp.put(String.valueOf(p9.getNif()), p9);
		listaProp.put(String.valueOf(p10.getNif()), p10);
		listaProp.put(String.valueOf(p11.getNif()), p11);
		listaProp.put(String.valueOf(p12.getNif()), p12);
		listaProp.put(String.valueOf(p13.getNif()), p13);
		listaProp.put(String.valueOf(p14.getNif()), p14);
		listaProp.put(String.valueOf(p15.getNif()), p15);
		listaProp.put(String.valueOf(p16.getNif()), p16);
		listaProp.put(String.valueOf(p17.getNif()), p17);
		listaProp.put(String.valueOf(p18.getNif()), p18);
		listaProp.put(String.valueOf(p19.getNif()), p19);
		listaProp.put(String.valueOf(p20.getNif()), p20);
		listaProp.put(String.valueOf(p21.getNif()), p21);
		listaProp.put(String.valueOf(p22.getNif()), p22);
		listaProp.put(String.valueOf(p23.getNif()), p23);
		listaProp.put(String.valueOf(p24.getNif()), p24);
		listaProp.put(String.valueOf(p25.getNif()), p25);
		listaProp.put(String.valueOf(p26.getNif()), p26);
		listaProp.put(String.valueOf(p27.getNif()), p27);
		listaProp.put(String.valueOf(p28.getNif()), p28);
		listaProp.put(String.valueOf(p29.getNif()), p29);
		listaProp.put(String.valueOf(p30.getNif()), p30);
                listaProp.put(String.valueOf(p31.getNif()), p31);
		
		
		listacondominios.put(String.valueOf(c1.getnCondominio()), c1);
                listacondominios.put(String.valueOf(c2.getnCondominio()), c2);
                listacondominios.put(String.valueOf(c3.getnCondominio()), c3);
		listacondominios.put(String.valueOf(c4.getnCondominio()), c4);
		listacondominios.put(String.valueOf(c5.getnCondominio()), c5);
		
                
        
    }
    
    
    //Trocar getTotalFacturado por getMontanteRecibos;
    public ArrayList<Condominio> orderbyFact(){
        TreeMap<String, Condominio> topfive = new TreeMap<>();
        Comparator<Condominio> byFacturacao = (e1, e2) -> Double.compare(e1.getMontanteRecibos(),
                e2.getMontanteRecibos());
        listacondominios.values()
                        .stream()
                        .sorted(byFacturacao)
                        .forEach(e -> topfive.put(String.valueOf(e.getMontanteRecibos()), e));
        return new ArrayList<>(topfive.descendingMap().values());
    }
    

    
    public String statCod(){
        String codpostal = "";
        ArrayList<String> listacod;
        listacod = new ArrayList<>();
        ArrayList<Condominio> listaC = new ArrayList<>(listacondominios.values());
        for(int i = 0; i < listaC.size(); i++ ){
            listacod.add(listaC.get(i).getCodPostal());
        }
        
        Map<String, Integer> contaStrings = new HashMap<>();
        for(String str: listacod){
            Integer conta = contaStrings.get(str);
            if(conta == null) conta = new Integer(0);
                conta++;
                contaStrings.put(str,conta);
        }
        Map.Entry<String,Integer> maisUsada = null;
        for(Map.Entry<String, Integer> e: contaStrings.entrySet()){
            if(maisUsada == null || maisUsada.getValue()<e.getValue())
            maisUsada = e;
        }


        if(maisUsada != null)
        codpostal = maisUsada.getKey();
        
        return codpostal;
    }

    
    public double statFacturado(LocalDate dataInicio, LocalDate dataFim){
        double montanteapurado = 0;
        for(int i = 0; i < getListaCondo().size(); i++){
              ArrayList<Fracao> condo = getListaCondo().get(i).getFracoes();
            for(int a = 0; a < condo.size(); a++){
                ArrayList<Recibo> recibos = condo.get(a).listaRecibos();
                for(int e = 0; e < recibos.size(); e++){
                    LocalDate data = recibos.get(e).getDataemissao();
                    if(data.isAfter(dataInicio) && data.isBefore(dataFim )){
                        montanteapurado += recibos.get(e).getMontante();
                    }
                }
            }
        }
        return montanteapurado;
    }
    
    public double minmax(LocalDate dataInicio, LocalDate dataFim){
        double montanteapurado = 0;
        for(int i = 0; i < listaFacturas.size(); i++ ){
            LocalDate compare = listaFacturas.get(i).getDataemissao();
            if(compare.isAfter(dataInicio) && compare.isBefore(dataFim )){
                montanteapurado += listaFacturas.get(i).getMontante();
            }
        }
        return montanteapurado;
    }
    
    public void emitirFacturacaoMensal(){
        ArrayList<Condominio> listaRe = new ArrayList<>(listacondominios.values());
        for(int i = 0; i < listaRe.size(); i++){
            ArrayList<Fracao> fracoes = listaRe.get(i).getFracoes();
            for(int a = 0; a < fracoes.size(); a++){
                listaFacturas.add(fracoes.get(a).emitirFactura());
                
            }
        }
    }
    
    public void terminar() {
        System.exit(0);
    }
    
    public class ClienteNaoExistenteException extends Exception {
        public ClienteNaoExistenteException() { }
        public ClienteNaoExistenteException(String message) {
            super(message);
        }        
    }
    
    public class ClienteDuplicadoException extends Exception {
        public ClienteDuplicadoException() { }
        public ClienteDuplicadoException(String message) {
            super(message);
        }        
    }
    
    public class CondoDuplicadoException extends Exception {
        public CondoDuplicadoException() { }
        public CondoDuplicadoException(String message) {
            super(message);
        }        
    }
    
    public class CondoNaoExistenteException extends Exception {
        public CondoNaoExistenteException() { }
        public CondoNaoExistenteException(String message) {
            super(message);
        }        
    }
    
    public class FracaoDuplicadoException extends Exception {
        public FracaoDuplicadoException() { }
        public FracaoDuplicadoException(String message) {
            super(message);
        }        
    }
    
    public class FracaoNaoExistenteException extends Exception {
        public FracaoNaoExistenteException() { }
        public FracaoNaoExistenteException(String message) {
            super(message);
        }        
    }   
    
 }
