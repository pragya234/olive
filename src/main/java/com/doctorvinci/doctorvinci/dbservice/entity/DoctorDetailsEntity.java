package com.doctorvinci.doctorvinci.dbservice.entity;

import com.doctorvinci.doctorvinci.models.DoctorType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "doctor_details")
public class DoctorDetailsEntity {
  @Column(name = "doctor_id")
  private int doctorId;

  private String name;

  @Column(name = "phone_number")
  private String phoneNumber;

  @Column(name = "email_id")
  private String emailId;

  @Column(name = "helper_contact")
  private String helperContact;

  @Column(name = "address_id")
  private int addressId;

  @Column(name = "doctor_fee")
  private int doctorFee;

  @Column(name ="is_hospital_doctor")
  private boolean isHospitalDoctor;

  @Column(name = "hospital_id")
  private int hospitalId;

  @Column(name = "doctor_description")
  private String doctorDescription;

  @Column(name = "doctor_image_url")
  private String doctorImageUrl;

  @Column(name = "doctor_type")
  private DoctorType doctorType;

  @Column(name = "has_allowed_free_revisit")
  private boolean hasAllowedFreeRevisit;

  @Column(name = "free_revisit_till_x_days_after_order")
  private int freeRevisitTillXDaysAfterOrder;

  @Column(name = "has_allowed_free_chat")
  private boolean hasAllowedFreeChat;

  @Column(name = "free_chat_till_x_days_after_order")
  private int freeChatTillXDaysAfterOrder;

}

/*
like models are used for adan pradan of data with front end, entities are used for adan pradan of data with database
DoctorDetailsEntity is a plain java class, we will make it entity by annotating the class with @Entity
to tell jvm which table this entity should be persisted/fetched from we annotate the class with @Table providing the table name
like models here also variables are private that means no one from outside this class will be directly able to access the variable
so in order to make the variable accessible we need to have getter and setter method for variable and that is why
  I am going to use @Data also
 just declaring @Entity make sure to map the variable with exactly same named column in the table
 but if we want to map variable with a column whose name are not same, we need
 to annotate @Column ("exact column name in the table")on the variable
 java best practice suggest variable name should be camelcase, while sql best practice suggest that variable name should be
 all small with _ between them

 */
