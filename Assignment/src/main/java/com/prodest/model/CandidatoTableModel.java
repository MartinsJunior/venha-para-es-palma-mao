package com.prodest.model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class CandidatoTableModel extends AbstractTableModel {
    //aqui transformei em coluna cada propriedade de Funcionario
    //que eu quero que seja exibida na tabela
    private String colunas[] = {"Nome", "Data de Nascimento", "Cpf"};
    private List<Candidato> candidatos = new ArrayList<Candidato>();
    private final int COLUNA_NOME = 0;
    private final int COLUNA_NASCIMENTO = 1;
    private final int COLUNA_CPF = 2;

    //retorna se a célula é editável ou não
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public  void adicionar(Candidato candidato){
        candidatos.add(candidato);
        fireTableRowsInserted(candidatos.size()-1,candidatos.size()-1);
    }

    public void clear(){
        candidatos.clear();
        fireTableRowsInserted(candidatos.size()-1,candidatos.size()-1);
    }
    //retorna o total de itens(que virarão linhas) da nossa lista
    public int getRowCount() {
        return candidatos.size();
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
            case COLUNA_NOME:
                return String.class;
            case COLUNA_NASCIMENTO:
                return String.class;
            case COLUNA_CPF:
                return String.class;
            default:
                return String.class;
        }
    }

    //preenche cada célula da tabela
    public Object getValueAt(int rowIndex, int columnIndex) {
        Candidato candidato = this.candidatos.get(rowIndex);
        switch (columnIndex) {
            case COLUNA_NOME:
                return candidato.getNome();
            case COLUNA_NASCIMENTO:
                return candidato.getDatanascimento();
            case COLUNA_CPF:
                return candidato.getCpf();
        }
        return null;
    }
    //altera o valor do objeto de acordo com a célula editada
    //e notifica a alteração da tabela, para que ela seja atualizada na tela
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //o argumento recebido pelo método é do tipo Object
        //mas como nossa tabela é de funcionários, é seguro(e até recomendável) fazer o cast de suas propriedades
        Candidato candidato= this.candidatos.get(rowIndex);
        //de acordo com a coluna, ele preenche a célula com o valor
        //respectivo do objeto de mesmo indice na lista
        switch (columnIndex) {
            case COLUNA_NOME:
                candidato.setNome(String.valueOf(aValue));
                break;
            case COLUNA_NASCIMENTO:
                candidato.setDatanascimento(String.valueOf(aValue));
                break;
            case COLUNA_CPF:
                candidato.setCpf(String.valueOf(aValue));
                break;
        }
        //este método é que notifica a tabela que houve alteração de dados
        fireTableDataChanged();
    }
}
