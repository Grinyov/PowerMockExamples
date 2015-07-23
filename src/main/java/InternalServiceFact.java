/**
 * Created by Grinyov Vitaliy on 23.07.15.
 */
public class InternalServiceFact {
    private final ExternalServiceFactory externalServiceFactory;

    public InternalServiceFact(final ExternalServiceFactory externalServiceFactory) {
        this.externalServiceFactory = externalServiceFactory;
    }

    public void doWork() {
       // externalServiceProvider.createExternalService.doMegaWork();
    }
}
