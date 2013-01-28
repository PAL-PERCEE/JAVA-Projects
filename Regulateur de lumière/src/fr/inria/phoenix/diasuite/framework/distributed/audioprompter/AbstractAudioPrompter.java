package fr.inria.phoenix.diasuite.framework.distributed.audioprompter;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;


/**
 * 
 *
 * @[684,0]
 * device AudioPrompter extends Prompter {
 * }
 */
public abstract class AbstractAudioPrompter extends Service {

    public AbstractAudioPrompter(ServiceConfiguration serviceConfiguration , java.lang.String id, java.lang.String location, java.lang.String user) {
      super("/Device/Device/PhysicalDevice/Prompter/AudioPrompter/", serviceConfiguration);
      updateId(id);
      updateLocation(location);
      updateUser(user);
    }

    @Override
    public final java.util.Map<String, Object> getAttributesCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source) {
        java.util.Map<String, Object> attributes = new java.util.HashMap<String, Object>();
        attributes.put("id",id);
        attributes.put("location",location);
        attributes.put("user",user);

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

        private java.lang.String location;

        /**
         * @[440,11]
         * attribute location as String;
         * @param newLocationValue
         */
        protected void updateLocation(java.lang.String newLocationValue) {
          if (location != newLocationValue) {
            location = newLocationValue;
            updateAttribute("location", newLocationValue);
          }
        }

        /**
         * @[440,11]
         * attribute location as String;
         * @return
         */  
        public java.lang.String getLocation() {
          return location;
        }

        private java.lang.String user;

        /**
         * @[441,11]
         * attribute user as String;
         * @param newUserValue
         */
        protected void updateUser(java.lang.String newUserValue) {
          if (user != newUserValue) {
            user = newUserValue;
            updateAttribute("user", newUserValue);
          }
        }

        /**
         * @[441,11]
         * attribute user as String;
         * @return
         */  
        public java.lang.String getUser() {
          return user;
        }


  protected final void internalPostInitialize() {postInitialize();}

        /**
         * 
         */
        protected abstract void askOpenQuestion(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to, java.lang.String questionId, java.lang.String title, java.lang.String content) throws Exception;

        /**
         * 
         */
        protected abstract void askCloseQuestionWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to, java.lang.String questionId, java.lang.String title, java.lang.String content, java.util.List<java.lang.String> possibleAnswers, java.lang.String image) throws Exception;

        /**
         * 
         */
        protected abstract void askCloseQuestion(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to, java.lang.String questionId, java.lang.String title, java.lang.String content, java.util.List<java.lang.String> possibleAnswers) throws Exception;

        /**
         * 
         */
        protected abstract void askOpenQuestionWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to, java.lang.String questionId, java.lang.String title, java.lang.String content, java.lang.String image) throws Exception;


        private java.util.HashMap<AnswerIndices,java.lang.String> _answer = new java.util.HashMap<AnswerIndices,java.lang.String>();
        /**
         * @[675,1]
         * source answer as String indexed by questionId as String;
         */  
        protected void publishAnswer(java.lang.String newAnswerValue , java.lang.String questionId) {
          AnswerIndices _indices_ = new AnswerIndices(questionId);
          _answer.put(_indices_,newAnswerValue);
          getProcessor().publishValue(getOutProperties(), "answer", newAnswerValue
    			, questionId ); 
        }

        /**
         * @[675,1]
         * source answer as String indexed by questionId as String;
         */
        protected java.lang.String getAnswer(java.lang.String questionId) throws Exception{
          return _answer.get(new AnswerIndices(questionId));    }
 

  public final Object orderCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("askOpenQuestion")) {
          askOpenQuestion((fr.inria.phoenix.diasuite.framework.datatype.contact.Contact)args[0], (java.lang.String)args[1], (java.lang.String)args[2], (java.lang.String)args[3]);
          return null;
        } else     if (orderName.equals("askCloseQuestionWithImage")) {
          askCloseQuestionWithImage((fr.inria.phoenix.diasuite.framework.datatype.contact.Contact)args[0], (java.lang.String)args[1], (java.lang.String)args[2], (java.lang.String)args[3], (java.util.List<java.lang.String>)args[4], (java.lang.String)args[5]);
          return null;
        } else     if (orderName.equals("askCloseQuestion")) {
          askCloseQuestion((fr.inria.phoenix.diasuite.framework.datatype.contact.Contact)args[0], (java.lang.String)args[1], (java.lang.String)args[2], (java.lang.String)args[3], (java.util.List<java.lang.String>)args[4]);
          return null;
        } else     if (orderName.equals("askOpenQuestionWithImage")) {
          askOpenQuestionWithImage((fr.inria.phoenix.diasuite.framework.datatype.contact.Contact)args[0], (java.lang.String)args[1], (java.lang.String)args[2], (java.lang.String)args[3], (java.lang.String)args[4]);
          return null;
        } 
    throw new InvocationException("Undefined method name " + orderName);
  }
  
  public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("answer")) {
          return getAnswer((java.lang.String)args[0]);
        }

       if (orderName.equals("id")) {
         return id;
       } else      if (orderName.equals("location")) {
         return location;
       } else      if (orderName.equals("user")) {
         return user;
       }
    
    throw new InvocationException("Undefined method name " + orderName);
  }
    
}