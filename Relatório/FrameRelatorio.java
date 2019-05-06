package querybuilder;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFileChooser;
import static javax.swing.JOptionPane.CANCEL_OPTION;
import static javax.swing.JOptionPane.YES_NO_CANCEL_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import org.jdesktop.swingx.JXDatePicker;

 
public class FrameRelatorio extends javax.swing.JFrame {

    conexao_banco db = new conexao_banco();
    int existe;
    int escolha = 0;
    ArrayList<String> filanome = new ArrayList();
    ArrayList<Integer> idfila = new ArrayList();
    
    ArrayList<String> limpezanome = new ArrayList();
    ArrayList<Integer> idlimpeza = new ArrayList();
    
    public FrameRelatorio() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tb_relatorio = new javax.swing.JTable();
        btn_excel = new javax.swing.JButton();
        btn_gerar_relatorio = new javax.swing.JButton();
        btn_limpar = new javax.swing.JButton();
        cmb_filas = new javax.swing.JComboBox();
        pickFromDate = new org.jdesktop.swingx.JXDatePicker();
        pickToDate = new org.jdesktop.swingx.JXDatePicker();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmb_horainicial = new javax.swing.JComboBox();
        cmb_minutoinicial = new javax.swing.JComboBox();
        cmb_horafinal = new javax.swing.JComboBox();
        cmb_minutofinal = new javax.swing.JComboBox();
        txt_quarto = new javax.swing.JTextField();
        cmb_tipos_limpeza = new javax.swing.JComboBox();
        txt_responsavel = new javax.swing.JTextField();
        txt_pessoa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_filanome = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Relatório");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tb_relatorio.setAutoCreateRowSorter(true);
        tb_relatorio.setAutoscrolls(false);
        tb_relatorio.setDragEnabled(true);
        tb_relatorio.setEnabled(false);
        tb_relatorio.setFocusable(false);
        tb_relatorio.getTableHeader().setResizingAllowed(false);
        tb_relatorio.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tb_relatorio);

        btn_excel.setText("Exportar para Excel");
        btn_excel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excelActionPerformed(evt);
            }
        });

        btn_gerar_relatorio.setText("Gerar Relatório");
        btn_gerar_relatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gerar_relatorioActionPerformed(evt);
            }
        });

        btn_limpar.setText("Limpar");
        btn_limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limparActionPerformed(evt);
            }
        });

        String sql = "SELECT DISTINCT(tg.int_key) AS ID, tg.vch_name AS Fila_Nome \n" +
        "FROM tbl_hlt_placecleaninglist_groups tg\n" +
        "INNER JOIN tbl_hlt_place p ON p.int_key = tg.int_location\n" +
        "INNER JOIN tbl_hlt_report_accesses report \n" +
        "ON report.vch_value = tg.int_key AND report.vch_field = \"terminal_group_id\"\n";
        this.db.Conectar();
        DefaultComboBoxModel Tabelas = (DefaultComboBoxModel) this.cmb_filas.getModel();
        int linhas = 0;
        try{
            this.db.RS= this.db.stmt.executeQuery(sql);

            while(this.db.RS.next()){
                this.filanome.add(this.db.RS.getString("Fila_Nome"));
                this.idfila.add(Integer.parseInt(this.db.RS.getString("ID")));
                Tabelas.addElement(filanome.get(linhas));
                linhas++;
            }

            this.db.RS.close();
            this.db.stmt.close();
            this.db.conect.close();
        }
        catch(SQLException e){
            showMessageDialog(this,"Não existem registros!", "Não existem registros", 1);
        }

        this.pickFromDate.setDate(pickFromDate.getLinkDay());
        this.pickToDate.setDate(pickFromDate.getLinkDay());
        pickFromDate.setFormats("dd/MM/yyyy");
        pickFromDate.setName(""); // NOI18N
        pickFromDate.setVerifyInputWhenFocusTarget(false);

        pickToDate.setFormats("dd/MM/yyyy");
        pickToDate.setName(""); // NOI18N

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Fila Terminal");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Data Inicial");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Data Final");

        for(int i = 0;i<24;i++){
            if(i<10){
                this.cmb_horainicial.addItem("0" + i);
                this.cmb_horafinal.addItem("0" + i);
            }else{
                this.cmb_horainicial.addItem(i);
                this.cmb_horafinal.addItem(i);
            }
        }
        this.cmb_horafinal.setSelectedIndex(23);

        for(int i = 0;i<60;i++){
            if(i<10){
                this.cmb_minutoinicial.addItem("0" + i);
                this.cmb_minutofinal.addItem("0" + i);
            }else{
                this.cmb_minutoinicial.addItem(i);
                this.cmb_minutofinal.addItem(i);
            }
        }
        this.cmb_minutofinal.setSelectedIndex(59);

        String sqllimp = "SELECT int_key as ID, vch_name AS Limpeza_Nome FROM tbl_hlt_cleantype\n" +
        "UNION\n" +
        "SELECT 9999, \"Todos os tipos\"\n" +
        "order by ID desc";

        this.db.Conectar();
        DefaultComboBoxModel Limpezas = (DefaultComboBoxModel) this.cmb_tipos_limpeza.getModel();
        int linhas_limp = 0;
        try{
            this.db.RS= this.db.stmt.executeQuery(sqllimp);

            while(this.db.RS.next()){
                this.limpezanome.add(this.db.RS.getString("Limpeza_Nome"));
                this.idlimpeza.add(Integer.parseInt(this.db.RS.getString("ID")));
                Limpezas.addElement(limpezanome.get(linhas_limp));
                linhas_limp++;
            }
        }
        catch(SQLException e){
            showMessageDialog(this,"Não existem registros!", "Não existem registros", 1);
        }

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Quarto");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Tipo de Limpeza");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Hora Inicial");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Minuto Inicial");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Hora Final");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Minuto Final");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Participante");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Responsável");

        lbl_filanome.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lbl_filanome.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_filanome, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_gerar_relatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_excel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmb_filas, javax.swing.GroupLayout.Alignment.LEADING, 0, 191, Short.MAX_VALUE)
                            .addComponent(txt_quarto, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_pessoa, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmb_tipos_limpeza, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmb_horafinal, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmb_minutofinal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pickFromDate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pickToDate, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmb_horainicial, javax.swing.GroupLayout.Alignment.LEADING, 0, 124, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmb_minutoinicial, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                            .addComponent(txt_responsavel)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1607, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_filas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pickFromDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pickToDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_quarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_horainicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_minutoinicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_tipos_limpeza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_horafinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_minutofinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_pessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_responsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(lbl_filanome, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_gerar_relatorio)
                    .addComponent(btn_excel)
                    .addComponent(btn_limpar))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    public void Gerar_Relatorio(){
        Clear_Table();
        if(this.pickFromDate.getDate() == null || this.pickToDate.getDate() == null){
            showMessageDialog(this, "Digite um valor para data", "Data inválida", 0);
            return;
        }
        
        if(!isValidDate(FormatDate(pickFromDate, "yyyy-MM-dd"))){
            showMessageDialog(this, "Digite a data no formato certo dd/MM/aaaa", "Data inválida", 0);
            return;
        }
       
        db.Conectar();      
        DefaultTableModel Resultado = (DefaultTableModel) tb_relatorio.getModel();
        int terminal_group_id = this.idfila.get(cmb_filas.getSelectedIndex());
        int limpeza_id = this.idlimpeza.get(cmb_tipos_limpeza.getSelectedIndex());
        String fromDate = FormatDate(pickFromDate, "yyyy-MM-dd");
        String toDate = FormatDate(pickToDate, "yyyy-MM-dd");
        String horainicial = cmb_horainicial.getSelectedItem().toString();
        String horafinal = cmb_horafinal.getSelectedItem().toString();
        String minutoinicial = cmb_minutoinicial.getSelectedItem().toString();
        String minutofinal = cmb_minutofinal.getSelectedItem().toString();
        String quarto = txt_quarto.getText().trim().replaceAll("\\s+", " ");
        String pessoa = txt_pessoa.getText().trim().replaceAll("\\s+", " ");
        String responsavel = txt_responsavel.getText().trim().replaceAll("\\s+", " ");
        if(!quarto.matches("^[a-zA-Z0-9._-]*$")){
                showMessageDialog(this, "Digite o nome do quarto sem caracteres especiais (exceto '-' , '_' e '.')", "Campo inválido", 0);
                txt_quarto.setText("");
                txt_quarto.requestFocus();
                return;
        }
        String proc = "CALL gerar_relatorio_andamentos_filas_netbeans(" 
                +terminal_group_id + ",'" + 
                fromDate + "','" + 
                toDate + "','" + 
                horainicial + "','" +
                minutoinicial + "','" +
                horafinal + "','" +
                minutofinal + "','" +
                quarto + "'," +
                limpeza_id+ ",'" +
                pessoa + "','" +
                responsavel + "','" 
                +"Normal','');";      
        try{         
                db.RS = db.stmt.executeQuery(proc);
                ResultSetMetaData rsmd = db.RS.getMetaData();
                int columnsNumber = rsmd.getColumnCount(); //Pegar quantidade de Colunas da proc
                String [] etapa = new String[columnsNumber]; //Array para armazenar o nome das colunas (ETAPAS)
                String [] Dif = new String[columnsNumber]; //Array para pegar os valores de Dif              
                
                int cont=-1; //contador para montar as linhas da tabela, começa com -1 pois o index do jTable começa com 0
             
                for (int i = 1; i <= columnsNumber; i++) {
                    String Colu = rsmd.getColumnName(i);  
                    /* Se na proc começar com 'Etapa' e nao for ID,temporariamente e PlaceName*/
                    if (Colu.equals("Supervisao") || Colu.equals("Tipo de Limpeza") || Colu.equals("Participantes - Em Checklist") || Colu.equals("Participantes - Em Limpeza") || Colu.equals("Finalizado") || Colu.equals("Requisitado") || Colu.equals("PlaceName") || Colu.equals("Lancado Por") || (Colu.startsWith("Etapa") && !Colu.contains("ID") && !Colu.contains("temporariamente")) || Colu.equals("Tempo Total"))		
                    {
                        etapa[i] = Colu;                      
                        etapa[i] = etapa[i].replace("Etapa", ""); //Tirar o etapa da String para ficar somente por exemplo: Em CheckList                     
                        etapa[i] = etapa[i].replace("Supervisao", "Supervisor(a)");
                        etapa[i] = etapa[i].replace("PlaceName", "Lugar");
                    }
                }
                
                
            //Remover duplicidade no array de String
            for(int i=0;i<etapa.length;i++)				
            {
                    if(etapa[i]!=null)
                    {
                            for(int j=i+1;j<etapa.length;j++)
                            {
                                    if(etapa[i].equals(etapa[j]))	
                                    {
                                            etapa[j]=null;			
                                    }
                            }
                    }
            }
                
            /* Adicionar as Etapas no jTable*/
            for (String etapa1 : etapa) {
                if (etapa1 != null) {
                    Resultado.addColumn(etapa1.replaceAll("\\s+", " "));
                }
            }
            
            
            //Array para pegar os somente os Dif's que vem da consulta para colocar no jTable (referente ao terminal_group_id = 1,2)
            String[] resultdif = {
                    "PlaceName",
                    "Tipo de Limpeza",
                    "Lancado Por",  
                    "Supervisao", 
                    "Dif. Aguardando UTI-Aguardando Checklist", 
                    "Dif. Aguardando UTR-Aguardando Checklist", 
                    "Dif. Aguardando Checklist-Aguardando Limpeza",
                    "Dif. Em Checklist-Aguardando Limpeza",
                    "Dif. Aguardando Limpeza-Em Deslocamento", 
                    "Dif. Em Deslocamento-Em Limpeza", 
                    "Dif. Em Limpeza-Em Supervisão",       
                    "Dif. Em Supervisão-Final",
                    "Requisitado", 
                    "Finalizado",
                    "Participantes - Em Checklist",
                    "Participantes - Em Limpeza",
                    "Tempo Total"}; 
            //Array para pegar os somente os Dif's que vem da consulta para colocar no jTable (referente ao terminal_group_id = 1,2)
            String[] resultdif_4 = {
                    "PlaceName",
                    "Tipo de Limpeza",
                    "Lancado Por",  
                    "Supervisao", 
                    "Dif. Aguardando UTI-Aguardando Checklist", 
                    "Dif. Aguardando Checklist-Aguardando Limpeza",
                    "Dif. Em Checklist-Aguardando Limpeza",
                    "Dif. Aguardando Limpeza-Em Deslocamento", 
                    "Dif. Em Deslocamento-Em Limpeza", 
                    "Dif. Em Limpeza-Em Supervisão",       
                    "Dif. Em Supervisão-Final",
                    "Requisitado", 
                    "Finalizado",
                    "Participantes - Em Checklist",
                    "Participantes - Em Limpeza",
                    "Tempo Total"}; 
            
            //Array para pegar os somente os Dif's que vem da consulta para colocar no jTable (referente ao terminal_group_id = 3)
            String[] resultdif_2 = {
                    "PlaceName",
                    "Tipo de Limpeza",
                    "Lancado Por",     
                    "Supervisao", 
                    "Dif. Aguardando Limpeza-Em Deslocamento", 
                    "Dif. Em Deslocamento-Em Limpeza", 
                    "Dif. Em Limpeza-Em Supervisão",
                    "Dif. Em Supervisão-Final",
                    "Requisitado",
                    "Finalizado",               
                    "Tempo Total"};
            
            //Array para pegar os somente os Dif's que vem da consulta para colocar no jTable (referente ao terminal_group_id = 4,5)
            String[] resultdif_3 = {
                    "PlaceName",
                    "Lancado Por",     
                    "Dif. Desmontagem-Espera Higiene", 
                    "Dif. Espera Higiene-Em Higienização", 
                    "Dif. Em Higienização-Em Montagem",
                    "Dif. Desmontagem-Fim",
                    "Requisitado",
                    "Finalizado",
                    "Participantes - Em Limpeza",
                    "Tempo Total"};
            
                int linhas[] = new int[Resultado.getColumnCount()]; //Variável para somar quantas linhas vai retornar, para depois fazer a média
                if(terminal_group_id == 1 || terminal_group_id == 2){
                    tb_relatorio.moveColumn(3,11);                    
                    tb_relatorio.moveColumn(12,3);
                    tb_relatorio.moveColumn(13,4);
                    tb_relatorio.moveColumn(14,9);
                    tb_relatorio.moveColumn(15,13);
                    tb_relatorio.moveColumn(1, tb_relatorio.getColumnCount()-1);
                    tb_relatorio.setAutoResizeMode( JTable.AUTO_RESIZE_OFF ); 
                }else if(terminal_group_id == 3){
                    /*
                    tb_relatorio.moveColumn(7,2);
                    tb_relatorio.moveColumn(8,3);
                    tb_relatorio.moveColumn(9,8);
                    tb_relatorio.moveColumn(1, tb_relatorio.getColumnCount()-1);*/
                    tb_relatorio.setAutoResizeMode( JTable.AUTO_RESIZE_ALL_COLUMNS ); 
                }else if(terminal_group_id == 4 || terminal_group_id == 5){
                    tb_relatorio.moveColumn(6,2);
                    tb_relatorio.moveColumn(7,3);
                    tb_relatorio.moveColumn(8,7);
                    tb_relatorio.setAutoResizeMode( JTable.AUTO_RESIZE_ALL_COLUMNS ); 
                }
                        
                while (db.RS.next()){
                    lbl_filanome.setText("Fila Terminal ==>  " + this.filanome.get(cmb_filas.getSelectedIndex()));
                    cont++;              
                    Resultado.insertRow(cont, new Object[]{""});//Adicionar linha vazia no JTable para cada resultado que vier, para conseguir atribuir valores no setValueAt do model
                    
                    for(int aux = 0;aux<Resultado.getColumnCount();aux++){
                        if(terminal_group_id == 1)
                            Dif[aux] = db.RS.getString(resultdif[aux]);
                    else if(terminal_group_id == 2)
                            Dif[aux] = db.RS.getString(resultdif_4[aux]);
                    else if(terminal_group_id == 3)
                            Dif[aux] = db.RS.getString(resultdif_2[aux]);
                    else if(terminal_group_id == 4 || terminal_group_id == 5)
                            Dif[aux] = db.RS.getString(resultdif_3[aux]);
                        String nomecoluna = Resultado.getColumnName(aux);  //Pegar os nomes da coluna para retirar o 00:00:00 quando vier nulo, pois na proc traz alguns campos nullo e não vazio, se não sendo TIME nao é pra trazer 00:00:00
                        if(Dif[aux] != null){                                
                            //Resultado.setValueAt(Dif[aux] + " (" + DifSec[aux] + ")", cont, aux);
                            try {
                                SimpleDateFormat sdfSource = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S"); // create SimpleDateFormat object with source string date format
                                Date date = sdfSource.parse(Dif[aux]);// pegar a String e transformar em Date     
                                SimpleDateFormat sdfDestination = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// criar um SimpleDateFormat  com o formato desejadado
                                Dif[aux] = sdfDestination.format(date); //transforma a data para outro formato

                            } catch (ParseException pe) {
                                //System.out.println("Exception : " + pe);
                            }
                            Resultado.setValueAt(Dif[aux].trim(), cont, aux); 
                            linhas[aux]++;
                        }else{    
                                if(nomecoluna.equals("Supervisor(a)") || nomecoluna.equals("Participantes - Em Checklist") || nomecoluna.equals("Participantes - Em Limpeza") || nomecoluna.equals("Lancado Por"))
                                    Resultado.setValueAt("--", cont, aux);  
                                else
                                    Resultado.setValueAt("00:00:00", cont, aux);                 
                        }
                    }
                } 
                
                
                /* Só faz as somas,médias caso há resultados na query */
                if(cont != -1){
                    double []soma= new double[Resultado.getColumnCount()];
                    for(int coluna = 2;coluna<Resultado.getColumnCount();coluna++){
                        for(int linha=0;linha<Resultado.getRowCount();linha++){
                            soma[coluna] += parseTimeStringToSeconds(Resultado.getValueAt(linha, coluna).toString());                                      
                        } 
                    }

                    double []media = new double[Resultado.getColumnCount()];
                    for(int coluna = 2;coluna<Resultado.getColumnCount();coluna++){
                        for(int linha=0;linha<Resultado.getRowCount();linha++){  
                            media[coluna] = soma[coluna]/linhas[coluna];  
                        }           
                    }

                    Resultado.addRow(new Object[]{"","","","","","","","","","","","","","","","",""});
                    Resultado.addRow(new Object[]{"","","","","","","","","","","","","","","","",""});
                    Resultado.addRow(new Object[]{"","","","","","","","","","","","","","","","",""});
                    changeColor(tb_relatorio,Resultado.getRowCount()-2,Resultado.getRowCount()-3);
                    Resultado.setValueAt("Média ===>", Resultado.getRowCount()-1, 0);
                  
                    String []formattedTime = new String[Resultado.getColumnCount()]; 
                    for(int coluna = 2;coluna<Resultado.getColumnCount();coluna++){
                        String nomecoluna = Resultado.getColumnName(coluna);  //Pegar os nomes da coluna para retirar o 00:00:00 quando vier nullo, pois na proc traz alguns campos nullo e não vazio, se não sendo TIME nao é pra trazer 00:00:00
                        for(int linha=0;linha<Resultado.getRowCount();linha++){
                            formattedTime[coluna] = getDurationString((int) media[coluna]);                          
                        }
                        
                        
                        /* Se vier na coluna o tempo 00:00:00 quer dizer que é valor que veio nulo e em formato TIME*/
                        if(!formattedTime[coluna].equals("00:00:00")){
                            Resultado.setValueAt(formattedTime[coluna], Resultado.getRowCount()-1, coluna);   
                        }else{
                            if(!nomecoluna.equals("Lancado Por") && !nomecoluna.equals("Requisitado") && !nomecoluna.equals("Finalizado") && !nomecoluna.equals("Participantes - Em Checklist") && !nomecoluna.equals("Participantes - Em Limpeza") && !nomecoluna.equals("Supervisor(a)") && !nomecoluna.equals("Tipo de Limpeza")){
                                Resultado.setValueAt("00:00:00", Resultado.getRowCount()-1, coluna);   
                            }    
                        }
                    }        
                    Resultado.fireTableDataChanged();
                    tb_relatorio.getTableHeader().setEnabled(false);
                    //Ajustar a tabela para que os campos fiquem certos (tamanho de linhas e colunas)
                    update();  
                    //FrameRelatorio.setCellsAlignment(tb_relatorio, SwingConstants.CENTER);
                }else{
                    //System.out.println("Sem registros no período");
                    this.Clear_Table();
                    showMessageDialog(this, "Não foram encontrados registro no perído de " + FormatDate(pickToDate, "dd/MM/yyyy") + " até " + FormatDate(pickToDate, "dd/MM/yyyy") + " na fila Terminal: " + cmb_filas.getSelectedItem().toString(), "Sem registros", 2);
                }
                db.RS.close();
                db.stmt.close();
                db.conect.close(); 
            }
            catch(SQLException e){
                System.out.println(e);
        }
    }
    
    private void update() { 
        adjustJTableRowSizes(tb_relatorio);
        jScrollPane1.setVisible(true);
        for (int i = 0; i < tb_relatorio.getColumnCount(); i++) {
            adjustColumnSizes(tb_relatorio, i, 2);
        }
    }
    
    
    
    /* Método para ajustar tamanho das linhas*/
    private void adjustJTableRowSizes(JTable jTable) {
        for (int row = 0; row < jTable.getRowCount(); row++) {
            int maxHeight = 0;
            for (int column = 0; column < jTable.getColumnCount(); column++) {
                TableCellRenderer cellRenderer = jTable.getCellRenderer(row, column);
                Object valueAt = jTable.getValueAt(row, column);
                Component tableCellRendererComponent = cellRenderer.getTableCellRendererComponent(jTable, valueAt, false, false, row, column);
                int heightPreferable = tableCellRendererComponent.getPreferredSize().height;
                maxHeight = Math.max(heightPreferable, maxHeight);
            }
            jTable.setRowHeight(row, maxHeight);  
        }
    }
    
    
    /* Método para ajustar tamanho das colunas*/
    public void adjustColumnSizes(JTable table, int column, int margin) {
        DefaultTableColumnModel colModel = (DefaultTableColumnModel) table.getColumnModel();
        TableColumn col = colModel.getColumn(column);
        int width;

        TableCellRenderer renderer = col.getHeaderRenderer();
        if (renderer == null) {
            renderer = table.getTableHeader().getDefaultRenderer();
        }
        Component comp = renderer.getTableCellRendererComponent(table, col.getHeaderValue(), false, false, 0, 0);
        width = comp.getPreferredSize().width;
        for (int r = 0; r < table.getRowCount(); r++) {
            renderer = table.getCellRenderer(r, column);
            comp = renderer.getTableCellRendererComponent(table, table.getValueAt(r, column), false, false, r, column);
            int currentWidth = comp.getPreferredSize().width;
            width = Math.max(width, currentWidth);
        }
        width += 2 * margin;
        col.setPreferredWidth(width);       
        col.setWidth(width);
    }
  
    /* Método para mudar cor da uma linha do JTable */
    public static void changeColor(JTable table, int coloredRow, int coloredRow2)
    {
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer()
        {
            @Override
            public Component getTableCellRendererComponent(JTable table,
                Object value, boolean isSelected, boolean hasFocus, int row,
                int column)
            {
                super.getTableCellRendererComponent(table, value, isSelected,
                    hasFocus, row, column);
                if (row == coloredRow || row == coloredRow2)
                {
                    setBackground(Color.CYAN);
                }
                else
                {
                    setBackground(null);
                }
                return this;
            }
        });
        table.repaint();
    }
   
    /* Método para converter segundos em HH:MM:SS*/
    private String getDurationString(int seconds) {
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        seconds = seconds % 60;

        return twoDigitString(hours) + ":" + twoDigitString(minutes) + ":" + twoDigitString(seconds);
    }

    private String twoDigitString(int number) {
        if (number == 0) {
            return "00";
        }

        if (number / 10 == 0) {
            return "0" + number;
        }

        return String.valueOf(number);
    }
    
    
    /* Método para centralizar o texto do jTable */
    public static void setCellsAlignment(JTable table, int alignment)
    {
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(alignment);

        TableModel tableModel = table.getModel();

        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
        {
            table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);      
        }
    }
    
    /* Verificar se uma data tem formato yyyy-MM-dd HH:mm:ss */
    public static boolean isValidDate(String inDate) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setLenient(false);
            try {
              dateFormat.parse(inDate.trim());
            } catch (ParseException pe) {
              return false;
            }    
            return true;
    }
    
   
    // given time string (hours:minutes:seconds, or mm:ss, return number of seconds.
    public static double parseTime(String str) throws NumberFormatException {
        if (str == null)
            throw new NumberFormatException("parseTimeString null str");
        if (str.isEmpty())
            throw new NumberFormatException("parseTimeString empty str");

        double h = 0;
        double m, s;
        String units[] = str.split(":");
        assert (units.length == 2 || units.length == 3);
        switch (units.length) {
            case 2:
                // mm:ss
                m = Integer.parseInt(units[0]);
                s = Integer.parseInt(units[1]);
                break;
            case 3:
                // hh:mm:ss
                h = Integer.parseInt(units[0]);
                m = Integer.parseInt(units[1]);
                s = Integer.parseInt(units[2]);
                break;
            default:
                throw new NumberFormatException("parseTimeString failed:" + str);
        }
        if (m<0 || m>60 || s<0 || s>60 || h<0)
            throw new NumberFormatException("parseTimeString range error:" + str);
        return h * 3600 + m * 60 + s;
    }

    // given time string (hours:minutes:seconds, or mm:ss, return number of seconds.
    public static double parseTimeStringToSeconds(String str) {
        try{
            return parseTime(str);
        }catch (NumberFormatException nfe) {
            return 0;
        }
    }


    public void Limpar(){      
        DefaultTableModel Tabela = (DefaultTableModel) tb_relatorio.getModel(); 
        Tabela.setColumnCount(0);   
        jScrollPane1.setVisible(false);
        int rowCount = Tabela.getRowCount();
        //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            Tabela.removeRow(i);
        }
        txt_pessoa.setText("");
        txt_responsavel.setText("");
        txt_quarto.setText("");
        lbl_filanome.setText("");
        cmb_tipos_limpeza.setSelectedIndex(0);
        cmb_horafinal.setSelectedIndex(23);
        cmb_horainicial.setSelectedIndex(0);
        cmb_minutofinal.setSelectedIndex(59);
        cmb_minutoinicial.setSelectedIndex(0);
        this.pickFromDate.setDate(this.pickFromDate.getLinkDay());
        this.pickToDate.setDate(this.pickToDate.getLinkDay());
    }
    
    public void Clear_Table(){      
        DefaultTableModel Tabela = (DefaultTableModel) tb_relatorio.getModel(); 
        Tabela.setColumnCount(0);   
        jScrollPane1.setVisible(false);
        lbl_filanome.setText("");
        int rowCount = Tabela.getRowCount();
        //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            Tabela.removeRow(i);
        }    
    }
    
    public static boolean isEmpty(JTable jTable){
        if (jTable != null && jTable.getModel() != null) {
            return jTable.getModel().getRowCount()<=0;
        }
        return false;
    }
    
     /* Método para exportar JTable para excel */
    public void toExcel(JTable table, File file){
        try{
            TableModel model = table.getModel();
            FileWriter excel = new FileWriter(file);

            for(int i = 0; i < model.getColumnCount(); i++){
                excel.write(model.getColumnName(i) + "\t");                
            }

            excel.write("\n");

            for(int i=0; i< model.getRowCount(); i++) {
                for(int j=0; j < model.getColumnCount(); j++) {
                    if(model.getValueAt(i,j) == null){
                          excel.write("\t");
                    }else{
                        excel.write(model.getValueAt(i,j).toString().replaceAll("\\(.*\\)", "")+"\t");
                    }
                }
                excel.write("\n");
            }

            excel.close();

        }catch(IOException e){ System.out.println(e); }
    }
    
    private void btn_excelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excelActionPerformed
        if(isEmpty(tb_relatorio)){
            showMessageDialog(this, "Gere um relatório antes!", "Tabela vazia", 2);
            return;
        }
        DefaultTableModel Resultado = (DefaultTableModel) tb_relatorio.getModel();
        Resultado.fireTableDataChanged();
        update();  
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("Pasta de Trabalho do Excel(.xls)", "xls"));
        fc.setAcceptAllFileFilterUsed(false);
        
        int option = fc.showSaveDialog(null);
        if(option == JFileChooser.APPROVE_OPTION){
                String filename = fc.getSelectedFile().getName(); 
                String path = fc.getSelectedFile().getParentFile().getPath(); 
                File selFile = fc.getSelectedFile();
                File idea = new File(selFile + ".xls");
                
                int len = filename.length();
                String ext = "";
                String file = "";
                
                if(selFile == null){
                    return;
                }
                if(len > 4){
                        ext = filename.substring(len-4, len);
                }

                if(ext.equals(".xls")){
                        file = path + "\\" + filename; 
                }else{
                        file = path + "\\" + filename + ".xls"; 
                }
                if(idea.exists()){
                    existe = showConfirmDialog(null, "Arquivo " + filename + ".xls já existe, deseja substituílo?",  "Deseja substituir?", YES_NO_CANCEL_OPTION);
                    switch (existe) {
                        case YES_OPTION:
                            idea.delete();
                            toExcel(tb_relatorio, new File(file));
                            escolha = 1;
                            break;
                        case CANCEL_OPTION:
                            escolha = 0;
                            return;
                        default:
                            escolha = 0;
                    }
                }else{
                    toExcel(tb_relatorio, new File(file));
                }
                
                if(escolha == 1){
                    showMessageDialog(this, "Arquivo" + filename + ".xls foi substituído", "Arquivo substituído", 2);
                }else{
                    showMessageDialog(this, "Arquivo " + filename + ".xls foi gerado com sucesso!", "Arquivo gerado com sucesso", 1 );
                }
                escolha = 0;            
        }
    }//GEN-LAST:event_btn_excelActionPerformed

    private void btn_gerar_relatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gerar_relatorioActionPerformed
        Gerar_Relatorio();
    }//GEN-LAST:event_btn_gerar_relatorioActionPerformed

    private void btn_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limparActionPerformed
        Limpar();   
    }//GEN-LAST:event_btn_limparActionPerformed
    
    /* Formatar as datas fornecidas para o formato SQL (yyyy-MM-dd)*/
    public String FormatDate(JXDatePicker pick, String format){     
        DateFormat oDateFormat = new SimpleDateFormat(format);
        String szDate = oDateFormat.format(pick.getDate());       
        return szDate;
    }
    


    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setResizable(false);
        jScrollPane1.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));
        jScrollPane1.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 10));
        jScrollPane1.setVisible(false);
        txt_quarto.requestFocus(); 
    }//GEN-LAST:event_formWindowOpened

   
   public static void main(String args[]) {
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows Classic".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameRelatorio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_excel;
    private javax.swing.JButton btn_gerar_relatorio;
    private javax.swing.JButton btn_limpar;
    private javax.swing.JComboBox cmb_filas;
    private javax.swing.JComboBox cmb_horafinal;
    private javax.swing.JComboBox cmb_horainicial;
    private javax.swing.JComboBox cmb_minutofinal;
    private javax.swing.JComboBox cmb_minutoinicial;
    private javax.swing.JComboBox cmb_tipos_limpeza;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_filanome;
    private org.jdesktop.swingx.JXDatePicker pickFromDate;
    private org.jdesktop.swingx.JXDatePicker pickToDate;
    private javax.swing.JTable tb_relatorio;
    private javax.swing.JTextField txt_pessoa;
    private javax.swing.JTextField txt_quarto;
    private javax.swing.JTextField txt_responsavel;
    // End of variables declaration//GEN-END:variables
}
