package fr.inria.phoenix.diasuite.framework.datatype.date;
import java.io.Serializable;


/**
 * 
 *
 * @[55,0]
 * structure Date {
 * day as Integer;
 * month as Integer;
 * year as Integer;
 * hour as Integer;
 * minute as Integer;
 * }
 */
public class Date implements Serializable {

    private static final long serialVersionUID = 0;
    private java.lang.Integer day;
    
    public java.lang.Integer getDay() {
        return day;
    }
    
    public void setDay(java.lang.Integer newDayValue) {
        this.day = newDayValue;
    }
    private java.lang.Integer month;
    
    public java.lang.Integer getMonth() {
        return month;
    }
    
    public void setMonth(java.lang.Integer newMonthValue) {
        this.month = newMonthValue;
    }
    private java.lang.Integer year;
    
    public java.lang.Integer getYear() {
        return year;
    }
    
    public void setYear(java.lang.Integer newYearValue) {
        this.year = newYearValue;
    }
    private java.lang.Integer hour;
    
    public java.lang.Integer getHour() {
        return hour;
    }
    
    public void setHour(java.lang.Integer newHourValue) {
        this.hour = newHourValue;
    }
    private java.lang.Integer minute;
    
    public java.lang.Integer getMinute() {
        return minute;
    }
    
    public void setMinute(java.lang.Integer newMinuteValue) {
        this.minute = newMinuteValue;
    }

    public Date() {
    }
  
    public Date(java.lang.Integer day, java.lang.Integer month, java.lang.Integer year, java.lang.Integer hour, java.lang.Integer minute) {
      this.day = day;      
      this.month = month;      
      this.year = year;      
      this.hour = hour;      
      this.minute = minute;      

    }    
      @Override
      public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((day == null) ? 0 : day.hashCode());
        result = prime * result + ((month == null) ? 0 : month.hashCode());
        result = prime * result + ((year == null) ? 0 : year.hashCode());
        result = prime * result + ((hour == null) ? 0 : hour.hashCode());
        result = prime * result + ((minute == null) ? 0 : minute.hashCode());

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
        Date other = (Date) obj;
        if (day == null) {
          if (other.day != null)
            return false;
        } else if (!day.equals(other.day))
          return false; 
        if (month == null) {
          if (other.month != null)
            return false;
        } else if (!month.equals(other.month))
          return false; 
        if (year == null) {
          if (other.year != null)
            return false;
        } else if (!year.equals(other.year))
          return false; 
        if (hour == null) {
          if (other.hour != null)
            return false;
        } else if (!hour.equals(other.hour))
          return false; 
        if (minute == null) {
          if (other.minute != null)
            return false;
        } else if (!minute.equals(other.minute))
          return false; 

        return true;
      }


      @Override
      public String toString() {
        return "Date [" + 
       "day=" + day +  ", " +    "month=" + month +  ", " +    "year=" + year +  ", " +    "hour=" + hour +  ", " +    "minute=" + minute +  
          "]";
      }

}
