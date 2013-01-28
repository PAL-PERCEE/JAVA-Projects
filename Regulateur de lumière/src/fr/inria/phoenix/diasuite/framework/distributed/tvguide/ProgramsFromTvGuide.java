package fr.inria.phoenix.diasuite.framework.distributed.tvguide;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;


public final class ProgramsFromTvGuide implements Serializable {
    private static final long serialVersionUID = 0;
  
  private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule> value;

  public java.util.List<fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule> value(){
    return value;
  }

  public ProgramsFromTvGuide(Service service, RemoteServiceInfo remoteServiceInfo, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule> value, ProgramsIndices indices) {
    this.sender = new TvGuideProxy(service, remoteServiceInfo);
    this.value = value;
    this.indices = indices;
  }
  
  public ProgramsFromTvGuide(Service service, RemoteServiceInfo remoteServiceInfo, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule> value, fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule filter) {
    this.sender = new TvGuideProxy(service, remoteServiceInfo);
    this.value = value;
    this.indices = new ProgramsIndices(filter);
  }
  
  private ProgramsIndices indices;
  
  public ProgramsIndices indices(){
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
      ProgramsFromTvGuide other = (ProgramsFromTvGuide) obj;
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

  private TvGuideProxy sender;
  
  public TvGuideProxy sender() {
    return sender;
  }

  public class TvGuideProxy extends Proxy {
    private TvGuideProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
      super(service, remoteServiceInfo);
    }


    public java.lang.String id() {
      return (java.lang.String) getService().getProcessor().callGetValue(getService().getOutProperties(), getRemoteServiceInfo(), "id");
    }


    public void subscribePrograms() {
      getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "programs");
    }

    public void unsubscribePrograms() {
      getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "programs");
    }
  }

}