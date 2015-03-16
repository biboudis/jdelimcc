import java.util.function.Supplier;

/**
 * Created by Aggelos Biboudis on 3/12/15.
 */
public class Ex {

    @FunctionalInterface
    public interface Consumer_<T> {
        void accept(T t) throws Exception;
    }

    @FunctionalInterface
    public interface Function_<T, R> {
        R apply(T t) throws Exception;
    }

    @FunctionalInterface
    public interface Supplier_<T> {
        T get() throws P0;
    }

    public static <T> Supplier<T> rethrowSupplier(Supplier_<T> function) {
        return () -> {
            try {
                return function.get();
            }
            catch (Exception exception) {
                throwAsUnchecked(exception);
                return null;
            }
        };
    }

    @SuppressWarnings ("unchecked")
    private static <E extends Throwable> void throwAsUnchecked(Exception exception) throws E { throw (E)exception; }
}
