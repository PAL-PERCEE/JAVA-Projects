package fr.inria.phoenix.diasuite.framework.distributed.instantmessenger;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.core.exception.InvocationException;
import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;


/**
 * 
 *
 * @[374,0]
 * device InstantMessenger extends CommunicationService {
 * }
 */
public abstract class AbstractInstantMessenger extends Service {

    public AbstractInstantMessenger(ServiceConfiguration serviceConfiguration , java.lang.String id) {
      super("/Device/Device/Service/CommunicationService/InstantMessenger/", serviceConfiguration);
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
        protected abstract void askOpenQuestion(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to, java.lang.String questionId, java.lang.String title, java.lang.String content) throws Exception;

        /**
         * 
         */
        protected abstract void askCloseTrustedQuestionWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to, java.lang.String questionId, java.lang.String title, java.lang.String content, java.util.List<java.lang.String> possibleAnswers, java.lang.String image) throws Exception;

        /**
         * 
         */
        protected abstract void sendTrustedMessageWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to, java.lang.String title, java.lang.String content, java.lang.String image) throws Exception;

        /**
         * 
         */
        protected abstract void sendTrustedMessage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to, java.lang.String title, java.lang.String content) throws Exception;

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
        protected abstract void askCloseTrustedQuestion(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to, java.lang.String questionId, java.lang.String title, java.lang.String content, java.util.List<java.lang.String> possibleAnswers) throws Exception;

        /**
         * 
         */
        protected abstract void askOpenTrustedQuestionWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to, java.lang.String questionId, java.lang.String title, java.lang.String content, java.lang.String image) throws Exception;

        /**
         * 
         */
        protected abstract void sendMessageWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to, java.lang.String title, java.lang.String content, java.lang.String image) throws Exception;

        /**
         * 
         */
        protected abstract void sendMessage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to, java.lang.String title, java.lang.String content, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.file.File> attachments) throws Exception;

        /**
         * 
         */
        protected abstract void askOpenTrustedQuestion(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to, java.lang.String questionId, java.lang.String title, java.lang.String content) throws Exception;

        /**
         * 
         */
        protected abstract void askOpenQuestionWithImage(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact to, java.lang.String questionId, java.lang.String title, java.lang.String content, java.lang.String image) throws Exception;


        private java.util.HashMap<QuestionAnswerIndices,java.lang.String> _questionAnswer = new java.util.HashMap<QuestionAnswerIndices,java.lang.String>();
        /**
         * @[360,1]
         * source questionAnswer as String indexed by questionId as String;
         */  
        protected void publishQuestionAnswer(java.lang.String newQuestionAnswerValue , java.lang.String questionId) {
          QuestionAnswerIndices _indices_ = new QuestionAnswerIndices(questionId);
          _questionAnswer.put(_indices_,newQuestionAnswerValue);
          getProcessor().publishValue(getOutProperties(), "questionAnswer", newQuestionAnswerValue
    			, questionId ); 
        }

        /**
         * @[360,1]
         * source questionAnswer as String indexed by questionId as String;
         */
        protected java.lang.String getQuestionAnswer(java.lang.String questionId) throws Exception{
          return _questionAnswer.get(new QuestionAnswerIndices(questionId));    }
        private fr.inria.phoenix.diasuite.framework.datatype.message.Message _lastMessage;
        /**
         * @[361,1]
         * source lastMessage as Message;
         */  
        protected void publishLastMessage(fr.inria.phoenix.diasuite.framework.datatype.message.Message newLastMessageValue ) {
          _lastMessage = newLastMessageValue;
          getProcessor().publishValue(getOutProperties(), "lastMessage", newLastMessageValue); 
        }

        /**
         * @[361,1]
         * source lastMessage as Message;
         */
        protected fr.inria.phoenix.diasuite.framework.datatype.message.Message getLastMessage() throws Exception{
          return _lastMessage;    }
        private java.util.HashMap<TrustedQuestionAnswerIndices,java.lang.String> _trustedQuestionAnswer = new java.util.HashMap<TrustedQuestionAnswerIndices,java.lang.String>();
        /**
         * @[365,1]
         * source trustedQuestionAnswer as String indexed by questionId as String;
         */  
        protected void publishTrustedQuestionAnswer(java.lang.String newTrustedQuestionAnswerValue , java.lang.String questionId) {
          TrustedQuestionAnswerIndices _indices_ = new TrustedQuestionAnswerIndices(questionId);
          _trustedQuestionAnswer.put(_indices_,newTrustedQuestionAnswerValue);
          getProcessor().publishValue(getOutProperties(), "trustedQuestionAnswer", newTrustedQuestionAnswerValue
    			, questionId ); 
        }

        /**
         * @[365,1]
         * source trustedQuestionAnswer as String indexed by questionId as String;
         */
        protected java.lang.String getTrustedQuestionAnswer(java.lang.String questionId) throws Exception{
          return _trustedQuestionAnswer.get(new TrustedQuestionAnswerIndices(questionId));    }
        private fr.inria.phoenix.diasuite.framework.datatype.message.Message _lastTrustedMessage;
        /**
         * @[366,1]
         * source lastTrustedMessage as Message;
         */  
        protected void publishLastTrustedMessage(fr.inria.phoenix.diasuite.framework.datatype.message.Message newLastTrustedMessageValue ) {
          _lastTrustedMessage = newLastTrustedMessageValue;
          getProcessor().publishValue(getOutProperties(), "lastTrustedMessage", newLastTrustedMessageValue); 
        }

        /**
         * @[366,1]
         * source lastTrustedMessage as Message;
         */
        protected fr.inria.phoenix.diasuite.framework.datatype.message.Message getLastTrustedMessage() throws Exception{
          return _lastTrustedMessage;    }
        private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.contact.Contact> _safeContacts;
        /**
         * @[368,1]
         * source safeContacts as Contact[];
         */  
        protected void publishSafeContacts(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.contact.Contact> newSafeContactsValue ) {
          _safeContacts = newSafeContactsValue;
          getProcessor().publishValue(getOutProperties(), "safeContacts", newSafeContactsValue); 
        }

        /**
         * @[368,1]
         * source safeContacts as Contact[];
         */
        protected java.util.List<fr.inria.phoenix.diasuite.framework.datatype.contact.Contact> getSafeContacts() throws Exception{
          return _safeContacts;    }
 

  public final Object orderCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("askOpenQuestion")) {
          askOpenQuestion((fr.inria.phoenix.diasuite.framework.datatype.contact.Contact)args[0], (java.lang.String)args[1], (java.lang.String)args[2], (java.lang.String)args[3]);
          return null;
        } else     if (orderName.equals("askCloseTrustedQuestionWithImage")) {
          askCloseTrustedQuestionWithImage((fr.inria.phoenix.diasuite.framework.datatype.contact.Contact)args[0], (java.lang.String)args[1], (java.lang.String)args[2], (java.lang.String)args[3], (java.util.List<java.lang.String>)args[4], (java.lang.String)args[5]);
          return null;
        } else     if (orderName.equals("sendTrustedMessageWithImage")) {
          sendTrustedMessageWithImage((fr.inria.phoenix.diasuite.framework.datatype.contact.Contact)args[0], (java.lang.String)args[1], (java.lang.String)args[2], (java.lang.String)args[3]);
          return null;
        } else     if (orderName.equals("sendTrustedMessage")) {
          sendTrustedMessage((fr.inria.phoenix.diasuite.framework.datatype.contact.Contact)args[0], (java.lang.String)args[1], (java.lang.String)args[2]);
          return null;
        } else     if (orderName.equals("askCloseQuestionWithImage")) {
          askCloseQuestionWithImage((fr.inria.phoenix.diasuite.framework.datatype.contact.Contact)args[0], (java.lang.String)args[1], (java.lang.String)args[2], (java.lang.String)args[3], (java.util.List<java.lang.String>)args[4], (java.lang.String)args[5]);
          return null;
        } else     if (orderName.equals("askCloseQuestion")) {
          askCloseQuestion((fr.inria.phoenix.diasuite.framework.datatype.contact.Contact)args[0], (java.lang.String)args[1], (java.lang.String)args[2], (java.lang.String)args[3], (java.util.List<java.lang.String>)args[4]);
          return null;
        } else     if (orderName.equals("askCloseTrustedQuestion")) {
          askCloseTrustedQuestion((fr.inria.phoenix.diasuite.framework.datatype.contact.Contact)args[0], (java.lang.String)args[1], (java.lang.String)args[2], (java.lang.String)args[3], (java.util.List<java.lang.String>)args[4]);
          return null;
        } else     if (orderName.equals("askOpenTrustedQuestionWithImage")) {
          askOpenTrustedQuestionWithImage((fr.inria.phoenix.diasuite.framework.datatype.contact.Contact)args[0], (java.lang.String)args[1], (java.lang.String)args[2], (java.lang.String)args[3], (java.lang.String)args[4]);
          return null;
        } else     if (orderName.equals("sendMessageWithImage")) {
          sendMessageWithImage((fr.inria.phoenix.diasuite.framework.datatype.contact.Contact)args[0], (java.lang.String)args[1], (java.lang.String)args[2], (java.lang.String)args[3]);
          return null;
        } else     if (orderName.equals("sendMessage")) {
          sendMessage((fr.inria.phoenix.diasuite.framework.datatype.contact.Contact)args[0], (java.lang.String)args[1], (java.lang.String)args[2], (java.util.List<fr.inria.phoenix.diasuite.framework.datatype.file.File>)args[3]);
          return null;
        } else     if (orderName.equals("askOpenTrustedQuestion")) {
          askOpenTrustedQuestion((fr.inria.phoenix.diasuite.framework.datatype.contact.Contact)args[0], (java.lang.String)args[1], (java.lang.String)args[2], (java.lang.String)args[3]);
          return null;
        } else     if (orderName.equals("askOpenQuestionWithImage")) {
          askOpenQuestionWithImage((fr.inria.phoenix.diasuite.framework.datatype.contact.Contact)args[0], (java.lang.String)args[1], (java.lang.String)args[2], (java.lang.String)args[3], (java.lang.String)args[4]);
          return null;
        } 
    throw new InvocationException("Undefined method name " + orderName);
  }
  
  public Object getValueCalled(java.util.Map<String, Object> properties, RemoteServiceInfo source, String orderName, Object... args) throws Exception {
        if (orderName.equals("questionAnswer")) {
          return getQuestionAnswer((java.lang.String)args[0]);
        } else     if (orderName.equals("lastMessage")) {
          return getLastMessage();
        } else     if (orderName.equals("trustedQuestionAnswer")) {
          return getTrustedQuestionAnswer((java.lang.String)args[0]);
        } else     if (orderName.equals("lastTrustedMessage")) {
          return getLastTrustedMessage();
        } else     if (orderName.equals("safeContacts")) {
          return getSafeContacts();
        }

       if (orderName.equals("id")) {
         return id;
       }
    
    throw new InvocationException("Undefined method name " + orderName);
  }
    
}