/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalogo.advertencias;

/**
 *
 * @author Araceli Mercado
 */
public enum Advertencias {
    NADA(0),
    ID_DUPLICADO(10),
    ID_VACIO(20),
    CAMPOS_VACIOS(30),
    RELACION_INCORRECTA(40),
    ENTIDAD_VACIA(50),
    FORMATO_INCORRECTO(60);
    
    private final int valor;
    
    private Advertencias(int valor){
        this.valor=valor;
    }
    
    public int getValor(){
        return valor;
    }
    
}


