package fr.inria.phoenix.diasuite.framework.distributed.smssender;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;


public final class QuestionAnswerFromSMSSender implements Serializable {
    private static final long serialVersionUID = 0;
  
  private java.lang.String value;

  public java.lang.String value(){
    return value;
  }

  public QuestionAnswerFromSMSSender(Service service, RemoteServiceInfo remoteServiceInfo, java.lang.String value, QuestionAnswerIndices indices) {
    this.sender = new SMSSenderProxy(service, remoteServiceInfo);
    this.value = value;
    this.indices = indices;
  }
  
  public QuestionAnswerFromSMSSender(Service service, RemoteServiceInfo remoteServiceInfo, java.lang.String value, java.lang.String questionId) {
    this.sender = new SMSSenderProxy(service, remoteServiceInfo);
    this.value = value;
    this.indices = new QuestionAnswerIndices(questionId);
  }
  
  private QuestionAnswerIndices indices;
  
  public QuestionAnswerIndices indices(){
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
      QuestionAnswerFromSMSSender other = (QuestionAnswerFromSMSSender) obj;
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

  private SMSSenderProxy sender;
  
  public SMSSenderProxy sender() {
    return sender;
  }

  public class SMSSenderProxy extends Proxy {
    private SMSSenderProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
      super(service, remoteServiceInfo);
    }


    public java.lang.String id() {
      return (java.lang.String) getService().getProcessor().callGetValue(getService().getOutProperties(), getRemoteServiceInfo(), "id");
    }


    public void subscribeQuestionAnswer() {
      getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "questionAnswer");
    }

    public void unsubscribeQuestionAnswer() {
      getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "questionAnswer");
    }
  }

}