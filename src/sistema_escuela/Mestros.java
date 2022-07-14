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

/**
 *
 * @author BBVAControl
 */
public class Mestros {
        int id;
    String periodo,fecha_i,fecha_fin;
    public String Read(){
    String temp="";
    String brRead;
            try{
                FileReader fr=new FileReader("C:\\Users\\dell\\Desktop\\Sistema_Escuela_Definitivo\\txts\\maestros.txt");
                BufferedReader br=new BufferedReader(fr);
                while((brRead=br.readLine())!=null){
                    temp+=brRead+"\n";
                }
            }catch(Exception e){
                
            }
            return temp;
           
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
                FileWriter fw=new FileWriter("C:\\Users\\dell\\Desktop\\Sistema_Escuela_Definitivo\\txts\\maestros.txt",true);
                PrintWriter pw=new PrintWriter(fw); 
                pw.write(texto);
                pw.close();
            }catch(Exception e){
                
            }
}
    
     public void Write2(String texto){
             try{
                FileWriter fw=new FileWriter("C:\\Users\\dell\\Desktop\\Sistema_Escuela_Definitivo\\txts\\maestros.txt",false);
                PrintWriter pw=new PrintWriter(fw); 
                pw.write(texto);
                pw.close();
            }catch(Exception e){
                
            }
}
}
