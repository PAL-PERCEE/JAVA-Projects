package fr.inria.phoenix.diasuite.framework.distributed.addressbook;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;


public final class ContactsFromAddressBook implements Serializable {
    private static final long serialVersionUID = 0;
  
  private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.contact.Contact> value;

  public java.util.List<fr.inria.phoenix.diasuite.framework.datatype.contact.Contact> value(){
    return value;
  }

  public ContactsFromAddressBook(Service service, RemoteServiceInfo remoteServiceInfo, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.contact.Contact> value, ContactsIndices indices) {
    this.sender = new AddressBookProxy(service, remoteServiceInfo);
    this.value = value;
    this.indices = indices;
  }
  
  public ContactsFromAddressBook(Service service, RemoteServiceInfo remoteServiceInfo, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.contact.Contact> value, fr.inria.phoenix.diasuite.framework.datatype.contact.Contact filter) {
    this.sender = new AddressBookProxy(service, remoteServiceInfo);
    this.value = value;
    this.indices = new ContactsIndices(filter);
  }
  
  private ContactsIndices indices;
  
  public ContactsIndices indices(){
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
      ContactsFromAddressBook other = (ContactsFromAddressBook) obj;
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

  private AddressBookProxy sender;
  
  public AddressBookProxy sender() {
    return sender;
  }

  public class AddressBookProxy extends Proxy {
    private AddressBookProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
      super(service, remoteServiceInfo);
    }


    public java.lang.String id() {
      return (java.lang.String) getService().getProcessor().callGetValue(getService().getOutProperties(), getRemoteServiceInfo(), "id");
    }

    public java.lang.String owner() {
      return (java.lang.String) getService().getProcessor().callGetValue(getService().getOutProperties(), getRemoteServiceInfo(), "owner");
    }


    public void subscribeContacts() {
      getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "contacts");
    }

    public void unsubscribeContacts() {
      getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "contacts");
    }
  }

}