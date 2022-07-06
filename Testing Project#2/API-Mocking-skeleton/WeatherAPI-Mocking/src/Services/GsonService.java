package Services;

import com.google.gson.Gson;
import com.google.gson.JsonNull;
import com.google.gson.internal.Primitives;

import Contracts.IJsonService;

public class GsonService implements IJsonService {
	private static Gson gson = new Gson();

    @Override
    public <T> T fromJson(String jsonString, Class<T> classOfT) {
    	return gson.fromJson(jsonString, classOfT);

    }

    @Override
    public String toJson(Object object) {
    	return gson.toJson(object);
    }
   


}
