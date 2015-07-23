/**
 * Created by Grinyov Vitaliy on 23.07.15.
 *
 * фабрика, создающая внешний сервис
 *
 */
public final class ExternalServiceFactory {

    public ExternalService createExternalService() {
        return new ExternalService();
    }
}
