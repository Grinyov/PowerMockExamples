import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by Grinyov Vitaliy on 23.07.15.
 */
// тест нашего сервиса
@RunWith(PowerMockRunner.class)
@PrepareForTest({ StaticService.class })
public class UseStaticServiceTest {
    private static final Object OBJECT_PARAM = new Object();
    private static final String RETURN_STRING = "result";

    private final UseStaticService useStaticService = new UseStaticService();


    public UseStaticServiceTest() {
        PowerMockito.mockStatic(StaticService.class);   // создает mock для всех статик методов в заданном классе
                                                        // но можно создать mock только для необходимых методов

        PowerMockito.when(StaticService.doStaticWithParams(OBJECT_PARAM)).thenReturn(RETURN_STRING); // стандартный способ
        // задать некое поведение созданной заглушке
    }

    @Test
    public void useStaticTest() {
        String result = useStaticService.useStatic(OBJECT_PARAM);

        PowerMockito.verifyStatic(); // вызывается перед проверкой каждого статического вызова метода
        StaticService.doStatic();   // определяет, какой собственно метод должен был быть вызван

        PowerMockito.verifyStatic();
        StaticService.doStaticWithParams(OBJECT_PARAM);

        assertEquals(RETURN_STRING, result);
    }
}