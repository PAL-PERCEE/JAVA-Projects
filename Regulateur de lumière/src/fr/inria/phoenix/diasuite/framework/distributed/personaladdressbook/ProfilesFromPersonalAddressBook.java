package fr.inria.phoenix.diasuite.framework.distributed.personaladdressbook;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;


public final class ProfilesFromPersonalAddressBook implements Serializable {
    private static final long serialVersionUID = 0;
  
  private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile> value;

  public java.util.List<fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile> value(){
    return value;
  }

  public ProfilesFromPersonalAddressBook(Service service, RemoteServiceInfo remoteServiceInfo, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile> value, ProfilesIndices indices) {
    this.sender = new PersonalAddressBookProxy(service, remoteServiceInfo);
    this.value = value;
    this.indices = indices;
  }
  
  public ProfilesFromPersonalAddressBook(Service service, RemoteServiceInfo remoteServiceInfo, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile> value, fr.inria.phoenix.diasuite.framework.datatype.personalprofile.PersonalProfile filter) {
    this.sender = new PersonalAddressBookProxy(service, remoteServiceInfo);
    this.value = value;
    this.indices = new ProfilesIndices(filter);
  }
  
  private ProfilesIndices indices;
  
  public ProfilesIndices indices(){
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
      ProfilesFromPersonalAddressBook other = (ProfilesFromPersonalAddressBook) obj;
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

  private PersonalAddressBookProxy sender;
  
  public PersonalAddressBookProxy sender() {
    return sender;
  }

  public class PersonalAddressBookProxy extends Proxy {
    private PersonalAddressBookProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
      super(service, remoteServiceInfo);
    }


    public java.lang.String id() {
      return (java.lang.String) getService().getProcessor().callGetValue(getService().getOutProperties(), getRemoteServiceInfo(), "id");
    }

    public java.lang.String user() {
      return (java.lang.String) getService().getProcessor().callGetValue(getService().getOutProperties(), getRemoteServiceInfo(), "user");
    }


    public void subscribeProfiles() {
      getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "profiles");
    }

    public void unsubscribeProfiles() {
      getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "profiles");
    }
  }

}