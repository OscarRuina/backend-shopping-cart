package com.team98.shoppingcart.common.mail.template;

import com.team98.shoppingcart.common.mail.IContent;
import com.team98.shoppingcart.common.mail.IEmail;

public class ContactTemplateEmail implements IEmail, IContent {

  private static final String TYPE = "text/plain";
  private static final String VALUE = "Thank you for contact us";
  private static final String SUBJECT = "Contact Receive";

  private final String email;

  public ContactTemplateEmail(String email) {
    this.email = email;
  }

  @Override
  public String getType() {
    return TYPE;
  }

  @Override
  public String getValue() {
    return VALUE;
  }

  @Override
  public String getEmailTo() {
    return email;
  }

  @Override
  public String getSubject() {
    return SUBJECT;
  }

  @Override
  public IContent getContent() {
    return this;
  }

}
