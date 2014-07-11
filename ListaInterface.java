import java.rmi.*;
import java.io.File;

public interface ListaInterface extends java.rmi.Remote
{ public String [] lista(String dir) throws java.rmi.RemoteException; 
  public void reset() throws java.rmi.RemoteException;
  public byte [] downloadFile (String fileNAme) throws java.rmi.RemoteException;
 
}
