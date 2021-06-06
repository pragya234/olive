package com.doctorvinci.doctorvinci.dbservice.entity;

import com.doctorvinci.doctorvinci.models.UserType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "log_in_request")
public class LogInRequestEntity {
  @Column(name = "mobile_number")
  private String mobileNumber;

  @Column(name = "user_type")
  private UserType userType;
}
