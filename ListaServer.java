import java.rmi.*;
public class ListaServer
{ public static void main(String[] arg)
  { try
    { Naming.rebind("Lista", new ListaImpl());
    }
    catch(Exception e)
    { e.printStackTrace();
    }
  }
}
