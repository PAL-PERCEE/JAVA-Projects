package fr.inria.phoenix.diasuite.framework.datatype.windinfo;
import java.io.Serializable;


/**
 * 
 *
 * @[92,0]
 * structure WindInfo {
 * speed as Float;
 * direction as String;
 * }
 */
public class WindInfo implements Serializable {

    private static final long serialVersionUID = 0;
    private java.lang.Float speed;
    
    public java.lang.Float getSpeed() {
        return speed;
    }
    
    public void setSpeed(java.lang.Float newSpeedValue) {
        this.speed = newSpeedValue;
    }
    private java.lang.String direction;
    
    public java.lang.String getDirection() {
        return direction;
    }
    
    public void setDirection(java.lang.String newDirectionValue) {
        this.direction = newDirectionValue;
    }

    public WindInfo() {
    }
  
    public WindInfo(java.lang.Float speed, java.lang.String direction) {
      this.speed = speed;      
      this.direction = direction;      

    }    
      @Override
      public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((speed == null) ? 0 : speed.hashCode());
        result = prime * result + ((direction == null) ? 0 : direction.hashCode());

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
        WindInfo other = (WindInfo) obj;
        if (speed == null) {
          if (other.speed != null)
            return false;
        } else if (!speed.equals(other.speed))
          return false; 
        if (direction == null) {
          if (other.direction != null)
            return false;
        } else if (!direction.equals(other.direction))
          return false; 

        return true;
      }


      @Override
      public String toString() {
        return "WindInfo [" + 
       "speed=" + speed +  ", " +    "direction=" + direction +  
          "]";
      }

}
