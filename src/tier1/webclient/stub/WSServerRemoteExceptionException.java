
/**
 * WSServerRemoteExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package tier1.webclient.stub;

public class WSServerRemoteExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1418118114193L;
    
    private tier1.webclient.stub.WSServerStub.WSServerRemoteException faultMessage;

    
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
    

    public void setFaultMessage(tier1.webclient.stub.WSServerStub.WSServerRemoteException msg){
       faultMessage = msg;
    }
    
    public tier1.webclient.stub.WSServerStub.WSServerRemoteException getFaultMessage(){
       return faultMessage;
    }
}
    