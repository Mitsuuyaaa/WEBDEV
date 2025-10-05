package com.Salazar.Exemptions;

public class UsernameNotFoundException extends RuntimeException{
  UsernameNotFoundException(String message){
    super(message);
  }
}