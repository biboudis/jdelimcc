/**
 * Created by Aggelos Biboudis on 3/12/15.
 */
class P0 extends Exception {
    Object mark;

    public P0(Object mark) {
        this.mark = mark;
    }

    public P0(String message, Object mark) {
        super(message);
        this.mark = mark;
    }

    public P0(String message, Throwable cause, Object mark) {
        super(message, cause);
        this.mark = mark;
    }

    public P0(Throwable cause, Object mark) {
        super(cause);
        this.mark = mark;
    }

    public P0(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Object mark) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.mark = mark;
    }
}
