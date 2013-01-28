package fr.inria.phoenix.diasuite.framework.distributed.ptzvideocamera;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;


public final class ImageFromPTZVideoCamera implements Serializable {
    private static final long serialVersionUID = 0;
  
  private fr.inria.phoenix.diasuite.framework.datatype.file.File value;

  public fr.inria.phoenix.diasuite.framework.datatype.file.File value(){
    return value;
  }

  public ImageFromPTZVideoCamera(Service service, RemoteServiceInfo remoteServiceInfo, fr.inria.phoenix.diasuite.framework.datatype.file.File value) {
    this.sender = new PTZVideoCameraProxy(service, remoteServiceInfo);
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
      ImageFromPTZVideoCamera other = (ImageFromPTZVideoCamera) obj;
      if (value == null) {
        if (other.value != null)
          return false;
      } else if (!value.equals(other.value))
        return false; 

      return true;
    }

  private PTZVideoCameraProxy sender;
  
  public PTZVideoCameraProxy sender() {
    return sender;
  }

  public class PTZVideoCameraProxy extends Proxy {
    private PTZVideoCameraProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
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


    public void subscribeImage() {
      getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "image");
    }

    public void unsubscribeImage() {
      getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "image");
    }
  }

}