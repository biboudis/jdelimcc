import java.util.function.Supplier;

/**
 * Created by Aggelos Biboudis on 3/12/15.
 */
public class Prompt<A> {

    Supplier<A> mbox;

    Object mark;

    public Prompt(Supplier<A> mbox, Object mark) {
        this.mbox = mbox;
        this.mark = mark;
    }

    A mbox_receive() {
        if (mbox == null)
            mbox = Ex.rethrowSupplier(()-> { throw new P0("empty box");});
        return mbox.get();
    }

}
