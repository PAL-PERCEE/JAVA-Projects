package fr.inria.phoenix.diasuite.framework.datatype.email;
import java.io.Serializable;


/**
 * 
 *
 * @[42,0]
 * structure Email {
 * title as String;
 * text as String;
 * date as String;
 * }
 */
public class Email implements Serializable {

    private static final long serialVersionUID = 0;
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
    private java.lang.String date;
    
    public java.lang.String getDate() {
        return date;
    }
    
    public void setDate(java.lang.String newDateValue) {
        this.date = newDateValue;
    }

    public Email() {
    }
  
    public Email(java.lang.String title, java.lang.String text, java.lang.String date) {
      this.title = title;      
      this.text = text;      
      this.date = date;      

    }    
      @Override
      public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((text == null) ? 0 : text.hashCode());
        result = prime * result + ((date == null) ? 0 : date.hashCode());

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
        Email other = (Email) obj;
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
        if (date == null) {
          if (other.date != null)
            return false;
        } else if (!date.equals(other.date))
          return false; 

        return true;
      }


      @Override
      public String toString() {
        return "Email [" + 
       "title=" + title +  ", " +    "text=" + text +  ", " +    "date=" + date +  
          "]";
      }

}
