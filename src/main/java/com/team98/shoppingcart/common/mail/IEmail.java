package com.team98.shoppingcart.common.mail;

public interface IEmail {
  String getEmailTo();

  String getSubject();

  IContent getContent();
}
