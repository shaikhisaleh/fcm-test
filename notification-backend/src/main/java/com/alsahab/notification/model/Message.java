package com.alsahab.notification.model;

/*
 * Author: Saleh Alshaikhi
 */

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Message {
  private String topic;
  private String data;
}
