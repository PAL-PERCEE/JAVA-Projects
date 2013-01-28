package fr.inria.phoenix.diasuite.framework.distributed.agenda;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;


/**
 * 
 *
 * @[386,0]
 * device Agenda extends HomeService {
 *   attribute owner as String;
 *   source currentEvent as AgendaEvent;
 *   source nextEvent as AgendaEvent;
 *   source events as AgendaEvent[] indexed by filter as AgendaEvent;
 *   action AgendaEventAction;
 * }
 */
public abstract class AbstractAgenda extends Service {

    public AbstractAgenda(ServiceConfiguration serviceConfiguration , java.lang.String id, java.lang.String owner) {
      super("/Device/Device/Service/HomeService/Agenda/", serviceConfiguration);
      updateId(id);
      updateOwner(owner);
    }

    @Override
    public final java.util.Map<String, Object> getAttributesCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source) {
        java.util.Map<String, Object> attributes = new java.util.HashMap<String, Object>();
        attributes.put("id",id);
        attributes.put("owner",owner);

        return attributes;
    }
    
        
        private java.lang.String id;

        /**
         * @[293,11]
         * attribute id as String;
         * @param newIdValue
         */
        protected void updateId(java.lang.String newIdValue) {
          if (id != newIdValue) {
            id = newIdValue;
            updateAttribute("id", newIdValue);
          }
        }

        /**
         * @[293,11]
         * attribute id as String;
         * @return
         */  
        public java.lang.String getId() {
          return id;
        }

        private java.lang.String owner;

        /**
         * @[387,11]
         * attribute owner as String;
         * @param newOwnerValue
         */
        protected void updateOwner(java.lang.String newOwnerValue) {
          if (owner != newOwnerValue) {
            owner = newOwnerValue;
            updateAttribute("owner", newOwnerValue);
          }
        }

        /**
         * @[387,11]
         * attribute owner as String;
         * @return
         */  
        public java.lang.String getOwner() {
          return owner;
        }


  protected final void internalPostInitialize() {postInitialize();}

        /**
         * 
         */
        protected abstract void removeEvent(fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent event) throws Exception;

        /**
         * 
         */
        protected abstract void replaceEvent(fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent oldEvent, fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent newEvent) throws Exception;

        /**
         * 
         */
        protected abstract void addEvent(fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent event) throws Exception;


        private fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent _currentEvent;
        /**
         * @[388,1]
         * source currentEvent as AgendaEvent;
         */  
        protected void publishCurrentEvent(fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent newCurrentEventValue ) {
          _currentEvent = newCurrentEventValue;
          getProcessor().publishValue(getOutProperties(), "currentEvent", newCurrentEventValue); 
        }

        /**
         * @[388,1]
         * source currentEvent as AgendaEvent;
         */
        protected fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent getCurrentEvent() throws Exception{
          return _currentEvent;    }
        private fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent _nextEvent;
        /**
         * @[389,1]
         * source nextEvent as AgendaEvent;
         */  
        protected void publishNextEvent(fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent newNextEventValue ) {
          _nextEvent = newNextEventValue;
          getProcessor().publishValue(getOutProperties(), "nextEvent", newNextEventValue); 
        }

        /**
         * @[389,1]
         * source nextEvent as AgendaEvent;
         */
        protected fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent getNextEvent() throws Exception{
          return _nextEvent;    }
        private java.util.HashMap<EventsIndices,java.util.List<fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent>> _events = new java.util.HashMap<EventsIndices,java.util.List<fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent>>();
        /**
         * @[390,1]
         * source events as AgendaEvent[] indexed by filter as AgendaEvent;
         */  
        protected void publishEvents(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent> newEventsValue , fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent filter) {
          EventsIndices _indices_ = new EventsIndices(filter);
          _events.put(_indices_,newEventsValue);
          getProcessor().publishValue(getOutProperties(), "events", newEventsValue
    			, filter ); 
        }

        /**
         * @[390,1]
         * source events as AgendaEvent[] indexed by filter as AgendaEvent;
         */
        protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent> getEvents(fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent filter) throws Exception{
          return _events.get(new EventsIndices(filter));    }
 

  public final Object orderCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("removeEvent")) {
          removeEvent((fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent)args[0]);
          return null;
        } else     if (orderName.equals("replaceEvent")) {
          replaceEvent((fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent)args[0], (fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent)args[1]);
          return null;
        } else     if (orderName.equals("addEvent")) {
          addEvent((fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent)args[0]);
          return null;
        } 
    throw new InvocationException("Undefined method name " + orderName);
  }
  
  public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("currentEvent")) {
          return getCurrentEvent();
        } else     if (orderName.equals("nextEvent")) {
          return getNextEvent();
        } else     if (orderName.equals("events")) {
          return getEvents((fr.inria.phoenix.diasuite.framework.datatype.agendaevent.AgendaEvent)args[0]);
        }

       if (orderName.equals("id")) {
         return id;
       } else      if (orderName.equals("owner")) {
         return owner;
       }
    
    throw new InvocationException("Undefined method name " + orderName);
  }
    
}