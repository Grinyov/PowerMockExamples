import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Created by Grinyov Vitaliy on 23.07.15.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ ExternalServiceFactory.class, ExternalService.class })
public class InternalServiceTestFact {
    private final ExternalService externalService = PowerMockito.mock(ExternalService.class);
    private final ExternalServiceFactory externalServiceFactory;
    private final InternalServiceFact internalService;

    public InternalServiceTestFact() throws Exception {
        PowerMockito.whenNew(ExternalService.class)
                .withNoArguments()
                .thenReturn(externalService);

        externalServiceFactory = new ExternalServiceFactory();
        internalService = new InternalServiceFact(externalServiceFactory);
    }
/*
Конструкция PowerMockito.whenNew(Class<?> type).withNoArguments().thenReturn(instance)
говорит PowerMock'у заменить в инспектируемых классах создание объектов типа type
 на объект instance. Важно, что бы объект, в котором необходимо заменить создание mock объекта,
 создавался после этой конструкции. Так же следует отметить, что ExternalServiceFactory
 может являться не обычным объектом, а partial mock'ом (spy) и тогда его поведение тоже можно будет проверить.
 */
    @Before
    public void before() {
        Mockito.reset(externalService);
    }

    @Test
    public void doWorkTest() {
        internalService.doWork();

//        Mockito.verify(externalService).doMegaWork();
    }
}
