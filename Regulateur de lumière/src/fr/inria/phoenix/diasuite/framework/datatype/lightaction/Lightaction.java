package fr.inria.phoenix.diasuite.framework.datatype.lightaction;
import java.io.Serializable;


/**
 * 
 *
 * @[4,0]
 * structure Lightaction {
 * value as Integer;
 * state as LightState;
 * }
 */
public class Lightaction implements Serializable {

    private static final long serialVersionUID = 0;
    private java.lang.Integer value;
    
    public java.lang.Integer getValue() {
        return value;
    }
    
    public void setValue(java.lang.Integer newValueValue) {
        this.value = newValueValue;
    }
    private fr.inria.phoenix.diasuite.framework.datatype.lightstate.LightState state;
    
    public fr.inria.phoenix.diasuite.framework.datatype.lightstate.LightState getState() {
        return state;
    }
    
    public void setState(fr.inria.phoenix.diasuite.framework.datatype.lightstate.LightState newStateValue) {
        this.state = newStateValue;
    }

    public Lightaction() {
    }
  
    public Lightaction(java.lang.Integer value, fr.inria.phoenix.diasuite.framework.datatype.lightstate.LightState state) {
      this.value = value;      
      this.state = state;      

    }    
      @Override
      public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        result = prime * result + ((state == null) ? 0 : state.hashCode());

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
        Lightaction other = (Lightaction) obj;
        if (value == null) {
          if (other.value != null)
            return false;
        } else if (!value.equals(other.value))
          return false; 
        if (state == null) {
          if (other.state != null)
            return false;
        } else if (!state.equals(other.state))
          return false; 

        return true;
      }


      @Override
      public String toString() {
        return "Lightaction [" + 
       "value=" + value +  ", " +    "state=" + state +  
          "]";
      }

}
