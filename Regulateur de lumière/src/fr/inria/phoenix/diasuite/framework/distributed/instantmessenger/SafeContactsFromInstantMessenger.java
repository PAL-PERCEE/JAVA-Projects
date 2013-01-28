package fr.inria.phoenix.diasuite.framework.distributed.instantmessenger;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;


public final class SafeContactsFromInstantMessenger implements Serializable {
    private static final long serialVersionUID = 0;
  
  private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.contact.Contact> value;

  public java.util.List<fr.inria.phoenix.diasuite.framework.datatype.contact.Contact> value(){
    return value;
  }

  public SafeContactsFromInstantMessenger(Service service, RemoteServiceInfo remoteServiceInfo, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.contact.Contact> value) {
    this.sender = new InstantMessengerProxy(service, remoteServiceInfo);
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
      SafeContactsFromInstantMessenger other = (SafeContactsFromInstantMessenger) obj;
      if (value == null) {
        if (other.value != null)
          return false;
      } else if (!value.equals(other.value))
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


    public void subscribeSafeContacts() {
      getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "safeContacts");
    }

    public void unsubscribeSafeContacts() {
      getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "safeContacts");
    }
  }

}