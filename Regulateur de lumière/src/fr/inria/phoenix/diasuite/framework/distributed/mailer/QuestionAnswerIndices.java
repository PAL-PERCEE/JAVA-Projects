package fr.inria.phoenix.diasuite.framework.distributed.mailer;


import java.io.Serializable;

public final class QuestionAnswerIndices implements Serializable {
    private static final long serialVersionUID = 0;
  
  private java.lang.String questionId;
  
  public java.lang.String questionId() {
  	return questionId;
  }
  
  public void setQuestionId(java.lang.String questionId) {
  	this.questionId = questionId;
  }


  public QuestionAnswerIndices(java.lang.String questionId) {
    this.questionId = questionId;

  }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((questionId == null) ? 0 : questionId.hashCode());

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
      QuestionAnswerIndices other = (QuestionAnswerIndices) obj;
      if (questionId == null) {
        if (other.questionId != null)
          return false;
      } else if (!questionId.equals(other.questionId))
        return false; 

      return true;
    }

}