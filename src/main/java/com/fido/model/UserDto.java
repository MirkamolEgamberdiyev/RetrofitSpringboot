package com.fido.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private String i_Method_Name;
    private int i_User_Id;
    private String i_First_Name;
    private String i_Last_Name;
    private String i_Username;
    private String i_Password;
    private String i_Email;
    private String i_Token;
    private String i_Token_Expiry;
    private String i_Card_Number;
    private String i_Card_Expiry_Date;
    private String i_Card_Cvv;
    private String i_Card_Type;
}
