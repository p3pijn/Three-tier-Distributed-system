
/**
 * WSServerMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
        package tier2.ws.skeleton;

        /**
        *  WSServerMessageReceiverInOut message receiver
        */

        public class WSServerMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver{


        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(msgContext);

        WSServerSkeletonInterface skel = (WSServerSkeletonInterface)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)){


        

            if("howManyItemsId".equals(methodName)){
                
                tier2.ws.HowManyItemsIdResponse howManyItemsIdResponse11 = null;
	                        tier2.ws.HowManyItemsId wrappedParam =
                                                             (tier2.ws.HowManyItemsId)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    tier2.ws.HowManyItemsId.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               howManyItemsIdResponse11 =
                                                   
                                                   
                                                         skel.howManyItemsId(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), howManyItemsIdResponse11, false, new javax.xml.namespace.QName("http://ws.tier2",
                                                    "howManyItemsId"));
                                    } else 

            if("palletsStoredSinceStart".equals(methodName)){
                
                tier2.ws.PalletsStoredSinceStartResponse palletsStoredSinceStartResponse13 = null;
	                        tier2.ws.PalletsStoredSinceStart wrappedParam =
                                                             (tier2.ws.PalletsStoredSinceStart)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    tier2.ws.PalletsStoredSinceStart.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               palletsStoredSinceStartResponse13 =
                                                   
                                                   
                                                         skel.palletsStoredSinceStart(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), palletsStoredSinceStartResponse13, false, new javax.xml.namespace.QName("http://ws.tier2",
                                                    "palletsStoredSinceStart"));
                                    } else 

            if("howManyItemsLocation".equals(methodName)){
                
                tier2.ws.HowManyItemsLocationResponse howManyItemsLocationResponse15 = null;
	                        tier2.ws.HowManyItemsLocation wrappedParam =
                                                             (tier2.ws.HowManyItemsLocation)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    tier2.ws.HowManyItemsLocation.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               howManyItemsLocationResponse15 =
                                                   
                                                   
                                                         skel.howManyItemsLocation(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), howManyItemsLocationResponse15, false, new javax.xml.namespace.QName("http://ws.tier2",
                                                    "howManyItemsLocation"));
                                    } else 

            if("totalItems".equals(methodName)){
                
                tier2.ws.TotalItemsResponse totalItemsResponse17 = null;
	                        tier2.ws.TotalItems wrappedParam =
                                                             (tier2.ws.TotalItems)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    tier2.ws.TotalItems.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               totalItemsResponse17 =
                                                   
                                                   
                                                         skel.totalItems(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), totalItemsResponse17, false, new javax.xml.namespace.QName("http://ws.tier2",
                                                    "totalItems"));
                                    } else 

            if("placesOccupied".equals(methodName)){
                
                tier2.ws.PlacesOccupiedResponse placesOccupiedResponse19 = null;
	                        tier2.ws.PlacesOccupied wrappedParam =
                                                             (tier2.ws.PlacesOccupied)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    tier2.ws.PlacesOccupied.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               placesOccupiedResponse19 =
                                                   
                                                   
                                                         skel.placesOccupied(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), placesOccupiedResponse19, false, new javax.xml.namespace.QName("http://ws.tier2",
                                                    "placesOccupied"));
                                    
            } else {
              throw new java.lang.RuntimeException("method not found");
            }
        

        newMsgContext.setEnvelope(envelope);
        }
        } catch (WSServerRemoteExceptionException e) {

            msgContext.setProperty(org.apache.axis2.Constants.FAULT_NAME,"WSServerRemoteException");
            org.apache.axis2.AxisFault f = createAxisFault(e);
            if (e.getFaultMessage() != null){
                f.setDetail(toOM(e.getFaultMessage(),false));
            }
            throw f;
            }
        
        catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
        }
        
        //
            private  org.apache.axiom.om.OMElement  toOM(tier2.ws.HowManyItemsId param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(tier2.ws.HowManyItemsId.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(tier2.ws.HowManyItemsIdResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(tier2.ws.HowManyItemsIdResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(tier2.ws.WSServerRemoteException param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(tier2.ws.WSServerRemoteException.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(tier2.ws.PalletsStoredSinceStart param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(tier2.ws.PalletsStoredSinceStart.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(tier2.ws.PalletsStoredSinceStartResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(tier2.ws.PalletsStoredSinceStartResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(tier2.ws.HowManyItemsLocation param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(tier2.ws.HowManyItemsLocation.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(tier2.ws.HowManyItemsLocationResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(tier2.ws.HowManyItemsLocationResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(tier2.ws.TotalItems param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(tier2.ws.TotalItems.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(tier2.ws.TotalItemsResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(tier2.ws.TotalItemsResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(tier2.ws.PlacesOccupied param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(tier2.ws.PlacesOccupied.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(tier2.ws.PlacesOccupiedResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(tier2.ws.PlacesOccupiedResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, tier2.ws.HowManyItemsIdResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(tier2.ws.HowManyItemsIdResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private tier2.ws.HowManyItemsIdResponse wraphowManyItemsId(){
                                tier2.ws.HowManyItemsIdResponse wrappedElement = new tier2.ws.HowManyItemsIdResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, tier2.ws.PalletsStoredSinceStartResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(tier2.ws.PalletsStoredSinceStartResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private tier2.ws.PalletsStoredSinceStartResponse wrappalletsStoredSinceStart(){
                                tier2.ws.PalletsStoredSinceStartResponse wrappedElement = new tier2.ws.PalletsStoredSinceStartResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, tier2.ws.HowManyItemsLocationResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(tier2.ws.HowManyItemsLocationResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private tier2.ws.HowManyItemsLocationResponse wraphowManyItemsLocation(){
                                tier2.ws.HowManyItemsLocationResponse wrappedElement = new tier2.ws.HowManyItemsLocationResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, tier2.ws.TotalItemsResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(tier2.ws.TotalItemsResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private tier2.ws.TotalItemsResponse wraptotalItems(){
                                tier2.ws.TotalItemsResponse wrappedElement = new tier2.ws.TotalItemsResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, tier2.ws.PlacesOccupiedResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(tier2.ws.PlacesOccupiedResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private tier2.ws.PlacesOccupiedResponse wrapplacesOccupied(){
                                tier2.ws.PlacesOccupiedResponse wrappedElement = new tier2.ws.PlacesOccupiedResponse();
                                return wrappedElement;
                         }
                    


        /**
        *  get the default envelope
        */
        private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory){
        return factory.getDefaultEnvelope();
        }


        private  java.lang.Object fromOM(
        org.apache.axiom.om.OMElement param,
        java.lang.Class type,
        java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault{

        try {
        
                if (tier2.ws.HowManyItemsId.class.equals(type)){
                
                           return tier2.ws.HowManyItemsId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (tier2.ws.HowManyItemsIdResponse.class.equals(type)){
                
                           return tier2.ws.HowManyItemsIdResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (tier2.ws.WSServerRemoteException.class.equals(type)){
                
                           return tier2.ws.WSServerRemoteException.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (tier2.ws.PalletsStoredSinceStart.class.equals(type)){
                
                           return tier2.ws.PalletsStoredSinceStart.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (tier2.ws.PalletsStoredSinceStartResponse.class.equals(type)){
                
                           return tier2.ws.PalletsStoredSinceStartResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (tier2.ws.WSServerRemoteException.class.equals(type)){
                
                           return tier2.ws.WSServerRemoteException.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (tier2.ws.HowManyItemsLocation.class.equals(type)){
                
                           return tier2.ws.HowManyItemsLocation.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (tier2.ws.HowManyItemsLocationResponse.class.equals(type)){
                
                           return tier2.ws.HowManyItemsLocationResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (tier2.ws.WSServerRemoteException.class.equals(type)){
                
                           return tier2.ws.WSServerRemoteException.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (tier2.ws.TotalItems.class.equals(type)){
                
                           return tier2.ws.TotalItems.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (tier2.ws.TotalItemsResponse.class.equals(type)){
                
                           return tier2.ws.TotalItemsResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (tier2.ws.WSServerRemoteException.class.equals(type)){
                
                           return tier2.ws.WSServerRemoteException.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (tier2.ws.PlacesOccupied.class.equals(type)){
                
                           return tier2.ws.PlacesOccupied.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (tier2.ws.PlacesOccupiedResponse.class.equals(type)){
                
                           return tier2.ws.PlacesOccupiedResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (tier2.ws.WSServerRemoteException.class.equals(type)){
                
                           return tier2.ws.WSServerRemoteException.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    

        /**
        *  A utility method that copies the namepaces from the SOAPEnvelope
        */
        private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env){
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
        org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
        returnMap.put(ns.getPrefix(),ns.getNamespaceURI());
        }
        return returnMap;
        }

        private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();
        if (cause != null) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        } else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }

        }//end of class
    