package fr.inria.phoenix.diasuite.framework.distributed.networkstorage;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;


public final class FileBrowsingFromNetworkStorage implements Serializable {
    private static final long serialVersionUID = 0;
  
  private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo> value;

  public java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo> value(){
    return value;
  }

  public FileBrowsingFromNetworkStorage(Service service, RemoteServiceInfo remoteServiceInfo, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo> value, FileBrowsingIndices indices) {
    this.sender = new NetworkStorageProxy(service, remoteServiceInfo);
    this.value = value;
    this.indices = indices;
  }
  
  public FileBrowsingFromNetworkStorage(Service service, RemoteServiceInfo remoteServiceInfo, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo> value, fr.inria.phoenix.diasuite.framework.datatype.fileinfo.FileInfo directory, fr.inria.phoenix.diasuite.framework.datatype.filetype.FileType filter) {
    this.sender = new NetworkStorageProxy(service, remoteServiceInfo);
    this.value = value;
    this.indices = new FileBrowsingIndices(directory, filter);
  }
  
  private FileBrowsingIndices indices;
  
  public FileBrowsingIndices indices(){
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
      FileBrowsingFromNetworkStorage other = (FileBrowsingFromNetworkStorage) obj;
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

  private NetworkStorageProxy sender;
  
  public NetworkStorageProxy sender() {
    return sender;
  }

  public class NetworkStorageProxy extends Proxy {
    private NetworkStorageProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
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

    public java.lang.String name() {
      return (java.lang.String) getService().getProcessor().callGetValue(getService().getOutProperties(), getRemoteServiceInfo(), "name");
    }


    public void subscribeFileBrowsing() {
      getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "fileBrowsing");
    }

    public void unsubscribeFileBrowsing() {
      getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "fileBrowsing");
    }
  }

}