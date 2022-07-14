/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_escuela;
//AINESE
import static java.lang.Character.isDigit;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Interfaz extends javax.swing.JFrame {
    DefaultTableModel modelM=new DefaultTableModel();    
    DefaultTableModel modelG=new DefaultTableModel();
    DefaultTableModel modelH=new DefaultTableModel();    
    String materias1[]=new String[50];
    String idcarrera1[]=new String[50];
    String carrera1[]=new String[50];
    String grupo1[]=new String[50];
    String idmaestros1[]=new String[50];
    String idmaterias1[]=new String[50];
    String idgrupo1[]=new String[50];
    
    
    File_Usuaros usuarios=new File_Usuaros();
    Carrera carrera=new Carrera();
    Materias materias=new Materias();
    Mestros maestros=new Mestros();
    Alumnos alumnos= new Alumnos();
    Semestre semestre=new Semestre();
    Grupo grupo=new Grupo();
    Horario horario=new Horario();
    status status=new status();
          

    
    /**
     * Creates new form Interfaz
     */
    public Interfaz() {      
        initComponents();
        usuarios_btnguardar.setEnabled(false);
        semestre_btnguardar.setEnabled(false);
        carreras_btnguardar.setEnabled(false);
        materias_btnguardar.setEnabled(false);
        maestros_btnguardar.setEnabled(false);
        alumnos_btnguardar.setEnabled(false);
        grupos_btnguardar.setEnabled(false);
        horarios_btnguardar.setEnabled(false);
        modelM.addColumn("ID");
        modelM.addColumn("Maestro");
        modelM.addColumn("Grupo Academico");
        modelM.addColumn("Grado Academico");
        
        modelG.addColumn("ID Grupo");
        modelG.addColumn("NOMBRE GRUPO");
        modelG.addColumn("ID MAESTRO");
        modelG.addColumn("ID MATERIA");       
        
        modelH.addColumn("ID Grupo");
        modelH.addColumn("Materia");
        modelH.addColumn("Profesor");
        modelH.addColumn("Dia");
        modelH.addColumn("Hora");
        this.maestros_jtmaestros.setModel(modelM);
        this.grupos_jtgrupos.setModel(modelG);
        this.horarios_jthorarios.setModel(modelH);
        sobrecarga();
        tablaMaestro();
        tablaGrupo();
        String comp=status.Read();
        String comp2="";
        for(int i=0;i<comp.length()-1;i++){
            comp2+=comp.charAt(i);
        }
        if(comp2.equals("Administrador")){
        tablaHorario();
        }else if(comp2.equals("")){
            
        }else{
            tablaHorario2();
        }       
    }
   
        void tablaHorario2(){
        for(int i=modelH.getRowCount()-1;i>-1;i--){
            modelH.removeRow(i);
        }
         int cont5=0;
               String idgrupo2="";
               String materia2="";
               String profesor2="";
               String dia2="";
               String hora2="";
               String grupo3="";
               String id2="";
               int aux2=0; 
               int aux=0; 
               String texto=horario.Read();
               String texto2=status.Read();
               String nuevo="";
               for(int i=0;i<texto2.length()-1;i++){
                   nuevo+=texto2.charAt(i);
               }
               String texto3=alumnos.Read();
               String texto4= grupo.Read();
               String linea=alumnos.Buscar3(texto3, nuevo);
                    for(int i=0;i<linea.length();i++){
                        if(linea.charAt(i)=='°'){
                            aux++;
                        }
                        if(linea.charAt(i)!='°'){
                            if(aux==12){
                                grupo3+=linea.charAt(i);
                            }
                        }
                    }
                    String linea2=grupo.Buscar3(texto4, grupo3);
                    aux=0;
                    for(int i=0;i<linea2.length();i++){
                        if(linea2.charAt(i)=='°'){
                            aux++;
                        }
                        if(linea2.charAt(i)!='°'){
                            if(aux==0 && isDigit(linea2.charAt(i))){
                                id2=id2+linea2.charAt(i);
                            }
                        }
                    }
                    //ya tengo id del grupo del alumno
        for(int i=0;i<texto.length();i++){
                   if(texto.charAt(i)=='#'){
                   aux2=0;
                   if(idgrupo2.equals(id2)){
                   String[] todo=new String[5];
                   todo[0]=idgrupo2;
                   todo[1]=materia2;
                   todo[2]=profesor2;
                   todo[3]=dia2;
                   todo[4]=hora2;
                   modelH.addRow(todo);
                   }
                   idgrupo2="";
                   materia2="";
                   profesor2="";
                   dia2="";
                   hora2="";
                   }
                   if(texto.charAt(i)=='°'){
                      aux2++;
                   }
                   if(aux2==1 && texto.charAt(i)!='°'){
                   idgrupo2+=texto.charAt(i);
                   }
                   if(aux2==2 && texto.charAt(i)!='°'){
                   materia2+=texto.charAt(i);
                   }
                   if(aux2==3 && texto.charAt(i)!='°'){
                   profesor2+=texto.charAt(i);
                   }
                   if(aux2==4 && texto.charAt(i)!='°'){
                       Boolean hola=false;
                       if(isDigit(texto.charAt(i))){
                      aux2++;
                      hola=true;
                   }
                       if(hola==false){
                   dia2+=texto.charAt(i);
                       }
                   }
                   if(aux2==5 && texto.charAt(i)!='°'){
                   hora2+=texto.charAt(i);
                   }
               }
    }
    
    void tablaHorario(){
        for(int i=modelH.getRowCount()-1;i>-1;i--){
            modelH.removeRow(i);
        }
         int cont5=0;
               String texto=horario.Read();
               String idgrupo2="";
               String materia2="";
               String profesor2="";
               String dia2="";
               String hora2="";
               int aux2=0;        
        for(int i=0;i<texto.length();i++){
                   if(texto.charAt(i)=='#'){
                   aux2=0;
                   String[] todo=new String[5];
                   todo[0]=idgrupo2;
                   todo[1]=materia2;
                   todo[2]=profesor2;
                   todo[3]=dia2;
                   todo[4]=hora2;
                   modelH.addRow(todo);
                   idgrupo2="";
                   materia2="";
                   profesor2="";
                   dia2="";
                   hora2="";
                   }
                   if(texto.charAt(i)=='°'){
                      aux2++;
                   }
                   if(aux2==1 && texto.charAt(i)!='°'){
                   idgrupo2+=texto.charAt(i);
                   }
                   if(aux2==2 && texto.charAt(i)!='°'){
                   materia2+=texto.charAt(i);
                   }
                   if(aux2==3 && texto.charAt(i)!='°'){
                   profesor2+=texto.charAt(i);
                   }
                   if(aux2==4 && texto.charAt(i)!='°'){
                       Boolean hola=false;
                       if(isDigit(texto.charAt(i))){
                      aux2++;
                      hola=true;
                   }
                       if(hola==false){
                   dia2+=texto.charAt(i);
                       }
                   }
                   if(aux2==5 && texto.charAt(i)!='°'){
                   hora2+=texto.charAt(i);
                   }
               }
    }
    
    void tablaMaestro(){
        for(int i=modelM.getRowCount()-1;i>-1;i--){
            modelM.removeRow(i);
        }
         int cont5=0;
               String texto=maestros.Read();
               String id2="";
               String nombre2="";
               String grado2="";
               String grupo2="";
               int aux2=0;        
        for(int i=0;i<texto.length();i++){
                   if(texto.charAt(i)=='#'){
                   aux2=0;
                   String[] todo=new String[4];
                   todo[0]=id2;
                   todo[1]=nombre2;
                   todo[2]=grupo2;
                   todo[3]=grado2;
                   modelM.addRow(todo);
                   id2="";
                   nombre2="";
                   grupo2="";
                   grado2="";
                   }
                   if(texto.charAt(i)=='°'){
                      aux2++;
                   }
                   if(aux2==0 && isDigit(texto.charAt(i))){
                   id2+=texto.charAt(i);
                   }
                   if(aux2==1 && texto.charAt(i)!='°'){
                   nombre2+=texto.charAt(i);
                   }
                   if(aux2==2 && texto.charAt(i)!='°'){
                   grado2+=texto.charAt(i);
                   }
                   if(aux2==3 && texto.charAt(i)!='°'){
                   grupo2+=texto.charAt(i);
                   }
               }
    }
    
    void tablaGrupo(){
        for(int i=modelG.getRowCount()-1;i>-1;i--){
            modelG.removeRow(i);
        }
        String textogrupo=grupo.Read();
               String idgrupo2="";
               String nombregrupo2="";
               String idmaestro2="";
               String idmateria2="";
               int auxgrupo2=0;        
        for(int i=0;i<textogrupo.length();i++){
                   if(textogrupo.charAt(i)=='#'){
                   auxgrupo2=0;
                   String[] todoM=new String[4];
                   todoM[0]=idgrupo2;
                   todoM[1]=nombregrupo2;
                   todoM[2]=idmaestro2;
                   todoM[3]=idmateria2;
                   modelG.addRow(todoM);
                   idgrupo2="";
                   nombregrupo2="";
                   idmaestro2="";
                   idmateria2="";
                   }
                   if(textogrupo.charAt(i)=='°'){
                      auxgrupo2++;
                   }
                   if(auxgrupo2==0 && isDigit(textogrupo.charAt(i))){
                   idgrupo2+=textogrupo.charAt(i);
                   }
                   if(auxgrupo2==1 && textogrupo.charAt(i)!='°'){
                   nombregrupo2+=textogrupo.charAt(i);
                   }
                   if(auxgrupo2==2 && textogrupo.charAt(i)!='°'){
                   idmaestro2+=textogrupo.charAt(i);
                   }
                   if(auxgrupo2==3 && textogrupo.charAt(i)!='°'){
                   idmateria2+=textogrupo.charAt(i);
                   }
               }                                                
    }
    
    
    void sobrecarga(){
        String comp=status.Read();
        String comp2="";
        for(int i=0;i<comp.length()-1;i++){
            comp2+=comp.charAt(i);
        }
        if(comp2.equals("Administrador")){
        tablaHorario();
        }else if(comp2.equals("")){
            
        }else{
            tablaHorario2();
        } 
        for(int x=0;x<50;x++){
            carrera1[x]="";
            materias1[x]="";
            idcarrera1[x]="";
            grupo1[x]="";
            idmaestros1[x]="";
            idmaterias1[x]="";
        }
        //aqui se reinician los combobox
        alumnos_cbcarrera.removeAllItems();
        maestros_cbmateria.removeAllItems();
        alumnos_cbgrupo.removeAllItems();
        maestros_cbgrupoacademico.removeAllItems();
         materias_cbidcarrera.removeAllItems();
         grupos_cbidmaestro.removeAllItems();
         grupos_cbidmateria.removeAllItems();
         horarios_cbidgrupo.removeAllItems();
         horarios_cbmaterias.removeAllItems();
         alumnos_cbcarrera.addItem(" ");
        maestros_cbmateria.addItem(" ");
        alumnos_cbgrupo.addItem(" ");
        maestros_cbgrupoacademico.addItem(" ");
         materias_cbidcarrera.addItem(" ");
         grupos_cbidmaestro.addItem(" ");
         grupos_cbidmateria.addItem(" ");
         horarios_cbidgrupo.addItem(" ");
         horarios_cbmaterias.addItem(" ");
         //aqui se carga carrera
                int cont5=0;
               String texto=carrera.Read();
               String aux="";
               int aux2=0;        
        for(int i=0;i<texto.length();i++){
                   if(texto.charAt(i)=='#'){
                       carrera1[cont5]=aux;
                       alumnos_cbcarrera.addItem(aux);
                       cont5++;
                       aux="";
                       aux2=0;
                   }
                 if(texto.charAt(i)=='°'){
                     if(aux2==1 || aux2==2){
                         aux2=2;
                     }else{
                     aux2=1;
                     }
                 }
                   if(aux2==1 && texto.charAt(i)!='°'){
                   aux=aux+texto.charAt(i);
                   }
               }
        //aqui se carga materia
        cont5=0;
        texto=materias.Read();
        aux="";
        aux2=0;
        for(int i=0;i<texto.length();i++){
                   if(texto.charAt(i)=='#'){
                       materias1[cont5]=aux;
                       maestros_cbmateria.addItem(aux);
                       horarios_cbmaterias.addItem(aux);
                       cont5++;
                       aux="";
                       aux2=0;
                   }
                 if(texto.charAt(i)=='°'){
                     if(aux2==1 || aux2==2){
                         aux2=2;
                     }else{
                     aux2=1;
                     }
                 }
                   if(aux2==1 && texto.charAt(i)!='°'){
                   aux=aux+texto.charAt(i);
                   }
                   
               }
        //aqui se carga grupo
         cont5=0;
         texto=grupo.Read();
         aux="";
        aux2=0;
       for(int i=0;i<texto.length();i++){
                 if(texto.charAt(i)=='#'){
                       grupo1[cont5]=aux;
                       alumnos_cbgrupo.addItem(aux);
                       maestros_cbgrupoacademico.addItem(aux);
                       cont5++;
                       aux="";
                       aux2=0;
                   }
                 if(texto.charAt(i)=='°'){
                     if(aux2==1 || aux2==2){
                         aux2=2;
                     }else{
                     aux2=1;
                     }
                 }
                   if(aux2==1 && texto.charAt(i)!='°'){
                   aux=aux+texto.charAt(i);
                   }
                   
               }
       //aqui se carga id carrera
        cont5=0;
        texto=carrera.Read();
        aux="";
        aux2=0;
     for(int i=0;i<texto.length();i++){
                   if(texto.charAt(i)=='#'){
                       idcarrera1[cont5]=aux;
                       materias_cbidcarrera.addItem(aux);
                       cont5++;
                       aux="";
                       aux2=0;
                   }
                 if(texto.charAt(i)=='°'){
                     aux2=1;
                 }
                   if(isDigit(texto.charAt(i)) && aux2==0){
                   aux=aux+texto.charAt(i);
                   }
                   
               } 
     //aqui se carga id maestros
     cont5=0;
        texto=maestros.Read();
        aux="";
        aux2=0;
     for(int i=0;i<texto.length();i++){
                   if(texto.charAt(i)=='#'){
                       idmaestros1[cont5]=aux;
                       grupos_cbidmaestro.addItem(aux);
                       cont5++;
                       aux="";
                       aux2=0;
                   }
                 if(texto.charAt(i)=='°'){
                     aux2=1;
                 }
                   if(isDigit(texto.charAt(i)) && aux2==0){
                   aux=aux+texto.charAt(i);
                   }
                   
               }
     //aqui se carga id materias
     cont5=0;
        texto=materias.Read();
        aux="";
        aux2=0;
     for(int i=0;i<texto.length();i++){
                   if(texto.charAt(i)=='#'){
                       idmaterias1[cont5]=aux;
                       grupos_cbidmateria.addItem(aux);
                       cont5++;
                       aux="";
                       aux2=0;
                   }
                 if(texto.charAt(i)=='°'){
                     aux2=1;
                 }
                   if(isDigit(texto.charAt(i)) && aux2==0){
                   aux=aux+texto.charAt(i);
                   }  
               }
     //aqui se carga id grupos
     cont5=0;
        texto=grupo.Read();
        aux="";
        aux2=0;
     for(int i=0;i<texto.length();i++){
                   if(texto.charAt(i)=='#'){
                       idgrupo1[cont5]=aux;
                       horarios_cbidgrupo.addItem(aux);
                       cont5++;
                       aux="";
                       aux2=0;
                   }
                 if(texto.charAt(i)=='°'){
                     aux2=1;
                 }
                   if(isDigit(texto.charAt(i)) && aux2==0){
                   aux=aux+texto.charAt(i);
                   }
                   
               }
    }    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        materias_tb = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        usuarios_txtconfirmarcontraseña = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        usuarios_txtbuscar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        usuarios_btnbuscar = new javax.swing.JButton();
        usuarios_txtapellidopaterno = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        usuarios_txtnombre = new javax.swing.JTextField();
        usuarios_btnguardar = new javax.swing.JButton();
        usuarios_txtapellidomaterno = new javax.swing.JTextField();
        usuarios_btnnuevo = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        usuarios_btneditar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        usuarios_btneliminar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        usuarios_cbperfil = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        usuarios_txtnombreusuario = new javax.swing.JTextField();
        usuarios_txtid = new javax.swing.JTextField();
        usuarios_txtcontraseña = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        alumnos_txtbuscar = new javax.swing.JTextField();
        alumnos_btnbuscar = new javax.swing.JButton();
        alumnos_txtciudad = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        alumnos_txtid = new javax.swing.JTextField();
        alumnos_txtnombre = new javax.swing.JTextField();
        alumnos_txtdireccion = new javax.swing.JTextField();
        alumnos_txttelefono = new javax.swing.JTextField();
        alumnos_txtapellidomaterno = new javax.swing.JTextField();
        alumnos_txtemail = new javax.swing.JTextField();
        alumnos_txtapellidopaterno = new javax.swing.JTextField();
        alumnos_btnguardar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        alumnos_btnnuevo = new javax.swing.JButton();
        alumnos_btneditar = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        alumnos_btneliminar = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        alumnos_cbcarrera = new javax.swing.JComboBox<>();
        alumnos_cbgrupo = new javax.swing.JComboBox<>();
        alumnos_cbsemestre = new javax.swing.JComboBox<>();
        alumnos_cbperiodo = new javax.swing.JComboBox<>();
        alumnos_fechan = new javax.swing.JLabel();
        alumnos_fecha = new javax.swing.JLabel();
        alumnos_jdcfechanacimiento = new com.toedter.calendar.JDateChooser();
        alumnos_jdcfecha = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        materias_txtid = new javax.swing.JTextField();
        materias_btnnuevo = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        materias_btneditar = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        materias_btneliminar = new javax.swing.JButton();
        materias_txtnombremateria = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        materias_txtcreditos = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        materias_cbidcarrera = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        materias_cbacademia = new javax.swing.JComboBox<>();
        materias_btnguardar = new javax.swing.JButton();
        jLabel57 = new javax.swing.JLabel();
        materias_txtbuscar = new javax.swing.JTextField();
        materias_btnbuscar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        semestre_btnguardar = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        semestre_txtid = new javax.swing.JTextField();
        semestre_btnnuevo = new javax.swing.JButton();
        semestre_btneditar = new javax.swing.JButton();
        semestre_btneliminar = new javax.swing.JButton();
        semestre_cbperiodo = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        semestre_txtbuscar = new javax.swing.JTextField();
        semestre_btnbuscar = new javax.swing.JButton();
        semestre_fechai = new javax.swing.JLabel();
        semestre_fechaf = new javax.swing.JLabel();
        semestre_jdcfechainicio = new com.toedter.calendar.JDateChooser();
        semestre_jdcfechafinal = new com.toedter.calendar.JDateChooser();
        jPanel6 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        grupos_txtid = new javax.swing.JTextField();
        grupos_btnnuevo = new javax.swing.JButton();
        grupos_cbidmaestro = new javax.swing.JComboBox<>();
        jLabel54 = new javax.swing.JLabel();
        grupos_cbidmateria = new javax.swing.JComboBox<>();
        grupos_txtbuscar = new javax.swing.JTextField();
        grupos_btneditar = new javax.swing.JButton();
        grupos_btnbuscar = new javax.swing.JButton();
        grupos_btnguardar = new javax.swing.JButton();
        grupos_txtnombregrupo = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        grupos_btneliminar = new javax.swing.JButton();
        jLabel56 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        grupos_jtgrupos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        carreras_btnguardar = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        carreras_txtid = new javax.swing.JTextField();
        carreras_btnnuevo = new javax.swing.JButton();
        carreras_txtnombrecarrera = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        carreras_txtbuscar = new javax.swing.JTextField();
        carreras_btnbuscar = new javax.swing.JButton();
        carreras_btneditar = new javax.swing.JButton();
        carreras_btneliminar = new javax.swing.JButton();
        carreras_cbarea = new javax.swing.JComboBox<>();
        carreras_cbsemestre = new javax.swing.JComboBox<>();
        carrera_fecha = new javax.swing.JLabel();
        carreras_jdcfecha = new com.toedter.calendar.JDateChooser();
        jPanel7 = new javax.swing.JPanel();
        horarios_txtid = new javax.swing.JTextField();
        horarios_btnnuevo = new javax.swing.JButton();
        horarios_btnguardar = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        horarios_cbidgrupo = new javax.swing.JComboBox<>();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        horarios_txtbuscar = new javax.swing.JTextField();
        horarios_btnbuscar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        horarios_jthorarios = new javax.swing.JTable();
        jLabel60 = new javax.swing.JLabel();
        horarios_cbmaterias = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        horarios_cbdia = new javax.swing.JComboBox<>();
        jLabel46 = new javax.swing.JLabel();
        horarios_cbhorario = new javax.swing.JComboBox<>();
        horarios_btngenerarhorario = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        maestros_cbmateria = new javax.swing.JComboBox<>();
        maestros_cbgradoacademico = new javax.swing.JComboBox<>();
        jLabel45 = new javax.swing.JLabel();
        maestros_txtid = new javax.swing.JTextField();
        maestros_btnnuevo = new javax.swing.JButton();
        maestros_txtnombremaestro = new javax.swing.JTextField();
        maestros_btneditar = new javax.swing.JButton();
        maestros_btnguardar = new javax.swing.JButton();
        maestros_btneliminar = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        maestros_txtdireccion = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        maestros_txttelefono = new javax.swing.JTextField();
        maestros_cbgrupoacademico = new javax.swing.JComboBox<>();
        jLabel53 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        maestros_jtmaestros = new javax.swing.JTable();
        jLabel59 = new javax.swing.JLabel();
        maestros_txtbuscar = new javax.swing.JTextField();
        maestros_btnbuscar = new javax.swing.JButton();
        SALIR = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Nombre:");

        jLabel3.setText("Apellido Paterno:");

        usuarios_txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarios_txtbuscarActionPerformed(evt);
            }
        });

        jLabel4.setText("Apellido Materno:");

        usuarios_btnbuscar.setText("Buscar");
        usuarios_btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarios_btnbuscarActionPerformed(evt);
            }
        });

        usuarios_txtapellidopaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarios_txtapellidopaternoActionPerformed(evt);
            }
        });

        jLabel8.setText("Perfil:");

        usuarios_txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarios_txtnombreActionPerformed(evt);
            }
        });

        usuarios_btnguardar.setText("Guardar");
        usuarios_btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarios_btnguardarActionPerformed(evt);
            }
        });

        usuarios_txtapellidomaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarios_txtapellidomaternoActionPerformed(evt);
            }
        });

        usuarios_btnnuevo.setText("Nuevo");
        usuarios_btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarios_btnnuevoActionPerformed(evt);
            }
        });

        jLabel5.setText("Nombre de Usuario:");

        usuarios_btneditar.setText("Editar");
        usuarios_btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarios_btneditarActionPerformed(evt);
            }
        });

        jLabel6.setText("Confirmar Password:");

        usuarios_btneliminar.setText("Eliminar");
        usuarios_btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarios_btneliminarActionPerformed(evt);
            }
        });

        jLabel7.setText("Password:");

        usuarios_cbperfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Administrador", "Coordinador", "Alumno" }));
        usuarios_cbperfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarios_cbperfilActionPerformed(evt);
            }
        });

        jLabel1.setText("ID:");

        usuarios_txtid.setEditable(false);
        usuarios_txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarios_txtidActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(usuarios_btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usuarios_btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usuarios_btneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usuarios_btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usuarios_txtnombreusuario, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel2))
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(usuarios_txtapellidomaterno)
                                    .addComponent(usuarios_txtapellidopaterno, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(usuarios_txtnombre, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(usuarios_txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(usuarios_txtcontraseña)
                            .addComponent(usuarios_txtconfirmarcontraseña))
                        .addGap(90, 90, 90)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(usuarios_txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usuarios_btnbuscar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(usuarios_cbperfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(136, 136, 136))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuarios_txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuarios_txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuarios_btnbuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuarios_txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuarios_txtapellidopaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuarios_cbperfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuarios_txtapellidomaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usuarios_txtnombreusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usuarios_txtcontraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usuarios_txtconfirmarcontraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 273, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usuarios_btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuarios_btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuarios_btneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuarios_btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Usuarios", jPanel8);

        jLabel21.setText("ID");

        jLabel22.setText("Grupo:");

        alumnos_btnbuscar.setText("Buscar");
        alumnos_btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alumnos_btnbuscarActionPerformed(evt);
            }
        });

        jLabel23.setText("Periodo:");

        jLabel16.setText("E-mail:");

        jLabel24.setText("Fecha de Nacimiento:");

        alumnos_txtid.setEditable(false);

        alumnos_txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alumnos_txtnombreActionPerformed(evt);
            }
        });

        alumnos_txttelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alumnos_txttelefonoActionPerformed(evt);
            }
        });

        alumnos_txtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alumnos_txtemailActionPerformed(evt);
            }
        });

        alumnos_btnguardar.setText("Guardar");
        alumnos_btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alumnos_btnguardarActionPerformed(evt);
            }
        });

        jLabel17.setText("Fecha:");

        jLabel18.setText("Ciudad:");

        jLabel9.setText("ID:");
        jLabel9.setToolTipText("");

        jLabel10.setText("Nombre:");

        jLabel11.setText("Apellido Paterno:");

        jLabel12.setText("Direccion:");

        jLabel13.setText("Telefono:");

        jLabel14.setText("Apellido Materno:");

        alumnos_btnnuevo.setText("Nuevo");
        alumnos_btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alumnos_btnnuevoActionPerformed(evt);
            }
        });

        alumnos_btneditar.setText("Editar");
        alumnos_btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alumnos_btneditarActionPerformed(evt);
            }
        });

        jLabel19.setText("Carrera:");

        alumnos_btneliminar.setText("Eliminar");
        alumnos_btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alumnos_btneliminarActionPerformed(evt);
            }
        });

        jLabel20.setText("Semestre:");

        alumnos_cbcarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alumnos_cbcarreraActionPerformed(evt);
            }
        });

        alumnos_cbsemestre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        alumnos_cbsemestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alumnos_cbsemestreActionPerformed(evt);
            }
        });

        alumnos_cbperiodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Ordinario", "Vacacional" }));
        alumnos_cbperiodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alumnos_cbperiodoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(alumnos_txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(alumnos_txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(alumnos_txtapellidopaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(alumnos_txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(alumnos_txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(alumnos_txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(alumnos_txtapellidomaterno)))
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(alumnos_cbcarrera, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(alumnos_cbsemestre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(alumnos_txtciudad, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(alumnos_cbgrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(alumnos_cbperiodo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addGap(2, 2, 2))
                                    .addComponent(jLabel24))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(alumnos_jdcfechanacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(alumnos_jdcfecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(alumnos_fechan, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(alumnos_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(379, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 725, Short.MAX_VALUE)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(alumnos_txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(alumnos_btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(alumnos_btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(alumnos_btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(alumnos_btneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(alumnos_btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(alumnos_fechan, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(alumnos_jdcfechanacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(alumnos_txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(alumnos_txtnombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(alumnos_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(alumnos_jdcfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alumnos_txtapellidopaterno)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alumnos_txtciudad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alumnos_txtapellidomaterno)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alumnos_cbcarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alumnos_txtdireccion)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alumnos_cbsemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alumnos_txttelefono)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alumnos_cbgrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alumnos_txtemail)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alumnos_cbperiodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alumnos_txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alumnos_btnbuscar)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(240, 240, 240)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alumnos_btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alumnos_btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alumnos_btneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alumnos_btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        jTabbedPane1.addTab("Alumnos", jPanel1);

        materias_txtid.setEditable(false);
        materias_txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materias_txtidActionPerformed(evt);
            }
        });

        materias_btnnuevo.setText("Nuevo");
        materias_btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materias_btnnuevoActionPerformed(evt);
            }
        });

        jLabel15.setText("ID:");
        jLabel15.setToolTipText("");

        materias_btneditar.setText("Editar");
        materias_btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materias_btneditarActionPerformed(evt);
            }
        });

        jLabel25.setText("Nombre de Materia:");

        materias_btneliminar.setText("Eliminar");
        materias_btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materias_btneliminarActionPerformed(evt);
            }
        });

        jLabel26.setText("Creditos:");

        jLabel27.setText("ID Carrera:");

        materias_cbidcarrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        materias_cbidcarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materias_cbidcarreraActionPerformed(evt);
            }
        });

        jLabel28.setText("Academia:");

        materias_cbacademia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Ciencias Basicas", "Ingenierias", "Electronica y Computacion" }));

        materias_btnguardar.setText("Guardar");
        materias_btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materias_btnguardarActionPerformed(evt);
            }
        });

        jLabel57.setText("ID");

        materias_btnbuscar.setText("Buscar");
        materias_btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materias_btnbuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel27)
                        .addComponent(jLabel26)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(materias_btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(materias_btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(materias_btneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(materias_btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel28)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(materias_cbacademia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(187, 187, 187)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel25)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(materias_txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(materias_cbidcarrera, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(materias_txtcreditos)
                                    .addComponent(materias_txtnombremateria))))
                        .addGap(64, 64, 64)
                        .addComponent(jLabel57)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(materias_txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(materias_btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(446, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(materias_txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(materias_btnbuscar)
                        .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(materias_txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(materias_txtnombremateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(materias_txtcreditos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(materias_cbidcarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(materias_cbacademia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 390, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(materias_btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(materias_btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(materias_btneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(materias_btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Materias", jPanel2);

        semestre_btnguardar.setText("Guardar");
        semestre_btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semestre_btnguardarActionPerformed(evt);
            }
        });

        jLabel29.setText("Fecha Fin");

        jLabel31.setText("ID:");
        jLabel31.setToolTipText("");

        jLabel38.setText("Fecha Inicio:");

        semestre_txtid.setEditable(false);

        semestre_btnnuevo.setText("Nuevo");
        semestre_btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semestre_btnnuevoActionPerformed(evt);
            }
        });

        semestre_btneditar.setText("Editar");
        semestre_btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semestre_btneditarActionPerformed(evt);
            }
        });

        semestre_btneliminar.setText("Eliminar");
        semestre_btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semestre_btneliminarActionPerformed(evt);
            }
        });

        semestre_cbperiodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Ordinario", "Vacacional" }));
        semestre_cbperiodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semestre_cbperiodoActionPerformed(evt);
            }
        });

        jLabel30.setText("Periodo:");

        jLabel58.setText("Id:");

        semestre_btnbuscar.setText("Buscar");
        semestre_btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semestre_btnbuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(semestre_btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(semestre_btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(semestre_btneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(semestre_btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel29))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(semestre_cbperiodo, 0, 149, Short.MAX_VALUE)
                                    .addComponent(semestre_jdcfechainicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(semestre_jdcfechafinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(semestre_fechai, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                    .addComponent(semestre_fechaf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(semestre_txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(jLabel58)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(semestre_txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(semestre_btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(486, 486, 486))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(semestre_txtid)
                    .addComponent(semestre_txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(semestre_btnbuscar)
                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(semestre_cbperiodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(semestre_fechai, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(semestre_fechaf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 453, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(semestre_jdcfechainicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(semestre_jdcfechafinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(semestre_btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(semestre_btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(semestre_btneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(semestre_btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        jTabbedPane1.addTab("Semestre", jPanel4);

        jLabel51.setText("Nombre del Grupo:");

        jLabel52.setText("ID del Maestro:");

        grupos_txtid.setEditable(false);
        grupos_txtid.setName("grupo_txtid"); // NOI18N
        grupos_txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grupos_txtidActionPerformed(evt);
            }
        });

        grupos_btnnuevo.setText("Nuevo");
        grupos_btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grupos_btnnuevoActionPerformed(evt);
            }
        });

        grupos_cbidmaestro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grupos_cbidmaestroActionPerformed(evt);
            }
        });

        jLabel54.setText("Id:");

        grupos_cbidmateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grupos_cbidmateriaActionPerformed(evt);
            }
        });

        grupos_btneditar.setText("Editar");
        grupos_btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grupos_btneditarActionPerformed(evt);
            }
        });

        grupos_btnbuscar.setText("Buscar");
        grupos_btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grupos_btnbuscarActionPerformed(evt);
            }
        });

        grupos_btnguardar.setText("Guardar");
        grupos_btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grupos_btnguardarActionPerformed(evt);
            }
        });

        grupos_txtnombregrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grupos_txtnombregrupoActionPerformed(evt);
            }
        });

        jLabel55.setText("ID de la Materia:");

        grupos_btneliminar.setText("Eliminar");
        grupos_btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grupos_btneliminarActionPerformed(evt);
            }
        });

        jLabel56.setText("ID:");
        jLabel56.setToolTipText("");

        grupos_jtgrupos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID GRUPO", "NOMBRE GRUPO", "ID MAESTRO", "ID MATERIA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        grupos_jtgrupos.setToolTipText("");
        grupos_jtgrupos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        grupos_jtgrupos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        grupos_jtgrupos.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        grupos_jtgrupos.setName(""); // NOI18N
        jScrollPane4.setViewportView(grupos_jtgrupos);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(grupos_btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(grupos_btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(grupos_btneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(grupos_txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel51)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(grupos_txtnombregrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel55))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(grupos_cbidmateria, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(grupos_cbidmaestro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(grupos_btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 659, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel54)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(grupos_txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(grupos_btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(grupos_txtid)
                    .addComponent(grupos_txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(grupos_btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(grupos_txtnombregrupo))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(grupos_cbidmaestro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(grupos_cbidmateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(grupos_btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(grupos_btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(grupos_btneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(grupos_btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        jTabbedPane1.addTab("Grupos", jPanel6);

        carreras_btnguardar.setText("Guardar");
        carreras_btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carreras_btnguardarActionPerformed(evt);
            }
        });

        jLabel32.setText("Fecha:");

        jLabel34.setText("ID:");
        jLabel34.setToolTipText("");

        jLabel35.setText("Nombre de la Carrera:");

        jLabel36.setText("Area:");

        jLabel43.setText("Semestre:");

        carreras_txtid.setEditable(false);
        carreras_txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carreras_txtidActionPerformed(evt);
            }
        });

        carreras_btnnuevo.setText("Nuevo");
        carreras_btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carreras_btnnuevoActionPerformed(evt);
            }
        });

        carreras_txtnombrecarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carreras_txtnombrecarreraActionPerformed(evt);
            }
        });

        jLabel44.setText("Id:");

        carreras_txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carreras_txtbuscarActionPerformed(evt);
            }
        });

        carreras_btnbuscar.setText("Buscar");
        carreras_btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carreras_btnbuscarActionPerformed(evt);
            }
        });

        carreras_btneditar.setText("Editar");
        carreras_btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carreras_btneditarActionPerformed(evt);
            }
        });

        carreras_btneliminar.setText("Eliminar");
        carreras_btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carreras_btneliminarActionPerformed(evt);
            }
        });

        carreras_cbarea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Ciencias Basicas", "Ingenierias", "Electronica y Computacion" }));

        carreras_cbsemestre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(carreras_btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(carreras_btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(carreras_btneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(carreras_btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addGap(40, 40, 40)
                        .addComponent(carreras_txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel43)
                                    .addComponent(jLabel36))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(carreras_cbarea, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(carreras_cbsemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(carreras_txtnombrecarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 469, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(carreras_jdcfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(carrera_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel44)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(carreras_txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(carreras_btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(44, 44, 44))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carreras_txtid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(carreras_txtnombrecarrera))
                            .addComponent(carreras_jdcfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(carreras_txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(carreras_btnbuscar)
                                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(carreras_cbsemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(carreras_cbarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(239, 239, 239)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(carreras_btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(carreras_btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(carreras_btneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(carreras_btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(carrera_fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(552, 552, 552))))
        );

        jTabbedPane1.addTab("Carreras", jPanel3);

        horarios_txtid.setEditable(false);

        horarios_btnnuevo.setText("Nuevo");
        horarios_btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horarios_btnnuevoActionPerformed(evt);
            }
        });

        horarios_btnguardar.setText("Guardar");
        horarios_btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horarios_btnguardarActionPerformed(evt);
            }
        });

        jLabel48.setText("ID:");
        jLabel48.setToolTipText("");

        horarios_cbidgrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horarios_cbidgrupoActionPerformed(evt);
            }
        });

        jLabel49.setText("ID Grupo:");

        jLabel50.setText("Id:");

        horarios_btnbuscar.setText("Buscar");
        horarios_btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horarios_btnbuscarActionPerformed(evt);
            }
        });

        horarios_jthorarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID GRUPO", "MATERIA", "PROFESOR", "DIA", "HORA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        horarios_jthorarios.setToolTipText("");
        horarios_jthorarios.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        horarios_jthorarios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        horarios_jthorarios.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        horarios_jthorarios.setName(""); // NOI18N
        jScrollPane3.setViewportView(horarios_jthorarios);

        jLabel60.setText("Materias:");

        jLabel33.setText("Dia:");

        horarios_cbdia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "lunes", "martes", "miercoles", "jueves", "viernes" }));

        jLabel46.setText("Hora:");

        horarios_cbhorario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "7:00", "8:00", "9:00", "10.00", "11:00", "12:00", "1:00", "2:00" }));

        horarios_btngenerarhorario.setText("Generar Horarios");
        horarios_btngenerarhorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horarios_btngenerarhorarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(horarios_txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116)
                        .addComponent(jLabel50)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(horarios_txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(horarios_btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel49)
                            .addComponent(jLabel60)
                            .addComponent(jLabel33)
                            .addComponent(jLabel46))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(horarios_cbidgrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(horarios_cbmaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(horarios_cbdia, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(horarios_cbhorario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 841, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(horarios_btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(horarios_btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(horarios_btngenerarhorario)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(horarios_txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(horarios_btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(horarios_txtid)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(horarios_cbidgrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel60)
                            .addComponent(horarios_cbmaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(horarios_cbdia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(horarios_cbhorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel46)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 249, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(horarios_btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(horarios_btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(horarios_btngenerarhorario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        jTabbedPane1.addTab("Horarios", jPanel7);

        maestros_cbmateria.setName("maestros_cbmateria"); // NOI18N
        maestros_cbmateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maestros_cbmateriaActionPerformed(evt);
            }
        });

        maestros_cbgradoacademico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Tecnico", "Bachillerato", "Licenciatura", "Maestria", "Especialidad", "Doctorado" }));
        maestros_cbgradoacademico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maestros_cbgradoacademicoActionPerformed(evt);
            }
        });

        jLabel45.setText("Grado Academico:");

        maestros_txtid.setEditable(false);

        maestros_btnnuevo.setText("Nuevo");
        maestros_btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maestros_btnnuevoActionPerformed(evt);
            }
        });

        maestros_txtnombremaestro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maestros_txtnombremaestroActionPerformed(evt);
            }
        });

        maestros_btneditar.setText("Editar");
        maestros_btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maestros_btneditarActionPerformed(evt);
            }
        });

        maestros_btnguardar.setText("Guardar");
        maestros_btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maestros_btnguardarActionPerformed(evt);
            }
        });

        maestros_btneliminar.setText("Eliminar");
        maestros_btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maestros_btneliminarActionPerformed(evt);
            }
        });

        jLabel37.setText("ID:");
        jLabel37.setToolTipText("");

        jLabel39.setText("Nombre del maestro:");

        jLabel40.setText("Grupo Academico:");

        jLabel41.setText("Telefono:");

        jLabel42.setText("Direccion:");
        jLabel42.setToolTipText("");

        maestros_txttelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maestros_txttelefonoActionPerformed(evt);
            }
        });

        jLabel53.setText("Materia:");

        maestros_jtmaestros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "MAESTRO", "GRUPO ACADEMICO", "GRADO ACADEMICO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        maestros_jtmaestros.setToolTipText("");
        maestros_jtmaestros.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        maestros_jtmaestros.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        maestros_jtmaestros.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        maestros_jtmaestros.setName(""); // NOI18N
        jScrollPane5.setViewportView(maestros_jtmaestros);

        jLabel59.setText("Id:");

        maestros_btnbuscar.setText("Buscar");
        maestros_btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maestros_btnbuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(maestros_btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(maestros_btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(maestros_btneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(maestros_btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(maestros_txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel41)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(maestros_txttelefono))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel42)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(maestros_txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel53)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(maestros_cbmateria, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel40)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(maestros_cbgrupoacademico, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel45)
                                .addGap(18, 18, 18)
                                .addComponent(maestros_cbgradoacademico, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel39)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(maestros_txtnombremaestro, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 464, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel59)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(maestros_txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(maestros_btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(59, 59, 59))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maestros_txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(maestros_txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maestros_btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maestros_txtnombremaestro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(maestros_cbgradoacademico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maestros_cbgrupoacademico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maestros_txtdireccion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maestros_txttelefono))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(maestros_cbmateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maestros_btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maestros_btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maestros_btneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maestros_btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        maestros_cbmateria.getAccessibleContext().setAccessibleName("maestros_cbmateria");
        maestros_cbmateria.getAccessibleContext().setAccessibleDescription("maestros_cbmateria");
        jLabel45.getAccessibleContext().setAccessibleDescription("");

        jTabbedPane1.addTab("Maestros", jPanel5);

        SALIR.setText("Salir");
        SALIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SALIRActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout materias_tbLayout = new javax.swing.GroupLayout(materias_tb);
        materias_tb.setLayout(materias_tbLayout);
        materias_tbLayout.setHorizontalGroup(
            materias_tbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, materias_tbLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(SALIR, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(materias_tbLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 752, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        materias_tbLayout.setVerticalGroup(
            materias_tbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, materias_tbLayout.createSequentialGroup()
                .addComponent(SALIR, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 782, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(materias_tb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 692, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(materias_tb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void grupos_btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grupos_btneliminarActionPerformed
        String texto=grupo.Read();
        if(texto==""){
            JOptionPane.showMessageDialog(this, "No existen registros");
        }else{
            String id2=grupos_txtbuscar.getText();
            if((id2.equals(""))){
                JOptionPane.showMessageDialog(this, "No ah ingresado el ID");
            }else{
                if(!esNumero(id2)){
                    JOptionPane.showMessageDialog(this, "ID incorrecta");
                }else{
                    String texto2=grupo.Buscar2(texto, id2);
                    if(texto2=="no encontrado"){
                        JOptionPane.showMessageDialog(this, "No se encontro la ID");
                    }else{
                        String linea="";
                        String lineas="";
                        for(int i=0;i<texto.length();i++){
                            linea=linea+texto.charAt(i);
                            if(texto.charAt(i)=='#'){
                                if(linea.compareTo(texto2)==0){
                                    linea="";
                                }else{
                                    lineas=lineas+linea;
                                    linea="";
                                }
                            }
                        }
                        grupo.Write2(lineas);
                        JOptionPane.showMessageDialog(this,"Eliminado");
                    }
                }
            }
        }
        grupos_txtid.setText(null);
             grupos_txtnombregrupo.setText(null);
            grupos_cbidmaestro.setSelectedIndex(0);
            grupos_cbidmateria.setSelectedIndex(0);
            grupos_txtbuscar.setText(null);
            tablaGrupo();
    }//GEN-LAST:event_grupos_btneliminarActionPerformed

    private void grupos_txtnombregrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grupos_txtnombregrupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_grupos_txtnombregrupoActionPerformed

    private void grupos_btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grupos_btnguardarActionPerformed
        // TODO add your handling code here:
        Boolean b=false;
        String txt;
        int cont5=0;
        String[] ids=new String[100];
        String texto=grupo.Read();
        String aux="";
        int aux2=0;
        for(int i=0;i<texto.length();i++){
            if(texto.charAt(i)=='#'){
                ids[cont5]=aux;
                cont5++;
                aux="";
                aux2=0;
            }
            if(texto.charAt(i)=='°'){
                aux2=1;
            }
            if(isDigit(texto.charAt(i)) && aux2==0){
                aux=aux+texto.charAt(i);
            }

        }
        String a=""+cont5;
        grupos_txtid.setText(a);

        for(int i=0;i<cont5;i++){
            if(grupos_txtid.getText().equals(ids[i])){
                b=true;
            }
        }
        if(b==true){
            JOptionPane.showMessageDialog(this, "La ID ya existe");
        }else{
            Boolean hola=false;
            if(esLetra(grupos_txtnombregrupo.getText())){
                hola=true;
            }
            if(hola==true){
            txt=cont5+"°"+grupos_txtnombregrupo.getText()+"°"+grupos_cbidmaestro.getSelectedItem()+"°"+grupos_cbidmateria.getSelectedItem()+"#"+"\n";
            grupo.Write(txt);
            JOptionPane.showMessageDialog(this, "Grupo Guardado");
            }else{
               JOptionPane.showMessageDialog(this, "Caracteres invalidos"); 
            }
        }
         grupos_btnnuevo.setEnabled(true);
               grupos_btnbuscar.setEnabled(true);
               grupos_btneditar.setEnabled(true);
             grupos_btneliminar.setEnabled(true);
            grupos_btnguardar.setEnabled(false);
        grupos_txtid.setText(null);
             grupos_txtnombregrupo.setText(null);
            grupos_cbidmaestro.setSelectedIndex(0);
            grupos_cbidmateria.setSelectedIndex(0);
            grupos_txtbuscar.setText(null);
            tablaGrupo();
    }//GEN-LAST:event_grupos_btnguardarActionPerformed

    private void grupos_btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grupos_btnbuscarActionPerformed
        sobrecarga();
        int aux=0;
       String id1=grupos_txtbuscar.getText();
       grupos_txtid.setText(null);
             grupos_txtnombregrupo.setText(null);
            grupos_cbidmaestro.setSelectedIndex(0);
            grupos_cbidmateria.setSelectedIndex(0);
            grupos_txtbuscar.setText(null);
        if(id1.equals("")){
            JOptionPane.showMessageDialog(this, "No ah ingresado la ID");
        }else{
            if(!esNumero(id1)){
               JOptionPane.showMessageDialog(this, "ID invalida"); 
            }else{
        String texto=grupo.Read();
        String texto2=grupo.Buscar(texto, id1);
        if(texto2=="no encontrado"){
            JOptionPane.showMessageDialog(this, "No se encontro la id");
        }else{
            String id2="";
            String nombregrupo2="";
            String idMaestro2="";
            String idMateria2="";
            String fecha2="";
            for(int i=0;i<texto2.length();i++){
                if(texto2.charAt(i)=='°'){
                    aux++;
                }
                if(texto2.charAt(i)!='°'){
                  if(aux==0){
                        id2=id2+texto2.charAt(i);
                    }  
                  if(aux==1){
                        nombregrupo2+=texto2.charAt(i);
                    }
                  if(aux==2){
                        idMaestro2+=texto2.charAt(i);
                    }
                  if(aux==3){
                       idMateria2+=texto2.charAt(i);
                    }
                  
                }
                }
            grupos_txtid.setText(id2);
             grupos_txtnombregrupo.setText(nombregrupo2);
            grupos_cbidmaestro.setSelectedItem(idMaestro2);
            grupos_cbidmateria.setSelectedItem(idMateria2);
            grupos_txtbuscar.setText(null);
           
            //semestre_jdcfechainicio.setDate(null);
        }
        }
        }
    }//GEN-LAST:event_grupos_btnbuscarActionPerformed

    private void grupos_btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grupos_btneditarActionPerformed
        String completo="";
        String auxtext="";
        Boolean yes=false;
        int aux=0;

        String id=grupos_txtbuscar.getText();
        if(id.equals("")){
            JOptionPane.showMessageDialog(this, "No ah ingresado la ID");
        }else{
            if(!esNumero(id)){
                JOptionPane.showMessageDialog(this, "ID incorrecta");
            }else{
                String periodo2="";
                String id2="";
                String nombre2="";
                String idmaestro2="";
                String idmateria2="";
                String texto=grupo.Read();
                String linea=grupo.Buscar(texto, id);
                if(linea=="no encontrado"){
                    JOptionPane.showMessageDialog(this, "No se encontro el ID");
                }else{
                    for(int i=0;i<linea.length();i++){
                        if(linea.charAt(i)=='°'){
                            aux++;
                        }
                        if(linea.charAt(i)!='°'){
                            if(aux==0){
                                id2=id2+linea.charAt(i);
                            }
                            if(aux==1){
                                nombre2=nombre2+linea.charAt(i);
                            }
                            if(aux==2){
                                idmaestro2+=linea.charAt(i);
                            }
                            if(aux==3){
                                idmateria2+=linea.charAt(i);
                            }

                        }
                    }
                    Boolean hola=false;
                    if(!(grupos_txtnombregrupo.getText().equals("")) && hola==false){
                        nombre2=grupos_txtnombregrupo.getText();
                        yes=true;
                        if(!esLetra(grupos_txtnombregrupo.getText())){
                            hola=true;
                        }
                    }
                    if(!(grupos_cbidmaestro.getSelectedItem().equals(" ")) && hola==false){
                        idmaestro2=(String)grupos_cbidmaestro.getSelectedItem();
                        yes=true;
                    }
                    if(!(grupos_cbidmateria.getSelectedItem().equals(" ")) && hola==false){
                        idmateria2=(String)grupos_cbidmateria.getSelectedItem();
                        yes=true;
                    }
                    if(hola==true){
                        yes=false;
                        JOptionPane.showMessageDialog(this, "Caracter invalido");
                    }
                    if(yes==true){
                    completo=id2+"°"+nombre2+"°"+idmaestro2+"°"+idmateria2+"#"+"\n";
                    grupo.Write(completo);
                    String renglon="";
                    String lineas="";
                    linea=linea+"#";
                    texto=grupo.Read();
                    for(int i=0;i<texto.length();i++){
                        renglon=renglon+texto.charAt(i);
                        if(renglon.equals(linea)){
                            renglon="";
                        }else{                if(texto.charAt(i)=='#'){

                            lineas=lineas+renglon;
                            renglon="";
                        }
                    }
                }
                grupo.Write2(lineas);
                JOptionPane.showMessageDialog(this, "Editado correctamente");
                    }
            }
        }
        }
        grupos_txtid.setText(null);
             grupos_txtnombregrupo.setText(null);
            grupos_cbidmaestro.setSelectedIndex(0);
            grupos_cbidmateria.setSelectedIndex(0);
            grupos_txtbuscar.setText(null);
            tablaGrupo();
    }//GEN-LAST:event_grupos_btneditarActionPerformed

    private void grupos_cbidmateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grupos_cbidmateriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_grupos_cbidmateriaActionPerformed

    private void grupos_cbidmaestroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grupos_cbidmaestroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_grupos_cbidmaestroActionPerformed

    private void grupos_btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grupos_btnnuevoActionPerformed
        sobrecarga();
          grupos_btnnuevo.setEnabled(false);
         grupos_btnbuscar.setEnabled(false);
         grupos_btneditar.setEnabled(false);
         grupos_btneliminar.setEnabled(false);
         grupos_btnguardar.setEnabled(true);
        grupos_txtid.setText(null);
             grupos_txtnombregrupo.setText(null);
            grupos_cbidmaestro.setSelectedIndex(0);
            grupos_cbidmateria.setSelectedIndex(0);
            grupos_txtbuscar.setText(null);
        sobrecarga();

        int cont5=0;
        String[] ids=new String[100];
        String texto=grupo.Read();
        String aux="";
        int aux2=0;
        for(int i=0;i<texto.length();i++){
            if(texto.charAt(i)=='#'){
                ids[cont5]=aux;
                cont5++;
                aux="";
                aux2=0;
            }
            if(texto.charAt(i)=='°'){
                aux2=1;
            }
            if(isDigit(texto.charAt(i)) && aux2==0){
                aux=aux+texto.charAt(i);
            }

        }
        String a=""+cont5;
        grupos_txtid.setText(a);
    }//GEN-LAST:event_grupos_btnnuevoActionPerformed

    private void grupos_txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grupos_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_grupos_txtidActionPerformed

    private void alumnos_cbsemestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alumnos_cbsemestreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alumnos_cbsemestreActionPerformed

    private void alumnos_btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alumnos_btneliminarActionPerformed
        String texto=alumnos.Read();
        if(texto==""){
            JOptionPane.showMessageDialog(this, "No existen registros");
        }else{
            String id2=alumnos_txtbuscar.getText();
            if(id2.equals("")){
                JOptionPane.showMessageDialog(this, "No ah ingresado la ID");
            }else{
                if(!esNumero(id2)){
                    JOptionPane.showMessageDialog(this, "ID incorrecta");
                }else{
                    String texto2=alumnos.Buscar2(texto, id2);
                    if(texto2=="no encontrado"){
                        JOptionPane.showMessageDialog(this, "No se encontro la ID");
                    }else{
                        String linea="";
                        String lineas="";
                        for(int i=0;i<texto.length();i++){
                            linea=linea+texto.charAt(i);
                            if(texto.charAt(i)=='#'){
                                if(linea.compareTo(texto2)==0){
                                    linea="";
                                }else{
                                    lineas=lineas+linea;
                                    linea="";
                                }
                            }
                        }
                        alumnos.Write2(lineas);
                        JOptionPane.showMessageDialog(this,"Eliminado");
                    }
                }
            }
        }
        alumnos_txtid.setText(null);
            alumnos_txtnombre.setText(null);
            alumnos_txtapellidopaterno.setText(null);
            alumnos_txtapellidopaterno.setText(null);
           alumnos_txtdireccion.setText(null);
           alumnos_txttelefono.setText(null);
            alumnos_txtbuscar.setText(null);
            alumnos_txtciudad.setText(null);
            alumnos_txtemail.setText(null);
            alumnos_fechan.setText(null);
            alumnos_fecha.setText(null);
            alumnos_cbcarrera.setSelectedIndex(0);
            alumnos_cbsemestre.setSelectedIndex(0);
            alumnos_cbgrupo.setSelectedIndex(0);
            alumnos_cbperiodo.setSelectedIndex(0);
            alumnos_jdcfechanacimiento.setDate(null);
            alumnos_jdcfecha.setDate(null);
    }//GEN-LAST:event_alumnos_btneliminarActionPerformed

    private void alumnos_btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alumnos_btneditarActionPerformed
        Boolean yes=false;
        Boolean qalumnos=false;
        String completo="";
        String auxtext="";
        int aux=0;

        String id=alumnos_txtbuscar.getText();
        if(id.equals("")){
            JOptionPane.showMessageDialog(this, "No ah ingresado ID");
        }else{
            if(!esNumero(id)){
                JOptionPane.showMessageDialog(this, "ID incorrecta");
            }else{
                String nombre2="";
                String id2="";
                String direccion2="";
                String apellidoP2="";
                String apellidoM2="";
                String telefono2="";
                String email2="";
                String ciudad2="";
                String carrera2="";
                String semestre2="";
                String grupo2="";
                String periodo2="";
                String fechanacimiento2="";
                String fecha2="";
                String texto=alumnos.Read();
                String linea=alumnos.Buscar(texto, id);
                if(linea=="no encontrado"){
                    JOptionPane.showMessageDialog(this, "No se encontro el ID");
                }else{
                    for(int i=0;i<linea.length();i++){
                        if(linea.charAt(i)=='°'){
                            aux++;
                        }
                        if(linea.charAt(i)!='°'){
                            if(aux==0){
                                id2=id2+linea.charAt(i);
                            }
                            if(aux==1){
                                nombre2=nombre2+linea.charAt(i);
                            }
                            if(aux==2){
                                apellidoP2+=linea.charAt(i);
                            }
                            if(aux==3){
                                apellidoM2+=linea.charAt(i);
                            }
                            if(aux==4){
                                direccion2+=linea.charAt(i);
                            }
                            if(aux==5){
                                telefono2+=linea.charAt(i);
                            }
                            if(aux==6){
                                email2+=linea.charAt(i);
                            }
                            if(aux==7){
                                fechanacimiento2+=linea.charAt(i);
                            }
                            if(aux==8){
                                fecha2+=linea.charAt(i);
                            }
                            if(aux==9){
                                ciudad2+=linea.charAt(i);
                            }
                            if(aux==10){
                                carrera2+=linea.charAt(i);
                            }
                            if(aux==11){
                                semestre2+=linea.charAt(i);
                            }
                            if(aux==12){
                                grupo2+=linea.charAt(i);
                            }
                            if(aux==13){
                                periodo2+=linea.charAt(i);
                            }

                        }
                    }
                    Boolean hola=true;
                    SimpleDateFormat dFormat=new SimpleDateFormat("dd-MM-yyyy");
                    SimpleDateFormat dFormat2=new SimpleDateFormat("dd-MM-yyyy");
                    if(!(alumnos_jdcfecha.getDate()==null) && hola==true){
                        fecha2=dFormat.format(alumnos_jdcfecha.getDate());
                        yes=true;
                    }
                    if(!(alumnos_jdcfechanacimiento.getDate()==null) && hola==true){
                        fechanacimiento2=dFormat2.format(alumnos_jdcfechanacimiento.getDate());
                        yes=true;
                    }
                    if(!(alumnos_txtnombre.getText().equals("")) && hola==true){
                        nombre2=alumnos_txtnombre.getText();
                        yes=true;
                        if(!esLetra(alumnos_txtnombre.getText())){
                            hola=false;
                        }
                    }
                    if(!(alumnos_txtapellidopaterno.getText().equals("")) && hola==true){
                        apellidoP2=alumnos_txtapellidopaterno.getText();
                        yes=true;
                        if(!esLetra(alumnos_txtapellidopaterno.getText())){
                            hola=false;
                        }
                    }
                    if(!(alumnos_txtapellidomaterno.getText().equals("")) && hola==true){
                        apellidoM2=alumnos_txtapellidomaterno.getText();
                        yes=true;
                        if(!esLetra(alumnos_txtapellidomaterno.getText())){
                            hola=false;
                        }
                    }
                    if(!(alumnos_txtdireccion.getText().equals("")) && hola==true){
                        direccion2=alumnos_txtdireccion.getText();
                        yes=true;
                        
                    }
                    if(!(alumnos_txttelefono.getText().equals("")) && hola==true){
                        telefono2=alumnos_txttelefono.getText();
                        yes=true;
                        if(!esNumero(alumnos_txttelefono.getText())){
                            hola=false;
                        }
                    }
                    if(!(alumnos_txtemail.getText().equals("")) && hola==true){
                        email2=alumnos_txtemail.getText();
                        yes=true;
                    }
                    if(!(alumnos_txtciudad.getText().equals("")) && hola==true){
                        ciudad2=alumnos_txtciudad.getText();
                        yes=true;
                        if(!esLetra(alumnos_txtciudad.getText())){
                            hola=false;
                        }
                    }
                    if(!(alumnos_cbcarrera.getSelectedItem().equals("")) && hola==true){
                        carrera2=(String)alumnos_cbcarrera.getSelectedItem();
                        yes=true;
                    }
                    if(!(alumnos_cbsemestre.getSelectedItem().equals("")) && hola==true){
                        semestre2=(String)alumnos_cbsemestre.getSelectedItem();
                        yes=true;
                    }
                    if(!(alumnos_cbgrupo.getSelectedItem().equals("")) && hola==true){
                        grupo2=(String)alumnos_cbgrupo.getSelectedItem();
                        yes=true;
                    }
                    if(!(alumnos_cbperiodo.getSelectedItem().equals("")) && hola==true){
                        periodo2=(String)alumnos_cbperiodo.getSelectedItem();
                        yes=true;
                    }
                    if(hola==false){
                       yes=false; 
                       JOptionPane.showMessageDialog(this, "Caracteres invalidos");
                    }
                    if(yes==true){
                    completo=id2+"°"+nombre2+"°"+apellidoP2+"°"+apellidoM2+"°"+direccion2+"°"+telefono2+"°"+email2+"°"+fechanacimiento2+"°"+fecha2+"°"+ciudad2+"°"+carrera2+"°"+semestre2+"°"+grupo2+"°"+periodo2+"#"+"\n";
                    alumnos.Write(completo);

                    String renglon="";
                    String lineas="";
                    linea=linea+"#";
                    texto=alumnos.Read();
                    for(int i=0;i<texto.length();i++){
                        renglon=renglon+texto.charAt(i);
                        if(texto.charAt(i)=='#'){
                            if(renglon.equals(linea)){
                                renglon="";
                            }else{
                                lineas=lineas+renglon;
                                renglon="";
                            }
                        }
                    }
                    alumnos.Write2(lineas);
                    JOptionPane.showMessageDialog(this, "Editado correctamente");
                }
                }
            }
        }
        alumnos_txtid.setText(null);
            alumnos_txtnombre.setText(null);
            alumnos_txtapellidopaterno.setText(null);
            alumnos_txtapellidopaterno.setText(null);
           alumnos_txtdireccion.setText(null);
           alumnos_txttelefono.setText(null);
            alumnos_txtbuscar.setText(null);
            alumnos_txtciudad.setText(null);
            alumnos_txtemail.setText(null);
            alumnos_fechan.setText(null);
            alumnos_fecha.setText(null);
            alumnos_cbcarrera.setSelectedIndex(0);
            alumnos_cbsemestre.setSelectedIndex(0);
            alumnos_cbgrupo.setSelectedIndex(0);
            alumnos_cbperiodo.setSelectedIndex(0);
            alumnos_jdcfechanacimiento.setDate(null);
            alumnos_jdcfecha.setDate(null);
    }//GEN-LAST:event_alumnos_btneditarActionPerformed

    private void alumnos_btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alumnos_btnnuevoActionPerformed
        sobrecarga();
          alumnos_btnnuevo.setEnabled(false);
        alumnos_btnbuscar.setEnabled(false);
        alumnos_btneditar.setEnabled(false);
        alumnos_btneliminar.setEnabled(false);
        alumnos_btnguardar.setEnabled(true);
       alumnos_txtid.setText(null);
            alumnos_txtnombre.setText(null);
            alumnos_txtapellidopaterno.setText(null);
            alumnos_txtapellidopaterno.setText(null);
           alumnos_txtdireccion.setText(null);
           alumnos_txttelefono.setText(null);
            alumnos_txtbuscar.setText(null);
            alumnos_txtciudad.setText(null);
            alumnos_txtemail.setText(null);
            alumnos_fechan.setText(null);
            alumnos_fecha.setText(null);
            alumnos_cbcarrera.setSelectedIndex(0);
            alumnos_cbsemestre.setSelectedIndex(0);
            alumnos_cbgrupo.setSelectedIndex(0);
            alumnos_cbperiodo.setSelectedIndex(0);
            alumnos_jdcfechanacimiento.setDate(null);
            alumnos_jdcfecha.setDate(null);
        sobrecarga();
        int cont5=0;
        String[] ids=new String[100];
        String texto=alumnos.Read();
        String aux="";
        int aux2=0;
        for(int i=0;i<texto.length();i++){
            if(texto.charAt(i)=='#'){
                ids[cont5]=aux;
                cont5++;
                aux="";
                aux2=0;
            }
            if(texto.charAt(i)=='°'){
                aux2=1;
            }
            if(isDigit(texto.charAt(i)) && aux2==0){
                aux=aux+texto.charAt(i);
            }

        }
        String a=""+cont5;
        alumnos_txtid.setText(a);
    }//GEN-LAST:event_alumnos_btnnuevoActionPerformed

    private void alumnos_btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alumnos_btnguardarActionPerformed
        String[] ids=new String[100];
        Boolean b=false;
        String txt;
        int contAlumnos=0;
        String texto=alumnos.Read();
        String aux="",fechaN="",fechaI="";
        int aux2=0;
        for(int i=0;i<texto.length();i++){
            if(texto.charAt(i)=='#'){
                ids[contAlumnos]=aux;
                contAlumnos++;
                aux="";
                aux2=0;
            }
            if(texto.charAt(i)=='°'){
                aux2=1;
            }
            if(isDigit(texto.charAt(i)) && aux2==0){
                aux=aux+texto.charAt(i);
            }

        }

        for(int i=0;i<contAlumnos;i++){
            if(alumnos_txtid.getText().equals(ids[i])){
                b=true;
            }
        }
        if(b==true){

            JOptionPane.showMessageDialog(this, "La ID ya existe");
        }else{
            SimpleDateFormat dFormat=new SimpleDateFormat("dd-MM-yyyy");
             if(!(alumnos_jdcfechanacimiento.getDate()==null)){
                fechaN=dFormat.format(alumnos_jdcfechanacimiento.getDate());
            }
             if(!(alumnos_jdcfecha.getDate()==null)){
                fechaI=dFormat.format(alumnos_jdcfecha.getDate());
            }
             Boolean hola=false;
           if(esLetra(alumnos_txtnombre.getText())){
              if(esLetra(alumnos_txtapellidopaterno.getText())){
                 if(esLetra(alumnos_txtapellidomaterno.getText())){
                    if(esNumero(alumnos_txttelefono.getText())){
                        if(esLetra(alumnos_txtciudad.getText())){
                           hola=true;
            }    
            }        
            }           
            }              
            }
           if(hola==true){
            txt=alumnos_txtid.getText()+"°"
            +alumnos_txtnombre.getText()+"°"+alumnos_txtapellidopaterno.getText()+"°"+alumnos_txtapellidomaterno.getText()+"°"
            +alumnos_txtdireccion.getText()+"°"+alumnos_txttelefono.getText()+"°"+alumnos_txtemail.getText()+"°"+fechaN+"°"+fechaI+"°"
            +alumnos_txtciudad.getText()+"°"+alumnos_cbcarrera.getSelectedItem()+"°"
            +alumnos_cbsemestre.getSelectedItem()+"°"+alumnos_cbgrupo.getSelectedItem()+"°"+alumnos_cbperiodo.getSelectedItem()+"#"+"\n";
            alumnos.Write(txt);
            JOptionPane.showMessageDialog(this, "Usuario Guardado");
           }else{
             JOptionPane.showMessageDialog(this, "Caracteres invalidos");  
           }
        }
        alumnos_btnnuevo.setEnabled(true);
        alumnos_btnbuscar.setEnabled(true);
        alumnos_btneliminar.setEnabled(true);
        alumnos_btneditar.setEnabled(true);
               alumnos_txtid.setText(null);
            alumnos_txtnombre.setText(null);
            alumnos_txtapellidopaterno.setText(null);
            alumnos_txtapellidomaterno.setText(null);
           alumnos_txtdireccion.setText(null);
           alumnos_txttelefono.setText(null);
            alumnos_txtbuscar.setText(null);
            alumnos_txtciudad.setText(null);
            alumnos_txtemail.setText(null);
            alumnos_fechan.setText(null);
            alumnos_fecha.setText(null);
            alumnos_cbcarrera.setSelectedIndex(0);
            alumnos_cbsemestre.setSelectedIndex(0);
            alumnos_cbgrupo.setSelectedIndex(0);
            alumnos_cbperiodo.setSelectedIndex(0);
            alumnos_jdcfechanacimiento.setDate(null);
            alumnos_jdcfecha.setDate(null);
    }//GEN-LAST:event_alumnos_btnguardarActionPerformed

    private void alumnos_txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alumnos_txtemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alumnos_txtemailActionPerformed

    private void alumnos_txttelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alumnos_txttelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alumnos_txttelefonoActionPerformed

    private void alumnos_txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alumnos_txtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alumnos_txtnombreActionPerformed

    private void alumnos_btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alumnos_btnbuscarActionPerformed
        // TODO add your handling code here:
        sobrecarga();
        String nombre2="";
        String id2="";
        String direccion2="";
        String apellidoP2="";
        String apellidoM2="";
        String telefono2="";
        String email2="";
        String ciudad2="";
        String carrera2="";
        String semestre2="";
        String grupo2="";
        String periodo2="";
        String fechaN2="";
        String fecha2="";
        String mesF2="";
        String añoF2="";
 int aux=0;
       String id1=alumnos_txtbuscar.getText();
        if(id1.equals("")){
            JOptionPane.showMessageDialog(this, "No ah ingresado la ID");
            alumnos_txtid.setText(null);
            alumnos_txtnombre.setText(null);
            alumnos_txtapellidopaterno.setText(null);
            alumnos_txtapellidomaterno.setText(null);
           alumnos_txtdireccion.setText(null);
           alumnos_txttelefono.setText(null);
            alumnos_txtbuscar.setText(null);
            alumnos_txtciudad.setText(null);
            alumnos_txtemail.setText(null);
            alumnos_fechan.setText(null);
            alumnos_fecha.setText(null);
            alumnos_cbcarrera.setSelectedIndex(0);
            alumnos_cbsemestre.setSelectedIndex(0);
            alumnos_cbgrupo.setSelectedIndex(0);
            alumnos_cbperiodo.setSelectedIndex(0);
            alumnos_jdcfechanacimiento.setDate(null);
            alumnos_jdcfecha.setDate(null);
        }else{
            if(!esNumero(id1)){
               JOptionPane.showMessageDialog(this, "ID invalida"); 
               alumnos_txtid.setText(null);
            alumnos_txtnombre.setText(null);
            alumnos_txtapellidopaterno.setText(null);
            alumnos_txtapellidomaterno.setText(null);
           alumnos_txtdireccion.setText(null);
           alumnos_txttelefono.setText(null);
            alumnos_txtbuscar.setText(null);
            alumnos_txtciudad.setText(null);
            alumnos_txtemail.setText(null);
            alumnos_fechan.setText(null);
            alumnos_fecha.setText(null);
            alumnos_cbcarrera.setSelectedIndex(0);
            alumnos_cbsemestre.setSelectedIndex(0);
            alumnos_cbgrupo.setSelectedIndex(0);
            alumnos_cbperiodo.setSelectedIndex(0);
            alumnos_jdcfechanacimiento.setDate(null);
            alumnos_jdcfecha.setDate(null);
            }else{
        String texto=alumnos.Read();
        String texto2=alumnos.Buscar(texto, id1);
        if(texto2=="no encontrado"){
            JOptionPane.showMessageDialog(this, "No se encontro la id");
         
        }else{
            for(int i=0;i<texto2.length();i++){
                if(texto2.charAt(i)=='°'){
                    aux++;
                }
                if(texto2.charAt(i)!='°'){
                  if(aux==0){
                        id2=id2+texto2.charAt(i);
                    }  
                  if(aux==1){
                        nombre2+=texto2.charAt(i);
                    }
                  if(aux==2){
                        apellidoP2+=texto2.charAt(i);
                    }
                  if(aux==3){
                        apellidoM2+=texto2.charAt(i);
                    } 
                  if(aux==4){
                        direccion2+=texto2.charAt(i);
                    }
                  if(aux==5){
                        telefono2+=texto2.charAt(i);
                    }
                  if(aux==6){
                        email2+=texto2.charAt(i);
                    }
                  if(aux==7){
                      fechaN2+=texto2.charAt(i);
                }
                  if(aux==8){
                      fecha2+=texto2.charAt(i);
                  }
                if(aux==9){
                   ciudad2+=texto2.charAt(i);
                }
                if(aux==10){
                    carrera2+=texto2.charAt(i);
                    }
                if(aux==11){
                    semestre2+=texto2.charAt(i);
                }
                if(aux==12){
                   grupo2+=texto2.charAt(i);
                }
                if(aux==13){
                    periodo2+=texto2.charAt(i);
                }
                }
              }
            alumnos_txtid.setText(id2);
            alumnos_txtnombre.setText(nombre2);
             alumnos_txtapellidopaterno.setText(apellidoP2);
             alumnos_txtapellidomaterno.setText(apellidoM2);
               alumnos_txtdireccion.setText(direccion2);
           alumnos_txttelefono.setText(telefono2);
            alumnos_txtemail.setText(email2);
            alumnos_fechan.setText(fechaN2);
            alumnos_fecha.setText(fecha2);
            alumnos_txtciudad.setText(ciudad2);
            alumnos_cbcarrera.setSelectedItem(carrera2);
            alumnos_cbsemestre.setSelectedItem(semestre2);
            alumnos_cbgrupo.setSelectedItem(grupo2);
            alumnos_cbperiodo.setSelectedItem(periodo2);
            alumnos_txtbuscar.setText(null);
        }
        }
        }     
    }//GEN-LAST:event_alumnos_btnbuscarActionPerformed

    private void carreras_btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carreras_btneliminarActionPerformed
        String texto=carrera.Read();
        if(texto==""){
        }else{
            String id2=carreras_txtbuscar.getText();
            if(id2.equals("")){
                JOptionPane.showMessageDialog(this, "No ah ingresado la ID");
            }else{
                if(!esNumero(id2)){
                    JOptionPane.showMessageDialog(this, "ID incorrecta");
                }else{
                    String texto2=carrera.Buscar2(texto, id2);
                    if(texto2=="no encontrado"){
                        JOptionPane.showMessageDialog(this, "No se encontro la ID");
                    }else{
                        String linea="";
                        String lineas="";
                        for(int i=0;i<texto.length();i++){
                            linea=linea+texto.charAt(i);
                            if(texto.charAt(i)=='#'){
                                if(linea.compareTo(texto2)==0){
                                    linea="";
                                }else{
                                    lineas=lineas+linea;
                                    linea="";
                                }
                            }
                        }
                        carrera.Write2(lineas);
                        JOptionPane.showMessageDialog(this,"Eliminado");
                    }
                }
            }
        }
        carreras_txtid.setText(null);
             carreras_txtnombrecarrera.setText(null);
            carreras_cbarea.setSelectedIndex(0);
            carreras_cbsemestre.setSelectedIndex(0);
            carrera_fecha.setText(null);
            carreras_jdcfecha.setDate(null);
            carreras_txtbuscar.setText(null);
    }//GEN-LAST:event_carreras_btneliminarActionPerformed

    private void carreras_btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carreras_btneditarActionPerformed
        Boolean q=false;
        Boolean yes=false;
        String completo="";
        String auxtext="";
        int aux=0;
        String id=carreras_txtbuscar.getText();
        if(id.equals("")){
            JOptionPane.showMessageDialog(this, "No ah ingresado la ID");
        }else{
            if(!esNumero(id)){
                JOptionPane.showMessageDialog(this, "ID incorrecta");
            }else{
                String nombrecarrera2="";
                String area2="";
                String id2="";
                String semestre2="";
                String fecha2="";
                String texto=carrera.Read();
                String linea=carrera.Buscar(texto, id);
                if(linea=="no encontrado"){
                    JOptionPane.showMessageDialog(this, "No se encontro el ID");
                }else{
                    for(int i=0;i<linea.length();i++){
                        if(linea.charAt(i)=='°'){
                            aux++;
                        }
                        if(linea.charAt(i)!='°'){
                            if(aux==0){
                                id2=id2+linea.charAt(i);
                            }
                            if(aux==1){
                                nombrecarrera2=nombrecarrera2+linea.charAt(i);
                            }
                            if(aux==2){
                                area2=area2+linea.charAt(i);
                            }
                            if(aux==3){
                                semestre2=semestre2+linea.charAt(i);
                            }
                            if(aux==4){
                                fecha2=fecha2+linea.charAt(i);
                            }
                        }
                    }
                    Boolean hola=false;
                    SimpleDateFormat dFormat=new SimpleDateFormat("dd-MM-yyyy");
                    if(!(carreras_jdcfecha.getDate()==null) && hola==false){
                        fecha2=dFormat.format(carreras_jdcfecha.getDate());
                        yes=true;
                    }
                    if(!(carreras_txtnombrecarrera.getText().equals("")) && hola==false){
                        nombrecarrera2=carreras_txtnombrecarrera.getText();
                        yes=true;
                        if(!esLetra(carreras_txtnombrecarrera.getText())){
                            hola=true;
                        }
                    }
                    if(!(carreras_cbarea.getSelectedItem().equals("")) && hola==false){
                        area2=(String)carreras_cbarea.getSelectedItem();
                        yes=true;
                    }
                    if(!(carreras_cbsemestre.getSelectedItem().equals("")) && hola==false){
                        semestre2=(String)carreras_cbsemestre.getSelectedItem();
                        yes=true;
                    }
                    if(hola==true){
                        yes=false;
                         JOptionPane.showMessageDialog(this, "Caracter invalido");
                    }
                    if(yes==true){
                    completo=id2+"°"+nombrecarrera2+"°"+area2+"°"+semestre2+"°"+fecha2+"#"+"\n";
                    carrera.Write(completo);

                    String renglon="";
                    String lineas="";
                    linea=linea+"#";
                    texto=carrera.Read();
                    for(int i=0;i<texto.length();i++){
                        renglon=renglon+texto.charAt(i);
                        if(texto.charAt(i)=='#'){
                            if(renglon.equals(linea)){
                                renglon="";
                            }else{
                                lineas=lineas+renglon;
                                renglon="";
                            }
                        }
                    }
                    carrera.Write2(lineas);
                    JOptionPane.showMessageDialog(this, "Editado correctamente");
                }
                }
            }
        }
        carreras_txtid.setText(null);
             carreras_txtnombrecarrera.setText(null);
            carreras_cbarea.setSelectedIndex(0);
            carreras_cbsemestre.setSelectedIndex(0);
            carrera_fecha.setText(null);
            carreras_jdcfecha.setDate(null);
            carreras_txtbuscar.setText(null);
    }//GEN-LAST:event_carreras_btneditarActionPerformed

    private void carreras_txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carreras_txtbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carreras_txtbuscarActionPerformed

    private void carreras_txtnombrecarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carreras_txtnombrecarreraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carreras_txtnombrecarreraActionPerformed

    private void carreras_btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carreras_btnnuevoActionPerformed
        sobrecarga();
         carreras_btnnuevo.setEnabled(false);
        carreras_btnbuscar.setEnabled(false);
       carreras_btneditar.setEnabled(false);
       carreras_btneliminar.setEnabled(false);
       carreras_btnguardar.setEnabled(true);
       carrera_fecha.setText("");
        int cont5=0;
        String[] ids=new String[100];
        String texto=carrera.Read();
        String aux="";
        int aux2=0;
        carreras_txtid.setText(null);
             carreras_txtnombrecarrera.setText(null);
            carreras_cbarea.setSelectedIndex(0);
            carreras_cbsemestre.setSelectedIndex(0);
            carrera_fecha.setText(null);
            carreras_jdcfecha.setDate(null);
            carreras_txtbuscar.setText(null);
        for(int i=0;i<texto.length();i++){
            if(texto.charAt(i)=='#'){
                ids[cont5]=aux;
                cont5++;
                aux="";
                aux2=0;
            }
            if(texto.charAt(i)=='°'){
                aux2=1;
            }
            if(isDigit(texto.charAt(i)) && aux2==0){
                aux=aux+texto.charAt(i);
            }

        }
        String a=""+cont5;
        carreras_txtid.setText(a);
    }//GEN-LAST:event_carreras_btnnuevoActionPerformed

    private void carreras_txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carreras_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carreras_txtidActionPerformed

    private void carreras_btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carreras_btnguardarActionPerformed
        Boolean b=false;
        String txt;
        int cont5=0;
        String[] ids=new String[100];
        String texto=carrera.Read();
        String aux="";
        int aux2=0;
        for(int i=0;i<texto.length();i++){
            if(texto.charAt(i)=='#'){
                ids[cont5]=aux;
                cont5++;
                aux="";
                aux2=0;
            }
            if(texto.charAt(i)=='°'){
                aux2=1;
            }
            if(isDigit(texto.charAt(i)) && aux2==0){
                aux=aux+texto.charAt(i);
            }

        }
        String a=""+cont5;
        carreras_txtid.setText(a);

        for(int i=0;i<cont5;i++){
            if(carreras_txtid.getText().equals(ids[i])){
                b=true;
            }
        }
        if(b==true){
            JOptionPane.showMessageDialog(this, "La ID ya existe");
        }else{
            if(esLetra(carreras_txtnombrecarrera.getText())){
            SimpleDateFormat dFormat=new SimpleDateFormat("dd-MM-yyyy");
            String fecha="";
            if(!(carreras_jdcfecha.getDate()==null)){
                fecha=dFormat.format(carreras_jdcfecha.getDate());
            }
            txt=cont5+"°"+carreras_txtnombrecarrera.getText()+"°"+carreras_cbarea.getSelectedItem()+"°"+carreras_cbsemestre.getSelectedItem()+"°"+fecha+"#"+"\n";
            carrera.Write(txt);
            JOptionPane.showMessageDialog(this, "Carrera Guardada");
            }else{
            JOptionPane.showMessageDialog(this, "Caracteres invalidos");    
            }
        }
       carreras_btnnuevo.setEnabled(true);
               carreras_btnbuscar.setEnabled(true);
               carreras_btneditar.setEnabled(true);
              carreras_btneliminar.setEnabled(true);
             carreras_btnguardar.setEnabled(false);
             
           carreras_txtid.setText(null);
             carreras_txtnombrecarrera.setText(null);
            carreras_cbarea.setSelectedIndex(0);
            carreras_cbsemestre.setSelectedIndex(0);
            carrera_fecha.setText(null);
            carreras_jdcfecha.setDate(null);
            carreras_txtbuscar.setText(null);
    }//GEN-LAST:event_carreras_btnguardarActionPerformed

    private void horarios_cbidgrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horarios_cbidgrupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_horarios_cbidgrupoActionPerformed

    private void horarios_btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horarios_btnnuevoActionPerformed
sobrecarga();
        horarios_btnguardar.setEnabled(true);
        horarios_btngenerarhorario.setEnabled(false);
        horarios_btnnuevo.setEnabled(false);
        
         sobrecarga();
       
        horarios_txtid.setText("");
        horarios_txtbuscar.setText("");
        horarios_cbidgrupo.setSelectedIndex(0);
        horarios_cbmaterias.setSelectedIndex(0);
        horarios_cbdia.setSelectedIndex(0);
        horarios_cbhorario.setSelectedIndex(0);
        sobrecarga();

        int cont5=0;
        String[] ids=new String[100];
        String texto=horario.Read();
        String aux="";
        int aux2=0;
        for(int i=0;i<texto.length();i++){
            if(texto.charAt(i)=='#'){
                ids[cont5]=aux;
                cont5++;
                aux="";
                aux2=0;
            }
            if(texto.charAt(i)=='°'){
                aux2=1;
            }
            if(isDigit(texto.charAt(i)) && aux2==0){
                aux=aux+texto.charAt(i);
            }

        }
        String a=""+cont5;
        horarios_txtid.setText(a);
    }//GEN-LAST:event_horarios_btnnuevoActionPerformed

    private void maestros_txttelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maestros_txttelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maestros_txttelefonoActionPerformed

    private void maestros_btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maestros_btneliminarActionPerformed
        String texto=maestros.Read();
        if(texto==""){
            JOptionPane.showMessageDialog(this, "No existen registros");
        }else{
            String id2=maestros_txtbuscar.getText();
            if(id2.equals("")){
                JOptionPane.showMessageDialog(this, "No ah ingresado una ID");
            }else{
                if(!esNumero(id2)){
                    JOptionPane.showMessageDialog(this, "ID incorrecta");
                }else{
                    String texto2=maestros.Buscar2(texto, id2);
                    if(texto2=="no encontrado"){
                        JOptionPane.showMessageDialog(this, "No se encontro la ID");
                    }else{
                        String linea="";
                        String lineas="";
                        for(int i=0;i<texto.length();i++){
                            linea=linea+texto.charAt(i);
                            if(texto.charAt(i)=='#'){
                                if(linea.compareTo(texto2)==0){
                                    linea="";
                                }else{
                                    lineas=lineas+linea;
                                    linea="";
                                }
                            }
                        }
                        maestros.Write2(lineas);                                                
                        JOptionPane.showMessageDialog(this,"Eliminado");
                        
                    }
                }
            }
        }
         maestros_txtid.setText(null);
            maestros_txtnombremaestro.setText(null);
            maestros_cbgradoacademico.setSelectedIndex(0);
            maestros_cbgrupoacademico.setSelectedIndex(0);
            maestros_txtdireccion.setText(null);
            maestros_txttelefono.setText(null);
            maestros_cbmateria.setSelectedItem(null);
            maestros_txtbuscar.setText(null);
            tablaMaestro();
    }//GEN-LAST:event_maestros_btneliminarActionPerformed

    private void maestros_btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maestros_btnguardarActionPerformed
        String[] ids=new String[100];
        Boolean b=false;
        String txt;
        int contMaterias=0;
        String texto=maestros.Read();
        String aux="";
        int aux2=0;
        for(int i=0;i<texto.length();i++){
            if(texto.charAt(i)=='#'){
                ids[contMaterias]=aux;
                contMaterias++;
                aux="";
                aux2=0;
            }
            if(texto.charAt(i)=='°'){
                aux2=1;
            }
            if(isDigit(texto.charAt(i)) && aux2==0){
                aux=aux+texto.charAt(i);
            }

        }

        for(int i=0;i<contMaterias;i++){
            if(maestros_txtid.getText().equals(ids[i])){
                b=true;
            }
        }
        if(b==true){
            JOptionPane.showMessageDialog(this, "La ID ya existe");
        }else{
            Boolean hola=false;
            if(esLetra(maestros_txtnombremaestro.getText())){
                if(esNumero(maestros_txttelefono.getText())){
                hola=true;
            }
            }
            if(hola==true){
            txt=maestros_txtid.getText()+"°"+maestros_txtnombremaestro.getText()+"°"+maestros_cbgradoacademico.getSelectedItem()+"°"+maestros_cbgrupoacademico.getSelectedItem()+"°"+maestros_txtdireccion.getText()+"°"+maestros_txttelefono.getText()+"°"+maestros_cbmateria.getSelectedItem()+"#"+"\n";
            maestros.Write(txt);
            JOptionPane.showMessageDialog(this, "Usuario Guardado");
            }else{
             JOptionPane.showMessageDialog(this, "Caracteres invalidos");   
            }
        }
                maestros_btnnuevo.setEnabled(true);
               maestros_btnbuscar.setEnabled(true);
               maestros_btneditar.setEnabled(true);
              maestros_btneliminar.setEnabled(true);
              maestros_btnguardar.setEnabled(false);
        
            maestros_txtid.setText(null);
            maestros_txtnombremaestro.setText(null);
            maestros_cbgradoacademico.setSelectedIndex(0);
            maestros_cbgrupoacademico.setSelectedIndex(0);
            maestros_txtdireccion.setText(null);
            maestros_txttelefono.setText(null);
            maestros_cbmateria.setSelectedItem(null);
            maestros_txtbuscar.setText(null);
            tablaMaestro();
    }//GEN-LAST:event_maestros_btnguardarActionPerformed

    private void maestros_btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maestros_btneditarActionPerformed
        Boolean yes=false;
        String completo="";
        String auxtext="";
        int aux=0;
        String id=maestros_txtbuscar.getText();
        if(id.equals("")){
            JOptionPane.showMessageDialog(this, "No se encontro el ID");
        }else{
            if(!esNumero(id)){
                JOptionPane.showMessageDialog(this, "ID incorrecta");
            }else{
                String nombreM2="";
                String id2="";
                String gradoA2="";
                String grupoA2="";
                String direccion2="";
                String telefono2="";
                String materia2="";
                String texto=maestros.Read();
                String linea=maestros.Buscar(texto, id);
                if(linea=="no encontrado"){
                    JOptionPane.showMessageDialog(this, "No se encontro el ID");
                }else{
                    for(int i=0;i<linea.length();i++){
                        if(linea.charAt(i)=='°'){
                            aux++;
                        }
                        if(linea.charAt(i)!='°'){
                            if(aux==0){
                                id2=id2+linea.charAt(i);
                            }
                            if(aux==1){
                                nombreM2=nombreM2+linea.charAt(i);
                            }
                            if(aux==2){
                                gradoA2+=linea.charAt(i);
                            }
                            if(aux==3){
                                grupoA2+=linea.charAt(i);
                            }
                            if(aux==4){
                                direccion2+=linea.charAt(i);
                            }
                            if(aux==5){
                                telefono2+=linea.charAt(i);
                            }
                            if(aux==6){
                                materia2+=linea.charAt(i);
                            }
                        }
                    }
                    Boolean hola=false;
                    if(!(maestros_txtnombremaestro.getText().equals("")) && hola==false){
                        nombreM2=maestros_txtnombremaestro.getText();
                        yes=true;
                        if(!esLetra(maestros_txtnombremaestro.getText())){
                            hola=true;
                        }
                    }
                    if(!(maestros_txtdireccion.getText().equals("")) && hola==false){
                        direccion2=maestros_txtdireccion.getText();
                        yes=true;
                    }
                    if(!(maestros_txttelefono.getText().equals("")) && hola==false){
                        telefono2=maestros_txttelefono.getText();
                        yes=true;
                        if(!esNumero(maestros_txttelefono.getText())){
                            hola=true;
                        }
                    }
                    if(!(maestros_cbgradoacademico.getSelectedItem().equals("")) && hola==false){
                        gradoA2=(String)maestros_cbgradoacademico.getSelectedItem();
                        yes=true;
                    }
                    if(!(maestros_cbgrupoacademico.getSelectedItem().equals("")) && hola==false){
                        grupoA2=(String)maestros_cbgrupoacademico.getSelectedItem();
                        yes=true;
                    }
                    if(!(maestros_cbmateria.getSelectedItem().equals("")) && hola==false){
                        materia2=(String)maestros_cbmateria.getSelectedItem();
                        yes=true;
                    }
                    if(hola==true){
                        yes=false;
                        JOptionPane.showMessageDialog(this, "Caracteres invalidos");
                    }
                    if(yes==true){
                    completo=id2+"°"+nombreM2+"°"+gradoA2+"°"+grupoA2+"°"+direccion2+"°"+telefono2+"°"+materia2+"#"+"\n";
                    maestros.Write(completo);

                    String renglon="";
                    String lineas="";
                    linea=linea+"#";
                    texto=maestros.Read();
                    for(int i=0;i<texto.length();i++){
                        renglon=renglon+texto.charAt(i);
                        if(texto.charAt(i)=='#'){
                            if(renglon.equals(linea)){
                                renglon="";
                            }else{
                                lineas=lineas+renglon;
                                renglon="";
                            }
                        }
                    }
                    maestros.Write2(lineas);
                    JOptionPane.showMessageDialog(this, "Editado correctamente");
                }
                }
            }
        }
         maestros_txtid.setText(null);
            maestros_txtnombremaestro.setText(null);
            maestros_cbgradoacademico.setSelectedIndex(0);
            maestros_cbgrupoacademico.setSelectedIndex(0);
            maestros_txtdireccion.setText(null);
            maestros_txttelefono.setText(null);
            maestros_cbmateria.setSelectedItem(null);
            maestros_txtbuscar.setText(null);
            tablaMaestro();
    }//GEN-LAST:event_maestros_btneditarActionPerformed

    private void maestros_txtnombremaestroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maestros_txtnombremaestroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maestros_txtnombremaestroActionPerformed

    private void maestros_btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maestros_btnnuevoActionPerformed
        sobrecarga();
         maestros_btnnuevo.setEnabled(false);
        maestros_btnbuscar.setEnabled(false);
        maestros_btneditar.setEnabled(false);
        maestros_btneliminar.setEnabled(false);
        maestros_btnguardar.setEnabled(true);
   
            maestros_txtid.setText(null);
            maestros_txtnombremaestro.setText(null);
            maestros_cbgradoacademico.setSelectedIndex(0);
            maestros_cbgrupoacademico.setSelectedIndex(0);
            maestros_txtdireccion.setText(null);
            maestros_txttelefono.setText(null);
            maestros_cbmateria.setSelectedItem(null);
            maestros_txtbuscar.setText(null);
        int cont5=0;
        String[] ids=new String[100];
        String texto=maestros.Read();
        String aux="";
        int aux2=0;
        for(int i=0;i<texto.length();i++){
            if(texto.charAt(i)=='#'){
                ids[cont5]=aux;
                cont5++;
                aux="";
                aux2=0;
            }
            if(texto.charAt(i)=='°'){
                aux2=1;
            }
            if(isDigit(texto.charAt(i)) && aux2==0){
                aux=aux+texto.charAt(i);
            }

        }
        String a=""+cont5;
        maestros_txtid.setText(a);
    }//GEN-LAST:event_maestros_btnnuevoActionPerformed

    private void maestros_cbgradoacademicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maestros_cbgradoacademicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maestros_cbgradoacademicoActionPerformed

    private void maestros_cbmateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maestros_cbmateriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maestros_cbmateriaActionPerformed

    private void semestre_cbperiodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semestre_cbperiodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_semestre_cbperiodoActionPerformed

    private void semestre_btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semestre_btneliminarActionPerformed
        String texto=semestre.Read();
        if(texto==""){
            JOptionPane.showMessageDialog(this, "No existen registros");
        }else{
            String id2=semestre_txtbuscar.getText();
            if(id2.equals("")){
                JOptionPane.showMessageDialog(this, "No ingresaste la ID");
            }else{
                if(!esNumero(id2)){
                    JOptionPane.showMessageDialog(this, "ID incorrecta");
                }else{
                    String texto2=semestre.Buscar2(texto, id2);
                    if(texto2=="no encontrado"){
                        JOptionPane.showMessageDialog(this, "No se encontro la ID");
                    }else{
                        String linea="";
                        String lineas="";
                        for(int i=0;i<texto.length();i++){
                            linea=linea+texto.charAt(i);
                            if(texto.charAt(i)=='#'){
                                if(linea.compareTo(texto2)==0){
                                    linea="";
                                }else{
                                    lineas=lineas+linea;
                                    linea="";
                                }
                            }
                        }
                        semestre.Write2(lineas);
                        JOptionPane.showMessageDialog(this,"Eliminado");
                    }
                }
            }
        }
        semestre_txtid.setText(null);
            semestre_cbperiodo.setSelectedIndex(0);
            semestre_fechai.setText(null);
            semestre_fechaf.setText(null);
            semestre_jdcfechainicio.setDate(null);
            semestre_jdcfechafinal.setDate(null);
            semestre_txtbuscar.setText(null);
    }//GEN-LAST:event_semestre_btneliminarActionPerformed

    private void semestre_btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semestre_btneditarActionPerformed
        String completo="";
        String auxtext="";
        Boolean yes=false;
        int aux=0;

        String id=semestre_txtbuscar.getText();
        if(id.equals("")){
            JOptionPane.showMessageDialog(this, "No ah ingresado la ID");
        }else{
            if(!esNumero(id)){
                JOptionPane.showMessageDialog(this, "ID incorrecta");
            }else{
                String periodo2="";
                String id2="";
                String fechainicio="";
                String fechafinal2="";
                String texto=semestre.Read();
                String linea=semestre.Buscar(texto, id);
                if(linea=="no encontrado"){
                    JOptionPane.showMessageDialog(this, "No se encontro el ID");
                }else{
                    for(int i=0;i<linea.length();i++){
                        if(linea.charAt(i)=='°'){
                            aux++;
                        }
                        if(linea.charAt(i)!='°'){
                            if(aux==0){
                                id2=id2+linea.charAt(i);
                            }
                            if(aux==1){
                                periodo2=periodo2+linea.charAt(i);
                            }
                            if(aux==2){
                                fechainicio+=linea.charAt(i);
                            }
                            if(aux==3){
                                fechafinal2+=linea.charAt(i);
                            }

                        }
                    }

                    SimpleDateFormat dFormat=new SimpleDateFormat("dd-MM-yyyy");
                    if(!(semestre_jdcfechainicio.getDate()==null)){
                        fechainicio=dFormat.format(semestre_jdcfechainicio.getDate());
                        yes=true;
                    }
                    if(!(semestre_jdcfechafinal.getDate()==null)){
                        fechafinal2=dFormat.format(semestre_jdcfechafinal.getDate());
                        yes=true;
                    }
                    if(!(semestre_cbperiodo.getSelectedItem().equals(""))){
                        periodo2=(String)semestre_cbperiodo.getSelectedItem();
                        yes=true;
                    }
                    if(yes==true){
                    completo=id2+"°"+periodo2+"°"+fechainicio+"°"+fechafinal2+"#"+"\n";
                    semestre.Write(completo);

                    String renglon="";
                    String lineas="";
                    linea=linea+"#";
                    texto=semestre.Read();
                    for(int i=0;i<texto.length();i++){
                        renglon=renglon+texto.charAt(i);
                        if(texto.charAt(i)=='#'){
                            if(renglon.equals(linea)){
                                renglon="";
                            }else{
                                lineas=lineas+renglon;
                                renglon="";
                            }
                        }
                    }
                    semestre.Write2(lineas);
                    JOptionPane.showMessageDialog(this, "Editado correctamente");
                    }
                }
            }
        }
        semestre_txtid.setText(null);
            semestre_cbperiodo.setSelectedIndex(0);
            semestre_fechai.setText(null);
            semestre_fechaf.setText(null);
            semestre_jdcfechainicio.setDate(null);
            semestre_jdcfechafinal.setDate(null);
            semestre_txtbuscar.setText(null);
    }//GEN-LAST:event_semestre_btneditarActionPerformed

    private void semestre_btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semestre_btnnuevoActionPerformed
        sobrecarga();
        int cont5=0;
        String[] ids=new String[100];
        String texto=semestre.Read();
        String aux="";
        int aux2=0;
        for(int i=0;i<texto.length();i++){
            if(texto.charAt(i)=='#'){
                ids[cont5]=aux;
                cont5++;
                aux="";
                aux2=0;
            }
            if(texto.charAt(i)=='°'){
                aux2=1;
            }
            if(isDigit(texto.charAt(i)) && aux2==0){
                aux=aux+texto.charAt(i);
            }

        }
        String a=""+cont5;
        semestre_txtid.setText(null);
        semestre_txtid.setText(a);
            semestre_cbperiodo.setSelectedIndex(0);
            semestre_fechai.setText(null);
            semestre_fechaf.setText(null);
            semestre_jdcfechainicio.setDate(null);
            semestre_jdcfechafinal.setDate(null);
            semestre_txtbuscar.setText(null);
        semestre_btnnuevo.setEnabled(false);
        semestre_btnguardar.setEnabled(true);
        semestre_btnbuscar.setEnabled(false);
        semestre_btneliminar.setEnabled(false);
        semestre_btneditar.setEnabled(false);
    }//GEN-LAST:event_semestre_btnnuevoActionPerformed

    private void semestre_btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semestre_btnguardarActionPerformed
        String[] ids=new String[100];
        Boolean b=false;
        String txt="";
        int contMaterias=0;
        String texto=semestre.Read();
        String aux="";
        int aux2=0;
        for(int i=0;i<texto.length();i++){
            if(texto.charAt(i)=='#'){
                ids[contMaterias]=aux;
                contMaterias++;
                aux="";
                aux2=0;
            }
            if(texto.charAt(i)=='°'){
                aux2=1;
            }
            if(isDigit(texto.charAt(i)) && aux2==0){
                aux=aux+texto.charAt(i);
            }

        }

        for(int i=0;i<contMaterias;i++){
            if(semestre_txtid.getText().equals(ids[i])){
                b=true;
            }
        }
        if(b==true){
            JOptionPane.showMessageDialog(this, "La ID ya existe");
        }else{
          SimpleDateFormat dFormat=new SimpleDateFormat("dd-MM-yyyy");
            String fechainicio="",fechafinal="";
            if(!(semestre_jdcfechainicio.getDate()==null)){
                fechainicio=dFormat.format(semestre_jdcfechainicio.getDate());
            }
            if(!(semestre_jdcfechafinal.getDate()==null)){
                fechafinal=dFormat.format(semestre_jdcfechafinal.getDate());
            }
            txt=semestre_txtid.getText()+"°"+semestre_cbperiodo.getSelectedItem()+"°"+fechainicio+"°"+fechafinal+"#"+"\n";
            semestre.Write(txt);
            JOptionPane.showMessageDialog(this, "Usuario Guardado");
        }
        semestre_txtid.setText(null);
            semestre_cbperiodo.setSelectedIndex(0);
            semestre_fechai.setText(null);
            semestre_fechaf.setText(null);
            semestre_jdcfechainicio.setDate(null);
            semestre_jdcfechafinal.setDate(null);
            semestre_txtbuscar.setText(null);
        semestre_btnnuevo.setEnabled(true);
        semestre_btnguardar.setEnabled(false);
        semestre_btnbuscar.setEnabled(true);
        semestre_btneliminar.setEnabled(true);
        semestre_btneditar.setEnabled(true);
    }//GEN-LAST:event_semestre_btnguardarActionPerformed

    private void materias_btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materias_btnbuscarActionPerformed
sobrecarga();
        String id1=materias_txtbuscar.getText();
            materias_txtid.setText(null);
            materias_txtnombremateria.setText(null);
            materias_txtcreditos.setText(null);
            materias_cbidcarrera.setSelectedIndex(0);
            materias_cbacademia.setSelectedIndex(0);
            materias_txtbuscar.setText(null);
int aux=0;
        if(id1.equals("")){
            JOptionPane.showMessageDialog(this, "No ah ingresado la ID");
        }else{
            if(!esNumero(id1)){
               JOptionPane.showMessageDialog(this, "ID invalida"); 
               materias_txtid.setText(null);
            materias_txtnombremateria.setText(null);
            materias_txtcreditos.setText(null);
            materias_cbidcarrera.setSelectedIndex(0);
            materias_cbacademia.setSelectedIndex(0);
            materias_txtbuscar.setText(null);
            }else{
        String texto=materias.Read();
        String texto2=materias.Buscar(texto, id1);
        if(texto2=="no encontrado"){
            JOptionPane.showMessageDialog(this, "No se encontro la id");
            materias_txtid.setText(null);
            materias_txtnombremateria.setText(null);
            materias_txtcreditos.setText(null);
            materias_cbidcarrera.setSelectedIndex(0);
            materias_cbacademia.setSelectedIndex(0);
            materias_txtbuscar.setText(null);
        }else{
            String id2="";
            String nombreM2="";
            String creditos2="";
            String idcarrera2="";
            String academia2="";
            for(int i=0;i<texto2.length();i++){
                if(texto2.charAt(i)=='°'){
                    aux++;
                }
                if(texto2.charAt(i)!='°'){
                  if(aux==0){
                        id2=id2+texto2.charAt(i);
                    }  
                  if(aux==1){
                        nombreM2+=texto2.charAt(i);
                    }
                  if(aux==2){
                        creditos2+=texto2.charAt(i);
                    }
                  if(aux==3){
                        idcarrera2+=texto2.charAt(i);
                    }  
                  if(aux==4){
                        academia2+=texto2.charAt(i);
                    }  
                }
                }
            materias_txtid.setText(id2);
            materias_txtnombremateria.setText(nombreM2);
            materias_txtcreditos.setText(creditos2);
            materias_cbidcarrera.setSelectedItem(idcarrera2);
            materias_cbacademia.setSelectedItem(academia2);
            materias_txtbuscar.setText(null);
        }
        }
        }        
    }//GEN-LAST:event_materias_btnbuscarActionPerformed

    private void materias_btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materias_btnguardarActionPerformed
        String[] ids=new String[100];
        Boolean b=false;
        String txt;
        int contMaterias=0;
        String texto=materias.Read();
        String aux="";
        int aux2=0;
        for(int i=0;i<texto.length();i++){
            if(texto.charAt(i)=='#'){
                ids[contMaterias]=aux;
                contMaterias++;
                aux="";
                aux2=0;
            }
            if(texto.charAt(i)=='°'){
                aux2=1;
            }
            if(isDigit(texto.charAt(i)) && aux2==0){
                aux=aux+texto.charAt(i);
            }

        }

        for(int i=0;i<contMaterias;i++){
            if(materias_txtid.getText().equals(ids[i])){
                b=true;
            }
        }
        if(b==true){
            JOptionPane.showMessageDialog(this, "La ID ya existe");
        }else{
            Boolean hola=false;
            if(esLetra(materias_txtnombremateria.getText())){
                if(esNumero(materias_txtcreditos.getText())){
                    hola=true;
            }
            }
            if(hola==true){
            txt=materias_txtid.getText()+"°"+materias_txtnombremateria.getText()+"°"+materias_txtcreditos.getText()+"°"+materias_cbidcarrera.getSelectedItem()+"°"+materias_cbacademia.getSelectedItem()+"#"+"\n";
            materias.Write(txt);
            JOptionPane.showMessageDialog(this, "Usuario Guardado");
            }else{
                JOptionPane.showMessageDialog(this, "Caracteres invalidos");
            }
        }
            materias_txtid.setText(null);
            materias_txtnombremateria.setText(null);
            materias_txtcreditos.setText(null);
            materias_cbidcarrera.setSelectedIndex(0);
            materias_cbacademia.setSelectedIndex(0);
            materias_txtbuscar.setText(null);
            
            materias_txtid.setEnabled(true);
            materias_btnnuevo.setEnabled(true);
            materias_btneliminar.setEnabled(true);
            materias_btneditar.setEnabled(true);
            materias_btnbuscar.setEnabled(true);
            materias_btnguardar.setEnabled(false);
    }//GEN-LAST:event_materias_btnguardarActionPerformed

    private void materias_cbidcarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materias_cbidcarreraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_materias_cbidcarreraActionPerformed

    private void materias_btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materias_btneliminarActionPerformed
        String texto=materias.Read();
        if(texto==""){
            JOptionPane.showMessageDialog(this, "No existen registros");
        }else{
            String id2=materias_txtbuscar.getText();
            if(id2.equals("")){
                JOptionPane.showMessageDialog(this, "No ah ingresado una ID");
            }else{
                if(!esNumero(id2)){
                    JOptionPane.showMessageDialog(this, "ID incorrecta");
                }else{
                    String texto2=materias.Buscar2(texto, id2);
                    if(texto2=="no encontrado"){
                        JOptionPane.showMessageDialog(this, "No se encontro la ID");
                    }else{
                        String linea="";
                        String lineas="";
                        for(int i=0;i<texto.length();i++){
                            linea=linea+texto.charAt(i);
                            if(texto.charAt(i)=='#'){
                                if(linea.compareTo(texto2)==0){
                                    linea="";
                                }else{
                                    lineas=lineas+linea;
                                    linea="";
                                }
                            }
                        }
                        materias.Write2(lineas);
                        JOptionPane.showMessageDialog(this,"Eliminado");
                    }
                }
            }
        }
            materias_txtid.setText(null);
            materias_txtnombremateria.setText(null);
            materias_txtcreditos.setText(null);
            materias_cbidcarrera.setSelectedIndex(0);
            materias_cbacademia.setSelectedIndex(0);
            materias_txtbuscar.setText(null);
    }//GEN-LAST:event_materias_btneliminarActionPerformed

    private void materias_btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materias_btneditarActionPerformed
        String completo="";
        String auxtext="";
        Boolean yes=false;
        int aux=0;

        String id=materias_txtbuscar.getText();
        if(id.equals("")){
            JOptionPane.showMessageDialog(this, "No se ah ingresado ID");
        }else{
            if(!esNumero(id)){
                JOptionPane.showMessageDialog(this, "ID incorrecta");
            }else{
                String nombreM2="";
                String id2="";
                String creditos="";
                String idC2="";
                String academia2="";
                String texto=materias.Read();
                String linea=materias.Buscar(texto, id);
                if(linea=="no encontrado"){
                    JOptionPane.showMessageDialog(this, "No se encontro el ID");
                }else{
                    for(int i=0;i<linea.length();i++){
                        if(linea.charAt(i)=='°'){
                            aux++;
                        }
                        if(linea.charAt(i)!='°'){
                            if(aux==0){
                                id2=id2+linea.charAt(i);
                            }
                            if(aux==1){
                                nombreM2=nombreM2+linea.charAt(i);
                            }
                            if(aux==2){
                                creditos+=linea.charAt(i);
                            }
                            if(aux==3){
                                idC2+=linea.charAt(i);
                            }
                            if(aux==4){
                                academia2+=linea.charAt(i);
                            }
                        }
                    }
                    Boolean hola=false;
                    if(!(materias_txtnombremateria.getText().equals("")) && hola==false){
                        nombreM2=materias_txtnombremateria.getText();
                        yes=true;
                        if(!esLetra(materias_txtnombremateria.getText())){
                            hola=true;
                        }
                    }
                    if(!(materias_txtcreditos.getText().equals("")) && hola==false){
                        creditos=materias_txtcreditos.getText();
                        yes=true;
                        if(!esNumero(materias_txtnombremateria.getText())){
                            hola=true;
                        }
                    }
                    if(!materias_cbidcarrera.getSelectedItem().equals("") && hola==false){
                        idC2=(String)materias_cbidcarrera.getSelectedItem();
                        yes=true;
                    }
                    if(!(materias_cbacademia.getSelectedItem().equals("")) && hola==false){
                        academia2=(String)materias_cbacademia.getSelectedItem();
                        yes=true;
                    }
                    if(hola==true){
                        yes=false;
                        JOptionPane.showMessageDialog(this, "Caracteres invalidos");
                    }
                    if(yes==true){
                    completo=id2+"°"+nombreM2+"°"+creditos+"°"+idC2+"°"+academia2+"#"+"\n";
                    materias.Write(completo);

                    String renglon="";
                    String lineas="";
                    linea=linea+"#";
                    texto=materias.Read();
                    for(int i=0;i<texto.length();i++){
                        renglon=renglon+texto.charAt(i);
                        if(texto.charAt(i)=='#'){
                            if(renglon.equals(linea)){
                                renglon="";
                            }else{
                                lineas=lineas+renglon;
                                renglon="";
                            }
                        }
                    }
                    materias.Write2(lineas);
                    JOptionPane.showMessageDialog(this, "Editado correctamente");
                    }
                }
            }
        }
            materias_txtid.setText(null);
            materias_txtnombremateria.setText(null);
            materias_txtcreditos.setText(null);
            materias_cbidcarrera.setSelectedIndex(0);
            materias_cbacademia.setSelectedIndex(0);
            materias_txtbuscar.setText(null);
    }//GEN-LAST:event_materias_btneditarActionPerformed

    private void materias_btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materias_btnnuevoActionPerformed
            sobrecarga();
            materias_txtid.setText(null);
            materias_txtnombremateria.setText(null);
            materias_txtcreditos.setText(null);
            materias_cbidcarrera.setSelectedIndex(0);
            materias_cbacademia.setSelectedIndex(0);
            materias_txtbuscar.setText(null);
            materias_txtid.setEnabled(false);
            materias_btnnuevo.setEnabled(false);
            materias_btneliminar.setEnabled(false);
            materias_btneditar.setEnabled(false);
            materias_btnbuscar.setEnabled(false);
            materias_btnguardar.setEnabled(true);
        int cont5=0;
        String[] ids=new String[100];
        String texto=materias.Read();
        String aux="";
        int aux2=0;
        for(int i=0;i<texto.length();i++){
            if(texto.charAt(i)=='#'){
                ids[cont5]=aux;
                cont5++;
                aux="";
                aux2=0;
            }
            if(texto.charAt(i)=='°'){
                aux2=1;
            }
            if(isDigit(texto.charAt(i)) && aux2==0){
                aux=aux+texto.charAt(i);
            }

        }
        String a=""+cont5;
        materias_txtid.setText(a);
    }//GEN-LAST:event_materias_btnnuevoActionPerformed

    private void materias_txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materias_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_materias_txtidActionPerformed

    private void usuarios_txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarios_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarios_txtidActionPerformed

    private void usuarios_cbperfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarios_cbperfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarios_cbperfilActionPerformed

    private void usuarios_btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarios_btneliminarActionPerformed
        String texto=usuarios.Read();
        if(texto==""){
            JOptionPane.showMessageDialog(this, "No existen registros");
        }else{
            String id2=usuarios_txtbuscar.getText();
            if(id2.equals("")){
                JOptionPane.showMessageDialog(this, "No ah ingresado la ID");
            }else{
                if(!esNumero(id2)){
                    JOptionPane.showMessageDialog(this, "ID incorrecta");
                }else{
                    String texto2=usuarios.Buscar2(texto, id2);
                    if(texto2=="no encontrado"){
                        JOptionPane.showMessageDialog(this, "No se encontro la ID");
                    }else{
                        String linea="";
                        String lineas="";
                        for(int i=0;i<texto.length();i++){
                            linea=linea+texto.charAt(i);
                            if(texto.charAt(i)=='#'){
                                if(linea.compareTo(texto2)==0){
                                    linea="";
                                }else{
                                    lineas=lineas+linea;
                                    linea="";
                                }
                            }
                        }
                        usuarios.Write2(lineas);
                        JOptionPane.showMessageDialog(this,"Eliminado");
                    }
                }
            }
        }
        usuarios_txtid.setText(null);
        usuarios_txtnombre.setText(null);
        usuarios_txtnombreusuario.setText(null);
        usuarios_txtapellidopaterno.setText(null);
        usuarios_txtapellidomaterno.setText(null);
        usuarios_txtcontraseña.setText(null);
        usuarios_txtconfirmarcontraseña.setText(null);
        usuarios_txtbuscar.setText(null);
        usuarios_cbperfil.setSelectedIndex(0);
    }//GEN-LAST:event_usuarios_btneliminarActionPerformed

    private void usuarios_btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarios_btneditarActionPerformed
        String completo="";
        String auxtext="";
        Boolean yes=false;
        int aux=0;

        String id=usuarios_txtbuscar.getText();
        if(id.equals("")){
            JOptionPane.showMessageDialog(this, "No ah ingresado la ID");
        }else{
            if(!esNumero(id)){
                JOptionPane.showMessageDialog(this, "ID incorrecta");
            }else{
                String periodo2="";
                String id2="";
                String nombre2="";
                String apellidopaterno2="";
                String apellidomaterno2="";
                String nombreusuario2="";
                String contraseña2="";
                String perfil2="";
                String texto=usuarios.Read();
                String linea=usuarios.Buscar(texto, id);
                if(linea=="no encontrado"){
                    JOptionPane.showMessageDialog(this, "No se encontro el ID");
                }else{
                    for(int i=0;i<linea.length();i++){
                        if(linea.charAt(i)=='°'){
                            aux++;
                        }
                        if(linea.charAt(i)!='°'){
                            if(aux==0){
                                id2=id2+linea.charAt(i);
                            }
                            if(aux==1){
                                nombre2=nombre2+linea.charAt(i);
                            }
                            if(aux==2){
                                apellidopaterno2+=linea.charAt(i);
                            }
                            if(aux==3){
                                apellidomaterno2+=linea.charAt(i);
                            }
                            if(aux==4){
                                nombreusuario2+=linea.charAt(i);
                            }
                            if(aux==5){
                                contraseña2+=linea.charAt(i);
                            }
                            if(aux==6){
                                perfil2+=linea.charAt(i);
                            }

                        }
                    }
                    Boolean hola=false;
                    if(!(usuarios_txtnombre.getText().equals("")) && hola==false){
                        nombre2=usuarios_txtnombre.getText();
                        yes=true;
                        if(!esLetra(usuarios_txtnombre.getText())){
                            hola=true;
                        }
                    }
                    if(!(usuarios_txtapellidopaterno.getText().equals("")) && hola==false){
                        apellidopaterno2=usuarios_txtapellidopaterno.getText();
                        yes=true;
                        if(!esLetra(usuarios_txtapellidopaterno.getText())){
                            hola=true;
                        }
                    }
                    if(!(usuarios_txtapellidomaterno.getText().equals("")) && hola==false){
                        apellidomaterno2=usuarios_txtapellidomaterno.getText();
                        yes=true;
                        if(!esLetra(usuarios_txtapellidomaterno.getText())){
                            hola=true;
                        }
                    }
                    if(!(usuarios_txtnombreusuario.getText().equals("")) && hola==false){
                        nombreusuario2=usuarios_txtnombreusuario.getText();
                        yes=true;
                        if(!esLetra(usuarios_txtnombreusuario.getText())){
                            hola=true;
                        }
                    }
                    if(!(usuarios_txtcontraseña.getText().equals("")) && hola==false){
                        contraseña2=usuarios_txtcontraseña.getText();
                        yes=true;
                    }
                    if(!(usuarios_cbperfil.getSelectedItem().equals("")) && hola==false){
                        perfil2=(String)usuarios_cbperfil.getSelectedItem();
                        yes=true;
                    }
                    if(hola==true){
                        yes=false;
                        JOptionPane.showMessageDialog(this, "Caracteres invalidos");
                    }
                    if(yes==true){
                    completo=id2+"°"+nombre2+"°"+apellidopaterno2+"°"+apellidomaterno2+"°"+nombreusuario2+"°"+contraseña2+"°"+perfil2+"#"+"\n";
                    usuarios.Write(completo);

                    String renglon="";
                    String lineas="";
                    linea=linea+"#";
                    texto=usuarios.Read();
                    for(int i=0;i<texto.length();i++){
                        renglon=renglon+texto.charAt(i);
                        if(renglon.equals(linea)){
                            renglon="";
                        }else{                
                            if(texto.charAt(i)=='#'){
                            lineas=lineas+renglon;
                            renglon="";
                        }
                    }
                }
                usuarios.Write2(lineas);
                JOptionPane.showMessageDialog(this, "Editado correctamente");
                    }
            }
        }
        }
        usuarios_txtid.setText(null);
        usuarios_txtnombre.setText(null);
        usuarios_txtnombreusuario.setText(null);
        usuarios_txtapellidopaterno.setText(null);
        usuarios_txtapellidomaterno.setText(null);
        usuarios_txtcontraseña.setText(null);
        usuarios_txtconfirmarcontraseña.setText(null);
        usuarios_txtbuscar.setText(null);
        usuarios_cbperfil.setSelectedIndex(0);
    }//GEN-LAST:event_usuarios_btneditarActionPerformed

    private void usuarios_btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarios_btnnuevoActionPerformed
        sobrecarga();
        usuarios_btnnuevo.setEnabled(false);
        usuarios_btnbuscar.setEnabled(false);
        usuarios_btneditar.setEnabled(false);
        usuarios_btneliminar.setEnabled(false);
        usuarios_btnguardar.setEnabled(true);
        usuarios_cbperfil.setEnabled(true);
        usuarios_txtnombre.setEnabled(true);
        usuarios_txtapellidopaterno.setEnabled(true);
        usuarios_txtapellidomaterno.setEnabled(true);
        usuarios_txtapellidomaterno.setEnabled(true);
        usuarios_txtnombreusuario.setEnabled(true);
        usuarios_txtapellidomaterno.setEnabled(true);
        usuarios_txtcontraseña.setEnabled(true);
        usuarios_txtconfirmarcontraseña.setEnabled(true);
        usuarios_txtbuscar.setEnabled(false);
        int cont5=0;
        String[] ids=new String[100];
        String texto=usuarios.Read();
        String aux="";
        int aux2=0;
        usuarios_txtid.setText(null);
        usuarios_txtnombre.setText(null);
        usuarios_txtnombreusuario.setText(null);
        usuarios_txtapellidopaterno.setText(null);
        usuarios_txtapellidomaterno.setText(null);
        usuarios_txtcontraseña.setText(null);
        usuarios_txtconfirmarcontraseña.setText(null);
        usuarios_txtbuscar.setText(null);
        usuarios_cbperfil.setSelectedIndex(0);
        for(int i=0;i<texto.length();i++){
            if(texto.charAt(i)=='#'){
                ids[cont5]=aux;
                cont5++;
                aux="";
                aux2=0;
            }
            if(texto.charAt(i)=='°'){
                aux2=1;
            }
            if(isDigit(texto.charAt(i)) && aux2==0){
                aux=aux+texto.charAt(i);
            }

        }
        String a=""+cont5;
        usuarios_txtid.setText(a);
    }//GEN-LAST:event_usuarios_btnnuevoActionPerformed

    private void usuarios_txtapellidomaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarios_txtapellidomaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarios_txtapellidomaternoActionPerformed

    private void usuarios_btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarios_btnguardarActionPerformed
        Boolean b=false;
        String txt;
        int cont5=0;
        String[] ids=new String[100];
        String texto=usuarios.Read();
        String aux="";
        int aux2=0;
        for(int i=0;i<texto.length();i++){
            if(texto.charAt(i)=='#'){
                ids[cont5]=aux;
                cont5++;
                aux="";
                aux2=0;
            }
            if(texto.charAt(i)=='°'){
                aux2=1;
            }
            if(isDigit(texto.charAt(i)) && aux2==0){
                aux=aux+texto.charAt(i);
            }

        }
        String a=""+cont5;
        usuarios_txtid.setText(a);

        for(int i=0;i<cont5;i++){
            if(usuarios_txtid.getText().equals(ids[i])){
                b=true;
            }
        }
        if(b==true){
            JOptionPane.showMessageDialog(this, "La ID ya existe");
        }else{
            if(usuarios_txtcontraseña.getText().equals(usuarios_txtconfirmarcontraseña.getText())){
                Boolean z=false;
                if(esLetra(usuarios_txtnombre.getText()) && z==false){
                    if(esLetra(usuarios_txtapellidopaterno.getText()) && z==false){
                        if(esLetra(usuarios_txtapellidomaterno.getText()) && z==false){
                           if(esLetra(usuarios_txtnombreusuario.getText()) && z==false){
                             z=true;
                    }
                    }
                    }
                }
                if(z==true){
                txt=cont5+"°"+usuarios_txtnombre.getText()+"°"+usuarios_txtapellidopaterno.getText()+"°"+usuarios_txtapellidomaterno.getText()+"°"+usuarios_txtnombreusuario.getText()+"°"+usuarios_txtcontraseña.getText()+"°"+usuarios_cbperfil.getSelectedItem()+"#"+"\n";
                usuarios.Write(txt);
                JOptionPane.showMessageDialog(this, "Usuario Guardado");
                }else{
                    JOptionPane.showMessageDialog(this, "Caracteres invalidos");
                }
            }else{
                JOptionPane.showMessageDialog(this, "Las contraseñas no son iguales");
            }
        }
        usuarios_txtid.setText(null);
        usuarios_txtnombre.setText(null);
        usuarios_txtnombreusuario.setText(null);
        usuarios_txtapellidopaterno.setText(null);
        usuarios_txtapellidomaterno.setText(null);
        usuarios_txtcontraseña.setText(null);
        usuarios_txtconfirmarcontraseña.setText(null);
        usuarios_txtbuscar.setText(null);
        usuarios_cbperfil.setSelectedIndex(0);
        usuarios_btnnuevo.setEnabled(true);
        usuarios_btnbuscar.setEnabled(true);
        usuarios_btneditar.setEnabled(true);
        usuarios_btneliminar.setEnabled(true);
        usuarios_btnguardar.setEnabled(false);
        usuarios_cbperfil.setEnabled(true);
        usuarios_txtnombre.setEnabled(true);
        usuarios_txtapellidopaterno.setEnabled(true);
        usuarios_txtapellidomaterno.setEnabled(true);
        usuarios_txtapellidomaterno.setEnabled(true);
        usuarios_txtnombreusuario.setEnabled(true);
        usuarios_txtapellidomaterno.setEnabled(true);
        usuarios_txtcontraseña.setEnabled(true);
        usuarios_txtconfirmarcontraseña.setEnabled(true);
        usuarios_txtbuscar.setEnabled(true);
    }//GEN-LAST:event_usuarios_btnguardarActionPerformed

    private void usuarios_txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarios_txtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarios_txtnombreActionPerformed

    private void usuarios_txtapellidopaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarios_txtapellidopaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarios_txtapellidopaternoActionPerformed

    private void usuarios_btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarios_btnbuscarActionPerformed
        sobrecarga(); 
        usuarios_txtid.setText(null);
        usuarios_txtnombre.setText(null);
        usuarios_txtnombreusuario.setText(null);
        usuarios_txtapellidopaterno.setText(null);
        usuarios_txtapellidomaterno.setText(null);
        usuarios_txtcontraseña.setText(null);
        usuarios_txtconfirmarcontraseña.setText(null);
        usuarios_cbperfil.setSelectedIndex(0);
        String nombre2="";
        String id2="";
        String nombreusuario2="";
        String apellidopaterno2="";
        String apellidomaterno2="";
        String contraseña2="";
        String perfil2="";
        String texto3="";
        int aux=0;
        String id1=usuarios_txtbuscar.getText();
        if(id1.equals("")){
            JOptionPane.showMessageDialog(this, "No ah ingresado la ID");
        }else{
            if(!esNumero(id1)){
               JOptionPane.showMessageDialog(this, "ID invalida"); 
            }else{
        String texto=usuarios.Read();
        String texto2=usuarios.Buscar(texto, id1);
        if(texto2=="no encontrado"){
            JOptionPane.showMessageDialog(this, "No se encontro la id");
            usuarios_txtbuscar.setText(null);
        }else{
            for(int i=0;i<texto2.length();i++){
                if(texto2.charAt(i)=='°'){
                    aux++;
                }
                if(texto2.charAt(i)!='°'){
                    if(aux==0){
                        id2=id2+texto2.charAt(i);
                    }
                    if(aux==1){
                        nombre2=nombre2+texto2.charAt(i);
                    }
                    if(aux==2){
                        apellidopaterno2=apellidopaterno2+texto2.charAt(i);
                    }
                    if(aux==3){
                        apellidomaterno2=apellidomaterno2+texto2.charAt(i);
                    }
                    if(aux==4){
                        nombreusuario2=nombreusuario2+texto2.charAt(i);
                    }
                    if(aux==5){
                        contraseña2=contraseña2+texto2.charAt(i);
                    }
                    if(aux==6){
                        perfil2=perfil2+texto2.charAt(i);
                    }
                }
            }
            usuarios_txtcontraseña.setText(null);
            usuarios_txtconfirmarcontraseña.setText(null);
            usuarios_txtid.setText(id2);
            usuarios_txtnombre.setText(nombre2);
            usuarios_txtnombreusuario.setText(nombreusuario2);
            usuarios_txtapellidopaterno.setText(apellidopaterno2);
            usuarios_txtapellidomaterno.setText(apellidomaterno2);
            usuarios_txtbuscar.setText(null);
            usuarios_cbperfil.setSelectedItem(perfil2);
        }
        }
        }
    }//GEN-LAST:event_usuarios_btnbuscarActionPerformed

    private void usuarios_txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarios_txtbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarios_txtbuscarActionPerformed

    private void horarios_btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horarios_btnguardarActionPerformed
         String[] ids=new String[100];
        Boolean b=false;
        String txt="",Maestro2="";
        int contMaterias=0;
        String texto=horario.Read();
        String aux="";
        int aux2=0;
        for(int i=0;i<texto.length();i++){
            if(texto.charAt(i)=='#'){
                ids[contMaterias]=aux;
                contMaterias++;
                aux="";
                aux2=0;
            }
            if(texto.charAt(i)=='°'){
                aux2=1;
            }
            if(isDigit(texto.charAt(i)) && aux2==0){
                aux=aux+texto.charAt(i);
            }

        }

        for(int i=0;i<contMaterias;i++){
            if(horarios_txtid.getText().equals(ids[i])){
                b=true;
            }
        }
        if(b==true){
            JOptionPane.showMessageDialog(this, "La ID ya existe");
        }else{
            String espa=" ";
            String dia=(String)horarios_cbdia.getSelectedItem();
                String hora=(String)horarios_cbhorario.getSelectedItem();
                     String idgrupo2=(String)horarios_cbidgrupo.getSelectedItem();
                      String Materia2=(String)horarios_cbmaterias.getSelectedItem();
                      String hora1="";
                                    hora1=dia+hora;
                            if(Materia2==""){
                                JOptionPane.showMessageDialog(this,"Materia Invalida!!");
                            }
                            else{
                                 if(dia==""){
                                JOptionPane.showMessageDialog(this,"Dia Invalido!!");
                            }else{
                                      if(hora==""){
                                JOptionPane.showMessageDialog(this,"Hora Invalida");
                            }else{
                                           if(idgrupo2==""){
                                   JOptionPane.showMessageDialog(this,"Id Grupo Invalido");
                                     }else{
                                String texto1=maestros.Read();
                                String mat=(String)horarios_cbmaterias.getSelectedItem();

                                String Profe=horario.ObProfe(texto1,mat);
                                if(Profe=="no encontrado"){
                                    JOptionPane.showMessageDialog(null,"No hay Profesor para esa Materia");
                                }else{
                                    for(int j=0;j<Profe.length();j++){
                                if(Profe.charAt(j)=='°'){
                                    aux2++;
                                }
                                if(Profe.charAt(j)!='°'){

                                  if(aux2==1){
                                        Maestro2+=Profe.charAt(j);
                                    }
                                  if(aux2==5){

                                  }


                                }
                                  
                                }
                                    if(horario.CpM(texto, Maestro2,hora1)==true){
                                     JOptionPane.showMessageDialog(null,"El Profesor Esta ocupado a esa Hora");
                                }
                                else {
                                    
                                  
                                    if(horario.CpIdg(texto,idgrupo2,hora1)==true){
                                        JOptionPane.showMessageDialog(null,"El Horario ya esta Ocupado");
                                    }else{

                                       

                                                txt=horarios_txtid.getText()+"°" 
                                                    +horarios_cbidgrupo.getSelectedItem()+"°"
                                                   +horarios_cbmaterias.getSelectedItem()+"°"
                                                    +Maestro2+"°"
                                                    +horarios_cbdia.getSelectedItem()
                                                   +horarios_cbhorario.getSelectedItem()+"#"+"\n";
                                                horario.Write(txt);
                                                JOptionPane.showMessageDialog(this, "Usuario Guardado");
                                         
                                        }  
                                    }
                                }
                        
                            }
                      }
                }
            }
        }
        horarios_txtid.setText(null);
        horarios_cbmaterias.setSelectedIndex(0);
        horarios_cbdia.setSelectedIndex(0);
        horarios_cbhorario.setSelectedIndex(0);
         horarios_cbidgrupo.setSelectedIndex(0);
        horarios_btnnuevo.setEnabled(true);
        horarios_btnguardar.setEnabled(false);
        horarios_btnbuscar.setEnabled(true);
        horarios_btngenerarhorario.setEnabled(true);
        String comp=status.Read();
        String comp2="";
        for(int i=0;i<comp.length()-1;i++){
            comp2+=comp.charAt(i);
        }
        if(comp2.equals("Administrador")){
        tablaHorario();
        }else if(comp2.equals("")){
            
        }else{
            tablaHorario2();
        }
    }//GEN-LAST:event_horarios_btnguardarActionPerformed

    private void semestre_btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semestre_btnbuscarActionPerformed
       sobrecarga();
        int aux=0;
       String id1=semestre_txtbuscar.getText();
       semestre_txtid.setText(null);
            semestre_cbperiodo.setSelectedIndex(0);
            semestre_fechai.setText(null);
            semestre_fechaf.setText(null);
            semestre_jdcfechainicio.setDate(null);
            semestre_jdcfechafinal.setDate(null);
            semestre_txtbuscar.setText(null);
        if(id1.equals("")){
            JOptionPane.showMessageDialog(this, "No ah ingresado la ID");
        }else{
            if(!esNumero(id1)){
               JOptionPane.showMessageDialog(this, "ID invalida"); 
            }else{
        String texto=semestre.Read();
        String texto2=semestre.Buscar(texto, id1);
        if(texto2=="no encontrado"){
            JOptionPane.showMessageDialog(this, "No se encontro la id");
        }else{
            String id2="";
            String periodo2="";
            String fechainicio2="";
            String fechafin2="";
            for(int i=0;i<texto2.length();i++){
                if(texto2.charAt(i)=='°'){
                    aux++;
                }
                if(texto2.charAt(i)!='°'){
                  if(aux==0){
                        id2=id2+texto2.charAt(i);
                    }  
                  if(aux==1){
                        periodo2+=texto2.charAt(i);
                    }
                  if(aux==2){
                        fechainicio2+=texto2.charAt(i);
                    }
                  if(aux==3){
                        fechafin2+=texto2.charAt(i);
                    } 
                }
                }
            semestre_txtid.setText(id2);
            semestre_cbperiodo.setSelectedItem(periodo2);
            semestre_fechai.setText(fechainicio2);
            semestre_fechaf.setText(fechafin2);
        }
        }
        }
    }//GEN-LAST:event_semestre_btnbuscarActionPerformed

    private void maestros_btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maestros_btnbuscarActionPerformed
sobrecarga();
        int aux=0;
       String id1=maestros_txtbuscar.getText();
        if(id1.equals("")){
            JOptionPane.showMessageDialog(this, "No ah ingresado la ID");
            maestros_txtid.setText(null);
            maestros_txtnombremaestro.setText(null);
            maestros_cbgradoacademico.setSelectedIndex(0);
            maestros_cbgrupoacademico.setSelectedIndex(0);
            maestros_txtdireccion.setText(null);
            maestros_txttelefono.setText(null);
            maestros_cbmateria.setSelectedItem(null);
            maestros_txtbuscar.setText(null);
        }else{
            if(!esNumero(id1)){
               JOptionPane.showMessageDialog(this, "ID invalida"); 
               maestros_txtid.setText(null);
            maestros_txtnombremaestro.setText(null);
            maestros_cbgradoacademico.setSelectedIndex(0);
            maestros_cbgrupoacademico.setSelectedIndex(0);
            maestros_txtdireccion.setText(null);
            maestros_txttelefono.setText(null);
            maestros_cbmateria.setSelectedItem(null);
            maestros_txtbuscar.setText(null);
            }else{
        String texto=maestros.Read();
        String texto2=maestros.Buscar(texto, id1);
        if(texto2=="no encontrado"){
            JOptionPane.showMessageDialog(this, "No se encontro la id");
            maestros_txtid.setText(null);
            maestros_txtnombremaestro.setText(null);
            maestros_cbgradoacademico.setSelectedIndex(0);
            maestros_cbgrupoacademico.setSelectedIndex(0);
            maestros_txtdireccion.setText(null);
            maestros_txttelefono.setText(null);
            maestros_cbmateria.setSelectedItem(null);
            maestros_txtbuscar.setText(null);
        }else{
            String id2="";
            String nombreM2="";
            String gradoacademico2="";
            String grupoacademico2="";
            String direccion2="";
            String telefono2="";
            String materia2="";
            for(int i=0;i<texto2.length();i++){
                if(texto2.charAt(i)=='°'){
                    aux++;
                }
                if(texto2.charAt(i)!='°'){
                  if(aux==0){
                        id2=id2+texto2.charAt(i);
                    }  
                  if(aux==1){
                        nombreM2+=texto2.charAt(i);
                    }
                  if(aux==2){
                        gradoacademico2+=texto2.charAt(i);
                    }
                  if(aux==3){
                        grupoacademico2+=texto2.charAt(i);
                    } 
                  if(aux==4){
                        direccion2+=texto2.charAt(i);
                    }
                  if(aux==5){
                        telefono2+=texto2.charAt(i);
                    }
                  if(aux==6){
                        materia2+=texto2.charAt(i);
                    }
                }
                }
            maestros_txtid.setText(id2);
            maestros_txtnombremaestro.setText(nombreM2);
            maestros_cbgradoacademico.setSelectedItem(gradoacademico2);
            maestros_cbgrupoacademico.setSelectedItem(grupoacademico2);
            maestros_txtdireccion.setText(direccion2);
            maestros_txttelefono.setText(telefono2);
            maestros_cbmateria.setSelectedItem(materia2);
            maestros_txtbuscar.setText(null);
        }
        }
        }     
        
    }//GEN-LAST:event_maestros_btnbuscarActionPerformed

    private void SALIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SALIRActionPerformed
        // TODO add your handling code here:
        Login Lg = new Login();
        Lg.setVisible(true);
        Lg.pack();
        Lg.setLocationRelativeTo(null);
        Lg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        this.dispose();
    }//GEN-LAST:event_SALIRActionPerformed

    private void carreras_btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carreras_btnbuscarActionPerformed
        sobrecarga();
        int aux=0;
       String id1=carreras_txtbuscar.getText();
       carreras_txtid.setText(null);
             carreras_txtnombrecarrera.setText(null);
            carreras_cbarea.setSelectedIndex(0);
            carreras_cbsemestre.setSelectedIndex(0);
            carrera_fecha.setText(null);
            carreras_jdcfecha.setDate(null);
            carreras_txtbuscar.setText(null);
        if(id1.equals("")){
            JOptionPane.showMessageDialog(this, "No ah ingresado la ID");
        }else{
            if(!esNumero(id1)){
               JOptionPane.showMessageDialog(this, "ID invalida"); 
            }else{
        String texto=carrera.Read();
        String texto2=carrera.Buscar(texto, id1);
        if(texto2=="no encontrado"){
            JOptionPane.showMessageDialog(this, "No se encontro la id");
        }else{
            String id2="";
            String nombrecarrera2="";
            String area2="";
            String semestre2="";
            String fecha2="";
            for(int i=0;i<texto2.length();i++){
                if(texto2.charAt(i)=='°'){
                    aux++;
                }
                if(texto2.charAt(i)!='°'){
                  if(aux==0){
                        id2=id2+texto2.charAt(i);
                    }  
                  if(aux==1){
                        nombrecarrera2+=texto2.charAt(i);
                    }
                  if(aux==2){
                        area2+=texto2.charAt(i);
                    }
                  if(aux==3){
                        semestre2+=texto2.charAt(i);
                    }
                  if(aux==4){
                    fecha2+=texto2.charAt(i);
                  }
                }
                }
            carreras_txtid.setText(id2);
             carreras_txtnombrecarrera.setText(nombrecarrera2);
            carreras_cbarea.setSelectedItem(area2);
            carreras_cbsemestre.setSelectedItem(semestre2);
            carrera_fecha.setText(fecha2);
           
            //semestre_jdcfechainicio.setDate(null);
        }
        }
        }
    }//GEN-LAST:event_carreras_btnbuscarActionPerformed

    private void horarios_btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horarios_btnbuscarActionPerformed
        sobrecarga();
    }//GEN-LAST:event_horarios_btnbuscarActionPerformed

    private void alumnos_cbcarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alumnos_cbcarreraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alumnos_cbcarreraActionPerformed

    private void alumnos_cbperiodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alumnos_cbperiodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alumnos_cbperiodoActionPerformed

    private void horarios_btngenerarhorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horarios_btngenerarhorarioActionPerformed
        // TODO add your handling code here:
         // TODO add your handling code here:
         int cont5=0;
        String[] ids=new String[100];
        String texto=horario.Read();
        String auxili="";
        int auxili2=0;
        
        for(int l=0;l<texto.length();l++){
            if(texto.charAt(l)=='#'){
                ids[cont5]=auxili;
                cont5++;
                auxili="";
                auxili2=0;
            }
            if(texto.charAt(l)=='°'){
                auxili2=1;
            }
            if(isDigit(texto.charAt(l)) && auxili2==0){
                auxili=auxili+texto.charAt(l);
            }

        } 
       String leergrupo=grupo.Read();
        String aux="";
        String linea=""; 
        int a=0,b=0;
        for(int i=0;i<leergrupo.length();i++){
            if(leergrupo.charAt(i)=='°'){
                a=1;
            }
            if(leergrupo.charAt(i)=='#'){
            b=1;
            }
            linea=linea+leergrupo.charAt(i);
            if(isDigit(leergrupo.charAt(i)) && a==0){
            aux=aux+leergrupo.charAt(i);
            }
            if(b==1){
               String lineaCom="";
                String materia2 = "",horario2="",horario3="";
                int aux1=0,aux2=0;
                   int contmate=0,contprofe=0;
        int conti=0,contj=0;
                String[] materias2=new String [20];
        String[] profesores=new String[20];
                        boolean LOLh2=true;
                        boolean LOLh3=true;
                String leerMaterias=materias.Read();
                  for(int j=0;j<leerMaterias.length();j++){
                        if(leerMaterias.charAt(j)=='°'){
                            aux1++;
                        }
                        if(leerMaterias.charAt(j)=='#'){
                            materias2[contmate]=materia2;
                            contmate++;
                            aux1=0;
                            materia2="";
                        }
                        if(leerMaterias.charAt(j)!='°'){
                          
                            if(aux1==1){
                                materia2=materia2+leerMaterias.charAt(j);
                            }
                            

                        }
                    }
                  String leerMaestros =maestros.Read();
                  for(int l=0;l<contmate;l++){
                   String lineaProfe=horario.ObProfe(leerMaestros,materias2[l]);
                   if(lineaProfe=="no encontrado"){
                       l++;
                        profesores[contprofe]="@";
                        contprofe++;
                   }
                   else{
                    materia2="";
                    aux2=0;
                   for(int j=0;j<lineaProfe.length();j++){
                                if(lineaProfe.charAt(j)=='°'){
                                    aux2++;
                                }
                                if(lineaProfe.charAt(j)=='#'){
                                  profesores[contprofe]=materia2;  
                                  contprofe++;
                                }
                                if(lineaProfe.charAt(j)!='°'){

                                  if(aux2==1){
                                        materia2+=lineaProfe.charAt(j);
                                    }
                                
                                }
                                  
                                }
                            }
                   
                  }
                  int grup=Integer.parseInt(aux);
                   int  clases;
                   boolean bandh2=true,bandh3=true;
           int opcion;
                  //if(grup%2==0){
                    for(int j=0;j<contmate;j++){
        
        if(profesores[j]=="@"){
       JOptionPane.showMessageDialog(null,"No hay profesor para esta materia");

        }
        else{
           
             clases=(contprofe-1)/2;
            opcion=(contprofe-1)%2;
           if(opcion==0){
               if(conti<clases){
                switch(conti){
                   case 0:{
                       horario2="lunes7:00";
                       horario3="miercoles7:00";break;
                   }
                   case 1:{
                       horario2="lunes8:00";
                       horario3="miercoles8:00";break;
                   }
                   case 2:{
                        horario2="lunes9:00";
                       horario3="miercoles9:00";break;
                   }
                   case 3:{
                        horario2="lunes10:00";
                       horario3="miercoles10:00";break;
                   }
                   case 4:{
                       horario2="lunes11:00";
                       horario3="miercoles11:00";break;
                   }
                   case 5:{
                       horario2="lunes12:00";
                       horario3="miercoles12:00";break;
                   }
                   case 6:{
                       horario2="lunes1:00";
                       horario3="miercoles1:00";break;
                   }
                   case 7:{
                       horario2="lunes2:00";
                       horario3="miercoles2:00";break;                   
                   }
                   
               }
             }
               else{
                   switch(contj){
                   case 0:{
                       horario2="martes7:00";
                       horario3="jueves7:00";break;
                   }
                   case 1:{
                       horario2="martes8:00";
                       horario3="jueves8:00";break;                   }
                   case 2:{
                      horario2="martes9:00";
                       horario3="jueves9:00";break;
                   }
                   case 3:{
                       horario2="martes10:00";
                       horario3="jueves10:00";break;
                   }
                   case 4:{
                       horario2="martes11:00";
                       horario3="jueves11:00";break;
                   }
                   case 5:{
                      horario2="martes12:00";
                       horario3="jueves12:00";break;
                   }
                   case 6:{
                      horario2="martes1:00";
                       horario3="jueves1:00";break;
                   }
                   case 7:{
                      horario2="martes2:00";
                       horario3="jueves2:00";break;
                   }                 
               }
                   contj++;
               }
                 conti++;
           }
           if(opcion==1){
                if(conti<=clases){
                switch(conti){
                    case 0:{
                       horario2="lunes7:00";
                       horario3="miercoles7:00";break;
                   }
                   case 1:{
                       horario2="lunes8:00";
                       horario3="miercoles8:00";break;
                   }
                   case 2:{
                        horario2="lunes9:00";
                       horario3="miercoles9:00";break;
                   }
                   case 3:{
                        horario2="lunes10:00";
                       horario3="miercoles10:00";break;
                   }
                   case 4:{
                       horario2="lunes11:00";
                       horario3="miercoles11:00";break;
                   }
                   case 5:{
                       horario2="lunes12:00";
                       horario3="miercoles12:00";break;
                   }
                   case 6:{
                       horario2="lunes1:00";
                       horario3="miercoles1:00";break;
                   }
                   case 7:{
                       horario2="lunes2:00";
                       horario3="miercoles2:00";break;                   
                   }
                                  
               }
             }
               else{
                   switch(contj){
                    case 0:{
                       horario2="martes7:00";
                       horario3="jueves7:00";break;
                   }
                   case 1:{
                       horario2="martes8:00";
                       horario3="jueves8:00";break;                   
                   }
                   case 2:{
                      horario2="martes9:00";
                       horario3="jueves9:00";break;
                   }
                   case 3:{
                       horario2="martes10:00";
                       horario3="jueves10:00";break;
                   }
                   case 4:{
                       horario2="martes11:00";
                       horario3="jueves11:00";break;
                   }
                   case 5:{
                      horario2="martes12:00";
                       horario3="jueves12:00";break;
                   }
                   case 6:{
                      horario2="martes1:00";
                       horario3="jueves1:00";break;
                   }
                   case 7:{
                      horario2="martes2:00";
                       horario3="jueves2:00";break;
                   }             
               }
                   contj++;
               }
                 conti++;
           }
            texto=horario.Read();
            if(horario.CpIdg(texto,aux,horario3)==true){
                clases=(contprofe-1)/2;
                if(contj-1<clases){
                                             for(int p=clases+1;p<8;p++){
                                              switch(p){
                                                    case 0:{
                                                        horario3="miercoles7:00";break;
                                                    }
                                                    case 1:{
                                                        horario3="miercoles8:00";break;
                                                    }
                                                    case 2:{
                                                         horario3="miercoles9:00";break;
                                                    }
                                                    case 3:{
                                                         horario3="miercoles10:00";break;
                                                    }
                                                    case 4:{
                                                        horario3="miercoles11:00";break;
                                                    }
                                                    case 5:{
                                                        horario3="miercoles12:00";break;
                                                    }
                                                    case 6:{
                                                        horario3="miercoles1:00";break;
                                                    }
                                                    case 7:{
                                                        horario3="miercoles2:00";break;
                                                    }
                   
                                                 }
                                              if(horario.CpIdg(texto,aux,horario3)==false){
                                                  bandh3=true;
                                                  LOLh3=true;
                                                  break;
                                              }else{bandh2=false;LOLh3=false;}
                                            
                                             }
                                         }else{
                                              for(int p=clases+1;p<8;p++){
                                              switch(p){
                                                    case 0:{
                                                    horario3="jueves7:00";break;
                                                }
                                                case 1:{
                                                    horario3="jueves8:00";break;
                                                }
                                                case 2:{
                                                   horario3="jueves9:00";break;
                                                }
                                                case 3:{
                                                    horario3="jueves10:00";break;

                                                }
                                                case 4:{
                                                    horario3="jueves11:00";break;
                                                }
                                                case 5:{
                                                   horario3="jueves12:00";break;
                                                }
                                                case 6:{
                                                   horario3="jueves1:00";break;
                                                }
                                                case 7:{
                                                   horario3="jueves2:00";break;
                                                }            
                                               }
                                              if(horario.CpIdg(texto,aux,horario3)==false){
                                                  bandh3=true;
                                                  LOLh2=true;
                                                  break;
                                              }else{bandh2=false;LOLh3=false;}
                                            
                                             }
                                         }
                                     }
                                    if(LOLh3==false) {
                            
                        }
                        else{
                if(horario.CpM(texto,profesores[j],horario3)==true){
                    boolean sal=false;
                                     String lineaProfa;
                                     int cantp=horario.ObContProfe(leerMaestros,materias2[j]);
                                     String profa;
                                     if(cantp<2){ 
                                         clases=(contprofe-1)/2;
                                         
                                         
                                         if(contj-1<clases){
                                             for(int p=clases+1;p<8;p++){
                                              switch(p){
                                                    case 0:{
                                                        horario3="miercoles7:00";break;
                                                    }
                                                    case 1:{
                                                        horario3="miercoles8:00";break;
                                                    }
                                                    case 2:{
                                                         horario3="miercoles9:00";break;
                                                    }
                                                    case 3:{
                                                         horario3="miercoles10:00";break;
                                                    }
                                                    case 4:{
                                                        horario3="miercoles11:00";break;
                                                    }
                                                    case 5:{
                                                        horario3="miercoles12:00";break;
                                                    }
                                                    case 6:{
                                                        horario3="miercoles1:00";break;
                                                    }
                                                    case 7:{
                                                        horario3="miercoles2:00";break;
                                                    }
                   
                                                 }
                                              if(horario.CpM(texto,profesores[j],horario3)==false){
                                                  bandh2=true;
                                                  break;
                                              }else{bandh2=false;}
                                            
                                             }
                                         }else{
                                              for(int p=clases+1;p<8;p++){
                                              switch(p){
                                                 case 0:{
                                                    horario3="jueves7:00";break;
                                                }
                                                case 1:{
                                                    horario3="jueves8:00";break;
                                                }
                                                case 2:{
                                                   horario3="jueves9:00";break;
                                                }
                                                case 3:{
                                                    horario3="jueves10:00";break;

                                                }
                                                case 4:{
                                                    horario3="jueves11:00";break;
                                                }
                                                case 5:{
                                                   horario3="jueves12:00";break;
                                                }
                                                case 6:{
                                                   horario3="jueves1:00";break;
                                                }
                                                case 7:{
                                                   horario3="jueves2:00";break;
                                                }              
                                               }
                                              if(horario.CpM(texto,profesores[j],horario3)==false){
                                                  bandh2=true;
                                                  break;
                                              }else{bandh2=false;}
                                            
                                             }
                                         }
                                     }else{
                                         aux2=0;
                                         for(int p=0;p<cantp;p++){
                                             profa="";
                                        lineaProfa=horario.ObProfePos(leerMaestros,materias2[j],p);
                                       
                   
                    
                                            for(int k=0;k<lineaProfa.length();k++){
                                                         if(lineaProfa.charAt(k)=='°'){
                                                             aux2++;
                                                         }
                                                         if(lineaProfa.charAt(k)=='#'){
                                                                aux2=0;
                                                         }
                                                         if(lineaProfa.charAt(k)!='°'){

                                                           if(aux2==1){
                                                                 profa+=lineaProfa.charAt(k);
                                                             }

                                                         }

                                                         }
                            
                                            if(horario.CpM(texto,profa, horario3)==false){
                                                  profesores[j]=profa;
                                                      bandh3=true;
                                                      break;
                                                   }else{bandh3=false;}
                                           }
                                         if(bandh3==false){
                                              clases=(contprofe-1)/2;
                                               if(contj-1<clases){
                                             for(int p=clases+1;p<8;p++){
                                                 if(sal==true){break;}
                                              switch(p){
                                                    case 0:{
                                                        horario3="miercoles7:00";break;
                                                    }
                                                    case 1:{
                                                        horario3="miercoles8:00";break;
                                                    }
                                                    case 2:{
                                                         horario3="miercoles9:00";break;
                                                    }
                                                    case 3:{
                                                         horario3="miercoles10:00";break;
                                                    }
                                                    case 4:{
                                                        horario3="miercoles11:00";break;
                                                    }
                                                    case 5:{
                                                        horario3="miercoles12:00";break;
                                                    }
                                                    case 6:{
                                                        horario3="miercoles1:00";break;
                                                    }
                                                    case 7:{
                                                        horario3="miercoles2:00";break;
                                                    }
                   
                                                 }
                                              if(horario.CpIdg(texto,aux,horario3)==false){ 
                                                   for(int po=0;po<cantp;po++){
                                                       profa="";
                                        lineaProfa=horario.ObProfePos(leerMaestros,materias2[j],po);
                                        aux2=0;
                                        for(int k=0;k<lineaProfa.length();k++){
                                                         if(lineaProfa.charAt(k)=='°'){
                                                             aux2++;
                                                         }
                                                         if(lineaProfa.charAt(k)=='#'){
                                                             aux2=0;
                                                         }
                                                         if(lineaProfa.charAt(k)!='°'){

                                                           if(aux2==1){
                                                                 profa+=lineaProfa.charAt(k);
                                                             }

                                                         }

                                                         }
                                            if(horario.CpM(texto,profa, horario3)==false){
                                                  profesores[j]=profa;
                                                  sal=true;
                                                      bandh2=true;
                                                      break;
                                                   }else{bandh2=false;}
                                           }
                                                  
                                                   
                                                
                                              }
                                            
                                             }
                                         }else{
                                              for(int p=clases;p<8;p++){
                                                  if(sal==true){break;}
                                              switch(p){
                                                    case 0:{
                                                    horario3="jueves7:00";break;
                                                }
                                                case 1:{
                                                    horario3="jueves8:00";break;
                                                }
                                                case 2:{
                                                   horario3="jueves9:00";break;
                                                }
                                                case 3:{
                                                    horario3="jueves10:00";break;

                                                }
                                                case 4:{
                                                    horario3="jueves11:00";break;
                                                }
                                                case 5:{
                                                   horario3="jueves12:00";break;
                                                }
                                                case 6:{
                                                   horario3="jueves1:00";break;
                                                }
                                                case 7:{
                                                   horario3="jueves2:00";break;
                                                }           
                                               }
                                              if(horario.CpIdg(texto,aux,horario3)==false){
                                                   for(int po=0;po<cantp;po++){
                                                       profa="";
                                        lineaProfa=horario.ObProfePos(leerMaestros,materias2[j],po);
                                        aux2=0;
                                        for(int k=0;k<lineaProfa.length();k++){
                                                         if(lineaProfa.charAt(k)=='°'){
                                                             aux2++;
                                                         }
                                                         if(lineaProfa.charAt(k)=='#'){
                                                                aux2=0;
                                                         }
                                                         if(lineaProfa.charAt(k)!='°'){

                                                           if(aux2==1){
                                                                 profa+=lineaProfa.charAt(k);
                                                             }

                                                         }

                                                         }
                                            if(horario.CpM(texto,profa, horario3)==false){
                                                  profesores[j]=profa;
                                                      bandh3=true;
                                                      sal=true;
                                                      break;
                                                   }else{bandh3=false;}
                                           }
                                                 
                                              }
                                            
                                             }
                                         }
                                         }
                                         
                                     }
                                }
                             
                                    
                        }
            if(horario.CpIdg(texto,aux,horario2)==true){
                clases=(contprofe-1)/2;
                if(contj-1<clases){
                                             for(int p=clases+1;p<8;p++){
                                              switch(p){
                                                    case 0:{
                                                        horario2="lunes7:00";break;
                                                    }
                                                    case 1:{
                                                        horario2="lunes8:00";break;
                                                    }
                                                    case 2:{
                                                         horario2="lunes9:00";break;
                                                    }
                                                    case 3:{
                                                         horario2="lunes10:00";break;
                                                    }
                                                    case 4:{
                                                        horario2="lunes11:00";break;
                                                    }
                                                    case 5:{
                                                        horario2="lunes12:00";break;
                                                    }
                                                    case 6:{
                                                        horario2="lunes1:00";break;
                                                    }
                                                    case 7:{
                                                        horario2="lunes2:00";break;
                                                    }
                   
                                                 }
                                              if(horario.CpIdg(texto,aux,horario2)==false){
                                                  bandh2=true;
                                                  LOLh2=true;
                                                  break;
                                              }else{bandh2=false;LOLh2=false;}
                                            
                                             }
                                         }else{
                                              for(int p=clases+1;p<8;p++){
                                              switch(p){
                                                    case 0:{
                                                    horario2="martes7:00";break;
                                                }
                                                case 1:{
                                                    horario2="martes8:00";break;
                                                }
                                                case 2:{
                                                   horario2="martes9:00";break;
                                                }
                                                case 3:{
                                                    horario2="martes10:00";break;

                                                }
                                                case 4:{
                                                    horario2="martes11:00";break;
                                                }
                                                case 5:{
                                                   horario2="martes12:00";break;
                                                }
                                                case 6:{
                                                   horario2="martes1:00";break;
                                                }
                                                case 7:{
                                                   horario2="martes2:00";break;
                                                }            
                                               }
                                              if(horario.CpIdg(texto,aux,horario2)==false){
                                                  bandh2=true;
                                                  LOLh2=true;
                                                  break;
                                              }else{bandh2=false;LOLh2=false;}
                                            
                                             }
                                         }
                                     }
                                    
        
                        if(LOLh2==false) {
                            
                        }
                        else{
                if(horario.CpM(texto,profesores[j],horario2)==true){
                    boolean sal=false;
                                     String lineaProfa;
                                     int cantp=horario.ObContProfe(leerMaestros,materias2[j]);
                                     String profa;
                                     if(cantp<2){ 
                                         clases=(contprofe-1)/2;
                                         
                                         
                                         if(contj-1<clases){
                                             for(int p=clases+1;p<8;p++){
                                              switch(p){
                                                    case 0:{
                                                        horario2="lunes7:00";break;
                                                    }
                                                    case 1:{
                                                        horario2="lunes8:00";break;
                                                    }
                                                    case 2:{
                                                         horario2="lunes9:00";break;
                                                    }
                                                    case 3:{
                                                         horario2="lunes10:00";break;
                                                    }
                                                    case 4:{
                                                        horario2="lunes11:00";break;
                                                    }
                                                    case 5:{
                                                        horario2="lunes12:00";break;
                                                    }
                                                    case 6:{
                                                        horario2="lunes1:00";break;
                                                    }
                                                    case 7:{
                                                        horario2="lunes2:00";break;
                                                    }
                   
                                                 }
                                              if(horario.CpM(texto,profesores[j],horario2)==false){
                                                  bandh2=true;
                                                  break;
                                              }else{bandh2=false;}
                                            
                                             }
                                         }else{
                                              for(int p=clases+1;p<8;p++){
                                              switch(p){
                                                 case 0:{
                                                    horario2="martes7:00";break;
                                                }
                                                case 1:{
                                                    horario2="martes8:00";break;
                                                }
                                                case 2:{
                                                   horario2="martes9:00";break;
                                                }
                                                case 3:{
                                                    horario2="martes10:00";break;

                                                }
                                                case 4:{
                                                    horario2="martes11:00";break;
                                                }
                                                case 5:{
                                                   horario2="martes12:00";break;
                                                }
                                                case 6:{
                                                   horario2="martes1:00";break;
                                                }
                                                case 7:{
                                                   horario2="martes2:00";break;
                                                }              
                                               }
                                              if(horario.CpM(texto,profesores[j],horario2)==false){
                                                  bandh2=true;
                                                  break;
                                              }else{bandh2=false;}
                                            
                                             }
                                         }
                                     }else{
                                         aux2=0;
                                         for(int p=0;p<cantp;p++){
                                             profa="";
                                        lineaProfa=horario.ObProfePos(leerMaestros,materias2[j],p);
                                       
                   
                    
                                            for(int k=0;k<lineaProfa.length();k++){
                                                         if(lineaProfa.charAt(k)=='°'){
                                                             aux2++;
                                                         }
                                                         if(lineaProfa.charAt(k)=='#'){
                                                                aux2=0;
                                                         }
                                                         if(lineaProfa.charAt(k)!='°'){

                                                           if(aux2==1){
                                                                 profa+=lineaProfa.charAt(k);
                                                             }

                                                         }

                                                         }
                            
                                            if(horario.CpM(texto,profa, horario2)==false){
                                                  profesores[j]=profa;
                                                      bandh2=true;
                                                      break;
                                                   }else{bandh2=false;}
                                           }
                                         if(bandh2==false){
                                              clases=(contprofe-1)/2;
                                               if(contj-1<clases){
                                             for(int p=clases+1;p<8;p++){
                                                 if(sal==true){break;}
                                              switch(p){
                                                    case 0:{
                                                        horario2="lunes7:00";break;
                                                    }
                                                    case 1:{
                                                        horario2="lunes8:00";break;
                                                    }
                                                    case 2:{
                                                         horario2="lunes9:00";break;
                                                    }
                                                    case 3:{
                                                         horario2="lunes10:00";break;
                                                    }
                                                    case 4:{
                                                        horario2="lunes11:00";break;
                                                    }
                                                    case 5:{
                                                        horario2="lunes12:00";break;
                                                    }
                                                    case 6:{
                                                        horario2="lunes1:00";break;
                                                    }
                                                    case 7:{
                                                        horario2="lunes2:00";break;
                                                    }
                   
                                                 }
                                              if(horario.CpIdg(texto,aux,horario2)==false){
                                                   for(int po=0;po<cantp;po++){
                                                       profa="";
                                        lineaProfa=horario.ObProfePos(leerMaestros,materias2[j],po);
                                        aux2=0;
                                        for(int k=0;k<lineaProfa.length();k++){
                                                         if(lineaProfa.charAt(k)=='°'){
                                                             aux2++;
                                                         }
                                                         if(lineaProfa.charAt(k)=='#'){
                                                             aux2=0;
                                                         }
                                                         if(lineaProfa.charAt(k)!='°'){

                                                           if(aux2==1){
                                                                 profa+=lineaProfa.charAt(k);
                                                             }

                                                         }

                                                         }
                                            if(horario.CpM(texto,profa, horario2)==false){
                                                  profesores[j]=profa;
                                                  sal=true;
                                                      bandh2=true;
                                                      break;
                                                   }else{bandh2=false;}
                                           }
                                                  
                                                   
                                                
                                              }
                                            
                                             }
                                         }else{
                                              for(int p=clases;p<8;p++){
                                                  if(sal==true){break;}
                                              switch(p){
                                                    case 0:{
                                                    horario2="martes7:00";break;
                                                }
                                                case 1:{
                                                    horario2="martes8:00";break;
                                                }
                                                case 2:{
                                                   horario2="martes9:00";break;
                                                }
                                                case 3:{
                                                    horario2="martes10:00";break;

                                                }
                                                case 4:{
                                                    horario2="martes11:00";break;
                                                }
                                                case 5:{
                                                   horario2="martes12:00";break;
                                                }
                                                case 6:{
                                                   horario2="martes1:00";break;
                                                }
                                                case 7:{
                                                   horario2="martes2:00";break;
                                                }           
                                               }
                                              if(horario.CpIdg(texto,aux,horario2)==false){
                                                   for(int po=0;po<cantp;po++){
                                                       profa="";
                                        lineaProfa=horario.ObProfePos(leerMaestros,materias2[j],po);
                                        aux2=0;
                                        for(int k=0;k<lineaProfa.length();k++){
                                                         if(lineaProfa.charAt(k)=='°'){
                                                             aux2++;
                                                         }
                                                         if(lineaProfa.charAt(k)=='#'){
                                                                aux2=0;
                                                         }
                                                         if(lineaProfa.charAt(k)!='°'){

                                                           if(aux2==1){
                                                                 profa+=lineaProfa.charAt(k);
                                                             }

                                                         }

                                                         }
                                            if(horario.CpM(texto,profa, horario2)==false){
                                                  profesores[j]=profa;
                                                      bandh2=true;
                                                      sal=true;
                                                      break;
                                                   }else{bandh2=false;}
                                           }
                                                 
                                              }
                                            
                                             }
                                         }
                                         }
                                         
                                     }
                                }
                             
                                    
                        }         
                                    
                                    if(bandh2==true){
                                        lineaCom="";
                                  lineaCom+=cont5+"°"+aux+"°"+materias2[j]+"°"+profesores[j]+"°"+horario2+"#"+"\n";
                                               horario.Write(lineaCom);
                                                
                                                cont5++;
                                    }
                                    if(bandh3==true){
                                             lineaCom="";   
                                  lineaCom+=cont5+"°"+aux+"°"+materias2[j]+"°"+profesores[j]+"°"+horario3+"#"+"\n";
                                               horario.Write(lineaCom);
                                         cont5++;
                                    }
                                        
                    
            }                     
          
        }
        
                    //}else{}
                   linea="";
                   aux="";
                   b=0;
                   a=0;
            }
                  
               
            }
       String comp=status.Read();
        String comp2="";
        for(int i=0;i<comp.length()-1;i++){
            comp2+=comp.charAt(i);
        }
        if(comp2.equals("Administrador")){
        tablaHorario();
        }else if(comp2.equals("")){
            
        }else{
            tablaHorario2();
        }
    }//GEN-LAST:event_horarios_btngenerarhorarioActionPerformed

    private Boolean esNumero(String a){
        Boolean x=true;
        for(int i=0;i<a.length();i++){
            if(isDigit(a.charAt(i))){
                x=true;
            }else{
                x=false;
                break;
            }
        }
        return x;
    }
    
    private Boolean esLetra(String a){
        Boolean b=true;
        for(int i=0;i<a.length();i++){
            if(Character.isLetter(a.charAt(i))){
                b=true;
            }else if(a.charAt(i)==' '){
                b=true;
            }else{
                b=false;
                break;
            }
        }
        return b;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SALIR;
    private javax.swing.JButton alumnos_btnbuscar;
    private javax.swing.JButton alumnos_btneditar;
    private javax.swing.JButton alumnos_btneliminar;
    private javax.swing.JButton alumnos_btnguardar;
    private javax.swing.JButton alumnos_btnnuevo;
    private javax.swing.JComboBox<String> alumnos_cbcarrera;
    private javax.swing.JComboBox<String> alumnos_cbgrupo;
    private javax.swing.JComboBox<String> alumnos_cbperiodo;
    private javax.swing.JComboBox<String> alumnos_cbsemestre;
    private javax.swing.JLabel alumnos_fecha;
    private javax.swing.JLabel alumnos_fechan;
    private com.toedter.calendar.JDateChooser alumnos_jdcfecha;
    private com.toedter.calendar.JDateChooser alumnos_jdcfechanacimiento;
    private javax.swing.JTextField alumnos_txtapellidomaterno;
    private javax.swing.JTextField alumnos_txtapellidopaterno;
    private javax.swing.JTextField alumnos_txtbuscar;
    private javax.swing.JTextField alumnos_txtciudad;
    private javax.swing.JTextField alumnos_txtdireccion;
    private javax.swing.JTextField alumnos_txtemail;
    private javax.swing.JTextField alumnos_txtid;
    private javax.swing.JTextField alumnos_txtnombre;
    private javax.swing.JTextField alumnos_txttelefono;
    private javax.swing.JLabel carrera_fecha;
    private javax.swing.JButton carreras_btnbuscar;
    private javax.swing.JButton carreras_btneditar;
    private javax.swing.JButton carreras_btneliminar;
    private javax.swing.JButton carreras_btnguardar;
    private javax.swing.JButton carreras_btnnuevo;
    private javax.swing.JComboBox<String> carreras_cbarea;
    private javax.swing.JComboBox<String> carreras_cbsemestre;
    private com.toedter.calendar.JDateChooser carreras_jdcfecha;
    private javax.swing.JTextField carreras_txtbuscar;
    private javax.swing.JTextField carreras_txtid;
    private javax.swing.JTextField carreras_txtnombrecarrera;
    private javax.swing.JButton grupos_btnbuscar;
    private javax.swing.JButton grupos_btneditar;
    private javax.swing.JButton grupos_btneliminar;
    private javax.swing.JButton grupos_btnguardar;
    private javax.swing.JButton grupos_btnnuevo;
    private javax.swing.JComboBox<String> grupos_cbidmaestro;
    private javax.swing.JComboBox<String> grupos_cbidmateria;
    private javax.swing.JTable grupos_jtgrupos;
    private javax.swing.JTextField grupos_txtbuscar;
    private javax.swing.JTextField grupos_txtid;
    private javax.swing.JTextField grupos_txtnombregrupo;
    private javax.swing.JButton horarios_btnbuscar;
    private javax.swing.JButton horarios_btngenerarhorario;
    private javax.swing.JButton horarios_btnguardar;
    private javax.swing.JButton horarios_btnnuevo;
    private javax.swing.JComboBox<String> horarios_cbdia;
    private javax.swing.JComboBox<String> horarios_cbhorario;
    private javax.swing.JComboBox<String> horarios_cbidgrupo;
    private javax.swing.JComboBox<String> horarios_cbmaterias;
    private javax.swing.JTable horarios_jthorarios;
    private javax.swing.JTextField horarios_txtbuscar;
    private javax.swing.JTextField horarios_txtid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    public javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton maestros_btnbuscar;
    private javax.swing.JButton maestros_btneditar;
    private javax.swing.JButton maestros_btneliminar;
    private javax.swing.JButton maestros_btnguardar;
    private javax.swing.JButton maestros_btnnuevo;
    private javax.swing.JComboBox<String> maestros_cbgradoacademico;
    private javax.swing.JComboBox<String> maestros_cbgrupoacademico;
    private javax.swing.JComboBox<String> maestros_cbmateria;
    public javax.swing.JTable maestros_jtmaestros;
    private javax.swing.JTextField maestros_txtbuscar;
    private javax.swing.JTextField maestros_txtdireccion;
    private javax.swing.JTextField maestros_txtid;
    private javax.swing.JTextField maestros_txtnombremaestro;
    private javax.swing.JTextField maestros_txttelefono;
    private javax.swing.JButton materias_btnbuscar;
    private javax.swing.JButton materias_btneditar;
    private javax.swing.JButton materias_btneliminar;
    private javax.swing.JButton materias_btnguardar;
    private javax.swing.JButton materias_btnnuevo;
    private javax.swing.JComboBox<String> materias_cbacademia;
    private javax.swing.JComboBox<String> materias_cbidcarrera;
    public javax.swing.JPanel materias_tb;
    private javax.swing.JTextField materias_txtbuscar;
    private javax.swing.JTextField materias_txtcreditos;
    private javax.swing.JTextField materias_txtid;
    private javax.swing.JTextField materias_txtnombremateria;
    private javax.swing.JButton semestre_btnbuscar;
    private javax.swing.JButton semestre_btneditar;
    private javax.swing.JButton semestre_btneliminar;
    private javax.swing.JButton semestre_btnguardar;
    private javax.swing.JButton semestre_btnnuevo;
    private javax.swing.JComboBox<String> semestre_cbperiodo;
    private javax.swing.JLabel semestre_fechaf;
    private javax.swing.JLabel semestre_fechai;
    private com.toedter.calendar.JDateChooser semestre_jdcfechafinal;
    private com.toedter.calendar.JDateChooser semestre_jdcfechainicio;
    private javax.swing.JTextField semestre_txtbuscar;
    private javax.swing.JTextField semestre_txtid;
    private javax.swing.JButton usuarios_btnbuscar;
    private javax.swing.JButton usuarios_btneditar;
    private javax.swing.JButton usuarios_btneliminar;
    private javax.swing.JButton usuarios_btnguardar;
    private javax.swing.JButton usuarios_btnnuevo;
    private javax.swing.JComboBox<String> usuarios_cbperfil;
    private javax.swing.JTextField usuarios_txtapellidomaterno;
    private javax.swing.JTextField usuarios_txtapellidopaterno;
    private javax.swing.JTextField usuarios_txtbuscar;
    private javax.swing.JTextField usuarios_txtconfirmarcontraseña;
    private javax.swing.JTextField usuarios_txtcontraseña;
    private javax.swing.JTextField usuarios_txtid;
    private javax.swing.JTextField usuarios_txtnombre;
    private javax.swing.JTextField usuarios_txtnombreusuario;
    // End of variables declaration//GEN-END:variables
}
