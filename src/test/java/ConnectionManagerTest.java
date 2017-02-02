import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by eugenevendensky on 2/2/17.
 */
public class ConnectionManagerTest {
    ConnectionManager connectionManager;
    @Before
    public void setUp(){connectionManager = new ConnectionManager();}

    @Test
    public void connectionManagerGetConnectionIPTest(){
        ConnectionManager.ManagedConnection managedConnection = (ConnectionManager.ManagedConnection) connectionManager.getConnection("18.131.31.214", "20834");
        System.out.println(managedConnection);
        ConnectionManager.ManagedConnection managedConnection1 = (ConnectionManager.ManagedConnection) connectionManager.getConnection("167.139.211.5", "36883", Protocol.FTP);
        System.out.println(managedConnection1);
        String expected = "18.131.31.214";
        String actual = managedConnection.getIP();
        assertEquals("I expect the expected IP to match the generated IP", actual, expected);

    }
    @Test
    public void connectionManagerGetConnectionPortTest(){
        ConnectionManager.ManagedConnection managedConnection = (ConnectionManager.ManagedConnection) connectionManager.getConnection("18.131.31.214", "20834");
        System.out.println(managedConnection);
        String expected = "20834";
        String actual = managedConnection.getPort();
        assertEquals("I expect the expected Port to match the generated Port", actual, expected);

    }
    @Test
    public void connectionManagerGetConnectionProtocolTest(){
        ConnectionManager.ManagedConnection managedConnection1 = (ConnectionManager.ManagedConnection) connectionManager.getConnection("167.139.211.5", "36883", Protocol.FTP);
        System.out.println(managedConnection1);
        Protocol expected = Protocol.FTP;
        Protocol actual = managedConnection1.getProtocol();
        assertEquals("I expect the expected Protocol to match the generated Port", actual, expected);

    }
    @Test
    public void connectionManagerGetConnectTest(){
        ConnectionManager.ManagedConnection managedConnection = (ConnectionManager.ManagedConnection) connectionManager.getConnection("18.131.31.214", "20834", Protocol.FTP);
        System.out.println(managedConnection);

        String actual = managedConnection.connect();
        String expected = "You are connected to 18.131.31.214:20834 via FTP";
        assertEquals("I expect the expected Port to match the generated Port", actual, expected);

    }
    @Test
    public void setConnectionManagerMaxPossibleIntTest(){
    ConnectionManager connectionManager = new ConnectionManager(2);
    ConnectionManager.ManagedConnection managedConnection = (ConnectionManager.ManagedConnection) connectionManager.getConnection("1:1", "1:0");
    ConnectionManager.ManagedConnection managedConnection2 = (ConnectionManager.ManagedConnection) connectionManager.getConnection("1:1", "1:0");
    ConnectionManager.ManagedConnection managedConnection3 = (ConnectionManager.ManagedConnection) connectionManager.getConnection("1:1", "1:0");
    ConnectionManager.ManagedConnection expected = null;
    ConnectionManager.ManagedConnection actual = (ConnectionManager.ManagedConnection) connectionManager.getConnection("1:1", "1:0");
    }
    @Test
    public void setConnectionManagerMaxPossibleIntTest2(){
        ConnectionManager connectionManager = new ConnectionManager(2);
        ConnectionManager.ManagedConnection managedConnection = (ConnectionManager.ManagedConnection) connectionManager.getConnection("1:1", "1:0", Protocol.FTP);
        ConnectionManager.ManagedConnection managedConnection2 = (ConnectionManager.ManagedConnection) connectionManager.getConnection("1:1", "1:0", Protocol.FTP);
        ConnectionManager.ManagedConnection managedConnection3 = (ConnectionManager.ManagedConnection) connectionManager.getConnection("1:1", "1:0", Protocol.FTP);
        ConnectionManager.ManagedConnection expected = null;
        ConnectionManager.ManagedConnection actual = (ConnectionManager.ManagedConnection) connectionManager.getConnection("1:1", "1:0");
    }
    @Test
    public void setConnectionManagerTestClosedAccount(){
        ConnectionManager connectionManager = new ConnectionManager();
        ConnectionManager.ManagedConnection managedConnection = (ConnectionManager.ManagedConnection)connectionManager.getConnection("1", "1");
        managedConnection.close();

        String expected= "Sorry this account is closed";
        String actual = managedConnection.connect();
        assertEquals(actual,expected);
    }



}
