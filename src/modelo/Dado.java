package modelo;

public class Dado {

    public int valor;
    public int semilla=32223;

    public Dado() {
        semilla = (int) (Math.random() * 6) + 1;
    }
    public int na(){
        return (int) (Math.random() * 6) + 1;      
    }

    public int generarNA() {

        /*arreglo para generar numeros pseudoaleatorios enteros */
        int arrayNA[] = new int[8];

        /*arreglo para almacenar la semilla y sus posteriores potencias*/
        char arraySemilla[] = new char[8];

        for (int i = 0; i < arrayNA.length; i++) {

            //elevo la semila al cuadrado y la convierto en string para sacar los cuatro del  medio*****//
            int intSemCuadr = (int) Math.pow(semilla, 2);
            String strSemCuad = String.valueOf(intSemCuadr);//lo paso a string 

            //********Cereo Vector***************//
            arraySemilla = this.cerearArray(arraySemilla);

            //*************convierto el string a un array de caracteres y lo guardo en   arraySemilla************//
            arraySemilla = strSemCuad.toCharArray();
           

            //-*****guardo los cuatro del medio***esto me genera un problem cuando no tengo el nº [5]*****///
            String strNuevaSem = Character.toString(arraySemilla[1]) ;

            System.out.println("ns= " + strNuevaSem);
            int nuevaSem = Integer.valueOf(strNuevaSem);
         
            arrayNA[i] = nuevaSem;
            
            semilla = nuevaSem;

        }//termina de generar los n elementos

        return arraySemilla[0];//devueve el array con los elementos generados
    }

//************metodo para cerear el Array*************no se si funcina bien
    public char[] cerearArray(char p_charArray[]) {
        for (int i = 0; i < p_charArray.length; i++) {
            p_charArray[i] = '0';
        }
        return p_charArray;
    }
    
}