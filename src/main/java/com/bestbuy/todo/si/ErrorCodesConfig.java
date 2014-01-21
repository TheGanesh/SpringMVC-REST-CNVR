package com.bestbuy.todo.si;

import java.io.ByteArrayInputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Component;

import com.bestbuy.todo.utils.ErrorPair;
import com.bestbuy.todo.utils.Errors;
import com.bestbuy.todo.utils.XMLManager;

@Component("errorCodesConfig")
public class ErrorCodesConfig {

  private Map<String, ErrorPair> errorsMap;

  public ErrorCodesConfig() {

    String scheduledJobsXML = new XMLManager().getXMLFromFile("Errors.xml");
    Errors errors = unmarshallSecheduledJobs(scheduledJobsXML);

    Map<String, ErrorPair> errorsMap = new LinkedHashMap<String, ErrorPair>();

    for (Errors.Error err : errors.getError()) {

      ErrorPair errPair = new ErrorPair();
      errPair.setHttpStatusCode(err.getHttpStatusCode());
      errPair.setMessage(err.getMessage());
      errorsMap.put(err.getCode(), errPair);

    }
    this.errorsMap = errorsMap;

  }

  private Errors unmarshallSecheduledJobs(String xml) {

    try {
      JAXBContext jaxbContext = JAXBContext.newInstance(Errors.class);
      Unmarshaller jaxbUnmarshaller;
      jaxbUnmarshaller = jaxbContext.createUnmarshaller();
      Errors scheduledJobs = (Errors) jaxbUnmarshaller.unmarshal(new ByteArrayInputStream(xml.getBytes()));
      return scheduledJobs;

    } catch (JAXBException e) {
      e.printStackTrace();
    }
    return null;
  }

  public Map<String, ErrorPair> getErrorsMap() {
    return errorsMap;
  }

  public void setErrorsMap(Map<String, ErrorPair> errorsMap) {
    this.errorsMap = errorsMap;
  }

}
