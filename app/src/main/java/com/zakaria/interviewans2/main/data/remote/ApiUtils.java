package com.zakaria.interviewans2.main.data.remote;

public class ApiUtils {
    private ApiUtils() {}

    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
