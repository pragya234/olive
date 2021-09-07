package com.olive.olive.dbservice.entity;

import com.olive.olive.models.UserType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "log_in_request")
public class LogInRequestEntity {
  @Id
  @Column(name = "mobile_number")
  private String mobileNumber;

  @Column(name = "user_type")
  private UserType userType;
}
