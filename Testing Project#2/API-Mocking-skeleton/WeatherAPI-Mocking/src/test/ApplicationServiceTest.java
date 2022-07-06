package test;

import static org.junit.jupiter.api.Assertions.*;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.jupiter.api.Test;

import Contracts.IHTTP;
import Contracts.IJsonService;
import Contracts.IWeatherService;
import Services.ApplicationService;
import Services.GsonService;

import Services.WeatherService;
import ViewModels.Result;
import ViewModels.Weather;

class ApplicationServiceTest {

	ApplicationService app ;
	IJsonService json=new GsonService();
	WeatherService weather;
	Result response= new Result();//Services.Result@8b87145
	Result response1= new Result();
	Weather m=new Weather();
	String result ="{\"coord\":{\"lon\":-0.1257,\"lat\":51.5085},\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03n\"}],\"base\":\"stations\",\"main\":{\"temp\":285.08,\"feels_like\":284.44,\"temp_min\":282.86,\"temp_max\":287.56,\"pressure\":1025,\"humidity\":81},\"visibility\":10000,\"wind\":{\"speed\":1.79,\"deg\":83,\"gust\":4.92},\"clouds\":{\"all\":40},\"dt\":1622406707,\"sys\":{\"type\":2,\"id\":268730,\"country\":\"GB\",\"sunrise\":1622346644,\"sunset\":1622405144},\"timezone\":3600,\"id\":2643743,\"name\":\"London\",\"cod\":200}";
	String result1="{\"cod\":\"404\",\"message\":\"city not found\"}";
	//------------------------------------------------------------------
	//CityName
	@Test
	void getCurrentWeatherWithCityNameTest1(){

		app = new ApplicationService(weather,json);
		String exp="invalid input";
		String resultt=app.getCurrentWeather("");	
		assertEquals(exp, resultt);
	}
	@Test
	void getCurrentWeatherWithCityNameTest2(){

		app = new ApplicationService(weather,json);
		String exp="invalid input";
		String resultt=app.getCurrentWeather(null);	
		assertEquals(exp, resultt);
	}
	@Test
	void getCurrentWeatherWithCityNameTest3(){

		response1.cod="404";
		response1.message="city not found";
		Mockery mockingContext;
		mockingContext = new Mockery();
		IWeatherService mockedObject = mockingContext.mock(IWeatherService.class);
		mockingContext.checking(new Expectations(){
		{
			oneOf(mockedObject).getCurrentWeather("Londo");
			will(returnValue(result1));
		}
		});
		
		app = new ApplicationService(mockedObject,json);
		String exp="invalid response";
		String resultt=app.getCurrentWeather("Londo");	
		assertEquals(exp, resultt);
	}
	@Test
	void getCurrentWeatherWithCityNameTest4(){

		response.cod="200";
		response.main="{\"temp\":285.08,\"feels_like\":284.44,\"temp_min\":282.86,\"temp_max\":287.56,\"pressure\":1025,\"humidity\":81}";
		response.weather="[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03n\"}]";
		m.temp="285.08";
		Mockery mockingContext;
		mockingContext = new Mockery();
		Mockery mockingContext1;
		mockingContext1 = new Mockery();
		IWeatherService mockedObject = mockingContext.mock(IWeatherService.class);
		IJsonService mockedObject1 = mockingContext1.mock(IJsonService.class);
		mockingContext.checking(new Expectations(){
		{
			oneOf(mockedObject).getCurrentWeather("London");
			will(returnValue(result));
		}
		});
		mockingContext1.checking(new Expectations(){
			{
				oneOf(mockedObject1).fromJson(result, Result.class);
				will(returnValue(response));//response
				oneOf(mockedObject1).fromJson(response.main.toString(), Weather.class);//{\"temp\":285.08,\"feels_like\":284.44,\"temp_min\":282.86,\"temp_max\":287.56,\"pressure\":1025,\"humidity\":81}
				will(returnValue(m.temp));//Services.Main@44f75083
			}
			});
		
		app = new ApplicationService(mockedObject,json);
		String exp="Temp : 285.08";
		String resultt=app.getCurrentWeather("London");	
		assertEquals(exp, resultt);
	}
	
	

//---------------------------------------------------------------------------------------
//CityId
@Test
void getCurrentWeatherWithCityIdTest1(){

	app = new ApplicationService(weather,json);
	String exp="invalid input";
	String resultt=app.getCurrentWeather(-2);	
	assertEquals(exp, resultt);
}
@Test
void getCurrentWeatherWithCityIdTest2(){

	app = new ApplicationService(weather,json);
	String exp="invalid input";
	String resultt=app.getCurrentWeather(0);	
	assertEquals(exp, resultt);
}
@Test
void getCurrentWeatherWithCityIdTest3(){

	response1.cod="404";
	response1.message="city not found";
	Mockery mockingContext;
	mockingContext = new Mockery();
	IWeatherService mockedObject = mockingContext.mock(IWeatherService.class);
	mockingContext.checking(new Expectations(){
	{
		oneOf(mockedObject).getCurrentWeather(800);
		will(returnValue(result1));
	}
	});
	
	app = new ApplicationService(mockedObject,json);
	String exp="invalid response";
	String resultt=app.getCurrentWeather(800);	
	assertEquals(exp, resultt);
}
@Test
void getCurrentWeatherWithCityIdTest4(){

	response.cod="200";
	response.main="{\"temp\":285.08,\"feels_like\":284.44,\"temp_min\":282.86,\"temp_max\":287.56,\"pressure\":1025,\"humidity\":81}";
	response.weather="[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03n\"}]";
	m.temp="285.08";
	Mockery mockingContext;
	mockingContext = new Mockery();
	Mockery mockingContext1;
	mockingContext1 = new Mockery();
	IWeatherService mockedObject = mockingContext.mock(IWeatherService.class);
	IJsonService mockedObject1 = mockingContext1.mock(IJsonService.class);
	mockingContext.checking(new Expectations(){
	{
		oneOf(mockedObject).getCurrentWeather(2643743);
		will(returnValue(result));
	}
	});
	mockingContext1.checking(new Expectations(){
		{
			oneOf(mockedObject1).fromJson(result, Result.class);
			will(returnValue(response));//response
			oneOf(mockedObject1).fromJson(response.main.toString(), Weather.class);//{\"temp\":285.08,\"feels_like\":284.44,\"temp_min\":282.86,\"temp_max\":287.56,\"pressure\":1025,\"humidity\":81}
			will(returnValue(m.temp));//Services.Main@44f75083
		}
		});
	
	app = new ApplicationService(mockedObject,json);
	String exp="Temp : 285.08";
	String resultt=app.getCurrentWeather(2643743);	
	assertEquals(exp, resultt);
}

//---------------------------------------------------------------------------------------
//Coord
@Test
void getCurrentWeatherWithCoordTest1(){

	response.cod="200";
	response.main="{\"temp\":285.08,\"feels_like\":284.44,\"temp_min\":282.86,\"temp_max\":287.56,\"pressure\":1025,\"humidity\":81}";
	response.weather="[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03n\"}]";
	m.temp="285.08";
	Mockery mockingContext;
	mockingContext = new Mockery();
	Mockery mockingContext1;
	mockingContext1 = new Mockery();
	IWeatherService mockedObject = mockingContext.mock(IWeatherService.class);
	IJsonService mockedObject1 = mockingContext1.mock(IJsonService.class);
	mockingContext.checking(new Expectations(){
	{
		oneOf(mockedObject).getCurrentWeather(-0.1257,51.5085);
		will(returnValue(result));
	}
	});
	mockingContext1.checking(new Expectations(){
		{
			oneOf(mockedObject1).fromJson(result, Result.class);
			will(returnValue(response));//response
			oneOf(mockedObject1).fromJson(response.main.toString(), Weather.class);//{\"temp\":285.08,\"feels_like\":284.44,\"temp_min\":282.86,\"temp_max\":287.56,\"pressure\":1025,\"humidity\":81}
			will(returnValue(m.temp));//Services.Main@44f75083
		}
		});
	
	app = new ApplicationService(mockedObject,json);
	String exp="Temp : 285.08";
	String resultt=app.getCurrentWeather(-0.1257,51.5085);	
	assertEquals(exp, resultt);
}
@Test
void getCurrentWeatherWithCoordTest2(){

	response1.cod="404";
	response1.message="city not found";
	Mockery mockingContext;
	mockingContext = new Mockery();
	IWeatherService mockedObject = mockingContext.mock(IWeatherService.class);
	mockingContext.checking(new Expectations(){
	{
		oneOf(mockedObject).getCurrentWeather(-1,-1);
		will(returnValue(result1));
	}
	});
	
	app = new ApplicationService(mockedObject,json);
	String exp="invalid response";
	String resultt=app.getCurrentWeather(-1,-1);	
	assertEquals(exp, resultt);
}
@Test
void getCurrentWeatherWithCoordTest3(){

	response.cod="200";
	response.main="{\"temp\":285.08,\"feels_like\":284.44,\"temp_min\":282.86,\"temp_max\":287.56,\"pressure\":1025,\"humidity\":81}";
	response.weather="[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03n\"}]";
	m.temp="285.08";
	Mockery mockingContext;
	mockingContext = new Mockery();
	Mockery mockingContext1;
	mockingContext1 = new Mockery();
	IWeatherService mockedObject = mockingContext.mock(IWeatherService.class);
	IJsonService mockedObject1 = mockingContext1.mock(IJsonService.class);
	mockingContext.checking(new Expectations(){
	{
		oneOf(mockedObject).getCurrentWeather(-0.1257,0);
		will(returnValue(result));
	}
	});
	mockingContext1.checking(new Expectations(){
		{
			oneOf(mockedObject1).fromJson(result, Result.class);
			will(returnValue(response));//response
			oneOf(mockedObject1).fromJson(response.main.toString(), Weather.class);//{\"temp\":285.08,\"feels_like\":284.44,\"temp_min\":282.86,\"temp_max\":287.56,\"pressure\":1025,\"humidity\":81}
			will(returnValue(m.temp));//Services.Main@44f75083
		}
		});
	
	app = new ApplicationService(mockedObject,json);
	String exp="Temp : 285.08";
	String resultt=app.getCurrentWeather(-0.1257,0);	
	assertEquals(exp, resultt);
}
@Test
void getCurrentWeatherWithCoordTest4(){

	app = new ApplicationService(weather,json);
	String exp="invalid input";
	String resultt=app.getCurrentWeather(0,0);	
	assertEquals(exp, resultt);
}
@Test
void getCurrentWeatherWithCoordTest5(){

	response.cod="200";
	response.main="{\"temp\":285.08,\"feels_like\":284.44,\"temp_min\":282.86,\"temp_max\":287.56,\"pressure\":1025,\"humidity\":81}";
	response.weather="[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03n\"}]";
	m.temp="285.08";
	Mockery mockingContext;
	mockingContext = new Mockery();
	Mockery mockingContext1;
	mockingContext1 = new Mockery();
	IWeatherService mockedObject = mockingContext.mock(IWeatherService.class);
	IJsonService mockedObject1 = mockingContext1.mock(IJsonService.class);
	mockingContext.checking(new Expectations(){
	{
		oneOf(mockedObject).getCurrentWeather(0.1257,0);
		will(returnValue(result));
	}
	});
	mockingContext1.checking(new Expectations(){
		{
			oneOf(mockedObject1).fromJson(result, Result.class);
			will(returnValue(response));//response
			oneOf(mockedObject1).fromJson(response.main.toString(), Weather.class);//{\"temp\":285.08,\"feels_like\":284.44,\"temp_min\":282.86,\"temp_max\":287.56,\"pressure\":1025,\"humidity\":81}
			will(returnValue(m.temp));//Services.Main@44f75083
		}
		});
	
	app = new ApplicationService(mockedObject,json);
	String exp="Temp : 285.08";
	String resultt=app.getCurrentWeather(0.1257,0);	
	assertEquals(exp, resultt);
}
//-----------------------------------------------------------------------------------------

}
//-------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------