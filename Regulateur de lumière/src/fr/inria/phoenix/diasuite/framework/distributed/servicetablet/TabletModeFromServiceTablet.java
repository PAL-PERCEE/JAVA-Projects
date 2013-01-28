package fr.inria.phoenix.diasuite.framework.distributed.servicetablet;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;


public final class TabletModeFromServiceTablet implements Serializable {
    private static final long serialVersionUID = 0;
  
  private fr.inria.phoenix.diasuite.framework.datatype.servicetabletmode.ServiceTabletMode value;

  public fr.inria.phoenix.diasuite.framework.datatype.servicetabletmode.ServiceTabletMode value(){
    return value;
  }

  public TabletModeFromServiceTablet(Service service, RemoteServiceInfo remoteServiceInfo, fr.inria.phoenix.diasuite.framework.datatype.servicetabletmode.ServiceTabletMode value) {
    this.sender = new ServiceTabletProxy(service, remoteServiceInfo);
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
      TabletModeFromServiceTablet other = (TabletModeFromServiceTablet) obj;
      if (value == null) {
        if (other.value != null)
          return false;
      } else if (!value.equals(other.value))
        return false; 

      return true;
    }

  private ServiceTabletProxy sender;
  
  public ServiceTabletProxy sender() {
    return sender;
  }

  public class ServiceTabletProxy extends Proxy {
    private ServiceTabletProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
      super(service, remoteServiceInfo);
    }


    public java.lang.String id() {
      return (java.lang.String) getService().getProcessor().callGetValue(getService().getOutProperties(), getRemoteServiceInfo(), "id");
    }

    public java.lang.String location() {
      return (java.lang.String) getService().getProcessor().callGetValue(getService().getOutProperties(), getRemoteServiceInfo(), "location");
    }

    public java.lang.String user() {
      return (java.lang.String) getService().getProcessor().callGetValue(getService().getOutProperties(), getRemoteServiceInfo(), "user");
    }


    public void subscribeTabletMode() {
      getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "tabletMode");
    }

    public void unsubscribeTabletMode() {
      getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "tabletMode");
    }
  }

}