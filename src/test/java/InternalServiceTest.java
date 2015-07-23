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
@RunWith(PowerMockRunner.class) // заменить стандартный JUnit исполнитель тестов на PowerMock'овский
@PrepareForTest({ ExternalService.class }) // подсказывает исполнителю теста, какие классы необходимо подготовить для теста
public class InternalServiceTest {
    private final ExternalService externalService = PowerMockito.mock(ExternalService.class);
    private final InternalService internalService = new InternalService(externalService);

    @Before
    public void before() {
        Mockito.reset(externalService);
    }

    @Test
    public void doWorkTest() {
        internalService.doWork();

        Mockito.verify(externalService).doMegaWork();
    }
}
