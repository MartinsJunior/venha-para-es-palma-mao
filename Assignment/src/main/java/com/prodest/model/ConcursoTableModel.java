package com.prodest.model;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ConcursoTableModel extends AbstractTableModel {
    //aqui transformei em coluna cada propriedade de Funcionario
    //que eu quero que seja exibida na tabela
    private String colunas[] = {"Órgão", "Edital", "Código do Concurso"};
    private List<Concurso> concursos = new ArrayList<Concurso>();
    private final int COLUNA_ORGAO = 0;
    private final int COLUNA_EDITAL = 1;
    private final int COLUNA_CODIGO = 2;

    //retorna se a célula é editável ou não
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public  void adicionar(Concurso concurso){
        concursos.add(concurso);
        fireTableRowsInserted(concursos.size()-1,concursos.size()-1);
    }

    public void clear(){
        concursos.clear();
        fireTableRowsInserted(concursos.size()-1,concursos.size()-1);
    }
    //retorna o total de itens(que virarão linhas) da nossa lista
    public int getRowCount() {
        return concursos.size();
    }
    //retorna o total de colunas da tabela

    public int getColumnCount() {
        return colunas.length;
    }
    //retorna o nome da coluna de acordo com seu indice
    @Override
    public String getColumnName(int indice) {
        return colunas[indice];
    }

    //determina o tipo de dado da coluna conforme seu indice
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case COLUNA_ORGAO:
                return String.class;
            case COLUNA_EDITAL:
                return String.class;
            case COLUNA_CODIGO:
                return String.class;
            default:
                return String.class;
        }
    }

    //preenche cada célula da tabela
    public Object getValueAt(int rowIndex, int columnIndex) {
        Concurso concurso = this.concursos.get(rowIndex);

        switch (columnIndex) {
            case COLUNA_ORGAO:
                return concurso.getOrgao();
            case COLUNA_EDITAL:
                return concurso.getEdital();
            case COLUNA_CODIGO:
                return concurso.getCodigoConcurso();
        }
        return null;
    }
    //altera o valor do objeto de acordo com a célula editada
    //e notifica a alteração da tabela, para que ela seja atualizada na tela
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //o argumento recebido pelo método é do tipo Object
        //mas como nossa tabela é de funcionários, é seguro(e até recomendável) fazer o cast de suas propriedades
        Concurso concurso= this.concursos.get(rowIndex);
        //de acordo com a coluna, ele preenche a célula com o valor
        //respectivo do objeto de mesmo indice na lista
        switch (columnIndex) {
            case COLUNA_ORGAO:
                concurso.setEdital(String.valueOf(aValue));
                break;
            case COLUNA_EDITAL:
                concurso.setEdital(String.valueOf(aValue));
                break;
            case COLUNA_CODIGO:
                concurso.setOrgao(String.valueOf(aValue));
                break;
        }
        //este método é que notifica a tabela que houve alteração de dados
        fireTableDataChanged();
    }
}
