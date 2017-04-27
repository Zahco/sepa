package model.sepa;

/**
 * Created by kittypwa on 27/04/17.
 */
public class TransactionEntity {

    private RootType rt;
    private int ident;

    public TransactionEntity(int ident, RootType rt){
        this.ident = ident;
        this.rt = rt;
    }

    public RootType getRt() {
        return rt;
    }

    public int getIdent() {
        return ident;
    }

    public void setRt(RootType rt){
        this.rt = rt;
    }

    public void setIdent(int ident) {
        this.ident = ident;
    }
}
