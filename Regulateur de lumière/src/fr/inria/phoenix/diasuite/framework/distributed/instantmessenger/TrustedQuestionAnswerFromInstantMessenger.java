package fr.inria.phoenix.diasuite.framework.distributed.instantmessenger;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;


public final class TrustedQuestionAnswerFromInstantMessenger implements Serializable {
    private static final long serialVersionUID = 0;
  
  private java.lang.String value;

  public java.lang.String value(){
    return value;
  }

  public TrustedQuestionAnswerFromInstantMessenger(Service service, RemoteServiceInfo remoteServiceInfo, java.lang.String value, TrustedQuestionAnswerIndices indices) {
    this.sender = new InstantMessengerProxy(service, remoteServiceInfo);
    this.value = value;
    this.indices = indices;
  }
  
  public TrustedQuestionAnswerFromInstantMessenger(Service service, RemoteServiceInfo remoteServiceInfo, java.lang.String value, java.lang.String questionId) {
    this.sender = new InstantMessengerProxy(service, remoteServiceInfo);
    this.value = value;
    this.indices = new TrustedQuestionAnswerIndices(questionId);
  }
  
  private TrustedQuestionAnswerIndices indices;
  
  public TrustedQuestionAnswerIndices indices(){
    return indices;
  }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((value == null) ? 0 : value.hashCode());
      result = prime * result + ((indices == null) ? 0 : indices.hashCode());

      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      TrustedQuestionAnswerFromInstantMessenger other = (TrustedQuestionAnswerFromInstantMessenger) obj;
      if (value == null) {
        if (other.value != null)
          return false;
      } else if (!value.equals(other.value))
        return false; 
      if (indices == null) {
        if (other.indices != null)
          return false;
      } else if (!indices.equals(other.indices))
        return false; 

      return true;
    }

  private InstantMessengerProxy sender;
  
  public InstantMessengerProxy sender() {
    return sender;
  }

  public class InstantMessengerProxy extends Proxy {
    private InstantMessengerProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
      super(service, remoteServiceInfo);
    }


    public java.lang.String id() {
      return (java.lang.String) getService().getProcessor().callGetValue(getService().getOutProperties(), getRemoteServiceInfo(), "id");
    }


    public void subscribeTrustedQuestionAnswer() {
      getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "trustedQuestionAnswer");
    }

    public void unsubscribeTrustedQuestionAnswer() {
      getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "trustedQuestionAnswer");
    }
  }

}