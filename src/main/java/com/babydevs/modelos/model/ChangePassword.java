package com.babydevs.modelos.model;

public class ChangePassword {
	private String password;
	private String newPassword;
	
	public ChangePassword() {}//constructor
	public ChangePassword(String password, String newPassword) {
			this.password = password;
			this.newPassword = newPassword;
		}//Constructor
	
		public String getPassword() {
			return password;
		}//getPassword
		public void setPassword(String password) {
			this.password = password;
		}//setPassword
		public String getNewPassword() {
			return newPassword;
		}//getNewPassword
		public void setNewPassword(String newPassword) {
			this.newPassword = newPassword;
		}//setPassword

		@Override
		public String toString() {
			return"ChangePassword [password=" + password + ", newPassword=" + newPassword +  "]";
		}
}//Class ChangePassword