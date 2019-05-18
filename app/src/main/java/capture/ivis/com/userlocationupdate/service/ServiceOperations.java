package capture.ivis.com.userlocationupdate.service;

import com.google.gson.JsonObject;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.mime.MultipartTypedOutput;


public interface ServiceOperations {

//    @FormUrlEncoded
//    @POST("/login")
//    void login(@Field("reg_mobileNum") String mobileNum, @Field("password") String password
//            , Callback<JsonObject> callback);

    @GET("/MobileAPI?action=loginauth&username=iv3481&password=JgwKqWd2")
    void login( Callback<JsonObject> jsonObjectCallback);
//    @GET
//    public Call<ResponseBody> profilePicture(@Url String url);



































    @FormUrlEncoded
    @POST("/getdropdownlist")
    void SigupBasicDetails(@Field("dropdown_id") String Marital_Status, Callback<JsonObject> callback);

    @FormUrlEncoded
    @POST("/getdropdownlist")
    void SigupCaste(@Field("dropdown_id") String caste, Callback<JsonObject> callback);

    @FormUrlEncoded
    @POST("/getdropdownlist")
    void SigupSkinTone(@Field("dropdown_id") String skintone, Callback<JsonObject> callback);

    @FormUrlEncoded
    @POST("/getdropdownlist")
    void SigupBloodGroup(@Field("dropdown_id") String bloodgroup, Callback<JsonObject> callback);

    @FormUrlEncoded
    @POST("/getdropdownlist")
    void SigupMotherTongue(@Field("dropdown_id") String mothertongue, Callback<JsonObject> callback);


    @FormUrlEncoded
    @POST("/getdropdownlist")
    void SigupProfessionalDetails(@Field("dropdown_id") String Qualification
            , Callback<JsonObject> callback);

    @FormUrlEncoded
    @POST("/getdropdownlist")
    void SignupBodyType(@Field("dropdown_id") String bodytype
            , Callback<JsonObject> callback);


    @FormUrlEncoded
    @POST("/getCities")
    void SigupCity(@Field("state_ID") String state_ID
            , Callback<JsonObject> callback);

    @FormUrlEncoded
    @POST("/getprofile")
    void SigupProfileDetails(@Field("reg_mobileNum") String reg_mobileNum
            , Callback<JsonObject> callback);




    @FormUrlEncoded
    @POST("/getdropdownlist")
    void SigupReligion(@Field("dropdown_id") String religion
            , Callback<JsonObject> callback);


    @Headers("Accept:application/json")
    @POST("/register")
    void registerUser(@Body MultipartTypedOutput multipartTypedOutput, Callback<JsonObject> jsonObjectCall);


    @POST("/home")
    void HomeProfileDetails(@Body MultipartTypedOutput multipartTypedOutput, Callback<JsonObject> callback);



    @FormUrlEncoded
    @POST("/nearmatches")
    void nearByMe(@Field("reg_gender") String gender, @Field("reg_place") String place,
                  Callback<JsonObject> callback);

    @FormUrlEncoded
    @POST("/getdropdownlist")
    void SigupDesignation(@Field("dropdown_id") String profession
            , Callback<JsonObject> callback);



    @PUT("/register")
    void UpdateProfileDetails(@Body MultipartTypedOutput multipartTypedOutput, Callback<JsonObject> callback);

    @FormUrlEncoded
    @POST("/search")
    void searchDetails
            (@Field("reg_gender") String gender, @Field("reg_patner_age_from") String ageFrom,
             @Field("reg_patner_age_to") String ageTo, @Field("reg_patner_qualification") String qualification,
             @Field("reg_patner_Profession") String profession, @Field("reg_patner_workingarea") String workingarea,
             @Field("reg_patner_caste") String patnercaste,
             @Field("reg_patner_height_from") String heightfrom, @Field("reg_patner_height_to") String patnerheightto,
             @Field("reg_patner_bloodgroup") String bloodgroup, Callback<JsonObject> callback);



    @FormUrlEncoded
    @POST("/connected")
    void SendingConnected(@Field("useridFrom") String useridFrom, @Field("status") String status,
                          @Field("useridTo") String userId, Callback<JsonObject> callback);








}
