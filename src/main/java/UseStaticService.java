/**
 * Created by Grinyov Vitaliy on 23.07.15.
 *
 * наш сервис
 *
 */
public class UseStaticService {

    public String useStatic(final Object obj) {
        StaticService.doStatic();
        //
        return StaticService.doStaticWithParams(obj);
    }
}
