package fr.inria.phoenix.diasuite.framework.distributed.texttospeech;

import java.io.Serializable;

import fr.inria.diagen.core.network.RemoteServiceInfo;
import fr.inria.diagen.core.service.local.Service;
import fr.inria.diagen.core.service.proxy.Proxy;


public final class TextToAudioFromTextToSpeech implements Serializable {
    private static final long serialVersionUID = 0;
  
  private fr.inria.phoenix.diasuite.framework.datatype.file.File value;

  public fr.inria.phoenix.diasuite.framework.datatype.file.File value(){
    return value;
  }

  public TextToAudioFromTextToSpeech(Service service, RemoteServiceInfo remoteServiceInfo, fr.inria.phoenix.diasuite.framework.datatype.file.File value, TextToAudioIndices indices) {
    this.sender = new TextToSpeechProxy(service, remoteServiceInfo);
    this.value = value;
    this.indices = indices;
  }
  
  public TextToAudioFromTextToSpeech(Service service, RemoteServiceInfo remoteServiceInfo, fr.inria.phoenix.diasuite.framework.datatype.file.File value, java.lang.String text) {
    this.sender = new TextToSpeechProxy(service, remoteServiceInfo);
    this.value = value;
    this.indices = new TextToAudioIndices(text);
  }
  
  private TextToAudioIndices indices;
  
  public TextToAudioIndices indices(){
    return indices;
  }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((value == null) ? 0 : value.hashCode());
      result = prime * result + ((indices == null) ? 0 : indices.hashCode());

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
      TextToAudioFromTextToSpeech other = (TextToAudioFromTextToSpeech) obj;
      if (value == null) {
        if (other.value != null)
          return false;
      } else if (!value.equals(other.value))
        return false; 
      if (indices == null) {
        if (other.indices != null)
          return false;
      } else if (!indices.equals(other.indices))
        return false; 

      return true;
    }

  private TextToSpeechProxy sender;
  
  public TextToSpeechProxy sender() {
    return sender;
  }

  public class TextToSpeechProxy extends Proxy {
    private TextToSpeechProxy(Service service, RemoteServiceInfo remoteServiceInfo) {
      super(service, remoteServiceInfo);
    }


    public java.lang.String id() {
      return (java.lang.String) getService().getProcessor().callGetValue(getService().getOutProperties(), getRemoteServiceInfo(), "id");
    }

    public java.lang.String location() {
      return (java.lang.String) getService().getProcessor().callGetValue(getService().getOutProperties(), getRemoteServiceInfo(), "location");
    }

    public java.lang.String user() {
      return (java.lang.String) getService().getProcessor().callGetValue(getService().getOutProperties(), getRemoteServiceInfo(), "user");
    }


    public void subscribeTextToAudio() {
      getService().getProcessor().subscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "textToAudio");
    }

    public void unsubscribeTextToAudio() {
      getService().getProcessor().unsubscribeValue(getService().getOutProperties(), new fr.inria.diagen.core.service.filter.SubscriptionFilter(this.getRemoteServiceInfo()), "textToAudio");
    }
  }

}