package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import Contracts.IJsonService;
import Services.ApplicationService;
import Services.GsonService;
import ViewModels.Result;
import ViewModels.Weather;
import Services.WeatherService;

public class GsonServiceTest {

	ApplicationService app ;
	IJsonService json=new GsonService();
	WeatherService weather;
	Result response= new Result();//Services.Result@8b87145
	Result response1= new Result();
	Weather m=new Weather();
	String result ="{\"coord\":{\"lon\":-0.1257,\"lat\":51.5085},\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03n\"}],\"base\":\"stations\",\"main\":{\"temp\":285.08,\"feels_like\":284.44,\"temp_min\":282.86,\"temp_max\":287.56,\"pressure\":1025,\"humidity\":81},\"visibility\":10000,\"wind\":{\"speed\":1.79,\"deg\":83,\"gust\":4.92},\"clouds\":{\"all\":40},\"dt\":1622406707,\"sys\":{\"type\":2,\"id\":268730,\"country\":\"GB\",\"sunrise\":1622346644,\"sunset\":1622405144},\"timezone\":3600,\"id\":2643743,\"name\":\"London\",\"cod\":200}";
	String result1="{\"cod\":\"404\",\"message\":\"city not found\"}";
	//fromJson
	@Test
	void fromJsonTest1(){

		response.cod="200.0";
		response.base="stations";
		response.wind="{\"speed\":1.79,\"deg\":83,\"gust\":4.92}";
		response.clouds="{\"all\":40}";
		response.sys="{\"type\":2,\"id\":268730,\"country\":\"GB\",\"sunrise\":1622346644,\"sunset\":1622405144}";
		response.dt="1622406707";
		response.timezone="3600";
		response.name="London";
		response.id="2643743";
		response.visibility="10000";
		response.coord="{\"coord\":{\"lon\":-0.1257,\"lat\":51.5085}";
		response.main="{\"temp\":285.08,\"feels_like\":284.44,\"temp_min\":282.86,\"temp_max\":287.56,\"pressure\":1025,\"humidity\":81}";
		response.weather="[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03n\"}]";
		Result resultt=json.fromJson(result, Result.class);
		assertEquals(response.cod,resultt.cod.toString());
		assertEquals(response.name,resultt.name.toString());
		assertEquals(response.base,resultt.base.toString());
		//assertEquals(response.timezone,resultt.timezone.toString());
	}
	@Test
	void fromJsonTest2(){

		response1.cod="404";
		response1.message="city not found";
		Result resultt=json.fromJson(result1, Result.class);
		assertEquals(response1.cod,resultt.cod.toString());
		assertEquals(response1.message,resultt.message.toString());
	}
	//---------------------------------------------------------------------------------------------
	//toJson
	@Test
	void toJsonTest1(){

		response.cod="200.0";
		response.base="stations";
		response.wind="{\"speed\":1.79,\"deg\":83,\"gust\":4.92}";
		response.clouds="{\"all\":40}";
		response.sys="{\"type\":2,\"id\":268730,\"country\":\"GB\",\"sunrise\":1622346644,\"sunset\":1622405144}";
		response.dt="1622406707";
		response.timezone="3600";
		response.name="London";
		response.id="2643743";
		response.visibility="10000";
		response.coord="{\"coord\":{\"lon\":-0.1257,\"lat\":51.5085}";
		response.main="{\"temp\":285.08,\"feels_like\":284.44,\"temp_min\":282.86,\"temp_max\":287.56,\"pressure\":1025,\"humidity\":81}";
		response.weather="[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03n\"}]";
		String result2="{\"weather\":\"[{\\\"id\\\":802,\\\"main\\\":\\\"Clouds\\\",\\\"description\\\":\\\"scattered clouds\\\",\\\"icon\\\":\\\"03n\\\"}]\",\"cod\":\"200.0\",\"main\":\"{\\\"temp\\\":285.08,\\\"feels_like\\\":284.44,\\\"temp_min\\\":282.86,\\\"temp_max\\\":287.56,\\\"pressure\\\":1025,\\\"humidity\\\":81}\",\"coord\":\"{\\\"coord\\\":{\\\"lon\\\":-0.1257,\\\"lat\\\":51.5085}\",\"base\":\"stations\",\"visibility\":\"10000\",\"wind\":\"{\\\"speed\\\":1.79,\\\"deg\\\":83,\\\"gust\\\":4.92}\",\"clouds\":\"{\\\"all\\\":40}\",\"sys\":\"{\\\"type\\\":2,\\\"id\\\":268730,\\\"country\\\":\\\"GB\\\",\\\"sunrise\\\":1622346644,\\\"sunset\\\":1622405144}\",\"timezone\":\"3600\",\"name\":\"London\",\"id\":\"2643743\",\"dt\":\"1622406707\"}";
		String  resultt=json.toJson(response);
		assertEquals(result2,resultt);
		
	}
	@Test
	void toJsonTest2(){

		response1.cod="404";
		response1.message="city not found";
		String  resultt=json.toJson(response1);
		assertEquals(result1,resultt);
		
	}
}
