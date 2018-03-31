/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;
import java.text.DecimalFormat;
import static Ventanas.Entrada1.n;
import static Ventanas.Entrada1.m;
import java.util.*;
/**
 *
 * @author aels21
 */
public class Proyecto {
    public static boolean noAcotada;
    public static final double M=99999;
    public double[][] principal;
    public int[] basicas;
    public int[] todas=new int[10000];
    public String[] basicas3;
    public String[] todas3;
    public static List<double[][]> iteraciones;
    double[] renglo0Fase1(double[] renglon0){
        for (int i = 0; i < renglon0.length; i++) {
            if(renglon0[i]==99999 ||renglon0[i]==-99999){
                renglon0[i]=1;
            }else{
                if(renglon0[i]!=0){
                    renglon0[i]=0;
                }
            }
        }
        return renglon0;
    }
    
    double[] copiar_fila(double[] a){
        double [] b = new double[a.length];
        b=inicializar_arreglo(b);
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        return b;
    }
    double[] inicializar_arreglo(double[] a){
        for (int i = 0; i < a.length; i++) {
            a[i] = 0;
        }
        return a;
    }
    double[][] inicializar_matriz(double[][] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = 0;
            }
        }
        return a;
    }
    boolean conArtificiales(String[] variables){
        for (int i = 0; i < variables.length; i++) {
            if (variables[i].charAt(9)=='R'){
                return true;
            }
        }
        return false;
    }
    String[] convertir_todas(String[] a){
        int cont=0;
        for (int i = 0; i < a.length; i++) {
            if (a[i].charAt(9)!='R'){
               cont=cont+1;
            }
        }
        String[] b =new String[cont]; 
        for (int i = 0; i < cont; i++) {
            b[i]=a[i];
        }
        return b;
    }
    double[][] holgura_exceso(double[][] matriz, String[] signos){
        int cont=0;
        for (int i = 0; i < n; i++) {
            todas[i]=1;
        }
        for (int i = 0; i < m; i++) {
            if (!(signos[i].equals("="))){
                cont++;
            }
        }
        if (cont>0) {
           double[][] nmatriz = new double[m+1][n+1+cont];
           nmatriz= inicializar_matriz(nmatriz); 
           for (int i = 0; i < m+1; i++) {
                for (int j = 0; j < n; j++) {
                    nmatriz[i][j]= matriz[i][j];
                }
            }
            for (int i = 1; i < m; i++) {
                int a=0;
                for (int j = 0; j < signos.length; j++) {
                    if(a<signos.length){
                    if (signos[a].equals(">=")){
                        nmatriz[i][n+j]=-1;
                        i=i+1;
                        a=a+1;
                        todas[n+j]=2;
                    }else{
                        if (signos[a].equals("<=")){
                            nmatriz[i][n+j]=1;
                            i=i+1;
                            a=a+1;
                            todas[n+j]=2;
                        }else{
                         i=i+1;
                         j=j-1;
                         a=a+1;
                        }
                    }
                    }
                }
            }
            for (int i = 1; i < m+1; i++) {
                    nmatriz[i][n+cont]=matriz[i][n];
            }
            return nmatriz;
        }else{            
           return matriz;
        }
    }
    //OJO MODIFICADO EL 05/10/2017
    double[] multiplicar (double a, double[] vect){
        
        double[] vector = new double[vect.length];
        for (int i = 0; i < vect.length; i++) {
            double resultado = vect[i]*a;
            //vector[i]= (double)Math.round(resultado * 100000d) / 100000d;
            vector[i]=resultado;
        }
        return vector;
    }
    double[] sumar (double[] a, double[] b){
        
        double[] vector = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            double resultado = a[i]+b[i];
            //vector[i]= (double)Math.round(resultado * 100000d) / 100000d;
            vector[i]= resultado;
        }
        return vector;
    }
    double redondear(double numero){
{
       return Math.rint(numero*100000)/100000;
}   }
    double[][] redondear_matriz(double[][] numero){
       for (int i = 0; i < numero.length; i++) {
           for (int j = 0; j < numero[i].length; j++) {
               numero[i][j]=redondear(numero[i][j]);
           }
        }    
        return numero;
    }
    double[][] forma_estandar(double[][] matriz,String[] signos){
        double[][] nmatriz;
        nmatriz= holgura_exceso(matriz,signos);
        for (int i = 1; i < m+1; i++) {
            if (nmatriz[i][nmatriz[i].length-1]<0){
                nmatriz[i]=multiplicar(-1,nmatriz[i]);
            }
        }
        
        return nmatriz;
    }
    double[][] mifase2(double[][] a, double[] b){
        double[][] matriz = new double[a.length][b.length];
        matriz = inicializar_matriz(matriz);
        for (int k = 0; k < b.length; k++) {
            matriz[0][k]=b[k];
        }
        matriz[0][matriz[0].length-1]=a[0][a[0].length-1];
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                matriz[i][j] = a[i][j];
            }
            matriz[i][matriz[i].length-1] = a[i][a[i].length-1];
        }
        return matriz;
    }
    List <String> Perm2(String[] elem, String act, int n, int r,List <String> arreglo) {
        if (n == 0) {
            arreglo.add(act);
        } else {
            for (int i = 0; i < r; i++) {
                if (!act.contains(elem[i])) { 
                    Perm2(elem, act + elem[i] + ",", n - 1, r,arreglo);
                }
            }
        }
    return arreglo;
    }
    String [][] perm3(List <String> arreglo){
        int a=n;
        String[] h = new String[arreglo.size()];
        Iterator <String> it = arreglo.iterator();
        int i=0;
        while (it.hasNext()){
            h[i]=it.next();
            i=i+1;
        }
        String[][] matriz= new String[h.length][a];
        for (int j = 0; j <h.length ; j++) {
            matriz[j]= (h[j].split(","));
        }
        return matriz;
    }
    int[][] convertir_comb(String[][] matriz){
        int[][] combinaciones = new int[matriz.length][matriz[0].length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                combinaciones[i][j]=(Integer.parseInt(matriz[i][j])-1);
            }   
        }
    return combinaciones;
    }
    double [][] copiar(double[][] m1){
        double[][] m2 = new double[m1.length][m1[0].length];
        m2=inicializar_matriz(m2);
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                m2[i][j]=m1[i][j];
            }
        }
        return m2;
    }
    String[] copiar(String[] m1){
        String[] m2 = new String[m1.length];
        for (int i = 0; i < m1.length; i++) {
              m2[i]=m1[i];
        }
        return m2;
    }
    int[] verificar(double[][] nmatriz){
       double[][] a = new double[nmatriz.length][nmatriz[0].length] ;
       double[][] b = new double[nmatriz.length][nmatriz[0].length];
       a=inicializar_matriz(a);
       b=inicializar_matriz(b);
       a=copiar(nmatriz);
       b=copiar(nmatriz);
       int[][] comb;
       int vnb;
       String[] arreglo=new String[nmatriz[0].length-1];
       vnb=(nmatriz[0].length-1)-(nmatriz.length-1);
       int[] solucion = new int[vnb];
       for (int i = 0; i < (nmatriz[0].length-1); i++) {
            int num = i+1;
            arreglo[i]= Integer.toString(num);
       }
       List <String> arreglo2 = new ArrayList<>();
       comb = convertir_comb(perm3(Perm2(arreglo,"",vnb,arreglo.length,arreglo2)));
       boolean enc=false;
       int i=0;
       while (enc==false && i<comb.length){
            b = copiar(nmatriz); 
            b = hacer_cero(comb[i],b);
            enc=prueba(b);
            i++;
       }
       if (enc==true){
           if(prueba2(b)){
                solucion= obtener_posiciones(b,(b[0].length-vnb-1));
                principal=copiar(nmatriz);
            }else{
               solucion = proceso_artificiales(nmatriz);
           }
           
       }else{
             solucion = proceso_artificiales(nmatriz); 
       }
       return solucion;
       }
    double[] emes(String[] variables,String funcion){
        double[] renglonz = new double[variables.length+1];
        renglonz = inicializar_arreglo(renglonz);
        for (int i = 0; i < variables.length; i++) {
            if(variables[i].charAt(9)=='R'){
                renglonz[i]=M;
                if(funcion.equals("Max")){
                    renglonz[i]=renglonz[i]*-1;
                }
            }else{
                renglonz[i]=principal[0][i];
            }
            renglonz[principal[0].length-1]=principal[0][principal[0].length-1];
        }
        return renglonz;
    }
    int [] proceso_artificiales(double[][] matriz){
       double[][] nmatriz = new double[matriz.length][matriz[0].length+1];
       nmatriz=inicializar_matriz(nmatriz); 
       for (int i = 0; i < matriz.length; i++) {
            nmatriz[i][nmatriz[0].length-1]=matriz[i][matriz[0].length-1];
            for (int j = 0; j < matriz[0].length-1; j++) {
                nmatriz[i][j]=matriz[i][j];
            }
        }
       double[][] b = new double[nmatriz.length][nmatriz[0].length];
       b=inicializar_matriz(b);
       b=copiar(nmatriz);
       int[][] comb;
       int vnb;
       String[] arreglo=new String[nmatriz[0].length-1];
       vnb=(nmatriz[0].length-1)-(nmatriz.length-1);
       int[] solucion = new int[vnb];
       for (int i = 0; i < (nmatriz[0].length-1); i++) {
            int num = i+1;
            arreglo[i]= Integer.toString(num);
       }
       List <String> arreglo2 = new ArrayList<>();
       comb = convertir_comb(perm3(Perm2(arreglo,"",vnb,arreglo.length,arreglo2)));
       boolean enc=false;
       boolean enc2=false;
       int i=0;
       int j=1;
       while ((enc==false && i<comb.length)||(enc2==false && i<comb.length)){
           j=1;
           while ((j<nmatriz.length && enc==false)||(enc2==false && j<nmatriz.length)){ 
            b=copiar(nmatriz);
            b = hacer_cero(comb[i],b);
            b[j][nmatriz[j].length-2]=1.0;
            enc=prueba(b);
            enc2=prueba2(b);
            j=j+1;
           }
            i++;
       }
       if (enc==true){
           solucion= verificar(b);
       }else{
            i=0;
            j=1;
            while (enc==false && i<comb.length){
                while (j<nmatriz.length && enc==false){ 
                    b=copiar(nmatriz);
                    b = hacer_cero(comb[i],nmatriz);
                    b[j][nmatriz[j].length-2]=1.0;
                    enc=prueba(b);
                    j=j+1;
                }
                i++;
            }
            if (enc==true) {
                solucion=verificar(b);
            }else{
                solucion = proceso_artificiales(nmatriz);
            }
       }
       return solucion;
    }
    int[] obtener_posiciones(double[][] matriz, int vb){
        int[] sol = new int[vb];
        for (int i = 1; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length-1; j++) {
                if (matriz[i][j]!=0) {
                    sol[i-1]=j;
                }
            }
        }
        return sol;
    }
    double[][] actualizar_matriz(double[][] m1,double[][] m2){
        double[][] m3=new double[m1.length][m1[0].length];
        m3=inicializar_matriz(m3);
        for (int i = 0; i < m2.length; i++) {
            for (int j = 0; j < m2[0].length-1; j++) {
                m3[i][j]=m2[i][j];
            }
        }
        for (int i = 0; i < m3.length; i++) {
            for (int j = m2[0].length-1; j < m3[0].length; j++) {
                m3[i][j]=m1[i][j];
            }
        }
        return m3;
    }
    String [] rellenar_basicas(int[] b, String[] t){
       
        String[] basicas = new String[b.length];
        for (int i = 0; i < b.length; i++) {
            basicas[i]=t[b[i]];
        }
        return basicas;
    }
    String [] rellenar(){
        
        String [] todas2= new String[principal[0].length-1];
        int a=1;
        int b=1;
        for (int i = 0; i < principal[0].length-1; i++) {
            if (todas[i]==1){
                todas2[i]="<html><p>X<sub>"+(i+1)+"</sub></p></html>";
            }else{
                if(todas[i]==2){
                    todas2[i]="<html><p>S<sub>"+(a)+"</sub></p></html>";
                    a=a+1;
                }else{
                    if(todas[i]==0){
                        todas2[i]="<html><p>R<sub>"+(b)+"</sub></p></html>";
                        b=b+1;
                    }
                }
            }
        }
        return todas2;
    }
    boolean prueba(double[][] matriz){
        int cont = 0;
        for (int i = 1; i <  matriz.length; i++) {
            cont=0;
            for (int j = 0; j < matriz[i].length-1; j++) {
                if (matriz[i][j]!=0) {
                    cont=cont+1;
                }
            }
            if (cont!=1) {
                return false;
            }
        }
        return true;
    }
    boolean prueba2(double[][] matriz){
        int cont = 0;
        for (int i = 1; i < matriz.length; i++) {
            cont=0;
            for (int j = 0; j < matriz[i].length-1; j++) {
                if (matriz[i][j]<0) {
                    return false;
                }
            }
        }
    return true;
    }
    double[][] hacer_cero(int[] combinaciones, double[][] matriz){
        double[][] nmatriz = matriz;
        for (int i = 1; i < matriz.length; i++) {
            for (int j = 0; j < combinaciones.length; j++) {
                nmatriz[i][combinaciones[j]]=0;
            }
        }
        return nmatriz;
    }
    
    //13/07/2017
    double[][] corregir (double valor,int pos_basica_en_matriz, double[][] matriz){
        double[] fila_z = matriz[0];
        double[] fila_valor_basica = matriz[pos_basica_en_matriz];
        fila_valor_basica = multiplicar(-1, fila_valor_basica);
        fila_valor_basica = multiplicar(valor, fila_valor_basica);
        double[] nfila_z = sumar(fila_valor_basica, fila_z);
        for (int i = 0; i < matriz[0].length; i++) {
            matriz[0][i] = nfila_z[i];
        }
        return matriz;
    }
    int obtener_posicion_basica(String basica, String[] todas){
        for (int i = 0; i < todas.length; i++) {
            if(basica.equals(todas[i])){
                return i;
            }
        }
        return -1;
    }
    double[][] regla_basicas(String[] basicas, String[] todas, double[][] matriz){
        for (int i = 0; i < basicas.length; i++) {
            int pos = obtener_posicion_basica(basicas[i], todas);
            double valor_en_renglon_z = matriz[0][pos];
            if(valor_en_renglon_z != 0){
                matriz = corregir(valor_en_renglon_z, i+1, matriz);
            }
        }
        return matriz;
    }
    
    int posicion_del_mayor(double[] candidatos){
        int pos_delmayor = 0;
        double mayor = candidatos[0];
        for (int i = 1; i < candidatos.length; i++){
            if(candidatos[i]>mayor){
                mayor = candidatos[i];
                pos_delmayor = i;
            }
        }
        return pos_delmayor;
    }
    int var_que_entra(String tipofuncion, double[] renglon_z){
        double[] candidatos = new double[renglon_z.length-1];
        candidatos = inicializar_arreglo(candidatos);
        if (tipofuncion.equals("Max")){
            for (int i = 0; i < candidatos.length; i++) {
                if(renglon_z[i] < 0){
                    candidatos[i] = renglon_z[i];
                }
            }
            candidatos = multiplicar(-1, candidatos);
            int pos_del_mayor = posicion_del_mayor(candidatos);
            return pos_del_mayor;
        }else{
            for (int i = 0; i < candidatos.length; i++) {
                if(renglon_z[i] > 0){
                    candidatos[i] = renglon_z[i];
                }
            }
            int pos_del_mayor = posicion_del_mayor(candidatos);
            return pos_del_mayor;
        }
    }
    boolean solucion_no_acotada(double[] divisores){
        for (int i = 0; i < divisores.length; i++) {
            if(divisores[i]>0){
                return false;
            }
        }
        return true;
    }
    
    double[] dividir(double[] divisor, double[] dividendo){
        double[] cociente = new double[divisor.length];
        for (int i = 0; i < divisor.length; i++) {
            if (divisor[i]<=0) {
                cociente[i] = 30000; // HAY QUE COLOCAR UN VALOR MUY GRANDE, PENDIENTE QUE VA A EXPLOTAR POR EL LIMITE DEL TIPO ENTERO 
            }else{
                cociente[i] = dividendo[i]/divisor[i];
            }            
        }
        return cociente;
    }
    int posicion_del_menor(double[] cocientes){
        int pos_delmenor = 0;
        double valor_menor = cocientes[0];
        for (int i = 1; i < cocientes.length; i++) {
            if (cocientes[i]<valor_menor) {
                valor_menor = cocientes[i];
                pos_delmenor = i;
            }
        }
        return pos_delmenor;
    }
    int var_que_sale(int pos_var_entra, double[][] matriz){
        double[] dividendos = new double[matriz.length-1];
        dividendos = inicializar_arreglo(dividendos);
        for (int i = 1; i < matriz.length; i++) {
            dividendos[i-1] = matriz[i][matriz[0].length-1];
        }
        double[] divisores = new double[matriz.length-1];
        divisores = inicializar_arreglo(divisores);
        for (int i = 1; i < matriz.length; i++) {
            divisores[i-1] = matriz[i][pos_var_entra];
        }
        if (solucion_no_acotada(divisores)) {
            return -1;
        }else{
            double[] cocientes = dividir(divisores, dividendos);
            // PENDIENTE EVALUAR CASO EN QUE HAYAN VARIAS QUE SALEN Y SE CONVIERTA EN UN CICLO INFINITO.
            int pos_del_menor_cociente = posicion_del_menor(cocientes);
            return pos_del_menor_cociente+1;
        }
    }
    boolean parada(String tipofuncion, double[] renglonz){
        if (tipofuncion.equals("Max")){
            for (int i = 0; i < renglonz.length-1; i++) {
                if(renglonz[i]<0){
                    return false;
                }
            }
            return true;
        }else{
            for (int i = 0; i < renglonz.length-1; i++) {
                if(renglonz[i]>0){
                   return false;
                }
            }
            return true;
        }
    }
    
    //17/07/2017
    
    
    double[][] metodo_simplex(String[] basicas2, String[] todas2, double[][] matriz, String tipofuncion){
        
        
        iteraciones = new ArrayList<>();
        double[][] nmatriz = matriz;
        
        nmatriz[0] = multiplicar(-1,nmatriz[0]);
        nmatriz = regla_basicas(basicas2, todas2, nmatriz);
        boolean parar;
        parar = parada(tipofuncion, nmatriz[0]);
        
        int j = var_que_entra(tipofuncion,nmatriz[0]);
        int i = var_que_sale(j,nmatriz);
        double[][] nuevamatriz = copiar(nmatriz);
        iteraciones.add(nuevamatriz);
        while(!parar){
            
            String entra = todas2[j];
            basicas2[i-1]=entra;
                if(nmatriz[i][j]!=1){
                    nmatriz[i] = multiplicar((1/nmatriz[i][j]),nmatriz[i]);
                }
                double[] fila_pivote = nmatriz[i];
                for (int k = 0; k < nmatriz.length; k++) {
                    if(k!=i){
                        if(nmatriz[k][j]!=0){
                            fila_pivote = multiplicar((-1)*(nmatriz[k][j]), fila_pivote);
                            nmatriz[k]=sumar(fila_pivote, nmatriz[k]);
                            fila_pivote = nmatriz[i];
                     }
                    }
                }
            //nmatriz = redondear_matriz(nmatriz);    
            parar = parada(tipofuncion, nmatriz[0]);
            j = var_que_entra(tipofuncion,nmatriz[0]);
            i = var_que_sale(j,nmatriz);
            
            if(i==-1){
                parar=true;
                noAcotada = true;
                System.out.println("Solucion no acotada por: "+todas[j]);
            }
            double[][] nuevamatriz2 = copiar(nmatriz);
            iteraciones.add(nuevamatriz2);
        }
        basicas3= basicas2;
        todas3=todas2;
        return nmatriz;
    }
   
}
