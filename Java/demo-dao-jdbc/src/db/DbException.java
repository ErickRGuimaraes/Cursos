package db;
public class DbException extends RuntimeException{
    private static final long serialVersionUIS = 1l;
    public DbException (String msg){
        super(msg);
    }
}
