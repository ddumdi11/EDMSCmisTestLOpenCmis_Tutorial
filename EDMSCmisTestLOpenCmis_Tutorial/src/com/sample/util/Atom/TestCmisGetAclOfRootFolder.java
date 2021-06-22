package com.sample.util.Atom;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.chemistry.opencmis.client.api.Folder;
import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.client.api.SessionFactory;
import org.apache.chemistry.opencmis.client.runtime.SessionFactoryImpl;
import org.apache.chemistry.opencmis.commons.SessionParameter;
import org.apache.chemistry.opencmis.commons.data.Ace;
import org.apache.chemistry.opencmis.commons.data.Acl;
import org.apache.chemistry.opencmis.commons.enums.BindingType;

public class TestCmisGetAclOfRootFolder {

	private static String serverURL = "http://localhost:8089/chemistry-opencmis-server-inmemory-1.1.0/atom11";
	private static String repositoryId = "A1";

	public static Session getSession() {
		Map<String, String> parameters = new HashMap<>();
		parameters.put(SessionParameter.BINDING_TYPE, BindingType.ATOMPUB.value());

		parameters.put(SessionParameter.USER, "");
		parameters.put(SessionParameter.PASSWORD, "");

		parameters.put(SessionParameter.REPOSITORY_ID, repositoryId);
		parameters.put(SessionParameter.ATOMPUB_URL, serverURL);

		SessionFactory sessionFactory = SessionFactoryImpl.newInstance();
		return sessionFactory.createSession(parameters);
	}

	public static void main(String args[]) {
		Session session = getSession();

		Folder folder = session.getRootFolder();

		Acl acl = folder.getAcl();

		if (acl == null) {
			System.out.println("No acl is associated with root folder");
			return;
		}

		List<Ace> aces = acl.getAces();

		for (Ace ace : aces) {
			System.out.println(ace.getPermissions());
		}

	}

}