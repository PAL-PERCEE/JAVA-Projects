package fr.inria.phoenix.diasuite.framework.distributed.texttospeech;


import java.io.Serializable;

public final class TextToAudioIndices implements Serializable {
    private static final long serialVersionUID = 0;
  
  private java.lang.String text;
  
  public java.lang.String text() {
  	return text;
  }
  
  public void setText(java.lang.String text) {
  	this.text = text;
  }


  public TextToAudioIndices(java.lang.String text) {
    this.text = text;

  }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((text == null) ? 0 : text.hashCode());

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
      TextToAudioIndices other = (TextToAudioIndices) obj;
      if (text == null) {
        if (other.text != null)
          return false;
      } else if (!text.equals(other.text))
        return false; 

      return true;
    }

}