package com.sample.util.Browser.Folders;

import java.util.HashMap;
import java.util.Map;

import org.apache.chemistry.opencmis.client.api.Folder;
import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.client.api.SessionFactory;
import org.apache.chemistry.opencmis.client.runtime.SessionFactoryImpl;
import org.apache.chemistry.opencmis.commons.SessionParameter;
import org.apache.chemistry.opencmis.commons.enums.BindingType;

public class CreateFolder {

 private static String serverURL = "http://localhost:8089/chemistry-opencmis-server-inmemory-1.1.0/browser";
 private static String repositoryId = "A1";

 public static Session getSession() {
  Map<String, String> parameters = new HashMap<>();
  parameters.put(SessionParameter.BINDING_TYPE, BindingType.BROWSER.value());

  parameters.put(SessionParameter.USER, "");
  parameters.put(SessionParameter.PASSWORD, "");

  parameters.put(SessionParameter.REPOSITORY_ID, repositoryId);
  parameters.put(SessionParameter.BROWSER_URL, serverURL);

  SessionFactory sessionFactory = SessionFactoryImpl.newInstance();
  return sessionFactory.createSession(parameters);
 }

 public static void main(String args[]) {
  Session session = getSession();

  Folder rootFolder = session.getRootFolder();

  Map<String, String> properties = new HashMap<>();
  properties.put("cmis:objectTypeId", "cmis:folder");
  properties.put("cmis:name", "My_Folder-0-0");

  Folder folder = rootFolder.createFolder(properties);

  System.out.println("Name Of the Folder " + folder.getName());
  System.out.println("Path Of the Folder " + folder.getPaths().get(0));
 }
}