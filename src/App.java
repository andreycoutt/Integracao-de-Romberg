import java.lang.Math;

public class App {
    public static int ordem_erro = 8; // ordem do erro
    public static int numElementosPrimCol = 4; // esse numero de elementos é sempre metade da ordem do erro.

    public static void main(String[] args) throws Exception { 
            var recebe = metodoRomberg(3.0); // ISSO AQUI VAI TER QUE RECEBER UM NUMERO PROVAVELMENTE O 3 É SO PRA VER SE ESTA FUNNCIONANDO
            // System.out.println(recebe); // apenas teste, se quiser pode descomentar esse.
            // System.out.println(ordem_erro); // apenas teste pra ver se ta funcionando
            // System.out.println(numElementosPrimCol); // apenas teste pra ver se ta funcionando.
    
    }

    
    // REGRA DOS TRAPEZIOS
    public static double trapezio(double f, double a, double b, int n){  
            double soma = 0;
            double h =  a - b /  n;
            for (int i = 1; i < n; i++){
                soma += f(a + i * h);
            }    
            
            soma *=2;
            soma *=f(a);
            soma *=f(b);
            soma *= 0.5 * h;
            return soma;
     }

     // metodo de extrapolação de richardson modificado com alfa = 2, aplicado em cima da formula da regra dos trapézios
     void romberg(double coluna_F1[]){ 
            for (int i = 0; i < numElementosPrimCol - 1; i++){
                for (int j = 0; j < numElementosPrimCol - 1; j++){
                    double numero = Math.pow(2, (i + 1)  * 2) * coluna_F1[j + 1] - coluna_F1[j];
                    double denominador = Math.pow(2, (i + 1) * 2) - 1;
                    //sem o * 2 isso seria o metodo de extrapolação de richardson tradicional, mas precisa que funcione pra oH2, ja que essa é a ordem do erro da regra dos trapezios(da aproximação fornecida pela regra dos trapézios)
                    coluna_F1[j] = numero / denominador;
                }
            }
            
            System.out.format("Aproximação O(h^ %d ) =  %2f", ordem_erro, coluna_F1[0]);
    }




    // AGORA FALTA PREENCHER A COLUNA F1, OU SEJA TENHO QUE OBTER AS APROXIMAÇÕES PELA REGRA DOS TRAPÉZIOS, PRA PODER
    // PASSAR PRO METODO DE INTEGRAÇÃO DE ROMBERG



   
     private static double f(double d) {
        return 0;
    }


    public static double metodoRomberg(double x){
        
        return (-x*x);
    }
}
