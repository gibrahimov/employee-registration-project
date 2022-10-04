package com.cydeo.model;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {

//    @NotNull        --->    Field shouldn't be null
//    @NotEmpty       --->    Field shouldn't be ""
//    @NotBlank       --->    Field shouldn't be "       "
    //@NotBlank covers @NotNull and @NotEmpty so just @NotBlank is enough

//    @NotNull -> @NotNull
//    @NotEmpty -> @NotNull + @NotEmpty
//    @NotBlank -> @NotNull + @NotEmpty + @NotBlank

    @NotBlank
    @Size(max = 12, min = 2)
    private String firstName;
    private String lastName;
    //Thymeleaf accepts yyy-MM-dd format, but LocalDate accepts mm-dd-yyyy(so not the same)

  //@NotNull
   @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

  //@NotBlank
 // @Email
    private String email;

//  @NotBlank
 // @@Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,}")
    private String password;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zipCode;







}
