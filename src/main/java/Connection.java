/**
 * Created by eugenevendensky on 2/2/17.
 */
public interface Connection {
    String getIP();
    String getPort();
    Protocol getProtocol();
    String connect();
}
