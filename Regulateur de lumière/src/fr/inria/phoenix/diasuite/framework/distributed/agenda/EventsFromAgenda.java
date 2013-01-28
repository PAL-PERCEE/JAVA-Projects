package fr.inria.phoenix.diasuite.framework.distributed.agenda;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;


public final class EventsFromAgenda implements Serializable {
    private static final long serialVersionUID = 0;
  
  private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent> value;

  public java.util.List<fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent> value(){
    return value;
  }

  public EventsFromAgenda(Service service, RemoteServiceInfo remoteServiceInfo, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent> value, EventsIndices indices) {
    this.sender = new AgendaProxy(service, remoteServiceInfo);
    this.value = value;
    this.indices = indices;
  }
  
  public EventsFromAgenda(Service service, RemoteServiceInfo remoteServiceInfo, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent> value, fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent filter) {
    this.sender = new AgendaProxy(service, remoteServiceInfo);
    this.value = value;
    this.indices = new EventsIndices(filter);
  }
  
  private EventsIndices indices;
  
  public EventsIndices indices(){
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
      EventsFromAgenda other = (EventsFromAgenda) obj;
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

  private AgendaProxy sender;
  
  public AgendaProxy sender() {
    return sender;
  }

  public class AgendaProxy extends Proxy {
    private AgendaProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
      super(service, remoteServiceInfo);
    }


    public java.lang.String id() {
      return (java.lang.String) getService().getProcessor().callGetValue(getService().getOutProperties(), getRemoteServiceInfo(), "id");
    }

    public java.lang.String owner() {
      return (java.lang.String) getService().getProcessor().callGetValue(getService().getOutProperties(), getRemoteServiceInfo(), "owner");
    }


    public void subscribeEvents() {
      getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "events");
    }

    public void unsubscribeEvents() {
      getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "events");
    }
  }

}