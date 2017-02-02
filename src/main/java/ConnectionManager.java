import java.util.ArrayList;

/**
 * Created by eugenevendensky on 2/2/17.
 */
public class ConnectionManager {
    static int numberOfConnections;
    int maxNumberOfConnections = numberOfConnections;
    public ConnectionManager(int maxNumberOfConnections){
        this.maxNumberOfConnections = maxNumberOfConnections;
    }
    public ConnectionManager(){}
    static ArrayList<Connection> connections = new java.util.ArrayList<Connection>();
    public Connection getConnection(String iP, String port){
        numberOfConnections++;  //make if when you find what the max number of connections is
        if(numberOfConnections>maxNumberOfConnections) {
          System.out.println("Adding this connection will exceed the maximum number of allowed connection");
          return null;
        }
        Connection connection = new ManagedConnection(iP, port);
        return connection;
    }
    public Connection getConnection(String iP, String port, Protocol protocol){
        numberOfConnections++;
        if(numberOfConnections>maxNumberOfConnections) {
            System.out.println("Adding this connection will exceed the maximum number of allowed connection");
            return null;
        }
        //make if when you find what the max number of connections is
        Connection connection = new ManagedConnection(iP, port, protocol);
        return connection;
    }

    class ManagedConnection implements Connection{
        String IP;
        String port;
        Protocol Protocol;


        private ManagedConnection(String ip, String port){
            this.IP = ip;
            this.port = port;
        }
        private ManagedConnection(String ip, String port, Protocol protocol){
            this.IP = ip;
            this.port = port;
            this.Protocol = protocol;
        }


        @Override
        public String getIP() {
            return this.IP;
        }

        @Override
        public String getPort() {
            return this.port;
        }

        @Override
        public Protocol getProtocol() {
            return this.Protocol;
        }
        public String connect(){
            String connect = "You are connected to " + this.getIP() + ":" + this.getPort() + " via " + getProtocol();
            return connect;
        }
    }


}
