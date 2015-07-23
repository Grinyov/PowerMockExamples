/**
 * Created by Grinyov Vitaliy on 23.07.15.
 *
 * наш сервис
 *
 */
public class InternalService {
    private final ExternalService externalService;

    public InternalService(final ExternalService externalService) {
        this.externalService = externalService;
    }

    public void doWork() {
        externalService.doMegaWork();
    }
}
