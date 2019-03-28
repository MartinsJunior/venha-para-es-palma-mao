public class mainTeste {


    public mainTeste() {


        //        ProfissaoDAO profissaoDAO = new ProfissaoDAO();
//        List<Profissao> profissoes = new ArrayList<Profissao>();
//        profissoes = profissaoDAO.getAll();
//        for (Profissao profissao :
//                profissoes) {
//            System.out.println(profissao.getNome());
//        }
//        LoadFileForm loadFileForm = new LoadFileForm();
//        loadFileForm.run(TIPOARQUIVO.CANDIDATO);
//        loadFileForm.run(TIPOARQUIVO.CONCURSO);


//        ConcursoDAO concursoDAO = new ConcursoDAO();
//        Concurso concurso = concursoDAO.findByCodigo("61828450843");
//        System.out.println(concurso.getEdital());
//        LoadFileToBDController loadFileToBDController = new LoadFileToBDController();
//        loadFileToBDController.loadFile("candidatos.txt",TIPOARQUIVO.CANDIDATO);
//        loadFileToBDController.loadFile("concursos.txt",TIPOARQUIVO.CONCURSO);
//        new BuscaPorCodigo().run();
//        new BuscaPorCpfForm().run();

//        CandidatoDAO candidatoDAO = new CandidatoDAO();
//        System.out.println(candidatoDAO.findBycpf("551.235.392-12").getNome());
//        List<Candidato> candidatos = candidatoDAO.findByProfissao(2);
//        for (Candidato candidato :
//                candidatos) {
//            System.out.println(candidato.getNome());
//        }
//        Candidato candidato = candidatoDAO.findBycpf("551.235.392-12");
//        for (Profissao profissao :
//                candidato.getProfissoes()) {
//            System.out.println("Profissao: "+ profissao.getNome());
//        }
//        ConcursoDAO concursoDAO = new ConcursoDAO();
//        List<Concurso> concursos = concursoDAO.findByProfissao(candidato.getProfissoes().get(2).getId());
//        for (Concurso concurso :
//                concursos) {
//            System.out.println(concurso.getOrgao());
//        }
//Miranda Stokes 21/03/1955 551.235.392-12 [carpinteiro, assistente administrativo, professor de matemática]




        //        List<Profissao> profissaos = loadFileToBDController.listarTodos();
//        for (int i = 0; i <profissaos.size() ; i++) {
//            System.out.println(profissaos.get(i).getNome()+"************");
//        }
//        ProfissaoDAO profissaoDAO = new ProfissaoDAO();
//        CandidatoDAO candidatoDAO = new CandidatoDAO();
//        ConcursoDAO concursoDAO = new ConcursoDAO();


//
//        Profissao p1 = new Profissao();
//        p1.setNome("Sanfoneiro");
//        profissaoDAO.salvar(p1);
//        Profissao p2 = new Profissao();
//        p2.setNome("Atoa");
//        profissaoDAO.salvar(p2);
//        Profissao p3 = new Profissao();
//        p3.setNome("Professor");
//        profissaoDAO.salvar(p3);
//
//
//        Candidato candidato = new Candidato();
//        candidato.setNome("Lindsey Craft");
//        candidato.setDatanascimento("19/05/1976");
//        candidato.setCpf("18284508434");
//
//        List<Profissao> profissaos = new ArrayList<Profissao>();
//        profissaos.add(p1);
//        profissaos.add(p2);
//
//        candidato.setProfissoes(profissaos);
//
//        candidatoDAO.salvar(candidato);
//        Concurso concurso = new Concurso();
//        concurso.setEdital("9/2016");
//        concurso.setCodigoConcurso("61828450843");
//        concurso.setOrgao("SEDU");
//
//        profissaos.clear();
//        profissaos.add(p3);
//        concurso.setProfisoesconcurso(profissaos);
//
//        concursoDAO.salvar(concurso);

//        List<Profissao> profissoes = loadFileToBDController.listarTodos();
//        for (int i = 0; i < profissoes.size(); i++) {
//            System.out.println("Profissao: "+profissoes.get(i).getNome());
//            List<Candidato> candidatos = (List<Candidato>) profissoes.get(i).getCandidatos();
//            for (int j = 0; j < candidatos.size(); j++) {
//                candidatos.get(i).getIdCandidato();
//            }
//        }


//        loadFileToBDController.salvar(profissao);
//        List<Profissao> profissaos = loadFileToBDController.listarTodos();
//        for (int i = 0; i <profissaos.size() ; i++) {
//            System.out.println(profissaos.get(i).getNome());
//        }
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("prodest");
//        em = emf.createEntityManager();
//        try{
//            String nome;
//            String separador = "[";
//            BufferedReader br = new BufferedReader(new FileReader("candidatos.txt"));
//            while(br.ready()){
//                String linha = br.readLine();
//                String[] textoSeparado = linha.split("\\[");
//                String profissoes = textoSeparado[1].replaceAll("\\]","");
//                String[] profissoesSeparadas = profissoes.split(",");
//                for (int i = 0; i < profissoesSeparadas.length; i++) {
//                       loadFileToBDController.salvar(new Profissao(profissoesSeparadas[i].trim()));
//                }
//            }
//            br.close();
//        }catch(IOException ioe){
//            ioe.printStackTrace();
//        }

//        criarProfissao("Caralhudo");
//
//        System.out.println("CHEGOY");
    }
}
