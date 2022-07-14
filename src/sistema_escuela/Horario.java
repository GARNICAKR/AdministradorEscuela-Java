/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_escuela;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import static java.lang.Character.isDigit;
import java.util.Random;

/**
 *
 * @author BBVAControl
 */
public class Horario {
            int id;
    String periodo,fecha_i,fecha_fin;
    public String Read(){
    String temp="";
    String brRead;
            try{
                FileReader fr=new FileReader("C:\\Users\\dell\\Desktop\\Sistema_Escuela_Definitivo\\txts\\horario.txt");
                BufferedReader br=new BufferedReader(fr);
                while((brRead=br.readLine())!=null){
                    temp+=brRead+"\n";
                }
            }catch(Exception e){
                
            }
            return temp;
           
}
    public int ObContProfe(String texto,String id){
             String aux="";
        String linea="";
        int contlineas=0;
        String[] lineas =new String[10];
        int b=0;boolean band=false;
        int a=0,l=0;
        for(int i=0;i<texto.length();i++){
            if(texto.charAt(i)=='°'){
                a++;
            }
            if(texto.charAt(i)=='#'){
            b=1;
            }else{
                linea=linea+texto.charAt(i);
            }
            if(a==6){
                if(l==0){l=1;}else{
                    if(texto.charAt(i)!='#'){
            aux=aux+texto.charAt(i);
                    }
                }
            }
            if(b==1){
               if(aux.equals(id)){
                lineas[contlineas]= linea;
                contlineas++;
                band=true;
                linea="";b=0;a=0;l=0;aux="";
                }else{
                   linea="";
                   aux="";
                   b=0;
                   a=0;l=0;
               }
            }
        }
        if(band==true){
        Random rand = new Random();
        int N=rand.nextInt(contlineas);
        linea=lineas[N];
        linea+="°"+"#";
        
                }
        return contlineas;
}
 public String ObProfePos(String texto,String id,int pos){
             String aux="";
        String linea="";
        int contlineas=0;
        String[] lineas =new String[10];
        int b=0;boolean band=false;
        int a=0,l=0;
        for(int i=0;i<texto.length();i++){
            if(texto.charAt(i)=='°'){
                a++;
            }
            if(texto.charAt(i)=='#'){
            b=1;
            }else{
                linea=linea+texto.charAt(i);
            }
            if(a==6){
                if(l==0){l=1;}else{
                    if(texto.charAt(i)!='#'){
            aux=aux+texto.charAt(i);
                    }
                }
            }
            if(b==1){
               if(aux.equals(id)){
                lineas[contlineas]= linea;
                contlineas++;
                band=true;
                linea="";b=0;a=0;l=0;aux="";
                }else{
                   linea="";
                   aux="";
                   b=0;
                   a=0;l=0;
               }
            }
        }
        if(band==true){
        Random rand = new Random();
        int N=rand.nextInt(contlineas);
        linea=lineas[pos];
        linea+="°"+"#";
        return linea;
                }
        return "no encontrado";
}   
        public String ObProfe(String texto,String id){
             String aux="";
        String linea="";
        int contlineas=0;
        String[] lineas =new String[10];
        int b=0;boolean band=false;
        int a=0,l=0;
        for(int i=0;i<texto.length();i++){
            if(texto.charAt(i)=='°'){
                a++;
            }
            if(texto.charAt(i)=='#'){
            b=1;
            }else{
                linea=linea+texto.charAt(i);
            }
            if(a==6){
                if(l==0){l=1;}else{
                    if(texto.charAt(i)!='#'){
            aux=aux+texto.charAt(i);
                    }
                }
            }
            if(b==1){
               if(aux.equals(id)){
                lineas[contlineas]= linea;
                contlineas++;
                band=true;
                linea="";b=0;a=0;l=0;aux="";
                }else{
                   linea="";
                   aux="";
                   b=0;
                   a=0;l=0;
               }
            }
        }
        if(band==true){
        Random rand = new Random();
        int N=rand.nextInt(contlineas);
        linea=lineas[N];
        linea+="°"+"#";
        return linea;
                }
        return "no encontrado";
}
 public String Buscar(String texto,String id){
        String aux="";
        String linea="";
        int b=0;
        int a=0;
        for(int i=0;i<texto.length();i++){
            if(texto.charAt(i)=='°'){
                a=1;
            }
            if(texto.charAt(i)=='#'){
            b=1;
            }else{
                linea=linea+texto.charAt(i);
            }
            if(isDigit(texto.charAt(i)) && a==0){
            aux=aux+texto.charAt(i);
            }
            if(b==1){
               if(aux.equals(id)){
                return linea;
                }else{
                   linea="";
                   aux="";
                   b=0;
                   a=0;
               }
            }
        }
        return "no encontrado";
    }
    
    public boolean CpIdg(String texto,String id,String horario ){
                     String aux="";
                           int  aux2=0;
        String linea="",horario2="";
        
        int b=0;boolean band=false;
        int a=0,l=0;
        for(int i=0;i<texto.length();i++){
            if(texto.charAt(i)=='°'){
                a++;
            }
            if(texto.charAt(i)=='#'){
            b=1;
            }else{
                linea=linea+texto.charAt(i);
            }
            if(a==1){
                if(l==0){l=1;}else{
                    aux=aux+texto.charAt(i);
                  
                    
                    
            
                }
            }
            if(b==1){
               if(aux.equals(id)){
                band=true;
                  for(int j=0;j<linea.length();j++){
                if(linea.charAt(j)=='°'){
                    aux2++;
                }
                if(linea.charAt(j)!='°'){
                 
                  if(aux2==4){
                        horario2+=linea.charAt(j);
                    }
                  
                  
                  
                }
                }
                  if(horario2.equals(horario)){
                      return true;
                  }
                linea="";b=0;a=0;l=0;aux="";aux2=0;horario2="";
                }else{
                   linea="";
                   aux="";
                   b=0;
                   a=0;l=0;
                   aux2=0;horario="";
               }
            }
        }
       return false;
    }
    
    public boolean CpM(String texto,String id,String horario ){
                     String aux="";
                           int  aux2=0;
        String linea="",horario2="";
        
        int b=0;boolean band=false;
        int a=0,l=0;
        for(int i=0;i<texto.length();i++){
            if(texto.charAt(i)=='°'){
                a++;
            }
            if(texto.charAt(i)=='#'){
            b=1;
            }else{
                linea=linea+texto.charAt(i);
            }
            if(a==3){
                if(l==0){l=1;}else{
                    aux=aux+texto.charAt(i);
                  
                    
                    
            
                }
            }
            if(b==1){
               if(aux.equals(id)){
                band=true;
                  for(int j=0;j<linea.length();j++){
                if(linea.charAt(j)=='°'){
                    aux2++;
                }
                if(linea.charAt(j)!='°'){
                 
                  if(aux2==4){
                        horario2+=linea.charAt(j);
                    }
                  
                  
                  
                }
                }
                  if(horario2.equals(horario)){
                      return true;
                  }
                linea="";b=0;a=0;l=0;aux="";aux2=0;horario2="";
                }else{
                   linea="";
                   aux="";
                   b=0;
                   a=0;l=0;aux2=0;horario2="";
               }
            }
        }
       return false;
    }
    public String Buscar2(String texto,String id){
        String aux="";
        int id2=Integer.parseInt(id);
        String linea="";
        int b=0;
        int a=0;
        for(int i=0;i<texto.length();i++){
            if(texto.charAt(i)=='°'){
                a=1;
            }
            if(texto.charAt(i)=='#'){
            b=1;
            }
            linea=linea+texto.charAt(i);
            if(isDigit(texto.charAt(i)) && a==0){
            aux=aux+texto.charAt(i);
            }
            if(b==1){
            int z=Integer.parseInt(aux);
               if(id2==z){
                return linea;
                }else{
                   linea="";
                   aux="";
                   b=0;
                   a=0;
               }
            }
        }
        return "no encontrado";
    }
    
    public void Write(String texto){
             try{
                FileWriter fw=new FileWriter("C:\\Users\\dell\\Desktop\\Sistema_Escuela_Definitivo\\txts\\horario.txt",true);
                PrintWriter pw=new PrintWriter(fw); 
                pw.write(texto);
                pw.close();
            }catch(Exception e){
                
            }
}
    
     public void Write2(String texto){
             try{
                FileWriter fw=new FileWriter("C:\\Users\\dell\\Desktop\\Sistema_Escuela_Definitivo\\txts\\horario.txt",false);
                PrintWriter pw=new PrintWriter(fw); 
                pw.write(texto);
                pw.close();
            }catch(Exception e){
                
            }
}
}
