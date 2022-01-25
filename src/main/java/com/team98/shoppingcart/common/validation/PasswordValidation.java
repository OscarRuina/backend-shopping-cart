package com.team98.shoppingcart.common.validation;

public class PasswordValidation {

  public static boolean isValid(String password) {
    return password.length() >= 8;
  }

}
