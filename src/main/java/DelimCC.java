import java.util.function.Function;

/**
 * Created by Aggelos Biboudis on 3/12/15.
 *
 * http://okmij.org/ftp/continuations/caml-shift-journal.pdf
 */
public abstract class DelimCC<A> {

    /* Creates a control delimiter of some flavor. */
    <A> Prompt<A> new_prompt() {
        return new Prompt<A>(Ex.rethrowSupplier(()-> { throw new P0("empty box");}), new Object());
    }

    /* Puts the control delimiter on the stack and then evaluates the f. */
    <A> A push_prompt(Prompt<A> p, Ex.Supplier_<A> thunk) throws P0 {
        try{
            return thunk.get();
        } catch (P0 y) {
            if (y.mark.equals(p.mark))
                return p.mbox_receive();
            else throw y;
        }
    }

    /* Removes the prefix of the stack up to the closest stack frame marked with the given p.
     * The removed portion of the stack, with the terminating delimiter p cut off,
     * is packaged as a continuation object of the abstract type subcont
     * and passed to take_subcont's argument f. */
    abstract <A, B> A take_subcont(Prompt<B> p, Function<Subcont<A, B>, Ex.Supplier_<B>> f);

    /* puts the removed stack frames back on the stack, possibly in a different context,
    *  thus reinstating the captured delimited continuation. */
    abstract <A, B> B push_subcon(Subcont<A, B> s, Ex.Supplier_<A> thunk);
}
