
package calculoimc;

import java.io.IOException;


public class NumeroIncorrecto extends IOException {

   
    public NumeroIncorrecto() {
        super("¡No se puede continuar NSS incorrecto ! El  NSS debe ser de 5 digitos");
    }

    public NumeroIncorrecto(String msg) {
        super(msg);
    }
}
