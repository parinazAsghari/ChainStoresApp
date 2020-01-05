package com.example.parinaz.chainstoresapp.databinding;

public class ViewModel extends android.arch.lifecycle.ViewModel {
    private String userName,lastName,emailAddress;
    public void setUserName(String userName){
        this.userName = userName;
    }
    public void  setLastName(String lastName){
        this.lastName = lastName;
    }

   public  void setEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
   }

    public String getUserName() {
        return userName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
