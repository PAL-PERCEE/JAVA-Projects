package fr.inria.phoenix.diasuite.framework.distributed.regulationindicator;

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

import fr.inria.phoenix.diasuite.framework.distributed.lumierecalculee.LumiereCalculeeValue;



/**
 * 
 *
 * @[28,0]
 * context RegulationIndicator as Float {
 * source setPoint from SetPointConsole;
 * source level from DimmableLight;
 * context LumiereCalculee;
 * }
 */
public abstract class AbstractRegulationIndicator extends Service {

    public AbstractRegulationIndicator(ServiceConfiguration serviceConfiguration) {
      super("/Context/RegulationIndicator/", serviceConfiguration);
    }

  @Override
  protected final void internalPostInitialize() {
      lumiereCalculee = new LumiereCalculee();
      lumiereCalculee.subscribe();  
    postInitialize();
  }

    private java.lang.Float contextValue;

    private void setRegulationIndicator(java.lang.Float newContextValue ) {
        contextValue = newContextValue;
        getProcessor().publishValue(getOutProperties(), "regulationIndicator", newContextValue );
    }

    protected final java.lang.Float getLastValue() {
        return contextValue;
    }

	protected class  RegulationIndicatorValuePublishable  {
		
		private java.lang.Float value;
		
		public java.lang.Float getValue() {
		  return value;
		} 
		public void setValue(java.lang.Float value) {
		  this.value = value;
		} 
		
		
          private boolean doPublish;
          public boolean doPublish() {
		    return doPublish;
		  }
		  public void setDoPublish(boolean doPublish) {
		    this.doPublish = doPublish;
		  }

		public  RegulationIndicatorValuePublishable (
		  java.lang.Float regulationIndicatorValue
, boolean doPublish ) {
		  
		  this.value = regulationIndicatorValue;
		  
            this.doPublish = doPublish;
		}
	}
	protected class  RegulationIndicatorIndexedValue  {
		
		private java.lang.Float value;
		
		public java.lang.Float getValue() {
		  return value;
		} 
		public void setValue(java.lang.Float value) {
		  this.value = value;
		} 
		
		

		public  RegulationIndicatorIndexedValue (
		  java.lang.Float regulationIndicatorValue
 ) {
		  
		  this.value = regulationIndicatorValue;
		  
		}
	}
	protected class  RegulationIndicatorIndexedValuePublishable  {
		
		private java.lang.Float value;
		
		public java.lang.Float getValue() {
		  return value;
		} 
		public void setValue(java.lang.Float value) {
		  this.value = value;
		} 
		
		
          private boolean doPublish;
          public boolean doPublish() {
		    return doPublish;
		  }
		  public void setDoPublish(boolean doPublish) {
		    this.doPublish = doPublish;
		  }

		public  RegulationIndicatorIndexedValuePublishable (
		  java.lang.Float regulationIndicatorValue
, boolean doPublish ) {
		  
		  this.value = regulationIndicatorValue;
		  
            this.doPublish = doPublish;
		}
	}


  @Override
    public void valueReceived(java.util.Map<String, Object> properties, RemoteServiceInfo source, String eventName, Object value, Object... indexes) {
      if (eventName.equals("lumiereCalculee") && source.getClassName().startsWith("/Context/LumiereCalculee/")) {
      		             LumiereCalculeeValue lumiereCalculeeValue
      		                  = new LumiereCalculeeValue(
      		                     (java.lang.Integer) value
      		                  );

            
      GetContextForLumiereCalculee getContext = new GetContextForLumiereCalculee();
      DiscoverForLumiereCalculee discover = new DiscoverForLumiereCalculee();
         RegulationIndicatorValuePublishable  mayPublish =
            onLumiereCalculee(

                lumiereCalculeeValue 

                , getContext, discover
            );
            if (mayPublish != null && mayPublish.doPublish())
              setRegulationIndicator(mayPublish.getValue() );
    }
 
    }

  public abstract
        RegulationIndicatorValuePublishable 
     onLumiereCalculee(
                  LumiereCalculeeValue lumiereCalculee

        
  	   , GetContextForLumiereCalculee getContext, 
  	   DiscoverForLumiereCalculee discover
     );




    protected final class DiscoverForLumiereCalculee {
      private DiscoverForLumiereCalculee() {
        setPointConsoleDiscoverer = new SetPointConsoleDiscovererForLumiereCalculee();
        dimmableLightDiscoverer = new DimmableLightDiscovererForLumiereCalculee();
        
      }


      private final SetPointConsoleDiscovererForLumiereCalculee setPointConsoleDiscoverer;

      public SetPointConsoleDiscovererForLumiereCalculee setPointConsoles() {
        return setPointConsoleDiscoverer;
      }

      private final DimmableLightDiscovererForLumiereCalculee dimmableLightDiscoverer;

      public DimmableLightDiscovererForLumiereCalculee dimmableLights() {
        return dimmableLightDiscoverer;
      }

    }
    protected class SetPointConsoleDiscovererForLumiereCalculee extends
        SetPointConsoleDiscoverer<SetPointConsoleCompositeForLumiereCalculee, SetPointConsoleProxyForLumiereCalculee> {
      @Override
      protected SetPointConsoleCompositeForLumiereCalculee instantiateComposite() {
        return new SetPointConsoleCompositeForLumiereCalculee();
      }
    }
    protected class SetPointConsoleCompositeForLumiereCalculee extends SetPointConsoleComposite<SetPointConsoleProxyForLumiereCalculee> {
      @Override
      protected SetPointConsoleProxyForLumiereCalculee instantiateProxy(RemoteServiceInfo rsi) {
        return new SetPointConsoleProxyForLumiereCalculee(service, rsi);
      }


    }
    protected class SetPointConsoleProxyForLumiereCalculee extends SetPointConsoleProxy {
        private SetPointConsoleProxyForLumiereCalculee(Service service, RemoteServiceInfo remoteServiceInfo) {
          super(service, remoteServiceInfo);
        }
  	  

  		    public java.lang.Integer getSetPoint() throws InvocationException {
  		      return (java.lang.Integer) getService().getProcessor().callGetValue(AbstractRegulationIndicator.this.getOutProperties(), getRemoteServiceInfo(), "setPoint"
  		              );
  		    }
  		
  		    public java.lang.Integer getSetPoint(
  		      SetPointConsoleSetPointContinuation continuation
  		    ) throws InvocationException {
  		      java.util.Map<String, Object> properties = AbstractRegulationIndicator.this.getOutProperties();
  		      properties.put("exception.continuation", continuation);
  		      return (java.lang.Integer) getService().getProcessor().callGetValue(properties, getRemoteServiceInfo(), "setPoint"
  	);
  		    }
  		

    }
    protected class DimmableLightDiscovererForLumiereCalculee extends
        DimmableLightDiscoverer<DimmableLightCompositeForLumiereCalculee, DimmableLightProxyForLumiereCalculee> {
      @Override
      protected DimmableLightCompositeForLumiereCalculee instantiateComposite() {
        return new DimmableLightCompositeForLumiereCalculee();
      }
    }
    protected class DimmableLightCompositeForLumiereCalculee extends DimmableLightComposite<DimmableLightProxyForLumiereCalculee> {
      @Override
      protected DimmableLightProxyForLumiereCalculee instantiateProxy(RemoteServiceInfo rsi) {
        return new DimmableLightProxyForLumiereCalculee(service, rsi);
      }


    }
    protected class DimmableLightProxyForLumiereCalculee extends DimmableLightProxy {
        private DimmableLightProxyForLumiereCalculee(Service service, RemoteServiceInfo remoteServiceInfo) {
          super(service, remoteServiceInfo);
        }
  	  

  		    public java.lang.Float getLevel() throws InvocationException {
  		      return (java.lang.Float) getService().getProcessor().callGetValue(AbstractRegulationIndicator.this.getOutProperties(), getRemoteServiceInfo(), "level"
  		              );
  		    }
  		
  		    public java.lang.Float getLevel(
  		      DimmableLightLevelContinuation continuation
  		    ) throws InvocationException {
  		      java.util.Map<String, Object> properties = AbstractRegulationIndicator.this.getOutProperties();
  		      properties.put("exception.continuation", continuation);
  		      return (java.lang.Float) getService().getProcessor().callGetValue(properties, getRemoteServiceInfo(), "level"
  	);
  		    }
  		

    }





    protected abstract class SetPointConsoleDiscoverer<F extends SetPointConsoleComposite<T>, T extends SetPointConsoleProxy> {
      protected abstract F instantiateComposite();

      public F all() {
        return instantiateComposite();
      }

      public T anyOne() {
        return all().anyOne();
      }

    }

    protected abstract class DimmableLightDiscoverer<F extends DimmableLightComposite<T>, T extends DimmableLightProxy> {
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



    protected abstract class DimmableLightComposite<T extends DimmableLightProxy> extends fr.inria.diagen.core.service.composite.Composite<T> {

      private DimmableLightComposite() {
         super(AbstractRegulationIndicator.this, "/Device/Device/PhysicalDevice/Appliance/Light/DimmableLight/");
      }


      public DimmableLightComposite<T> andId(java.lang.String id) throws CompositeException {
        if (locked) {
          throw new CompositeException();
        }
        filter.getAttributes().put("id", new EqualsAttributeFilter<java.lang.String>(id));
        return this;
      }

      public DimmableLightComposite<T> andLocation(java.lang.String location) throws CompositeException {
        if (locked) {
          throw new CompositeException();
        }
        filter.getAttributes().put("location", new EqualsAttributeFilter<java.lang.String>(location));
        return this;
      }

      public DimmableLightComposite<T> andUser(java.lang.String user) throws CompositeException {
        if (locked) {
          throw new CompositeException();
        }
        filter.getAttributes().put("user", new EqualsAttributeFilter<java.lang.String>(user));
        return this;
      }



    }

    protected abstract class SetPointConsoleComposite<T extends SetPointConsoleProxy> extends fr.inria.diagen.core.service.composite.Composite<T> {

      private SetPointConsoleComposite() {
         super(AbstractRegulationIndicator.this, "/Device/SetPointConsole/");
      }



    }



    protected class SetPointConsoleProxy extends Proxy {
      private SetPointConsoleProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
        super(service, remoteServiceInfo);
      }



    }

    protected class DimmableLightProxy extends Proxy {
      private DimmableLightProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
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



    }



    private LumiereCalculee lumiereCalculee;

    protected final class LumiereCalculee {

      private ServiceFilter filter = new ServiceFilter("/Context/LumiereCalculee/");
      
  	private RemoteServiceInfo getRsi() {
  		return getProcessor().discoverComponents(getOutProperties(), filter).get(0);
  	}
  	
      private LumiereCalculee() {
      }

      private final void subscribe() {
        getProcessor().subscribeValue(getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(filter), "lumiereCalculee");
      }

      public final java.lang.Integer getValue(
       java.util.Map<String, Object> properties
      ) throws InvocationException {
        return (java.lang.Integer) getProcessor().callGetValue(properties, getRsi(), "lumiereCalculee"
        );
      }
      
      public final java.lang.Integer getValue(
       java.util.Map<String, Object> properties,
       LumiereCalculeeContinuation continuation
      ) throws InvocationException {
        properties.put("exception.continuation", continuation);
        return (java.lang.Integer) getProcessor().callGetValue(properties, getRsi(), "lumiereCalculee"
          );
      }
    }



  protected final class GetContextForLumiereCalculee {
  }



    protected interface SetPointConsoleSetPointContinuation extends Continuation<java.lang.Integer> {};

    protected interface DimmableLightLevelContinuation extends Continuation<java.lang.Float> {};

    protected interface LumiereCalculeeContinuation extends Continuation<java.lang.Integer> {};


}