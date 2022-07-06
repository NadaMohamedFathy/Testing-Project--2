package Contracts;

public interface IJsonService {
    public <T> T fromJson(String jsonString, Class<T> classOfT);

    public String toJson(Object object);
}
