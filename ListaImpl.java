import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.rmi.*;
import java.rmi.server.*;
import java.io.File;
import java.io.FileInputStream;
public class ListaImpl extends UnicastRemoteObject implements ListaInterface
{ String [] dire;
  
    public ListaImpl() throws RemoteException
  { dire = new String[100]; reset();
  }

  public void reset() throws RemoteException
  { for(int c = 0; c < dire.length; c++)
      dire [c] = "";
  }

  public byte [] downloadFile (String fileName) throws RemoteException
  {
      try {
        File file = new File (fileName);
        byte [] buffer = new byte [(int)file.length()];
        BufferedInputStream entrada = new BufferedInputStream (new FileInputStream (fileName));
        entrada.read(buffer,0,buffer.length);
        entrada.close();
        return (buffer);
      }catch (Exception e)
      {
        System.out.println ("FileImpl:" + e.getMessage());
        e.printStackTrace();
        return (null);
      }

  }
 public String [] lista(String dir) throws RemoteException
 {
        File diretorio = new File(dir);
        File fList[] = diretorio.listFiles();
        System.out.println("Numero de arquivos no diretorio : " + fList.length );
        //dire = fList[0].getName();
        for ( int i = 0; i < fList.length; i++ )
        { 
         if (i<=dire.length){dire[i] = fList[i].getName();}
          else {throw new RemoteException("Indice invalido");}
        }
       //System.out.println(fList[i].getName() +" " + new Date(fList[i].lastModified()));
       return dire;
 

 }

}

