package com.bestbuy.todo.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * This is a utility class for reading data from properties file.
 * 
 * @author a122259
 */
@Component("xmlManager")
public class XMLManager {

  final static Logger logger = LoggerFactory.getLogger(XMLManager.class);

  /**
   * This method tries to load the passed file name from all the possible locations
   * associated with this project. Normally it tries to load the File from the
   * project resources, if it fails it tries to load it from the current directory
   * and if it fails it tries to load it using absolute path using user.dir system
   * properties as prefix.
   * 
   * @param filename
   *          The name of the file to retrieve. It can contain subdirectories
   * @return InputStream pointing to the requested file. null if it fails to locate
   *         the requested file.
   */

  public synchronized InputStream tryToLoadFromEverywhere(String filename) {
    InputStream result = null;
    result = System.class.getResourceAsStream(filename);
    if (result != null) {
      return result;
    }

    result = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);
    if (result != null) {
      return result;
    }

    result = Thread.currentThread().getClass().getResourceAsStream(filename);
    if (result != null) {
      return result;
    }

    result = ClassLoader.getSystemResourceAsStream(filename);
    if (result != null) {
      return result;
    }
    result = ClassLoader.getSystemClassLoader().getResourceAsStream(filename);
    if (result != null) {
      return result;
    }

    return result;
  }

  public String getXMLFromFile(String fileName) {

    InputStream inputStream = tryToLoadFromEverywhere(fileName);
    BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
    StringBuilder sb = new StringBuilder();

    try {
      String line = null;
      while ((line = br.readLine()) != null) {
        sb.append(line);
      }
      br.close();
    } catch (IOException e) {
      logger.error("Exception occurred while getStringFromFile" + fileName, e);
    }
    return sb.toString();

  }
}
