package fr.inria.phoenix.diasuite.framework.distributed.mailer;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;


public final class SafeContactsFromMailer implements Serializable {
    private static final long serialVersionUID = 0;
  
  private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.contact.Contact> value;

  public java.util.List<fr.inria.phoenix.diasuite.framework.datatype.contact.Contact> value(){
    return value;
  }

  public SafeContactsFromMailer(Service service, RemoteServiceInfo remoteServiceInfo, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.contact.Contact> value) {
    this.sender = new MailerProxy(service, remoteServiceInfo);
    this.value = value;
  }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((value == null) ? 0 : value.hashCode());

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
      SafeContactsFromMailer other = (SafeContactsFromMailer) obj;
      if (value == null) {
        if (other.value != null)
          return false;
      } else if (!value.equals(other.value))
        return false; 

      return true;
    }

  private MailerProxy sender;
  
  public MailerProxy sender() {
    return sender;
  }

  public class MailerProxy extends Proxy {
    private MailerProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
      super(service, remoteServiceInfo);
    }


    public java.lang.String id() {
      return (java.lang.String) getService().getProcessor().callGetValue(getService().getOutProperties(), getRemoteServiceInfo(), "id");
    }


    public void subscribeSafeContacts() {
      getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "safeContacts");
    }

    public void unsubscribeSafeContacts() {
      getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "safeContacts");
    }
  }

}