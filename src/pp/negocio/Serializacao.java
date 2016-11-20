package pp.negocio;

import java.io.*;

public class Serializacao {
    public static boolean guardarObjecto(Object obj, String ficheiroDestino){
        boolean retValue = true;
        
        try{
            FileOutputStream fileOut = new FileOutputStream(ficheiroDestino);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            out.close();
            fileOut.close();            
      }catch(IOException i){
          retValue = false;
      }
        
      return retValue;        
    }
    
    
     public static Object lerObjecto(String ficheiro){
        Object retValue = null;
        
        try{
            FileInputStream fileIn = new FileInputStream(ficheiro);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            retValue = in.readObject();
            in.close();
            fileIn.close();            
      }catch(Exception e){           
      }
        
      return retValue;        
    }
            
}