package fr.inria.phoenix.diasuite.framework.distributed.tvguide;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;


/**
 * 
 *
 * @[399,0]
 * device TvGuide extends HomeService {
 *   source availableChannels as Channel[];
 *   source currentProgram as TvSchedule indexed by channelId as String;
 *   source nextProgram as TvSchedule indexed by channelId as String;
 *   source programs as TvSchedule[] indexed by filter as TvSchedule;
 * }
 */
public abstract class AbstractTvGuide extends Service {

    public AbstractTvGuide(ServiceConfiguration serviceConfiguration , java.lang.String id) {
      super("/Device/Device/Service/HomeService/TvGuide/", serviceConfiguration);
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


        private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.channel.Channel> _availableChannels;
        /**
         * @[400,1]
         * source availableChannels as Channel[];
         */  
        protected void publishAvailableChannels(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.channel.Channel> newAvailableChannelsValue ) {
          _availableChannels = newAvailableChannelsValue;
          getProcessor().publishValue(getOutProperties(), "availableChannels", newAvailableChannelsValue); 
        }

        /**
         * @[400,1]
         * source availableChannels as Channel[];
         */
        protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.channel.Channel> getAvailableChannels() throws Exception{
          return _availableChannels;    }
        private java.util.HashMap<CurrentProgramIndices,fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule> _currentProgram = new java.util.HashMap<CurrentProgramIndices,fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule>();
        /**
         * @[401,1]
         * source currentProgram as TvSchedule indexed by channelId as String;
         */  
        protected void publishCurrentProgram(fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule newCurrentProgramValue , java.lang.String channelId) {
          CurrentProgramIndices _indices_ = new CurrentProgramIndices(channelId);
          _currentProgram.put(_indices_,newCurrentProgramValue);
          getProcessor().publishValue(getOutProperties(), "currentProgram", newCurrentProgramValue
    			, channelId ); 
        }

        /**
         * @[401,1]
         * source currentProgram as TvSchedule indexed by channelId as String;
         */
        protected fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule getCurrentProgram(java.lang.String channelId) throws Exception{
          return _currentProgram.get(new CurrentProgramIndices(channelId));    }
        private java.util.HashMap<NextProgramIndices,fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule> _nextProgram = new java.util.HashMap<NextProgramIndices,fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule>();
        /**
         * @[402,1]
         * source nextProgram as TvSchedule indexed by channelId as String;
         */  
        protected void publishNextProgram(fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule newNextProgramValue , java.lang.String channelId) {
          NextProgramIndices _indices_ = new NextProgramIndices(channelId);
          _nextProgram.put(_indices_,newNextProgramValue);
          getProcessor().publishValue(getOutProperties(), "nextProgram", newNextProgramValue
    			, channelId ); 
        }

        /**
         * @[402,1]
         * source nextProgram as TvSchedule indexed by channelId as String;
         */
        protected fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule getNextProgram(java.lang.String channelId) throws Exception{
          return _nextProgram.get(new NextProgramIndices(channelId));    }
        private java.util.HashMap<ProgramsIndices,java.util.List<fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule>> _programs = new java.util.HashMap<ProgramsIndices,java.util.List<fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule>>();
        /**
         * @[403,1]
         * source programs as TvSchedule[] indexed by filter as TvSchedule;
         */  
        protected void publishPrograms(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule> newProgramsValue , fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule filter) {
          ProgramsIndices _indices_ = new ProgramsIndices(filter);
          _programs.put(_indices_,newProgramsValue);
          getProcessor().publishValue(getOutProperties(), "programs", newProgramsValue
    			, filter ); 
        }

        /**
         * @[403,1]
         * source programs as TvSchedule[] indexed by filter as TvSchedule;
         */
        protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule> getPrograms(fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule filter) throws Exception{
          return _programs.get(new ProgramsIndices(filter));    }
 

  public final Object orderCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
 
    throw new InvocationException("Undefined method name " + orderName);
  }
  
  public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("availableChannels")) {
          return getAvailableChannels();
        } else     if (orderName.equals("currentProgram")) {
          return getCurrentProgram((java.lang.String)args[0]);
        } else     if (orderName.equals("nextProgram")) {
          return getNextProgram((java.lang.String)args[0]);
        } else     if (orderName.equals("programs")) {
          return getPrograms((fr.inria.phoenix.diasuite.framework.datatype.tvschedule.TvSchedule)args[0]);
        }

       if (orderName.equals("id")) {
         return id;
       }
    
    throw new InvocationException("Undefined method name " + orderName);
  }
    
}