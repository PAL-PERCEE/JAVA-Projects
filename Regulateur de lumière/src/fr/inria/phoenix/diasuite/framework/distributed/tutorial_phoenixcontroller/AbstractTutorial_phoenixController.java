package fr.inria.phoenix.diasuite.framework.distributed.tutorial_phoenixcontroller;


import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.behavioral.contract.CompositeException;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.module.event.EventSynchronizer;
import fr.inria.diagen.core.module.event.EventSynchronizerBuffer;
import fr.inria.diagen.core.exception.continuation.Continuation;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.filter.attribute.AttributeFilter;
import fr.inria.diagen.core.service.filter.attribute.EqualsAttributeFilter;
import fr.inria.diagen.core.service.filter.service.ServiceFilter;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;

import fr.inria.phoenix.diasuite.framework.distributed.regulationindicator.RegulationIndicatorValue;




public abstract class AbstractTutorial_phoenixController extends Service {

    public AbstractTutorial_phoenixController(ServiceConfiguration serviceConfiguration) {
      super("/Controller/Tutorial_phoenixController/", serviceConfiguration);
    }

    protected final void internalPostInitialize() {
        regulationIndicator = new RegulationIndicator();
        regulationIndicator.subscribe();

        postInitialize();
    }

  @Override
    public void valueReceived(java.util.Map<String, Object> properties, RemoteServiceInfo source, String eventName, Object value, Object... indexes) {
      if (eventName.equals("regulationIndicator") && source.getClassName().startsWith("/Context/RegulationIndicator/")) {
      		             RegulationIndicatorValue regulationIndicatorValue
      		                  = new RegulationIndicatorValue(
      		                     (java.lang.Float) value
      		                  );

            
      GetContextForRegulationIndicator getContext = new GetContextForRegulationIndicator();
      DiscoverForRegulationIndicator discover = new DiscoverForRegulationIndicator();
                  onRegulationIndicator(

                      regulationIndicatorValue 

                      , getContext, discover
                  );
    }
 
    }

  public abstract
   
       void 
     onRegulationIndicator(
                  RegulationIndicatorValue regulationIndicator

        
  	   , GetContextForRegulationIndicator getContext, 
  	   DiscoverForRegulationIndicator discover
     );



    protected final class DiscoverForRegulationIndicator {
      private DiscoverForRegulationIndicator() {
        dimmableLightDiscoverer = new DimmableLightDiscovererForRegulationIndicator();
        
      }


      private final DimmableLightDiscovererForRegulationIndicator dimmableLightDiscoverer;

      public DimmableLightDiscovererForRegulationIndicator dimmableLights() {
        return dimmableLightDiscoverer;
      }

    }
    protected class DimmableLightDiscovererForRegulationIndicator extends
        DimmableLightDiscoverer<DimmableLightCompositeForRegulationIndicator, DimmableLightProxyForRegulationIndicator> {
      @Override
      protected DimmableLightCompositeForRegulationIndicator instantiateComposite() {
        return new DimmableLightCompositeForRegulationIndicator();
      }
    }
    protected class DimmableLightCompositeForRegulationIndicator extends DimmableLightComposite<DimmableLightProxyForRegulationIndicator> {
      @Override
      protected DimmableLightProxyForRegulationIndicator instantiateProxy(RemoteServiceInfo rsi) {
        return new DimmableLightProxyForRegulationIndicator(service, rsi);
      }

            public void setValue(java.lang.Float value ) throws InvocationException {
              launchDiscovering();
              for (DimmableLightProxyForRegulationIndicator proxy : proxies) {
                proxy.setValue(value);
              }
            }

            public void setValue(java.lang.Float value, DimmableLightVariationControlContinuation continuation) throws InvocationException {
              launchDiscovering();
              for (DimmableLightProxyForRegulationIndicator proxy : proxies) {
                proxy.setValue(value,  continuation);
              }
            }
                public void increase() throws InvocationException {
              launchDiscovering();
              for (DimmableLightProxyForRegulationIndicator proxy : proxies) {
                proxy.increase();
              }
            }

            public void increase(DimmableLightVariationControlContinuation continuation) throws InvocationException {
              launchDiscovering();
              for (DimmableLightProxyForRegulationIndicator proxy : proxies) {
                proxy.increase( continuation);
              }
            }
                public void decrease() throws InvocationException {
              launchDiscovering();
              for (DimmableLightProxyForRegulationIndicator proxy : proxies) {
                proxy.decrease();
              }
            }

            public void decrease(DimmableLightVariationControlContinuation continuation) throws InvocationException {
              launchDiscovering();
              for (DimmableLightProxyForRegulationIndicator proxy : proxies) {
                proxy.decrease( continuation);
              }
            }
            
      

    }
    protected class DimmableLightProxyForRegulationIndicator extends DimmableLightProxy {
        private DimmableLightProxyForRegulationIndicator(Service service, RemoteServiceInfo remoteServiceInfo) {
          super(service, remoteServiceInfo);
        }
  	  
            public void setValue(java.lang.Float value ) throws InvocationException {
              getService().getProcessor().callOrder(
                  getService().getOutProperties(), 
                  getRemoteServiceInfo(), 
                  "setValue" 
        , 
                  value 
              );
            }

            public void setValue(java.lang.Float value, DimmableLightVariationControlContinuation continuation) throws InvocationException {
              java.util.Map<String, Object> properties = getService().getOutProperties();
              properties.put("exception.continuation", continuation);
              getService().getProcessor().callOrder(
                  properties, 
                  getRemoteServiceInfo(), 
                  "setValue" 
        , 
                  value 
              );
            }
                public void increase() throws InvocationException {
              getService().getProcessor().callOrder(
                  getService().getOutProperties(), 
                  getRemoteServiceInfo(), 
                  "increase" 
              );
            }

            public void increase(DimmableLightVariationControlContinuation continuation) throws InvocationException {
              java.util.Map<String, Object> properties = getService().getOutProperties();
              properties.put("exception.continuation", continuation);
              getService().getProcessor().callOrder(
                  properties, 
                  getRemoteServiceInfo(), 
                  "increase" 
              );
            }
                public void decrease() throws InvocationException {
              getService().getProcessor().callOrder(
                  getService().getOutProperties(), 
                  getRemoteServiceInfo(), 
                  "decrease" 
              );
            }

            public void decrease(DimmableLightVariationControlContinuation continuation) throws InvocationException {
              java.util.Map<String, Object> properties = getService().getOutProperties();
              properties.put("exception.continuation", continuation);
              getService().getProcessor().callOrder(
                  properties, 
                  getRemoteServiceInfo(), 
                  "decrease" 
              );
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
         super(AbstractTutorial_phoenixController.this, "/Device/Device/PhysicalDevice/Appliance/Light/DimmableLight/");
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



    private RegulationIndicator regulationIndicator;

    protected final class RegulationIndicator {

      private ServiceFilter filter = new ServiceFilter("/Context/RegulationIndicator/");
      
  	private RemoteServiceInfo getRsi() {
  		return getProcessor().discoverComponents(getOutProperties(), filter).get(0);
  	}
  	
      private RegulationIndicator() {
      }

      private final void subscribe() {
        getProcessor().subscribeValue(getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(filter), "regulationIndicator");
      }

      public final java.lang.Float getValue(
       java.util.Map<String, Object> properties
      ) throws InvocationException {
        return (java.lang.Float) getProcessor().callGetValue(properties, getRsi(), "regulationIndicator"
        );
      }
      
      public final java.lang.Float getValue(
       java.util.Map<String, Object> properties,
       RegulationIndicatorContinuation continuation
      ) throws InvocationException {
        properties.put("exception.continuation", continuation);
        return (java.lang.Float) getProcessor().callGetValue(properties, getRsi(), "regulationIndicator"
          );
      }
    }


  protected final class GetContextForRegulationIndicator {
  }



    protected interface RegulationIndicatorContinuation extends Continuation<java.lang.Float> {};



    protected interface DimmableLightVariationControlContinuation extends Continuation<Void> {};


} 