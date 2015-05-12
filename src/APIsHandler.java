
import java.util.HashMap;
import java.util.Map;
import org.apache.thrift.TException;
import thriftDemo.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sonle
 */
public class APIsHandler implements APIs.Iface {
    ServerManager serverManager = new ServerManager(0, new HashMap<String, Integer>());
    
    @Override
    public void put(String _username, int _newValue) throws TException {
        Map<String,Integer> userAccessCounter = serverManager.getUserAccessCounter();
        userAccessCounter.put(_username, +_newValue);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void increase(String _username) throws TException {
        serverManager.setTotalAccessCounter(serverManager.getTotalAccessCounter() + 1);
        Map<String,Integer> userAccessCounter = serverManager.getUserAccessCounter();
        if (userAccessCounter.containsKey(_username)){
            int currentCounter = userAccessCounter.get(_username);
            userAccessCounter.put(_username, ++currentCounter);
        }
        else {
            userAccessCounter.put(_username, 1);
        }
        
        System.out.println("===================");
        System.out.println("username: " + _username);
        System.out.println("counter: " + userAccessCounter.get(_username));
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int get(String _username) throws TException {
        Map<String,Integer> userAccessCounter = serverManager.getUserAccessCounter();
        return userAccessCounter.get(_username);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
