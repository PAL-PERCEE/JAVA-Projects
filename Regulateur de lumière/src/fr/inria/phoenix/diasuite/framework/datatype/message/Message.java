package fr.inria.phoenix.diasuite.framework.datatype.message;
import java.io.Serializable;


/**
 * 
 *
 * @[48,0]
 * structure Message {
 * sender as Contact;
 * title as String;
 * text as String;
 * attachments as File[];
 * }
 */
public class Message implements Serializable {

    private static final long serialVersionUID = 0;
    private fr.inria.phoenix.diasuite.framework.datatype.contact.Contact sender;
    
    public fr.inria.phoenix.diasuite.framework.datatype.contact.Contact getSender() {
        return sender;
    }
    
    public void setSender(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact newSenderValue) {
        this.sender = newSenderValue;
    }
    private java.lang.String title;
    
    public java.lang.String getTitle() {
        return title;
    }
    
    public void setTitle(java.lang.String newTitleValue) {
        this.title = newTitleValue;
    }
    private java.lang.String text;
    
    public java.lang.String getText() {
        return text;
    }
    
    public void setText(java.lang.String newTextValue) {
        this.text = newTextValue;
    }
    private java.util.List<fr.inria.phoenix.diasuite.framework.datatype.file.File> attachments;
    
    public java.util.List<fr.inria.phoenix.diasuite.framework.datatype.file.File> getAttachments() {
        return attachments;
    }
    
    public void setAttachments(java.util.List<fr.inria.phoenix.diasuite.framework.datatype.file.File> newAttachmentsValue) {
        this.attachments = newAttachmentsValue;
    }

    public Message() {
    }
  
    public Message(fr.inria.phoenix.diasuite.framework.datatype.contact.Contact sender, java.lang.String title, java.lang.String text, java.util.List<fr.inria.phoenix.diasuite.framework.datatype.file.File> attachments) {
      this.sender = sender;      
      this.title = title;      
      this.text = text;      
      this.attachments = attachments;      

    }    
      @Override
      public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sender == null) ? 0 : sender.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((text == null) ? 0 : text.hashCode());
        result = prime * result + ((attachments == null) ? 0 : attachments.hashCode());

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
        Message other = (Message) obj;
        if (sender == null) {
          if (other.sender != null)
            return false;
        } else if (!sender.equals(other.sender))
          return false; 
        if (title == null) {
          if (other.title != null)
            return false;
        } else if (!title.equals(other.title))
          return false; 
        if (text == null) {
          if (other.text != null)
            return false;
        } else if (!text.equals(other.text))
          return false; 
        if (attachments == null) {
          if (other.attachments != null)
            return false;
        } else if (!attachments.equals(other.attachments))
          return false; 

        return true;
      }


      @Override
      public String toString() {
        return "Message [" + 
       "sender=" + sender +  ", " +    "title=" + title +  ", " +    "text=" + text +  ", " +    "attachments=" + attachments +  
          "]";
      }

}
