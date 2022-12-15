package model;

public class telephone {
	private String numTelephone;
	private client_parent client;
	
	public telephone(String _numTelephone, client_parent _client) {
		this.numTelephone = _numTelephone;
		this.client = _client;		
	}
	
	
	public String getNumTelephone() {
		return numTelephone;
	}
	public void setNumTelephone(String numTelephone) {
		this.numTelephone = numTelephone;
	}
	public client_parent getClient() {
		return client;
	}
	public void setClient(client_parent client) {
		this.client = client;
	}
	

}
