package fr.inria.phoenix.diasuite.framework.distributed.timer;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;


/**
 * 
 *
 * @[326,0]
 * device Timer extends BuiltIn {
 *   source timerTriggered as String indexed by timerId as String;
 *   action ScheduleTimer;
 * }
 */
public abstract class AbstractTimer extends Service {

    public AbstractTimer(ServiceConfiguration serviceConfiguration , java.lang.String id) {
      super("/Device/Device/Service/BuiltIn/Timer/", serviceConfiguration);
      updateId(id);
    }

    @Override
    public final java.util.Map<String, Object> getAttributesCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source) {
        java.util.Map<String, Object> attributes = new java.util.HashMap<String, Object>();
        attributes.put("id",id);

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


  protected final void internalPostInitialize() {postInitialize();}

        /**
         * 
         */
        protected abstract void periodicSchedule(java.lang.String id, java.lang.Integer delayMs, java.lang.Integer periodMs) throws Exception;

        /**
         * 
         */
        protected abstract void schedule(java.lang.String id, java.lang.Integer delayMs) throws Exception;

        /**
         * 
         */
        protected abstract void cancel(java.lang.String id) throws Exception;


        private java.util.HashMap<TimerTriggeredIndices,java.lang.String> _timerTriggered = new java.util.HashMap<TimerTriggeredIndices,java.lang.String>();
        /**
         * @[327,1]
         * source timerTriggered as String indexed by timerId as String;
         */  
        protected void publishTimerTriggered(java.lang.String newTimerTriggeredValue , java.lang.String timerId) {
          TimerTriggeredIndices _indices_ = new TimerTriggeredIndices(timerId);
          _timerTriggered.put(_indices_,newTimerTriggeredValue);
          getProcessor().publishValue(getOutProperties(), "timerTriggered", newTimerTriggeredValue
    			, timerId ); 
        }

        /**
         * @[327,1]
         * source timerTriggered as String indexed by timerId as String;
         */
        protected java.lang.String getTimerTriggered(java.lang.String timerId) throws Exception{
          return _timerTriggered.get(new TimerTriggeredIndices(timerId));    }
 

  public final Object orderCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("periodicSchedule")) {
          periodicSchedule((java.lang.String)args[0], (java.lang.Integer)args[1], (java.lang.Integer)args[2]);
          return null;
        } else     if (orderName.equals("schedule")) {
          schedule((java.lang.String)args[0], (java.lang.Integer)args[1]);
          return null;
        } else     if (orderName.equals("cancel")) {
          cancel((java.lang.String)args[0]);
          return null;
        } 
    throw new InvocationException("Undefined method name " + orderName);
  }
  
  public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("timerTriggered")) {
          return getTimerTriggered((java.lang.String)args[0]);
        }

       if (orderName.equals("id")) {
         return id;
       }
    
    throw new InvocationException("Undefined method name " + orderName);
  }
    
}