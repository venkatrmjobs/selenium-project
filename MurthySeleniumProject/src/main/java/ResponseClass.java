import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
        import org.json.JSONObject;

        import java.util.HashMap;
        import java.util.Map;

public class ResponseClass {

    public static Response response() {
        String auth = "eyJhbGciOiJSUzI1NiJ9.ewogICAgImRlYWxlckNvZGUiOiAiMDAwMDAwMiIsCiAgICAidXNlcl9uYW1lIjogInZrdXBlcm0iLAogICAgInNjb3BlIjogWwogICAgICAgICJyZWFkIiwKICAgICAgICAid3JpdGUiLAogICAgICAgICJvcGVuaWQiCiAgICBdLAogICAgImFwcGxpY2F0aW9uVXNlcklkIjogInZrdXBlcm0iLAogICAgImV4cCI6IDE5OTU5OTY1MDUsCiAgICAic3RvcmVJZCI6ICI5OTk5IiwKICAgICJhdXRob3JpdGllcyI6IFsKICAgICAgICAiQVBQTElDQVRJT05fSU5GTzpBRE1JTklTVEVSX0FQUExJQ0FUSU9OIiwKIlJBVEVfUExBTlNfQU5EX0ZFQVRVUkVTOkNIQU5HRV9SQVRFX1BMQU4iLAogICAgICAgICJBQ0NPVU5UX0lORk86VklFV19SQVRFX1BMQU5fSElTVE9SWSIsCiAgICAgICAgIlJBVEVfUExBTlNfQU5EX0ZFQVRVUkVTOk9WRVJSSURFX0RFVklDRV9VTkxPQ0tfRUxJR0lCSUxJVFkiCiAgICBdLAogICAgImp0aSI6ICI1NDVmM2VmZS05YjYxLTQ0MTMtODQ5Zi1iNjRhZThiNmI4ZjMiLAogICAgImNoYW5uZWxJZCI6ICJSRVRBSUwiLAogICAgImNsaWVudF9pZCI6ICJmbGFtZSIKfQ.cmpUQQhNdwjMLFDInfV6C_l89MuWCVvnzTGrb7l_6hUcYAs1QVjLcmbzr8nslfSugzctvsPUk4QWRJGghsURsaDHcOZEg72wwaKG55qyVF2-fKq_4Wr7AAntSzBSEuEiu9E_oqjmpFzGf5EtyK1G1B4R-6PofsmJFx2QxOkdn1aBYLgLlsyY1_E4pFTb3MzUF90_IcdG37R_O-bPcny6EA8X9vu8_AGfZBQb136NhAAsKYo6SUC228hO96OAWqzuiADkiW6sS_H6xiLvrleQtbYW_yoVCEwl436ZTWGNX0RSaigjavtDjrHHM6yIDcOOmbiEI8zj312TVOMm2JUzqA";
//        JSONObject requestParams1 = new JSONObject();
        Map<String, String> requestParams = new HashMap<String, String>();
        requestParams.put("accountNumber", "949935093");
        requestParams.put("billCycleCode", "3");
        requestParams.put("msisdns", "3237457813,3237459358,3237624332,3237624938,4152796143,4154393934,4159263679");
        Response response = RestAssured.
                given().header("Content-Type", "application/json")
                .header ("Accepted", "application/json")
                .auth().oauth2(auth)
                .body(requestParams).
                        when()
                .post("https://tms-sell-rateplanchange-v1-tetris1.apps.px-npe01b.cf.t-mobile.com/rateplanchange/getMrcSummaryDetails");

        return response;
    }
    public static void  main (String[] args){
        System.out.println(response().body());
    }
}

