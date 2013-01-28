package fr.inria.phoenix.diasuite.framework.datatype.tvschedule;
import java.io.Serializable;


/**
 * 
 *
 * @[137,0]
 * structure TvSchedule {
 * title as String;
 * description as String;
 * genre as String;
 * startTime as Date;
 * endTime as Date;
 * channel as String;
 * }
 */
public class TvSchedule implements Serializable {

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
    private java.lang.String genre;
    
    public java.lang.String getGenre() {
        return genre;
    }
    
    public void setGenre(java.lang.String newGenreValue) {
        this.genre = newGenreValue;
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
    private java.lang.String channel;
    
    public java.lang.String getChannel() {
        return channel;
    }
    
    public void setChannel(java.lang.String newChannelValue) {
        this.channel = newChannelValue;
    }

    public TvSchedule() {
    }
  
    public TvSchedule(java.lang.String title, java.lang.String description, java.lang.String genre, fr.inria.phoenix.diasuite.framework.datatype.date.Date startTime, fr.inria.phoenix.diasuite.framework.datatype.date.Date endTime, java.lang.String channel) {
      this.title = title;      
      this.description = description;      
      this.genre = genre;      
      this.startTime = startTime;      
      this.endTime = endTime;      
      this.channel = channel;      

    }    
      @Override
      public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((genre == null) ? 0 : genre.hashCode());
        result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
        result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
        result = prime * result + ((channel == null) ? 0 : channel.hashCode());

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
        TvSchedule other = (TvSchedule) obj;
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
        if (genre == null) {
          if (other.genre != null)
            return false;
        } else if (!genre.equals(other.genre))
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
        if (channel == null) {
          if (other.channel != null)
            return false;
        } else if (!channel.equals(other.channel))
          return false; 

        return true;
      }


      @Override
      public String toString() {
        return "TvSchedule [" + 
       "title=" + title +  ", " +    "description=" + description +  ", " +    "genre=" + genre +  ", " +    "startTime=" + startTime +  ", " +    "endTime=" + endTime +  ", " +    "channel=" + channel +  
          "]";
      }

}
