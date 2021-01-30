
package calculoimc;


public class IMC {

       
    private int nss;
    private String nombre;
    private double peso;
    private double altura; 
    private double imc;
     double r;
    
    public IMC(int nss, String nombre, double peso, double altura) throws NumeroIncorrecto{
        this.nss = nss;
        String x= Integer.toString(nss);;
         if( x.length() != 5 )
           throw new NumeroIncorrecto ();
        this.nombre = nombre;
        this.peso = peso;
        if(peso < 0 || peso > 700){
            throw new  ArithmeticException();
        }
        this.altura = altura;
        if(altura < 0 || altura > 3.0){
            throw new  ArithmeticException("altura no valida");
        }
    }

    public int getNss() {
        return nss;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setNss(int nss) {
        this.nss = nss;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    public double calcularImc (){
       
        r = getPeso() / Math.pow(getAltura(), 2) ;
        imc=r;
        return r ;
    }
     
    public String categoria(){
        String cat = "";
        if (r < 18.5){
             cat= "Bajo peso";          
          }
        
        if ( r >= 18.5 && r < 25){
             cat= "peso normal";          
          }       
        if ( r >= 25 && r < 30){
             cat= "sobrepeso ";          
          }
        if ( r >= 30 && r < 35){
             cat= "Obesidad grado l";          
          }
        if ( r >= 35 && r < 40){
             cat= "Obesidad grado 2";          
          }
        if ( r >= 40){
             cat= "Obesidad grado 3 ";          
          }
         return cat ;
    }
    public String toString(){
        return nss+" "+nombre+" "+"Peso: "+peso+"  "+"Altura: "+altura+" "+"IMC: "+imc;
    }
}
