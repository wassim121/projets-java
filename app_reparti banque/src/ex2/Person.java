package ex2;

import java.io.Serializable;

public class Person implements Serializable {
    private String username;
    private String password;
    private int solde;

    public Person(String username, String password,int solde) {
        this.username = username;
        this.password = password;
        this.solde=solde;
    }

    public int getSolde() {
		return solde;
	}

	public int setSolde(int solde) {
		 return this.solde = solde;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
