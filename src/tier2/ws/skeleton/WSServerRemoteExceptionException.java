
/**
 * WSServerRemoteExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package tier2.ws.skeleton;

public class WSServerRemoteExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1418117772967L;
    
    private tier2.ws.WSServerRemoteException faultMessage;

    
        public WSServerRemoteExceptionException() {
            super("WSServerRemoteExceptionException");
        }

        public WSServerRemoteExceptionException(java.lang.String s) {
           super(s);
        }

        public WSServerRemoteExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public WSServerRemoteExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(tier2.ws.WSServerRemoteException msg){
       faultMessage = msg;
    }
    
    public tier2.ws.WSServerRemoteException getFaultMessage(){
       return faultMessage;
    }
}
    