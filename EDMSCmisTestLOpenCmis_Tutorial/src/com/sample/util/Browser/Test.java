package com.sample.util.Browser;

import java.util.List;

import org.apache.chemistry.opencmis.client.api.Repository;

public class Test {

	public static void main(String args[]) {
		String urlToConnect = "http://localhost:8089/chemistry-opencmis-server-inmemory-1.1.0/browser";

		RepositoryUtil repoUtil = new BrowserBindingRepositoryUtil("", "", urlToConnect);

		List<Repository> repositories = repoUtil.getAllRepositories();

		for (Repository repository : repositories) {
			System.out.println(repository.getName());
		}

	}
}