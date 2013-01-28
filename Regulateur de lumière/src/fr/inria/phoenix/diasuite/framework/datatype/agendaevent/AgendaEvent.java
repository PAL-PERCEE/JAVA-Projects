package fr.inria.phoenix.diasuite.framework.datatype.agendaevent;
import java.io.Serializable;


/**
 * 
 *
 * @[63,0]
 * structure AgendaEvent {
 * title as String;
 * description as String;
 * startTime as Date;
 * endTime as Date;
 * place as String;
 * calendar as String;
 * }
 */
public class AgendaEvent implements Serializable {

    private static final long serialVersionUID = 0;
    private java.lang.String title;
    
    public java.lang.String getTitle() {
        return title;
    }
    
    public void setTitle(java.lang.String newTitleValue) {
        this.title = newTitleValue;
    }
    private java.lang.String description;
    
    public java.lang.String getDescription() {
        return description;
    }
    
    public void setDescription(java.lang.String newDescriptionValue) {
        this.description = newDescriptionValue;
    }
    private fr.inria.phoenix.diasuite.framework.datatype.date.Date startTime;
    
    public fr.inria.phoenix.diasuite.framework.datatype.date.Date getStartTime() {
        return startTime;
    }
    
    public void setStartTime(fr.inria.phoenix.diasuite.framework.datatype.date.Date newStartTimeValue) {
        this.startTime = newStartTimeValue;
    }
    private fr.inria.phoenix.diasuite.framework.datatype.date.Date endTime;
    
    public fr.inria.phoenix.diasuite.framework.datatype.date.Date getEndTime() {
        return endTime;
    }
    
    public void setEndTime(fr.inria.phoenix.diasuite.framework.datatype.date.Date newEndTimeValue) {
        this.endTime = newEndTimeValue;
    }
    private java.lang.String place;
    
    public java.lang.String getPlace() {
        return place;
    }
    
    public void setPlace(java.lang.String newPlaceValue) {
        this.place = newPlaceValue;
    }
    private java.lang.String calendar;
    
    public java.lang.String getCalendar() {
        return calendar;
    }
    
    public void setCalendar(java.lang.String newCalendarValue) {
        this.calendar = newCalendarValue;
    }

    public AgendaEvent() {
    }
  
    public AgendaEvent(java.lang.String title, java.lang.String description, fr.inria.phoenix.diasuite.framework.datatype.date.Date startTime, fr.inria.phoenix.diasuite.framework.datatype.date.Date endTime, java.lang.String place, java.lang.String calendar) {
      this.title = title;      
      this.description = description;      
      this.startTime = startTime;      
      this.endTime = endTime;      
      this.place = place;      
      this.calendar = calendar;      

    }    
      @Override
      public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
        result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
        result = prime * result + ((place == null) ? 0 : place.hashCode());
        result = prime * result + ((calendar == null) ? 0 : calendar.hashCode());

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
        AgendaEvent other = (AgendaEvent) obj;
        if (title == null) {
          if (other.title != null)
            return false;
        } else if (!title.equals(other.title))
          return false; 
        if (description == null) {
          if (other.description != null)
            return false;
        } else if (!description.equals(other.description))
          return false; 
        if (startTime == null) {
          if (other.startTime != null)
            return false;
        } else if (!startTime.equals(other.startTime))
          return false; 
        if (endTime == null) {
          if (other.endTime != null)
            return false;
        } else if (!endTime.equals(other.endTime))
          return false; 
        if (place == null) {
          if (other.place != null)
            return false;
        } else if (!place.equals(other.place))
          return false; 
        if (calendar == null) {
          if (other.calendar != null)
            return false;
        } else if (!calendar.equals(other.calendar))
          return false; 

        return true;
      }


      @Override
      public String toString() {
        return "AgendaEvent [" + 
       "title=" + title +  ", " +    "description=" + description +  ", " +    "startTime=" + startTime +  ", " +    "endTime=" + endTime +  ", " +    "place=" + place +  ", " +    "calendar=" + calendar +  
          "]";
      }

}
