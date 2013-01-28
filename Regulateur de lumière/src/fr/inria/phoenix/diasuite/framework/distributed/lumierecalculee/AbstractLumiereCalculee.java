package fr.inria.phoenix.diasuite.framework.distributed.lumierecalculee;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;

import java.util.Map;

import fr.inria.diagen.core.service.filter.attribute.*;
import fr.inria.diagen.core.behavioral.contract.*;
import fr.inria.diagen.core.exception.continuation.Continuation;
import fr.inria.diagen.core.service.proxy.Proxy;
import fr.inria.diagen.core.service.filter.service.ServiceFilter;
import fr.inria.diagen.core.module.event.EventSynchronizer;
import fr.inria.diagen.core.module.event.EventSynchronizerBuffer;
import fr.inria.diagen.core.module.event.EventValue;

import fr.inria.phoenix.diasuite.framework.distributed.lightsensor.LevelFromLightSensor;



/**
 * Tutorial_phoenix context
 *
 * @[20,0]
 * context LumiereCalculee as Integer {
 * source level from LightSensor;
 * }
 */
public abstract class AbstractLumiereCalculee extends Service {

    public AbstractLumiereCalculee(ServiceConfiguration serviceConfiguration) {
      super("/Context/LumiereCalculee/", serviceConfiguration);
    }

  @Override
  protected final void internalPostInitialize() {
    postInitialize();
  }

    private java.lang.Integer contextValue;

    private void setLumiereCalculee(java.lang.Integer newContextValue ) {
        contextValue = newContextValue;
        getProcessor().publishValue(getOutProperties(), "lumiereCalculee", newContextValue );
    }

    protected final java.lang.Integer getLastValue() {
        return contextValue;
    }

	protected class  LumiereCalculeeValuePublishable  {
		
		private java.lang.Integer value;
		
		public java.lang.Integer getValue() {
		  return value;
		} 
		public void setValue(java.lang.Integer value) {
		  this.value = value;
		} 
		
		
          private boolean doPublish;
          public boolean doPublish() {
		    return doPublish;
		  }
		  public void setDoPublish(boolean doPublish) {
		    this.doPublish = doPublish;
		  }

		public  LumiereCalculeeValuePublishable (
		  java.lang.Integer lumiereCalculeeValue
, boolean doPublish ) {
		  
		  this.value = lumiereCalculeeValue;
		  
            this.doPublish = doPublish;
		}
	}
	protected class  LumiereCalculeeIndexedValue  {
		
		private java.lang.Integer value;
		
		public java.lang.Integer getValue() {
		  return value;
		} 
		public void setValue(java.lang.Integer value) {
		  this.value = value;
		} 
		
		

		public  LumiereCalculeeIndexedValue (
		  java.lang.Integer lumiereCalculeeValue
 ) {
		  
		  this.value = lumiereCalculeeValue;
		  
		}
	}
	protected class  LumiereCalculeeIndexedValuePublishable  {
		
		private java.lang.Integer value;
		
		public java.lang.Integer getValue() {
		  return value;
		} 
		public void setValue(java.lang.Integer value) {
		  this.value = value;
		} 
		
		
          private boolean doPublish;
          public boolean doPublish() {
		    return doPublish;
		  }
		  public void setDoPublish(boolean doPublish) {
		    this.doPublish = doPublish;
		  }

		public  LumiereCalculeeIndexedValuePublishable (
		  java.lang.Integer lumiereCalculeeValue
, boolean doPublish ) {
		  
		  this.value = lumiereCalculeeValue;
		  
            this.doPublish = doPublish;
		}
	}


  @Override
    public void valueReceived(java.util.Map<String, Object> properties, RemoteServiceInfo source, String eventName, Object value, Object... indexes) {
      if (eventName.equals("level") && source.getClassName().startsWith("/Device/Device/PhysicalDevice/Sensor/LightSensor/")) {
      		             LevelFromLightSensor levelFromLightSensor
      		                  = new LevelFromLightSensor(
      		                     this, 
      		                     source,
      		                     (java.lang.Float) value
      		      
      		                  );

            
      GetContextForLevelFromLightSensor getContext = new GetContextForLevelFromLightSensor();
      DiscoverForLevelFromLightSensor discover = new DiscoverForLevelFromLightSensor();
 
                   java.lang.Integer  returnValue = onLevelFromLightSensor(

    levelFromLightSensor 

    , getContext, discover
);
                  if(returnValue != null) {
                    setLumiereCalculee(returnValue );
                  } else {
                    setLumiereCalculee(null);
                  }
    }
 
    }

  public abstract
        java.lang.Integer 
     onLevelFromLightSensor(
                  LevelFromLightSensor levelFromLightSensor
        
  	   , GetContextForLevelFromLightSensor getContext, 
  	   DiscoverForLevelFromLightSensor discover
     );




    protected final LightSensorDiscoverer<LightSensorComposite<LightSensorProxy>, LightSensorProxy> discoverLightSensorForSubscribe = new LightSensorDiscoverer<LightSensorComposite<LightSensorProxy>, LightSensorProxy>() {
      @Override
      protected LightSensorComposite<LightSensorProxy> instantiateComposite() {
        return new LightSensorComposite<LightSensorProxy>() {
          @Override
          protected LightSensorProxy instantiateProxy(RemoteServiceInfo rsi) {
            return new LightSensorProxy(service, rsi);
          }
        };
      }
    };


    protected final class DiscoverForLevelFromLightSensor {
      private DiscoverForLevelFromLightSensor() {
        
      }

    }




    protected abstract class LightSensorDiscoverer<F extends LightSensorComposite<T>, T extends LightSensorProxy> {
      protected abstract F instantiateComposite();

      public F all() {
        return instantiateComposite();
      }

      public T anyOne() {
        return all().anyOne();
      }


      @SuppressWarnings("unchecked")
      public F whereId(java.lang.String id) throws CompositeException {
        return (F) instantiateComposite().andId(id);
      }

      @SuppressWarnings("unchecked")
      public F whereLocation(java.lang.String location) throws CompositeException {
        return (F) instantiateComposite().andLocation(location);
      }

      @SuppressWarnings("unchecked")
      public F whereUser(java.lang.String user) throws CompositeException {
        return (F) instantiateComposite().andUser(user);
      }

    }



    protected abstract class LightSensorComposite<T extends LightSensorProxy> extends fr.inria.diagen.core.service.composite.Composite<T> {

      private LightSensorComposite() {
         super(AbstractLumiereCalculee.this, "/Device/Device/PhysicalDevice/Sensor/LightSensor/");
      }


      public LightSensorComposite<T> andId(java.lang.String id) throws CompositeException {
        if (locked) {
          throw new CompositeException();
        }
        filter.getAttributes().put("id", new EqualsAttributeFilter<java.lang.String>(id));
        return this;
      }

      public LightSensorComposite<T> andLocation(java.lang.String location) throws CompositeException {
        if (locked) {
          throw new CompositeException();
        }
        filter.getAttributes().put("location", new EqualsAttributeFilter<java.lang.String>(location));
        return this;
      }

      public LightSensorComposite<T> andUser(java.lang.String user) throws CompositeException {
        if (locked) {
          throw new CompositeException();
        }
        filter.getAttributes().put("user", new EqualsAttributeFilter<java.lang.String>(user));
        return this;
      }


      public void subscribeLevel() {
        getProcessor().subscribeValue(getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(filter), "level");
      }

      public void unsubscribeLevel() {
        getProcessor().unsubscribeValue(getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(filter), "level");
      }


    }



    protected class LightSensorProxy extends Proxy {
      private LightSensorProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
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



      public void subscribeLevel() {
        getProcessor().subscribeValue(getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "level");
      }

      public void unsubscribeLevel() {
        getProcessor().unsubscribeValue(getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "level");
      }


    }




  protected final class GetContextForLevelFromLightSensor {
  }



    protected interface LightSensorLevelContinuation extends Continuation<java.lang.Float> {};


}