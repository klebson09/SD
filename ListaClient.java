import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.rmi.*;
import java.util.*;
public class ListaClient
{ public static void main(String[] argv)
  { //System.setSecurityManager(new RMISecurityManager());
    ListaInterface v;
    Scanner sc = new Scanner (System.in);
    String [] dir;
    try
    {
      v = (ListaInterface)Naming.lookup(
                       "rmi://192.168.101.159:1099/Lista");
      System.out.println ("Entre com o nome do diretório remoto: "); 
      String tmp = sc.next();
      dir = v.lista (tmp);
      for (int i = 0; i<= 99; i++)
      {
        if (dir[i].length() > 0)
          System.out.println ("nome do arquivo: "+ tmp +"\\" + dir[i]);
      }
      String tmp1;
	  System.out.println ("nome do arquivo a ser copiado");
	  tmp1=sc.next();
      tmp = tmp +"\\"+ tmp1;      
      
     System.out.println (tmp);
      byte[] filedata = v.downloadFile(tmp);
      File file = new File(tmp1);

       BufferedOutputStream output = new
           BufferedOutputStream(new FileOutputStream(file.getName()));
      output.write(filedata,0,filedata.length); 
      output.flush();
      output.close();
    }
    catch(Exception e) { /*...*/ }
  }
}

