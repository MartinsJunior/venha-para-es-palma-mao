package com.prodest.model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ProfissaoTableModel extends AbstractTableModel {
    //aqui transformei em coluna cada propriedade de Funcionario
    //que eu quero que seja exibida na tabela
    private String colunas[] = {"Profissoes"};
    private List<Profissao> profissoes = new ArrayList<Profissao>();
    private final int COLUNA_PROFISSAO = 0;

    //retorna se a célula é editável ou não
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public  void adicionar(Profissao profissao){
        profissoes.add(profissao);
        fireTableRowsInserted(profissoes.size()-1,profissoes.size()-1);
    }

    public void clear(){
        profissoes.clear();
        fireTableRowsInserted(profissoes.size()-1,profissoes.size()-1);
    }
    //retorna o total de itens(que virarão linhas) da nossa lista
    public int getRowCount() {
        return profissoes.size();
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
                return String.class;
    }

    //preenche cada célula da tabela
    public Object getValueAt(int rowIndex, int columnIndex) {
        Profissao profissao = this.profissoes.get(rowIndex);
        return profissao.getNome();
    }
    //altera o valor do objeto de acordo com a célula editada
    //e notifica a alteração da tabela, para que ela seja atualizada na tela
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //o argumento recebido pelo método é do tipo Object
        //mas como nossa tabela é de funcionários, é seguro(e até recomendável) fazer o cast de suas propriedades
        Profissao profissao= this.profissoes.get(rowIndex);
        //de acordo com a coluna, ele preenche a célula com o valor
        //respectivo do objeto de mesmo indice na lista
        profissao.setNome(String.valueOf(aValue));
        //este método é que notifica a tabela que houve alteração de dados
        fireTableDataChanged();
    }
}
