import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class City {
    private String CityName;
    private String StateName;
    private String CountryName;

    public String getCityName() {
        return CityName;
    }

    public String getCountryName() {
        return CountryName;
    }

    public String getStateName() {
        return StateName;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }

    public void setCountryName(String countryName) {
        CountryName = countryName;
    }

    public void setStateName(String stateName) {
        StateName = stateName;
    }

    public City(String cName) {
        this.CityName=cName;
    }

    /** We need to override toString method to directly print out the information of the city, otherwise we will only get the address of the object
     */
    @Override
    public String toString() {
        return "City [ CityName: "+CityName+", StateName: "+ StateName+ ", CountryName: "+CountryName+" ]";
    }

    public static void main(String args[]) {
        /** This part will demonstrate how to use a Json String to create an object, the parameter name of the json object should match the filed name of the object
         * Internally, we use the GSON package provided by Google, it's open source, and can be easily added as dependency from Maven
         */
        String json_str = "{\"CityName\":\"Montreal\", \"StateName\":\"Quebec\", \"CountryName\":\"Canada\"}";
        GsonBuilder builder = new GsonBuilder();

        //This line has nothing to do with the overall functionality I want to show, it only helps generate nice-looking output
        builder.setPrettyPrinting();


        Gson gson = builder.create();
        City Montreal = gson.fromJson(json_str, City.class);
        System.out.println(Montreal.getCityName());
        System.out.println(Montreal.getStateName());
        System.out.println(Montreal.getCountryName());
        System.out.println(Montreal);
        System.out.println();

        /** The order of the parameters of a Json String actually does not matter, the function inside GSON package checks if there's a name-match between the field
         * and the Json parameter
         */
        String json_str2 = "{\"CityName\":\"Mumbai\", \"CountryName\":\"India\", \"StateName\":\"Maharashtra\"}";
        City Mumbai = gson.fromJson(json_str2, City.class);
        System.out.println(Mumbai.getCityName());
        System.out.println(Mumbai.getStateName());
        System.out.println(Mumbai.getCountryName());
        System.out.println();


        /** The GSON also provides a non-static method called toJson() that converts an object to a Json String, and there's a pretty interesting function called
         * setPrettyPrinting() that split the Json String, and switch to a new line for each new parameter
         */
        String js_str1 = gson.toJson(Montreal);
        String js_str2 = gson.toJson(Mumbai);
        System.out.println(js_str1);
        System.out.println(js_str2);

    }
}
